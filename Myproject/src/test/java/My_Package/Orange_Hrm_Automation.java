package My_Package;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void tc() throws InterruptedException, IOException {
    	//logging in
    	//sending input into username field
		driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //sending input into paswword field
		driver.findElement(By.name("password")).sendKeys("admin123"); 
		//clicking on submit button 
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		//clicked on admin
        driver.findElement(By.xpath("//a[@class=\"oxd-main-menu-item\"]")).click();
        //clicked on user management
        driver.findElement(By.xpath(" //span[@class=\"oxd-topbar-body-nav-tab-item\" and .='User Management ']")).click(); 
        //clicked on users
        driver.findElement(By.xpath("//a[@class=\"oxd-topbar-body-nav-tab-link\"]")).click();
        
      
        driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Vijey Surya");
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()=\"Vijey  Surya\"]")).click();
      
        
        
//		WebElement dropdown1 = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]"));
//		dropdown1.click();
//		driver.findElement(By.xpath("(//span[text()=\"Admin\"])[2]")).click();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("No.1 Hero");
//		
//		WebElement dropdown2 = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]"));
//		dropdown2.click();
//		driver.findElement(By.xpath("//span[text()=\"Enabled\"]")).click();
//		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--ghost\"]")).click();
//		
		
    }

}
