package Functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;

import OrdersTestcases.Login;
import PageFactoryandTestdata.OrdersLocators;

public class ConversionsWithoutOtherCharges extends Login {

	public static double SubTotal;
	public static double AmountDue;
	public static double SalesTax;
	public static double BookedMargin;
	public static double Discount;
	public static double TotalCost;
	public static double TotalPrice;
	public static double TotalCostMargin;
	public static double TotalPriceMargin;
	public static double partialPaymentCalculation;
	public static double BookedMarginCalculation;
	public static double BookedMarginCalculation2;
	public static double BookedMarginTotal;
	public static String SubTotalText;
	public static String AmountDueText;
	public static String SalesTaxText;
	public static String BookedMarginText;
	public static String DiscountText;
	public static String TotalCostText;
	public static String TotalPriceText;
	public static String TotalCostText1;
	public static String TotalPriceText1;
	public static NumberFormat SubTotalFormat;
	public static NumberFormat AmountDueFormat;
	public static NumberFormat SalesTaxFormat;
	public static NumberFormat BookedMarginFormat;
	public static NumberFormat DiscountFormat;
	public static NumberFormat TotalCostFormat;
	public static NumberFormat TotalPriceFormat;
	public static NumberFormat TotalCostFormat1;
	public static NumberFormat TotalPriceFormat1;
	public static Number SubTotalNumber;
	public static Number AmountDueNumber;
	public static Number SalesTaxNumber;
	public static Number BookedMarginNumber;
	public static Number DiscountNumber;
	public static Number TotalCostNumber;
	public static Number TotalPriceNumber;
	public static Number TotalCostNumber1;
	public static Number TotalPriceNumber1;
	public static BigDecimal bd;
	public static BigDecimal bd1;
	public static BigDecimal bd2;
	public static String Orderno;
	public static double CalculateTax;
	public static double SubTotalWithTaxInclude;
	public static double TotalAmountDueWithTaxInclude;
	public static String TotalPrice_SplitShipment1text;
	public static String TotalPrice_SplitShipment2text;
	public static NumberFormat TotalPrice_SplitShipment1NumberFormat;
	public static NumberFormat TotalPrice_SplitShipment2NumberFormat;
	public static Number TotalPrice_SplitShipment1Number;
	public static Number TotalPrice_SplitShipment2Number;
	public static double TotalPrice1;
	public static double TotalPrice2;
	public static double TotalPriceSumAmount;
	public static String TotalPrice_Previewtext;
	public static NumberFormat TotalPricePreviewNumberFormat;
	public static Number TotalPricePreviewNumber;
	public static double TotalPricePreview;
	public static String TotalPrice_SalesPreviewtext;
	public static NumberFormat TotalPriceSalesPreviewNumberFormat;
	public static Number TotalPriceSalesPreviewNumber;
	public static double TotalPriceSalesPreview;
	public static String TotalCost_C_Removal;
	public static String TotalPrice_C_Removal;
	public static String PurchaseOrderPreviewAmount_C_Removal;
	public static String SalesOrderPreviewAmount_C_Removal;
	
	public static void Subtotal_String_To_Int_Conversion() throws ParseException{
		   
		// This is to Instantiate EditOrders  class  
		   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	 	    
		   //Converting subtotal from string to int
		   	 SubTotalText=EditOrderConfiguration.SubtotalWithoutServicecharges_InvoiceScreen.getText();
		   	 System.out.println(SubTotalText);
		   	 
		   	 SubTotalFormat = NumberFormat.getCurrencyInstance();
		   	 SubTotalNumber = SubTotalFormat.parse(SubTotalText);
		   	 System.out.println(SubTotalNumber.toString());
		   	 
		   	 SubTotal=Double.parseDouble(SubTotalNumber.toString());
		   	 System.out.println(SubTotal);
	   }

