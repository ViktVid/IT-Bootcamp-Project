package basePackageProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import basePackage.ExcelReader;

import pagesPackageProject.DynamicPropertiesPageHappyPath;
import pagesPackageProject.DynamicPropertiesPageSadPath;
import pagesPackageProject.FormsPage;
import pagesPackageProject.InteractionsPage;
import pagesPackageProject.LogInPage;
import pagesPackageProject.PageElements;

public class Base {

	public static WebDriver driver;
	public static WebDriverWait wdwait;
	public static Actions action;
	public ExcelReader excelReader;
	public PageElements pageElements;
	public DynamicPropertiesPageHappyPath dynamicPropertiesPageHappyPath;
	public DynamicPropertiesPageSadPath dynamicPropertiesPageSadPath;
	public FormsPage formsPage;
	public InteractionsPage interactionsPage;
	public LogInPage logInPage;
	public String baseUrl;
	public String formsUrl;

	@BeforeClass // >> Setovanje koje cemo pozivati pre svake klase:
	public void setUp() throws IOException {

		// Setovanje Drivera za Chrome:
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		// Actions builder = new Actions (driver);
		// Pozivanje klase "PageElements (Kreiranje konstruktora):
		pageElements = new PageElements(driver, wdwait);

		// Povezivanje Excel tabele iz koje vucemo podatke za svaku klasu koju cemo
		// koristiti:
		excelReader = new ExcelReader("C:\\Users\\User\\Desktop\\Project.xlsx");

		// Usmeravanje na osnovnu URL adresu, koju povlacimo iz prethodno pozvane Excel
		// tabele:
		baseUrl = excelReader.getStringData("ProjectData", 1, 0);

		// Usmeravanje na drugu URL adresu (Ovo sam napravila za potrebu da se direktno
		// preusmerim sa jedne na drugu, putem podataka iz Excel tabele):
		formsUrl = excelReader.getStringData("ProjectData", 4, 0);

		// Setovanje klase WebDriverWait koju cemo koristiti za svako eksplicitno
		// cekanje tokom testa:
		wdwait = new WebDriverWait(driver, 20);

		// Pozivanje klase DynamicPropertiesHappyPath (Kreiranje konstruktora):
		dynamicPropertiesPageHappyPath = new DynamicPropertiesPageHappyPath(driver, wdwait);

		// Pozivanje klase DynamicPropertiesSadPath (Kreiranje konstruktora):
		dynamicPropertiesPageSadPath = new DynamicPropertiesPageSadPath(driver, wdwait);

		// Pozivanje klase FormsPage (Kreiranje konstruktora):
		formsPage = new FormsPage(driver, wdwait);

		// Pozivanje klase InteractionsPage (Kreiranje konstruktora):
		interactionsPage = new InteractionsPage(driver, wdwait, action);

		// Pozivanje klase LogInPage:
		logInPage = new LogInPage(driver, wdwait);

	}

	@AfterClass // >> Podesavanje koje ce se izvrsiti nakon svake klase: Zatvaranje drivera:
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
