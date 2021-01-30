package com.qa.demo.selenium.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateShelterPage {

	public static final String URL = "http://localhost:8080/CreateShelter.html";

	@FindBy(id = "shelterName")
	private WebElement shelterName;

	@FindBy(id = "addressLine")
	private WebElement addressLine;

	@FindBy(id = "postcode")
	private WebElement postcode;

	@FindBy(xpath = "/html/body/div/main/fieldset[1]/button")
	private WebElement createButton;

	@FindBy(id = "output")
	private WebElement output;

	public CreateShelterPage(WebDriver driver) {

	}
	
	public void action(String name, String address, String pcode) {
		shelterName.click();
		shelterName.sendKeys(name);
		addressLine.click();
		addressLine.sendKeys(address);
		postcode.click();
		postcode.sendKeys(pcode);
		createButton.click();
	}
	
	public WebElement getOutput() {
		return output;
	}

}

