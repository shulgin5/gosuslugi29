package com.gmail.shulgin220618;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SubServicePage {
    public WebDriver driver;

    public SubServicePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement nameOrganization;

    private WebElement nameSubService;

    private WebElement reglamentLink;

    private WebElement buttonGet;

    private WebElement reestrNumber;

    private WebElement idGoal;

    private WebElement dateLastUpdate;
}
