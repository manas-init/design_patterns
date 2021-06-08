//package Bridge;

abstract class TV {
    public abstract void on();
    public abstract void off();
}

class SonyTv extends TV {
    Remote remote;
    
    public SonyTv(Remote remote) {
        this.remote = remote;
    }
    
    @Override
    public void on() {
        System.out.print("Sony tv on : ");
        remote.on();
    }
    
    @Override
    public void off() {
        System.out.print("Sony tv off : ");
        remote.off();
    }
}

class OnidaTv extends TV {
    Remote remote;
    
    public OnidaTv(Remote remote) {
        this.remote = remote;
    }
    
    @Override
    public void on() {
        System.out.print("Onida tv on : ");
        remote.on();
    }
    
    @Override
    public void off() {
        System.out.print("Onida tv off : ");
        remote.off();
    }
}

interface Remote {
    public void on();
    public void off();
}

class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("On with old remote");
    }
    
    @Override
    public void off() {
        System.out.println("Off with old remote");
    }
}

class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("On with new remote");
    }
    
    @Override
    public void off() {
        System.out.println("Off with new remote");
    }
}


public class BridgePatternSample {
    public static void main(String[] args) {
        Remote oldRemote = new OldRemote();
        Remote newRemote = new NewRemote();
        
        TV oldSonyTv = new SonyTv(oldRemote);
        TV oldOnidaTv = new OnidaTv(oldRemote);
        TV newSonyTv = new SonyTv(newRemote);
        TV newOnidaTv = new OnidaTv(newRemote);
        
        oldSonyTv.on();
        oldSonyTv.off();
        newSonyTv.on();
        newSonyTv.off();
        
        oldOnidaTv.on();
        oldOnidaTv.off();
        newOnidaTv.on();
        newOnidaTv.off();
    }
}
