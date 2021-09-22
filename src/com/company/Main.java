package com.company;

public class Main {

    public static void main(String[] args) {
        SavingAccount savings=new SavingAccount("trump",101,1000000, 0.02 );// this is trumps account
        savings.add_interest();// this is to add the interestrate
        System.out.println("the balance is: $" + savings.getBalance() );
        CheckingAccount checking=new CheckingAccount("trump ", 102, 100,savings);
        checking.MakeChek(1000);
        System.out.println("the savings balance is: $" + savings.getBalance() );
        System.out.println("the cheeking balance is: $" + checking.getBalance() );
	// write your code here
    }
}

class BankAccount{
    double balance;
    String owner;
    Integer accountID;
    public BankAccount(String owner, Integer accountID, double balance){
        this.owner=owner;
        this.accountID=accountID;
        this.balance=balance;

    }
public double getBalance(){
     return balance;
    }
    public void deposit(double amount){
        balance+=amount;// balance= balance+ amount
    }
    public boolean withdraw(double amount){
        boolean result = false;
        if (amount<=balance)
        {
          balance-=amount; //this is balance=-amoumt
            result =true;
        }


        return result;
    }
}
class SavingAccount extends BankAccount{
   double interest_rate;
   public SavingAccount(String owner, Integer accountID, double amount, double rate)
   {
     super(owner,accountID,amount);
     this.interest_rate=rate;
   }
   public void add_interest(){
    balance+=balance*interest_rate; // balance = balance
   }
}
class CheckingAccount extends BankAccount {
    SavingAccount overdraftaccount;

    public CheckingAccount(String owner, Integer accountID, double amount, SavingAccount od) {
        super(owner, accountID, amount);
        this.overdraftaccount = od;
    }

    public boolean MakeChek(double amount) {
        boolean result = false;
        if (super.withdraw(amount))
            result = true;
        else if (overdraftaccount.withdraw(amount - balance)) {
            balance = 0.0;
            result = true;

        }
        return result;
    }
}
