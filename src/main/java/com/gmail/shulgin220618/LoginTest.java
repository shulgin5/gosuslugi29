package com.gmail.shulgin220618;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class LoginTest {

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

            mainPage.clickEnterButton();
            loginPage.inputLogin(ConfProperties.getProperty("login"));
            loginPage.inputPassword(ConfProperties.getProperty("password"));
            loginPage.buttonLoginClick();
            mainPage.clickCatalogLink();
            catalogPage.clickLoadMore();
            List<String> allCategories = catalogPage.getLinksCategories();

            driver.get(allCategories.get(2));
            servicesPage.clickLoadMore();
            List<String> allServices = servicesPage.getLinksServices();
            driver.get(allServices.get(6));
            System.out.println(servicePage.getServiceName());
            System.out.println(servicePage.getOrganizationName());
            System.out.println(servicePage.getReglamentLink());
            System.out.println(servicePage.getElectronicServices().size());
            System.out.println(servicePage.getNoElectronicServices().size());
            System.out.println(allServices.size());


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
