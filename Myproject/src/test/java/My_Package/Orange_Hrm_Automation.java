package My_Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_Hrm_Automation {
	
	//driver accessible to all methods in the class
	WebDriver driver;

	//using testng beforetest annotation for opening broswer and navigating to url
    @BeforeTest
    public void bfrtst() throws InterruptedException {
    	
    	
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //maximizing the window
		driver.manage().window().maximize();
		//pausing execution for 3 seconds
	    Thread.sleep(3000);
 
     
    }
    

    @Test
    public void login() throws InterruptedException, IOException {
    	
    	//sending input into username field
		driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //sending input into paswword field
		driver.findElement(By.name("password")).sendKeys("admin123"); 
		//clicking on submit button 
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		
    }

}
