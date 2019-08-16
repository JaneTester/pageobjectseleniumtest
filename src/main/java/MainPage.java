import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private By signInButton = By.xpath("//a[@href='/login']");
    private By signUpButton = By.xpath("(//a[@href='/join?source=header-home'])[1]");
    private By userLogin = By.xpath("//input[@id='user[login]']");
    private By userEmail = By.xpath("//input[@id='user[email]']");
    private By userPas = By.xpath("//input[@id='user[password]']");
    private By signUpFormButton = By.xpath("(//button[text()='Sign up for GitHub'])[1]");

    public LoginPage ClickSignIn (){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage ClicksignUpButton (){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage ClicksignUpFormButton (){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeLogin (String login) {
        driver.findElement(userLogin).sendKeys(login);
        return this;
    }
    public MainPage typeEmail (String mail) {
        driver.findElement(userEmail).sendKeys(mail);
        return this;
    }
    public MainPage typePassword (String password) {
        driver.findElement(userPas).sendKeys(password);
        return this;
    }

    public SignUpPage register (String login, String mail, String password) {
        this.typeLogin(login);
        this.typeEmail(mail);
        this.typePassword(password);
        this.ClicksignUpFormButton();
        return new SignUpPage (driver);
    }
}
