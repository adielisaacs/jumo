package co.za.afferent.service;

public class AfferentImpl implements AfferentService{
	Integer creditCardEndIndex = new Integer("0");
	double minutes;
	final long startTime = System.currentTimeMillis();
	
	public boolean performValidation(String messageFromCustomer)
	{
		
		String creditcard 	  = extractCreditCardNo(messageFromCustomer);
		String purchaseCentsAmount = extractPurchaseAmount(messageFromCustomer);
		
		Double purchaseRandValue = convertCentsToRands(purchaseCentsAmount);
		
		long endTime = System.currentTimeMillis();
		double calminutes = (int) (((endTime-startTime) / (1000*60)) % 60);
		setTimeInMinutes(calminutes);
		//check if amount is > R10 000
		//check if transtion > 1 hour
		if((purchaseRandValue < 10000) && (calminutes < 60)){
			return true;	
		}else{
			return false;
		}
		
	}
	    public double getTimeInMinutes(){
	    	return minutes;
		}
	    public void setTimeInMinutes(double newminutes){
	    	this.minutes = newminutes;
		}
		private String extractCreditCardNo(String message)
		{
			String ccIndex = message.substring(0, 2);
			creditCardEndIndex = new Integer(ccIndex);
			creditCardEndIndex = creditCardEndIndex +2;	
			String creditCardNo = message.substring(2, creditCardEndIndex);

			return creditCardNo;
		}
	
		private String extractPurchaseAmount(String message)
		{
			String paIndex = message.substring(creditCardEndIndex, (creditCardEndIndex+2));

			Integer purchaseAmountDigits = new Integer(paIndex);
			
			String purchaseAmount = message.substring((creditCardEndIndex+2), ((creditCardEndIndex+2)+purchaseAmountDigits));
			
			return purchaseAmount;
		}
		
		private double convertCentsToRands(String cents)
		{
			Double centVariant = new Double(cents);
			Double randVariant = (centVariant/ 100);
			return randVariant;
		}
	
	
	
}
