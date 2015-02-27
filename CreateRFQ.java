package TestScript;

import org.openqa.selenium.By;

import com.base.AssertType;
import com.base.webdriver.SonnetElement;
import com.lib.DataSource;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

public class CreateRFQ extends SonnetElement {
	DataSource ds = new DataSource();
	
	@Given("^I Open \"([^\"]*)\" browser$")
    public void OpenBrowser(String browserName) throws Exception {
           _DefaultRoot="D:\\automation\\Tcs";
            
           invokeBrowser(browserName);
           navigateTo(_Properties.getProperty("url"));
          
    }
	
	@Given("^System is configured$")
	public void initTestData() throws Exception{
		String csvpath = _Properties.getProperty("create");
		
		ds.GetCSVDataFile(csvpath);
	}
	
	@Given("^Login$")
	public void acquentLogin() {
		try{
		findElement(By.cssSelector("tr>td>input[name='USERNAME']")).sendKeys(_Properties.getProperty("Login"));
		findElement(By.name("PASSWORD")).sendKeys(_Properties.getProperty("password"));
		findElement(By.name("login")).click();
		findElement(By.name("Submit")).click();
		findElement(By.xpath("(//a[contains(@href, '#')])[3]")) .click();// create RFQ link after logging
		
	} catch(Exception e){
		e.printStackTrace();
	}
	}
	
	@When("^enter requestForQuote details with \"([^\"]*)\"$")
	public void requestForQuote(int datarow) throws Exception {
		
		ds.SetFilterTo(datarow);
		
		findElement(By.cssSelector("#rfqDescription"))
				.sendKeys(ds.GetData("description"));// RFQDescription
	  
		findElement(By.cssSelector("#rfqComment"))
		.sendKeys(ds.GetData("comments"));//Pass Comments 

	 
		findElement(By.cssSelector("#selectedCurrency")).selectByVisibleText(ds.GetData("currency")); //Pass Currency
		
		 findElement(By.cssSelector("#unitChkBox2")).click();//pass Units
		findElement(By.cssSelector("#selectedProgram")).selectByVisibleText("Select...");//Pass Program
		findElement(By.cssSelector("#partUsageBrkDwnInd1")) .click();//#partUsageBrkDwnInd0
		findElement(By.xpath("//tr[8]/td[2]/input[2]")).click();//Mark this as secured RFQ
		
		findElement(By.id("firstUseDate.dayVal")).sendKeys(ds.GetData("day"));//set the day
		findElement(By.id("firstUseDate.monVal")).selectByVisibleText("Feb");//set the Month
		findElement(By.id("firstUseDate.yearVal")).sendKeys(ds.GetData("year")); //set the Year
		
		findElement(By.xpath("//div[2]/a")).click();// click
	}                                                 
		
	@Then("^error message for RFQ")
    public void errorRFQ() throws Exception{
		String errormsgRFQ=(_Browser.findElement(By.id("error-list")).getText());
		//findElement(By.cssSelector("#error-list>li>label>strong")).verify(AssertType.EQUAL_VALUE,(ds.GetData("expmsg")),"Error Message for RFQ Validation");//Script is not working
		Assert.assertEquals(errormsgRFQ, (ds.GetData("expmsg")));
	}
	
	@Then("^error message for Unit")
    public void errorUnit()  throws Exception{
		Assert.assertEquals(_Browser.findElement(By.id("error-list")).getText(), (ds.GetData("expmsg")));
		//findElement(By.cssSelector("#error-list>li>label>strong")).verify(AssertType.EQUAL_VALUE,(ds.GetData("expmsg")),"Error Message FOR Unit Validation");//Script is not working	
	}
	
	@Then("^RFQ created successfully")
    public void successmsg()  throws Exception{
		String RFQvalue=_Browser.findElement(By.xpath("html/body/div[1]/form/div[2]/table/tbody/tr/td[2]/div[3]/table/tbody/tr[2]/td[2]")).getText();
		Assert.assertEquals(_Browser.findElement(By.id("alert_container")).getText()," - RFQ number "+RFQvalue+" created successfully");
	  //findElement(By.xpath("html/body/div[1]/form/div[2]/table/tbody/tr/td[2]/div[1]/div")).verify(AssertType.EQUAL_VALUE," - RFQ number "+RFQvalue+" created successfully","RFQ Verification");//Framework script is not working
	}

	@Then("^Quit$")
	public void quit() throws Throwable {
		_Browser.close();
	}
 	
	
}
