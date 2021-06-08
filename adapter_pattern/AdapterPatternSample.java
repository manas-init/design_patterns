//package Adapter

interface WebDriver {
    public void getElement();
    public void selectElement();
}


class ChromeDrive implements WebDriver {
    
    @Override
    public void getElement() {
        System.out.println("Calling get element from chrome driver");
    }
    
    @Override
    public void selectElement() {
        System.out.println("Calling select element from chrome driver");
    }
}


class WebDriverAdapter implements WebDriver {
    SafariDriver safari;
    
    public WebDriverAdapter(SafariDriver safari) {
        this.safari = safari;
    }
    
    @Override
    public void getElement() {
        this.safari.findElement();
    }
    
    @Override
    public void selectElement() {
        this.safari.clickElement();
    }
}


class SafariDriver {
    public void findElement() {
        System.out.println("Calling findElement from safari driver");
    }
    
    public void clickElement() {
        System.out.println("Calling click element from safari driver");
    }
}


public class AdapterPatternSample {
    public static void main(String[] args) {
        ChromeDrive chrome = new ChromeDrive();
        chrome.getElement();
        chrome.selectElement();
        
        SafariDriver safari = new SafariDriver();
        WebDriverAdapter webAdapter = new WebDriverAdapter(safari);
        webAdapter.getElement();
        webAdapter.selectElement();
    }
}
