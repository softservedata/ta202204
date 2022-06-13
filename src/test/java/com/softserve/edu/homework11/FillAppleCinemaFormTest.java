package com.softserve.edu.homework11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class FillAppleCinemaFormTest {

    private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss-S";
    private static final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeScreenShot(String name) {
        String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./" + name + "_" + currentTime + "_screenshot.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
    }

    public void changeCurrency(){
        driver.findElement(By.xpath("//*[@id='form-currency']/div/button")).click();
        driver.findElement(By.name("USD")).click();
    }

    @Test
    public void testFillTheForm() {
        changeCurrency();
        clickToCart("Apple Cinema");
        setRadio();
        setCheckbox();
        setText();
        selectColor("Green");
        setTextarea();
        uploadFile();
        setDate();
        setTime();
        setDateTime();
        setQuantity("4");
        addToCart();
        checkAddToCartAlert();
        takeScreenShot("testFillTheForm");
    }


    public void scrollToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    //Search product on the site
    private WebElement getItemByName(String name){
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        WebElement result = null;
        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'product-layout')]"));
        for (WebElement current : products) {
            if (current.findElement(By.xpath(".//a[text()]")).getText().equals(name)); {
                result = current;
                break;
            }
        }
        return result;
    }

    public void clickToCart(String name){
        WebElement addMacToCart = getItemByName(name);
        addMacToCart.findElement(By.xpath(".//button[@type='button']")).click();
        presentationSleep();
    }

    public void setRadio(){
        List <WebElement> radioButtons = driver.findElements(By.xpath("//div[@id='input-option218']//div[@class='radio']"));
        boolean check = false;
        scrollToElement(driver.findElement(By.xpath("//div[@id='input-option218']")));

/*        for(WebElement current : radioButtons) {
            String radioButtonsName = current.getText();

            if(radioButtonsName.trim().contains(size)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
                (new WebDriverWait(driver, Duration.ofSeconds(10)))
                        .until(ExpectedConditions.elementToBeClickable(current));
                current.click();
                check = current.isSelected();
                System.out.println(current.getText() + " - " + check);
            }
        }*/

        WebElement radioButton = driver.findElement(By.xpath("//div[@id='input-option218']//div[@class='radio']//input[@value='6']"));
        radioButton.click();
    }

    public void setCheckbox() {
        List <WebElement> checkBoxes = driver.findElements(By.xpath("//div[@id='input-option223']//div[@class='checkbox']"));
        boolean check = false;

        scrollToElement(driver.findElement(By.xpath("//div[@id='input-option223']")));
/*
        for(WebElement current : checkBoxes) {
            String checkBoxesName = current.getText();

            if(checkBoxesName.trim().equals(name)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
                (new WebDriverWait(driver, Duration.ofSeconds(10)))
                        .until(ExpectedConditions.elementToBeClickable(current));
                current.click();
                check = current.isSelected();
                System.out.println(current.getText() + " - " + check);
            }
        }*/

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='input-option223']//div[@class='checkbox']//input[@value='9']"));
        checkbox.click();
    }

    public void setText() {
        String textValue = "New Test";
        driver.findElement(By.id("input-option208")).click();
        driver.findElement(By.id("input-option208")).clear();
        driver.findElement(By.id("input-option208")).sendKeys(textValue);
    }

    public void selectColor(String color) {
        WebElement colorDropdown = driver.findElement(By.cssSelector("#input-option217"));
        Select colors = new Select(colorDropdown);

        List<WebElement> dropdown = colors.getOptions();

        for(WebElement current : dropdown) {
            if(current.getText().trim().contains(color)) {
                current.click();
            }
        }
    }

    public void setTextarea() {
        String textareaValue = "Homework 11";
        driver.findElement(By.id("input-option209")).click();
        driver.findElement(By.id("input-option209")).clear();
        driver.findElement(By.id("input-option209")).sendKeys(textareaValue);
    }

    public void acceptAlert() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.alertIsPresent());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));

        Alert alert = driver.switchTo().alert();

        try {
            if (alert.getText().equals("Your file was successfully uploaded!")) {
                System.out.println("File uploaded successfully");
                alert.accept();
            }
        } catch(NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void uploadFile() {
        Robot robot = null;

        StringSelection filePath;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        filePath = new StringSelection("C:\\javaCoreForTA\\homework11.txt");

        driver.findElement(By.xpath("//button[@id='button-upload222']")).click();
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);


        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        acceptAlert();
    }

    public void setDate() {
        Date date = new Date();

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

        String formattedDate= dateFormat.format(date);

        WebElement dateField = driver.findElement(By.xpath("//div[@class='input-group date']//input[@class='form-control']"));

        dateField.click();
        dateField.clear();
        dateField.sendKeys(formattedDate);
    }

    public void setTime() {
        Date time = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = timeFormat.format(time);

        WebElement timeField = driver.findElement(By.xpath("//div[@class='input-group time']//input[@class='form-control']"));
        timeField.click();
        timeField.clear();
        timeField.sendKeys(formattedTime);
    }

    public void setDateTime() {
        Date dateTime = new Date();
        DateFormat dateTimeFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm");
        String formattedDateTime = dateTimeFormat.format(dateTime);

        WebElement timeField = driver.findElement(By.xpath("//div[@class='input-group datetime']//input[@class='form-control']"));
        timeField.click();
        timeField.clear();
        timeField.sendKeys(formattedDateTime);
    }

    public void setQuantity(String quantity) {
        WebElement quantityField = driver.findElement(By.id("input-quantity"));
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void addToCart() {
        driver.findElement(By.cssSelector("#button-cart")).click();
    }

    public void checkAddToCartAlert() {
        try {
            WebElement successAlert = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
            if(successAlert != null) {
                System.out.println("Item was added to cart");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }


}
