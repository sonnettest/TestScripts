package Cucumber.TestScript;

import org.openqa.selenium.By;















import com.base.AssertType;
import com.base.Attributes;
import com.base.webdriver.SonnetElement;
import com.lib.DataSource;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateRFQ extends SonnetElement {
	private DataSource ds = new DataSource();

	@Given("^System is configured$")
	public void initTestData() throws Exception{
		ds.GetCSVDataFile(_Properties.getProperty("create"));
	}
	
	@Given("^Login$")
	public void acquentLogin() {
		findElement(By.cssSelector("tr>td>input[name='USERNAME']")).sendKeys(_Properties.getProperty("Login"));
		findElement(By.name("PASSWORD")).sendKeys(_Properties.getProperty("password"));
		//findElement(By.name("login")).verify(AssertType.EQUAL_TEXT, "login","submit is not text");//;
		findElement(By.name("login")).click();
		
	
		
		//System.out.println(_Browser.findElement(By.cssSelector("")).getText());
	}

	
	@When("^enter requestForQuote details")
	public void requestForQuote() throws Exception {
	/*	findElement(By.xpath("//*[@href='/mockups/tcs2014/create_rfq.asp']"))
				.click();// create RFQ link after logging
*/
		ds.SetFilterTo(1);
		findElement(By.xpath("(//*[@class='tbl']//tr[3]/td[2])[1]/input"))
				.sendKeys(ds.GetData("description"));// RFQDescription

		findElement(By.xpath("(//*[@class='tbl']//tr[4]/td[2])[1]/textarea"))
				.sendKeys(ds.GetData("comments"));

		findElement(By.xpath("//*[@class='tbl']//tr[5]/td[2]/select"))
				.selectByVisibleText(ds.GetData("currency"));

		findElements(By.xpath("(//*[@class='tbl']//tr[6]/td[2])[1]//tbody/tr"))
				.selectWebElement(Attributes.TEXT,
						"Augusta / Commercial Products (US)");

		findElement(By.xpath("//*[@class='tbl']//tr[7]/td[2]/select"))
				.selectByVisibleText("Program 2");

		if (!findElement(By.xpath(" (//*[@name='02'])[1]")).isSelected())
			findElement(By.xpath(" (//*[@name='02'])[1]")).click();

		if (!findElement(By.xpath(" (//*[@name='02'])[2]")).isSelected())
			findElement(By.xpath(" (//*[@name='02'])[2]")).click();

		if (!findElement(By.xpath(" (//*[@name='01'])[1]")).isSelected())
			findElement(By.xpath(" (//*[@name='01'])[1]")).click();

		if (!findElement(By.xpath(" (//*[@name='01'])[2]")).isSelected())
			findElement(By.xpath(" (//*[@name='01'])[2]")).click();
       
	 	 findElement(By.cssSelector(".ui-datepicker-trigger")).click();
	 	 findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]/a")).click();
		
		/*findElement(By.id("day")).sendKeys("15");// set the day
		findElement(By.id("select")).selectByVisibleText("Jan");// set month
		findElement(By.id("year")).sendKeys("2017");// set year
*/		findElement(By.xpath("//*[@href='create_rfq_parts.asp']")).click();// click
																			// next
	}

	@And("^enter parts details")
	public void parts(){

		findElement(By.cssSelector(".no_border_w_top_pad>input"))
				.sendKeys(
						"C:\\Users\\sudharshan.r\\Desktop\\Desktop contents\\Penguins.jpg");

		entermainpartdetails();
		monthly();
		pricebreaks();
		editpartdetails();
		findElement(By.cssSelector(".aButton[href*=suppliers]")).click();

	}

	@And("^enter suppliers details")
	public void suppliers() {
		findElement(
				By.xpath("//td[@id='content_center']/table/tbody/tr[1]/td[4]/div/table/tbody/tr[1]/td[1]/input"))
				.click();

		findElement(
				By.xpath("//td[@id='content_center']/table/tbody/tr[1]/td[4]/div/table/tbody/tr[2]/td[1]/input"))
				.click();

		findElement(
				By.xpath("//td[@id='content_center']/table/tbody/tr[1]/td[4]/div/table/tbody/tr[3]/td[1]/input"))
				.click();

		findElement(
				By.xpath("//td[@id='content_center']/table/tbody/tr[1]/td[6]/div/table/tbody/tr[5]/td[1]/input"))
				.click();

		findElement(By.cssSelector(".aButton[href*=review]")).click();

	}

	@And("^enter publish details")
	public void publish() {
		findElement(By.xpath("//td[@id='content_center']/table[1]/tbody/tr[3]/td[2]/textarea")).sendKeys("Hello world");;
		findElement(By.cssSelector(".aButton[href*=analyze]")).click();
	}

	@And("^enter analyze details")
	public void analyze() {
		findElement(By.xpath("//*[@id='content_center']/input[1]")).click();
		findElement(By.cssSelector("#exPlus>a")).click();
		
		findElement(By.xpath("//div[@id='logPlus']/a")).click();  
		
		findElement(By.cssSelector("#exMinus>a")).click();
		findElement(By.xpath("//div[@id='logMinus']/a")).click();

	}
	
	
	
	
	
	

	public void entermainpartdetails() {
		
			findElement(By.cssSelector(".altRow:nth-child(1)>td>div>input"))
					.click();

			findElement(
					By.cssSelector(".altRow:nth-child(1)>td:nth-child(3)>input"))
					.sendKeys("RX800");

			findElement(
					By.cssSelector(".altRow:nth-child(1)>td:nth-child(4)>input"))
					.sendKeys("Rev123");

			findElement(
					By.cssSelector(".altRow:nth-child(1)>td:nth-child(5)>input"))
					.sendKeys("somepart");

			findElement(By.cssSelector(".altRow>td:nth-child(6)>select"))
					.selectByVisibleText("Experimental");

			findElement(
					By.cssSelector(".altRow:nth-child(1)>td:nth-child(9)>input"))
					.sendKeys("someMOQ");

			findElement(By.cssSelector(".altRow>td>select[name='LST_UNIT']"))
					.selectByVisibleText("Australia Branch");

		}

	public void pricebreaks() {
		findElement(
				By.xpath("//table[@class='alternateRows']//tbody//tr[1]/td[9]//a"))
				.click();
		findElement(
				By.xpath("//div[@id='TB_ajaxContent']//*[@class='tbl']//tr[1]//input"))
				.sendKeys("12");
		findElement(
				By.xpath("//div[@id='TB_ajaxContent']//*[@class='tbl']//tr[2]//input"))
				.sendKeys("22");
		findElement(
				By.xpath("//div[@id='TB_ajaxContent']//*[@class='tbl']//tr[3]//input"))
				.sendKeys("32");
		findElement(By.xpath("//a[@id='TB_closeWindowButton']")).click();
	}

