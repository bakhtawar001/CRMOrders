package Master;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
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

import OrdersTestcases.AcknowlodgementPreview;
import OrdersTestcases.BrowserInitiation;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.CreateOrderwhenAddressnotmatching;
import OrdersTestcases.Login;
import OrdersTestcases.OrderLevel_OrderDownload;
import OrdersTestcases.PurchaseOrderPreview_WithDownloadVerification;
import OrdersTestcases.Requote_FromOrdersDetails_And_QuoteDetails;
import OrdersTestcases.SalesOrderPreview;
import PageFactoryandTestdata.HelpingFunction;

public class PreviewDocumentExecution extends  HelpingFunction {
	
	
	public static WebDriverWait wait;
	static Predicate<WebDriver> pageLoaded;
	static WebDriver input;
	static String user=System.getProperty("user.name");
	public static String downloadPath = "C:\\Users\\"+user+"\\Downloads";
	static String Suite="PreviewDocumentsExecution.html";

	
	@BeforeTest
	 public void Startup() throws InterruptedException, AWTException, IOException{

		 BrowserInitiation.StartBrowser(Suite);
		 }

	@Test(priority=0)
		public void LoginApp() throws IOException, InterruptedException, AWTException{
		 Login.login();
	 
}
	@Test(priority=1)

	public void AccessOrder_ForPreviewDoc() throws IOException, InterruptedException, AWTException{
		CreateOrder.AccessOrder_ForPreviewDocument();
	
  }
	
