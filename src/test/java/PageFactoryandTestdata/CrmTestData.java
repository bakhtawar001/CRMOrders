package PageFactoryandTestdata;

import java.awt.Robot;
import java.util.Date;
import java.util.Random;


public class CrmTestData {

	public static String Banme="Chrome"; 
	public static String CompVerify;

// SITA Credencials
	public static String admin="Automation1 Framework";
	public static String ASI="125748"; 
	public static String USER="CRMRegression1"; 
	public static String PASS="Pakistan786";
	
	/*public static String ASI="101574"; 
	public static String USER="prod_ems"; 
	public static String PASS="pakistan1234@";*/
	
	//NON Admin
	public static String nonadmin="bautomation mnonadmin";
	public static String ASINONAdmin="125748"; 
	public static String USERNONAdmin="autononadmin_125748"; 
	public static String PASSNONAdmin="pakistan123@";
	
	
	 //====================================================Corporate Credentials======================================================//
    public static String ASINo_Corp="109480";
    public static String Username_Corp="bilal_corps";
    public static String Password_Corp="bilal.1234";
    
    //====================================================Child User======================================================//
    public static String ASINo_Child="444081";
    public static String Username_Child="sm444081";
    public static String Password_Child="success1";
    
    
	//Company Creation Info
	
	static Date date = new Date();
	public static String Company="Auto "+date.toString();
	public static String CompanyState="Auto state"+date.toString();
	public static String SupplierCompany="Auto Customer"+date.toString();
	public static String Delcomp="Del "+date.toString();
	public static String CompanyB="Company B "+date.toString();
	public static String VirualSampleName="Virtual Sample" +date.toString();
	public static String ExistingCompany="Auto Supplier ASIQA I";
	
	static Random EditVirualSampleNameR = new Random(); 
	static int EditVirualSampleRR  = EditVirualSampleNameR.nextInt(500000); 
	public static String EditVirualSampleName="Edit Virtual Sample"+EditVirualSampleRR;
	//public static String EditVirualSampleName="Edit Virtual Sample" +date.toString();
	public static String ProvideEmailAddress="bnazir@asicentral.com";
	
	public static String FirstName="Bakhtawar " +date.toString();
	public static String LastName="Nazir " +date.toString();
	public static String CompanyName="MacPak " +date.toString();
	static Random email = new Random(); 
	public static int emailaddress   = email.nextInt(500000); 
	public static String WebsitesEmail="bakhtawar"+emailaddress+"@hotmail.com";
	public static String WebsitesPassword="pakistan123@";
	public static String ConfirmWebsitesPassword="pakistan123@";
	
	public static String CompPhone="+92-347-11222333";
	static Random SpecialCHaPhoneno = new Random(); 
	static int SpecialCHaCompPhonenoCreate = SpecialCHaPhoneno.nextInt(500000); 
	public static String SpecialCHaCompPhone="+#92-347-$$$"+SpecialCHaCompPhonenoCreate;
	public static String EditCompPhone="+92-347-11222444";
	static Random CompPhoneR = new Random(); 
	static int CompPhoneno   = CompPhoneR.nextInt(500000); 
	public static String CompPhoneNo="+92-347-"+CompPhoneno;
	public static String CompEmail="bnazirAsi@gmail.com";
	public static String EditCompEmail="bakhtawar"+emailaddress+"@hotmail.com";
	public static String CompWebsite="www.macpak.com";
	public static String ContactAddress="SL1 9AD";

	// RelationShip
	public static String RShipFarward="Is Employer of"+date.toString();
	public static String RShipFarwardTitle="Is Employee of";
	public static String RShipReverse="Is Employer of";
	public static String RShipReverseTitle="Is Employee of";

	
	// Team
		public static String TeamName="Auto "+date.toString();
		public static String Notes="Notes Created "+date.toString();
	//Decoration name
		public static String DecorationName="Decoration "+date.toString();
		public static String DecorationName_Foillogo="DecorationFoil "+date.toString();
		public static String EditDecorationName="Edited Decoration "+date.toString();
		
