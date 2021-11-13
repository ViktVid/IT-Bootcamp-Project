package pagesPackageProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsPage {
	
	
	public WebDriver driver;
	public WebDriverWait wdwait;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	WebElement elements;
	WebElement forms;
	WebElement practiceForm;
	
	WebElement firstName;
	WebElement lastName;
	WebElement email;
	WebElement gender;
	WebElement mobileNumber;
	WebElement dateOfBirth;
	WebElement subject;
	WebElement choosePicture;
	WebElement hobbies;
	WebElement picture;
	WebElement currentAddress;
	WebElement state;
	WebElement city;
	
	WebElement submit;
	
	WebElement proof;
	
	public FormsPage(WebDriver driver, WebDriverWait wdwait) {
		this.driver = driver;
		this.wdwait = wdwait;
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWdwait() {
		return wdwait;
	}
	
	public WebElement getElements() {
		return driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1) > div > div.card-up"));
		
	}
	
	public void clickElements() {
		this.getElements().click();
	}

	public List<WebElement> getNavigation() throws InterruptedException {
		WebElement forms = driver.findElement(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2)"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forms);
		Thread.sleep(500);
		return driver.findElements(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2)"));
	}
	
	public void chooseTheElement() throws InterruptedException {
		this.getNavigation().get(0).click();
		} 

	public List<WebElement> getInteractionList() throws InterruptedException {
		WebElement interactionsItems = driver.findElement(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", interactionsItems);
		Thread.sleep(500);
		return driver.findElements(By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div"));
	}
	
	public void listOfForms (int i) throws InterruptedException {
		this.getInteractionList().get(i).click();
	} 
	
	
/*	public void getForms() throws InterruptedException {
		driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(2) > div")); 
		Actions actions = new Actions(driver); 
		actions.moveToElement(forms); 
		actions.perform();
		this.getForms();
	}
	
	public void clickForms() {
		this.clickForms();
	}
	*/
	
	public WebElement getFirstName() {
		driver.findElement(By.cssSelector("#firstName"));
		jse.executeScript("arguments[0].scrollIntoView(true);", firstName);
		return driver.findElement(By.cssSelector("#firstName"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.id("lastName"));
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.id("userEmail"));
	}
	
	public WebElement getGender() {
		return driver.findElement(By.id("gender-radio-2"));
	}
	
	public WebElement getMobileNumber() {
		return driver.findElement(By.id("userNumber"));
	}
			
//		int size = driver.findElements(By.tagName("iframe")).size();
//		return (WebElement) driver.switchTo().frame(6);

	public WebElement getDateOfBirth() {
		return dateOfBirth;
	}

	public WebElement getSubject() {
		return driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]"));
	}
	
	public WebElement getChoosePicture() {
		return driver.findElement(By.id("uploadPicture"));
	}
	
	public void getChoosePicture(String choosePictureData) {
		this.choosePicture.click();
		this.choosePicture.sendKeys();
	}

	public WebElement getHobbies() {
		return driver.findElement(By.id("hobbies-checkbox-2"));
	}

	public WebElement getPicture() {
		return driver.findElement(By.id("uploadPicture"));
	}

	public WebElement getCurrentAddress() {
		return driver.findElement(By.id("currentAddress"));
	}

	public WebElement getState() {
		return driver.findElement(By.xpath("//*[@id=\"state\"]/div/div[2]"));
	}

	public WebElement getCity() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.id("submit"));
	}
	
	public WebElement getProof() {
		return driver.findElement(By.xpath("/html/body/div[4]/div/div"));
	}

	public void insertFirstName(String firstNameData) {
		this.getFirstName().click();
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstNameData);
	}
	
	public void insertLastName(String lastNameData) {
		this.getLastName().clear();
		this.getLastName().sendKeys(lastNameData);
	}
	
	public void insertEmail(String emailData) {
		this.getEmail().clear();
		this.getEmail().sendKeys(emailData);
	}
		
	public void clickGender() {
		this.getGender().click();
	}

	public void insertMobileNumber(int mobileNumberData) {
		this.getMobileNumber().clear();
		this.getMobileNumber().sendKeys();
	}
	
	public void insertEmail(int emailData) {
		this.getEmail().clear();
		this.getEmail().sendKeys();
	}
	
	public void insertSubject(String subjectData) {
		this.getSubject().clear();
		this.getSubject().sendKeys(subjectData);
	}
	
	public void insertCurrentAddress(String currentAddressData) {
		this.getCurrentAddress().clear();
		this.getCurrentAddress().sendKeys(currentAddressData);
	}
	
	//STATE
	
	//CITY

	public void clickSubmit() {
		this.getSubmit().click();
	}
}
