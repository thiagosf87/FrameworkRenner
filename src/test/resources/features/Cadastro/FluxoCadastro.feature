#language: pt
@cadastro @fluxo-regressivo
Funcionalidade: Validar fluxo regressivo para cadastro de usuário

  Contexto:
    Dado que estou na pagina de incio do site Renner
    E clico na opção entre ou cadastre-se

  @smoke
  Cenario: Cadastro de novo usuário com sucesso
    Dado que seleciono o botão quero me cadastrar
    E realizo o preenchimento dos dados obrigatorios
    E seleciono o termo de acordo
    E realizo o cadastro
    Então sou cadastrado com sucesso

  @smoke
  Cenario: Validar Cadastro CPF já existente
    Dado que seleciono o botão quero me cadastrar
    E realizo o preenchimento dos dados obrigatorios com cpf ja cadastrado
    E seleciono o termo de acordo
    E realizo o cadastro
    Então recebo mensagem de erro

  Cenario: Validar Cadastro CPF inválido
    Dado que seleciono o botão quero me cadastrar
    E informo um CPF invalido
    E seleciono o termo de acordo
    E realizo o cadastro
    Então o sistema retornar mensagem de erro

  Cenario: Validar Cadastro com idade inferior a dezesseis anos
    Dado que seleciono o botão quero me cadastrar
    E realizar cadastro preenchendo dados solicitados
    E seleciono o termo de acordo
    E realizo o cadastro
    Então o sistema retornar mensagem de idade inferior