	// Address
	 
	public static String AddressName="My Primary Address";
	public static String Address="4800 E Street Rd Feasterville-Trevose, PA 19053 US";
	public static String CompBillingAddressName="My Billing Address";
	public static String CompBillingAddress="SL1 9AD";
	
	public static String ContactAAddress="Canada Water";
	public static String AddressLine1="4800 E Street Rd";
	
	public static String CompAddress="000567";
	public static String SecandaryCompAddress="Alternate Company Address";
	public static String State="12345";
	public static String ContactFirstName="Bakhtawar " +date.toString();
	public static String City="New York";
	public static String PostalCode="SL19AD";
	



// Note Content
	public static String NoteCont="I am Creating Note";
	public static String EditNoteCont="I am Editing Note";

	public static String MainNoteContent="I am Creating Note From Main";

	
	// Task Name
		static Random rtask = new Random(); 
		static int taskvalue   = rtask.nextInt(500000); 
		public static String Task="CommonTask"+taskvalue;
		
		
			
		public static String AssignTo="Automation1 Framework";
		public static String EditCommonTask="Edit CommonTask"+date.toString();
	
		//public static String Task="Get Proof Approval from Customer";
		
		public static String EditTask="Editing Assignment Tasks";
		public static String Days="1";

		public static String MainTask="Main autoTasks "+date.toString();

		public static String DefaultTask="Default Tasks "+date.toString();
		
		public static String PrivateDefaultTask="Private Default Tasks "+date.toString();
		
		public static String PublicDefaultTask="Public Default Tasks "+date.toString();

		public static String SupplierDefaultTask="Supplier Default Tasks "+date.toString();
		public static String DecoratorDefaultTask="Decorator Default Tasks "+date.toString();
		public static String SupplierDefaultTaskProductLineItem="Supplier Product Line Item"+date.toString();
		public static String DecoratorDefaultTaskProductLineItem="Decorator Product Line Item " + date.toString();
		static Random rand = new Random(); 
		static int value   = rand.nextInt(500000); 
		public static String ContactFromOrder="CC"+value;
		public static String PresentationName="Presentation" + date.toString();
		public static String thirdpartysystemID="Third Party"+value;

	// Contact Info
		public static String ContactFName="Auto "+date.toString();
		public static String ContactLName="Nazeer";
		public static String MergeContactFName="Merge ContactB "+date.toString();
		
		public static String ContactBFName="Bakhtawar "+date.toString();
		public static String ContactBLName="Nazir";
		public static String ContactBCompPhone="+92-34799887766";
		public static String ContactBCompEmail="bkAsi@gmail.com";
		public static String ContactBCompWebsite="www.macpak.pk";
	
	// CompanyProfile
		public static String CPCompanyName="Auto ASI Supplier"+date.toString();
		public static String CPEmail="asiqa"+value+"@asicentral.com";
		public static String CPPhone="+92-34799887766"+value;
		public static String CPWebsite="www.pinterest"+value+".com";
		
	//public static String stage ="https://espweb.stage-asicentral.com";
		public static String stage ="https://esp.stage-asicentral.com";
		public static String uat ="https://esp.uat-asicentral.com";
		public static String prod ="https://esp.asicentral.com";
		public static String ADR ="	https://espweb.asicentral.com/Diagnostics/health.aspx";
	
	
		
		
		public static String window1;
		public static String window2;

		public static String items[] = {"Mug","Basket", "Pen", "Golf", "bags", "USB"};//, "Basket"
		public static String color[] = { "red", "green", "blue", "pink", "white", "black" };


// Browsers
		public static String sChromePath = "Installation/chromedriver.exe";
		public static String Firefoxpath = "Installation/geckodriver.exe";
		public static String IEPath = "Installation/IEDriverServer.exe";
		public static String EdgePath = "Installation/MicrosoftWebDriver.exe";
	



	Robot rb;
	


	

}








