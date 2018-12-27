/*1)Create a Class SavingAccount with fields acc_balance, acc_ID, accountHoldername, isSalaryAccount. Also add setter and 
  	getter methods with business method like withdraw and deposit.
a.	Create 5 different object of SavingAccount and add them into ArrayList, now interate the arraylist and display all 
	SavingAccounts object one by one.
b.	Now save the ArrayList which contains SavingAccounts object into a file and read the file and display all savingAccount 
	Object one by one.
c.	Create class BankAccountList which will maintain SavingAccount objects. Ensure that this class should not 
	allow duplicates as well as data should be displayed in sorted order. (as per acc_ID)  */
//--------------------------------------------------------------------------------------------------------------------------------------------

package com.capgemini.advancedCollectionAssignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Tushar SavingAccount defines the accountId,name,salary of customer.
 *
 */
public class SavingAccount implements Serializable, Comparable<SavingAccount> {
	private double accountBalance;
	static double accountId;
	private String accountHolderName;
	private boolean isSalary;

	static {
		accountId = 1200500;
	}
	{
		accountId++;
	}

	public SavingAccount(double accountBalance, String acountHolderName,
			boolean isSalary) { // constructor initialize account details.
		super();
		this.accountBalance = accountBalance;
		this.accountHolderName = acountHolderName;
		this.isSalary = isSalary;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public String getAcountHolderName() {
		return accountHolderName;
	}

	public boolean isSalary() {
		return isSalary;
	}

	public double withdraw(double amount) { // withdraw amount.
		return accountBalance - amount;
	}

	public double deposit(double amount) { // deposit amount.
		return accountBalance + amount;
	}

	/**
	 * 
	 * @param accountList
	 * @throws IOException
	 *             writeFile is used to create file and write account details.
	 */
	public void writeFile(ArrayList<SavingAccount> accountList)
			throws IOException {
		File file = new File("C:/Users/tudeore/Desktop/tudeore.txt");
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream fileOut = new ObjectOutputStream(fout);
		fileOut.writeObject(accountList);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *             readFile is used to read the file of customers.
	 */
	public ArrayList<SavingAccount> readFile() throws IOException,
			ClassNotFoundException { // Read file.
		String fileName = "C:/Users/tudeore/Desktop/tudeore.txt";
		File file = new File(fileName);
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream outputIn = new ObjectInputStream(fileIn);

		ArrayList<SavingAccount> accountList = (ArrayList<SavingAccount>) outputIn
				.readObject();
		return accountList;

	}

	@Override
	public String toString() {
		return "SavingAccount [accountBalance=" + accountBalance
				+ ", acountHolderName=" + accountHolderName + ", isSalary="
				+ isSalary + "]";
	}

	@Override
	public int compareTo(SavingAccount arg0) {
		return this.accountHolderName.compareTo(arg0.accountHolderName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accountHolderName == null) ? 0 : accountHolderName
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavingAccount other = (SavingAccount) obj;
		if (accountHolderName == null) {
			if (other.accountHolderName != null)
				return false;
		} else if (!accountHolderName.equals(other.accountHolderName))
			return false;
		return true;
	}

}
