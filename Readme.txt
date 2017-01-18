---------------------------
Loan Accounting Application 
done by Adiel Isaacs
---------------------------

1. The language used is Java and the reason for this is that Java is cross platformed,robust
   and scalable for large processing power.

2. The application design follows a strict basic SOA design pattern. which allows the application
   scallability to expand,mutate,change and advance into various realms of technology stacks/vendors,
   whilst keeping its functionality in a Object Orientated design.
   
3. The Structure of the app is depicted below:

			LoanProcessor.java(executable)
					|
					|
			LoanService.java
					|
			LoanDAO.java 
					|
					|
		    ----------------------
		    |         |			  |
DataFileManager.java  |			  |
					  |		   Loan.java
					  |		   
				ComputedLoan.java	 
				
4. To run , just execute the LoanProcessor.java OR execute the RunJumo.jar Jar file included in the dist folder.
   viola !