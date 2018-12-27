/*1)Create a Class SavingAccount with field�s acc_balance, acc_ID, accountHoldername, isSalaryAccount. Also add setter and 
	getter methods with business method like withdraw and deposit.
a.	Create 5 different object of SavingAccount and add them into ArrayList, now interate the arraylist and display all 
	SavingAccount�s object one by one.
b.	Now save the ArrayList which contains SavingAccount�s object into a file and read the file and display all savingAccount
	Object one by one.
c.	Create class BankAccountList which will maintain SavingAccount objects. Ensure that this class should not allow duplicates 
	as well as data should be displayed in sorted order. (as per acc_ID)  */
//-----------------------------------------------------------------------------------------------------------------------------

package com.capgemini.advancedCollectionAssignment;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author tushar used to test the account list is sorted.
 */
public class TestOfBankAccount {
	private SavingAccount accountOne;
	private SavingAccount accountTwo;
	private SavingAccount accountThree;
	private SavingAccount accountFour;
	private SavingAccount accountFive;
	private ArrayList<SavingAccount> accountList;

	@Before
	public void setUp() {
		accountList = new ArrayList<SavingAccount>();

		accountOne = new SavingAccount(15000, "Tushar", true);
		accountTwo = new SavingAccount(20000, "Anil", true);
		accountThree = new SavingAccount(30000, "Kamlesh", true);
		accountFour = new SavingAccount(10000, "sagar", true);
		accountFive = new SavingAccount(12000, "Shubham", true);
	}

	@Test
	public void testForIterators() {

		accountList.add(accountOne);
		accountList.add(accountTwo);
		accountList.add(accountThree);
		accountList.add(accountFour);
		accountList.add(accountFive);
		Iterator<SavingAccount> account = ((List<SavingAccount>) accountList)
				.iterator();
		while (account.hasNext()) {
			String expected = "[SavingAccount [accountBalance=15000.0, acountHolderName=Tushar, isSalary=true], SavingAccount [accountBalance=20000.0, acountHolderName=Anil, isSalary=true], SavingAccount [accountBalance=30000.0, acountHolderName=Kamlesh, isSalary=true], SavingAccount [accountBalance=10000.0, acountHolderName=sagar, isSalary=true], SavingAccount [accountBalance=12000.0, acountHolderName=Shubham, isSalary=true]]";
			assertEquals(expected, accountList.toString());
		}
	}

	@Test
	public void testOffileOfSavingAccount() {

		accountList.add(accountOne);
		accountList.add(accountThree);
		accountList.add(accountFour);
		accountList.add(accountFive);

		SavingAccount fileAccount = new SavingAccount(1200, "rohan", false);
		try {
			fileAccount.writeFile(accountList);
			String expected = "[SavingAccount [accountBalance=15000.0, acountHolderName=Tushar, isSalary=true], SavingAccount [accountBalance=30000.0, acountHolderName=Kamlesh, isSalary=true], SavingAccount [accountBalance=10000.0, acountHolderName=sagar, isSalary=true], SavingAccount [accountBalance=12000.0, acountHolderName=Shubham, isSalary=true]]";

			try {
				assertEquals(expected, fileAccount.readFile().toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOfAccountList() {		//test for account list is not contain repetition and sort by name.
		accountList.add(accountOne);
		accountList.add(accountTwo);
		accountList.add(accountThree);
		accountList.add(accountFour);
		accountList.add(accountFive);
		accountList.add(accountOne);
		accountList.add(accountTwo);
		BankAccountList list = new BankAccountList();
		String expected = "[SavingAccount [accountBalance=20000.0, acountHolderName=Anil, isSalary=true], SavingAccount [accountBalance=30000.0, acountHolderName=Kamlesh, isSalary=true], SavingAccount [accountBalance=12000.0, acountHolderName=Shubham, isSalary=true], SavingAccount [accountBalance=15000.0, acountHolderName=Tushar, isSalary=true], SavingAccount [accountBalance=10000.0, acountHolderName=sagar, isSalary=true]]";
		assertEquals(expected, list.listOfClients(accountList).toString());
	}
}
