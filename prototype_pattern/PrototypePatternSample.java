package Prototype;
import java.util.ArrayList;

class VehicleList implements Cloneable {
    ArrayList<String> list;
    
    public VehicleList() {
        this.list = new ArrayList<String>();
    }
    
    public VehicleList(ArrayList<String> list) {
        this.list = list;
    }
    
    public void addVehicles() {
        this.list.add("Audi A4");
        this.list.add("Honda Amaze");
        this.list.add("Hyundai Verna");
        this.list.add("Maruti Baleno");
    }
    
    public ArrayList<String> getList() {
        return this.list;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        ArrayList<String> temp = new ArrayList<String>();
        for(String s: this.getList()) {
            temp.add(s);
        }
        return new VehicleList(temp);
    }
}

public class PrototypePatternSample {
    public static void main(String[] args) throws CloneNotSupportedException {
        VehicleList a = new VehicleList();
        a.addVehicles();
        
        VehicleList b = (VehicleList) a.clone();
        System.out.println(b.getList());
        
        ArrayList<String> l = b.getList();
        l.add("duke");
        System.out.println(l);
        System.out.println(b.getList());
        System.out.println(a.getList());
    }
}
