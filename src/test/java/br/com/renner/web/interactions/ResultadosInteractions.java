package br.com.renner.web.interactions;

import br.com.renner.toolbox.GlobalTools;
import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.pages.ResultPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static br.com.renner.web.steps.hooks.WebSetup.driver;

public class ResultadosInteractions extends ResultPages {

    ToolsPage toolsPage = new ToolsPage();

    private static double totalOrder;

    public ResultadosInteractions() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void verificarResultadoLink(String codigo) throws InterruptedException {
        Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        String urlResultProduto = "b?Ntt=" + codigo;

        System.out.println("URL: " + url);

        if (!url.contains(urlResultProduto)) {
            throw new InterruptedException("Não foi possivel carregar a página de Resultados");
        }

    }

    public void selecionarProdutoItem() throws InterruptedException {
        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(2000);

        if (ProductTitleDiv.isDisplayed()) {
            ProductTitleDiv.click();
        }

    }

    public void selecionarVarianteProduto(String varianteItem) throws Exception {
        Thread.sleep(1000);
        varianteItem = GlobalTools.removeAccents(varianteItem).toUpperCase();
        switch (varianteItem) {
            case "AZUL":
                selecionarCOrAzul.click();
                break;
            case "BRANCA":
                selecionarCOrBranca.click();
                break;
            case "NA":
                System.out.println("Esse pedido não possue variante para selecionar, avançar para adicionar ao carrinho");
                break;
            default:
                throw new Exception("A variante " + varianteItem + " escolhida para o produto ainda não esta mapeada");
        }


    }

    public void selecionarTamanho(String tamanho) throws Exception {
        Thread.sleep(1000);
        tamanho = GlobalTools.removeAccents(tamanho).toUpperCase();
        switch (tamanho) {
            case "G":
                selecionarTamanhoG.isEnabled();
                selecionarTamanhoG.click();
                break;
            case "M":
                selecionarTamanhoM.isEnabled();
                selecionarTamanhoM.click();
                break;
            case "NA":
                System.out.println("Esse pedido não possue variante de tamanho para selecionar, avançar para adicionar ao carrinho");
                break;
            default:
                throw new Exception("O tamanho: " + tamanho + " escolhida para o produto ainda não esta mapeada");
        }
    }

    public void setValueOrder(double amountCheckout) {
        this.totalOrder = amountCheckout;
    }

    public void valorTotalOrcamento() {
        String getValorOrcamento = getValuePrice.getText().replace(".", "").replace("R$", "");
        System.out.println("valor " + getValorOrcamento);
        double valorOrcamento = Double.parseDouble(getValorOrcamento.replace(",", "."));
        setValueOrder(valorOrcamento);
        System.out.println("O valor do Orçamento " + valorOrcamento);

    }

    public void enviarParaCarrinho() {
        btnEnviarCarrinho.isEnabled();
        btnEnviarCarrinho.click();
    }

    public void verificarPageCarrinho() throws InterruptedException {
        Thread.sleep(6000);
        String url = driver.getCurrentUrl();
        String urlResultUrl = "/sacola";
        System.out.println("URL " + url);

        if (!url.contains(urlResultUrl)) {
            throw new IllegalArgumentException("Não foi possível carregar a página de resultados");
        }
    }

    public void selecionarQuantidade(String quantidade) throws InterruptedException {
        Thread.sleep(15000);

//        comboQuantidade.click();
//        comboQuantidade.clear();
//
//        comboQuantidade.sendKeys(quantidade);
//        comboQuantidade.sendKeys(Keys.ENTER);
//
//        if (btnOkModalAlert.isDisplayed()) {
//            btnOkModalAlert.click();
//        }
    }
}
