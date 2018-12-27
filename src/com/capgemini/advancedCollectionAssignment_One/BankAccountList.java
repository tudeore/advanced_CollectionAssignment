package com.capgemini.advancedCollectionAssignment;

import java.util.ArrayList;
import java.util.TreeSet;
/**
 * 
 * @author Tushar
 *avoid the duplicates in the list.
 */
public class BankAccountList {

	public TreeSet<SavingAccount> listOfClients(			//convert Array list into tree set. 
			ArrayList<SavingAccount> accountList) {

		TreeSet<SavingAccount> set = new TreeSet<SavingAccount>(accountList);
		System.out.println(set.toString());
		return set;
	}

	@Override
	public String toString() {
		System.out.println("BankAccountList [toString()=" + super.toString()
				+ "]");
		return "BankAccountList [toString()=" + super.toString() + "]";
	}
}
