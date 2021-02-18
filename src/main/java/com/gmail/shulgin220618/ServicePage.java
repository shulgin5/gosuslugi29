package com.gmail.shulgin220618;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ServicePage extends Page{

    public ServicePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class=\"modal-title-inner-text\"]/span")
    private WebElement serviceName;

    @FindBy(xpath = "//a[@class=\"service-organ-link\"]")
    private WebElement organizationName;

    @FindBy(xpath = "//a[@class=\"reglament-link\"]")
    private WebElement reglamentLink;

    @FindBy(xpath = "//h3[@class='b-basic-list-title ' and contains(text(), 'Электронные услуги')]/following-sibling::div/div/a")
    private List<WebElement> electronicServices;

    @FindBy(xpath = "//h3[@class='b-basic-list-title ' and contains(text(), 'Не электронные услуги')]/following-sibling::div/div/a")
    private List<WebElement> noElectronicServices;

    public String getServiceName(){
        return this.serviceName.getAttribute("innerText");
    }

    public String getOrganizationName(){
        return this.organizationName.getAttribute("innerText");
    }

    public String getReglamentLink(){
        return this.reglamentLink.getAttribute("href");
    }

    public int countElectonicSubServices(){
        return electronicServices.size();
    }

    public int countNoElectonicSubServices(){
        return noElectronicServices.size();
    }

    public List<String> getElectronicServices(){
        List<String> links = new ArrayList<>();
        for (WebElement subService : this.electronicServices){
            String dataTargetId = subService.getAttribute("data-targetid");
            String dataServiceId = subService.getAttribute("data-serviceid");
            String subServiceLink = "https://gosuslugi29.ru/pgu/services/info/targets.htm?id=" +
                    dataTargetId + "&serviceId=" + dataServiceId;
            links.add(subServiceLink);
        }
        return links;
    }

    public List<String> getNoElectronicServices(){
        List<String> links = new ArrayList<>();
        for (WebElement subService : this.noElectronicServices){
            String dataTargetId = subService.getAttribute("data-targetid");
            String dataServiceId = subService.getAttribute("data-serviceid");
            String subServiceLink = "https://gosuslugi29.ru/pgu/services/info/targets.htm?id=" +
                    dataTargetId + "&serviceId=" + dataServiceId;
            links.add(subServiceLink);
        }
        return links;
    }

}
