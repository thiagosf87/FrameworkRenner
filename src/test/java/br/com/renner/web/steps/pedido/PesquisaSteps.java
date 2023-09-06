package br.com.renner.web.steps.pedido;

import br.com.renner.web.interactions.PesquisaIntereactions;
import io.cucumber.java.pt.Quando;

public class PesquisaSteps {

    PesquisaIntereactions pesquisaIntereactions = new PesquisaIntereactions();
    private static String pesquisaStepName;

    @Quando("informo o código do produto {string}")
    public void informoOCódigoDoProduto(String codigo) throws InterruptedException {
        Thread.sleep(3000);
        pesquisaStepName = "Informar o código do produto: " + codigo + "para pesquisa";
        pesquisaIntereactions.informarCodigoProduto(codigo);

    }

}
