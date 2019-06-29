import java.io.IOException;
import com.sun.javafx.PlatformUtil;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SignInTest {
    
    	@FindBy(xpath = "//*[@id='userAccountLink']")
	    private WebElement yourTrips;
	    
	    @FindBy(xpath = "//*[@id='SignIn']")
	    private WebElement signIn;
	    
	    @FindBy(xpath = "//*[@id='modal_window']")
	    private WebElement modalWindow;
	    
	    @FindBy(xpath = "//*[@id='signInButton']")
	    private WebElement frameSignIn;
	    
	    @FindBy(id = "errors1")
	    private WebElement errorMessage;

        /*Intialize WebDriver from UtilityBase*/
	@BeforeSuite	
	public void intializeDriver() throws IOException {

	driver=UtilityBase.getWebDriver();
	driver.get("https://www.cleartrip.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	PageFactory.initElements(driver, this);


	}

        @Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing()
	{
	clickButton(yourTrips);
	clickButton(signIn);
	iFrame(modalWindow,driver);
	clickButton(frameSignIn);
	String errorMsg=getText(errorMessage);
	Assert.assertTrue(errorMsg.contains("There were errors in your submission"));	
	}
	
	@AfterSuite
	public void quitBrowser(){
	//To Close the web browser at the end of test.
	{
	driver.quit();
	}

   


}
