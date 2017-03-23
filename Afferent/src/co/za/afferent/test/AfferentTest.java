package co.za.afferent.test;

import org.junit.Test;

import co.za.afferent.processor.AfferentExecution;
import co.za.afferent.service.AfferentImpl;
import co.za.afferent.service.AfferentService;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import junit.textui.TestRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AfferentTest {
	AfferentService testAfferent = new AfferentImpl();
	 
	@Test
    public void acceptanceTest() 
	{
		
		assertTrue (testAfferent.performValidation("151234123412341230510000"));
		
    }
	@Test
	public void errorTest() 
	{
		
		assertTrue (testAfferent.performValidation("151234123412341230510000"));
		
    }
	@Test
	public void testTime()
	{
		Runnable runA = new Runnable() {

	         public void run() {
	            try {
	            	testAfferent.performValidation("151234123412341230510000");
	            	assertSame(1.00, testAfferent.getTimeInMinutes());
	            } catch (Exception x) {
	               System.out.println("Exception thrown.");
	            }catch(AssertionError ae){
	            	System.out.println("AssertionException thrown.");
	            }
	         }
	      };
	      try {
	          Thread threadA1 = new Thread(runA, "A");
	         
	          //thread set o a  minute
	          threadA1.sleep(60000);
	          threadA1.start();
	       } catch (InterruptedException x) {
	       }
	       
	       
	}
	
}
