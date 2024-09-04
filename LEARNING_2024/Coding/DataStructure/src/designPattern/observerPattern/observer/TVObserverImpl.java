package designPattern.observerPattern.observer;

import designPattern.observerPattern.observable.StockObservable;

public class TVObserverImpl  implements NotificationAlertObserver {

        StockObservable obv;
        String email;
	    
        public TVObserverImpl(StockObservable o, String email){
	    	this.obv=o;
	    	this.email=email;
	    }
		public void update() {

			System.out.println("Notification came to TV Observer. Stock is available "+obv.getData());
			emailSent();
			
		}
		public void emailSent(){
			System.out.println("Email sent to" + email);
		}
}
