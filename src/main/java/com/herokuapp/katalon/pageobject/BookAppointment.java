package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.logger.Logs;
import com.herokuapp.katalon.utilities.RandomDateGenerator;
import com.herokuapp.katalon.utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.herokuapp.katalon.utilities.WebDriverUtils.selectValueFromDropdown;

public class BookAppointment {

    private WebDriver driver;
    public BookAppointment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logs logs = new Logs();

    @FindBy(id = "btn-make-appointment")
    public WebElement createNewProjectButton;

    @FindBy(id = "combo_facility")
    public WebElement facilityDropDownLocator;

    @FindBy(id = "chk_hospotal_readmission")
    public WebElement readmissionCheckmarkLocator;

    @FindBy(id = "txt_visit_date")
    public WebElement enterDateLocator;

    @FindBy(id = "txt_comment")
    public WebElement txtCommentLocator;

    @FindBy(id = "btn-book-appointment")
    public WebElement bookAppointmentButtonLocator;

    @FindBy(id = "summary")
    public WebElement summaryLocator;

//    @FindBy(how = How.CSS, using = "input[type='radio']")
//    public By healthCareRadioButtonList;

    public By healthCareRadioButtonList = By.cssSelector("input[type='radio']");

    public void clickBookAppointmentButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createNewProjectButton);
        logs.process("Successfully clicked");
    }

    public void fillFacilityDropDownByText(String text){
        selectValueFromDropdown(facilityDropDownLocator, text);
    }

    public void checkHospitalReadmission(){
        readmissionCheckmarkLocator.click();
    }

    public List<WebElement> findElementsByIndex(){
        return driver.findElements(healthCareRadioButtonList);
    }

    public void fillRandomDate(){
        enterDateLocator.sendKeys(RandomDateGenerator.fillRandomDate());
    }

    public void fillCommentField(String comment){
        txtCommentLocator.sendKeys(comment);
    }

    public void submitAppointment(){
        bookAppointmentButtonLocator.click();
    }

    public boolean confirmationIsDisplayed(WebElement element) {
        WebDriverUtils.waitForElement(driver, element, 30);
        return true;
    }
}



