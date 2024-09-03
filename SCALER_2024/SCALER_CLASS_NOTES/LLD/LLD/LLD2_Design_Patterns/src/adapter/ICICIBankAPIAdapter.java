package adapter;

import adapter.thirdparty.ICICIBankAPI;

public class ICICIBankAPIAdapter implements BankAPI{

    ICICIBankAPI icicibankapi =new ICICIBankAPI();
    @Override
    public double getBalance(String accountNumber) {
        return 0;
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        return false;
    }
}
