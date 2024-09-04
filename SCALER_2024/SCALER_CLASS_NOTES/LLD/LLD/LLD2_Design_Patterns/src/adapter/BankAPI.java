package adapter;

public interface BankAPI {

  double getBalance(String accountNumber);

  public boolean sendMoney(String fromAccount,String toAccount, double amount);


}
