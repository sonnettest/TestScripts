package Cucumber.TestScript;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.SonnetTestNGBase;

public class DrvAcquent extends SonnetTestNGBase {
	CreateRFQ create = new CreateRFQ();
	SearchRFQ search = new SearchRFQ();
	@BeforeMethod 
    public void testSetup() { 
            if (_IsBrowserClosed) { 
                    _Browser = invokeBrowser(_Properties.getProperty("browser")); 
                    _Browser.get(_Properties.getProperty("url")); 
                    _Browser.manage().window().maximize(); 
                    _IsBrowserClosed = false;
                    create.acquentLogin();
            } 
    }

	
    @Test(description="Create the RFQ", priority=1)
	public void CreateRFQ() throws InterruptedException {
		
	
		create.requestForQuote();
		create.parts();
		create.suppliers();
		create.publish();
		create.analyze();
	
    	
    
	}

	@Test(description="Search  the RFQ", priority=2)
	public void SearchRFQ() {
	

		search.enterRFQsearchDetails();

	}
	
	

}
