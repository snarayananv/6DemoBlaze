package com.blaze;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeMain {

	@Test

	public void runBlaze() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.xpath("//a[text()='destination of the week! The Beach!']"));
		element.click();
		Thread.sleep(1000);
		driver.navigate().back();

		WebElement element2 = driver.findElement(By.name("fromPort"));
		Select s = new Select(element2);
		s.selectByVisibleText("San Diego");

		WebElement element3 = driver.findElement(By.name("toPort"));
		Select s1 = new Select(element3);
		s1.selectByVisibleText("Berlin");

		WebElement element4 = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		element4.click();

		List<WebElement> table = driver.findElements(By.tagName("td"));

		for (int i = 0; i < table.size(); i++) {

			WebElement webElement = table.get(i);
			String text = webElement.getText();
			if (text.equals("$200.98")) {

				System.out.println(text);
				System.out.println("row = "+(i+1));

			}

//		}
//
//			Select st = new Select(webElement);
//			List<WebElement> options = st.getOptions();
//
//			for (int j = 0; j < options.size(); j++) {
//
//				WebElement webElement2 = options.get(j);
//				String text = webElement2.getText();
//				System.out.println(text);
//			}

//			String text = webElement.getText();
//			
//			if (text.equals("value")) {
//
//				System.out.println(text);
//
//			}
//        
//        String text = webElement.getText();
//        System.out.println(text);

		}
	}
}
