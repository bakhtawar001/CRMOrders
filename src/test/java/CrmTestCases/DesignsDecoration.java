package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import OrdersTestcases.OrderDeletion;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersTestdata;

public class DesignsDecoration extends HelpingFunction {
	public static CrmLocatiors GetData = PageFactory.initElements(driver, CrmLocatiors.class);

	public static void Design_Decoration() throws InterruptedException, AWTException, IOException {
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		Click("Click on Design tab", GetData.Designs);
		Click("Click on Decoration tab", GetData.Decorations);
		Click("Click Add Decorations button", GetData.AddDecorations);
		Input("Provide Decoration name", GetData.DecorationName, CrmTestData.DecorationName);
		Click("Upload Artfile", GetData.Decoration_ArtWorkImageUploadButton);
		Thread.sleep(2000);
		OrderDeletion.Projectpath = System.getProperty("user.dir");
		System.out.println(OrderDeletion.Projectpath);
		String Projectpath = System.getProperty("user.dir");
		Runtime.getRuntime().exec(Projectpath + "/Img/orderslogo.exe");
		Thread.sleep(15000);
		waitForElementNotVisible(120, driver, GetData.DesignSpinnerLoader);
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", GetData.SaveDecoration);
		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		Thread.sleep(2000);
		Input("Search Decoration", GetData.SearchDecoration, CrmTestData.DecorationName);
		Thread.sleep(2000);
		String verifydecoration = driver
				.findElement(By.xpath("//a[contains(text(),'" + CrmTestData.DecorationName + "')]")).getText();
		System.out.println(verifydecoration + '\n');
		Thread.sleep(2000);
		Verify(verifydecoration, CrmTestData.DecorationName, "Decoration design is not created");

	}

