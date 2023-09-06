package br.com.renner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoPages {

    @FindBy(xpath = "//button[contains(text(),'Finalizar Compra')]")
    public static WebElement btnFinalizarCompra;

    @FindBy(xpath = "//*[@id='checkout']/div[5]/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/label/div")
    public static WebElement radioButtonPadrao;

    @FindBy(xpath = "//label[@for='oc1479771377']")
    public static WebElement radioButtonNovo;
    @FindBy(xpath = "//*[@id='messageOk']")
    public static WebElement btnOkModal;

    @FindBy(xpath = "//span[contains(text(),'Normal')]")
    public static WebElement freteNormal;

    @FindBy(xpath = "//span[contains(text(),'Agendada')]")
    public static WebElement freteAgendada;

    @FindBy(xpath = "//a[contains(text(),'IR PARA PAGAMENTO')]")
    public static WebElement btnIrPagamento;

}
