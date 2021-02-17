package com.gmail.shulgin220618;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubServicePage {
    public WebDriver driver;

    public SubServicePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='service-organ-link']")
    private WebElement nameOrganization;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Государственная услуга:')]/following::p[1]")
    private WebElement nameSubService;

    @FindBy(xpath = "//a[@class='reglament-link']")
    private WebElement reglamentLink;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    private WebElement buttonGet;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Реестровый номер услуги:')]/following::p[1]")
    private WebElement reestrNumber;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Идентификатор цели:')]/following::p[1]")
    private WebElement idGoal;

    @FindBy(xpath = "//div[@class='mobile-hidden']")
    private WebElement dateLastUpdate;


}
