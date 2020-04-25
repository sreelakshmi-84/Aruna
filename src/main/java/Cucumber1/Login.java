package Cucumber1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.CSS, using = ".email")
    public WebElement usernameText;
    @FindBy(how = How.CSS, using = ".password")
    public WebElement passwordText;
    @FindBy(how = How.CSS, using = ".login-button")
    public WebElement login;
    @FindBy(how = How.TAG_NAME, using = "body")
    public WebElement bodyText;

    public void enterUsername(String uname) {
        wait = new WebDriverWait(driver, 10000);
        usernameText.sendKeys(uname);
    }

    public void enterPassword(String password) {
        wait = new WebDriverWait(driver, 10000);
        passwordText.sendKeys(password);
    }

    public void login() {
        wait = new WebDriverWait(driver, 10000);
        login.click();
    }

    public boolean VerifyMessage() {
        String Exp = "Welcome to our store";
        return bodyText.getText().contains(Exp);

    }

}


