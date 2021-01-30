package com.qa.demo.selenium.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.demo.selenium.webpages.pages.CreateDogPage;
import com.qa.demo.selenium.webpages.pages.CreateShelterPage;

public class HomePage {

	public static final String URL = "http://localhost:8080/HomePage.html";
	
	@FindBy(id = "readDogs")
	private WebElement readDogs;
	
	@FindBy(id = "readShelter")
	private WebElement readShelters;
	
	@FindBy(css = ".navbar-toggler-icon")
	private WebElement navbarToggler;
	
	@FindBy(xpath = "//*[@id=\"togglethis\"]/ul/li[1]/a")
	private WebElement createDog;
	
	@FindBy(xpath = "//*[@id=\"togglethis\"]/ul/li[4]/a")
	private WebElement createShelter;
	
	public CreateDogPage createDogPage;
	public CreateShelterPage createShelterPage;
	
	public HomePage(WebDriver driver) {
		driver.get(URL);
		this.createDogPage = PageFactory.initElements(driver, CreateDogPage.class);
		this.createShelterPage = PageFactory.initElements(driver, CreateShelterPage.class);
	}
	
	public void readAllDogs() {
		readDogs.click();
	}
	
	public void readAllShelters() {
		readShelters.click();
	}
	
	public void clickCreateDog() {
		navbarToggler.click();
		createDog.click();
	}
	
	public void clickCreateShelter() {
		navbarToggler.click();
		createShelter.click();
	}

}
