package br.com.renner.web.steps.pedido;

import br.com.renner.toolbox.ConnectionDB;
import br.com.renner.web.interactions.PagamentoInteractions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static br.com.renner.toolbox.ToolsPage.getTimestamp;

public class PagamentoSteps {

    PagamentoInteractions pagamentoInteractions = new PagamentoInteractions();
    private static String pagamentoStepName;

    ConnectionDB connectionDB = new ConnectionDB();

    String numeroPedido;

    @Então("seleciono a forma de pagamento {string}")
    public void selecionoAFormaDePagamento(String formaPagamento) throws Exception {
        pagamentoStepName = "Selecionar a forma pagamento: " + formaPagamento;
        pagamentoInteractions.escolhoMetodoPagamento(formaPagamento);

    }

    @Então("seleciono a bandeira do cartão {string}")
    public void selecionoABandeiraDoCartão(String bandeiraCartao) throws Exception {
        pagamentoStepName = "Selecionar a bandeira do cartão";
        pagamentoInteractions.informarDadosCartao(bandeiraCartao);
        pagamentoInteractions.informarNomeCartao();
        pagamentoInteractions.informarDataValidade();
        pagamentoInteractions.informarCVV();
        pagamentoInteractions.selecionarQuantidadeParcelamento();
        pagamentoInteractions.escolherParcerlas("1");
    }

    @Então("selecionar o botão finalizar pedido")
    public void selecionarOBotãoFinalizarPedido() {
        pagamentoStepName = "Selecionar Botão Finalizar Pedido";
        pagamentoInteractions.btnFinalizarPedido();
    }

    @Então("o pedido deve ser gerado")
    public void oPedidoDeveSerGerado() throws InterruptedException {
        pagamentoStepName = "Validar Pedido Gerado";
        pagamentoInteractions.recuperarNumeroPedido();
    }

    @Dado("gravo os dados na base {string} {string} {string} {string} {string} {string}")
    public void gravoOsDadosNaBase(String sku, String qtdPedido, String item, String tpFrete, String endereco, String formaPagamento) throws Exception {
        String cod_pedido = pagamentoInteractions.recuperarNumeroPedido();
        String quant_pedido = qtdPedido;
        String data_pedido = getTimestamp();
        String tp_item = item;
        String sku_pedido = sku;
        String forma_pagamento = formaPagamento.toUpperCase();
        String tp_frete = tpFrete;
        String local_cd = endereco;
        String valor_pedido = pagamentoInteractions.recuperarValorTotal().replace("R$", "").replace(",", ".");
        String status_pedido = "gerado".toUpperCase();
        int integracao_hj = 0;
        String id_onda = null;
        int status_onda = 0;

        System.out.println("Dados Inseridos No Banco");
        System.out.println("Código do Pedido Gerado: " + cod_pedido);
        System.out.println("Quantidade do Produto: " + quant_pedido);
        System.out.println("Data do Pedido Gerado: " + data_pedido);
        System.out.println("Tipo de Item do Pedido: " + tp_item);
        System.out.println("Codigo do Produto: " + sku_pedido);
        System.out.println("Forma de Pagamento Escolhida: " + forma_pagamento);
        System.out.println("Tipo de Frete: " + tp_frete);
        System.out.println("Local do CD: " + local_cd);
        System.out.println("Valor do Pedido: " + valor_pedido);
        System.out.println("Status do Pedido: " + status_pedido);
        System.out.println("Pedido Integrado com HJ: " + integracao_hj);
        System.out.println("Id da Onda: " + id_onda);
        System.out.println("Status da Onda: " + status_onda);

        connectionDB.insertDB(cod_pedido, data_pedido, quant_pedido, tp_item, sku_pedido, forma_pagamento, tp_frete, local_cd, valor_pedido, status_pedido, integracao_hj, id_onda, status_onda);
    }

    @Dado("que acesso a tela para aprovação do pedido")
    public void queAcessoATelaParaAprovaçãoDoPedido() throws InterruptedException {
        pagamentoStepName = "Acessar a Url para aprovação do pedido";
        numeroPedido = pagamentoInteractions.recuperarNumeroPedido();
        pagamentoInteractions.acessarUrlAprovacao();
        pagamentoInteractions.selecionarLinkOrder();

        System.out.println("Número do Pedido para ser aprovado: " + numeroPedido);
    }

    @Quando("informo o número pedido")
    public void informoONúmeroPedido() {
        pagamentoStepName = "Informar Numero do Pedido: " + numeroPedido;
        pagamentoInteractions.informarPedido(numeroPedido);
    }

    @Quando("envio para aprovar")
    public void envioParaAprovar() throws InterruptedException {
        pagamentoStepName = "Selecionar o botão Chance Value";
        pagamentoInteractions.selecionarBtnChanceValue();
        pagamentoInteractions.clickMenuService();
        pagamentoInteractions.clickMenuApprover();
        pagamentoInteractions.clickInvokeMethod();
    }

    @Então("o pedido deve ser aprovado")
    public void oPedidoDeveSerAprovado() {
        pagamentoStepName = "Confirmar aprovação da Order pelo botão Invoke Method";
        pagamentoInteractions.updatePedidoBd(numeroPedido);
        System.out.println("Número do Pedido para aprovação " + numeroPedido);

    }
}
