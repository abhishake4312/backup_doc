package adapter;

public class PhonePe {

    BankAPI bankAPI;

    public PhonePe(BankAPI bankAPI) {
        this.bankAPI=bankAPI;
    }

    //Now phonepe doesnot have to care which bank adapter we are using no code change here
    public void doSomething(){
        bankAPI.getBalance("2546897");
    }
}
