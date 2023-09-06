package br.com.renner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagamentoPages {

    @FindBy(xpath = "//*[@id=\"checkout\"]/div[5]/div[1]/div[1]/div[3]/div[2]/div/div[1]/div/div/div[8]/a/span[2]/span/span[1]")
    public static WebElement tipoPgCredito;

    @FindBy(xpath = "//span[text()='Cartão Virtual de Débito Caixa]")
    public static WebElement tipoPgDebito;

    @FindBy(xpath = "//input[@name='cardNumber']")
    public static WebElement inputCartao;

    @FindBy(xpath = "//input[@name='userCardName']")
    public static WebElement inputNomeCartao;

    @FindBy(xpath = "//input[@name='expirationDate']")
    public static WebElement inputVencimentoCartao;

    @FindBy(xpath = "//input[@name='securityCode']")
    public static WebElement inputCVVCartao;

    @FindBy(xpath = "//div[@class='form__credit_card--installments_selected cp us'][contains(.,'Em quantas vezes quer pagar?')]")
    public static WebElement selectComboParcelamento;

    @FindBy(xpath = "(//li[contains(@class,'us')])[1]")
    public static WebElement option1;

    @FindBy(xpath = "(//li[contains(@class,'us')])[2]")
    public static WebElement option2;

    @FindBy(xpath = "(//li[contains(@class,'us')])[3]")
    public static WebElement option3;

    @FindBy(xpath = "//*[@id='form-multiple-credit-cards']/button")
    public static WebElement btnFinalizar;

    @FindBy(xpath = "//strong[@class='orderNumber']")
    public static WebElement numeroPedidoTxt;

    @FindBy(xpath = "//span[@id='btFechar'][contains(.,'X')]")
    public static WebElement bannerPedido;

    @FindBy(xpath = "//h3[@class='title'][contains(.,'Agradecemos por comprar na Renner')]")
    public static WebElement txtMsgmPedido;

    @FindBy(xpath = "//*[@id='detail_buy']/div/div/div[2]/div[1]/div[2]/div/div/span/div/span")
    public static WebElement getValorPedido;

    @FindBy(xpath = "//a[contains(text(),'orders')]")
    public static WebElement linkOrder;

    @FindBy(name = "newValue")
    public static WebElement inputPedido;

    @FindBy(name = "change")
    public static WebElement btnChanceValue;

    @FindBy(xpath = "//a[@href='/dyn/admin/nucleus/lrsa/fake/mock/ReprocessClearSale/']")
    public static WebElement linkServices;
    @FindBy(xpath = "//a[contains(text(),'approveOrders')]")
    public static WebElement setLinkOrderApprover;

    @FindBy(name = "submit")
    public static WebElement btnInvokeMethod;


}
