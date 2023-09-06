package br.com.renner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroPages {

    @FindBy(xpath = "//button[contains(.,'QUERO ME CADASTRAR')]")
    public static WebElement btnQueroMecadastrar;

    @FindBy(xpath = "//h2[contains(.,'CADASTRO')]")
    public static WebElement TxtCadastroTitulo;

    @FindBy(name = "login")
    public static WebElement TxtEmailCadastro;

    @FindBy(xpath = "//div[@class='FormControl_form__T4x_w'][1]/input")
    public static WebElement TxtCPFCadastro;

    @FindBy(name = "firstName")
    public static WebElement TxtNomeCadastro;

    @FindBy(name = "lastName")
    public static WebElement TxtSorbeNomeCadastro;

    @FindBy(xpath = "(//input[contains(@type,'text')])[6]")
    public static WebElement TxtDataNascimentoCadastro;

    @FindBy(xpath = "//form/div[6]/div/label[2]/span")
    public static WebElement RadioMasculino;

    @FindBy(name = "password")
    public static WebElement TxtSenhaCadastro;

    @FindBy(xpath = "(//input[contains(@type,'text')])[7]")
    public static WebElement TxtTelefoneCadastro;

    @FindBy(xpath = "//*[@id='__next']/div/div[1]/div[1]/div[1]/div/div/main/div/div[2]/div/form/div[9]/label[2]/div")
    public static WebElement CbxTermoAceiteCadastro;

    @FindBy(xpath = "//button[contains(.,'Cadastrar')]")
    public static WebElement BtnCadastrar;

    @FindBy(xpath = "//p[@class='modal-alert-message']")
    public static WebElement GetMensagemSucesso;

    @FindBy(xpath = "//button[contains(.,'OK')]")
    public static WebElement BtnOkModal;


    @FindBy(xpath = "//p[contains(text(),'CPF inválido!')]")
    public static WebElement TxtMensagemCPFInvalido;

    @FindBy(xpath = "//p[contains(text(),'Desculpe. Atualmente, o cadastro em nossa Loja Virtual/APP está disponível apenas para maiores de 16 anos.')]")
    public static WebElement TxtMensagemMenorIdade;

}
