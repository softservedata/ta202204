package com.softserve.edu.sites.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class ProductForm {
    private final WebDriver driver;
    private final JavascriptExecutor js;

    @FindBy(id = "input-option218")
    private WebElement sizeRadioButton;

    @FindBy(id = "input-option223")
    private WebElement checkbox;

    @FindBy(id = "input-option208")
    private WebElement textField;

    @FindBy(id = "input-option217")
    private WebElement colorDropdown;

    @FindBy(id = "input-option209")
    private WebElement textArea;

    @FindBy(id = "button-upload222")
    private WebElement file;

    @FindBy(id = "input-option219")
    private WebElement date;

    @FindBy(id = "input-option221")
    private WebElement time;

    @FindBy(id = "input-option220")
    private WebElement dateTime;

    @FindBy(id = "input-quantity")
    private WebElement qty;

    @FindBy(id = "button-cart")
    private WebElement addToCardButton;

    public ProductForm(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSizeRadioButton() {
        return this.sizeRadioButton;
    }

    public void clickSizeRadioButton(String size) {
        String path = ".//input[@value='" + size + "']";
        WebElement sizeButton = this.getSizeRadioButton();
        js.executeScript("arguments[0].scrollIntoView(true);", sizeButton);
        sizeButton.findElement(By.xpath(path)).click();
    }

    public WebElement getCheckbox() {
        return this.checkbox;
    }

    public void clickCheckbox(String checkboxText) {
        String path = ".//input[@value='" + checkboxText + "']";
        this.getCheckbox().findElement(By.xpath(path)).click();
    }

    public WebElement getTextField() {
        return this.textField;
    }

    public void setTextField(String text) {
        this.getTextField().sendKeys(text);
    }

    public void clearTextField() {
        this.getTextField().clear();
    }

    public Select getColorDropdown() {
        return new Select(this.colorDropdown);
    }

    public void selectColor(String color) {
        this.getColorDropdown().selectByValue(color);
    }

    public WebElement getTextArea() {
        return this.textArea;
    }

    public void setTextArea(String text) {
        this.getTextArea().sendKeys(text);
    }

    public WebElement getFile() {
        return this.file;
    }

    public void uploadFile() {
        String filePath = "src/test/java/com/softserve/edu/homework11/apple_cinema.txt";
        File testFile = new File(filePath);

        this.getFile().click();

        try {
            Robot robot = new Robot();
            robot.setAutoDelay(1000);

            StringSelection stringSelection = new StringSelection(testFile.getAbsolutePath());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            robot.setAutoDelay(1000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            driver.switchTo().alert().accept();
        } catch (AWTException e) {
            System.err.println(e.getMessage());
        }
    }

    public WebElement getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.getDate().sendKeys(date);
    }

    public void clearDate() {
        this.getDate().clear();
    }

    public WebElement getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.getTime().sendKeys(time);
    }

    public void clearTime() {
        this.getTime().clear();
    }

    public WebElement getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.getDateTime().sendKeys(dateTime);
    }

    public void clearDateTime() {
        this.getDateTime().clear();
    }

    public WebElement getQty() {
        return this.qty;
    }

    public void setQty(String qty) {
        this.getQty().sendKeys(qty);
    }

    public void clearQty() {
        this.getQty().clear();
    }

    public WebElement getAddToCardButton() {
        return this.addToCardButton;
    }

    public void clickAddToCartButton() {
        this.getAddToCardButton().click();
    }
}
