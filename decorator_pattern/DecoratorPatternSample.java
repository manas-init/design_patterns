//package Decorator;

interface Dress {
    public void assemble();
}

class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("This is basic dress feature");
    }
}

class DressDecorator implements Dress {
    protected Dress dress;
    
    DressDecorator(Dress dress) {
        this.dress = dress;
    }
    
    @Override
    public void assemble() {
        this.dress.assemble();
    }
}


class FormalDress extends DressDecorator {
    FormalDress(Dress dress) {
        super(dress);
    }
    
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("This is formal dress decorator");
    }
}

class FancyDress extends DressDecorator {
    FancyDress(Dress dress) {
        super(dress);
    }
    
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("This is fancy dress decorator");
    }
}


class SportsDress extends DressDecorator {
    SportsDress(Dress dress) {
        super(dress);
    }
    
    @Override
    public void assemble() {
        super.assemble();
        System.out.println("This is sports dress decorator");
    }
}


public class DecoratorPatternSample {
    public static void main(String[] args) {
        Dress sportsDress = new SportsDress(new BasicDress());
        sportsDress.assemble();
        System.out.println();
        
        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();
        
        Dress formalDress = new FormalDress(new BasicDress());
        formalDress.assemble();
        System.out.println();
        
        Dress sportsFancyDress = new SportsDress(new FancyDress(new BasicDress()));
        sportsFancyDress.assemble();
        System.out.println();
        
        Dress formalSportsDress = new FormalDress(new SportsDress(new BasicDress()));
        formalSportsDress.assemble();
        System.out.println();
    }
}
