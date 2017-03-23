package co.za.afferent.service;

public interface AfferentService {
		Integer creditCardEndIndex = new Integer("0");
		double minutes = new Double("0.00");
		final long startTime = System.currentTimeMillis();

		boolean performValidation(String messageFromCustomer);
	    public double getTimeInMinutes();
}
