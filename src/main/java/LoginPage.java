import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id='login_field']");
    private By pasField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//input[@value='Sign in']");
    private By heading = By.xpath("//div[contains(@class,'auth-form-header')]/h1");
    private By error = By.xpath("//div[@id= 'js-flash-container']//div[@class='container']");
    private By createAccLink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(pasField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String login, String password) {
        this.typeLogin(login);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String GetHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String GetErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage CreateAccount() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

}
