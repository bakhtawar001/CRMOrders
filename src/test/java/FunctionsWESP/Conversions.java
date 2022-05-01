package FunctionsWESP;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;

public class Conversions extends WESPORDER {

	public static double SubTotal;
	public static double AmountDue;
	public static double SalesTax;
	public static double TotalPrice;
	public static String OrderNumberText;
	public static Number OrderNumberNumber;
	public static NumberFormat OrderNumberFormat;
	public static int OrderNumber;
	public static double FreightWithCreditServiceNewtotalPrice;
	public static String SubTotalText;
	public static String AmountDueText;
	public static String SalesTaxText;
	public static NumberFormat SubTotalFormat;
	public static NumberFormat AmountDueFormat;
	public static NumberFormat SalesTaxFormat;
	public static Number SubTotalNumber;
	public static Number AmountDueNumber;
	public static Number SalesTaxNumber;
	public static String Orderno;
	public static double CalculateTax;
	public static double SubTotalWithTaxInclude;
	public static double TotalAmountDueWithTaxInclude;
	public static BigDecimal bd;
	public static String TotalPriceText;
	public static Number TotalPriceNumber;
	public static NumberFormat TotalPriceFormat;
	public static double CreditServiceTotalWithTax;
	public static String FreightWithCrdeitTypeText;
	public static NumberFormat FreightWithCrdeitTypeFormat;
	public static Number FreightWithCrdeitTypeNumber;
	public static String OrdernoPreview;
	public static String Ordernopreview;
	public static double SumSubtotalandTax_WithSalesPreviewAmountMatch;
	
	
	
   public static void Subtotal_String_To_Int_Conversion() throws ParseException{
	   
	// This is to Instantiate EditOrders  class  
	   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
 	    
	   //Converting subtotal from string to int
	   	 SubTotalText=EditOrderConfiguration.Orderdetails_SubTotal.getText();
	   	 System.out.println(SubTotalText);
	   	 
	   	 SubTotalFormat = NumberFormat.getCurrencyInstance();
	   	 SubTotalNumber = SubTotalFormat.parse(SubTotalText);
	   	 System.out.println(SubTotalNumber.toString());
	   	 
	   	 SubTotal=Double.parseDouble(SubTotalNumber.toString());
	   	 System.out.println(SubTotal);
   }
   
   public static void SubtotalQuote_String_To_Int_Conversion() throws ParseException{
	   
		// This is to Instantiate EditOrders  class  
		   	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	 	    
		   //Converting subtotal from string to int
		   	 SubTotalText=EditOrderConfiguration.QuoteSubtotal.getText();
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
  	 SalesTaxText=EditOrderConfiguration.Orderdetails_SalesTax.getText();
  	 System.out.println(SalesTaxText);
  	 
  	 SalesTaxFormat = NumberFormat.getCurrencyInstance();
  	 SalesTaxNumber = SalesTaxFormat.parse(SalesTaxText);
  	 System.out.println(SalesTaxNumber.toString());
  	 
  	SalesTax=Double.parseDouble(SalesTaxNumber.toString());
  	 System.out.println(SalesTax); 
  	 
  	

}

public static void SalesTaxQuote_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
    
	
	//Now Converting sales Tax from string to int
  	 SalesTaxText=EditOrderConfiguration.QuoteSalesTax.getText();
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
   	
	
	AmountDueText=EditOrderConfiguration.Orderdetails_AmountDue.getText();
   	 System.out.println(AmountDueText);
   	 
   	 AmountDueFormat = NumberFormat.getCurrencyInstance();
   	AmountDueNumber = AmountDueFormat.parse(AmountDueText);
   	 System.out.println(AmountDueNumber.toString());
   	 
   	AmountDue=Double.parseDouble(AmountDueNumber.toString());
   	 System.out.println(AmountDue);
}

public static void AmountDueQuote_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
  	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	
	//Now Converting the Amountdue from string to Int
   	
	
	AmountDueText=EditOrderConfiguration.QuoteTotal.getText();
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

public static void Tax_Calculation_Automatic_Canadian(){
	
	//Calculating the tax now
   	CalculateTax= (SubTotal * 13/ 100);
   	
   	System.out.println("Tax Calculated is"+CalculateTax);
}

