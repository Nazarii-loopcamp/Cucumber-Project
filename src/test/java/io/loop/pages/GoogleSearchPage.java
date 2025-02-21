package io.loop.pages;

import io.cucumber.java.en.Then;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id='APjFqb']")
    public WebElement searchBox;

    @FindBy (xpath = "//input[@data-ved='0ahUKEwiJ29fa68iLAxVpOTQIHU9uB8IQ4dUDCBM']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']" )
    public WebElement captcha;

    @FindBy (xpath = "//div[@class='wvKXQ']")
    public WebElement capital;

    public void handleReCaptcha(WebDriver driver, WebElement captchaElement) {

        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
            driver.switchTo().frame(iframe);

            if (captchaElement.isDisplayed()) {
                captchaElement.click();
            }
        } catch (Exception e) {
            System.out.println("Captcha handled");
        }
        driver.switchTo().defaultContent();

    }

}