	public static void SalesTax_String_To_Int_Conversion() throws ParseException{
		
		// This is to Instantiate EditOrders  class  
	  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	    
		
		//Now Converting sales Tax from string to int
	  	 SalesTaxText=EditOrderConfiguration.SalesTaxWithoutServiceCharges_InvoiceScreen.getText();
	  	 System.out.println(SalesTaxText);
	  	 
	  	 SalesTaxFormat = NumberFormat.getCurrencyInstance();
	  	 SalesTaxNumber = SalesTaxFormat.parse(SalesTaxText);
	  	 System.out.println(SalesTaxNumber.toString());
	  	 
	  	SalesTax=Double.parseDouble(SalesTaxNumber.toString());
	  	 System.out.println(SalesTax); 
	  	 
	  	
}
	public static void AmountDue_String_To_Int_Conversion() throws ParseException{
		
		// This is to Instantiate EditOrders  class  
	  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
		
		//Now Converting the Amountdue from string to Int
	   	
		
		AmountDueText=EditOrderConfiguration.AmountDueWithoutServiceCharges_InvoiceScreen.getText();
	   	 System.out.println(AmountDueText);
	   	 
	   	 AmountDueFormat = NumberFormat.getCurrencyInstance();
	   	AmountDueNumber = AmountDueFormat.parse(AmountDueText);
	   	 System.out.println(AmountDueNumber.toString());
	   	 
	   	AmountDue=Double.parseDouble(AmountDueNumber.toString());
	   	 System.out.println(AmountDue);
	}

	public static void Tax_Calculation_Automatic(){
		
		//Calculating the tax now
	   	CalculateTax= (SubTotal * 6/ 100);
	   	
	   	System.out.println("Tax Calculated is"+CalculateTax);
	}
	
public static void Tax_Calculation_Manual(){
		
		//Calculating the tax now
	   	CalculateTax= (SubTotal * 5/ 100);
	   	
	   	System.out.println("Tax Calculated is"+CalculateTax);
	}

	public static void SubTotal_Calculation(){
		
		SubTotalWithTaxInclude=CalculateTax+SubTotal;
	   	
	   	System.out.println("Subtotal With Tax Inclusion:"+""+SubTotalWithTaxInclude);
	}
	public static void RoundingOffTotalAmount(){
		
		bd=new BigDecimal(SubTotalWithTaxInclude);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		System.out.println(bd.doubleValue());
		
		
	}

public static void AmountDueCalculation_AfterPartialPayment(){
	partialPaymentCalculation=AmountDue;
	System.out.println(partialPaymentCalculation);
	
}

public static void TotalPriceSplitShipment1_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	TotalPrice_SplitShipment1text=EditOrderConfiguration.TotalPrice_SplitShipment1.getText();
	   	 System.out.println(TotalPrice_SplitShipment1text);
	   	 
	   	TotalPrice_SplitShipment1NumberFormat = NumberFormat.getCurrencyInstance();
	   	TotalPrice_SplitShipment1Number = TotalPrice_SplitShipment1NumberFormat.parse(TotalPrice_SplitShipment1text);
	   	 System.out.println(TotalPrice_SplitShipment1Number.toString());
	   	 
	   	TotalPrice1=Double.parseDouble(TotalPrice_SplitShipment1Number.toString());
	   	 System.out.println(TotalPrice1);
   }

public static void TotalPriceSplitShipment2_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	 
	   	TotalPrice_SplitShipment2text=EditOrderConfiguration.TotalPrice_SplitShipment2.getText();
	   	 System.out.println(TotalPrice_SplitShipment2text);
	   	 
	   	TotalPrice_SplitShipment2NumberFormat = NumberFormat.getCurrencyInstance();
	   	TotalPrice_SplitShipment2Number = TotalPrice_SplitShipment2NumberFormat.parse(TotalPrice_SplitShipment2text);
	   	 System.out.println(TotalPrice_SplitShipment2Number.toString());
	   	 
	   	TotalPrice2=Double.parseDouble(TotalPrice_SplitShipment2Number.toString());
	   	 System.out.println(TotalPrice2);
   }

