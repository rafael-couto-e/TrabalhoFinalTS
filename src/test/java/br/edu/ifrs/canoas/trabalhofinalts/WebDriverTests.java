package br.edu.ifrs.canoas.trabalhofinalts;

import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTests {
    private static WebDriver chromeDriver;
    
    public WebDriverTests() {
    }
    
    @BeforeClass
    public static void init(){
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir")+File.separator+"chromedriver"
        );
        
        chromeDriver = new ChromeDriver();
    }
    
    @Test
    public void cdu1p(){
        
    }
    
    @Test
    public void cdu1a1(){
        
    }
    
    @Test
    public void cdu1a2(){
        
    }
    
    @Test
    public void cdu1a3(){
        
    }
    
    @Test
    public void cdu2P(){
        
    }
    
    @Test
    public void cdu3P(){
        
    }
    
    @Test
    public void cdu3a1(){
        
    }
    
    @Test
    public void cdu3a2(){
        
    }
    
    @Test
    public void cdu3a3(){
        
    }
    
    @Test
    public void cdu4P(){
        
    }
    
    @Test
    public void cdu4a1(){
        
    }
    
    @Test
    public void cdu4a2(){
        
    }
    
    @Test
    public void cdu4a3(){
        
    }
    
    @Test
    public void cdu4a4(){
        
    }
    
    @Test
    public void cdu5P(){
        
    }
    
    @Test
    public void cdu5a1(){
        
    }
    
    @Test
    public void cdu5a2(){
        
    }
    
    @Test
    public void cdu5a3(){
        
    }
    
    @Test
    public void cdu5a4(){
        
    }
    
    @Test
    public void cdu6P(){
        
    }
    
    @Test
    public void cdu6a1(){
        
    }
    
    @Test
    public void cdu6a2(){
        
    }
    
    @Test
    public void cdu6a3(){
        
    }
    
    @Test
    public void cdu7P(){
        
    }
    
    @Test
    public void cdu7a1(){
        
    }
    
    @Test
    public void cdu7a2(){
        
    }
    
    @Test
    public void cdu7a3(){
        
    }
    
    @Test
    public void cdu8P(){
        
    }
    
    @Test
    public void cdu8a1(){
        
    }
    
    @Test
    public void cdu8a2(){
        
    }
    
    @Test
    public void cdu8a3(){
        
    }
}