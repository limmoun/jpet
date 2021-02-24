package eql.JpetStore;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JpetTest {

	WebDriver driver;

	@Before

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver2.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void TestJPetStore() throws Exception {

		driver.get("http://localhost:8090/jpetstore/");
		
		driver.findElement(By.xpath("//*[@id=\"Content\"]/p[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id='MenuContent']/a[2]")).click();
		
		WebElement elementlog = driver.findElement(By.xpath("//input[@name ='username']"));
		elementlog.clear();
		elementlog.sendKeys("ACID");

		WebElement elementMdp = driver.findElement(By.xpath("//input[@name ='password']"));
		elementMdp.clear();
		elementMdp.sendKeys("ACID");
		
		driver.findElement(By.xpath("//input[@name ='signon']")).click();

		assertTrue(driver.findElement(By.xpath("//a[@href='/jpetstore/actions/Account.action?signoff=\']")).isDisplayed());
		System.out.print("L'utilisateur ABC est bien connecté !");
			
		driver.findElement(By.xpath("//img[contains(@src, 'fish_icon')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'FI-SW-02')]")).click();
		

		driver.findElement(By.xpath("//a[@href='/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-3']")).click();

	}
	
	
	public void ecrireChampTxt (WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
		
	}
	

}
