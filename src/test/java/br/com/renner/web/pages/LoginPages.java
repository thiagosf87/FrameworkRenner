package br.com.renner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages {

    @FindBy(xpath = "(//span[contains(.,'Entre ou cadastre-se')])[2]")
    public static WebElement BtnEntre;

    @FindBy(xpath = "//h2[@class='css-1063n1j e1wna1tp2'][contains(.,'Identificação')]")
    public static WebElement TituloIdentificacao;

    @FindBy(name = "login")
    public static WebElement InputCpfEmail;

    @FindBy(name = "password")
    public static WebElement InputSenha;

    @FindBy(xpath = "//button[@class='Button_button__vcDFE Button_medium__2sh2z'][contains(.,'ENTRAR')]")
    public static WebElement BtnLogin;

    @FindBy(xpath = "//strong[@class='user-info__strong']")
    public static WebElement UserLogado;

    @FindBy(xpath = "//p[@class='modal-alert-message']")
    public static WebElement getMensagemErro;


    @FindBy(xpath = "//p[@class='FormControl_helperText__T_6ly color-error text-xxs font-regular text-s-lg']")
    public static WebElement getMensagemEmail;

    @FindBy(xpath = "//span[@class='css-15h4f5l eczc0zn1']")
    public static WebElement getMsgmCampoSenha;

}
