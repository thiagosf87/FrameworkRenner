package br.com.renner.web.steps.login;

import br.com.renner.toolbox.GlobalTools;
import br.com.renner.web.interactions.LoginInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginSteps {

    LoginInteractions loginInteractions = new LoginInteractions();
    private static String loginStepName;

    public LoginSteps() throws IOException, ParseException {

    }
    String msgm;

    /***
     * passos do Dado
     */

    @Dado("que estou na pagina de incio do site Renner")
    public void queAcessoSiteRenner() {
        loginStepName = "Estar na pagina inicio Site Renner";
    }

    @Dado("clico na opção entre ou cadastre-se")
    public void clicoNaOpçãoEntreOuCadastreSe() throws InterruptedException {
        loginStepName = "Acessar o botão Entre ou Cadastre-se";
        loginInteractions.selecionarEntreOuCadastrese();
    }

    /***
     * Passos do Quando
     */

    @Quando("realizo login com email e senha validos")
    public void realizoLoginComEmailESenhaValidos() {
        loginStepName = "Informar Email e Senha Valido";
        loginInteractions.preencherDadosDeLoginValidosEmail();
    }

    @Quando("realizo login com cpf e senha validos")
    public void realizoLoginComCpfESenhaValidos() {
        loginStepName = "Informar Cpf e Senha Valido";
        loginInteractions.preencheDadosDeLoginValidoCPF();

    }

    @Quando("informo dados de login {string} e senha {string} validos")
    public void realizarLoginDadosValidos(String login, String senha) {
        loginInteractions.preencherDadosLogin(login);
        loginInteractions.preencherDadosSenha(senha);
        loginInteractions.botaoEntrar();
    }

    @Quando("realizo login com email e senha invalidos")
    public void realizoLoginComEmailESenhaInvalidos() {
        loginStepName = "Informar Email e Senha Inválidos";
        loginInteractions.preencherDadosDeLoginInvalido();

    }

    @Quando("realizo login com cpf e senha invalidos")
    public void realizoLoginComCpfESenhaInvalidos() {
        loginStepName = "Informar CPF  e Senha Invalidos";
        loginInteractions.preencherDadosDeLoginInvalido();
    }

    @E("uma mensagem de alerta e exibida")
    public void validarMensagemErro() {
        loginStepName = "Validar mensagem de erro";
        loginInteractions.validarMensagemErroLogin();
    }

    /***
     * Passos de validação
     */

    @Entao("login deve ser efetuado com sucesso")
    public void validarLoginComSucesso() {
        loginStepName = "Login efetuado com sucesso";
        loginInteractions.validarUsuario();

    }

    /***** /
     * Valdiar esse metodo não esta rodando
     * @throws InterruptedException
     */
    @Entao("o usuario nao deve estar logado")
    public void oUsuarioNaoDeveEstarLogado() throws InterruptedException {
        loginStepName = "Usuario não deve logar";
        loginInteractions.usuarioNaoLogado();

    }

    @Entao("uma mensagem de alerta e exibida {string}")
    public void umaMensagemDeAlertaExibida(String msmValidacao) {
        loginStepName = "Validar mensagem de erro exibida";
        msmValidacao = GlobalTools.removeAccents(msmValidacao).toUpperCase();

        if (msmValidacao.equals("EMAIl INVALIDO")){
            msgm = "este campo é obrigatório";
            loginInteractions.getMensagemErroEmail(msgm);

        } else if (msmValidacao.equals("SENHA INVALIDA")) {
            msgm = "este campo é obrigatório";
            loginInteractions.getMensagemSenha(msgm);

        } else if (msmValidacao.equals("DADOS INVALIDOS")) {
            msgm = "Esta combinação de usuário e senha é inválida.";
            loginInteractions.getMensagemModalErro(msgm);
        }

    }

}
