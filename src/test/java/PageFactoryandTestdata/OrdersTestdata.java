package PageFactoryandTestdata;

import java.util.Date;
import java.util.Random;

public class OrdersTestdata {

//==============================================Application URL========================================================================//	
          public static String CRMandOrders_URL="https://esp.uat-asicentral.com";
  

 //============================================Browser Path=========================================================================//
          public static String sChromePath = "Installation/chromedriver.exe";
          
 //=================================================Application All Environments Credentials==========================================//
         
       /*   public static String ASINo="101574";
          public static String Username="prod_ems";
          public static String Password="pakistan1234@";*/
          
         
         
          public static String autocrm1="autocrm1";
          public static String passautocrm1="autotest1";
          public static String autocrm2="autocrm2";
          public static String autocrm3="autocrm3";
          public static String ASINo="125748";
          public static String Username="OrdersRegression1";
          public static String Password="test1234";
          
          public static String ASINo1="125748";
          public static String Username1="OrdersRegression2";
          public static String Password1="test1234";
          
          public static String ASINoNonAdmin="125748";
          public static String UsernameNonAdmin="125748nonadmin";
          public static String PasswordNonAdmin="pakistan123@";

//===================================================Product Used======================================================
          //public static String OrderProduct="Cybertool M Swiss Army Knife";
          public static String OrderProduct="1 oz Mug Shaped Mini Shot Glass";
          public static String OrderProduct2="Bags";
          public static String CustomerSearchProductIDAHO="Hardcover Large Journalbook";
          public static String CanadianProduct="Business Card Sticky Pack";
          public static String SampleRequest_ProductName="Jetline";
          public static String SampleRequest_ProductNumber="BG101";
          
          	static Random rorderstatus = new Random(); 
  			static int orderstatusvalue   = rorderstatus.nextInt(500000); 
          public static String orderstatusname= "OrderStatus"+ orderstatusvalue;
          static  Date date=new Date();
          public static String orderstatuswithnotes= "Orders status is changed."+date.toString();
//============================================Download Path===========================================================
      //    public static String downloadPath = "C:\\Users\\Bilal.Mubarik\\Downloads";
          
//========================================Clipboard Product USed=====================================================//
          public static String Clipboard_ProductName="Hamptons Jute Tote Bag";
          
          public static String Clipboard_ProductNumber="LT-4248";
          
  //======================================Search Result WESP Product USed===========================================//
         
          public static String SearchResult_ProductName="Ladies' Sport-Tek Sport-Wick Stretch Contrast Full Zip Jacket";
          
          public static String SearchResult_ProductNumber="LST853";
          
   //========================================Product For Projects=================================================// 
          public static String Project_ProductName="Dri-FIT Classic Polo";
          
          public static String Project_ProductNumber="267020";
          
   //=======================================Product for shopping cart===========================================//
          public static String ShoppingCart_ProductName="1.8 Oz. Hand Sanitizer Antibacterial Gel in Flip-Top Bottle w/ Carabiner";
          
          public static String ShoppingCart_ProductNumber="5248";
          
   //=========================================QUR Product BookedMargin==========================================//
          public static String QURProduct_BookedMargin="Arabica 15 oz. Ceramic Mug";
          
          public static String QURProduct_BookedMarginUATProd="Frutavital QUR test";
          
   //============================================Search Terms Calender Products IDAHO Search==============================//
          public static String GolfTriumphCalender_Products="Golf Triumph Calendar";
          
          public static String Triumphbeaches_Product="Triumph Beaches";
          
          public static String TriumphAmericanMuscle_Product="Triumph American Muscle";
          
          public static String TriumphPuppies_Product="Triumph Puppies Appointment Calendar";
          
          public static String MotivationTriumphCalendar_Product="Motivations Triumph Calendar";
          
   //================================================SafeMode Order Product Search=======================================//
          public static String HitPromotionalProduct ="Hit Promotional Products";
          
          public static String HitPromotionalProductNumber="12";
   //================================================Company Detail=======================================//    
          public static String CompanyName ="American Macrosoft 2021";
          public static String CompanyEmailAddress ="americanMacrosoft2021@asicentral.com";
          public static String CompanyWebsite ="www.americanMacrosoft2021.com";
          public static String CountryName ="Canada Place";
          public static String PostalCode ="V6C 3T4";
          public static String Phoneno ="#92-7756443";
          public static String City ="Vancouver";
         
         
}
