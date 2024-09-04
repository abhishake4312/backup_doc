package designPattern.observerPattern;

import designPattern.observerPattern.observable.IphoneObservableImpl;
import designPattern.observerPattern.observable.StockObservable;
import designPattern.observerPattern.observer.MobileObserverImpl;
import designPattern.observerPattern.observer.NotificationAlertObserver;
import designPattern.observerPattern.observer.TVObserverImpl;

public class MainStock {

	public static void main(String[] args){
	StockObservable iPhoneObv1= new IphoneObservableImpl();
	StockObservable iPhoneObv2= new IphoneObservableImpl();
	
	NotificationAlertObserver mObs=new MobileObserverImpl(iPhoneObv2,"abc@gmail.com");
	
	NotificationAlertObserver tvObs=new TVObserverImpl(iPhoneObv1,"TV@gmail.com");
	
	iPhoneObv1.add(mObs);
	iPhoneObv1.add(tvObs);
	
	iPhoneObv1.setData(5);
	
	
	
	}
	
}
