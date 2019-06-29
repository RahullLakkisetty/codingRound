import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends BaseUtility{
	
	private static WebDriver driver=null;

            @FindBy(linkText = "Flights")
	    private WebElement flightLink;
	 
	    @FindBy(linkText = "One Way")
	    private WebElement trip;

	    @FindBy(id = "FromTag")
	    private WebElement source;

	    @FindBy(id = "ToTag")
	    private WebElement destination;

	    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[6]/a")
		private WebElement departOn;
	    
	    @FindBy(id = "Adults")
	    private WebElement noOfPeople;
	    
	    @FindBy(id = "SearchBtn")
	    private WebElement searchFlights;
	
	    
	
	    @BeforeSuite	
	    public void intializeDriver() throws IOException
	    {
	    driver=UtilityBase.getWebDriver();
	    driver.get("https://www.cleartrip.com");
	    waitFor(2000);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    PageFactory.initElements(driver, this);   
	    }
	
	    @Test
	    public void testThatResultsAppearForAOneWayJourney() 
	    {
	    clickButton(flightLink);
	    clearBox(source);
	    enterText(source, "Bangalore",Keys.TAB);
	    clearBox(destination);
	    enterText(destination, "Delhi",Keys.TAB);
            clickButton(departOn);
	    selectDropDown(noOfPeople,"2");
	    clickButton(searchFlights);
	    System.out.println("Succesfully Booked your Flight"); 
	    Assert.assertTrue(isElementPresent(By.className("searchSummary"),driver));
	    }

            @AfterSuite
	    public void quitBrowser(){
	    {
	    driver.quit();
	    }

}
