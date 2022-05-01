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
import org.openqa.selenium.support.PageFactory;
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
import OrdersTestcases.AddShipmentAddress_With_DifferentCompany;
import OrdersTestcases.BackButton;
import OrdersTestcases.BlindShip_WithConfirmations;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.CreateOrderServices;
import OrdersTestcases.CreateOrderServices_WithTax;
import OrdersTestcases.EditOrderProduct_Configuration;
import OrdersTestcases.EditOrderProduct_Decoration;
import OrdersTestcases.EditOrderProduct_Instructions;
import OrdersTestcases.Login;
import OrdersTestcases.ManualSalesTax_Calculation;
import OrdersTestcases.MultipleShippingAddress;
import OrdersTestcases.OrderDeletion;
import OrdersTestcases.ProductAndSupplierClickable;
import OrdersTestcases.Setting_OrdersStatus;
import OrdersTestcases.Settings_SalesTaxDisabling_WithConfiguration;
import OrdersTestcases.Settings_ShippingTaxDisabling_WithConfiguration;
import OrdersTestcases.ShippingTaxCalculations_Verification_WithoutTaxes;
import OrdersTestcases.SplitShipment;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;

public class OrdersExecution2 extends HelpingFunction {

	public static WebDriverWait wait;
	static Predicate<WebDriver> pageLoaded;
	static WebDriver input;
	static String user = System.getProperty("user.name");
	public static String downloadPath = "C:\\Users\\" + user + "\\Downloads";
	static String Suite = "IDAHO_OrderExecution2.html";

	@BeforeTest
	public void Startup() throws InterruptedException, AWTException, IOException {

		StartBrowser.StartupBrowser(Suite);
	}

	@Test(priority = 0)
	public void LoginApp() throws IOException, InterruptedException, AWTException {
		Login.login();

	}

	@Test(priority = 1)
	public void AutomaticSalesTax_check() throws IOException, InterruptedException, AWTException {
		Settings_SalesTaxDisabling_WithConfiguration.AutomaticSalesTax_check();

	}

	@Test(priority = 2)
	public void Create_NewOrderStatus() throws IOException, InterruptedException, AWTException {
		/*
		 * OrdersLocators SalesOrderPreview = PageFactory.initElements(driver,
		 * OrdersLocators.class); SalesOrderPreview.ESPWebHomePage_OrdersTab.click();
		 * Thread.sleep(2000); Click("Click orders title tab",
		 * SalesOrderPreview.Orders_Title_Tab);
		 * SalesOrderPreview.OrderlistingSearch.sendKeys("601413"); Thread.sleep(7000);
		 * //Select existing created order from Top of the list
		 * SalesOrderPreview.OrderListing_Orderselection.click(); waitForPageLoading();
		 */
		Setting_OrdersStatus.Create_NewOrderStatus();

	}

	@Test(priority = 3)
	public void UploadDSTFiles_Orderlevel() throws IOException, InterruptedException, AWTException {
		OrderDeletion.UploadDSTFile_Orderlevel();

	}

	@Test(priority = 4)
	public void CreateOrder_OrderStatusDropdown() throws IOException, InterruptedException, AWTException {
		Setting_OrdersStatus.CreateOrder_OrderStatusDropdown();

	}

	@Test(priority = 5)
	public void CreateOrder_NewOrderStatus_NotesVerification() throws IOException, InterruptedException, AWTException {
		Setting_OrdersStatus.CreateOrder_NewOrderStatus_NotesVerification();

	}

	@Test(priority = 6)

	public void Product_AddedTo_Order() throws IOException, InterruptedException, AWTException {

		CreateOrder.Product_Added_To_Order();
	}

	@Test(priority = 7)
	public void Send_ASI_SmartBookslink_Verification() throws IOException, InterruptedException, AWTException {
		// Create Order
		CreateOrder.Send_ASI_SmartBooks_link_Verification();
	}

	@Test(priority = 8)
	public void CreateOrder() throws IOException, InterruptedException, AWTException {
		// Create Order
		CreateOrder.Create_Order();
	}

	@Test(priority = 9)
	public void PNameandSupplierASInoAreClickable() throws IOException, InterruptedException, AWTException {
		// Create Order
		ProductAndSupplierClickable.LinksAreClickable();
	}

