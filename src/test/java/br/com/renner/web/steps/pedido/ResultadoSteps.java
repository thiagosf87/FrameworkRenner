package br.com.renner.web.steps.pedido;

import br.com.renner.toolbox.ToolsPage;
import br.com.renner.web.interactions.ResultadosInteractions;
import io.cucumber.java.pt.Quando;

public class ResultadoSteps {

    ResultadosInteractions resultadosIntereactions = new ResultadosInteractions();

    ToolsPage toolsPage = new ToolsPage();
    private static String resultStepName;


    @Quando("valido se houve retorno de resutlados para a busca {string}")
    public void validarResultPesquisa(String codigo) throws InterruptedException {
        resultStepName = "Validar se houve retorno de resutlados para a busca";
        resultadosIntereactions.verificarResultadoLink(codigo);
    }

    @Quando("escolho o produto exibido")
    public void escolhoOProdutoExibido() throws InterruptedException {
        resultStepName = "E seleciono o produto desejado";
        resultadosIntereactions.selecionarProdutoItem();

    }

    @Quando("seleciono a variante {string} do produto")
    public void selecionoACorDoProduto(String varianteItem) throws Exception {
        resultStepName = "E seleciono a cor (" + varianteItem + ") para o produto";
        resultadosIntereactions.selecionarVarianteProduto(varianteItem);
    }

    @Quando("seleciono o tamanho {string}")
    public void selecionoOTamanho(String tamanho) throws Exception {
        resultStepName = "E seleciono o tamanho (" + tamanho + ") para o produto";
        resultadosIntereactions.selecionarTamanho(tamanho);
    }

    @Quando("envio o produto para o carrinho")
    public void envioOProdutoParaOCarrinho() {
        resultStepName = "Enviar o produto seleciona para o carrinho";
        resultStepName = "Recuperar o valor total sem taxas";

        resultadosIntereactions.valorTotalOrcamento();
        resultadosIntereactions.enviarParaCarrinho();

    }

    @Quando("seleciono a quantidade do produto {string}")
    public void selecionoAQuantidadeDoProduto(String quantidade) throws InterruptedException {
        resultStepName = "E seleciono a quantidade (" + quantidade + ") para o produto";
        resultadosIntereactions.verificarPageCarrinho();
        resultadosIntereactions.selecionarQuantidade(quantidade);
    }

}
