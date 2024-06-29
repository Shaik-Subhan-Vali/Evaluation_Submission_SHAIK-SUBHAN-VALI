package My_Package;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		//using implicit wait
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
        //sending input into drop downn
        driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Vijey Surya");
        
        Thread.sleep(3000);
        //clicking on vijey surya option
        driver.findElement(By.xpath("//span[text()=\"Vijey  Surya\"]")).click();

        Thread.sleep(3000);	
        //Fetching text from 1st status of the user 
		String statusmsg= driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[5]/div")).getText();
		System.out.println(statusmsg);
		//using testng assert and verifying with actual txt
		String exp ="Enabled";
		Assert.assertEquals(statusmsg, exp);
			
    }
    
    @AfterTest
    public void logout() {
    	
    	 driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click();
		 driver.findElement(By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]")).click();
    }

}