public void monthly() {
	
		
		findElement(
				By.cssSelector("tr:nth-child(1)>td:nth-child(8)>a[title='Monthly EAU']"))
				.click();

		findElement(
				By.xpath("//div[@id='TB_ajaxContent']/div[2]/table/tbody/tr[1]/td[2]/input"))
				.sendKeys("1234");
		findElement(
				By.xpath("//div[@id='TB_ajaxContent']/div[2]/table/tbody/tr[11]/td[2]/input"))
				.sendKeys("5679");

		findElement(By.xpath("//a[@id='TB_closeWindowButton']")).click();
	}

	public void editpartdetails() {
		findElement(
				By.xpath("//td[@id='content_center']/table[2]/tbody/tr[3]/td[1]/a/img"))
				.click();

		findElement(
				By.xpath("//div[@id='TB_ajaxContent']/fieldset/table/tbody/tr[1]/td[2]/input[1]"))
				.sendKeys("some1234");

		findElement(
				By.xpath("//div[@id='TB_ajaxContent']/fieldset/table/tbody/tr[4]/td[2]/input[1]"))
				.click();

		findElement(
				By.xpath("//div[@id='TB_ajaxContent']/fieldset/table/tbody/tr[6]/td[2]/select"))
				.selectByVisibleText("Kgs");

		findElement(
				By.xpath("//div[@id='TB_ajaxContent']/table[2]/tbody/tr[3]/td[2]/select"))
				.selectByVisibleText("Full Disclosure");

		findElement(By.cssSelector("#TB_closeWindowButton")).click();
	}

	

	@Then("^Quit$")
	public void quit() throws Throwable {
		_Browser.close();
	}
 
	
}
