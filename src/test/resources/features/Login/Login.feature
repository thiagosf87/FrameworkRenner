#language: pt
@login @fluxo-regressivo
Funcionalidade: Validar fluxo login

  Contexto:
    Dado que estou na pagina de incio do site Renner
    E clico na opção entre ou cadastre-se

  Cenario: Realizar login com email e senha valido
    Quando realizo login com email e senha validos
    Entao login deve ser efetuado com sucesso

  @smoke
  Cenario: Realizar login com cpf e senha valido
    Quando realizo login com cpf e senha validos
    Entao login deve ser efetuado com sucesso

  @smoke
  Esquema do Cenario: Realizar login com sucesso
    Quando informo dados de login "<login>" e senha "<senha>" validos
    Então login deve ser efetuado com sucesso

    Exemplos:
      | login                  | senha         |
      | 75697802994            | 123@automacao |
      | automacao_teste@db.com | 123@automacao |

#### Cenarios de erro ###
  @smoke
  Cenario: Fazer login com usuario invalido - Email
    Quando realizo login com email e senha invalidos
    Entao uma mensagem de alerta e exibida

  Cenario: Fazer login com usuario invalido - CPF
    Quando realizo login com cpf e senha invalidos
    Entao uma mensagem de alerta e exibida

  Esquema do Cenario: Fazer login com usuario invalido - Email
    Quando informo dados de login "<login>" e senha "<senha>" validos
    Entao uma mensagem de alerta e exibida "<validacao>"

    Exemplos:
      | login       | senha         | validacao       |
      |             | 123@automacao | EMAIL INVALIDO  |
      | 75697802994 |               | SENHA INVALIDA  |
      | 75697802994 | 235@automacao | DADOS INVALIDOS |








