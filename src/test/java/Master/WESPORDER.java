package Master;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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
import OrdersWESPTestcases.CreateOrder_SafeModeActive;
import OrdersWESPTestcases.Login;
import OrdersWESPTestcases.OrderCreation_FromIdahoMultipleProd;
import OrdersWESPTestcases.OrderCreation_FromWespMultipleProd;
import OrdersWESPTestcases.OrderFromIdaho_ThroughProjects;
import OrdersWESPTestcases.OrderFromShoppingCart_Idaho;
import OrdersWESPTestcases.OrderFromWESP_FromCreatePresentation_Order;
import OrdersWESPTestcases.OrderFromWESP_ThroughCompare;
import OrdersWESPTestcases.OrderFromWESP_ThroughHovering_ProductSearched;
import OrdersWESPTestcases.OrderFromWESP_ThroughProduct_QuickInfo;
import OrdersWESPTestcases.OrderFromWESP_ThroughProject;
import OrdersWESPTestcases.OrderFromWESP_ThroughSearch;
import OrdersWESPTestcases.OrderFromWESP_ThroughShoppingCart;
import OrdersWESPTestcases.OrderFromWESP_WithCanadian_Product;
import OrdersWESPTestcases.OrdersFromWESP_ThroughClipboard;
import OrdersWESPTestcases.QuoteFromWESP_ThroughClipboard;
import OrdersWESPTestcases.SearchOrderByInvoice;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class WESPORDER extends HelpingFunction {

	public static WebDriverWait wait;
	static Predicate<WebDriver> pageLoaded;
	static WebDriver input;
	static String suite = "WESPORDER.html";

	@BeforeTest
	public void Startup() throws InterruptedException, AWTException, IOException {

		StartBrowser.StartupBrowser(suite);
	}

	@Test(priority = 0)
	public void LoginApp() throws IOException, InterruptedException, AWTException {
		Login.login(OrdersTestdata.Username, OrdersTestdata.Password);

	}

	@Test(priority = 1)
	public void OrderFromWESP_Search() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughSearch.OrderFromWESP_WithSearchProduct();
	}

	/*
	 * @Test(priority=2) public static void VerificationOfBookedMargin() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * OrderFromWESP_ThroughSearch.VerificationOfBookedMargin(); }
	 * 
	 * 
	 * 
	 * @Test(priority=3) public static void VerificationOfBookedMarginAfterEditing()
	 * throws IOException, InterruptedException, ParseException{
	 * 
	 * OrderFromWESP_ThroughSearch.VerificationOfBookedMarginAfterEditing(); }
	 * 
	 * 
	 * 
	 * @Test(priority=4) public static void
	 * VerificationOfBookedMarginWithMultipleProducts() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * OrderFromWESP_ThroughSearch.VerificationOfBookedMarginWithMultipleProducts();
	 * }
	 */
	@Test(priority = 5)
	public static void OrderWithQUR() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughSearch.OrderWithQUR();
	}

	@Test(priority = 6)
	public void OrderFromWESP_HoveringProduct() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughHovering_ProductSearched.OrderFromWESP_WithHoveringProduct();
	}

	@Test(priority = 7)
	public void OrderFromWESP_QuickInfoProduct() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughProduct_QuickInfo.OrderFromWESP_ProductQuickInfo();
	}

	@Test(priority = 8)
	public void OrderFromWESP_Compare() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughCompare.OrderFromWESP_Comparing();
	}

	@Test(priority = 9)
	public void OrderFromWESP_Project() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughProject.OrderFromWESP_Projects();
	}

	@Test(priority = 10)
	public void OrderFromIDAHO_Projects() throws IOException, InterruptedException, ParseException {

		OrderFromIdaho_ThroughProjects.OrderFromIDAHO_FromProjects();
	}

	@Test(priority = 11)
	public void OrderFromWESP_With_CandianProduct() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_WithCanadian_Product.OrderFromWESP_With_CanadianProduct();
	}

	@Test(priority = 12)
	public void OrderFromWESP_From_CreatePresentation_OrderCreation()
			throws IOException, InterruptedException, ParseException {

		OrderFromWESP_FromCreatePresentation_Order.OrderFromWESP_FromCreatePresenation_OrderCreation();
	}

	@Test(priority = 13)
	public void OrderCreation_ThroughShoppingCart_Idaho() throws IOException, InterruptedException, ParseException {

		OrderFromShoppingCart_Idaho.ShoppingCartOrder_FromIdaho();
	}

	@Test(priority = 14)
	public void OrderCreation_ThroughShoppingCart_WESP() throws IOException, InterruptedException, ParseException {

		OrderFromWESP_ThroughShoppingCart.OrderFromWESP_FromShoppingCart();
	}

	@Test(priority = 15)
	public void OrderCreation_FromClipBoard_WESP() throws IOException, InterruptedException, ParseException {

		OrdersFromWESP_ThroughClipboard.OrderFromWESP_FromClipboard();
	}

	@Test(priority = 16)
	public void OrderCreation_FromWespMultipleProd() throws IOException, InterruptedException, ParseException {
		OrderCreation_FromWespMultipleProd.TaxAppliedonMultipleProductsAtCandaianAddress1();
	}

	@Test(priority = 17)
	public void OrderCreation_FromIdahoMultipleProdCan() throws IOException, InterruptedException, ParseException {
		OrderCreation_FromIdahoMultipleProd.TaxAppliedonMultipleProductsAtCandaianAddress();
	}

	@Test(priority = 18)
	public void SerchByInvoice() throws IOException, InterruptedException, ParseException {
		SearchOrderByInvoice.SearchOrderWithInvoice();
	}

	@Test(priority = 19)
	public void QuoteCreation_FromClipBoard_WESP() throws IOException, InterruptedException, ParseException {

		QuoteFromWESP_ThroughClipboard.QuoteFromWESP_FromClipboard();
	}

	@Test(priority = 20)
	public void WESPOrder_SafeModeActive() throws IOException, InterruptedException, ParseException {

		CreateOrder_SafeModeActive.OrderFromWESP_SafeModeActive();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		test = extent.createTest(result.getName());
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case is Passed", ExtentColor.GREEN));
			test.log(Status.PASS, "Please see attached screenshot");
			extent.flush();

		}

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue",
					ExtentColor.RED));
			test.fail(result.getThrowable());
			extent.flush();
		}

		if (result.getStatus() == ITestResult.SKIP) {
			System.out.print("Test cases is skipped");
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
			extent.flush();
		}

	}

	@AfterTest
	public void teardown() {
		extent.flush();

		// driver.close();

	}

	public static void resultPass(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			// test =extent.createTest(new Exception().getStackTrace()[0].getMethodName());

			// test.log(Status.PASS, sTestName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void resultFail(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			// test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

			// test.log(Status.FAIL, sTestName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	protected static void Click(String string, WebElement key) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", key);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected static void ConfigurePro() throws InterruptedException {
		OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
		// Enter The Quantity on Quatity screen

		try {

			Click("Click at continue button", WespOrder.CreateOrder_Configure_Continue_Button);

			WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");

			Thread.sleep(1000);

			// Press the continue Button
			WespOrder.CreateOrder_Configure_Continue_Button.click();

			Thread.sleep(15000);
			WespOrder.CreateOrder_Configure_Continue_Button.click();

			List<WebElement> li = driver.findElements(By.xpath("//span[contains(text(),'Enter or Select Company')]"));

			// Choose the customer to create Order
			if (li.size() > 0) {
				WespOrder.ChooseCustomer_TextField.click();
				WespOrder.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
				Thread.sleep(6000);
				WespOrder.ChooseCustomer_SearchInsertion.sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				// First store parent window to switch back

				WespOrder.CreateOrder_Configure_Continue_Button.click();
				Thread.sleep(3000);

				if (WespOrder.ChooseCustomer_TextField1.isDisplayed()) {
					WespOrder.ChooseCustomer_TextField1.click();
					Thread.sleep(2000);
					WespOrder.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
					Thread.sleep(6000);
					WespOrder.ChooseCustomer_SearchInsertion.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
				}
			}

			// Press the Create Order Button
			WespOrder.ChooseCustomer_CreateOrderButton.click();

			Thread.sleep(20000);

		}

		catch (Exception e) {

		}

	}

	public static void FileUpload(String s) throws AWTException, InterruptedException {
		Robot r = new Robot();
		for (int i = 0; i < s.length(); i++)

		{
			System.out.println(s.length());
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

	public static void waitForPageLoad() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

		pageLoaded = new Predicate<WebDriver>() {

			public boolean apply(WebDriver input) {
				return ((JavascriptExecutor) input).executeScript("return document.readyState").toString()
						.equals("complete");
			}

		};

		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//div[contains(text(),'Loading')] | //div[contains(text(),'Saving')]"))
				.isDisplayed()) {
			waitForPageLoad();
		}
	}
}