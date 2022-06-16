package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends AccountSidebarGuestPart {
    public static final String successRegistrationMessage = "Your Account Has Been Created!";

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement successMessage;

    @FindBy(id = "input-firstname")
    private WebElement firstName;
    @FindBy(id = "input-lastname")
    private WebElement lastName;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-telephone")
    private WebElement telephone;
    @FindBy(id = "input-fax")
    private WebElement fax;

    @FindBy(id = "input-company")
    private WebElement company;
    @FindBy(id = "input-address-1")
    private WebElement addressFirst;
    @FindBy(id = "input-address-2")
    private WebElement addressSecond;
    @FindBy(id = "input-city")
    private WebElement city;
    @FindBy(id = "input-postcode")
    private WebElement postCode;
    @FindBy(id = "input-country")
    private WebElement country;
    @FindBy(id = "input-zone")
    private WebElement region;

    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    //private WebElement subscribe;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//div[@id='content']//input[@class='btn btn-primary']")
    private WebElement continueButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        PageFactory.initElements(this.driver, this);
    }

    // Page Object

    public WebElement getSuccessMessage() {
        return this.successMessage;
    }

    public String getSuccessMessageText() {
        return this.getSuccessMessage().getText();
    }

    public WebElement getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.getFirstName().sendKeys(firstName);
        ;
    }

    public void clickFirstName() {
        this.getFirstName().click();
    }

    public WebElement getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.getLastName().sendKeys(lastName);
        ;
    }

    public void clickLastName() {
        this.getLastName().click();
    }

    public WebElement getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.getEmail().sendKeys(email);
        ;
    }

    public void clickEmail() {
        this.getEmail().click();
    }

    public WebElement getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.getTelephone().sendKeys(telephone);
        ;
    }

    public void clickTelephone() {
        this.getTelephone().click();
    }

    public WebElement getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.getFax().sendKeys(fax);
        ;
    }

    public void clickFax() {
        this.getFax().click();
    }

    public WebElement getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.getCompany().sendKeys(company);
        ;
    }

    public void clickCompany() {
        this.getCompany().click();
    }

    public WebElement getAddressFirst() {
        return this.addressFirst;
    }

    public void setAddressFirst(String addressFirst) {
        this.getAddressFirst().sendKeys(addressFirst);
        ;
    }

    public void clickAddressFirst() {
        this.getAddressFirst().click();
    }

    public WebElement getAddressSecond() {
        return this.addressSecond;
    }

    public void setAddressSecond(String addressSecond) {
        this.getAddressSecond().sendKeys(addressSecond);
        ;
    }

    public void clickAddressSecond() {
        this.getAddressSecond().click();
    }

    public WebElement getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.getCity().sendKeys(city);
        ;
    }

    public void clickCity() {
        this.getCity().click();
    }

    public WebElement getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.getPostCode().sendKeys(postCode);
        ;
    }

    public void clickPostCode() {
        this.getPostCode().click();
    }

    public Select getCountry() {
        return new Select(this.country);
    }

    public void deselectCountry() {
        this.getCountry().deselectByValue("222");
    }

    public void selectCountry(String country) {
        this.getCountry().selectByVisibleText(country);
    }

    public Select getRegion() {
        return new Select(this.region);
    }

    public void selectRegion(String region) {
        this.getRegion().selectByVisibleText(region);
    }

    public WebElement getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.getPassword().sendKeys(password);
        ;
    }

    public void clickPassword() {
        this.getPassword().click();
    }

    public WebElement getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.getConfirmPassword().sendKeys(confirmPassword);
        ;
    }

    public void clickConfirmPassword() {
        this.getConfirmPassword().click();
    }

    public WebElement getPrivacyPolicy() {
        return this.privacyPolicy;
    }

    public void clickPrivacyPolicy() {
        this.getPrivacyPolicy().click();
    }

    public WebElement getContinueButton() {
        return this.continueButton;
    }

    public void clickContinueButton() {
        this.getContinueButton().click();
    }


    // Functional

    private void enterFistName(String firstName) {
        clickFirstName();
        setFirstName(firstName);
    }

    private void enterLastName(String lastName) {
        clickLastName();
        setLastName(lastName);
    }

    private void enterEmail(String email) {
        clickEmail();
        setEmail(email);
    }

    private void enterTelephone(String telephone) {
        clickTelephone();
        setTelephone(telephone);
    }

    private void enterFax(String fax) {
        clickFax();
        setFax(fax);
    }

    private void enterCompany(String company) {
        clickCompany();
        setCompany(company);
    }

    private void enterAddressFirst(String addressFirst) {
        clickAddressFirst();
        setAddressFirst(addressFirst);
    }

    private void enterAddressSecond(String addressSecond) {
        clickAddressSecond();
        setAddressSecond(addressSecond);
    }

    private void enterCity(String city) {
        clickCity();
        setCity(city);
    }

    private void enterPostCode(String postCode) {
        clickPostCode();
        setPostCode(postCode);
    }

    private void enterCountry(String country) {
        selectCountry(country);
    }

    private void enterRegion(String region) {
        selectRegion(region);
    }

    private void enterPassword(String password) {
        clickPassword();
        setPassword(password);
    }

    private void enterConfirmPassword(String confirmPassword) {
        clickConfirmPassword();
        setConfirmPassword(confirmPassword);
    }

    public void fillRegister(IUser user) {
        //public void fillLogin(String email, String password) {
        enterFistName(user.getFirstname());
        enterLastName(user.getLastname());
        enterEmail(user.getEmail());
        enterTelephone(user.getTelephone());

        enterCompany(user.getCompany());
        enterAddressFirst(user.getAddress1());
        enterAddressSecond(user.getAddress2());
        enterCity(user.getCity());
        enterPostCode(user.getPostcode());
        enterCountry(user.getCountry());
        enterRegion(user.getRegion());

        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());

        clickPrivacyPolicy();
        clickContinueButton();
    }

    public RegisterPage successfulRegister(IUser validUser) {
        fillRegister(validUser);
        return new RegisterPage(driver);
    }
}
