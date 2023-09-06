package br.com.renner.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPages {

    @FindBy(xpath = "//h3[@class='ProductBox_title__x9UGh']")
    public static WebElement ProductTitleDiv;

    @FindBy(xpath = "//*[@id='__next']/div/div[1]/div[2]/section/div[2]/div[2]/div[1]/div[3]/div/div[2]/div[2]/div[2]/label/div/span")
    public static WebElement selecionarCOrAzul;
    @FindBy(xpath = "//*[@id='__next']/div/div[1]/div[2]/section/div[2]/div[2]/div[1]/div[3]/div/div[2]/div[2]/div[1]/label/div/span")
    public static WebElement selecionarCOrBranca;

    @FindBy(xpath = "//span[text()='G']")
    public static WebElement selecionarTamanhoG;

    @FindBy(xpath = "//span[text()='P']")
    public static WebElement selecionarTamanhoP;

    @FindBy(xpath = "//span[text()='M']")
    public static WebElement selecionarTamanhoM;

    @FindBy(xpath = "//span[text()='GG']")
    public static WebElement selecionarTamanhoGG;

    @FindBy(xpath = "//span[@class='PriceDiscount_listPrice__iXr09']")
    public static WebElement getValuePrice;

    @FindBy(xpath = "//button[text()= 'Adicionar à sacola']")
    public static WebElement btnEnviarCarrinho;

    @FindBy(xpath = "//input[@class='quantitySelect']")
    public static WebElement comboQuantidade;

    @FindBy(id = "messageOk")
    public static WebElement btnOkModalAlert;


}
