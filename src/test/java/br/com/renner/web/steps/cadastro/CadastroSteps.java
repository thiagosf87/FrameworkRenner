package br.com.renner.web.steps.cadastro;

import br.com.renner.web.interactions.CadastroInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CadastroSteps {

    CadastroInteractions cadastroInteractions = new CadastroInteractions();
    private static String cadastroStepName;


    @Dado("que seleciono o botão quero me cadastrar")
    public void clicoNaOpcaoQueroMeCadastrar() {
        cadastroStepName = "Selecionar o botão quero me cadastrar";
        cadastroInteractions.selecionoQueroMeCadastrar();

    }

    @Dado("realizo o preenchimento dos dados obrigatorios")
    public void preencherCamposDoCadastro() throws Exception {
        cadastroStepName = "Preencher os dados de cadastro";
        cadastroInteractions.informarDadosCadastroValido();
    }

    @Dado("realizo o preenchimento dos dados obrigatorios com cpf ja cadastrado")
    public void preencherDadosCadastroInvalidos() {
        cadastroStepName = "Preencher os dados de cadastro";
        cadastroInteractions.informarEmail("automacao_04@gmail.com");
        cadastroInteractions.informarCpf("84521323600");
        cadastroInteractions.informarNome("Teste");
        cadastroInteractions.informarSobreNome("Automacao");
        cadastroInteractions.informarNascimento("22/02/1987");
        cadastroInteractions.selecionarPreferencia();
        cadastroInteractions.informarSenha("123@automacao");
        cadastroInteractions.informarTelefone("41991674455");
    }

    @Dado("seleciono o termo de acordo")
    public void selecionoOTermoDeAcordo() {
        cadastroStepName = "Selecionar Termo";
        cadastroInteractions.aceitarTermo();

    }

    @Dado("realizo o cadastro")
    public void realizoOCadastro() {
        cadastroStepName = "Realizar Cadastro";
        cadastroInteractions.clicarBotaoCadastrar();

    }

    @Então("sou cadastrado com sucesso")
    public void souCadastradoComSucesso() {
        cadastroStepName = "Cadastro realizado com sucesso";
        cadastroInteractions.validoCadastroComSucesso();

    }

    @Então("recebo mensagem de erro")
    public void validoMensagemErro() {
        cadastroStepName = "Validar mensagem de erro ao cadastrar";
        cadastroInteractions.getMensagemErro();

    }

    @Dado("informo um CPF invalido")
    public void informoUmCPFInvalido() throws Exception {
        cadastroStepName = "Informar CPF inválido para cadastro";
        cadastroInteractions.realizoCadastroCPFInvalido();

    }

    @Então("o sistema retornar mensagem de erro")
    public void oSistemaRetornarMensagemDeErro() {
        cadastroStepName = "Validar mensagem de alerta para cpf inválido";
        cadastroInteractions.validoMensagemAlertaInvalido();
    }

    @Dado("realizar cadastro preenchendo dados solicitados")
    public void realizarCadastroPreenchendoDadosSolicitados() {
        cadastroStepName = "Realizar cadastro menor de idade";
        cadastroInteractions.realizarCadatroMenorIdade();

    }
    @Então("o sistema retornar mensagem de idade inferior")
    public void oSistemaRetornarMensagemDeIdadeInferior() {
        cadastroInteractions.validarMensagemAlertaMenorIdade();

    }
}
