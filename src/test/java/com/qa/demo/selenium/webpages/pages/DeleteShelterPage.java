package com.qa.demo.selenium.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteShelterPage {
public static final String URL = "http://localhost:8080/DeleteShelter.html";
	
	@FindBy(id = "shelterId")
	private WebElement shelterId;

	@FindBy(xpath = "/html/body/div/main/fieldset[1]/button")
	private WebElement deleteButton;

	@FindBy(id = "output")
	private WebElement output;

	public DeleteShelterPage(WebDriver driver) {

	}
	
	public void action(int sId) {
		shelterId.click();
		shelterId.sendKeys(String.valueOf(sId));
		deleteButton.click();
	}
	
	public WebElement getOutput() {
		return output;
	}

}
