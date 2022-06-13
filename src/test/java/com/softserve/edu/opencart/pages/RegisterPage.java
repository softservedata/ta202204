package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends AccountSidebarGuestPart {
    
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement phone;
    private WebElement address1;
    private WebElement city;
    private WebElement zipCode;
    private WebElement password;
    private WebElement passwordConfirm;
    private WebElement fax;
    private WebElement company;
    private WebElement address2;
    private WebElement country;
    private WebElement state;
    
    private List<WebElement> countries;
    private List<WebElement> states;


    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    
    private void initElements() {
        firstName = driver.findElement(By.name("firstname"));
        lastName = driver.findElement(By.name("lastname"));
        email = driver.findElement(By.name("email"));
        phone = driver.findElement(By.name("telephone"));
        address1 = driver.findElement(By.name("address_1"));
        city = driver.findElement(By.name("city"));
        zipCode = driver.findElement(By.name("postcode"));
        password = driver.findElement(By.name("password"));
        passwordConfirm = driver.findElement(By.name("confirm"));
        fax = driver.findElement(By.name("fax"));
        company = driver.findElement(By.name("company"));
        address2 = driver.findElement(By.name("address_2"));
        country = driver.findElement(By.name("country_id"));
        state = driver.findElement(By.name("zone_id"));
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
        return zipCode;
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
    
    public WebElement getState() {
        return state;
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

// Page Object

    // Functional

    public void clickOnCountryList() {
        getCountry().click();
    }
    
    public void clickOnStateList() {
        getState().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Business Logic

    public void fillFields(IUser user) {
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
    }
    


}
