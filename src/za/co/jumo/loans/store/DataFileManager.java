/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.jumo.loans.store;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import za.co.jumo.loans.pojo.ComputedLoan;
import za.co.jumo.loans.pojo.Loan;

public class DataFileManager {
 

    public List<Loan> readLoans(){

        String csvFile ="\\Loans.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Loan> loanList = new ArrayList();
        System.out.println(""+System.getProperty("java.class.path")+csvFile);
        try {
            //MSISDN,Network,Date,Product,Amount
            br = new BufferedReader(new FileReader(System.getProperty("java.class.path")+csvFile));
            while ((line = br.readLine()) != null) {
                Loan loan = new Loan();
               
                // use comma as separator
                String[] loanSplit = line.split(cvsSplitBy);
                
                 loan.setMsisdn(loanSplit[0]);
                 loan.setNetwork(loanSplit[1].replaceAll("'", ""));
                 loan.setDate(loanSplit[2].replaceAll("'", ""));
                 loan.setProduct(loanSplit[3].replaceAll("'", ""));
                 loan.setAmount(loanSplit[4]);
                 System.out.println( loan);

                 loanList.add(loan);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return loanList;
    }

    public void writeLoans(List<ComputedLoan> computedList, List<Loan> loanList) throws IOException{
        String csvFile = "Output.csv";
        FileWriter writer = new FileWriter(csvFile);
        
        for(ComputedLoan loanComputed :computedList){
            writer.append(loanComputed.getNetwork());
            writer.append(",");
            writer.append(loanComputed.getTotal());
            writer.append("\n");
            writer.append("\n");
            
            for(Loan loan : loanList){
            	if(loan.getNetwork().equals(loanComputed.getNetwork())){
            		writer.append(loan.getProduct());
                    writer.append(",");
                    writer.append(loan.getDate());
                    writer.append(",");
                    writer.append(loan.getAmount());
                    writer.append("\n");
            	}
            }
            writer.append("\n");
        }  

        writer.flush();
        writer.close();
    }
    
    
}

