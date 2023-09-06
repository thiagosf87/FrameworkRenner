package br.com.renner.web.interactions;

import br.com.renner.toolbox.GlobalTools;
import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.pages.LoginPages;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static br.com.renner.web.steps.hooks.WebSetup.driver;

public class LoginInteractions extends LoginPages {

    ToolsPage toolsPage = new ToolsPage();
    GlobalTools globalTools = new GlobalTools();

    public LoginInteractions() {

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void selecionarEntreOuCadastrese() throws InterruptedException {
        Thread.sleep(10000);
        BtnEntre.click();
    }

    public void preencherDadosDeLoginValidosEmail() {
        TituloIdentificacao.isDisplayed();
        InputCpfEmail.click();
        InputCpfEmail.clear();
        InputCpfEmail.sendKeys(ToolsPage.getUserEmail());
        InputSenha.click();
        InputSenha.clear();
        InputSenha.sendKeys(ToolsPage.getPassword());
        BtnLogin.click();
    }

    public void preencheDadosDeLoginValidoCPF() {
        TituloIdentificacao.isDisplayed();
        InputCpfEmail.click();
        InputCpfEmail.clear();
        InputCpfEmail.sendKeys(ToolsPage.getCPF());
        InputSenha.click();
        InputSenha.clear();
        InputSenha.sendKeys(ToolsPage.getPassword());
        BtnLogin.click();
    }

    public void preencherDadosLogin(String login) {
        TituloIdentificacao.isDisplayed();
        InputCpfEmail.click();
        InputCpfEmail.clear();
        InputCpfEmail.sendKeys(login);
    }

    public void preencherDadosSenha(String senha) {
        InputSenha.click();
        InputSenha.clear();
        InputSenha.sendKeys(senha);

    }

    public void preencherDadosDeLoginInvalido() {
        TituloIdentificacao.isDisplayed();
        InputCpfEmail.click();
        InputCpfEmail.clear();
        InputCpfEmail.sendKeys("automacao_teste@gmail.com");
        InputSenha.click();
        InputSenha.clear();
        InputSenha.sendKeys("123@@teste");
        BtnLogin.click();
    }

    public void botaoEntrar() {
        BtnLogin.click();
    }

    public void validarUsuario() {
        String usuario = "Automação";
        try {
            Assert.assertEquals(usuario, UserLogado.getText());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void usuarioNaoLogado() throws InterruptedException {
        Assert.assertFalse(UserLogado.isDisplayed());
    }

    public void validarMensagemErroLogin() {
        String msgValidacao = "Esta combinação de usuário e senha é inválida.";
        Assert.assertEquals(msgValidacao, getMensagemErro.getText());
    }

    public void getMensagemErroEmail(String msgm) {

        try {
            Assert.assertEquals(msgm, getMensagemEmail.getText());
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public void getMensagemSenha(String msgm) {
        try {
            Assert.assertEquals(msgm, getMsgmCampoSenha.getText());
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public void getMensagemModalErro(String msgm) {
        try {
            Assert.assertEquals(msgm, getMensagemErro.getText());
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
