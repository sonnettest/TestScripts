package TestScript;

import org.testng.annotations.Test;

import com.base.SonnetTestNGBase;

public class DrvAcquent extends SonnetTestNGBase{
	private CreateRFQ create = new CreateRFQ();
	private SearchRFQ search = new SearchRFQ();
	
    @Test(description="Create the RFQ",priority=1)
	public void CreateRFQmethod() throws Exception{
    	create.initTestData();
		create.acquentLogin();

	   create.requestForQuote();
		
	/*	create.parts();
		create.suppliers();
		create.publish();
		create.analyze();
	*/
    	
    
	}

	@Test(description="Search  the RFQ", priority=2)
	public void SearchRFQmethod() {
	

		/*search.enterRFQsearchDetails();
*/
	}
	
	

}
