package firstprgrm;

import org.openqa.selenium.chrome.ChromeDriver;

public class trial {

	public static void main(String[] args) {
		
		//1) Launch browser (chrome)
				ChromeDriver driver=new ChromeDriver();
				
				//Chrome Browser
				//WebDrver driver=new ChromeDriver(); //For chrome browser
				//WebDriver driver=new EdgeDriver();  //For Edge browser
				//WebDriver driver=new FirefoxDriver(); //For Forefox browser
				//ChromiumDriver driver=new ChromeDriver(); //For chrome browser
				
				
				//2) Open URL  https://demo.opencart.com/
				
				driver.get("https://demo.opencart.com/");
				
			/*	//3) Validate title should be   "Your Store"
				
				String act_title=driver.getTitle();
				
				if(act_title.equals("Your Store"))
				{
					System.out.println("Test Passed");
				}
				else
				{
					System.out.println("Test Failed");
				}
					
				
				//4) close browser
			//	driver.close();
				//driver.quit();*/
		
		
		
		
	}

}
