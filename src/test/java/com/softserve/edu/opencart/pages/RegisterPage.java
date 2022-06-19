package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends AccountSidebarGuestPart {

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement phone;
    private WebElement address1;
    private WebElement city;
    private WebElement postCode;
    private WebElement password;
    private WebElement passwordConfirm;
    private WebElement fax;
    private WebElement company;
    private WebElement address2;
    private WebElement country;
    private WebElement region;
    private WebElement subscribe;
    private WebElement privacyPolicy;
    private WebElement continueButton;

    private List<WebElement> countries;
    private List<WebElement> states;

    private void initElements() {
        firstName = driver.findElement(By.id("input-firstname"));
        lastName = driver.findElement(By.id("input-lastname"));
        email = driver.findElement(By.id("input-email"));
        phone = driver.findElement(By.id("input-telephone"));
        fax = driver.findElement(By.id("input-fax"));     // not required
        company = driver.findElement(By.id("input-company")); // not required
        address1 = driver.findElement(By.id("input-address-1"));
        address2 = driver.findElement(By.id("input-address-2")); // not required
        city = driver.findElement(By.id("input-city"));
        postCode = driver.findElement(By.id("input-postcode"));
        country = driver.findElement(By.id("input-country"));
        region = driver.findElement(By.id("input-zone"));
        password = driver.findElement(By.id("input-password"));
        passwordConfirm = driver.findElement(By.id("input-confirm"));
        subscribe = driver.findElement(By.cssSelector("input[name='newsletter'][value='1']"));
        privacyPolicy = driver.findElement(By.name("agree"));
        continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        setCountries();
        setStates();

    }
    public WebElement getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        getFirstName().sendKeys(firstName);
    }
    public WebElement getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        getLastName().sendKeys(lastName);
    }

    public WebElement getFax() {
        return fax;
    }
    public void setFax(String fax) {
        getFax().sendKeys(fax);
    }

    public WebElement getCompany() {
        return company;
    }
    public void setCompany(String company) {
        getCompany().sendKeys(company);
    }

    public WebElement getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        getAddress2().sendKeys(address2);
    }

    public WebElement getEmail() {
        return email;
    }
    public void setEmail(String email) {
        getEmail().sendKeys(email);
    }

    public WebElement getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        getPhone().sendKeys(phone);
    }

    public WebElement getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        getAddress1().sendKeys(address1);
    }

    public WebElement getCity() {
        return city;
    }
    public void setCity(String city) {
        getCity().sendKeys(city);
    }

    public WebElement getZipCode() {
        return postCode;
    }
    public void setZipCode(String zipCode) {
        getZipCode().sendKeys(zipCode);
    }

    public WebElement getPassword() {
        return password;
    }
    public void setPassword(String password) {
        getPassword().sendKeys(password);
    }

    public WebElement getCountry() {
        return country;
    }
    public WebElement getRegion() {
        return region;
    }

    public WebElement getPasswordConfirm() {
        return passwordConfirm;
    }
    public void setPasswordConfirm(String passwordConfirm) {
        getPasswordConfirm().sendKeys(passwordConfirm);
    }

    public List<WebElement> getCountries() {
        return countries;
    }
    public void setCountries() {
        countries = new ArrayList<>();
        countries.addAll(driver.findElements(By.cssSelector("#input-country option")));
    }
    public List<WebElement> getStates() {
        return states;
    }
    public void setStates() {
        states = new ArrayList<>();
        states.addAll(driver.findElements(By.cssSelector("#input-zone option")));
    }
    public void selectCountry(String country) {
        for ( WebElement element : getCountries() ) {
            if (element.getText().contains(country)) {
                element.click();
                break;
            }
        }
    }
    public void selectState(String state) {
        for ( WebElement element : getStates() ) {
            if (element.getText().contains(state)) {
                element.click();
                break;
            }
        }
    }


    // Functional
    public void clickOnCountryList() {
        getCountry().click();
    }
    public void clickOnStateList() {
        getRegion().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private WebElement getSubscribe() {
        return subscribe;
    }
    private void setSubscribe(boolean subscribe) {
        if(subscribe)
            getSubscribe().click();
    }
    private WebElement getPrivacypolicy() {
        return privacyPolicy;
    }
    private void setPrivacypolicy(boolean privacypolicy) {
        if(privacypolicy)
            getPrivacypolicy().click();
    }
    private WebElement getContinueButton() {
        return continueButton;
    }
    private void clickContinueButton() {
        getContinueButton().click();
    }

    // Business Logic
    public void fillInRegisterPage(IUser user) {
        setFirstName(user.getFirstname());
        setLastName(user.getLastname());
        setEmail(user.getEmail());
        setPhone(user.getTelephone());
        setFax(user.getFax());
        setCompany(user.getCompany());
        setAddress1(user.getAddress1());
        setAddress2(user.getAddress2());
        setCity(user.getCity());
        setZipCode(user.getPostcode());
        clickOnCountryList();
        selectCountry(user.getCountry());
        clickOnStateList();
        selectState(user.getRegion());
        setPassword(user.getPassword());
        setPasswordConfirm(user.getPassword());
        setSubscribe(user.isSubscribe());
        setPrivacypolicy(user.agreePrivacyPolicy());
        clickContinueButton();
    }
}