public static void TotalPrice_SumAmount(){
	TotalPriceSumAmount=TotalPrice1+TotalPrice2;
	System.out.println(TotalPriceSumAmount);
	
}

public static void TotalPricePreview_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	TotalPrice_Previewtext=EditOrderConfiguration.TotalPricePreview.getText();
	   	 System.out.println(TotalPrice_Previewtext);
	   	 
	   	TotalPricePreviewNumberFormat = NumberFormat.getCurrencyInstance();
	   	TotalPricePreviewNumber = TotalPricePreviewNumberFormat.parse(TotalPrice_Previewtext);
	   	 System.out.println(TotalPricePreviewNumber.toString());
	   	 
	   	TotalPricePreview=Double.parseDouble(TotalPricePreviewNumber.toString());
	   	 System.out.println(TotalPricePreview);
   }
public static void TotalPriceSalesPreview_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	TotalPrice_SalesPreviewtext=EditOrderConfiguration.SalesOrderPreview_TotalAmount.getText();
	   	 System.out.println(TotalPrice_SalesPreviewtext);
	   	 
	   	TotalPriceSalesPreviewNumberFormat = NumberFormat.getCurrencyInstance();
	   	TotalPriceSalesPreviewNumber = TotalPriceSalesPreviewNumberFormat.parse(TotalPrice_SalesPreviewtext);
	   	 System.out.println(TotalPriceSalesPreviewNumber.toString());
	   	 
	   	TotalPriceSalesPreview=Double.parseDouble(TotalPriceSalesPreviewNumber.toString());
	   	 System.out.println(TotalPriceSalesPreview);
   }

public static void TotalPriceQuotePreview_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	TotalPrice_SalesPreviewtext=EditOrderConfiguration.QuotePreviewTotal.getText();
	   	 System.out.println(TotalPrice_SalesPreviewtext);
	   	 
	   	TotalPriceSalesPreviewNumberFormat = NumberFormat.getCurrencyInstance();
	   	TotalPriceSalesPreviewNumber = TotalPriceSalesPreviewNumberFormat.parse(TotalPrice_SalesPreviewtext);
	   	 System.out.println(TotalPriceSalesPreviewNumber.toString());
	   	 
	   	TotalPriceSalesPreview=Double.parseDouble(TotalPriceSalesPreviewNumber.toString());
	   	 System.out.println(TotalPriceSalesPreview);
   }



public static void CanadianProduct_Subtotal_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	 SubTotalText=EditOrderConfiguration.CanadianProductOrder_Subtotal.getText();
	   	 System.out.println(SubTotalText);
	   	 
	   	 SubTotalFormat = NumberFormat.getCurrencyInstance();
	   	 SubTotalNumber = SubTotalFormat.parse(SubTotalText);
	   	 System.out.println(SubTotalNumber.toString());
	   	 
	   	 SubTotal=Double.parseDouble(SubTotalNumber.toString());
	   	 System.out.println(SubTotal);
   }

public static void CanadianProduct_SalesTax_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
    
	
	//Now Converting sales Tax from string to int
  	 SalesTaxText=EditOrderConfiguration.CanadianProductOrder_Tax.getText();
  	 System.out.println(SalesTaxText);
  	 
  	 SalesTaxFormat = NumberFormat.getCurrencyInstance();
  	 SalesTaxNumber = SalesTaxFormat.parse(SalesTaxText);
  	 System.out.println(SalesTaxNumber.toString());
  	 
  	SalesTax=Double.parseDouble(SalesTaxNumber.toString());
  	 System.out.println(SalesTax); 
  	 
  	
}
public static void CanadianProduct_AmountDue_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
   	
	
	AmountDueText=EditOrderConfiguration.CanadianProductOrder_AmountDue.getText();
   	 System.out.println(AmountDueText);
   	 
   	 AmountDueFormat = NumberFormat.getCurrencyInstance();
   	AmountDueNumber = AmountDueFormat.parse(AmountDueText);
   	 System.out.println(AmountDueNumber.toString());
   	 
   	AmountDue=Double.parseDouble(AmountDueNumber.toString());
   	 System.out.println(AmountDue);
}

