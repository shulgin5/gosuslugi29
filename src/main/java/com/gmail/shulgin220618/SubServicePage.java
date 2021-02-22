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

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Способы подачи заявки:')]/following::ul[1]/li")
    private List<WebElement> methodsSendApplication;

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Способы получения результата:')]/following::ul[1]/li")
    private List<WebElement> methodsGetAnswer;

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Адрес предоставления в электронном виде:')]/following::p[1]")
    private WebElement adderssService;

    @FindBy(xpath = "//p[contains(text(),'Стоимость:')]/following::p[1]")
    private WebElement cost;

    @FindBy(xpath = "//span[contains(text(),'Стоимость и порядок оплаты')]/following::p[1]")
    private WebElement costFree;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Срок выполнения услуги:')]/following::p[1]")
    private WebElement deadlineComplete;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Срок, в течение которого заявление о предоставлении услуги должно быть зарегистрировано:')]/following::p[1]")
    private WebElement dealineRegistrationApplication;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Максимальный срок ожидания в очереди при подаче заявления о предоставлении услуги лично:')]/following::p[1]")
    private WebElement maxTimeWait;

    @FindBy(xpath="//a[@id='dataGrpcategory']/ancestor::h3/following-sibling::div/ul/li")
    private List<WebElement> categoriesRecipients;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Основание для оказания услуги:')]/following::p[1]")
    private WebElement reasonProvisionService;

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Основание для приостановления/отказа:')]/following::ul[1]/li")
    private List<WebElement> reasonsRefuse;

    @FindBy(xpath="//p[@class='attr-title' and contains(text(),'Результат оказания услуги:')]/following::ul[1]/li")
    private List<WebElement> result;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Государственная услуга:')]/following::p[1]")
    private WebElement nameSubService;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Реестровый номер услуги:')]/following::p[1]")
    private WebElement reestrNumber;

    @FindBy(xpath = "//p[@class='attr-title' and contains(text(),'Идентификатор цели:')]/following::p[1]")
    private WebElement idGoal;

    @FindBy(xpath = "//div[@class='mobile-hidden']")
    private WebElement dateLastUpdate;

    @FindBy(xpath = "//a[@class='service-details-link']")
    private WebElement buttonAllInfo;

    @FindBy(xpath = "//a[@class='service-organ-link']")
    private WebElement nameOrganization;

    @FindBy(xpath = "//a[@class='reglament-link']")
    private WebElement reglamentLink;

    @FindBy(xpath = "//*[contains(text(),'Получить услугу')]")
    private WebElement buttonGet;

    public String getNameOrganization(){
        return this.nameOrganization.getAttribute("innerText");
    }

    public String getAddressService(){
        return this.adderssService.getAttribute("innerText");
    }

    public String getCost(){
        return this.cost.getAttribute("innerText");
    }

    public String getCostFree(){
        return this.costFree.getAttribute("innerText");
    }

    public String getReasonProvisionService(){
        return this.reasonProvisionService.getAttribute("innerText");
    }

    public List<String> getReasonRefuse(){
        List<String> reasons = new ArrayList<>();
        for(WebElement reason : this.reasonsRefuse){
            reasons.add(reason.getAttribute("innerText"));
        }
        return reasons;
    }

    public List<String> getResult(){
        List<String> results = new ArrayList<>();
        for(WebElement result : this.result){
            results.add(result.getAttribute("innerText"));
        }
        return results;
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
