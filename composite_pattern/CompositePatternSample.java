//pattern composite;

import java.util.List;
import java.util.ArrayList;

abstract class Account {
    public abstract float getBalance();
}


class SavingsAccount extends Account {
    float balance;
    String accountNo;
    
    SavingsAccount(String accountNo, float balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    public float getBalance() {
        return this.balance;
    }
    
    public void setBalance(float amount) {
        this.balance = amount;
    }
    
    public String getAccountNumber() {
        return this.accountNo;
    }
}


class SalaryAccount extends Account {
    float balance;
    String accountNo;
    
    SalaryAccount(String accountNo, float balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    public float getBalance() {
        return this.balance;
    }
    
    public void setBalance(float amount) {
        this.balance = amount;
    }
    
    public String getAccountNumber() {
        return this.accountNo;
    }
}


class CompositeAccount extends Account {
    ArrayList<Account> accounts;
    
    CompositeAccount() {
        accounts = new ArrayList<Account>();
    }
    
    public void addAccount(Account acc) {
        this.accounts.add(acc);
    }
    
    public float getBalance() {
        float total = 0;
        for(Account acc: accounts) {
            total += acc.getBalance();
        }
        return total;
    }
}


public class CompositePatternSample {
    public static void main(String[] args) {
        CompositeAccount myAcc = new CompositeAccount();
        myAcc.addAccount(new SalaryAccount("1234", 100));
        myAcc.addAccount(new SavingsAccount("5678", 20));
        System.out.println(myAcc.getBalance());
    }
}