public static void CanadianProduct_BookedMargin_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
   	
	
	BookedMarginText=EditOrderConfiguration.CanadianProductOrder_BookedMargin.getText();
   	 System.out.println(BookedMarginText);
   	 
   	 BookedMarginFormat = NumberFormat.getCurrencyInstance();
   	BookedMarginNumber = BookedMarginFormat.parse(BookedMarginText);
   	 System.out.println(BookedMarginNumber.toString());
   	 
   	BookedMargin=Double.parseDouble(BookedMarginNumber.toString());
   	 System.out.println(BookedMargin);
}
public static void CanadianProduct_Discount_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
   	
	
	DiscountText=EditOrderConfiguration.CanadianProductOrder_Discount.getText();
   	 System.out.println(DiscountText);
   	 
   	DiscountFormat = NumberFormat.getCurrencyInstance();
   	DiscountNumber = DiscountFormat.parse(DiscountText);
   	 System.out.println(DiscountNumber.toString());
   	 
   	Discount=Double.parseDouble(DiscountNumber.toString());
   	 System.out.println(Discount);
}

public static void CanadianProduct_TotalCost_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 //OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
   	
  	Remove_C_From_TotalCost();
	
  	TotalCostText=TotalCost_C_Removal;
   	 System.out.println(TotalCostText);
   	 
   	TotalCostFormat = NumberFormat.getCurrencyInstance();
   	TotalCostNumber = TotalCostFormat.parse(TotalCostText);
   	 System.out.println(TotalCostNumber.toString());
   	 
   	TotalCost=Double.parseDouble(TotalCostNumber.toString());
   	 System.out.println(TotalCost);
}

public static void CanadianProduct_TotalPrice_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 //OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
  	Remove_C_From_TotalPrice();
	
  	TotalPriceText=TotalPrice_C_Removal;
   	 System.out.println(TotalPriceText);
   	 
   	TotalPriceFormat = NumberFormat.getCurrencyInstance();
   	TotalPriceNumber = TotalPriceFormat.parse(TotalPriceText);
   	 System.out.println(TotalPriceNumber.toString());
   	 
   	TotalPrice=Double.parseDouble(TotalPriceNumber.toString());
   	 System.out.println(TotalPrice);
}

public static void BookedMargin_TotalPrice_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
  	
	
  	TotalPriceText1=EditOrderConfiguration.TotalPrice_Product2_BookedMargin.getText();
   	 System.out.println(TotalPriceText1);
   	 
   	TotalPriceFormat1 = NumberFormat.getCurrencyInstance();
   	TotalPriceNumber1 = TotalPriceFormat1.parse(TotalPriceText1);
   	 System.out.println(TotalPriceNumber1.toString());
   	 
   	TotalPriceMargin=Double.parseDouble(TotalPriceNumber1.toString());
   	 System.out.println(TotalPriceMargin);
}

