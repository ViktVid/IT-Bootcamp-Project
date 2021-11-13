package pagesPackageProject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InteractionsPage {

	public WebDriver driver;
	public WebDriverWait wdwait;
	public Actions action;
	
	WebElement elements;
	WebElement draggable;
	WebElement dropHere;
	WebElement drop;
	WebElement textDroppable;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement interactionList;

	public InteractionsPage(WebDriver driver, WebDriverWait wdwait, Actions action) {
		this.driver = driver;
		this.wdwait = wdwait;
		this.action = action;
	}
	
	public WebElement getElements() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
		
	}
	
	public void clickElements() {
		this.getElements().click();
	}

	public List<WebElement> getNavigation() throws InterruptedException {
		WebElement interactions = driver.findElement(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(5)"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", interactions);
		Thread.sleep(500);
		return driver.findElements(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(5)"));
	}
	
	public void chooseTheElement() throws InterruptedException {
		this.getNavigation().get(0).click();
		} 

	public List<WebElement> getInteractionList() throws InterruptedException {
		WebElement interactionsItems = driver.findElement(By.id("item-3"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", interactionsItems);
		Thread.sleep(500);
		return driver.findElements(By.id("item-3"));
	}
	
	public void listOfInteractions (int i) throws InterruptedException {
		this.getInteractionList().get(i).click();
	} 
	
	
	// Ovde sam htela da dodam dva elementa, ovo je prvi:
	public WebElement getDraggable() throws InterruptedException {
		WebElement d = driver.findElement(By.id("draggable"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", d);
		 Thread.sleep(500);
		return driver.findElement(By.id("draggable"));
	}

	// Ovo je drugi:
	public WebElement getDropHere() {
		return driver.findElement(By.id("droppable"));
	}

	// Ovde sam htela da uhvatim jedan i prebacim u drugi, nisam uspela
	public void getDrop() throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.clickAndHold(draggable).moveToElement(dropHere).release(dropHere).build().perform();
	}

	// Ovo bi mi bila provera da je uspesno, odnosno tekst iz ovog elementa
	public WebElement getTextDroppable() {
		return driver.findElement(By.id("droppable"));
	}

	public void textDroppable() {
		this.getTextDroppable().getText();
	}
}
