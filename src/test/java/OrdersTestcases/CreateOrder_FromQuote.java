package OrdersTestcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class CreateOrder_FromQuote extends OrdersExecution1 {

	public static String NaviagtionFromInvoiceToOrderScreen;
	public static String NaviagtionFromOrderToQuoteScreen;
	static OrdersLocators CreateOrderFromQuote = PageFactory.initElements(driver, OrdersLocators.class);

	public static void CreateOrders_FromQuote_LinkedTraction_VerificationInvoice()
			throws IOException, InterruptedException {
		try {

			Thread.sleep(6000);
			// Press CreateOrderButton in Quote to move to Order screen from Quote screen
			Click("Click at invoice button", CreateOrderFromQuote.CreateOrderButton_Quote);

			// waitForPageLoading();

			// waitForElementNotVisible(120, driver,CreateOrderFromQuote.SpinnerLoader);

			Thread.sleep(30000);
			// Press the Create Invoice Button
			Click("Click at invoice button", CreateOrderFromQuote.Order_CreateInvoice);
			// waitForElementNotVisible(120, driver,CreateOrderFromQuote.SpinnerLoader);

			waitForPageLoading();

			Thread.sleep(30000);

			// Validate the Linked transaction item status on Invoice screen
			WebElement HoverLinkedTransaction = CreateOrderFromQuote.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransaction);

			Thread.sleep(2000);

			// Validate as if the Linkedtrasaction link occur or not
			Assert.assertTrue(CreateOrderFromQuote.LinkedTransactionDisplayedVerification.isDisplayed());

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
	}

	public static void ShipAccountNo_Visibility_InvoiceDocument_Verification()
			throws InterruptedException, IOException {
		try {
			Click("Click the Preview Button on quote detail Page for Account No Verification",
					CreateOrderFromQuote.Quote_Preview_Button);

			// waitForElementNotVisible(120, driver,CreateOrderFromQuote.SpinnerLoader);

			waitForPageLoading();

			Thread.sleep(2000);

			CreateQuote.windowhandles = driver.getWindowHandles();

			CreateQuote.It = CreateQuote.windowhandles.iterator();

			CreateQuote.ParentWindow = CreateQuote.It.next();

			System.out.println(CreateQuote.ParentWindow);

			CreateQuote.ChildWindow = CreateQuote.It.next();

			System.out.println(CreateQuote.ChildWindow);

			driver.switchTo().window(CreateQuote.ChildWindow);

			Thread.sleep(2000);
			Assert.assertTrue(CreateOrderFromQuote.ShipAccount_QuotePreview_Verification.isDisplayed()
					& CreateOrderFromQuote.ShipAccount_QuotePreview_Verification.getText().contains("Ship Account:"));

		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

	public static void CPN_NumberVisibility_AtInvoiceDoc_Verification() throws IOException, InterruptedException {
		try {
			Assert.assertTrue(CreateOrderFromQuote.CustomerFacingDoc_CPN_Visible_Verification.isDisplayed());

		} catch (NoSuchElementException e) {
			e.getMessage();
		}
	}

	public static void VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_InvoicePreview_Verification()
			throws InterruptedException, IOException {
		try {
			// Assert.assertTrue(CreateOrderFromQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText().contains("Notes:")
			// &&
			// CreateOrderFromQuote.DecoratorInstructions_QuotePreview_Verification.getText().contains("Instructions:")
			// &&
			// CreateOrderFromQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText().contains("Test
			// Vendor Notes") &&
			// CreateOrderFromQuote.DecoratorInstructions_QuotePreview_Verification.getText().contains("Test
			// Decorator Instructions") );
			if (CreateOrderFromQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText()
					.contains("Notes:")
					&& CreateOrderFromQuote.DecoratorInstructions_QuotePreview_Verification.getText()
							.contains("Instructions:")
					&& CreateOrderFromQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText()
							.contains("Test Vendor Notes")
					&& CreateOrderFromQuote.DecoratorInstructions_QuotePreview_Verification.getText()
							.contains("Test Decorator Instructions")) {
				System.out.println("VendorNotes and Decorartor Instructions Displayed on Invoice Preview Successfully");

				// resultPass("VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_InvoicePreview_Verification",
				// "VendorNotes and Decorartor Instructions Displayed on Invoice Preview
				// Successfully");
			} else {
				System.out
						.println("VendorNotes and Decorartor Instructions Displayed on Invoice Preview UnSuccessfully");

				// resultFail("VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_InvoicePreview_Verification",
				// "VendorNotes and Decorartor Instructions Displayed on Invoice Preview
				// UnSuccessfully");
			}

		} catch (NoSuchElementException e) {
			e.getMessage();
		}

		finally {
			driver.close();

			Thread.sleep(3000);

			driver.switchTo().window(CreateQuote.ParentWindow);
		}

	}

	public static void LinkedTransaction_Navigation_ToOrderScreen() throws IOException, InterruptedException {
		try {

			// Now Validating the navigation process through linked as invoice to order and
			// order to Quote and validate the process

			WebElement HoverLinkedTransaction = CreateOrderFromQuote.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransaction);

			Thread.sleep(2000);

			// Click the Order number on Transactionlink
			CreateOrderFromQuote.LinkedTransactionOrderNumber_Linkedtext.click();

			NaviagtionFromInvoiceToOrderScreen = CreateOrderFromQuote.CreateOrder_OrderQuoteTextVerification.getText();

			System.out.println(NaviagtionFromInvoiceToOrderScreen);
			Assert.assertTrue(NaviagtionFromInvoiceToOrderScreen.contains("Order"));
			/*
			 * if(NaviagtionFromInvoiceToOrderScreen.contains("Order")) { System.out.
			 * println("Navigation from invoice to order screen Successfully Through linked Transaction order link"
			 * ); resultPass("LinkedTransaction_Navigation_ToOrderScreen",
			 * "Navigation from invoice to order screen Successfully Through linked Transaction order link"
			 * ); } else{ System.out.
			 * println("Navigation from invoice to order screen UnSuccessfully Through linked Transaction order link"
			 * ); resultFail("LinkedTransaction_Navigation_ToOrderScreen",
			 * "Navigation from invoice to order screen UnSuccessfully Through linked Transaction order link"
			 * ); }
			 */

		} catch (NoSuchElementException e) {
			e.getStackTrace();

		}

	}

	public static void Delete_Order_with_Associated_Invoices() throws InterruptedException, IOException {
		try {

			// Press the More Button on order details
			CreateOrderFromQuote.Orderdetails_MoreButton.click();

			// Press the delete order option
			Thread.sleep(1000);
			CreateOrderFromQuote.Orderdetails_MoreButton_DeleteOrder.click();

			// Press the Ok button for error message verification
			CreateOrderFromQuote.DeleteOrder_Okbutton.click();
			// waitForElementNotVisible(120, driver,CreateOrderFromQuote.SpinnerLoader);
			waitForPageLoading();

			// Validating Order removal from invoices with Validation error verification
			Assert.assertTrue(
					CreateOrderFromQuote.DeleteOrder_ErrorMessageVerification.getText().contains("Unable to delete"));

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}

	}

	public static void ShipAccountNo_AcknowledgementDocument_Verification() throws InterruptedException, IOException {
		try {

			Thread.sleep(20000);

			CreateOrderFromQuote.PreviewButton_Orderdetails.click();

			waitForElementNotVisible(120, driver, CreateOrderFromQuote.SpinnerLoader);

			Thread.sleep(2000);

			// Press the Acknowlodgement Order document
			Click("Click Acknowledgement Popup", CreateOrderFromQuote.PreviewPopUp_Acknowledgement);

			// CreateOrderFromQuote.PreviewPopUp_Acknowledgement.click();

			Thread.sleep(2000);

			// Press the Preview Button
			CreateOrderFromQuote.PreviewPopUp_PreviewButton.click();
			waitForElementNotVisible(120, driver, CreateOrderFromQuote.SpinnerLoader);

			Thread.sleep(2000);

			CreateQuote.windowhandles = driver.getWindowHandles();

			CreateQuote.It = CreateQuote.windowhandles.iterator();

			CreateQuote.ParentWindow = CreateQuote.It.next();

			System.out.println(CreateQuote.ParentWindow);

			CreateQuote.ChildWindow = CreateQuote.It.next();

			System.out.println(CreateQuote.ChildWindow);

			driver.switchTo().window(CreateQuote.ChildWindow);

			Thread.sleep(2000);
			Assert.assertTrue(CreateOrderFromQuote.ShipAccount_QuotePreview_Verification.isDisplayed()
					& CreateOrderFromQuote.ShipAccount_QuotePreview_Verification.getText().contains("Ship Account:"));

		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

	public static void VendorNotes_DecoratorNotes_Visible_checkbox_SelectedAtProductLevel_AcknowledgementPreview_Verification()
			throws InterruptedException, IOException {
		try {

			Assert.assertTrue(CreateOrderFromQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText()
					.contains("Notes:"));
			Thread.sleep(2000);
			Assert.assertTrue(CreateOrderFromQuote.DecoratorInstructions_QuotePreview_Verification.getText()
					.contains("Instructions:"));
			Thread.sleep(2000);
			Assert.assertTrue(CreateOrderFromQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText()
					.contains("Test Vendor Notes"));
			Thread.sleep(2000);
			Assert.assertTrue(CreateOrderFromQuote.DecoratorInstructions_QuotePreview_Verification.getText()
					.contains("Test Decorator Instructions"));

		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

	public static void LinkedTransaction_Navigation_ToQuoteScreen() throws IOException, InterruptedException {
		try {

			driver.close();

			Thread.sleep(2000);

			driver.switchTo().window(CreateQuote.ParentWindow);

			Click("Close Preview", CreateOrderFromQuote.ClosePreviewPopup);

			Thread.sleep(2000);
			WebElement HoverLinkedTransactionNav = CreateOrderFromQuote.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransactionNav);

			Thread.sleep(2000);

			CreateOrderFromQuote.LinkedTransactionOrderNumber_Linkedtext.click();
			Thread.sleep(2000);

			waitForElementNotVisible(120, driver, CreateOrderFromQuote.SpinnerLoader);

			NaviagtionFromOrderToQuoteScreen = CreateOrderFromQuote.CreateOrder_OrderQuoteTextVerification.getText();

			System.out.println(NaviagtionFromOrderToQuoteScreen);
			Assert.assertTrue(NaviagtionFromOrderToQuoteScreen.contains("Quote"));
			/*
			 * if(NaviagtionFromOrderToQuoteScreen.contains("Quote")) { System.out.
			 * println("Navigation from Order to Quote screen Successfully Through linked Transaction order link"
			 * ); resultPass("LinkedTransaction_Navigation_ToQuoteScreen",
			 * "Navigation from Order to Quote screen Successfully Through linked Transaction order link"
			 * ); } else{ System.out.
			 * println("Navigation from Order to Quote screen UnSuccessfully Through linked Transaction order link"
			 * ); resultFail("LinkedTransaction_Navigation_ToQuoteScreen",
			 * "Navigation from Order to Quote screen UnSuccessfully Through linked Transaction order link"
			 * ); }
			 */

		} catch (NoSuchElementException e) {
			System.err.println("NoSuchElementException: " + e.getMessage());
		}

	}

}