public static void BookedMargin_TotalCost_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
  	
	
  	TotalCostText1=EditOrderConfiguration.TotalCost_Product2_BookedMargin.getText();
   	 System.out.println(TotalCostText1);
   	 
   	TotalCostFormat1 = NumberFormat.getCurrencyInstance();
   	TotalCostNumber1 = TotalCostFormat1.parse(TotalCostText1);
   	 System.out.println(TotalCostNumber1.toString());
   	 
   	TotalCostMargin=Double.parseDouble(TotalCostNumber1.toString());
   	 System.out.println(TotalCostMargin);
}
public static void CanadianProduct_PurchaseOrderAmount_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 //OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
	Remove_C_From_PurchaseOrder();
	
  	TotalPriceText=PurchaseOrderPreviewAmount_C_Removal;
   	 System.out.println(TotalPriceText);
   	 
   	TotalPriceFormat = NumberFormat.getCurrencyInstance();
   	TotalPriceNumber = TotalPriceFormat.parse(TotalPriceText);
   	 System.out.println(TotalPriceNumber.toString());
   	 
   	TotalPrice=Double.parseDouble(TotalPriceNumber.toString());
   	 System.out.println(TotalPrice);
}
public static void CanadianProduct_SalesOrder_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 //OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
	Remove_C_From_SalesOrder();
	
  	TotalPriceText=SalesOrderPreviewAmount_C_Removal;
   	 System.out.println(TotalPriceText);
   	 
   	TotalPriceFormat = NumberFormat.getCurrencyInstance();
   	TotalPriceNumber = TotalPriceFormat.parse(TotalPriceText);
   	 System.out.println(TotalPriceNumber.toString());
   	 
   	TotalPrice=Double.parseDouble(TotalPriceNumber.toString());
   	 System.out.println(TotalPrice);
}
public static void BookedMarginCalculation() throws ParseException{
	
	BookedMarginCalculation=TotalPrice-TotalCost-Discount;
	System.out.println(BookedMarginCalculation);
}

public static void RoundingOffBooked(){
	
	bd1=new BigDecimal(BookedMarginCalculation);
	bd1 = bd1.setScale(2, RoundingMode.HALF_UP);
	System.out.println(bd1.doubleValue());
	
	
}

public static void BookedMarginCalculation_With_MultipleProducts()
{
	BookedMarginCalculation2=TotalPriceMargin-TotalCostMargin-Discount;
	System.out.println(BookedMarginCalculation2);
}

public static void BookedMarginCalculation_MultipleProducts_Sum(){
	BookedMarginTotal=BookedMarginCalculation+BookedMarginCalculation2;
	System.out.println(BookedMarginTotal);
}

public static void RoundingOffMultipleProducts_BookedMargin(){
	bd2=new BigDecimal(BookedMarginTotal);
	bd2 = bd2.setScale(2, RoundingMode.HALF_UP);
	System.out.println(bd2.doubleValue());
}
public static void Remove_C_From_TotalCost(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	TotalCost_C_Removal=OrdernoConv.TotalCost_CanProduct.getText();
	
	TotalCost_C_Removal=TotalCost_C_Removal.replaceAll("[a-zA-Z]", "");
	
	System.out.println(TotalCost_C_Removal);
	
	
}

public static void Remove_C_From_TotalPrice(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	TotalPrice_C_Removal=OrdernoConv.TotalPrice_CanProduct.getText();
	
	TotalPrice_C_Removal=TotalPrice_C_Removal.replaceAll("[a-zA-Z]", "");
	
	System.out.println(TotalPrice_C_Removal);
	
	
}

public static void Remove_C_From_PurchaseOrder(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	PurchaseOrderPreviewAmount_C_Removal=OrdernoConv.CanadianProductOrder_PurchaseOrderPreview_Amountdue.getText();
	
	PurchaseOrderPreviewAmount_C_Removal=PurchaseOrderPreviewAmount_C_Removal.replaceAll("[a-zA-Z]", "");
	
	System.out.println(PurchaseOrderPreviewAmount_C_Removal);


}
public static void Remove_C_From_SalesOrder(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	SalesOrderPreviewAmount_C_Removal=OrdernoConv.CanadianProduct_SalesOrderPreview_AmountDue.getText();
	
	SalesOrderPreviewAmount_C_Removal=SalesOrderPreviewAmount_C_Removal.replaceAll("[a-zA-Z]", "");
	
	System.out.println(SalesOrderPreviewAmount_C_Removal);
}
}