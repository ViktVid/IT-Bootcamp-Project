package pagesPackageProject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageElements {

	public WebDriver driver;
	public WebDriverWait wdwait;
	WebElement elements;
	WebElement textBox;
	WebElement username;
	WebElement email;
	WebElement currentAddress;
	WebElement permanentAddress;
	WebElement submit;
	WebElement outputProof;
	
	public PageElements(WebDriver driver, WebDriverWait wdwait) {
		this.driver = driver;
		this.wdwait = wdwait;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWdwait() {
		return wdwait;
	}

	// Kreiranje getera za karticu "Elements"
	public WebElement getElements() {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
		
	}

	// Geter za element "Text Box"
	public WebElement getTextBox() {
		return driver.findElement(By.className("text")); //  (By.id("item-0"))
	}

	// Geter za element "Username"
	public WebElement getUsername() {
		return driver.findElement(By.id("userName"));
	}

	// Geter za element "Email"
	public WebElement getEmail() {
		return driver.findElement(By.id("userEmail"));
	}

	// Geter za element "CurrentAddress"
	public WebElement getCurrentAddress() {
		return driver.findElement(By.id("currentAddress"));
	}

	// Geter za element "PermanentAddress"
	public WebElement getPermanentAddress() {
		return driver.findElement(By.id("permanentAddress"));
	}
	
	// Skrolovanje nanize, kako bismo pronasli i kliknuli dugme "Submit"
	public void getSubmit() throws InterruptedException {
		WebElement submit = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		Thread.sleep(500);
		driver.findElement(By.id("submit")).click();
	}

	// Pronalazak dokaza  da jeste sabmitovano (Podaci koje smo uneli su stampani ispod dugmeta "Submit", nakon klika na "Submit")
	public WebElement getOutputProof() {
		return driver.findElement(By.cssSelector(
				"div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.text-field-container form:nth-child(1) div.mt-4.row:nth-child(6) > div.border.col-md-12.col-sm-12"));

	}

	// Odabir kartice "Elements"
	public void clickElements() {
		this.getElements().click();
	}
	
	// Biranje "Teext Box" opcije iz padajuceg menija
	public void clickTextBox() {
		this.getTextBox().click();
	}

	public void insertUsername(String usernameData) {
		
		// Brisanje podataka iz polja "Username" - Za slucaj da su tu vec bili neki podaci
		this.getUsername().clear();
		
		// Slanje username-a iz Excel tabele
		this.getUsername().sendKeys(usernameData);
	}

	public void insertEmail(String emailData) {
		
		// Brisanje podataka iz polja "Email" - Za slucaj da su tu vec bili neki podaci
		this.getEmail().clear();
		
		// Slanje email-a iz Excel tabele
		this.getEmail().sendKeys(emailData);
	}

	public void insertCurrentAddress(String currentAddressData) {
		
		// Brisanje podataka iz polja "Current Address" - Za slucaj da su tu vec bili neki podaci
		this.getCurrentAddress().clear();
		
		// Slanje podataka o trenutnoj adresi iz Excel tabele
		this.getCurrentAddress().sendKeys(currentAddressData);
	}

	public void insertPermanentAddress(String permanentAddressData) {
		
		// Brisanje podataka iz polja "Permanent Address" - Za slucaj da su tu vec bili neki podaci
		this.getPermanentAddress().clear();
		
		// Slanje podataka o stalnoj adresi iz Excel tabele
		this.getPermanentAddress().sendKeys(permanentAddressData);
	}

}
