#language: pt
@pedido @fluxo-regressivo
Funcionalidade: Validar fluxo para geração de pedido no site renner

  Contexto:
    Dado que estou na pagina de incio do site Renner
    E clico na opção entre ou cadastre-se
    Quando realizo login com email e senha validos

  Esquema do Cenario: Validar o fluxo regressivo para a loja renner, até a geração do pedido
    Quando informo o código do produto "<sku_produto>"
    E valido se houve retorno de resutlados para a busca "<sku_produto>"
    E escolho o produto exibido
    E seleciono a variante "<variante>" do produto
    E seleciono o tamanho "<tamanho>"
    E envio o produto para o carrinho
    E seleciono a quantidade do produto "<quantidade>"
    E avanço para a página de checkout
    Entao valido estar na página de pagamento
    E seleciono os dados necessários de endereço "<endereco>"
    E seleciono o tipo de frete "<tipo_frete>"
    Então avanço para a página de pagamento
    E seleciono a forma de pagamento "<forma_pagamento>"
    E seleciono a bandeira do cartão "<bandeira_cartao>"
    E selecionar o botão finalizar pedido
    Então o pedido deve ser gerado
    E gravo os dados na base "<sku_produto>" "<quantidade>" "<item>" "<tipo_frete>" "<endereco>" "<forma_pagamento>"
    Dado que acesso a tela para aprovação do pedido
    Quando informo o número pedido
    E envio para aprovar
    Então o pedido deve ser aprovado

    Exemplos:
      | sku_produto | item | variante | tamanho | quantidade | cupom | endereco | tipo_frete | forma_pagamento | bandeira_cartao |
      | 607324790   | EN   | NA       | NA      | 1          | nao   | padrao   | normal     | credito         | master          |
      | 543554229   | OSR  | NA       | U       | 2          | nao   | padrao   | normal     | credito         | visa            |
      | 543290083   | OSR  | NA       | NA      | 1          | nao   | padrao   | normal     | credito         | visa            |
      | 607324888   | CX   | NA       | NA      | 1          | nao   | padrao   | normal     | credito         | master          |
