package pagesPackageProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPageSadPath {

	// Ovom klasom proveravam da li ce se boja teksta na dugmetu promeniti ukoliko kliknemo dugme "Color Change"
	// To se nece desiti, jer se boja menja iskljucivo automatski nakon 5 sek
	// Korisnik ocekuje da se boja promeni odmah nakon klika na dugme
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	WebElement elements;
	WebElement DynamicProperties;
	WebElement colorChange;
	WebElement visibleAfter5Seconds;
	
	public DynamicPropertiesPageSadPath(WebDriver driver, WebDriverWait wdwait) {
		this.driver = driver;
		this.wdwait = wdwait;
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWdwait() {
		return wdwait;
	}
	
	// Kreiranje getera za WebElement koji se zove "Elements" 
	public WebElement getElements() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
	}
	
	// Kreiranje getera za WebElement koji se zove "DynamiProperties"
	public void getDynamicProperties() throws InterruptedException {
		WebElement dynamicProperties = driver.findElement(By.id("item-8"));
		
		// Skrolovanje dok element "DynamicProperties" ne bude vidljiv
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicProperties);
		Thread.sleep(500);
		
		// Pozivanje istog elementa putem ID-a i klik istog elementa
		 driver.findElement(By.id("item-8")).click();
	}
	
	// Kreiranje getera za WebElement koji se zove "ColorChange" 
	public WebElement getColorChange() {
		return driver.findElement(By.id("colorChange"));
	}

	// Geter za dugme "Visible After 5 Seconds", jer se to dugme pojavljuje tek nakon promenjene boje
	// Ovo radimo kako bismo utvrdili da boja jeste promenjena
	public WebElement getVisibleAfter5Seconds() {
		return visibleAfter5Seconds;
	}

	// Klik na karticu "Elements"
	public void clickElements() {
		this.getElements().click();
	}
	
	// Klik na karticu "Color Change"
	public void clickColorChange() {
		this.getColorChange().click();
	}
	
	// Cekamo da se pojavi dugme "Visible After 5 Seconds"
	public void waiter(WebElement visibilityButton) throws InterruptedException {
		wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
	}
}
