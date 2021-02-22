package com.gmail.shulgin220618;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String... args){
        setup();
    }
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(ConfProperties.getProperty("loginpage"));

            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            CatalogPage catalogPage = new CatalogPage(driver);
            ServicesPage servicesPage = new ServicesPage(driver);
            ServicePage servicePage = new ServicePage(driver);
            SubServicePage subServicePage = new SubServicePage(driver);

            mainPage.clickEnterButton();
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            loginPage.inputPassword(ConfProperties.getProperty("password"));
            loginPage.buttonLoginClick();
            mainPage.clickCatalogLink();
            catalogPage.clickLoadMore();
            List<String> allCategories = catalogPage.getLinksCategories();


        }catch(Exception e) {
            System.out.println(e.getMessage());
        }finally {
            driver.quit();
        }
    }
}
