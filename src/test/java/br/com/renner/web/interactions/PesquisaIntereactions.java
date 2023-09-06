package br.com.renner.web.interactions;

import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.pages.PesquisaPages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static br.com.renner.web.steps.hooks.WebSetup.driver;

public class PesquisaIntereactions extends PesquisaPages {
    ToolsPage toolsPage = new ToolsPage();

    public PesquisaIntereactions() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void informarCodigoProduto(String codigo) {
        InputCodigo.click();
        InputCodigo.sendKeys(codigo);
        InputCodigo.sendKeys(Keys.ENTER);
    }
}
