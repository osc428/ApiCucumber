package com.devEx.pages;

import com.devEx.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtnLoginPage;

    @FindBy(xpath = "//*[text()='Invalid Credentials!']")
    public WebElement invalidText;

    public void loginTeacher(){
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtnLoginPage.click();
    }

    public void login(String username, String password){
       understandBtn.click();
       loginBtnBasePage.click();
       emailInput.sendKeys(username);
       passwordInput.sendKeys(password);
       loginBtnLoginPage.click();
    }


}