	 @Test(priority=2)
	  public void Purchase_OrderPreview_Verification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.Purchase_Order_Preview_Verification();
	  }
	  @Test(priority=3)
	  public void PurchaseOrder_SalesPersonDetailsPreviewVerification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_SalesPersonDetails_PreviewVerification();
	  }
	  @Test(priority=4)
	  public void PurchaseOrderPreview_TermsandPaywith() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrderPreview_TermsandPaywith();
	  }
	  
	  @Test(priority=42)
	  public void PurchaseOrderPreview_SplitShipment1_DetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrderPreview_SplitShipment1_Details_Verification();
	  }
	  
	  @Test(priority=43)
	  public void PurchaseOrderPreview_SplitShipment1_DecorationDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrderPreview_SplitShipment1_DecorationDetails_Verification();
	  }
	  
	  @Test(priority=44)
	  public void PurchaseOrder_PersonalizationDecorationDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_PersonalizationDecoration_DocDownload();
	  }
	  
	  @Test(priority=45)
	  public void PurchaseOrder_AtworkDecorationDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_AtworkDecoration_DocDownload();
	  }
	  
	  @Test(priority=46)
	  public void PurchaseOrder_PreviewShippingDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_PreviewShippingDetails_Verification();
	  }
	  
	  @Test(priority=47)
	  public void PurchaseOrder_BlindShipVerification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_BlindShip_Verification();
	  }
	  
	  @Test(priority=48)
	  public void PurchaseOrder_AtworkPODocDownload() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_AtworkPO_DocDownload();
	  }
	  
	  @Test(priority=49)
	  public void PurchaseOrder_POPDFDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_POPDF_DocDownload();
	  }
	  
	  @Test(priority=50)
	  public void Calculating_TotalCostOnPreview() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.Calculating_TotalCost_On_Preview();
	  }
	  @Test(priority=51)
	  public void Calculating_TotalPriceOnPreview() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.Calculating_TotalPrice_On_Preview();
	  }
	/*@Test(priority=51)
	  public void PackingList_DisplayVerification() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PackingList_Display_Verification();
	  }*/
	  
	  @Test(priority=52)
	  public void PurchaseOrder_PreviewPOSend() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderPreview_WithDownloadVerification.PurchaseOrder_Preview_POSend();
	  }
	 /* @Test(priority=53)
	  public void PurchaseOrder_POSend_POHistroy() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderHistory.PurchaseOrder_POSend_POHistroy();
	  }
	  @Test(priority=54)
	  public void VerifyOrder_CRM() throws IOException, InterruptedException, ParseException{
		  
		  PurchaseOrderHistory.VerifyOrder_CRM();
	  }*/
	  
	 @Test(priority=55)
	  public void SalesOrderPreviewSalesPersonDetails() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrderPreview_SalesPersonDetails();
	  }
	 @Test(priority=56)
	 public void SalesOrder_BillingShippingDetailsPreview() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrder_BillingShippingDetails_Preview();
	 }
	 @Test(priority=57)
	 public void SalesOrder_BlindshipVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrder_Blindship_Verification();
	 }
	 @Test(priority=58)
	 public void SalesOrderPreview_SplitShipment1_DetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrderPreview_SplitShipment1_Details_Verification();
	 }
	 @Test(priority=59)
	 public void SalesOrderPreview_SplitShipment1_DecorationDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrderPreview_SplitShipment1_DecorationDetails_Verification();
	 }
	 
	 @Test(priority=60)
	 public void SalesOrder_PreviewShippingFromDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrder_PreviewShippingFromDetails_Verification();
	 }
	 @Test(priority=61)
	 public void SalesOrder_ShippingFrom_BlindShipVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrder_ShippingFrom_BlindShip_Verification();
	 }
	 @Test(priority=62)
	 public void SalesOrderPreview_ShippingToDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrderPreview_ShippingToDetails_Verification();
	 }
	 @Test(priority=63)
	 public void SalesOrderPreviewInstructions() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrderPreview_Instructions();
	 }
	 @Test(priority=64)
	 public void SalesOrderPreview_ServicesDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrderPreview_ServicesDetails_Verification();
	 }
	 @Test(priority=65)
	 public void Calculating_TotalPrice_OnSalesPreview() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.Calculating_TotalPrice_On_SalesPreview();
	 }
	 @Test(priority=66)
	 public void SalesOrder_PDFDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrder_PDF_DocDownload();
	 }
	 @Test(priority=67)
	 public void PDFAttach_Checkbox_ischecked_bydefault() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.PDFAttach_Checkbox_ischecked_by_default();
	 }
	 @Test(priority=68)
	 public void SalesOrder_Preview_SalesOrderSend() throws IOException, InterruptedException, ParseException{
		  
		  SalesOrderPreview.SalesOrder_Preview_SalesOrder_Send();
	 }
	 
	 
	 @Test(priority=69)
	  public void AcknowledgementOrder_PreviewSalesPersonDetails() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.AcknowledgementOrder_Preview_SalesPersonDetails();
	  }
	 @Test(priority=70)
	  public void AckowlodgementPreview_SplitShipment1Details_Verification() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.AckowlodgementPreview_SplitShipment1_Details_Verification();
	  }
	  @Test(priority=71)
	  public void AcknowlodgementPreview_SplitShipment1DecorationDetails_Verification() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.AcknowlodgementPreview_SplitShipment1_DecorationDetails_Verification();
	  }
	  @Test(priority=72)
	  public void Ackowledgement_PreviewShippingFromDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.Ackowledgement_PreviewShippingFromDetails_Verification();
	  }
	  @Test(priority=73)
	  public void AckowledgementPreviewInstructions() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.AckowledgementPreview_Instructions();
	  }
	  @Test(priority=74)
	  public void AcknowledgementPreview_ServicesDetailsVerification() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.AcknowledgementPreview_ServicesDetails_Verification();
	  }
	  @Test(priority=75)
	  public void Ackowledgement_PersonalizationDecorationDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.Ackowledgement_PersonalizationDecoration_DocDownload();
	  }
	  @Test(priority=76)
	  public void Ackowledgement_PDFDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.Ackowledgement_PDF_DocDownload();
	  }
	  @Test(priority=77)
	  public void Calculating_TotalPrice_OnAckowledgementPreview() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.Calculating_TotalPrice_On_AckowledgementPreview();
	  }
	  @Test(priority=78)
	  public void Acknowledgement_PreviewAckSend() throws IOException, InterruptedException, ParseException{
		  
		  AcknowlodgementPreview.Acknowledgement_Preview_AckSend();
	  }
	  
	  @Test(priority=79)
	  public void PurchaseOrder_OrderLevel_POPDFDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  OrderLevel_OrderDownload.PurchaseOrder_OrderLevel_POPDF_DocDownload();
	  }
	  
	  @Test(priority=80)
	  public void SalesOrder_PreviewDownloadPopup_PDFDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  OrderLevel_OrderDownload.SalesOrder_PreviewDownloadPopup_PDF_DocDownload();
	  }
	  
	  @Test(priority=81)
	  public void AckowledgementDownloadPopup_PDFDocDownload() throws IOException, InterruptedException, ParseException{
		  
		  OrderLevel_OrderDownload.AckowledgementDownloadPopup_PDF_DocDownload();
	  }
	  
	   @Test(priority=82)
	   public void Tax_not_calculating_if_Canadian_address_is_notmatching() throws IOException, InterruptedException, AWTException{
		    
		   CreateOrderwhenAddressnotmatching.Tax_not_calculating_if_Canadian_address_is_not_matching();
	   }
	   
	   @Test(priority=83)
	   public void Tax_is_not_calculating_if_Canadian_addressisnotmatching() throws IOException, InterruptedException, AWTException{
		    
		   CreateOrderwhenAddressnotmatching.Tax_is_not_calculating_if_Canadian_addressis_notmatching();
	   }
	   
		@Test(priority=84)
		   public void SameAsBilling_ShippingAddress_Verification_OrderLevel() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.SameAsBilling_ShippingAddress_Verification_Order_Level();
		
		}
		
		@Test(priority=85)
		   public void CPN_Number_EditProductConfigVerification() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.CPN_Number_EditProductConfig_Verification();
		
		}
		
		@Test(priority=86)
		   public void SameAsBilling_ShippingAddress_Verification_ProductLevel() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.SameAsBilling_ShippingAddress_Verification_Product_Level();
		
		}
		@Test(priority=87)
		   public void SameAsBilling_AcknowledgementAddress_Verification_OrderLevel() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.SameAsBilling_AcknowledgementAddress_Verification_Order_Level();
		
		}
		
		 @Test(priority=88)
		   public void ProfitMaker_SendVerification() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.ProfitMaker_Send_Verification();
		   }
		 @Test(priority=89)
		   public void ManageCurrancy_USD_OrderLevel() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.ManageCurrancy_USD_OrderLevel();
		   }
		 @Test(priority=90)
		   public void ManageCurrancy_CAD_OrderLevel() throws IOException, InterruptedException, AWTException{
			     
			   Requote_FromOrdersDetails_And_QuoteDetails.ManageCurrancy_CAD_OrderLevel();
		   }
		
	   @Test(priority=91)
	   public void Requote_From_OrdersDetails() throws IOException, InterruptedException, AWTException{
		     
		   Requote_FromOrdersDetails_And_QuoteDetails.CreateQuote_From_Orders_Details();
	   }
	   
	  
	

	   @AfterMethod
	 	public void getResult(ITestResult result){
	 		test = extent.createTest(result.getName());
	 	if(result.getStatus()==ITestResult.SUCCESS){
	 		test.log(Status.PASS, result.getMethod().getDescription());
	 			
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case is Passed", ExtentColor.GREEN));
	 			 extent.flush();
	 		}
	 		if(result.getStatus()==ITestResult.FAILURE){
	 			test.log(Status.FAIL, result.getMethod().getDescription());
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
	 			 test.fail(result.getThrowable());
	 			 extent.flush();
	 		}
	 		
	 		
	 	}

	@AfterTest
	public void teardown(){
	 	
	 	
	 driver.close();
	}

}
