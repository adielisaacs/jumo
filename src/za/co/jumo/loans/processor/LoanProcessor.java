/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.jumo.loans.processor;

import java.util.List;
import za.co.jumo.loans.dao.LoanDAO;
import za.co.jumo.loans.pojo.ComputedLoan;
import za.co.jumo.loans.pojo.Loan;
import za.co.jumo.loans.service.LoanService;
import za.co.jumo.loans.store.DataFileManager;

/**
 *
 * @author adiel
 */
public class LoanProcessor {
	LoanService loanExecution = new LoanDAO();
	
    public void loanProcess(){
        
        List<Loan> loandata = loanExecution.readLoanData();
        List<ComputedLoan> computedList = loanExecution.computeLoantotals(loandata);
        loanExecution.processLoanData(computedList, loandata);
        
    }
    public static void main(String[]agrs){
        LoanProcessor lp = new LoanProcessor();
        lp.loanProcess();
    }
}