public static void SubTotal_Calculation(){
	
	SubTotalWithTaxInclude=CalculateTax+SubTotal;
   	
   	System.out.println("Subtotal With Tax Inclusion:"+""+SubTotalWithTaxInclude);
}

public static void Tax_Calculation_Manual(){
	//Calculating the tax now
   	CalculateTax= (SubTotal * 5/ 100);
   	
   	System.out.println("Tax Calculated is"+CalculateTax);
	
}

public static void RoundingOffTotalAmount(){
	
	bd=new BigDecimal(SubTotalWithTaxInclude);
	bd = bd.setScale(2, RoundingMode.HALF_UP);
	System.out.println(bd.doubleValue());
	
	
}
public static void TotalPrice_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
 	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	 //Converting subtotal from string to int
 	TotalPriceText=EditOrderConfiguration.Orderdetails_TotalPrice.getText();
  	 System.out.println(TotalPriceText);
  	 
  	TotalPriceFormat = NumberFormat.getCurrencyInstance();
  	TotalPriceNumber = TotalPriceFormat.parse(TotalPriceText);
  	 System.out.println(TotalPriceNumber.toString());
  	 
  	TotalPrice=Double.parseDouble(TotalPriceNumber.toString());
  	 System.out.println(TotalPrice);
}

public static void FreightNewPriceWithCreditService_String_To_Int_Conversion() throws ParseException{
	
	// This is to Instantiate EditOrders  class  
 	 OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	 //Converting subtotal from string to int
 	FreightWithCrdeitTypeText=EditOrderConfiguration.Orderdetails_FreightwithcreditTypePrice.getText();
  	 System.out.println(FreightWithCrdeitTypeText);
  	 
  	FreightWithCrdeitTypeFormat = NumberFormat.getCurrencyInstance();
  	FreightWithCrdeitTypeNumber = FreightWithCrdeitTypeFormat.parse(FreightWithCrdeitTypeText);
  	 System.out.println(FreightWithCrdeitTypeNumber.toString());
  	 
  	FreightWithCreditServiceNewtotalPrice=Double.parseDouble(FreightWithCrdeitTypeNumber.toString());
  	 System.out.println(FreightWithCreditServiceNewtotalPrice);
}

public static void OrdernumberRegularExpressionStringConversion(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	Orderno=OrdernoConv.OrderNumber.getText();
	
	Orderno=Orderno.replaceAll("[-+.^:,#a-zA-Z]", "");
	
	System.out.println(Orderno);
	
	
}

public static void OrdernumberPreviewConversion(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	Ordernopreview=OrdernoConv.OrdernoPreviewVerification.getText();
	
	Ordernopreview=Ordernopreview.replaceAll("[-+.^:,#a-zA-Z]", "");
	
	System.out.println(Ordernopreview);
	
	
}




public static void OrdernumberPreviewRegularExpressionStringConversion(){
	// This is to Instantiate EditOrders  class  
	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
	
	OrdernoPreview=OrdernoConv.PurchaseOrder_Preview_PurchaseOrderNumberVerification.getText();
	
	OrdernoPreview=OrdernoPreview.replaceAll("[-+.^:,#a-zA-Z]", "").replace("[\n]","").replace("[\r]","");
	
	System.out.println(OrdernoPreview);
	
	
}




public static void ServicesCalculation_WithTaxes(){
	//Calculating the tax now
   	CalculateTax= (TotalPrice * 5/ 100);
   	
   	System.out.println("Tax Calculated is"+CalculateTax);
	
}


public static void CreditServiceTaxCalculation(){
	
	CreditServiceTotalWithTax=TotalPrice+FreightWithCreditServiceNewtotalPrice;
	
	//Calculating the tax now
   	CalculateTax= ( CreditServiceTotalWithTax * 5/ 100);
   	
   	System.out.println("Tax Calculated is"+CalculateTax);
	
}
public static void SumSubtotalandTax_MatchingwithSalesPreviewAmount()
{
	SumSubtotalandTax_WithSalesPreviewAmountMatch=SubTotal+SalesTax;
	System.out.println(SumSubtotalandTax_WithSalesPreviewAmountMatch);
}

}
