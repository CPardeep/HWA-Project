package com.qa.demo.selenium;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.demo.selenium.webpages.HomePage;

class TestShelterWebsite {

	private static WebDriver driver;
	private static Logger LOGGER = Logger.getGlobal();

	@BeforeEach
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();

		// timeouts
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Test
	public void Test_createDogs() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click toggeler
		website.clickCreateDog();

		// Run the action
		website.createDogPage.action("Roky", "Akita", "1", "#0000", 1, 1);

		// Wait for the output to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done")));

		// Check for confirmation
		assertEquals("Name: Roky, Breed: Akita, Age: 1, Colour: #000000, Available: Reserved",
				website.createDogPage.getOutput().getAttribute("value"));

	}

	@Test
	public void Test_createShelters() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click toggeler
		website.clickCreateShelter();

		// Run the action
		website.createShelterPage.action("GG Shelter", "75 Cannock Road, Wolverhampton", "WV66AS");

		// Wait for the output to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done")));

		// Check for confirmation
		assertEquals("Shelter Name: GG Shelter, Address: 75 Cannock Road, Wolverhampton, Postcode: WV66AS",
				website.createShelterPage.getOutput().getAttribute("value"));
	}

	@Test
	public void Test_updateDog() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click toggeler
		website.clickUpdateDog();

		// Run the action
		website.updateDogPage.action(1, "Roky", "Akita", "1", "#0000", 1, 1);

		// Wait for the output to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done")));

		// Check for confirmation
		assertEquals("Name: Roky, Breed: Akita, Age: 1, Colour: #000000, Available: Reserved",
				website.updateDogPage.getOutput().getAttribute("value"));
	}

	@Test
	public void Test_updateShelter() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click toggeler
		website.clickUpdateShelter();

		// Run the action
		website.updateShelterPage.action(1, "GG Shelter", "75 Cannock Road, Wolverhampton", "WV66AS");

		// Wait for the output to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done")));

		// Check for confirmation
		assertEquals("Shelter Name: GG Shelter, Address: 75 Cannock Road, Wolverhampton, Postcode: WV66AS",
				website.updateShelterPage.getOutput().getAttribute("value"));
	}

	@Test
	public void Test_deleteDog() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click toggeler
		website.clickDeleteDog();

		// Run the action
		website.deleteDogPage.action(2);

		// Wait for the output to load
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done")));

		// Check for confirmation
		assertEquals("Successfull", website.deleteDogPage.getOutput().getAttribute("value"));
	}

	@Test
	public void Test_deleteShelter() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Click toggeler
		website.clickDeleteShelter();

		// Run the action
		website.deleteShelterPage.action(2);

		// Check for confirmation
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("done")));

		assertEquals("Successfull", website.deleteShelterPage.getOutput().getAttribute("value"));
	}

	@Test
	public void Test_ReadDogs() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Read Dogs
		website.readAllDogs();

	}

	@Test
	public void Test_ReadShelters() throws InterruptedException {

		// Site Navigation
		driver.get("http://localhost:8080/HomePage.html");
		HomePage website = PageFactory.initElements(driver, HomePage.class);

		// Read Dogs
		website.readAllShelters();

	}

	@AfterEach
	public void cleanAll() {
		driver.quit();
		LOGGER.info("Testing Done");
	}
}