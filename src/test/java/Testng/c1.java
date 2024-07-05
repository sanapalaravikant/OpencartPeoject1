package Testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class c1 {

	@Test
	void abc()
	{
		System.out.println(" this is abc from C1..");
	}
	
	@BeforeTest
	void bt()
	{
		System.out.println("this is BeforeTest method....");
	}
	
	
}


