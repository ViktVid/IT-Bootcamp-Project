package pagesPackageProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingAdBlock { 
	
// Ovu klasu sam htela da pozovem pre svake
// Trebalo je da doda AdBlock ekstenziju nakon otvaranja bazicnog URL-a, kako bi olaksao dalje kretanje kroz sajt
// Ova klasa mi nije uspela, ovo cu zavrsiti naknadno


	public static void main(String[] args) throws InterruptedException {

	// Setovanje klase i usmeravanje na google pretazivac:
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wdwait = new WebDriverWait(driver, 20);

		driver.navigate().to("https://www.google.com");
		
	// Klik na SearchBox i slanje texta Ad block, enter nakon toga za pretragu:	
		WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		searchBox.sendKeys("Ad Block");
		searchBox.sendKeys(Keys.ENTER);
		
	// Otvorili smo prvi AdBloker koji nam je google ponudio:
		Thread.sleep(500);
		WebElement adBlock = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div/div[1]/a/h3"));
		adBlock.click();
		
	// Kliknuli smo opciju "Dodaj ekstenziju":
		Thread.sleep(500);
		WebElement addingBlocker = driver.findElement(By.cssSelector("body > div.F-ia-k.S-ph.S-Rc-qa > div.h-F-f-k.F-f-k > div > div > div.e-f-o > div.h-e-f-Ra-c.e-f-oh-Md-zb-k > div"));
		addingBlocker.click();

	// Pozvali smo cekanje iskacuceg prozora kako bismo potvrdili dodavanje ekstenzije:
		wdwait.until(ExpectedConditions.alertIsPresent());
		
	// Preusmerili smo se na iskacuci prozor:
		Alert alert = driver.switchTo().alert();
		
	// Imamo opciju "Accept i Dismiss, mi biramo accept kako bismo odobrili dodavanje ekstenzije
		alert.accept();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
