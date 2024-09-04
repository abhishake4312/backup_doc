package designPattern.observerPattern.observable;

import java.util.ArrayList;
import java.util.List;

import designPattern.observerPattern.observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StockObservable{

	List<NotificationAlertObserver> listObs = new ArrayList<NotificationAlertObserver>();
	
	int currentStock=0;
	

	public void add(NotificationAlertObserver obs) {
		listObs.add(obs);
		
	}

	public void remove(NotificationAlertObserver obs) {
		listObs.remove(obs);
		
	}


	public void notifyObserver() {
	
		int i=0;
		for(NotificationAlertObserver obs: listObs){
			System.out.println("Sending notification to "+(i+1)+" Observer");
			obs.update();
			i++;
		}
		
	}


	public void setData(int newStock) {
		if(newStock>0){
			currentStock=newStock;
			notifyObserver();
		}
	
		
	}

	@Override
	public int getData() {
		// TODO Auto-generated method stub
		return currentStock;
	}

}
