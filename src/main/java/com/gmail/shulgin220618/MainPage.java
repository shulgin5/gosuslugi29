package com.gmail.shulgin220618;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@data-behavior, 'signIn')]")
    private WebElement enterButton;

    @FindBy(xpath = "//*[contains(text(), 'Каталог услуг')]/..")
    private WebElement catalogLink;

    public void clickCatalogLink(){
        catalogLink.click();
    }

    public void clickEnterButton(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@data-behavior, 'tileAction')]")));
        enterButton.click();
    }

}
