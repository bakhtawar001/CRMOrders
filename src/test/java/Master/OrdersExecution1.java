package Master;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.base.Predicate;

import CrmTestCases.StartBrowser;
import OrdersTestcases.CreateInvoice;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.CreateOrder_FromQuote;
import OrdersTestcases.CreateQuote;
import OrdersTestcases.Dasboard_Orders;
import OrdersTestcases.EnterPaymentInvoice_WithInvoiceDeletion;
import OrdersTestcases.Login;
import OrdersTestcases.OrderDeletion;
import OrdersTestcases.Settings_SalesTax_ShippingTax_Enabling;
import PageFactoryandTestdata.HelpingFunction;

public class OrdersExecution1 extends HelpingFunction {

	public static WebDriverWait wait;
	static Predicate<WebDriver> pageLoaded;
	static WebDriver input;
	static String user = System.getProperty("user.name");
	public static String downloadPath = "C:\\Users\\" + user + "\\Downloads";
	public String Suite = "IDAHO_OrderExecution1.html";

	@BeforeTest
	public void Startup() throws InterruptedException, AWTException, IOException {
		StartBrowser.StartupBrowser(Suite);
	}

	@Test(priority = 0, description = "Validate that user is able to login with orders application successfully")
	public void LoginApp() throws IOException, InterruptedException, AWTException {
		Login.login();

	}

	@Test(priority = 1, description = "Validate that on orders landing page search field should have water mark 'Search by product,supplier etc.'")
	public void OrdersListing_SearchOrderField_PlaceholderVerification()
			throws IOException, InterruptedException, AWTException {
		Settings_SalesTax_ShippingTax_Enabling.OrdersListing_SearchOrderField_Placeholder_Verification();

	}

	@Test(priority = 2, description = "Validate that in sale tax page from settings address exists with 'PA' state and Tax rates checks box should be selected.")
	public void Settings_AutomaticSalesTaxChecked() throws IOException, InterruptedException, AWTException {
		Settings_SalesTax_ShippingTax_Enabling.AutomaticSalesTax_checked();

	}

	@Test(priority = 3, description = "Validate that on dashboard tool tip 'Difference in sales revenue year to date compared to the same time prior year' should be displayed on yearly summary section.")
	public void Percentage_square_in_Orders_SummaryWidget_ToolTip_TextVerification()
			throws IOException, InterruptedException, AWTException {
		Dasboard_Orders.Percentage_square_in_Orders_SummaryWidget_ToolTip_Text_Verification();

	}

	@Test(priority = 4, description = "Validate that on dashboard tool tip 'Difference in sales revenue between the selected period and the prior period' should be displayed on orders summary section.")
	public void Percentage_circle_inOrdersSummary_Widget_ToolTip_TextVerification()
			throws IOException, InterruptedException, AWTException {
		Dasboard_Orders.Percentage_circle_inOrdersSummary_Widget_ToolTip_Text_Verification();

	}

	@Test(priority = 5)
	public void PayWith_ElectronicFundsOption_DropdownValueVerification()
			throws IOException, InterruptedException, AWTException {
		OrderDeletion.PayWith_ElectronicFundsOption_DropdownVerification();

	}

	@Test(priority = 6)
	public void ShipVia_LoomisGroundOption_DropdownValueVerifcation()
			throws IOException, InterruptedException, AWTException {
		OrderDeletion.ShipVia_LoomisGroundOption_DropdownVerifcation();

	}

	@Test(priority = 7)
	public void OrderSaving_WithoutSalesPerson_ValidationVerification()
			throws IOException, InterruptedException, AWTException {
		OrderDeletion.OrderSaving_WithoutSalesPerson_Validation_Verification();

	}

	/*
	 * @Test(priority=8) public void UploadDSTFileOrders_Orderlevel() throws
	 * IOException, InterruptedException, AWTException{
	 * OrderDeletion.UploadDSTFile_Orderlevel();
	 * 
	 * }
	 */

	@Test(priority = 8)
	public void InvalidFileUpload_ErrorMessageDisplayVerification()
			throws IOException, InterruptedException, AWTException {
		OrderDeletion.InvalidFileUpload_ErrorMessageVerification();

	}

	@Test(priority = 9)
	public void UploadSVGFileOrders_Orderlevel() throws IOException, InterruptedException, AWTException {
		OrderDeletion.UploadSVG();

	}

	@Test(priority = 10)
	public void Upload_AIExtensionFile() throws IOException, InterruptedException, AWTException {
		OrderDeletion.Upload_AIExtension_File();

	}

