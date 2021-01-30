package com.qa.demo.selenium.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteDogPage {

public static final String URL = "http://localhost:8080/DeleteDog.html";
	
	@FindBy(id = "dogId")
	private WebElement dogId;

	@FindBy(xpath = "/html/body/div/main/fieldset[1]/button")
	private WebElement deleteButton;

	@FindBy(id = "output")
	private WebElement output;

	public DeleteDogPage(WebDriver driver) {

	}
	
	public void action(int dId) {
		dogId.click();
		dogId.sendKeys(String.valueOf(dId));
		deleteButton.click();
	}
	
	public WebElement getOutput() {
		return output;
	}

}
