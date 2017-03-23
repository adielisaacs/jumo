package co.za.afferent.processor;

import co.za.afferent.service.AfferentImpl;
import co.za.afferent.service.*;
public class AfferentExecution {
	
	public static void main(String agrs[])
	{
		AfferentService test = new AfferentImpl();
		boolean status = test.performValidation("151234123412341230510000");
		System.out.println("Process Validation:"+status);
	}
}