	@Test(priority = 11)
	public void CustomProducts_SupplierSelectionDropdown_Verification()
			throws IOException, InterruptedException, AWTException {
		OrderDeletion.CustomProducts_SupplierSelection_Dropdown_Verification();

	}

	@Test(priority = 12)
	public void VerifyCogWheelNotExistsFor_CustomProductsVerification()
			throws IOException, InterruptedException, AWTException {
		OrderDeletion.cogWheelIcon_CustomProducts_Verification();

	}

	@Test(priority = 13)
	public void DeleteOrder_Orderlevel() throws IOException, InterruptedException, AWTException {
		OrderDeletion.DeleteOrder();

	}

	@Test(priority = 14)
	public void CustomerFacingDoc_CPN_Visible_EnableFromSettings()
			throws IOException, InterruptedException, AWTException {
		CreateQuote.CustomerFacingDoc_CPN_Visible_Enable_FromSettings();

	}

	@Test(priority = 15)
	public void CreateQuote_BillingAddress_Verification()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.QuoteCreation_BillingAddressVerification();
	}

	@Test(priority = 16)
	public void CreateQuote_ShippingAddress_Verification()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.QuoteCreation_ShippingAddressVerification();

	}

	@Test(priority = 17)
	public void CreateQuote_AddingProductToQuote()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.ProductAddedToQuote();

	}

	@Test(priority = 18)
	public void CreateQuote_Verification() throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.QuoteCreation_Verification();

	}

	@Test(priority = 19)
	public void Review_ImprintLocation() throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.AddImprintLocation();

	}

	@Test(priority = 20)
	public void VerifyTermandPay_QuoteRequestPreview()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.VerifyTermandPay_QuoteRequest_Preview();

	}

	@Test(priority = 21)
	public void ShipAccountNo_Checkbox_Uncheck_ByDefaultVerification()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.ShipAccountNo_Checkbox_Uncheck_ByDefault_Verification();

	}

	@Test(priority = 22)
	public void ShipAccountNotVisible_Visible_Checkbox_UncheckForAccountNo()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.ShipAccountNotVisible_Visible_Checkbox_UncheckFor_AccountNo();

	}

	@Test(priority = 23)
	public void Verify_ImprintLocation() throws IOException, InterruptedException {

		CreateQuote.VerifyImprintLocation();
	}

	@Test(priority = 24)
	public void CPN_Number_QuoteDocPreview_Verification()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.CPN_Number_QuoteDoc_Preview_Verification();

	}

	@Test(priority = 25)
	public void VendorInformation_QuotePreviewDoc() throws IOException, InterruptedException {

		CreateQuote.VendorInformation();
	}

	@Test(priority = 26)
	public void VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_QuotePreviewVerification()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote
				.VendorNotes_DecoratorNotes_DecoratorInstructions_Visible_checkbox_SelectedAtProductLevel_QuotePreview_Verification();

	}

	@Test(priority = 27)
	public void ShipAccountNo_Visibility_QuoteDocumentVerification()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.ShipAccountNo_Visibility_QuoteDocument_Verification();

	}

	@Test(priority = 28)
	public void AccountNo_Visible_Checkbox_Selected_Verification_AtProductLevel()
			throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.AccountNo_Visible_Checkbox_Selected_Verification_At_ProductLevel();

	}

	@Test(priority = 29)
	public void Quote_Download() throws IOException, InterruptedException, AWTException, ParseException {

		CreateQuote.QuoteDownload();

	}

	@Test(priority = 30)
	public void CreateOrder_FromQuote_LinkedTransactionInvoice() throws IOException, InterruptedException {

		CreateOrder_FromQuote.CreateOrders_FromQuote_LinkedTraction_VerificationInvoice();
	}

	@Test(priority = 31)
	public void ShipAccountNo_Visibility_InvoiceDocumentVerification() throws IOException, InterruptedException {

		CreateOrder_FromQuote.ShipAccountNo_Visibility_InvoiceDocument_Verification();
	}

	@Test(priority = 32)
	public void VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_InvoicePreviewVerification()
			throws IOException, InterruptedException {

		CreateOrder_FromQuote
				.VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_InvoicePreview_Verification();
	}

	@Test(priority = 33)
	public void LinkedTransaction_Navigation_To_OrderScreen() throws IOException, InterruptedException {

		CreateOrder_FromQuote.LinkedTransaction_Navigation_ToOrderScreen();
	}

	@Test(priority = 34)
	public void CreateOrder_Delete_Orderwith_Associated_Invoices() throws IOException, InterruptedException {

		CreateOrder_FromQuote.Delete_Order_with_Associated_Invoices();
	}

	@Test(priority = 35)
	public void ShipAccountNo_AcknowledgementDocumentVerification() throws IOException, InterruptedException {

		CreateOrder_FromQuote.ShipAccountNo_AcknowledgementDocument_Verification();
	}

	@Test(priority = 36)
	public void VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_AcknowledgementPreviewVerification()
			throws IOException, InterruptedException {

		CreateOrder_FromQuote
				.VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_AcknowledgementPreview_Verification();
	}

	@Test(priority = 37)
	public void CreateOrder_LinkedTransactions_Navigation_ToQuoteScreen() throws IOException, InterruptedException {

		CreateOrder_FromQuote.LinkedTransaction_Navigation_ToQuoteScreen();
	}

	@Test(priority = 38)
	public void Enterpaymentpartial() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.EnterPaymentWithInvoice_PaymentPartial();
	}

	@Test(priority = 39)
	public void DeleteInvoice_WithPaymentLeft() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.Delete_Invoice_with_Payment_left();
	}

	@Test(priority = 40)
	public void Full_Payment_Verify() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.Full_Payment_Verification();
	}

	@Test(priority = 41)
	public void Shipping_AddressEditing() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.Shipping_Address_Editing();
	}

	@Test(priority = 42)
	public void Partial_PaymentLink_Verification() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.Partial_Payment_Link_Verification();
	}

	@Test(priority = 43)
	public void Reorder_Verification() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.Reorder();
	}

	@Test(priority = 44)
	public void FieldsData_Verifications_AfterReorder() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.FieldsData_Verification_AfterReorder();
	}

	@Test(priority = 45)
	public void New_InhandDate_AfterReorderVerification() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.New_InhandDate_AfterReorder_Verification();
	}

	@Test(priority = 46)
	public void Linked_Transaction_ReOrder_Verifications() throws IOException, InterruptedException, ParseException {

		EnterPaymentInvoice_WithInvoiceDeletion.Linked_Transaction_ReOrder_Verification();
	}

	@Test(priority = 47)
	public void InvoiceCreationBillingAddress() throws IOException, InterruptedException, ParseException {

		CreateInvoice.InvoiceCreation_BillingAddress();

	}

	@Test(priority = 48)
	public void CreateInvoiceShippingAddress_Verification() throws IOException, InterruptedException, ParseException {

		CreateInvoice.CreateInvoice_ShippingAddress_Verification();

	}

	@Test(priority = 49)
	public void Product_AddedTo_Invoice() throws IOException, InterruptedException, ParseException {
		// Create Order
		CreateInvoice.Product_Added_To_Invoice();

	}

	@Test(priority = 50)
	public void CreateInvoice() throws IOException, InterruptedException, ParseException {
		// Create Order
		CreateInvoice.Create_Invoice();

	}

	@Test(priority = 51)
	public void VerifyBillingEmailAddress_Send_Invoice() throws IOException, InterruptedException, ParseException {
		// Create Order
		CreateInvoice.Send_Invoice_BillingEmailAddress();

	}

	@Test(priority = 52)
	public void CreateOrder_BillingAddressVerification() throws IOException, InterruptedException, AWTException {
		// Create Order
		CreateOrder.CreateOrder_BillingAddress_Verification();
	}

	@Test(priority = 53)
	public void CreateOrder_ShippingAddressVerification() throws IOException, InterruptedException, AWTException {
		// Create Order
		CreateOrder.CreateOrder_ShippingAddress_Verification();
	}

	@Test(priority = 54)
	public void CreateOrder_AcknowlodgementAddressVerification()
			throws IOException, InterruptedException, AWTException {
		// Create Order
		CreateOrder.CreateOrder_AcknowlodgementAddress_Verification();
	}

	@Test(priority = 55)
	public void Net25_Net45_Net90_50PercentAdvance_50PercentUponCompletion_Net75_Terms_DropdownValuesVerification()
			throws IOException, InterruptedException, AWTException {
		// Create Order
		CreateOrder
				.Net25_Net45_Net90_50PercentAdvance_50PercentUponCompletion_Net75_Terms_DropdownValues_Verification();
	}

	@Test(priority = 56)
	public void FedExOvernight_FedExFLEXExpress_ShipVia_DropdownValuesVerification()
			throws IOException, InterruptedException, AWTException {

		CreateOrder.FedExOvernight_FedExFLEXExpress_ShipVia_DropdownValues_Verification();

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		test = extent.createTest(result.getName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getMethod().getDescription());
			test.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + "Test Case is Passed", ExtentColor.GREEN));
			extent.flush();
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getMethod().getDescription());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue",
					ExtentColor.RED));
			test.fail(result.getThrowable());
			extent.flush();
		}

	}

	@AfterTest
	public void teardown() {

		driver.close();
	}

	/*
	 * public static void resultPass(String sTestName, String sTestCase) throws
	 * IOException, InterruptedException { try {
	 * 
	 * test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
	 * 
	 * test.log(Status.PASS,sTestCase); extent.flush(); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * } public static void resultFail(String sTestName, String sTestCase) throws
	 * IOException, InterruptedException { try {
	 * 
	 * 
	 * test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
	 * 
	 * test.log(Status.FAIL, sTestCase); extent.flush(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	public static void Hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public static void MoveToElement_Click(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();

	}

	public static void Click(String string, WebElement key) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", key);

	}

	public static void Input(String message, WebElement key, String value) {
		try {
			key.clear();
			key.sendKeys(value);
		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException: " + e.getMessage());
		}
	}

	public static void waitForPageLoadSave() throws InterruptedException {
		wait = new WebDriverWait(driver, 120);

		pageLoaded = new Predicate<WebDriver>() {

			public boolean apply(WebDriver input) {
				return ((JavascriptExecutor) input).executeScript("return document.readyState").toString()
						.equals("complete");
			}

		};
		// wait.until(pageLoaded) ;
		System.out.println("Page Loading...");

		Thread.sleep(5000);

		if (driver.findElement(By.xpath("//div[contains(@ng-class,'blockUiMessageClass')][contains(text(),'Saving')]"))
				.isDisplayed()) {
			waitForPageLoadSave();
		}
	}

	public static void waitForPageLoading() throws InterruptedException {
		wait = new WebDriverWait(driver, 120);

		pageLoaded = new Predicate<WebDriver>() {

			public boolean apply(WebDriver input) {
				return ((JavascriptExecutor) input).executeScript("return document.readyState").toString()
						.equals("complete");
			}

		};
		// wait.until(pageLoaded) ;
		System.out.println("Page Loading...");

		Thread.sleep(3000);

		if (driver.findElement(By.xpath("//div[contains(@ng-class,'blockUiMessageClass')][contains(text(),'Loading')]"))
				.isDisplayed()) {
			waitForPageLoading();
		}
	}

	public static void FileUpload(String s) throws AWTException, InterruptedException {
		Robot r = new Robot();
		for (int i = 0; i < s.length(); i++) {
			char res = s.charAt(i);
			final boolean upperCase = Character.isUpperCase(res);
			final int keyCode = KeyEvent.getExtendedKeyCodeForChar(res);
			System.out.println(keyCode);

			if (upperCase || keyCode > 500) {
				r.keyPress(KeyEvent.VK_SHIFT);
				if (keyCode == 513) {
					r.keyPress(KeyEvent.VK_SEMICOLON);
					r.keyRelease(KeyEvent.VK_SEMICOLON);
				}

			}

			if (keyCode < 500) {
				r.keyPress(keyCode);
				r.keyRelease(keyCode);
			}

			if (upperCase || keyCode > 500) {
				r.keyRelease(KeyEvent.VK_SHIFT);
			}
		}
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	@SuppressWarnings("deprecation")
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

	@SuppressWarnings("deprecation")
	public static String waitForElementToBeClickable_Xpath(int timeOutInSeconds, WebDriver driver,
			String elementXPath) {
		if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

			return "Wrong usage of WaitforElementNotVisible()";
		}
		try {
			(new WebDriverWait(driver, timeOutInSeconds))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXPath)));
			return null;
		} catch (TimeoutException e) {
			return "Build your own errormessage...";
		}
	}

	public static boolean isElementDisplayed(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public static void waitForElementToBeGone(WebElement element, int timeout, WebDriver driver) {
		if (isElementDisplayed(element, driver)) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		}
	}

	public static void waitForLoad(WebDriver driver) throws InterruptedException {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(pageLoadCondition);

		Thread.sleep(5000);

		if (driver.findElement(By.xpath("//div[contains(text(),'Loading')] | //div[contains(text(),'Saving')]"))
				.isDisplayed()) {
			waitForLoad(driver);
		}

	}
}
