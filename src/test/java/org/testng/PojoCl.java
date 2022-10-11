package org.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoCl extends Base {
	public PojoCl() {
		PageFactory.initElements(ts, this);
	}
	@FindBy(id="email") private WebElement u;
	@FindBy(id="pass") private WebElement p;
	@FindBy(name="login") private WebElement l;
	public WebElement getU() {
		return u;
	}
	public WebElement getP() {
		return p;
	}
	public WebElement getL() {
		return l;
	}  
}
