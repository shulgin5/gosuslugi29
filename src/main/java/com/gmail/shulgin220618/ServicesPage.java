package com.gmail.shulgin220618;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Exception;

import java.util.ArrayList;
import java.util.List;

public class ServicesPage {
    public WebDriver driver;

    public ServicesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickLoadMore(){
        try {
            while (true) {
                waitShowButtonLoadMore(By.xpath("//a[@class=\"btn btn-lg btn-primary btn--tiles-more btn--pagination\"]"), 5).click();
            }
        }catch(Exception e){
            System.out.println("Загружены все элементы");
        }
    }

    private WebElement waitShowButtonLoadMore(By locator, int n){
        WebDriverWait wait = new WebDriverWait(driver, n);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<String> getLinksServices(){
        List<String> links = new ArrayList<String>();
        List<WebElement> allServices = getAllServices();
        for (WebElement service : allServices){
            links.add(service.getAttribute("href"));
        }
        return links;
    }

    private List<WebElement> getAllServices(){
        return driver.findElements(By.xpath("//*[@data-behavior=\"tileAction\"]/a"));
    }
}
