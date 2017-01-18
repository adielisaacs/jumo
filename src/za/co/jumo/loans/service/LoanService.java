/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.jumo.loans.service;

import java.util.List;
import za.co.jumo.loans.pojo.ComputedLoan;
import za.co.jumo.loans.pojo.Loan;

/**
 *
 * @author adiel
 */
public interface LoanService {
    
    public List<Loan> readLoanData();
    
    public List<ComputedLoan> computeLoantotals(List<Loan> listLoan);
    
    /**
     *
     * @param computedList
     * @param computedList
     */
    public void processLoanData(List<ComputedLoan> computedList,List<Loan> loanList);
}
