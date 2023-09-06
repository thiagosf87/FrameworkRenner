package br.com.renner.web.interactions;

import br.com.renner.toolbox.ConnectionDB;
import br.com.renner.toolbox.GlobalTools;
import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.pages.PagamentoPages;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static br.com.renner.toolbox.ToolsPage.esperarElement;
import static br.com.renner.web.steps.hooks.WebSetup.driver;

public class PagamentoInteractions extends PagamentoPages {

    GlobalTools globalTools = new GlobalTools();
    ConnectionDB connectionDB = new ConnectionDB();

    public PagamentoInteractions() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void escolhoMetodoPagamento(String formaPagamento) throws Exception {
        formaPagamento = globalTools.removeAccents(formaPagamento).toUpperCase();
        Thread.sleep(6000);

        switch (formaPagamento) {
            case "CREDITO":
                tipoPgCredito.isEnabled();
                tipoPgCredito.click();
                break;
            case "DEBITO":
                tipoPgDebito.isEnabled();
                tipoPgDebito.click();
                break;
            default:
                throw new Exception("O método de pagamento " + formaPagamento + "escolhido para o produto não está disponivel");
        }
    }

    public void informarDadosCartao(String bandeiraCartao) throws Exception {
        Thread.sleep(5000);
        bandeiraCartao = globalTools.removeAccents(bandeiraCartao).toUpperCase();

        switch (bandeiraCartao) {
            case "MASTER":
                inputCartao.isEnabled();
                inputCartao.sendKeys("5301 3192 9941 5744");
                break;
            case "VISA":
                inputCartao.isEnabled();
                inputCartao.sendKeys("4539 1746 5302 3338");
                break;
            default:
                throw new Exception("A bandeira do cartão " + bandeiraCartao + "escolhido para o produto não está disponivel");

        }
    }

    public void informarNomeCartao() {
        inputNomeCartao.click();
        inputNomeCartao.sendKeys(globalTools.geradorNome() + "  " + GlobalTools.geradorSobrNome());
    }

    public void informarDataValidade() {
        inputVencimentoCartao.click();
        inputVencimentoCartao.sendKeys("02/2024");
    }

    public void informarCVV() {
        inputCVVCartao.click();
        inputCVVCartao.sendKeys("390");
        inputCVVCartao.sendKeys(Keys.TAB);
    }

    public void selecionarQuantidadeParcelamento() {
        selectComboParcelamento.click();
    }

    public void escolherParcerlas(String quantidade) {

        if (quantidade.equals("1") && option1.isDisplayed() && option1.isEnabled()) {
            option1.click();

        } else if (quantidade.equals("2") && option2.isDisplayed() && option2.isEnabled()) {
            option2.click();

        }
    }

    public void btnFinalizarPedido() {
        btnFinalizar.isDisplayed();
        btnFinalizar.click();
    }

    public String recuperarNumeroPedido() throws InterruptedException {
        if (bannerPedido.isDisplayed()) {
            bannerPedido.click();
        }

        String numeroPedido = numeroPedidoTxt.getText();
        String msgm = txtMsgmPedido.getText();

        Assert.assertEquals("AGRADECEMOS POR COMPRAR NA RENNER", msgm);
        System.out.println("O Número do Pedido Gerado: " + numeroPedido);

        return numeroPedido;
    }

    public String recuperarValorTotal() throws Exception {
        String valorPedidoGerado = getValorPedido.getText().replaceAll("R$", "").replace(",", ".");

        return valorPedidoGerado;
    }


    public void acessarUrlAprovacao() throws InterruptedException {
        driver.get("http://admin:Renner@2020@10.206.208.46:18081/dyn/admin/nucleus/lrsa/fake/mock/ReprocessClearSale/");
        Thread.sleep(5000);
    }

    public void selecionarLinkOrder() throws InterruptedException {
        Thread.sleep(7000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        linkOrder.isDisplayed();
        linkOrder.click();
    }


    public void informarPedido(String numeroPedido) {
        inputPedido.click();
        inputPedido.clear();
        inputPedido.sendKeys(numeroPedido);

    }

    public void selecionarBtnChanceValue() {
        btnChanceValue.isDisplayed();
        btnChanceValue.click();
    }

    public void clickMenuService() throws InterruptedException {
        Thread.sleep(2000);
        linkServices.click();
    }

    public void clickMenuApprover() {
        setLinkOrderApprover.click();
    }

    public void clickInvokeMethod() {
        btnInvokeMethod.isDisplayed();
        btnInvokeMethod.click();
    }

    public void updatePedidoBd(String numeroPedido) {
        String cod_pedido = numeroPedido;
        String status_pedido = "Aprovado".toUpperCase();

        System.out.println("Dados Atualizados No Banco");
        System.out.println("Código do Pedido Atualizado: " + cod_pedido);
        System.out.println("Status do Pedido: " + status_pedido);

        connectionDB.updateDBAprovacao(cod_pedido, status_pedido);

    }


}
