package br.com.renner.web.interactions;

import br.com.renner.toolbox.GlobalTools;
import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.pages.CarrinhoPages;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static br.com.renner.web.steps.hooks.WebSetup.driver;

public class CarrinhoInteractions extends CarrinhoPages {

    ToolsPage toolsPage = new ToolsPage();
    GlobalTools globalTools = new GlobalTools();

    public CarrinhoInteractions() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void clicarBtnFinalizarCompra() throws InterruptedException {
        Thread.sleep(3000);
        btnFinalizarCompra.isDisplayed();
        btnFinalizarCompra.click();
    }

    public void validarPaginaCheckout() throws InterruptedException {
        Thread.sleep(6000);
        String url = driver.getCurrentUrl();
        String urlResultUrl = "/checkout";
        System.out.println("URL " + url);

        if (!url.contains(urlResultUrl)) {
            throw new IllegalArgumentException("Não foi possível carregar a página de resultados");
        }
    }

    public void setEndereco(String endereco) throws Exception {
        Thread.sleep(7000);
        endereco = globalTools.removeAccents(endereco).toUpperCase();
        switch (endereco) {
            case "PADRAO":
                radioButtonPadrao.click();
                break;
            case "NOVO":
                break;
            default:
                throw new Exception("O Endereço " + endereco + " escolhida para o produto ainda não está mapeada");
       }
    }


    public void validarExibicaoModal() throws InterruptedException {
        Thread.sleep(2000);
        if (btnOkModal.isDisplayed()) {
            btnOkModal.click();
        }
    }

    public void selecionarTpFrete(String frete) throws InterruptedException {
        Thread.sleep(4000);
        frete = globalTools.removeAccents(frete).toUpperCase();
        switch (frete) {
            case "NORMAL":
                freteNormal.isDisplayed();
                freteNormal.click();
                break;
            case "AGENDADA":
                freteAgendada.isDisplayed();
                freteAgendada.click();
                break;
        }


    }

    public void selecionarBotaoIrParaPagamento() {
        btnIrPagamento.isDisplayed();
        btnIrPagamento.click();
    }
}
