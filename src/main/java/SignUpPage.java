import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class,'setup-header')]//h1");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By emailField  =By.xpath("//input[@id='user_email']");
    private By passwordField =By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    private By mainError = By.xpath("//div[@class='flash flash-error my-3']");
    private By nameError = By.xpath("//dd[@id='description_f82cf5aef93f']");
    private By emailError = By.xpath("//dd[@id='description_63ae39d63530']");
    private By passwordError = By.xpath("//dd[@id='description_aac9336c0279']");

    public SignUpPage typeLogin (String login) {
        driver.findElement(userNameField).sendKeys(login);
        return this;
    }
    public SignUpPage typeEmail (String mail) {
        driver.findElement(emailField).sendKeys(mail);
        return this;
    }
    public SignUpPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignUpPage registerWithInvalidCreds (String login, String mail, String password){
        this.typeLogin(login);
        this.typeEmail(mail);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String GetHeadingText() {
        return driver.findElement(heading).getText();
    }
    public String GetMainErrorText() {
        return driver.findElement(mainError).getText();
    }
    public String GetNameErrorText() {
        return driver.findElement(nameError).getText();
    }
    public String GetEmailErrorText() {
        return driver.findElement(emailError).getText();
    }
    public String GetPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }
}