	@Test(priority = 10)
	public void BackButton() throws IOException, InterruptedException {
		// Create Order
		BackButton.BackButtonVerification();
	}

	@Test(priority = 11)
	public void OrderProductConfig_NewAddCharge_in_Configuration_WithAmount_Verification()
			throws IOException, InterruptedException, ParseException {

		EditOrderProduct_Configuration.OrderProductConfig_NewAddCharge_in_Configuration_With_Amount_Verification();
	}

	@Test(priority = 12)
	public void AddVendor_Charge_WithAmount_calculation() throws IOException, InterruptedException, ParseException {

		EditOrderProduct_Configuration.AddVendor_Charge_With_Amount_calculation();
	}

	@Test(priority = 13)
	public void Existing_Artwork_File_UploadVerification()
			throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Existing_Artwork_File_Upload_Verification();
	}

	@Test(priority = 14)
	public void Artwork_DownloadUnderDecorationTab()
			throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Artwork_Download_UnderDecorationTab();
	}

	@Test(priority = 15)
	public void Artwork_Uncheck_VisibleCheckbox()
			throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Artwork_Uncheck_VisibleCheckbox();
	}

	@Test(priority = 16)
	public void ArtworkVisibility_OnAcknowledgementDoc()
			throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Artwork_Visibility_AcknowledgementDoc();
	}

	@Test(priority = 17)
	public void ProofEmailAddres() throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.ProofEmailAddres();
	}

	@Test(priority = 18)
	public void Artwork_FileDeletion() throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Artwork_File_Deletion();
	}

	@Test(priority = 19)
	public void Decoration_Charge_With_Amountcalculation()
			throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Decoration_Charge_With_Amount_calculation();
	}

	@Test(priority = 20)
	public void Verificationof_Decoration_Display_Under_DecorationTab()
			throws IOException, InterruptedException, ParseException, AWTException {

		EditOrderProduct_Decoration.Verificationof_Decoration_Display_Under_Decoration_Tab();
	}

	@Test(priority = 21)
	public void AddingInstructions() throws IOException, InterruptedException, ParseException {

		EditOrderProduct_Instructions.Adding_Instructions();
	}

	@Test(priority = 22)
	public void InstructionsViewing() throws IOException, InterruptedException, ParseException {

		EditOrderProduct_Instructions.Instructions_Viewing();
	}

	@Test(priority = 23)
	public void Settings_SalesTaxConfig() throws IOException, InterruptedException {
		Settings_SalesTaxDisabling_WithConfiguration.AutomaticSalesTax_Uncheck();
	}

	@Test(priority = 24)
	public void ManualSalesTaxCalculation() throws IOException, InterruptedException, ParseException {
		ManualSalesTax_Calculation.ManualSalesTax_Calculation_Order();
	}

	@Test(priority = 25)
	public void Freight_ServicePopup_Display() throws IOException, InterruptedException, ParseException {

		// Create Order Service
		CreateOrderServices.Freight_Service_Popup_Display();
	}

	@Test(priority = 26)
	public void Freight_Title_Field_TextValidation() throws IOException, InterruptedException, ParseException {

		// Create Order Service
		CreateOrderServices.Freight_Title_Field_Text_Validation();
	}

	@Test(priority = 27)
	public void Freight_TitleUpdate() throws IOException, InterruptedException, ParseException {

		// Create Order Service
		CreateOrderServices.Freight_Title_Update();
	}

	@Test(priority = 28)
	public void Services_VendorCompanyVerification() throws IOException, InterruptedException, ParseException {
		CreateOrderServices.Services_VendorCompany_Verification();
	}

	@Test(priority = 29)
	public void Freight_Service_Add_TaxCalculation_Verification()
			throws IOException, InterruptedException, ParseException {

		// Create Order Service
		CreateOrderServices.Freight_Service_Add_Tax_Calculation_Verification();
	}

	@Test(priority = 30)
	public void Settings_ShippingTaxConfig() throws IOException, InterruptedException, ParseException {

		Settings_ShippingTaxDisabling_WithConfiguration.AutomaticShippingTax_Uncheck();
	}

	@Test(priority = 31)
	public void Settings_ShippingTaxCalculationVerify() throws IOException, InterruptedException, ParseException {

		ShippingTaxCalculations_Verification_WithoutTaxes.ShippingTax_Calculation_Order_WithDisablingTax();
	}

	@Test(priority = 32)
	public void TaxCalculationWithServiceTypeCredit() throws IOException, InterruptedException, ParseException {
		// Calculating tax on service type credit in Freight
		CreateOrderServices_WithTax.Services_WithTax_TypeCredit();
	}

	@Test(priority = 33)
	public void MultiShippingAddress() throws IOException, InterruptedException, ParseException {

		MultipleShippingAddress.multiShippingAddress();
	}

	@Test(priority = 34)
	public void Zero_Quantity_Validation_MessageVerification()
			throws IOException, InterruptedException, ParseException {

		SplitShipment.Zero_Quantity_Validation_Message_Verification();
	}

	@Test(priority = 35)
	public void SplitShipment_not_showingin_shippingtab() throws IOException, InterruptedException, ParseException {

		SplitShipment.SplitShipment_not_showing_in_shippingtab();
	}

	@Test(priority = 36)
	public void SplitShipment_Showing_inPricing_tab() throws IOException, InterruptedException, ParseException {

		SplitShipment.SplitShipment_Showing_in_Pricing_tab();
	}

	@Test(priority = 37)
	public void SplitShipment_Showing_inDecoration_tab() throws IOException, InterruptedException, ParseException {

		SplitShipment.SplitShipment_Showing_in_Decoration_tab();
	}

	@Test(priority = 38)
	public void SplitShipment_Showingin_PurchaseOrder_tab() throws IOException, InterruptedException, ParseException {

		SplitShipment.SplitShipment_Showing_in_PurchaseOrder_tab();
	}

	@Test(priority = 39)
	public void TwoPOsCreation() throws IOException, InterruptedException, ParseException {

		AddShipmentAddress_With_DifferentCompany.TwoPOs_Creation();
	}

	@Test(priority = 40)
	public void New_DestinationAddress_WithDifferentCompany() throws IOException, InterruptedException, ParseException {

		AddShipmentAddress_With_DifferentCompany.New_DestinationAddress_With_DifferentCompany();
	}

	@Test(priority = 41)
	public void BlindShip_WithConfirmation() throws IOException, InterruptedException, ParseException {

		BlindShip_WithConfirmations.BlindShipWithConfirmation();
	}

	/*
	 * @Test(priority=39) public void Purchase_OrderPreview_Verification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * Purchase_Order_Preview_Verification(); }
	 * 
	 * @Test(priority=40) public void
	 * PurchaseOrder_SalesPersonDetailsPreviewVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrder_SalesPersonDetails_PreviewVerification(); }
	 * 
	 * @Test(priority=41) public void PurchaseOrderPreview_TermsandPaywith() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrderPreview_TermsandPaywith(); }
	 * 
	 * @Test(priority=42) public void
	 * PurchaseOrderPreview_SplitShipment1_DetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrderPreview_SplitShipment1_Details_Verification(); }
	 * 
	 * @Test(priority=43) public void
	 * PurchaseOrderPreview_SplitShipment1_DecorationDetailsVerification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrderPreview_SplitShipment1_DecorationDetails_Verification(); }
	 * 
	 * @Test(priority=44) public void
	 * PurchaseOrder_PersonalizationDecorationDocDownload() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrder_PersonalizationDecoration_DocDownload(); }
	 * 
	 * @Test(priority=45) public void PurchaseOrder_AtworkDecorationDocDownload()
	 * throws IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrder_AtworkDecoration_DocDownload(); }
	 * 
	 * @Test(priority=46) public void
	 * PurchaseOrder_PreviewShippingDetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrder_PreviewShippingDetails_Verification(); }
	 * 
	 * @Test(priority=47) public void PurchaseOrder_BlindShipVerification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrder_BlindShip_Verification(); }
	 * 
	 * @Test(priority=48) public void PurchaseOrder_AtworkPODocDownload() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PurchaseOrder_AtworkPO_DocDownload(); }
	 * 
	 * @Test(priority=49) public void PurchaseOrder_POPDFDocDownload() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_POPDF_DocDownload
	 * (); }
	 * 
	 * @Test(priority=50) public void Calculating_TotalPriceOnPreview() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * Calculating_TotalPrice_On_Preview(); }
	 * 
	 * @Test(priority=51) public void PackingList_DisplayVerification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.
	 * PackingList_Display_Verification(); }
	 * 
	 * @Test(priority=52) public void PurchaseOrder_PreviewPOSend() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_Preview_POSend();
	 * }
	 * 
	 * @Test(priority=53) public void PurchaseOrder_POSend_POHistroy() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * PurchaseOrderHistory.PurchaseOrder_POSend_POHistroy(); }
	 * 
	 * @Test(priority=53) public void VerifyOrder_CRM() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * PurchaseOrderHistory.VerifyOrder_CRM(); }
	 * 
	 * @Test(priority=54) public void SalesOrderPreviewSalesPersonDetails() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrderPreview_SalesPersonDetails(); }
	 * 
	 * @Test(priority=55) public void SalesOrder_BillingShippingDetailsPreview()
	 * throws IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrder_BillingShippingDetails_Preview(); }
	 * 
	 * @Test(priority=56) public void SalesOrder_BlindshipVerification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrder_Blindship_Verification(); }
	 * 
	 * @Test(priority=57) public void
	 * SalesOrderPreview_SplitShipment1_DetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrderPreview_SplitShipment1_Details_Verification(); }
	 * 
	 * @Test(priority=57) public void
	 * SalesOrderPreview_SplitShipment1_DecorationDetailsVerification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.
	 * SalesOrderPreview_SplitShipment1_DecorationDetails_Verification(); }
	 * 
	 * @Test(priority=58) public void
	 * SalesOrder_PreviewShippingFromDetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrder_PreviewShippingFromDetails_Verification(); }
	 * 
	 * @Test(priority=59) public void
	 * SalesOrder_ShippingFrom_BlindShipVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrder_ShippingFrom_BlindShip_Verification(); }
	 * 
	 * @Test(priority=60) public void
	 * SalesOrderPreview_ShippingToDetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrderPreview_ShippingToDetails_Verification(); }
	 * 
	 * @Test(priority=61) public void SalesOrderPreviewInstructions() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrderPreview_Instructions(); }
	 * 
	 * @Test(priority=62) public void
	 * SalesOrderPreview_ServicesDetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrderPreview_ServicesDetails_Verification(); }
	 * 
	 * @Test(priority=63) public void Calculating_TotalPrice_OnSalesPreview() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.Calculating_TotalPrice_On_SalesPreview(); }
	 * 
	 * @Test(priority=64) public void SalesOrder_PDFDocDownload() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrder_PDF_DocDownload(); }
	 * 
	 * @Test(priority=65) public void PDFAttach_Checkbox_ischecked_bydefault()
	 * throws IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.PDFAttach_Checkbox_ischecked_by_default(); }
	 * 
	 * @Test(priority=66) public void SalesOrder_Preview_SalesOrderSend() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * SalesOrderPreview.SalesOrder_Preview_SalesOrder_Send(); }
	 * 
	 * 
	 * @Test(priority=67) public void
	 * AcknowledgementOrder_PreviewSalesPersonDetails() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.AcknowledgementOrder_Preview_SalesPersonDetails(); }
	 * 
	 * @Test(priority=68) public void
	 * AckowlodgementPreview_SplitShipment1Details_Verification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.
	 * AckowlodgementPreview_SplitShipment1_Details_Verification(); }
	 * 
	 * @Test(priority=69) public void
	 * AcknowlodgementPreview_SplitShipment1DecorationDetails_Verification() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.
	 * AcknowlodgementPreview_SplitShipment1_DecorationDetails_Verification(); }
	 * 
	 * @Test(priority=70) public void
	 * Ackowledgement_PreviewShippingFromDetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.Ackowledgement_PreviewShippingFromDetails_Verification
	 * (); }
	 * 
	 * @Test(priority=71) public void AckowledgementPreviewInstructions() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.AckowledgementPreview_Instructions(); }
	 * 
	 * @Test(priority=72) public void
	 * AcknowledgementPreview_ServicesDetailsVerification() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.AcknowledgementPreview_ServicesDetails_Verification();
	 * }
	 * 
	 * @Test(priority=73) public void
	 * Ackowledgement_PersonalizationDecorationDocDownload() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.Ackowledgement_PersonalizationDecoration_DocDownload()
	 * ; }
	 * 
	 * @Test(priority=74) public void Ackowledgement_PDFDocDownload() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.Ackowledgement_PDF_DocDownload(); }
	 * 
	 * @Test(priority=75) public void
	 * Calculating_TotalPrice_OnAckowledgementPreview() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.Calculating_TotalPrice_On_AckowledgementPreview(); }
	 * 
	 * @Test(priority=76) public void Acknowledgement_PreviewAckSend() throws
	 * IOException, InterruptedException, ParseException{
	 * 
	 * AcknowlodgementPreview.Acknowledgement_Preview_AckSend(); }
	 * 
	 * @Test(priority=77) public void PurchaseOrder_OrderLevel_POPDFDocDownload()
	 * throws IOException, InterruptedException, ParseException{
	 * 
	 * OrderLevel_OrderDownload.PurchaseOrder_OrderLevel_POPDF_DocDownload(); }
	 * 
	 * @Test(priority=78) public void
	 * SalesOrder_PreviewDownloadPopup_PDFDocDownload() throws IOException,
	 * InterruptedException, ParseException{
	 * 
	 * OrderLevel_OrderDownload.SalesOrder_PreviewDownloadPopup_PDF_DocDownload(); }
	 * 
	 * @Test(priority=79) public void AckowledgementDownloadPopup_PDFDocDownload()
	 * throws IOException, InterruptedException, ParseException{
	 * 
	 * OrderLevel_OrderDownload.AckowledgementDownloadPopup_PDF_DocDownload(); }
	 * 
	 * @Test(priority=80) public void
	 * Tax_not_calculating_if_Canadian_address_is_notmatching() throws IOException,
	 * InterruptedException, AWTException{
	 * 
	 * CreateOrderwhenAddressnotmatching.
	 * Tax_not_calculating_if_Canadian_address_is_not_matching(); }
	 * 
	 * @Test(priority=81) public void
	 * Tax_is_not_calculating_if_Canadian_addressisnotmatching() throws IOException,
	 * InterruptedException, AWTException{
	 * 
	 * CreateOrderwhenAddressnotmatching.
	 * Tax_is_not_calculating_if_Canadian_addressis_notmatching(); }
	 * 
	 * @Test(priority=82) public void
	 * SameAsBilling_ShippingAddress_Verification_OrderLevel() throws IOException,
	 * InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.
	 * SameAsBilling_ShippingAddress_Verification_Order_Level();
	 * 
	 * }
	 * 
	 * @Test(priority=83) public void CPN_Number_EditProductConfigVerification()
	 * throws IOException, InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.
	 * CPN_Number_EditProductConfig_Verification();
	 * 
	 * }
	 * 
	 * @Test(priority=84) public void
	 * SameAsBilling_ShippingAddress_Verification_ProductLevel() throws IOException,
	 * InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.
	 * SameAsBilling_ShippingAddress_Verification_Product_Level();
	 * 
	 * }
	 * 
	 * @Test(priority=85) public void
	 * SameAsBilling_AcknowledgementAddress_Verification_OrderLevel() throws
	 * IOException, InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.
	 * SameAsBilling_AcknowledgementAddress_Verification_Order_Level();
	 * 
	 * }
	 * 
	 * @Test(priority=86) public void ProfitMaker_SendVerification() throws
	 * IOException, InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.ProfitMaker_Send_Verification(); }
	 * 
	 * 
	 * @Test(priority=87) public void Requote_From_OrdersDetails() throws
	 * IOException, InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.CreateQuote_From_Orders_Details();
	 * }
	 * 
	 * 
	 * @Test(priority=88) public void Requote_From_QuoteDetails() throws
	 * IOException, InterruptedException, AWTException{
	 * 
	 * Requote_FromOrdersDetails_And_QuoteDetails.Requote_From_Quote_Details(); }
	 */

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

		driver.quit();
	}

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
