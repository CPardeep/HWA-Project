package com.qa.demo.selenium.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateDogPage {

	public static final String URL = "http://localhost:8080/CreateDog.html";

	@FindBy(id = "dogName")
	private WebElement dogName;

	@FindBy(id = "dogBreed")
	private WebElement dogBreed;

	@FindBy(id = "dogAge")
	private WebElement dogAge;

	@FindBy(id = "dogColour")
	private WebElement dogColour;

	@FindBy(id = "dogAvailable")
	private WebElement dogAvailable;

	@FindBy(id = "shelterID")
	private WebElement shelterID;

	@FindBy(xpath = "/html/body/div/main/fieldset[1]/button")
	private WebElement createButton;

	@FindBy(id = "output")
	private WebElement output;

	public CreateDogPage(WebDriver driver) {

	}
	
	public void action(String name, String breed, String age, String colour, int indexAvailable, int sid) {
		dogName.click();
		dogName.sendKeys(name);
		dogBreed.click();
		dogBreed.sendKeys(breed);
		dogAge.click();
		dogAge.sendKeys(age);
		dogColour.click();
		dogColour.sendKeys(colour);
		Select dropDown = new Select(dogAvailable);
		dropDown.selectByIndex(indexAvailable);
		shelterID.click();
		shelterID.sendKeys(String.valueOf(sid));
		createButton.click();
	}
	
	public WebElement getOutput() {
		return output;
	}

}
