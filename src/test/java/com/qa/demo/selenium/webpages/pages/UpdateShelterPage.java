package com.qa.demo.selenium.webpages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateShelterPage {

	public static final String URL = "http://localhost:8080/UpdateShelter.html";
	
	@FindBy(id = "shelterId")
	private WebElement shelterId;
	
	@FindBy(id = "shelterName")
	private WebElement shelterName;

	@FindBy(id = "addressLine")
	private WebElement addressLine;

	@FindBy(id = "postcode")
	private WebElement postcode;

	@FindBy(xpath = "/html/body/div/main/fieldset/button")
	private WebElement createButton;

	@FindBy(id = "output")
	private WebElement output;

	public UpdateShelterPage(WebDriver driver) {

	}
	
	public void action(int sId, String name, String address, String pcode) {
		shelterId.click();
		shelterId.sendKeys(String.valueOf(sId));
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
