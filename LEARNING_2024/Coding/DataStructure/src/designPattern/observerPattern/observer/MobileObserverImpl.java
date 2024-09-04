package designPattern.observerPattern.observer;

import designPattern.observerPattern.observable.StockObservable;

public class MobileObserverImpl implements NotificationAlertObserver{


    StockObservable obv;
    
    String email;
    
    public MobileObserverImpl(StockObservable o, String email){
    	this.obv=o;
    	this.email=email;
    }
	public void update() {
		
		System.out.println("Notification came to Mobile Observer. Stock is available "+obv.getData());
		emailSent();
		
	}
	public void emailSent(){
		System.out.println("Email sent to" + email);
	}

}
