package com.devops.dxc.devops.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumTest {
	 private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  
	@Test
	void testAhorroMayor() {
		int sueldo = 700000;
		int ahorro = 56500000;
		String diezObtenido="";
		String diezEsperado = String.valueOf(Util.getDxc(ahorro, sueldo)) ;
		System.out.println(diezEsperado);
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    driver.get("http://localhost:8081/");
	    //driver.manage().window().setSize(new Dimension(1900, 1020));
	    driver.findElement(By.id("input-5")).click();
	    driver.findElement(By.id("input-5")).sendKeys(String.valueOf(sueldo));
	    {
	      WebElement element = driver.findElement(By.cssSelector(".v-btn__content"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("input-9")).sendKeys(String.valueOf(ahorro));
		   
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".v-btn__content")).click();
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	
	
		By itemDiez = By.xpath("//*[@id=\'app\']/form/section[2]/table/tr[2]/td[1]");
		WebElement elementoDiez = driver.findElement(itemDiez);

	    WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElement(elementoDiez, String.valueOf(diezEsperado)));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoSaldo, saldoEsperado));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoImpuesto, impuestoEsperado));
	
		diezObtenido = elementoDiez.getText();
		
	    assertEquals(diezEsperado,diezObtenido );
	
	}
	
	@Test
	void testAhorroMenor() {
		int ahorro = 870000;
		int sueldo = 350000;
		String diezObtenido="";
		String diezEsperado = String.valueOf(Util.getDxc(ahorro, sueldo)) ;
		System.out.println(diezEsperado);
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    driver.get("http://localhost:8081/");
	    //driver.manage().window().setSize(new Dimension(1900, 1020));
	    driver.findElement(By.id("input-5")).click();
	    driver.findElement(By.id("input-5")).sendKeys(String.valueOf(sueldo));
	    {
	      WebElement element = driver.findElement(By.cssSelector(".v-btn__content"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("input-9")).sendKeys(String.valueOf(ahorro));
		   
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".v-btn__content")).click();
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	
	
		By itemDiez = By.xpath("//*[@id=\'app\']/form/section[2]/table/tr[2]/td[1]");
		WebElement elementoDiez = driver.findElement(itemDiez);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElement(elementoDiez, String.valueOf(diezEsperado)));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoSaldo, saldoEsperado));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoImpuesto, impuestoEsperado));
	
		diezObtenido = elementoDiez.getText();
		
	    assertEquals(diezEsperado,diezObtenido );
	
	}
	
	@Test
	void testAhorroMedio() {
		int ahorro = 8700000;
		int sueldo = 350000;
		String diezObtenido="";
		String diezEsperado = String.valueOf(Util.getDxc(ahorro, sueldo)) ;
		System.out.println(diezEsperado);
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    driver.get("http://localhost:8081/");
	    //driver.manage().window().setSize(new Dimension(1900, 1020));
	    driver.findElement(By.id("input-5")).click();
	    driver.findElement(By.id("input-5")).sendKeys(String.valueOf(sueldo));
	    {
	      WebElement element = driver.findElement(By.cssSelector(".v-btn__content"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("input-9")).sendKeys(String.valueOf(ahorro));
		   
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".v-btn__content")).click();
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	
	
		By itemDiez = By.xpath("//*[@id=\'app\']/form/section[2]/table/tr[2]/td[1]");
		WebElement elementoDiez = driver.findElement(itemDiez);

	    WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElement(elementoDiez, String.valueOf(diezEsperado)));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoSaldo, saldoEsperado));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoImpuesto, impuestoEsperado));
	
		diezObtenido = elementoDiez.getText();
		
	    assertEquals(diezEsperado,diezObtenido );
	
	}
	
	@Test
	void testGetImpuesto() {
		int ahorro = 8700000;
		int sueldo = 350000;
		String impuestoEsperado = String.valueOf((int)(Util.getImpuesto(ahorro, sueldo))) ;
		String impuestoObtenido="";
		System.out.println(impuestoEsperado);
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    driver.get("http://localhost:8081/");
	    //driver.manage().window().setSize(new Dimension(1900, 1020));
	    driver.findElement(By.id("input-5")).click();
	    driver.findElement(By.id("input-5")).sendKeys(String.valueOf(sueldo));
	    {
	      WebElement element = driver.findElement(By.cssSelector(".v-btn__content"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("input-9")).sendKeys(String.valueOf(ahorro));
		   
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".v-btn__content")).click();
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
		By itemImpuesto = By.xpath("//*[@id=\"app\"]/form/section[2]/table/tr[2]/td[3]");
		WebElement elementoImpuesto = driver.findElement(itemImpuesto);
	

	    WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoDiez, String.valueOf(diezEsperado)));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoSaldo, saldoEsperado));
		wait.until(ExpectedConditions.textToBePresentInElement(elementoImpuesto, impuestoEsperado));
	
		impuestoObtenido = elementoImpuesto.getText();
		
	    assertEquals(impuestoEsperado,impuestoObtenido );
	
	}
	
	@Test
	void testGetSaldoRestante() {
		int ahorro = 71400000;
		int sueldo = 1700000;
		String saldoEsperado = String.valueOf((int)(Util.getSaldoRestante(ahorro, sueldo))) ;
		String saldoObtenido="";
		System.out.println(saldoEsperado);
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	    driver.get("http://localhost:8081/");
	    //driver.manage().window().setSize(new Dimension(1900, 1020));
	    driver.findElement(By.id("input-5")).click();
	    driver.findElement(By.id("input-5")).sendKeys(String.valueOf(sueldo));
	    {
	      WebElement element = driver.findElement(By.cssSelector(".v-btn__content"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("input-9")).sendKeys(String.valueOf(ahorro));
		   
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector(".v-btn__content")).click();
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }

		By itemSaldo = By.xpath("//*[@id=\'app\']/form/section[2]/table/tr[2]/td[2]");
		WebElement elementoSaldo = driver.findElement(itemSaldo);

	    WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoDiez, String.valueOf(diezEsperado)));
		wait.until(ExpectedConditions.textToBePresentInElement(elementoSaldo, saldoEsperado));
		//wait.until(ExpectedConditions.textToBePresentInElement(elementoImpuesto, impuestoEsperado));
	
		saldoObtenido = elementoSaldo.getText();
		
	    assertEquals(saldoEsperado,saldoObtenido );
	}

}
