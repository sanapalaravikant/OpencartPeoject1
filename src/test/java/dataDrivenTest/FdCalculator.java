package dataDrivenTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FdCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows=Utilityfile.getRowCount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//1) read data from excel
			String pric=Utilityfile.getCellData(filePath, "Sheet1",i,0);
			String rateofinterest=Utilityfile.getCellData(filePath, "Sheet1",i,1);
			String per1=Utilityfile.getCellData(filePath, "Sheet1",i,2);
			String per2=Utilityfile.getCellData(filePath, "Sheet1",i,3);
			String fre=Utilityfile.getCellData(filePath, "Sheet1",i,4);
			String exp_mvalue=Utilityfile.getCellData(filePath, "Sheet1",i,5);
			
			//2) pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); //clicked on calculate
			
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test passed");
				Utilityfile.setCellData(filePath, "Sheet1",i,7,"Passed");
				Utilityfile.fillGreenColor(filePath, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test failed");
				Utilityfile.setCellData(filePath, "Sheet1",i,7,"Failed");
				Utilityfile.fillRedColor(filePath, "Sheet1",i,7);
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // clicked on clear button
			
		} //ending of for loop
		
		driver.quit();


	}

}
