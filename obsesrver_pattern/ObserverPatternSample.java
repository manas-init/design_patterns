//package observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    public void addObserver(Observer obs);
    public void removeObserver(Observer obs);
    public void notifyObserver();
}

class DeliveryData implements Subject {
    private ArrayList<Observer> observers;
    private String status;
    
    public DeliveryData() {
        this.observers = new ArrayList<Observer>();
    }
    
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }
    
    public void removeObserver(Observer obs) {
        this.observers.remove(obs);
    }
    
    public void notifyObserver() {
        for(Observer obs:this.observers) {
            obs.notify(getStatus());
        }
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        this.notifyObserver();
    }
}


interface Observer {
    public void notify(String s);
}

class Seller implements Observer {
    private String status;
    
    @Override
    public void notify(String newStatus) {
        System.out.println("Updating status("+newStatus+") of delivery to Seller");
    }
    
    public String getStatus() {
        return this.status;
    }
}

class Buyer implements Observer {
    private String status;
    
    @Override
    public void notify(String newStatus) {
        System.out.println("Updating status("+newStatus+") of delivery to Buyer");
    }
    
    public String getStatus() {
        return this.status;
    }
}

class Warehouse implements Observer {
    private String status;
    
    @Override
    public void notify(String newStatus) {
        System.out.println("Updating status("+newStatus+") of delivery to Warehouse");
    }
    
    public String getStatus() {
        return this.status;
    }
}


public class ObserverPatternSample {
    public static void main(String[] args) {
        DeliveryData deliveryStream = new DeliveryData();
        Buyer buyer = new Buyer();
        Seller seller = new Seller();
        Warehouse warehouse = new Warehouse();
        deliveryStream.addObserver(buyer);
        deliveryStream.addObserver(seller);
        deliveryStream.addObserver(warehouse);
        deliveryStream.updateStatus("delivered");
    }
}
