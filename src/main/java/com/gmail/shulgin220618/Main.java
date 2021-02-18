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

//            mainPage.clickEnterButton();
//            loginPage.inputLogin(ConfProperties.getProperty("login"));
//            loginPage.inputPassword(ConfProperties.getProperty("password"));
//            loginPage.buttonLoginClick();
            mainPage.clickCatalogLink();
            catalogPage.clickLoadMore();
            List<String> allCategories = catalogPage.getLinksCategories();

            driver.get(allCategories.get(2));
            servicesPage.clickLoadMore();
            List<String> allServices = servicesPage.getLinksServices();
            driver.get(allServices.get(6));
            driver.get(servicePage.getElectronicServices().get(0));
            subServicePage.clickButtonAllInfo();
            System.out.println(subServicePage.getNameSubService());
//            System.out.println(subServicePage.getButtonGet());
            System.out.println(subServicePage.getReglamentLink());
            System.out.println(subServicePage.getNameOrganization());
            System.out.println(subServicePage.getReestrNumber());
            System.out.println(subServicePage.getDateLastUpdate());





//            int countElectron = 0;
//            int countNoElectron = 0;
//
//            for (String category : allCategories) {
//                driver.get(category);
//                servicesPage.clickLoadMore();
//                List<String> allServices = servicesPage.getLinksServices();
//                for (String service : allServices) {
//                    driver.get(service);
//                }
//            }



            Thread.sleep(10000);


        }catch(Exception e) {
            System.out.println(e.getMessage());
        }finally {
            driver.quit();
            driver.close();
        }
    }
}
