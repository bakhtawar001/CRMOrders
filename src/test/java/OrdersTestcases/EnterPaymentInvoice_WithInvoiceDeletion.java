package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.ConversionsWithoutOtherCharges;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class EnterPaymentInvoice_WithInvoiceDeletion extends OrdersExecution1 {
	public static JavascriptExecutor jse;
	public static JavascriptExecutor jse1;
	public static JavascriptExecutor jse2;
	public static String OldShippingAddress;
	public static String NewShippingAddress;
	static OrdersLocators EnterPayment = PageFactory.initElements(driver, OrdersLocators.class);

	public static void EnterPaymentWithInvoice_PaymentPartial()
			throws IOException, InterruptedException, ParseException {
		try {
			// This is to Instantiate EditOrders class

			WebElement HoverLinkedTransaction = EnterPayment.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransaction);

			Thread.sleep(2000);

			// Click the Order number on Transactionlink
			EnterPayment.LinkedTransactionOrderNumber_Linkedtext.click();

			WebElement HoverLinkedTransaction1 = EnterPayment.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransaction1);

			Thread.sleep(2000);

			// Click the Order number on Transactionlink
			EnterPayment.LinkedTransactionInvoice.click();

			waitForPageLoading();

			Thread.sleep(2000);

			// Converting subtotal from string to int
			ConversionsWithoutOtherCharges.Subtotal_String_To_Int_Conversion();

			//Calculating Tax	

			ConversionsWithoutOtherCharges.Tax_Calculation_Automatic();

			//Sales Tax Conversion from String to integer with $ removing done 

			ConversionsWithoutOtherCharges.SalesTax_String_To_Int_Conversion();

			//Calculating the SubTotal

			ConversionsWithoutOtherCharges.SubTotal_Calculation();

			//Rounding off the value SubTotal and Sum tax
			ConversionsWithoutOtherCharges.RoundingOffTotalAmount();

			//Now Converting the Amountdue from string to Int
			ConversionsWithoutOtherCharges.AmountDue_String_To_Int_Conversion();

			//Now Validating the Total Amount due 
			if (ConversionsWithoutOtherCharges.bd.doubleValue() == ConversionsWithoutOtherCharges.AmountDue) {
				System.out.println(
						"Total Amount Due:" + "" + ConversionsWithoutOtherCharges.AmountDue + "" + "is correct");
			} else {
				System.out.println(
						"Total Amount Due:" + "" + ConversionsWithoutOtherCharges.AmountDue + "" + "is not correct");
			}

			// Click the EnterPayment Button
			EnterPayment.Invoice_EnterPaymentButton.click();

			Thread.sleep(5000);

			// On Enter Payement Popup Validate the partial price verfication case
			EnterPayment.Invoice_EnterPaymentPopup_PayinFullCheckbox.click();

			Input("enter amount", EnterPayment.Invoice_EnterPaymentPopup_PayinFullTextField, "0.52");

			// Press the save button
			EnterPayment.Invoice_EnterPaymentPopup_SaveButton.click();

			waitForPageLoading();
			// waitForElementNotVisible(120, driver,EnterPayment.SpinnerLoader);
			Thread.sleep(2000);

//Now Converting the Amountdue from string to Int
			ConversionsWithoutOtherCharges.AmountDue_String_To_Int_Conversion();

			ConversionsWithoutOtherCharges.AmountDueCalculation_AfterPartialPayment();
			Assert.assertEquals(ConversionsWithoutOtherCharges.partialPaymentCalculation,
					ConversionsWithoutOtherCharges.AmountDue);

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
	}

	public static void Delete_Invoice_with_Payment_left() throws IOException, InterruptedException {
		try {

//Press the More Button on order details
			Click("Click at more button", EnterPayment.Orderdetails_MoreButton);

			// Press the delete order option
			Thread.sleep(2000);
			Click("Click at delete invoice button", EnterPayment.Invoice_DeleteInvoice);

			// Press the Ok button for error message verification
			Thread.sleep(2000);
			Click("Click at OK button to confirm", EnterPayment.DeleteOrder_Okbutton);

			Thread.sleep(1000);

			// Validating if full Payment is not done invoice should not be deleted
			Assert.assertTrue(EnterPayment.DeleteOrder_ErrorMessageVerification.getText().contains("Unable to delete"));
			/*
			 * if(EnterPayment.DeleteOrder_ErrorMessageVerification.getText().
			 * contains("Unable to delete")) {
			 * System.out.println("Unable to delete the invoice as it has payment history");
			 * resultPass("Delete Invoice with Payment left",
			 * "Unable to delete the invoice as it has payment history"); } else{
			 * System.out.println("able to delete the invoice as it has payment history");
			 * resultFail("Delete Invoice with Payment left",
			 * "able to delete the invoice as it has payment history"); }
			 */
			Thread.sleep(30000);
		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
	}

	public static void Full_Payment_Verification() throws IOException, InterruptedException {
		try {
			// Now validate the full payment process with calculation verification
			// Click the EnterPayment Button
			Click("Click at OK button to confirm", EnterPayment.Invoice_EnterPaymentButton);

			// Press the save button
			Click("Click at OK button to confirm", EnterPayment.Invoice_EnterPaymentPopup_SaveButton);

			waitForElementNotVisible(120, driver, EnterPayment.SpinnerLoader);
			Thread.sleep(15000);
			Assert.assertTrue(EnterPayment.AmountDueWithoutServiceCharges_InvoiceScreen.getText().contains("0.00"));
			/*
			 * if(EnterPayment.AmountDueWithoutServiceCharges_InvoiceScreen.getText().
			 * contains("0.00")) { System.out.println("Full Payment done successfully");
			 * resultPass("Full Payment Verification", "Full Payment done successfully"); }
			 * else{ System.out.println("Full Payment done unsuccessfully");
			 * resultFail("Full Payment Verification", "Full Payment done unsuccessfully");
			 * }
			 */

		} catch (NoSuchElementException e) {

			e.getStackTrace();
		}
	}

	public static void Shipping_Address_Editing() throws InterruptedException, IOException {
		try {

			// Go to Order screen again and validate the Edit shipping Address scenario
			WebElement HoverLinkedTransaction2 = EnterPayment.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransaction2);

			Thread.sleep(1000);

			// Click the Order number on Transactionlink
			Click("Click at OK button to confirm", EnterPayment.LinkedTransactionOrderNumber_Linkedtext);

			// Storing the old shipping Address
			OldShippingAddress = EnterPayment.CreateOrderScreen_ShippingCompanyAddress.getText();
			System.out.println(OldShippingAddress);

			// Press the Edit Button
			Click("Click at OK button to confirm", EnterPayment.EditShippingAddressButton);

			// Change the Address from current address to different Address
			/*
			 * WebElement ClearShippingAddress = EnterPayment.EditShippingAddressField;
			 * ClearShippingAddress.sendKeys(Keys.CONTROL + "a");
			 * ClearShippingAddress.sendKeys(Keys.DELETE);
			 * 
			 * Thread.sleep(1000);
			 * 
			 * //Enter New Address
			 * EnterPayment.EditShippingAddressField.sendKeys("California Street");
			 */

			Input("enter shipping address", EnterPayment.EditShippingAddressField, "California Street");

			Thread.sleep(4000);

			EnterPayment.EditShippingAddressField.sendKeys(Keys.ENTER);

			waitForPageLoading();

			// waitForElementNotVisible(120, driver,EnterPayment.SpinnerLoader);

			Thread.sleep(5000);
			/*
			 * WebElement ClearShippingPostal = EnterPayment.EditShippingPostalCodeField;
			 * ClearShippingPostal.sendKeys(Keys.CONTROL + "a");
			 * ClearShippingPostal.sendKeys(Keys.DELETE);
			 * 
			 * Thread.sleep(1000); //Enter New Postal Code
			 * EnterPayment.EditShippingPostalCodeField.sendKeys("22355");
			 */

			Input("enter shipping address", EnterPayment.EditShippingPostalCodeField, "22355");

			waitForElementNotVisible(120, driver, EnterPayment.SpinnerLoader);
			Thread.sleep(2000);
			// Press the save Button
			EnterPayment.EditShippingSaveButton.click();
			waitForElementNotVisible(120, driver, EnterPayment.SpinnerLoader);
			Thread.sleep(3000);
			Click("Click at OK button to confirm", EnterPayment.EditingConfirm);

//		 EnterPayment.EditingConfirm.click();

			Thread.sleep(2000);

			// Storing New Shipping Address
			NewShippingAddress = EnterPayment.CreateOrderScreen_ShippingCompanyAddress.getText();
			System.out.println(NewShippingAddress);
			Thread.sleep(2000);

			Assert.assertNotEquals(NewShippingAddress, OldShippingAddress);
			/*
			 * if(!NewShippingAddress.equals(OldShippingAddress)) {
			 * System.out.println("Shipping Address Updated Successfully");
			 * resultPass("Shipping Address Editing",
			 * "Shipping Address Updated Successfully"); } else{
			 * System.out.println("Shipping Address Updated UnSuccessfully");
			 * resultFail("Shipping Address Editing",
			 * "Shipping Address Updated UnSuccessfully"); }
			 */

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
	}

	public static void Partial_Payment_Link_Verification() throws InterruptedException, IOException {
		try {
			// Now Enter Details in Some of order fields for reorder veriifcation
			EnterPayment.Order_POReferenceField.sendKeys("223344");

			Thread.sleep(1000);

			// Select the In-hand date
			EnterPayment.Inhand_Orderdate_CalenderIcon.click();

			Thread.sleep(1000);

			// Move to next month through next icon in date picker
			EnterPayment.CalenderMoveNextMonthIcon.click();

			Thread.sleep(2000);

			// Select the In-hand date
			EnterPayment.InhandDate_Selection.click();

			Thread.sleep(2000);

			EnterPayment.InHandDate_Apply_Button.click();

			wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.elementToBeClickable(EnterPayment.DateConfirm));

			EnterPayment.DateConfirm.click();

			Thread.sleep(4000);
			// Select the In-Shipping date
			Click("Click Function", EnterPayment.Shipdate_CalenderIcon);

			// EnterPayment.Shipdate_CalenderIcon.click();
			Thread.sleep(4000);

			// Move to next month through next icon in date picker
			EnterPayment.CalenderMoveNextMonthIcon.click();

			// Select the In-Shipping date
			EnterPayment.Shipdate_Selection.click();

			wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.elementToBeClickable(EnterPayment.DateConfirm));

			EnterPayment.DateConfirm.click();
			Thread.sleep(13000);

			// Click the EnterPayment Button
			EnterPayment.Invoice_EnterPaymentButton.click();

			Thread.sleep(3000);
			// On Enter Payement Popup Validate the partial price verfication case
			EnterPayment.Invoice_EnterPaymentPopup_PayinFullCheckbox.click();
			Thread.sleep(3000);

			Input("enter shipping address", EnterPayment.Invoice_EnterPaymentPopup_PayinFullTextField, "0.52");

			// Press the save button
			EnterPayment.Invoice_EnterPaymentPopup_SaveButton.click();
			waitForElementNotVisible(120, driver, EnterPayment.SpinnerLoader);
			Thread.sleep(2000);

			// Now Validate Partial Payment Link exist
			Assert.assertTrue(EnterPayment.PartialPaymentLink.isDisplayed());
			/*
			 * if(EnterPayment.PartialPaymentLink.isDisplayed()) {
			 * System.out.println("Partial Payment link displayed Successfully");
			 * resultPass("Partial Payment Link Verification",
			 * "Partial Payment link displayed Successfully"); } else{
			 * System.out.println("Partial Payment link displayed UnSuccessfully");
			 * resultFail("Partial Payment Link Verification",
			 * "Partial Payment link displayed UnSuccessfully"); }
			 */
		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}

	}

	public static void Reorder() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			// Reorder the order
			Click("Click at OK button to confirm", EnterPayment.Orderdetails_MoreButton);
			Thread.sleep(2000);
			Click("Click at OK button to confirm", EnterPayment.MoreButton_Reorder);

			waitForPageLoading();
			Thread.sleep(2000);
			// waitForElementNotVisible(120, driver,EnterPayment.SpinnerLoader);
			Click("Click at OK button to confirm", EnterPayment.ContinueReorder);

			Thread.sleep(30000);
			Assert.assertTrue(
					EnterPayment.Reorder_Verifications.getText().contains("Your Sales Order has been copied!"));
			/*
			 * if(EnterPayment.Reorder_Verifications.getText().
			 * contains("Your Sales Order has been copied!")) {
			 * System.out.println("Reorder created successfully");
			 * resultPass("Reorder_Creation", "Reorder created successfully"); } else{
			 * System.out.println("Reorder created UnSuccessfully");
			 * resultFail("Reorder_Creation", "Reorder created UnSuccessfully");
			 * 
			 * }
			 */
		} catch (NoSuchElementException e) {
			e.getMessage();
		}

	}

	public static void FieldsData_Verification_AfterReorder() throws IOException, InterruptedException {
		try {

			String POFieldAfter_Reorder = EnterPayment.Order_POReferenceField.getText();

			String Inhanddate_AfterReorder = EnterPayment.SamplerRequest_Inhand_Date.getText();

			String ShipDate_AfterReorder = EnterPayment.ShipdateField.getText();
			Assert.assertTrue(POFieldAfter_Reorder.isEmpty() & Inhanddate_AfterReorder.isEmpty()
					& ShipDate_AfterReorder.isEmpty());
			/*
			 * if(POFieldAfter_Reorder.isEmpty() & Inhanddate_AfterReorder.isEmpty() &
			 * ShipDate_AfterReorder.isEmpty()) { System.out.
			 * println("Inhanddate,Shipdate,PO Reference and partial payment Data removed After Reorder Successfully"
			 * ); resultPass("FieldsData_Verification_AfterReorder",
			 * "Inhanddate,Shipdate,PO Reference and partial payment Data removed After Reorder Successfully"
			 * ); } else{ System.out.
			 * println("Inhanddate,Shipdate,PO Reference and partial payment Data removed After Reorder UnSuccessfully"
			 * ); resultFail("FieldsData_Verification_AfterReorder",
			 * "Inhanddate,Shipdate,PO Reference and partial payment Data removed After Reorder UnSuccessfully"
			 * ); }
			 */

		} catch (NoSuchElementException e) {

			e.getMessage();
		}
	}

	public static void New_InhandDate_AfterReorder_Verification() throws InterruptedException, IOException {
		try {
			SoftAssert softAssertion = new SoftAssert();
			// Select the In-hand date
			EnterPayment.Inhand_Orderdate_CalenderIcon.click();

			Thread.sleep(1000);

			// Move to next month through next icon in date picker
			EnterPayment.CalenderMoveNextMonthIcon.click();

			Thread.sleep(2000);

			// Select the In-hand date
			EnterPayment.InhandDate_Selection.click();

			Thread.sleep(2000);

			EnterPayment.InHandDate_Apply_Button.click();

			wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.elementToBeClickable(EnterPayment.DateConfirm));

			EnterPayment.DateConfirm.click();

			Thread.sleep(7000);

			WebElement InhandDate = EnterPayment.SamplerRequest_Inhand_Date;
			String Inhandvalue = InhandDate.getAttribute("value");
			System.out.println(Inhandvalue);

			// Press the Preview Button on order details
			EnterPayment.PreviewButton_Orderdetails.click();
			System.out.println("A");
			Thread.sleep(30000);

			wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.elementToBeClickable(EnterPayment.PreviewPopUp_SalesOrder));
			// Press the Purchase Order document
			EnterPayment.PreviewPopUp_SalesOrder.click();
			System.out.println("B");
			Thread.sleep(3000);

			// First store parent window to switch back
			SalesOrderPreview.parentWindow = driver.getWindowHandle();

			// Press the Preview Button
			EnterPayment.PreviewPopUp_PreviewButton.click();

			Thread.sleep(60000);
			System.out.println("C");
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				if (!winHandle.equals(SalesOrderPreview.parentWindow)) {
					driver.switchTo().window(winHandle);
				}
			}

			String Inhand_DatePreview = EnterPayment.InHand_At_SalesOrder_Verification_Preview.getText();
			System.out.println(Inhand_DatePreview);

			Assert.assertTrue(Inhand_DatePreview.contains(Inhandvalue));

			/*
			 * if(Inhand_DatePreview.contains(Inhandvalue)){ System.out.
			 * println("Inhand Date Updated after reorder in sales order document preview Successfully "
			 * ); resultPass("New_InhandDate_AfterReorder_Verification",
			 * "Inhand Date Updated after reorder in sales order document preview Successfully"
			 * ); } else{ System.out.
			 * println("Inhand Date Updated after reorder in sales order document preview UnSuccessfully "
			 * ); resultFail("New_InhandDate_AfterReorder_Verification",
			 * "Inhand Date Updated after reorder in sales order document preview UnSuccessfully"
			 * ); }
			 */
			softAssertion.assertAll();
			Thread.sleep(2000);

			driver.close();

			Thread.sleep(2000);

			// Switch back to parent window
			driver.switchTo().window(SalesOrderPreview.parentWindow);

			EnterPayment.ClosePreviewPopup.click();
			// Close the Preview Popup

			Thread.sleep(2000);

		} catch (NoSuchElementException e) {
			e.getMessage();
		}

		/*
		 * finally { Thread.sleep(2000);
		 * 
		 * driver.close();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * //Switch back to parent window
		 * driver.switchTo().window(SalesOrderPreview.parentWindow);
		 * 
		 * EnterPayment.ClosePreviewPopup.click(); //Close the Preview Popup
		 * 
		 * Thread.sleep(2000); }
		 */

	}

	public static void Linked_Transaction_ReOrder_Verification() throws IOException, InterruptedException {
		try {

			WebElement HoverLinkedTransaction11 = EnterPayment.QuoteOrderLinkedtransaction;
			Hover(HoverLinkedTransaction11);

			Thread.sleep(1000);

			// Validate as if the Linkedtrasaction link occur or not
			Assert.assertTrue(EnterPayment.LinkedTransactionDisplayedVerification.isDisplayed());
			Click("Save and Close", EnterPayment.CloseAndExit);
			/*
			 * if(EnterPayment.LinkedTransactionDisplayedVerification.isDisplayed()) {
			 * System.out.println("Linked Transaction Displayed on ReOrder Successfully");
			 * resultPass("Linked Transaction ReOrder Verification",
			 * "Linked Transaction Displayed on ReOrder Successfully"); } else{
			 * System.out.println("Linked Transaction Displayed on ReOrder UnSuccessfully");
			 * resultFail("Linked Transaction ReOrder Verification",
			 * "Linked Transaction Displayed on ReOrder UnSuccessfully"); }
			 */

		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}

	}

}
