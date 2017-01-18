/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.jumo.loans.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import za.co.jumo.loans.pojo.ComputedLoan;
import za.co.jumo.loans.pojo.Loan;
import za.co.jumo.loans.service.LoanService;
import za.co.jumo.loans.store.DataFileManager;

/**
 *
 * @author adiel
 */
public class LoanDAO implements LoanService{

    DataFileManager dfm = new DataFileManager();
    
    @Override
    public List<Loan> readLoanData() {
        return dfm.readLoans();
    }

    public List<ComputedLoan> computeLoantotals(List<Loan> listLoan){
        
        List<ComputedLoan> comList = new ArrayList<ComputedLoan>();
        
        
        int i=1;
        
        for(Loan loan:listLoan){
        	Double total = new Double("0");
            String network = null ;
            ComputedLoan comLoan = new ComputedLoan();
            
            if(loan.getNetwork().equals("Network "+i)){
                network = loan.getNetwork();
                
                for(Loan loantotals:listLoan){
                    if(loantotals.getNetwork().equals("Network "+i)){
                    total = total + new Double(loantotals.getAmount());
                    }
                 }
                comLoan.setNetwork(network);
                comLoan.setTotal(total.toString());    
                comList.add(comLoan);
                
                i++;
                //total = new Double("0.00");
                //network="";
            }
                
        } 
        return comList;
    }

    @Override
    public void processLoanData(List<ComputedLoan> computedList, List<Loan> loanList) {
    	
    	try {
			dfm.writeLoans(computedList,loanList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

        
    
}
