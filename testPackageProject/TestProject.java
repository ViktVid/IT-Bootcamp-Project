package testPackageProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackageProject.Base;

public class TestProject extends Base {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeMethod // >> Maksimiziranje prozora i odlazak na bazicnu URL adresu pre svake metode:
	public void pageSetUp() {
		driver.manage().window().maximize();		
		driver.navigate().to(baseUrl);
	}

	@Test(priority = 10) // Prvi test po prioritetu - Provera da li su podaci poslati - Klasa PageElements:
	public void successfulSubmit() throws InterruptedException {

// Povlacenje potrebnih podataka iz Excel tabele:
		String username = excelReader.getStringData("ProjectData", 1, 1);
		String email = excelReader.getStringData("ProjectData", 1, 2);
		String currentAddress = excelReader.getStringData("ProjectData", 1, 3);
		String permanentAddress = excelReader.getStringData("ProjectData", 1, 3);
		
		// Biranje kartice "elements"
		pageElements.clickElements();
		
		// Biranje opcije "Text Box"
		pageElements.clickTextBox();
		
		// Slanje podataka u polje "Username"
		pageElements.insertUsername(username);
		
		// Slanje podataka u polje "Email"
		pageElements.insertEmail(email);
		
		// Slanje podataka u polje "Current Address"
		pageElements.insertCurrentAddress(currentAddress);
		
		// Slanje podataka u polje "Permanent Address"
		pageElements.insertPermanentAddress(permanentAddress);
		
		// Klik na "Submit" dugme
		pageElements.getSubmit();
		
		// Trazenje odstampanih podataka ispod dugmeta "Submit"
		pageElements.getOutputProof();

		// Provera da li je deo sa odstampanim podacima prikazan
		Assert.assertTrue(pageElements.getOutputProof().isDisplayed());
		
		// Ovaj test ce proci, jer podaci jesu odstampani nakon klika na "Submit"
	}

		@Test(priority = 20) // Drugi test po prioritetu
		// Provera da li tekst na dugmetu "Color Change" menja boju nakon 5 sekundi - Klasa DynamicPropertiesPageHappyPath:
		
