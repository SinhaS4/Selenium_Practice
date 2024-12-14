package Demo;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class AddToCart extends BaseClass {
	
	
	public void changecountry() throws InterruptedException
	{
		
		WebElement dropdown=driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[1]")); 
		Actions action=new Actions(driver);
		action.moveToElement(dropdown).build().perform();
		Thread.sleep(5000);
		WebElement Changecountry=driver.findElement(By.xpath("(//div[contains(text(),'Change country/region')])[1]"));
		Changecountry.click();
		Thread.sleep(1000);
		WebElement dd=driver.findElement(By.xpath("//span[@id='icp-dropdown']"));
		dd.click();
		WebElement countryname=driver.findElement(By.xpath("//ul[@class='a-nostyle a-list-link']/li[9]"));
		countryname.click();
		Thread.sleep(100);
		WebElement website=driver.findElement(By.xpath("//input[@class='a-button-input']"));
		website.click();
		Thread.sleep(100);
		Set<String> handles=driver.getWindowHandles();
		 Iterator it=handles.iterator();
		 String parentwindow=(String)it.next();
		 String childwindow=(String)it.next();
		 driver.switchTo().window(childwindow);
		
	}
	
	public void AddItem() throws InterruptedException, IOException
	{
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iphone");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(".//screenshot/amazon.png"));
	}

}
