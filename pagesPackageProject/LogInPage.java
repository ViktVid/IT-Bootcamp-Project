package pagesPackageProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

	public WebDriver driver;
	public WebDriverWait wdwait;
	JavascriptExecutor jse =(JavascriptExecutor) driver;
	WebElement homeBody;
	WebElement bookStoreApplication;

	public LogInPage(WebDriver driver, WebDriverWait wdwait) {
		this.driver = driver;
		this.wdwait = wdwait;
	}

	
	public void getHomeBody() throws InterruptedException {
		WebElement homeBodyCards = driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(6)"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeBodyCards);
		Thread.sleep(500);
		driver.findElements(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(6)"));
		homeBodyCards.click();
	}
	


}
