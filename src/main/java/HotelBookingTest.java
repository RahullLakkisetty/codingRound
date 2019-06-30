import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/* Intializes WebDriver, Automate HotelBooking Page and Closes web browser */
public class HotelBookingTest extedns UtilityBase {

	   private static WebDriver driver=null;
    
	   //Page Object Elements of HotelBooking Page
           @FindBy(linkText = "Hotels")
	   private WebElement hotelLink;

	   @FindBy(xpath = "//*[@id='Tags']")
	   private WebElement localityTextBox;
   
	   @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[6]/a")
	   private WebElement checkIn;
	   
	   @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[2]/a")
	   private WebElement checkOut;
	   
	   @FindBy(id = "//*[@id='SearchHotelsButton']")
	   private WebElement searchButton;

	   @FindBy(xpath = "//*[@id='travellersOnhome']")
	   private WebElement travellerSelection;
	
	
           //Intializes WebDriver from UtilityBase and opens Cleartrip website
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
    
	 //Opens Hotelbooking web page and searches Hotels in IndiraNagar
   	  @Test
	  public void shouldBeAbleToSearchForHotels() 
	  {
	  clickButton(hotelLink);
	  waitFor(2000);
	  enterText(localityTextBox, "Indiranagar, Bangalore",Keys.TAB);
	  clickButton(checkIn);
	  clickButton(checkOut);
	  selectDropDown(travellerSelection,"2 rooms, 4 adults");
          waitFor(2000);
	  clickButton(searchButton);  
	  }
	  
          	    
	  //Closes browser after executing test
	  @AfterSuite
	  public void quitBrowser()  
	  {
          driver.quit();
	  }

}