	public static void ViewEdit_Decoration() throws InterruptedException, AWTException, IOException {
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		Thread.sleep(3000);
		Click("Click to view Decoration", GetData.ViewDecoration);
		Thread.sleep(2000);
		Assert.assertTrue(GetData.VerifyViewDecorationScreen.isDisplayed());
		Input("Edit Decoration name", GetData.DecorationName, CrmTestData.EditDecorationName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", GetData.SaveDecoration);

		GetData.SaveDecoration.click();
		Thread.sleep(2000);
		Input("Search Decoration", GetData.SearchDecoration, CrmTestData.EditDecorationName);
		String verifyEditdecoration = driver
				.findElement(By.xpath("//a[contains(text(),'" + CrmTestData.EditDecorationName + "')]")).getText();
		System.out.println(verifyEditdecoration + '\n');
		Thread.sleep(2000);
		Verify(verifyEditdecoration, CrmTestData.EditDecorationName, "Decoration design is not Edited");

	}

	public static void ViewDecoration_Order() throws InterruptedException, AWTException, IOException {
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		SoftAssert assertion = new SoftAssert();
		Thread.sleep(3000);
		Click("Click on Orders tab", GetData.OrdersTab);
		Thread.sleep(2000);
		Click("Create an Order", GetData.CreateOrder);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", GetData.CreateOrder_AddProductButton);

		Thread.sleep(3000);
		// Press Add Product Button
		Click("a", GetData.CreateOrder_AddProductButton);

		// CreateOrder. CreateOrder_AddProductButton.click();

		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);

		// Go To Product Search Tab in popup
		Click("Seach product", GetData.CreateOrder_AddProductPopup_ProductSearchTab);

		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		// Search the Product which want to associate with order
		GetData.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.OrderProduct);

		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);

		// Now press Search Button
		Click("a", GetData.CreateOrder_AddProductPopup_SearchButton);
		wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.elementToBeClickable(GetData.CreateOrder_AddProductPopup_ProductSelection));

		// Now Select the Product
		Click("a", GetData.CreateOrder_AddProductPopup_ProductSelection);

		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", GetData.CreateOrder_AddProductPopup_AddProductsButton);
		// Press the Add Products Button to complete the process
		Click("a", GetData.CreateOrder_AddProductPopup_AddProductsButton);

		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);

		String ProductAddedToOrderSuccess = GetData.CreateOrder_ProductAddedToOrder_Successfull.getText();
		Thread.sleep(2000);
		Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));

		Thread.sleep(2000);

		Click("a", GetData.OrdersDetails_Configure);

		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		Thread.sleep(1000);

		GetData.ProductConfiguration_AddCharge_QTY.sendKeys("1");
		Thread.sleep(2000);
		Click("Click Continue Button", GetData.Continuebutton);

		//Press the save button
		Click("Click Save button", GetData.ProductConfiguration_AddCharge_SaveButton);

		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		Thread.sleep(2000);
		Click("Click Edit Button", GetData.OrdersDetails_EditButton);
		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		Click("Clik at deco tab", GetData.Orderdetails_DecorationTab);
		Thread.sleep(2000);
		Click("Select Decoration", GetData.DecorationDropDown);
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'" + CrmTestData.EditDecorationName + "')]"))
				.isDisplayed());

		assertion.assertAll();
		Click("Close Product modal window", GetData.CloseProductWindow);
		Thread.sleep(2000);
		Click("Close order window", GetData.CloseOrder_Icon);
		Thread.sleep(2000);
		Click("Click on CRM tab", GetData.CRM);
		Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
		Thread.sleep(3000);
		Click("Company Details", GetData.CompDetails);
		

	}

	public static void Delete_Decoration() throws InterruptedException, AWTException, IOException {
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		// Click("Click on Design tab",GetData.Designs);
		// Click("Click on Decoration tab",GetData.Decorations);
		Thread.sleep(2000);
		Click("Click Add Decorations button", GetData.AddDecorations);
		Input("Provide Decoration name", GetData.DecorationName, CrmTestData.DecorationName_Foillogo);
		// Click("Click on Imprint Method drop down" ,GetData.ImprintMethod);
		// Click("Select Imprint Method" ,GetData.SelectImprintMethod);
		Click("Upload Artfile", GetData.Decoration_ArtWorkImageUploadButton);
		Thread.sleep(2000);
		OrderDeletion.Projectpath = System.getProperty("user.dir");
		System.out.println(OrderDeletion.Projectpath);
		String Projectpath = System.getProperty("user.dir");
		Runtime.getRuntime().exec(Projectpath + "/Img/ordersfoil.exe");
		Thread.sleep(5000);
		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", GetData.SaveDecoration);
		// GetData.SaveDecoration.click();
		waitForElementNotVisible(120, driver, GetData.SpinnerLoader);
		Thread.sleep(2000);
		Input("Search Decoration", GetData.SearchDecoration, CrmTestData.DecorationName_Foillogo);
		String verifydecoration = driver
				.findElement(By.xpath("//a[contains(text(),'" + CrmTestData.DecorationName_Foillogo + "')]")).getText();
		System.out.println(verifydecoration + '\n');
		Thread.sleep(2000);
		Verify(verifydecoration, CrmTestData.DecorationName_Foillogo, "Decoration design is not created");

		Click("Click to view Decoration", GetData.ViewDecoration);
		Thread.sleep(3000);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", GetData.DeleteDecoration);
		// GetData.DeleteDecoration.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		Input("Search Decoration", GetData.SearchDecoration, CrmTestData.DecorationName_Foillogo);
		Thread.sleep(2000);
		Assert.assertTrue(GetData.VerifyDeleteDecoration.isDisplayed());

	}

	public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String elementXPath) {
		if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

			return "Wrong usage of WaitforElementNotVisible()";
		}
		try {
			(new WebDriverWait(driver, timeOutInSeconds))
					.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXPath)));
			return null;
		} catch (TimeoutException e) {
			return "Build your own errormessage...";
		}
	}
}
