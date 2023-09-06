package br.com.renner.toolbox;

import org.json.JSONArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static br.com.renner.toolbox.SetupTestRunProperties.*;

public class ConnectionDB {

    public JSONArray selectDB(String codPedido, String dataPedido, String qtdPedido, String tpItem, String skuPedido, String formaPagamento, String tpFrete, String localCd, String valorPedido, String statusPedido, int integracaoHJ, String idOnda, String statusOnda) {
        JSONArray jsonArray = null;

        try {
            Class.forName(getConfigJdbcDriver());
            Connection tdm = DriverManager.getConnection(getConfigDbUrl(), getConfigUser(), getConfigPassword());

            Statement statement = tdm.createStatement();

            jsonArray = new JSONArray();

            jsonArray = QueryFormatter.parseResultsetToJsonArray
                    (tdm.prepareStatement("select * from tdmdb.tbl_pedidos_renner where tp_item = '" + tpItem + "' and status_pedido = 'Aprovado' and id_onda = 'null' order by rand() limit 1;").executeQuery());

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("json " + jsonArray);
        return jsonArray;

    }

    public JSONArray insertDB(String codPedido, String dataPedido, String qtdPedido, String tpItem, String skuPedido, String formaPagamento, String tpFrete, String localCd, String valorPedido, String statusPedido, int integracaoHJ, String idOnda, int statusOnda) {

        String cod_pedido = codPedido;
        String data_pedido = dataPedido;
        String quant_pedido = qtdPedido;
        String tp_item = tpItem;
        String sku_pedido = skuPedido;
        String forma_pagamento = formaPagamento;
        String tp_frete = tpFrete;
        String local_cd = localCd;
        String valor_pedido = valorPedido;
        String status_pedido = statusPedido;
        int integracao_hj = integracaoHJ;
        String id_onda = idOnda;
        int status_onda = statusOnda;

        JSONArray jsonArray = null;

        try {
            Class.forName(getConfigJdbcDriver());
            Connection tdm = DriverManager.getConnection(getConfigDbUrl(), getConfigUser(), getConfigPassword());

            Statement statement = tdm.createStatement();

            jsonArray = new JSONArray();

            statement.executeUpdate("insert into tdmdb.tbl_pedidos_renner(cod_pedido, data_pedido,  quant_pedido, tp_item, sku_pedido, forma_pagamento, tp_frete, local_cd, valor_pedido, status_pedido, integracao_hj, id_onda, status_onda)\n" +
                    "\tvalues ('" + cod_pedido + "','" + data_pedido + "', '" + quant_pedido + "', '" + tp_item + "','" + sku_pedido + "','" + forma_pagamento + "','" + tp_frete + "','" + local_cd + "','" + valor_pedido + "','" + status_pedido + "','" + integracao_hj + "','" + id_onda + "','" + status_onda + "');");
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public JSONArray updateDBAprovacao(String codPedido, String statusPedido) {

        String cod_pedido = codPedido;
        String status_pedido = statusPedido;
        JSONArray jsonArray = null;

        try {
            Class.forName(getConfigJdbcDriver());
            Connection tdm = DriverManager.getConnection(getConfigDbUrl(), getConfigUser(), getConfigPassword());

            Statement statement = tdm.createStatement();

            jsonArray = new JSONArray();

            statement.executeUpdate("update tdmdb.tbl_pedidos_renner set status_pedido = '" + status_pedido + "' where cod_pedido = '" + cod_pedido + "'");
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }


}
