package Demo1.SmokeSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Demo.AddToCart;

import Demo.BaseClass;

public class AmazonTestSuite extends BaseClass{
	
	
	AddToCart add=new AddToCart();
	
    @Test
    public void ChangeCountryTest() throws InterruptedException
    {
    	
    	add.changecountry();
    	extent.attachReporter(htlmReporter);
    	ExtentTest test=extent.createTest("Change the country to India");
    	test.log(Status.PASS, "Country changes to India");
    	test.log(Status.FAIL, "Country doesnt changes");
    }
    
    @Test
	public void AddToCartTest() throws InterruptedException, IOException
	{
		
		add.AddItem();
		extent.attachReporter(htlmReporter);
		ExtentTest test=extent.createTest("Add Items to cart");
    	test.log(Status.PASS, "Item Got added");
    	test.log(Status.FAIL, "Item doesnt added");
	}
    
}
