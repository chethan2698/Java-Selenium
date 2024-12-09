package Selenium.testNg.Classes;

import org.testng.annotations.Factory;

public class FactoryClass {

	@Factory
	public Object[] factoryObjects() {

		return new Object[] { new FactoryTest("",""), new FactoryTest("",""), new FactoryTest("","") };
		 
	}

}
