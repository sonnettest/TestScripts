package TestScript;

import org.testng.annotations.Test;

import com.base.SonnetTestNGBase;

public class DrvAcquent extends SonnetTestNGBase{
	private CreateRFQ create = new CreateRFQ();
	private SearchRFQ search = new SearchRFQ();
	
//For RFQ Description Mandatory feild Blank
    @Test(description="Create the RFQ",priority=1,enabled=true)
	public void CreateRFQmethod() throws Exception{
    	    create.initTestData();
	    create.acquentLogin();
	    create.requestForQuote(1);////For RFQ Description Mandatory feild Blank
	    create.errorRFQ();
	    create.requestForQuote(2);////For Unit Description Mandatory feild Blank
	    create.errorUnit();
	    create.requestForQuote(3);////For RFQ Description Mandatory feild Blank
	    create.successmsg();
	    
	   
     }   


	    

	
	

}
