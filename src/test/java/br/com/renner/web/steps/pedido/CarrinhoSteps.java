package br.com.renner.web.steps.pedido;

import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.interactions.CarrinhoInteractions;
import br.com.renner.web.interactions.ResultadosInteractions;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CarrinhoSteps {
    CarrinhoInteractions carrinhoInteractions = new CarrinhoInteractions();

    private static String carrinhoStepName;

    @Quando("avanço para a página de checkout")
    public void avançoParaAPáginaDeCheckout() throws InterruptedException {
        carrinhoStepName = "Avançar para página de checkout";
        carrinhoInteractions.clicarBtnFinalizarCompra();
    }

    @Entao("valido estar na página de pagamento")
    public void validoEstarNaPáginaDePagamento() throws InterruptedException {
        carrinhoStepName = "Validar Que estou na página de Checkout";
        carrinhoInteractions.validarPaginaCheckout();
    }

    @Entao("seleciono os dados necessários de endereço {string}")
    public void selecionoOsDadosNecessáriosDeEndereço(String endereco) throws Exception {
        carrinhoStepName = "Seleciono o Endereço";
        carrinhoInteractions.setEndereco(endereco);
        //carrinhoInteractions.validarExibicaoModal();
    }

    @Entao("seleciono o tipo de frete {string}")
    public void selecionoOTipoDeFrete(String frete) throws InterruptedException {
        carrinhoStepName = "Selecionar tipo de frete " + frete + " para entregar";
        carrinhoInteractions.selecionarTpFrete(frete);

    }

    @Então("avanço para a página de pagamento")
    public void avançoParaAPáginaDePagamento() {
        carrinhoStepName = "Avançar para página de pagamento";
        carrinhoInteractions.selecionarBotaoIrParaPagamento();

    }


}