	public void waitForSuccessfulColorChanging() throws InterruptedException {
			
		// Odabir kartice "Elements"
		dynamicPropertiesPageHappyPath.clickElements();
		
		// Odabir "Dynamic Properties" iz padajuceg menija
		dynamicPropertiesPageHappyPath.getDynamicProperties();
		
		// Metoda Thread.sleep, radi sigurnosti da je dugme promenilo boju
		Thread.sleep(1000);
		
		// Pronalazak dugmeta "Visible After 5 Seconds" koje se pojavljuje iskljucivo nakon promenjene boje na tekstu dugmeta "Color Change"
		dynamicPropertiesPageHappyPath.getVisibleAfter5Seconds();
		Thread.sleep(5000);
		
		try {
			driver.findElement(By.id("visibleAfter"));
			Thread.sleep(6000);
			Assert.assertTrue(dynamicPropertiesPageHappyPath.getVisibleAfter5Seconds().isDisplayed());
			// U ovom Try-Catch bloku program proverava da li je element prisutan, ako jeste onda radi Assert, ako nije onda ga preskace
			// Proveru vrsimo direktnom pretragom preko ID-a
		} catch (org.openqa.selenium.NoSuchElementException e) {

		}
		
		
		try { // Ovaj blok je isti kao prethodni, osim sto sam trazila proveru pozivom iz klase, a ne direktnom proverom
			dynamicPropertiesPageHappyPath.getVisibleAfter5Seconds();
			Thread.sleep(6000);
			Assert.assertTrue(dynamicPropertiesPageHappyPath.getVisibleAfter5Seconds().isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {
			
		}
		
		// Assert koji uzima tekst koji se pojavljuje na dugmetu "Visible After 5 Seconds"
		Assert.assertEquals(dynamicPropertiesPageHappyPath.getVisibleAfter5Seconds().getText(), "Visible After 5 Seconds");
		// Ovaj test ce proci, jer dugme automatski menja boju nakon 5 sekundi, i onda se pojavljuje dugme sa trazenim tekstom
		}

		

	@Test(priority = 30) // Treci test po prioritetu
	// Provera da li tekst na dugmetu "Color Change" menja boju nakon klika na isto dugme, bez cekanja - Klasa DynamicPropertiesPageSadPath:
	
	
	public void successfulColorChanging() throws InterruptedException {
		
		// Odabir kartice "Elements"
		dynamicPropertiesPageSadPath.clickElements();
		
		// Odabir "Dynamic Properties" iz padajuceg menija
		dynamicPropertiesPageSadPath.getDynamicProperties();
		
		// Klik na dugme "Color Change"
		dynamicPropertiesPageSadPath.clickColorChange();
		
		// Trazenje dugmeta "Visible After 5 Seconds"
		dynamicPropertiesPageSadPath.getVisibleAfter5Seconds();

		// Provera da li je dugme "Visible After 5 Seconds" prikazano
		Assert.assertTrue(dynamicPropertiesPageSadPath.getVisibleAfter5Seconds().isDisplayed());
		// Ovaj test pada, jer dugme menja boju iskljucivo automatski nakon 5 sekundi
	} 

	
	@Test(priority = 40) // // Cetvrti test po prioritetu
	// Provera da li korisnik moze uspesno da unese podatke na stranici "Forms"  - Klasa FormsPage:
	
	public void successfulRegistration() throws InterruptedException {
		
//		driver.navigate().to(formsUrl);  	>> Ovo sam stavila kako bih mogla da odem direktno na zeljenu stranicu, a ne preko Home Page

		// Unos podataka iz Excel tabele:
		
		String firstName = excelReader.getStringData("ProjectData", 8, 0 );
		String lastName = excelReader.getStringData("ProjectData", 8, 1 );
		String email = excelReader.getStringData("ProjectData", 8, 2);
		int mobileNumber = excelReader.getIntegerData("ProjectData", 8, 3 );
		String currentAddress = excelReader.getStringData("ProjectData", 8, 4 );
		String choosePicture = excelReader.getStringData("ProjectData", 8, 5);
		String subject = excelReader.getStringData("ProjectData", 8, 6);

		formsPage.clickElements();
		formsPage.chooseTheElement();
		formsPage.listOfForms(0);
		
		Thread.sleep(500);
		formsPage.insertFirstName(firstName);
		formsPage.insertLastName(lastName);
		formsPage.clickGender();
		formsPage.insertMobileNumber(mobileNumber);
		formsPage.insertEmail(email);
		formsPage.getDateOfBirth();
		formsPage.insertSubject(subject);
		formsPage.getHobbies();
		formsPage.getChoosePicture(choosePicture);
		formsPage.insertCurrentAddress(currentAddress);
		formsPage.clickSubmit();
// Ovaj test nisam zavrsila, jer jos uvek ni na jedan nacin nisam uspela da dodjem do stranice "Forms" (osim direktnim linkom)
		
	} 
		@Test(priority = 50) // Peti test po prioritetu
		// Provera da li mozemo prevuci objekat namenjen za to i smestiti ga u drugi (takodje namenjen za to) - Klasa InteractionsPage
		
		public void successfulDraggingAndDropping() throws InterruptedException {
			
			interactionsPage.clickElements();
    		interactionsPage.chooseTheElement();
    		interactionsPage.listOfInteractions(3);
    		
    		// Ovo nisam umela da izvedem:
    		interactionsPage.action.perform();
    		
    		//Pa ni ostalo ne radi
	//		interactionsPage.getDraggable();
	//		interactionsPage.getDropHere();
			interactionsPage.getDrop();
			interactionsPage.getTextDroppable();

			// Provera da li je prikazan element iz klase
			Assert.assertTrue(interactionsPage.getTextDroppable().isDisplayed());
			
			// Provera da li je prisutan element sa navedenim tekstom
			Assert.assertEquals(interactionsPage.getTextDroppable().getText(), "Dropped!");
			
			// Ovaj test bi trebalo da prodje, nisam pronasla dobre lokatore
		}
		
/*		@Test(priority = 60) // Sesti test po prioritetu
		// Provera uspesne registracije - Klasa LogInPage - Nije zavrseno
		
		public void successfulLogIn() throws  {
			
			logInPage.getHomeBody();
			
			// Nije zavrsena klasa
		
		} */
		
		
		@AfterMethod // Ciscenje kolacica nakon svake metode
		public void pageCleanUp() {
			driver.manage().deleteAllCookies();
		} 

}
