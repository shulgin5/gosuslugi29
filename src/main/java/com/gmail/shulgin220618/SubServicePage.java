package com.gmail.shulgin220618;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubServicePage extends Page {

    public SubServicePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='service-details-link']")
    private WebElement buttonAllInfo;

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

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Срок выполнения услуги:')]/following::p[1]")
    private WebElement deadlineComplete;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Срок, в течение которого заявление о предоставлении услуги должно быть зарегистрировано:')]/following::p[1]")
    private WebElement dealineRegistrationApplication;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Максимальный срок ожидания в очереди при подаче заявления о предоставлении услуги лично:')]/following::p[1]")
    private WebElement maxTimeWait;

    @FindBy(xpath="//a[@id='dataGrpcategory']/ancestor::h3/following-sibling::div/ul/li")
    private List<WebElement> categoriesRecipients;

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Способы подачи заявки:')]/following::ul[1]/li")
    private List<WebElement> methodsSendApplication;

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Способы получения результата:')]/following::ul[1]/li")
    private List<WebElement> methodsGetAnswer;

    public String getNameOrganization(){
        return this.nameOrganization.getAttribute("innerText");
    }

    public String getNameSubService(){
        return this.nameSubService.getAttribute("innerText");
    }

    public String getReglamentLink(){
        return this.reglamentLink.getAttribute("href");
    }

    public boolean getButtonGet(){
        return this.buttonGet.isDisplayed();
    }

    public String getReestrNumber(){
        return this.reestrNumber.getAttribute("innerText");
    }

    public String getIdGoal(){
        return this.idGoal.getAttribute("innerText");
    }

    public String getDateLastUpdate(){
        return this.dateLastUpdate.getAttribute("innerText");
    }

    public String getDeadlineComplete(){
        return this.deadlineComplete.getAttribute("innerText");
    }

    public String getDealineRegistrationApplication(){
        return this.dealineRegistrationApplication.getAttribute("innerText");
    }

    public String getMaxTimeWait(){
        return this.maxTimeWait.getAttribute("innerText");
    }

    public List<String> getCategoriesRecipients(){
        List<String> categories = new ArrayList<>();
        for(WebElement category : this.categoriesRecipients){
            categories.add(category.getAttribute("innerText"));
        }
        return categories;
    }

    public List<String> getMethodsSendApplication(){
        List<String> methods = new ArrayList<>();
        for(WebElement method : this.methodsSendApplication){
            methods.add(method.getAttribute("innerText"));
        }
        return methods;
    }

    public List<String> getMethodsGetAnswer(){
        List<String> methods = new ArrayList<>();
        for(WebElement method : this.methodsGetAnswer){
            methods.add(method.getAttribute("innerText"));
        }
        return methods;
    }

    public void clickButtonAllInfo(){
        waitElement(By.xpath("//a[@class='service-details-link']"),5);
        this.buttonAllInfo.click();
    }

}
