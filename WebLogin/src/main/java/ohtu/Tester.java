package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/jtamland/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekaka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akke34p");
//        element = driver.findElement(By.name("login"));
//        
//        sleep(2);
//        element.submit();
//
//        sleep(3);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
       
        sleep(2);
        
        
        
        
        element = driver.findElement(By.name("username"));
        Random r = new Random();
        
        element.sendKeys("mattiLuukkainen"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("MattiLuukkainen");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("MattiLuukkainen");
        
        sleep(2);
        element = driver.findElement(By.name("signup"));
        element.submit();
        
        sleep(1);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        
        sleep(1);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        
        sleep(3);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
