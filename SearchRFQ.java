package Cucumber.TestScript;

import org.openqa.selenium.By;

import com.base.webdriver.SonnetElement;

import cucumber.api.java.en.When;

public class SearchRFQ extends SonnetElement {
	@When("^enter search RFQ details$")
	public void enterRFQsearchDetails() {

	
		findElement(
				By.cssSelector("#left_navigation>ul>li>a[href='search.asp']"))
				.click();

		findElement(
				By.cssSelector(".tbl>tbody>tr:nth-child(2)>td>select[name=select]"))
				.selectByVisibleText("Closed");

		findElement(
				By.cssSelector(".tbl>tbody>tr:nth-child(3)>td:nth-child(2)>input"))
				.sendKeys("1234");// enter RFQ number

		findElement(
				By.cssSelector(".tbl>tbody>tr:nth-child(3)>td:nth-child(4)>input"))
				.sendKeys("RX1657");// enter part number

		findElement(
				By.cssSelector(".tbl>tbody>tr:nth-child(5)>td>select[name=select]"))
				.selectByVisibleText("Something");// select something in program
													// dropdown

		findElement(By.cssSelector(".tbl>tbody>tr:nth-child(6)>td>input"))
				.sendKeys("D01010101");// enter MGC textbox

		findElement(
				By.cssSelector(".tbl>tbody>tr:nth-child(7)>td:nth-child(2)>input"))
				.sendKeys("1063-Eaton");// enter supplier textbox

		findElement(
				By.cssSelector(".tbl>tbody>tr:nth-child(7)>td:nth-child(4)>input"))
				.sendKeys("Acquient");// enter stakeholder

		findElement(By.cssSelector(".tbl>tbody>tr:nth-child(8)>td>input"))
				.sendKeys("SomeOne");// enter assigned buyer

		findElement(By.cssSelector(".tbl>tbody>tr:nth-child(8)>td>select"))
				.selectByVisibleText("Published");

		// date range starting
		findElement(By.cssSelector("	tr>td:nth-child(1)>input#day")).sendKeys(
				"15");

		findElement(By.cssSelector("td:nth-child(1)>#select"))
				.selectByVisibleText("Feb");

		findElement(By.cssSelector("td:nth-child(1)>input#year")).sendKeys(
				"2015");

		// date range ending
		findElement(By.cssSelector("tr>td:nth-child(3)>input#day")).sendKeys(
				"31");

		findElement(By.cssSelector("td:nth-child(3)>#select"))
				.selectByVisibleText("Dec");

		findElement(By.cssSelector("td:nth-child(3)>input#year")).sendKeys(
				"2016");

		findElement(By.xpath("//td/div[@id='left_navigation'][1]/ul/li[4]/a"))
				.click();// click on Search RFQ link

	}

	



}
