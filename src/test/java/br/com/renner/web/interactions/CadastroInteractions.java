package br.com.renner.web.interactions;

import br.com.renner.toolbox.GlobalTools;
import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.pages.CadastroPages;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static br.com.renner.web.steps.hooks.WebSetup.driver;

public class CadastroInteractions extends CadastroPages {

    ToolsPage toolsPage = new ToolsPage();
    public static Faker faker = new Faker();

    public CadastroInteractions() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void selecionoQueroMeCadastrar() {
        btnQueroMecadastrar.click();
        TxtCadastroTitulo.isDisplayed();
    }

    public void informarDadosCadastroValido() throws Exception {

        TxtCadastroTitulo.isDisplayed();
        TxtEmailCadastro.click();
        TxtEmailCadastro.sendKeys(faker.internet().emailAddress());
        TxtCPFCadastro.sendKeys(GlobalTools.cpfGenerator());
        TxtNomeCadastro.sendKeys(faker.name().firstName());
        TxtSorbeNomeCadastro.sendKeys(faker.name().lastName());
        TxtDataNascimentoCadastro.sendKeys(GlobalTools.birthdayGenerator(20, 30));
        RadioMasculino.click();
        TxtSenhaCadastro.click();
        TxtSenhaCadastro.sendKeys("123@automacao");
        TxtTelefoneCadastro.click();
        TxtTelefoneCadastro.sendKeys("41991674588");
    }

    public void informarEmail(String email) {
        TxtEmailCadastro.click();
        TxtEmailCadastro.clear();
        TxtEmailCadastro.sendKeys(email);

    }

    public void informarCpf(String cpf) {
        TxtCPFCadastro.sendKeys(cpf);
    }

    public void informarNome(String nome) {
        TxtNomeCadastro.sendKeys(nome);
    }

    public void informarSobreNome(String sobreNome) {
        TxtSorbeNomeCadastro.sendKeys(sobreNome);
    }

    public void informarNascimento(String nascimento) {
        TxtDataNascimentoCadastro.sendKeys(nascimento);
    }

    public void selecionarPreferencia() {
        RadioMasculino.click();

    }

    public void informarSenha(String senha) {
        TxtSenhaCadastro.sendKeys(senha);
    }

    public void informarTelefone(String telefone) {
        TxtTelefoneCadastro.sendKeys(telefone);
    }

    public void aceitarTermo() {
        CbxTermoAceiteCadastro.click();
    }

    public void clicarBotaoCadastrar() {
        BtnCadastrar.click();
    }


    public void realizoCadastroCPFInvalido() throws Exception {

        TxtCadastroTitulo.isDisplayed();
        TxtEmailCadastro.click();
        TxtEmailCadastro.sendKeys(faker.internet().emailAddress());
        TxtCPFCadastro.sendKeys("06386208988");
        TxtNomeCadastro.sendKeys(faker.name().firstName());
        TxtSorbeNomeCadastro.sendKeys(faker.name().lastName());
        TxtDataNascimentoCadastro.sendKeys(GlobalTools.birthdayGenerator(20, 30));
        RadioMasculino.click();
        TxtSenhaCadastro.click();
        TxtSenhaCadastro.sendKeys("123@automacao");
        TxtTelefoneCadastro.click();
        TxtTelefoneCadastro.sendKeys("41991674588");

    }

    public void realizarCadatroMenorIdade() {
        TxtCadastroTitulo.isDisplayed();
        TxtEmailCadastro.click();
        TxtEmailCadastro.sendKeys(faker.internet().emailAddress());
        TxtCPFCadastro.sendKeys(GlobalTools.cpfGenerator());
        TxtNomeCadastro.sendKeys(faker.name().firstName());
        TxtSorbeNomeCadastro.sendKeys(faker.name().lastName());
        TxtDataNascimentoCadastro.sendKeys("01/01/2010");
        RadioMasculino.click();
        TxtSenhaCadastro.click();
        TxtSenhaCadastro.sendKeys("123@automacao");
        TxtTelefoneCadastro.click();
        TxtTelefoneCadastro.sendKeys("41991674588");
    }

    public void validoCadastroComSucesso() {
        String mensagem = "registerLogin.register.success";
        Assert.assertEquals(mensagem, GetMensagemSucesso.getText());
        BtnOkModal.click();
    }

    public void getMensagemErro() {
        String mensagem = "CPF já registrado";
        Assert.assertEquals(mensagem, GetMensagemSucesso.getText());
        BtnOkModal.click();
    }

    public void validoMensagemAlertaInvalido() {
        TxtMensagemCPFInvalido.isDisplayed();
        String msg = "CPF inválido!";
        Assert.assertEquals(msg, TxtMensagemCPFInvalido.getText());
    }

    public void validarMensagemAlertaMenorIdade() {
        TxtMensagemMenorIdade.isDisplayed();
        String msg = "Desculpe. Atualmente, o cadastro em nossa Loja Virtual/APP está disponível apenas para maiores de 16 anos.";
        Assert.assertEquals(msg, TxtMensagemMenorIdade.getText());
    }
}
