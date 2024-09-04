package adapter;

import adapter.thirdparty.YesBankAPI;

public class YesBankAPIAdapter implements BankAPI {

    YesBankAPI yesBankAPI=new YesBankAPI();
    @Override
    public double getBalance(String accountNumber) {
        return yesBankAPI.fetchBalance(accountNumber);

    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
       return yesBankAPI.transfer(fromAccount, toAccount, amount);
    }
}
