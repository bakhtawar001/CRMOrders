package PageFactoryandTestdata;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrdersLocators{

	//======================================================Login Locators======================================================//

	@FindBy(xpath="//input[contains(@id,'txtAsiNum')]")
	public WebElement ASINo;

	@FindBy(xpath="//input[contains(@id,'txtUserName')]|//input[contains(@id,'asilogin_UserName')]")
	public WebElement UserName;
	@FindBy(xpath="//input[contains(@id,'txtPassword')]|//input[contains(@id,'asilogin_Password')]")
	public WebElement Password;
	
	@FindBy(xpath="//input[contains(@value,'Login')]|//input[contains(@value,'Log in')]")
	public WebElement LoginButton;
	
	//=================================================Landing Page Locators==================================================//
	
	@FindBy(xpath="//div[contains(text(),'ESP Orders')]")
	public WebElement Successfull_ESPOrdersLogin;
	
	@FindBy(linkText="CRM") public WebElement CRM; 
	@FindBy(xpath="//a[contains(text(),'ESP Web Home Page')]")
	public WebElement ESPWebHomePageLinkText;
	
	@FindBy(linkText="Orders") public WebElement Orders; 
	
	@FindBy(xpath="//a[contains(text(),'Orders')]")
	public WebElement ESPWebHomePage_OrdersTab;
	
	@FindBy(xpath="//ng-content[contains(text(),'Orders')]")
	public WebElement ESPWebHomePage_OrdersTab1;
	
	@FindBy(xpath="//input[contains(@placeholder,'Search by product, supplier, etc.')]")
	public WebElement OrdersTab_SearchOrder_Field_Placeholder;
	@FindBy(xpath="//td[contains(@data-title-text,'Order #')]")
	public WebElement ordersdetailspage;
	
	//==============================================Dashboard Locators=========================================//
	@FindBy(xpath="//a[contains(@translate,'NAVIGATION.DASHBOARD')]")
	public WebElement Dasboard_Tab;
	
	@FindBy(xpath="//i[contains(@ng-class,'percentChange ')]")
	public WebElement Percentage_Dashboard;
	
	@FindBy(xpath="//i[contains(@ng-class,'percentChange ')]")
	public String Percentage_Dashboard_Icon;
	
	@FindBy(xpath="//i[contains(@ng-class,'vm.chartValue > 0')]")
	public WebElement Ordersummary_Dashboard_Percentage;
	
	@FindBy(xpath="//div[contains(@content,'Difference in sales revenue year to date compared to the same time prior year.')]")
	public WebElement YearlySummary_Percentage_ToolTipText_Verification;
	
	@FindBy(xpath="//div[contains(@uib-tooltip,'Difference in sales revenue between the selected period and the prior period.')]")
	public WebElement OrderSummary_ToolTip_Text_Verification;
	
	@FindBy(xpath="//a[contains(@translate,'ORDERS.TABS.TAB_TITLE_ORDERS')]")
	public WebElement Orders_Title_Tab;
	
	//==============================================Create Order Locators====================================================//

		
	@FindBy(xpath="//td[contains(@ng-click,'vm.goToDetail($event, order.Id)')]")
	public WebElement OrderListing_Orderselection;
	
	@FindBy(xpath="	//td[contains(@data-title-text,'Order #')]")
	public WebElement Orderno;

	@FindBy(xpath="//button[contains(@class,'btn btn-primary dropdown-toggle')]")
	public WebElement OrdersScreen_OrderButton;
	
	@FindBy(xpath="//ng-content[contains(@translate,'BUTTONS.CREATE_ORDER')]")
	public WebElement OrdersScreen_CreateOrderButton;
	
	
	@FindBy(xpath="//span[contains(@class,'close ui-select-match-close')]")
	public WebElement SalesPerson_Remove_FromOrder_Icon;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter or Select User')]")
	public WebElement SalesPersonField_CreateOrder;
	
	@FindBy(xpath="//div[@class='ng-binding ng-scope']")
	public WebElement SalesPerson_dropdown_Selection_CreateOrder;
	
	@FindBy(xpath="//p[contains(text(),'Please include a sales person on your Sales Order.')]")
	public WebElement OrderSaving_WithoutSalesPerson_Validation_Verification;
	
	@FindBy(xpath="//button[contains(@translate,'BUTTONS.OK')]")
	public WebElement SalesPerson_Validation_Check_OK_Button;
	
	@FindBy(xpath="//div[contains(@class,'btn-group dropdown')]/a")
	public WebElement CreateOrder_SalesOrderOption;
	
	
	@FindBy(xpath="//span[contains(@class,'caret')]/parent::button/parent::div//button[2]")
	public WebElement CreateCustomProduct_CreateIcon;
	
	@FindBy(xpath="//i[@class='fa fa-gear editmodal-lineitem-settings']")
	public List<WebElement> CogWheelIcon_CustomProducts;
	
	@FindBy(xpath="//a[contains(@translate,'BUTTONS.NEW_PRODUCT')]")
	public WebElement NewProduct_Link_CustomPro;
	
	@FindBy(xpath="//div[contains(@id,'category')]/descendant::span")
	public WebElement CategoryDropDown;
	
	@FindBy(xpath="//input[contains(@type, 'search')]")
	public WebElement SearchCategories;
	
	@FindBy(xpath="//input[contains(@id,'productName')]")
	public WebElement Productname;
	
	@FindBy(xpath="//input[contains(@id,'cpn')]")
	public WebElement ProductCPN;
	
	@FindBy(xpath="//input[contains(@id,'productNumber')]")
	public WebElement ProductNumber;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter or Select Company')]")
	public WebElement SearchSupplier;
	
	@FindBy(xpath="//span[contains(@aria-label,'Select a Vendor activate')]")
	public WebElement CustomProduct_SupplierDropdown_Verification;
	
	@FindBy(xpath="//button[contains(@translate,'BUTTONS.CANCEL')]")
	public WebElement CustomProduct_Popup_Cancel_Button;
	
	
	@FindBy(xpath="//i[contains(@class, 'fa fa-picture-o')]")
	public WebElement PushMenu;
	
	@FindBy(xpath="//button[contains(@name,'ngFileUpload')]")
	public WebElement UploadFile;
	
	
	
	@FindBy(xpath="//*[contains(@class, 'toast-title')]")
	public WebElement TitleMesg;
	
	
	@FindBy(xpath="//img[contains(@title, 'DST.dst')]")
	public WebElement DSTFileVerification;
	
	@FindBy(xpath="//Strong[contains(text(),'Sample.ai')]")
	public WebElement AIFileVerification;
	
	@FindBy(xpath="//Strong[contains(text(),'SVG.svg')]")
	public WebElement SVGFileVerification;
	
	@FindBy(xpath="//ng-content[contains(text(),'Create Quote')]")
	public WebElement CreateOrder_QuoteOption;
	
	@FindBy(xpath="//ng-content[contains(@translate,'BUTTONS.CREATE_SAMPLE_REQUEST')]")
	public WebElement CreateSampleRequest;
	
/*	@FindBy(xpath="//li[contains(@ng-if,'currentUser.canCreateInvoice')]/a")
	public WebElement CreateOrder_InvoiceOption;*/

	@FindBy(xpath="//ng-content[contains(text(),'Create Invoice')]")
	public WebElement CreateOrder_InvoiceOption;
	
	@FindBy(xpath="//button[contains(@options,'vm.getConfirmCopyExtras')]")
	public WebElement CreateOrderButton_Quote;
	
	
	
	@FindBy(xpath="//span[contains(@ng-show, 'vm.model.Number')]")
	public WebElement OrderNumber;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.configs.search')]")
	public WebElement OrderlistingSearch;
	
	@FindBy(xpath="//tr[contains(@class, 'media cursor-pointer pull-up ng-scope')]") 
	public List<WebElement> GetNoOfRecords;
	
	

	@FindBy(xpath="//span[contains(text(),'Enter or')]")
	public WebElement CreateOrderScreen_CompanySearch_Textfield;
	
	@FindBy(xpath="//div[contains(@name,'Customer')]/input[contains(@ng-model,'select.search')]")
	public WebElement CreateOrderScreen_CompanyField_SendData;
	
	@FindBy(xpath="//ul[contains(@repeat,'company as company in uiSelectCompanies')]/li")
	public WebElement CreateOrderScreen_CompanyFieldVerification;
	
	@FindBy(xpath="//ng-content[contains(text(),'View CRM Record')]")
	public WebElement ViewCRMRecord;
	
	
	@FindBy(css="#ui-select-choices-row-0-1 > span > div > div.ellipsis.text-light.ng-scope")
	public WebElement CreateOrderScreen_CompanySearch_Selection;
	
	@FindBy(xpath="//div[contains(@class, 'well well-sm clearfix address-body no-margin')]")
	public WebElement CreateOrderScreen_BillingCompanyAddress;
	
//	@FindBy(css="#pad-wrapper > div:nth-child(7) > div > div > div:nth-child(2) > div > order-contact > div > div.margin-left-20 > div > address")
//	public WebElement CreateOrderScreen_ShippingCompanyAddress;
	
	@FindBy(css="#pad-wrapper > div:nth-child(8) > div > div > div:nth-child(2) > div > order-contact > div > div.margin-left-20 > div > address > div:nth-child(3)")
	public WebElement CreateOrderScreen_ShippingCompanyAddress;
	
	@FindBy(css="#pad-wrapper > div:nth-child(7) > div > div > div:nth-child(3) > div > order-contact > div > div.margin-left-20 > div > address")
	public WebElement CreateOrderScreen_AckCompanyAddress;
	
	@FindBy(xpath="//div[contains(@ng-model,'CreditTerm')]/div/span")
	public WebElement Terms_Dropdown;
	
	@FindBy(xpath="//div[contains(@ng-model,'vm.order.ShippingDetail.Carrier')]/div/span")
	public WebElement ShipVia_Dropdown;
	
	@FindBy(xpath="	//div[contains(@ng-model,'vm.order.ShippingDetail.Carrier')]/input[contains(@type,'search')]")
	public WebElement Input_ShipVia_Method;
	

	@FindBy(xpath="//ul[contains(@repeat,'term.Code')]//li")
    public List<WebElement> TermsDropdownValues;
	
	@FindBy(xpath="//ul[contains(@repeat,'carrierType.Code')]//li")
	public List<WebElement> ShipViaDropdown_Values;
	
	
	@FindBy(xpath="//ul[contains(@repeat,'carrierType.Code')]//li/descendant::div[contains(@ng-if,'$select.open')]")
	public List<WebElement> Ground_ShipViaDropdown_Values;
	
	@FindBy(xpath="//button[contains(text(),'Add Product')]")
	public WebElement CreateOrder_AddProductButton;
	
	@FindBy(xpath="//li//a[contains(text(),'Product Search')]")
	public WebElement CreateOrder_AddProductPopup_ProductSearchTab;
	
	@FindBy(xpath="//li//a[contains(text(),'Project')]")
	public WebElement CreateOrder_AddProductPopup_ProjectTab;
	
	@FindBy(xpath="	//a[contains(@title,'AutomationProject')]")
	public WebElement CreateOrder_AddProductPopup_ProjectSelection;
	
	@FindBy(name="keywords")
	public WebElement CreateOrder_AddProductPopup_SearchKeywordField;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-search')]")
	public WebElement CreateOrder_AddProductPopup_SearchButton;
	
	@FindBy(css="body > div.modal.modal-xl.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.modal-body-scroll.ng-scope > div > div > div.tab-pane.ng-scope.active > div.product-container.ng-scope > div > div > div > div:nth-child(1) > div")
	public WebElement CreateOrder_AddProductPopup_ProductSelection;
	
	@FindBy(xpath="//button[contains(text(),'Add Products')]")
	public WebElement CreateOrder_AddProductPopup_AddProductsButton;
	
	@FindBy(css="#toast-container")
	public WebElement CreateOrder_ProductAddedToOrder_Successfull;
	
	@FindBy(xpath="//span[contains(@class,'doc-title')]")
	public WebElement Ack_Send_Successfull;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.configureProduct(lineItem)')]")
	public WebElement CreateOrders_ConfigureButton;
	
	@FindBy(xpath="//a[contains(text(),'Projects')]")
	public WebElement AddProduct_ProjectsTab;
	
	@FindBy(css="body > div.modal.modal-xl.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.modal-body-scroll.ng-scope > div > div > div.tab-pane.ng-scope.active > div > div.col-sm-9 > div > div > div > div > div > div > div")
	public WebElement ProjectsProductSelection;
	//button[contains(text(),'Ok')] | //button[contains(text(),'Yes')]
	@FindBy(xpath="//input[contains(@placeholder,'QTY')] | //input[contains(@placeholder,'Qty')]")
	public WebElement CreateOrder_Configure_QTY_TextField;
	
	@FindBy(xpath="//button[contains(text(),'Configure')]")
	public WebElement OrdersDetails_ConfigureProduct;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-danger btn-sm btn-block ng-scope ng-isolate-scope')]//ng-content[contains(text(),'Delete')]")
	public WebElement DeleteProduct;
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	public WebElement ConfirmationButton;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	public WebElement CreateOrder_Configure_Continue_Button;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement CreateOrder_DecoratorScreen_Save_Button;
	
	@FindBy(xpath="//button[contains(@analytics-event,'Clicked Send')]")
	public WebElement Invoice_Send_Button;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::div[contains(@ng-if,'$ctrl.ngModel.EmailAddress')]")
	public WebElement Billing_EmailAddress;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.ShippingContact')]/descendant::div[contains(@ng-if,'$ctrl.ngModel.EmailAddress')]")
	public WebElement Shipping_EmailAddress;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.AcknowledgementContact')]/descendant::div[contains(@ng-if,'$ctrl.ngModel.EmailAddress')]")
	public WebElement Ack_EmailAddress;
	
	@FindBy(xpath="//span[contains(@placeholder,'Enter or Select Email')]/descendant::span[contains(@class,'ng-binding ng-scope')]")
	public WebElement SendInvoice_Billing_EmailAddress;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::div/button")
	public WebElement Eidt_Billing_EmailAddressButton;
	
	@FindBy(xpath="//input[contains(@name,'emailAddress')]")
	public WebElement Edit_Billing_EmailAddress;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]//div[contains(@placeholder,'Enter or choose different Contact')]//span[contains(@class,'btn btn-default form-control ui-select-toggle')]")
	public WebElement ChooseBillingContact;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::input[contains(@placeholder,'Enter or choose different Contact')]")
	public WebElement SearchContact;
	@FindBy(xpath="//input[contains(@id,'CompanyName')]")
	public WebElement EditBillingContact_CompanyName;
	
	@FindBy(xpath="//div[contains(@class,'modal-dialog ')]/descendant::button[contains(@translate,'BUTTONS.SAVE')]")
	public WebElement BillingContact_SaveButton;
	
	@FindBy(xpath="//div[contains(@name,'compnayTypes')]/descendant::span[contains(@class,'ui-select-match-text pull-left')]")
	public WebElement CompanySelection;
	
	@FindBy(xpath="//div[contains(@class,'ui-select-choices-wrapper')]/ul/li/descendant::ng-content[contains(text(),'Prospects')]/parent::span/input")
	public WebElement ProspectComapny;
	
	
	@FindBy(xpath="//div[contains(@class,'ui-select-choices-wrapper')]/ul/li/descendant::ng-content[contains(text(),'Customers')]/parent::span/input")
	public WebElement CustomersCompany;
	
	@FindBy(xpath="//div[contains(@class,'ui-select-choices-wrapper')]/ul/li/descendant::ng-content[contains(text(),'Suppliers')]/parent::span/input")
	public WebElement SuppliersCompany;
	
	@FindBy(xpath="//div[contains(@class,'ui-select-choices-wrapper')]/ul/li/descendant::ng-content[contains(text(),'Decorators')]/parent::span/input")
	public WebElement DecoratorsCompany;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-default btn-sm dropdown-toggle')]")
	public WebElement OrderDetails_Service_ToggleClick;
	
	@FindBy(xpath="//ng-content[contains(text(),'Show All Charges')]")
	public WebElement EditProduct_ShowAllVendorChargesButton;
	
	@FindBy(xpath="//strong[contains(text(),'Less than Minimum Charge')]/parent::td//button[contains(@title,'Add Charge')]")
	public WebElement VendorCharges_LessThanMinimumAddButton;
	
	@FindBy(xpath="//button[contains(text(),'Use Current Rates')]")
	public WebElement Orderdetails_UseCurrentRates_Button;
	
	@FindBy(xpath="//*[contains(@translate,'ORDERS.LABELS.PRODUCT.CPN')]")
	public WebElement Customer_NumberEditProduct;
	
	@FindBy(xpath="//input[contains(@id,'cpn')]")
	public WebElement EditProduct_CPN_Field_Verification;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.order.ShippingSameAsBilling')]")
	public WebElement Sameasbilling_Checkbox_ShippingAddress;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.order.AcknowledgementSameAsBilling')]")
	public WebElement Sameasbilling_Checkbox_Acknowledgement;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::address")
	public WebElement BillingAddress_Orderlevel;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.ShippingContact')]/descendant::address")
	public WebElement ShippingAddress_Orderlevel;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.AcknowledgementContact')]/descendant::address")
	public WebElement AcknowledgementAddress_OrderLevel;
	
	@FindBy(xpath="//tr[contains(@class,'subtotals')]/following-sibling::tr[1]/descendant::td/p[contains(@class,'ng-binding')]/text()[2]")
	public WebElement GrossSubTotal;
	
	@FindBy(xpath="//button[contains(text(),'Add Product')]/following-sibling::ul")
	public WebElement AddNewProductDropdown;
	
	
	//================================================Add Services Locators====================================================
	@FindBy(xpath="//a[contains(text(),'Freight')]")
	public WebElement OrderDetails_Service_Freight;
	
	@FindBy(xpath="//h4[contains(text(),'Add Service')]")
	public WebElement OrderDetails_Service_Freight_Popup_Heading;
	
	@FindBy(xpath="//input[contains(@name, 'serviceName')]")
	public WebElement OrderDetails_Service_Freight_Popup_TitleField;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.service.Description')]")
	public WebElement OrderDetails_Service_Freight_Popup_DescriptionField;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.service.Cost')]")
	public WebElement OrderDetails_Service_Freight_Popup_Netcost;
	
	@FindBy(xpath="//select[contains(@ng-model,'vm.service.ServiceType')]")
	public WebElement OrderDetails_Service_Freight_Popup_ServiceType;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement OrderDetails_Service_Freight_Popup_SaveButton;
	
	@FindBy(xpath="//div[contains(text(),'Freight1')]")
	public WebElement Orderdetails_FreightDivDisplay_validation;
	
	@FindBy(css="#pad-wrapper > div:nth-child(10) > div > div > div > div.ng-scope > div > table > tbody > tr.ng-scope.service-row > td.item-actions.hover-btn-container.ng-scope > button.btn.btn-danger.btn-sm.btn-block.ng-scope.ng-isolate-scope")
	public WebElement Orderdetails_FreightDelete_Button;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	public WebElement Orderdetails_FreightDeletePopup_OKButton;
	
	//====================================================Edit Order Locators====================================================
	
	
	@FindBy(xpath="//div[contains(@ng-if,'lineItem.Supplier.PrimaryPhone')]")
	public WebElement OrdersDetails_PhoneNo;
	
	@FindBy(xpath="	//div[contains(@class,'product-supplier-details')]")
	public WebElement SupplierPhoneNoVerification;

	
	@FindBy(xpath="//button[contains(@ng-click,'vm.openProductModal')]")
	public WebElement OrdersDetails_EditButton;
	
    @FindBy(xpath="//tfoot//tr[contains(@class,'subtotals')]/td[3]/strong")
    public WebElement Orderdetails_SubTotal;
    
    @FindBy(xpath="//tfoot/tr/td[2]/p[3]")
    public WebElement Orderdetails_SalesTax;
	
	@FindBy(xpath="//tfoot/tr[3]/td[2]/strong")
	public WebElement Orderdetails_AmountDue;
	
	/*@FindBy(css="#pad-wrapper > div:nth-child(10) > div > div > div > div.ng-scope > div > table > tbody > tr.ng-scope.product-row > td.nested.item-details.ng-scope > table > tfoot > tr > td.item-price.text-right > strong")
	public WebElement Orderdetails_TotalPrice;
	*/
	@FindBy(css="#pad-wrapper > div:nth-child(11) > div > div > div > div.ng-scope > div > table > tfoot > tr.subtotals > td:nth-child(3) > strong")
	public WebElement Orderdetails_TotalPrice;
	
	@FindBy(css="#pad-wrapper > div:nth-child(11) > div > div > div > div.ng-scope > div > table > tbody:nth-child(4) > tr > td.nested.item-details.ng-scope > table > tfoot > tr > td.item-price.text-right > strong")
	public WebElement Orderdetails_FreightwithcreditTypePrice;
	
	@FindBy(xpath="//button[contains(@ng-click,'addServiceCharge')]")
	public WebElement ProductConfiguration_AddChargeLinkText;
	
	@FindBy(css="body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div > div.col-sm-9.col-md-9 > div > div > div.tab-pane.ng-scope.active > div > fieldset > service-charges > div > table > tbody > tr > td.item-qty > input")
	public WebElement ProductConfiguration_AddCharge_QTY;
	
	@FindBy(xpath="//*[@id='quantity-view']/div/div/div/table/tbody/tr/td[1]/div/input")
	public WebElement ProductConfiguration_AddQTY;
	
	@FindBy(css="body > div:nth-child(1) > div > div > div.modal-body.ng-scope > form > div > div.col-sm-9.col-md-9 > div > div > div.tab-pane.ng-scope.active > div > fieldset > service-charges > div > table > tbody > tr > td.item-cost > input")
	public WebElement ProductConfiguration_AddCharge_NetCost;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement NewOrder_ProductConfiguration_AddCharge_SaveButton;
	
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	public WebElement ProductConfiguration_AddCharge_ContinueButton;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement ProductConfiguration_AddCharge_ConfigSaveButton;
	
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.done(editProductForm)')]")
	public WebElement ProductConfiguration_AddCharge_SaveButton;
	
	@FindBy(css="body > div.modal.product-edit-modal-window.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > form > div > div.col-sm-9.col-md-9 > div > div > div.tab-pane.ng-scope.active > div > service-charges > div > ng-transclude > table > tbody:nth-child(2) > tr > td:nth-child(1) > button")
	public WebElement ProductConfiguration_AddVendorCharge_LinkText;
	
	@FindBy(css="body > div.modal.product-edit-modal-window.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > form > div > div.col-sm-9.col-md-9 > div > div > div.tab-pane.ng-scope.active > div > fieldset > service-charges > div > table > tbody:nth-child(3) > tr > td.item-cost > input")
	public WebElement ProductConfiguration_VendorChargeNetCost;
	
	@FindBy(xpath="//input[contains(@ng-click,'vm.onInputClick()')]")
	public WebElement ProductConfiguration_SKU;
	
	@FindBy(xpath="//input[contains(@name,'qty')]")
	public WebElement ProductConfiguration_QTY;
	
	@FindBy(xpath="//td[contains(@class,'item-description')]//input[contains(@name,'description')]")
	public WebElement ProductConfiguration_Description;
	
	@FindBy(xpath="//input[contains(@name,'cost')]")
	public WebElement ProductConfiguration_Cost;
	
	@FindBy(xpath="//th[contains(text(),'Variant Attributes')]")
	public WebElement ProductConfiguration_VariantAttributes;
	
	
	@FindBy(xpath="//td[contains(@class,'item-sku')]//input[contains(@ng-click,'vm.onInputClick()')][1]")
	public WebElement Addlineitem_ProductConfiguration_SKU;
	
	@FindBy(xpath="	//ng-content[contains(text(),'Add Line Item')]")
	public WebElement ProductConfiguration_AddLineItem;

	@FindBy(xpath="//button[contains(@ng-if,'vm.product.Variants.length > 0')]/ng-content")
	public WebElement ProductConfiguration_ClearAll;
	
	@FindBy(xpath="//button[contains(text(),'Yes, Clear and Reconfigure Product')]")
	public WebElement ProductConfiguration_ClearVariants;
	
	@FindBy(xpath="	//h3[contains(text(),'Quantity')]")
	public WebElement POA;

	@FindBy(xpath="//a[contains(text(),'Decoration')]")
	public WebElement EditOrder_DecorationTab;
	
	@FindBy(xpath="//a[contains(text(),'Configuration')]")
	public WebElement EditOrder_Configuration;
	
	@FindBy(xpath="//span[contains(@aria-label,'Select a Decorator activate')]/span")
	public WebElement DecorationName;
	
	@FindBy(xpath="//div[contains(@ng-model,'decoration.getSetLocation')]/div/span")
	public WebElement EditOrder_Decoration_Location;
	
	@FindBy(xpath="//span[contains(text(),'Side')]|//span[contains(text(),'side of mug')]")
	public WebElement EditOrder_Decoration_LocationValue;
	
	@FindBy(xpath="//span[contains(@tabindex,'-1')][contains(@aria-label,'Select a Decorator activate')]")
	public WebElement EditOrder_Decoration_Decorator;
	
	@FindBy(xpath="	//input[contains(@placeholder,'Select A Decorator')]")
	public WebElement EditOrder_Decoration_DecoratorName;
	
	@FindBy(xpath="//div[contains(@name,'Decorator')]/input[contains(@ng-model,'select.search')]")
	public WebElement EditOrder_Decoration_DecoratorSelection;
	
	@FindBy(xpath="//button[contains(@choose-order-action,'send')]")
	public WebElement EditOrder_Decoration_Send;
	
	@FindBy(xpath="//div[contains(@title,'Auto Supplier ASIQA I')]")
	public WebElement PreviewPopup_DecoratorPurchaseOrderSelection;

	@FindBy(xpath="//button[contains(@ng-click,'vm.chooseAction({ selection: vm.selection, item: vm.currentItem })')]")
	public WebElement PreviewPopup_Continue;
	
	@FindBy(xpath="//span[contains(@ng-class,'{ invalid: $item.isValid === false }')]")
	public WebElement EmailAddress;
	@FindBy(xpath="//button[contains(@ng-click,'vm.cancel()')]")
	public WebElement CancelSendWindow;
	
	
	
	@FindBy(xpath="//span[contains(text(), 'Enter or Select')]")
	public WebElement EditOrder_Decoration_ImprintMethod;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter or Choose Imprint Method')]")
	public WebElement EditOrder_Decoration_ImprintMethod1;
	
	@FindBy(xpath="//span[contains(text(), 'Laser Engraved')]")
	public WebElement EditOrder_Decoration_Imprint_SelectValue;
	
	@FindBy(xpath="//ng-content[contains(text(),'Attach Files')]")
	public WebElement EditOrder_Decoration_ArtWorkImageUploadButton;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.model.IsVisible')]")
	public WebElement Decorator_VisibleCheckbox;
	
	@FindBy(xpath="//p[contains(@class, 'artwork-upload-right col-sm-4 col-md-3')]/asi-file-upload/div/div/div/button")
	public WebElement UploadButton;
	
	@FindBy(xpath="//i[contains(@class,'artwork-container-sm')]")
	public WebElement EditOrder_Decoration_Existing_Artwork_Selection;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-download')]")
	public WebElement EditOrder_Decoration_ArtworkDownload;
	
	@FindBy(xpath="//button[contains(@ng-if,'delete')]")
	public WebElement EditOrder_Decoration_ArtworkDelete_Icon;
	
	@FindBy(xpath="//button[contains(@translate,'BUTTONS.OK')]")
	public WebElement Artwork_Delete_Confirm;
	
	@FindBy(xpath="//div[contains(@class,'artwork-name ellipsis ng-binding')]")
	public WebElement EditOrder_Decoration_Artwork_Existence_Verification;
	
	@FindBy(xpath="//div[contains(@class,'artwork-name ellipsis ng-binding')]")
	public List<WebElement> EditOrder_Decoration_Artwork_Deletion_Verification;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.done(editProductForm)')]")
	public WebElement SaveDecoration;
	

	@FindBy(xpath="//input[contains(@ng-model,'decoration.Location.VendorCode')]")
	public WebElement EditOrder_Decoration_VendorCode;
	
	@FindBy(xpath="//input[contains(@ng-model,'detail.LogoSize.Value')]")
	public WebElement EditOrder_Decoration_ImprintSize;
	
	@FindBy(xpath="//input[contains(@ng-model,'detail.LogoColors[0].Value')]")
	public WebElement EditOrder_Decoration_ImprintColor;
	
	@FindBy(xpath="//select[contains(@ng-model,'decoration.ProofType')]")
	public WebElement EditOrder_Decoration_ProofType;
	
	@FindBy(xpath="//input[contains(@ng-model,'decoration.ProofEmail')]")
	public WebElement EditOrder_Decoration_ProofType_EmailAddress;
	
	/*
	@FindBy(xpath="//textarea[contains(@ng-model,'decoration.Comments')]")
	public WebElement EditOrder_Decoration_VendorNotes;
	*/
	@FindBy(xpath="//*[contains(@ng-model,'decoration.Comments')][@name]")
	public WebElement EditOrder_Decoration_VendorNotes;
	
	@FindBy(xpath="//ng-content[contains(text(), 'Add Charge')]")
	public WebElement EditOrder_Decoration_AddCharge_LinkText;
	
	@FindBy(xpath="//input[contains(@ng-model, 'charge.Cost')]")
	public WebElement EditOrder_Decoration_NetCostField;
	

	
	//@FindBy(xpath="//div[contains(@class,'form-group _40 pull-right no-margin')]/div[1]/div/span")
	
	
	@FindBy(xpath="//span[contains(@aria-label,'Select a Decorator activate')]")

	public WebElement DecoratorCompanySelection;
	
	
	@FindBy(xpath="//input[contains(@aria-label, 'Select a Decorator')]")
	public WebElement TypeDecorator;
	@FindBy(xpath="//div[contains(@class,'pull-left')]/i/parent::div")
	public WebElement DecoratorCompanySearch;
	
	@FindBy(css="#pad-wrapper > div:nth-child(12) > div > div > div > div.ng-scope > div > table > tbody > tr > td.nested.item-details")
	public WebElement Orderdetails_DecorationTab_DecorationDisplayVerification;
	
	@FindBy(xpath="//input[contains(@ng-model,'decoration.CommentsVisible')]")
	public WebElement VendorNotes_Visible_Checkbox;
	
	@FindBy(xpath="//input[contains(@ng-model,'detail.InstructionsVisible')]")
	public WebElement DecorationInstructions_Visible_Checkbox;
	
	@FindBy(xpath="//*[contains(@ng-model,'detail.Instructions')][@name='comments'] | //*[contains(@ng-model,'detail.Instructions')][@name]")
	public WebElement DecorationInstructions_Textarea;
	
	
	
	
	@FindBy(xpath="//a[contains(text(),'Instructions')]")
	public WebElement EditOrder_InstructionTab;
	
	@FindBy(xpath="//textarea[contains(@ng-model,'instruction.Content')]")
	public WebElement EditOrder_InstructionTextArea;
	
	@FindBy(xpath="//a[contains(@ng-click, 'vm.openProductModal(lineItem')]")
	public WebElement ViewInstructions;
	
	@FindBy(xpath="//a[contains(@ng-click, 'vm.openProductModal(lineItem')]")
	public List<WebElement> NoViewInstructions_Verification_AfterCopyingQuote;
	
	@FindBy(xpath="//li[contains(@class,'uib-tab nav-item ng-scope ng-isolate-scope')]/a//uib-tab-heading/ng-content[contains(text(),'Shipping')]")
	public WebElement EditOrder_ShippingTab;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.ShippingContact')]/descendant::address")
	public WebElement ShippingAddress_Verification_At_ProductLevel;

	
	@FindBy(xpath="//button[contains(@ng-click,'vm.addNewDestination()')]")
	public WebElement EditOrder_ShippingTab_AddShippingDestinationButton;
	

/*	@FindBy(xpath="//div[contains(@class,'clearfix margin-bottom-5')]/ul/li[1]/a")
	public WebElement Orderdetails_PricingTab;
	
	@FindBy(xpath="//div[contains(@class,'clearfix margin-bottom-5')]/ul/li[2]/a")
	public WebElement Orderdetails_DecorationTab;
	
	@FindBy(xpath="//div[contains(@class,'clearfix margin-bottom-5')]/ul/li[3]/a")
	public WebElement Orderdetails_ShippingTab;
		
	@FindBy(xpath="//div[contains(@class,'clearfix margin-bottom-5')]/ul/li[4]/a")
	*/
	
	@FindBy(xpath="//ng-content[contains(text(),'Pricing')]/parent::a")
	public WebElement Orderdetails_PricingTab;
	
	@FindBy(xpath="//ng-content[contains(text(),'Decoration')]/parent::a")
	public WebElement Orderdetails_DecorationTab;
	
	@FindBy(xpath="//div[contains(@placeholder,'Select A Decorator')]/span")
	public WebElement Orderdetails_DecoratorDropDown;
	
	
	@FindBy(xpath="//div[contains(@placeholder,'Select A Decorator')]/span/descendant::i[contains(@class,'glyphicon glyphicon-remove')]")
	public WebElement RemoveDecorator;
	
	
	
	@FindBy(xpath="	//input[contains(@placeholder,'Select A Decorator')]")
	public WebElement Orderdetails_ProvideDecorator;

	
	@FindBy(xpath="//ng-content[contains(text(),'Shipping')] | //ng-content[contains(text(),'Shipping')]")
	public WebElement Orderdetails_ShippingTab;
		
	@FindBy(xpath="//ng-content[contains(text(),'Purchase Orders')] | //ng-content[contains(text(),'Purchase Orders')]")
	
	public WebElement Orderdetails_PurchaseOrderTab;
	
	@FindBy(xpath="//tbody[contains(@ng-if, 'vendor.Products.length')]") 
	public List<WebElement> GetPOSFromPOTab;
	
	@FindBy(xpath="//tbody[contains(@ng-repeat, 'shippingDetail in lineItem.ShippingDetails track by $index')]") 
	public List<WebElement> GetAddressFromShippingTab;
	
	@FindBy(css="body > div.modal.product-edit-modal-window.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > form > div > div.col-sm-9.col-md-9 > div > div > div.tab-pane.ng-scope.active > product-shipping > div > div:nth-child(4) > div > div > div:nth-child(2) > div.row.destination-from > div.col-xs-11 > div > div.ui-select-container.ui-select-bootstrap.dropdown.ng-not-empty.ng-valid.ng-touched > div.ui-select-match > span > span.ui-select-match-text.pull-left")
	public WebElement ShippingDestination_WithNewDecoratorCompany_CompanySelection;
	
	@FindBy(xpath="//strong[contains(@translate, 'ORDERS.LABELS.SHIP_FROM')]/following-sibling::small")
	public WebElement ShippingDestination_WithNewDecoratorCompany_ShippingAddress_Verification;
	
	//@FindBy(xpath="//div[contains(@placeholder, 'Enter or Choose Contact')]/span")
	//public WebElement ShippingTab_NewDestinationAddressCompany_Field;
	
	@FindBy(xpath="//span[contains(@aria-label, 'Ship From activate')]")
	public List<WebElement> ShippingTab_NewDestinationAddressCompany_Field;
	
	//@FindBy(xpath="//span[contains(@aria-label, 'Ship From activate')]/span")
	//public WebElement ShippingTab_NewDestinationAddressCompany_Field;
	
	
	
	@FindBy(xpath="//div[contains(@class,'ui-select-choices-row ng-scope')][2]")
	public WebElement ShippingTab_NewDestinationAddress_Selection;
	
/*	@FindBy(css="body > div.modal.product-edit-modal-window.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > form > div > div.col-sm-9.col-md-9 > div > div > div.tab-pane.ng-scope.active > product-shipping > div > div:nth-child(2) > div > div > div:nth-child(3) > div > div.col-sm-12.text-right > button")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton;
	*/
	

	@FindBy(xpath="//button[contains(@ng-click, 'vm.openSplitShipmentModal')]/i")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.okay()')]")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton_OKProceedButton;
	

	
	@FindBy(xpath="//span[contains(text(),'Enter or Choose Contact')]")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton_OKProceedButton_CustomerAddressField1;
	
	@FindBy(xpath="//order-contact[contains(@contact-type,'Ship To')]/descendant::span[contains(@class,'btn btn-default form-control ui-select-toggle')]")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton_RemoveCrossIcon_CustomerAddressField1;
	
	@FindBy(css="body > div.modal.split-shipment.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > div > product-shipping > div > div:nth-child(2) > div > div > div:nth-child(2) > div.row.destination-to > div.col-xs-11 > div:nth-child(2) > order-contact > div.form-group.ng-scope > div > div.ui-select-match.ng-scope > span > span.ui-select-match-text.pull-left.ui-select-allow-clear")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton_OKProceedButton_CustomerAddressField2;
	
	@FindBy(xpath="//span[contains(text(),'Feasterville-Trevose, ')]")
	public WebElement EditOrder_ShippingTab_SplitShipmentButton_OKProceedButton_CustomerAddressField_AddressSelection;
	
	@FindBy(xpath="//button[contains(text(),'Next - Enter Quantity')]")
	public WebElement EditOrder_Splitshipment_EnterQuantityNextButton;
	
	@FindBy(css="body > div.modal.split-shipment.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.ng-scope > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr.ng-scope > td > div > div > input")
	public WebElement EditOrder_Splitshipment_Shipment1_QTY;
	
	@FindBy(xpath="//input[contains(@name, 'qty')]")
	public WebElement EditOrder_Splitshipment_Shipment2_QTY;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.save')]")
	public WebElement EditOrder_Splitshipment_SaveButton;
	
	@FindBy(xpath="//p[contains(@translate,'ORDERS.MESSAGES.SPLIT_SHIPMENT_MSG1')]")
	public WebElement ErrorMessage_Verification_QuantityCheck;
	
	@FindBy(xpath="//div[contains(@ng-if, 'lineItem.isSplitShipment')][contains(text(), 'Shipment 1 of')]")
	public WebElement Orderdetails_shippingTab_SplitshipmentExistence_Verification;
	
	@FindBy(css="#pad-wrapper > div:nth-child(11) > div > div > div > div.ng-scope > div > table > tbody > tr > td.nested > table > tbody:nth-child(2)")
	public WebElement Orderdetails_ShippingTab_AddNewDestinationAddressVerification;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.order.POReference')]")
	public WebElement Order_POReferenceField;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.options.IncludePoReference')]")
	public WebElement Order_POReferenceField_Checkbox;
	
	@FindBy(xpath="//a[contains(@popover-class,'tooltip-references')][contains(@class,'ng-binding ng-isolate-scope')]")
	public WebElement PartialPaymentLink;
	
	@FindBy(xpath="//button[contains(@id,'close-order')]")
	public WebElement CloseOrder_Icon;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.close()')]")
	public WebElement CloseSampleRequest_Icon;
	
	
	
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.close()')]")
	public WebElement CloseOrder_Icon_SampleRequest;
	
	@FindBy(xpath="//button[contains(@ng-click,'closeAndExit()')]")
	public WebElement CloseOrderAfterEditing_Button;
	
	@FindBy(xpath="//a[contains(@id, 'userInfo')]")
	public WebElement OrderListing_UserInfoIcon;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]") 
	public WebElement LogoutButton;
	
	@FindBy(xpath="//div[contains(@class,'popover-title')]//h5") 
	public WebElement Loggedin_Username;
	
	
	
	//===================================================Settings Locators==================================================//
	@FindBy(xpath="//a[contains(@href,'/settings/import')]")
	public WebElement UserInfoIcon_Settings;
	
	@FindBy(xpath="//a[contains(text(),'Sales Tax')]")
	public WebElement Settings_SalesTax;
	
	@FindBy(xpath="//a[contains(text(),'Order Status')]")
	public WebElement Settings_OrderStatus;
	
	@FindBy(xpath="//input[contains(@name,'status')]")
	public WebElement Settings_Ordername;
	
	@FindBy(xpath="//textarea[contains(@ng-model,'vm.orderStatus.Note')]")
	public WebElement Settings_Ordernotes;
	
	@FindBy(xpath="//textarea[contains(@ng-model,'orderStatusNote')]")
	public WebElement Ordersdetail_OrdernotesVerification;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-sticky-note')]")
	public WebElement Pushmenu_notes;
	
	@FindBy(xpath="//div[contains(@class,'word-break item-title cursor-pointer margin-top-5 multiline-note-content ng-binding ng-scope')]")
	public WebElement Pushmenu_NotesVerification;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement Settings_Orderstatus_savebutton;
	
	@FindBy(xpath="//button[contains(@ng-click,'save(orderStatusForm)')]")
	public WebElement Settings_OrderstatusForm_savebutton;
	
	@FindBy(xpath="//i[contains(@style,'color: rgb(0, 128, 0);')]")
	public WebElement Settings_Orderstatus_SelectColor;
	
	@FindBy(xpath="//a[contains(@translate,'SETTINGS.ORDER_STATUS.ADD_ORDER_STATUS')]")
	public WebElement Settings_AddOrderStatus;
	
	@FindBy(xpath="//a[contains(text(),'Company Profile')]")
	public WebElement Company_Profile;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.companyProfile.DisablePayment')]")
	public WebElement  Order_Payments_Checkbox;
	@FindBy(xpath="//a[contains(@ng-click,'vm.setCompanyProfile(companyProfileForm.$valid, false)')]")
	public WebElement  Save_CompanyProfile;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-default ng-binding dropdown-toggle')]")
	public WebElement Orderdetailpage_OrderStatusDropdown;
	
	
	//@FindBy(xpath="//strong[contains(text(),'"+OrdersTestdata.orderstatusname+"')]")
	//public WebElement Settings_AddOrderStatusVerification;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.autoCalculateRates')]")
	public WebElement Settings_SalesTax_AutoCalculateTaxes_Checkbox;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.companyProfile.AllowReorderTypes')]")
	public WebElement Settings_OrderContact_Checkbox;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.companyProfile.AllowOrderInquiry')]")
	public WebElement Settings_OrderTracking_Checkbox;
		
	@FindBy(xpath="//td[contains(text(),'PA')]/parent::tr//span[contains(@ng-show,'!vm.autoCalculateRates')]")
	public WebElement Settings_SalesTax_EditTaxButton;
	
	@FindBy(xpath="//td[contains(text(),'PA')]/parent::tr/td[3]/div//input[contains(@ng-model,'tax.Components[0].TaxRate')]")
	public WebElement Settings_SalesTax_EditTaxField;
	
	@FindBy(xpath="//td[contains(text(),'PA')]/parent::tr/td[4]/div//input[contains(@ng-model,'tax.ChargeTaxOnShipping')]")
	public WebElement ChargeTaxOnShipping_Checkbox;
	
	@FindBy(xpath="//td[contains(text(),'PA')]/parent::tr//button[contains(@title,'Save')]")
	public WebElement Settings_SalesTax_EditTaxField_SaveButton;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.chargeTaxesOnShipping')]")
	public WebElement Settings_ShippingSalesTaxCheckbox;
	
	@FindBy(css="#pad-wrapper > div > div.col-xs-9.col-xl-10 > div > div > div.panel-body > div:nth-child(1) > div > div > div.row.margin-top-10")
	public WebElement Settings_AddressExistenceVerification;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.openAddressModal()')]")
	public WebElement Settings_AddAddressButton;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.address.Line1')]")
	public WebElement Settings_AddAddress_AddressNameField;
	
	@FindBy(xpath="//a[contains(@ng-click,'vm.save()')]")
	public WebElement Settings_AddAddress_SaveButton;
	
	@FindBy(css="#pad-wrapper > div > div.col-xs-9.col-xl-10 > div > div > div.panel-body > div:nth-child(3) > table > tbody")
	public WebElement Settings_TaxesListing_With_PA_State_ExistenceVerification;
	
	@FindBy(xpath="//a[contains(text(),'Document Design')]")
	public WebElement Settings_DocumentDesign_Option;
	
	@FindBy(xpath="//select[contains(@ng-model,'vm.selectedDocument')]")
	public WebElement Settings_DocumentDesign_DocumentSelectionDropdown;
	
	@FindBy(xpath="//ng-content[contains(text(),'CPN Number')]/parent::label/input")
	public WebElement CustomerFacingDoc_CPNNumber_Selection;
	
	@FindBy(xpath="//ng-content[contains(text(),'Product Number')]/parent::label/input")
	public WebElement CustomerFacingDoc_ProductNumber_Selection;
	
	@FindBy(id="saveDocSettings")
	public WebElement SavingDocSettings;
	
	@FindBy(xpath="//*[contains(text(),'CPN-')]")
	public WebElement CustomerFacingDoc_CPN_Visible_Verification;
	
	@FindBy(xpath="//table[contains(@class,'decoration-table')]/descendant::td[1]")
	public WebElement ImprintLocation;
	
	
	//=============================================DownLoad & Preview===========================================================================//
	@FindBy(xpath="//ng-content[contains(text(),'Download')]")
	public WebElement OrderLevel_Order_Download;
	
	@FindBy(xpath="//strong[contains(text(),'Download')]")
	public WebElement Orderlevel_DownloadPopup_DownloadButton;
	
	@FindBy(xpath="//ng-content[contains(text(),'Preview')]")
	public WebElement PreviewButton_Orderdetails;
	
	@FindBy(xpath="//h4[contains(text(),'Purchase Order')]")
	public WebElement PreviewPopUp_PurchaseOrder;
	
	@FindBy(css="body > div.modal.modal-wide.fade.ng-scope.ng-isolate-scope.in > div > div > div.modal-body.choose-order-action-modal.margin-bottom-20.ng-scope > div > div:nth-child(2) > div > div > div.list-group.in.collapse > div:nth-child(1) > div > i")
	public WebElement PreviewPopup_PurchaseOrderSelection;
	
	@FindBy(xpath="//h4[contains(text(),'Acknowledgment')]")
	public WebElement PreviewPopUp_Acknowledgement;
	
	@FindBy(xpath="//h4[contains(text(),'Sales Order')]")
	public WebElement PreviewPopUp_SalesOrder;
	
	@FindBy(xpath="//h4[contains(text(),'Sample Request')]")
	public WebElement PreviewPopUp_SampleRequest;
	@FindBy(xpath="//div[contains(@class,'col-xs-6 col-md-6')]/div/div[3]/p")
	public WebElement InHand_At_SalesOrder_Verification_Preview;
	
	@FindBy(xpath="//h4[contains(text(),'Packing List')]")
	public WebElement PreviewPopUp_PackingListMyCompany;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-lg col-xs-2 fa-dot-circle-o')]")
	public WebElement PreviewPopup_PackingWithProductName;
	
	@FindBy(xpath="//a[contains(@class,'btn btn-primary margin-top-20 margin-bot-20 padding-left-30 padding-right-30')]")
	public WebElement PreviewPopUp_PreviewButton;
	
	
	@FindBy(xpath="//table/tbody/tr/td/div/b[contains(text(),'Download Artwork:')]")
	public WebElement Ack_DownloadArtworkn;
	
	
	@FindBy(xpath="//span[contains(@class,'doc-title')]")
	public WebElement PurchaseOrder_Preview_PurchaseOrderNumberVerification;
	@FindBy(xpath="//div[contains(@class,'pull-left')]/address")
	public WebElement PurchaseOrder_Preview_HeaderVerification;
	
	
	@FindBy(css="span[class='text-light']")
	public WebElement OrdernoPreviewVerification;
	
	@FindBy(xpath="//table[contains(@class,'table table-bordered table-col-5 table-cost')]/tbody")
	public WebElement PurchaseOrder_Preview_SplitShipment1Area;
	
	@FindBy(xpath="//div[contains(@class,'decorations')]")
	public WebElement PurchaseOrder_Preview_DecorationDetails_SplitShipment1Area;
	
	@FindBy(xpath="//tbody[contains(@class,'line-item')][3]")
	public WebElement PurchaseOrder_Preview_ShippingDetailsHeadingVerification;
	
	@FindBy(xpath="//tbody[contains(@class,'line-item')][4]")
	public WebElement PurchaseOrder_Preview_SplitShipment2Area;
	
	@FindBy(css="body > div.container-fluid > div > div.row.break-word > div:nth-child(2) > div > div:nth-child(2)")
	public WebElement PurchaseOrder_Preview_DecorationDetails_SplitShipment2Area;
	
	@FindBy(xpath="//*[@id='order-container-table-el']/tbody/tr[4]/td/div/table/tbody/tr[6]/td[1]/div/table/tbody/tr/td[1]/div/div")
	public WebElement PurchaseOrder_Preview_ShippingToDetails;
	
	@FindBy(xpath="//*[@id='order-container-table-el']/tbody/tr[4]/td/div/table/tbody/tr[6]/td[1]/div/table/tbody/tr/td[1]/div/div")
	public WebElement PurchaseOrder_Preview_SalesPersonDetailsVerification;
	
	@FindBy(xpath="//ol[contains(@class,'decoration-artwork list-inline')]/li[2]/a")
	public WebElement PurchaseOrder_Preview_Decoration_DownloadFile;
	
	@FindBy(xpath="//ol[contains(@class,'decoration-artwork list-inline')]/li[1]/a")
	public WebElement PurchaseOrder_Preview_Decoration_Atwork_DownloadFile;
	
	@FindBy(xpath="//ol[contains(@class,'decoration-artwork list-inline')]/li[2]/a")
	public WebElement PurchaseOrder_Preview_POAtworkDownload;
	
/*	@FindBy(xpath="//a[contains(@class,'btn btn-link')][3]")
	public WebElement PurchaseOrder_Preview_PODocDownload;*/
	
	@FindBy(xpath="//ul[contains(@class,'nav navbar-nav')]/li[3]/a/button")
	public WebElement PurchaseOrder_Preview_PODocDownload;
	

/*	@FindBy(xpath="//a[contains(@class,'btn btn-link ')]/i")
	public WebElement SalesOrderPreview_DownloadPDFButton;
*/	
	
	
	@FindBy(xpath="//ul[contains(@class,'nav navbar-nav')]/li[1]/a/button")
	public WebElement SalesOrderPreview_DownloadPDFButton;
	
	@FindBy(xpath="//ul[contains(@class,'nav navbar-nav')]/li[2]/a/button")
	public WebElement PurchaseOrder_Preview_ViewPackagingList;
	
	@FindBy(xpath="//body[contains(@class,'html ng-scope block-ui block-ui-anim-fade')]")
	public WebElement PackingList_DisplayView;
	
	
	@FindBy(xpath="//ul[contains(@class,'nav navbar-nav')]/li/a/ng-controller/button")
	public WebElement PO_SendButton;
	@FindBy(xpath="//button[contains(@class,'btn btn-primary ng-isolate-scope')]")
	public WebElement Ack_PO_SendButton;
	
	
	@FindBy(xpath="//i[contains(@class, 'fa fa-paper-plane')]")
	public WebElement SendButton;
	
	@FindBy(xpath="//button[contains(@analytics-label,'Send')]")
	public WebElement PackingList_SendButton;
	
	@FindBy(xpath="	//h4[contains(text(),'Packing List')]")
	public WebElement SelectPackingList;


	@FindBy(xpath="//strong[contains(text(),'Continue')]//ancestor::button")
	public WebElement Continue;
	

	@FindBy(xpath="//div[contains(@class,'list-group in collapse')]/div[1]")
	public WebElement PackingList_SupplierList;
	
	
//-----------------------------------------Sample Request
	
	@FindBy(xpath="	//table[contains(@class,'order-contact-box-row')]/descendant::td[1]")
	public WebElement SampleRequest_CustomerName;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.ShippingContact')]")
	public WebElement SampleRequest_ShippingAddress;
	

	
	//-----------------------Purchase Order History------------------------------
	
	@FindBy(xpath="//a[contains(text(),'Purchase Order History')]")
	public WebElement PO_HistoryTab;
	@FindBy(xpath="//input[contains(@ng-model,'vm.configs.search')]")
	public WebElement SearchPO_HistoryTab;
	@FindBy(xpath="//a[contains(@ng-click,'vm.viewOrder()')]")
	public WebElement PO_verify_HistoryTab;
	@FindBy(xpath="//button[contains(@ng-click,'vm.close()')]")
	public WebElement Cancel;
	@FindBy(xpath="//uib-tab-heading[contains(text(),'Suppliers')]")
	public WebElement CRM_Supplier;
	@FindBy(xpath="//input[contains(@ng-model,'vm.searchTerm')]")
	public WebElement Search_Supplier;
	@FindBy(xpath="//div[contains(@ng-click,'::selectCompany(company.Id)')]")
	public WebElement Select_order;
	@FindBy(xpath="//*[@id='pad-wrapper']/div[3]/div[1]/div[1]/div/nav/ul/li[5]/a")
	public WebElement CRM_Orders;
	@FindBy(xpath="//input[contains(@placeholder,'Search by product, supplier, etc.')]")
	public WebElement Search_Orders;
	@FindBy(xpath="//table[contains(@ng-table,'vm.orderTable')]")
	public WebElement CRM_Orderstablesizebefore;
	
	@FindBy(xpath="//*[contains(text(), 'Companies')]")
	public WebElement NavigatetoCompanies;
	
	@FindBy(xpath="//strong[contains(text(), 'Continue')]")
	public WebElement Continuebutton;
	@FindBy(xpath="//button[contains(@ng-click, 'vm.back(vm.fromLocation)')]")
	public WebElement Backbutton1;
	


	
	@FindBy(xpath="//div[contains(@name,'To')]/descendant::span[contains(@class,'close ui-select-match-close')]")
	public WebElement Send_PO_ToandCCRemoveIcon;
	
	@FindBy(xpath="//input[contains(@ng-model,'$select.search')]")
	public WebElement SendPO_To_Field;
	
	@FindBy(xpath="//input[contains(@ng-model,'$select.search')]")
	public WebElement SendSales_To_Field;
	
	@FindBy(xpath="//input[contains(@id, 'includeDocument')]")
	public WebElement VerifyDocumentCheckbox;
	
	@FindBy(xpath="//input[contains(@aria-label,'Select To Person')]")
	public WebElement SendAck_To_Field;
	
	
	//==================================Create Quote=====================================================//
	@FindBy(xpath="//button[contains(text(),'Create Quote')]")
	public WebElement OrderPage_CreateQuoteButton;
	
	@FindBy(css="div.col-xs-12 col-sm-6 border-right")
	public WebElement CreateQuote_BillingContactAddress;
	
	@FindBy(css="#pad-wrapper > div:nth-child(4) > div > div > div:nth-child(2) > order-contact > div.well.well-sm.clearfix.address-body.no-margin")
	public WebElement CreateQuote_ShippingContactAddress;
	
	@FindBy(css="#pad-wrapper > div:nth-child(3) > div > div > div.col-md-6.col-lg-6.col-xl-6.border-right > order-contact > div.well.well-sm.clearfix.address-body.no-margin")
	public WebElement CreateInvoice_BillingContactAddress;
	
	@FindBy(xpath="//button[contains(@ng-disabled,'!currentUser.canCreateInvoice')]")
	public WebElement CreateInvoice;
	
	
	@FindBy(css="#pad-wrapper > div:nth-child(3) > div > div > div:nth-child(2) > order-contact > div.well.well-sm.clearfix.address-body.no-margin")
	public WebElement CreateInvoice_ShippingContactAddress;
	
	@FindBy(xpath="//*[@id='clipboardProducts']/div/div/div[1]/div")
	public WebElement AddProduct_Clipboard_US_Product;
	
	@FindBy(xpath="//span[contains(text(),'1')][contains(@class,'badge ng-binding')]/ancestor::li")
	public WebElement PriceTab;
	
	
	@FindBy(xpath="//input[contains(@ng-model,'ShippingAccountVisible')]")
	public WebElement AccountNo_Visible_Checkbox;
	
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement AccountNo_Visible_Confirm;
	
	@FindBy(xpath="//button[contains(text(),'Preview')]")
	public WebElement Quote_Preview_Button;
	
	@FindBy(xpath="//strong[contains(text(), 'Ship Account:')]")
	public WebElement ShipAccount_QuotePreview_Verification;
	
	@FindBy(xpath="//*[@id='order-contact']/div/div[2]/div[4]/p")
	public List<WebElement> ShipAccount_QuotePreview_Verification_ListCount;
	
	@FindBy(xpath="//b[contains(text(), 'Notes')]/parent::*")
	public WebElement VendorNotes_DecoratorInstructions_QuotePreview_Verification;
	
	@FindBy(xpath="//b[contains(text(), 'Instructions:')]/parent::*")
	public WebElement DecoratorInstructions_QuotePreview_Verification;
	
	@FindBy(xpath="//ng-content[contains(text(),'Download')]")
	public WebElement QuoteDownload_Button;
	
	@FindBy(xpath="//ng-content[contains(@translate,'ORDERS.MESSAGES.QUOTE.RE')]")
	public WebElement Requote_Option_QuoteDetails;
	
	//@FindBy(xpath="//input[contains(@ng-model,'vm.options.IncludeInstructions')]")
	@FindBy(xpath="//input[contains(@ng-model,'vm.options.IncludeArtwork')]")
	public WebElement Copy_NoInstructions_To_NewQuote;
	
	
	@FindBy(xpath="//button[contains(@class,'btn btn-default btn-sm btn-visible ng-scope')]")
	public WebElement Preview_QuoteRequest;
	
	@FindBy(xpath="//li[contains(@class,'ng-pristine ng-untouched ng-valid ng-scope ng-not-empty btn-primary active')]")
	public WebElement Pricingtab;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::div[contains(@placeholder,'Enter or choose different Contact')]/span")
	public WebElement BillingContact;
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::input")
	public WebElement SearchBillingContact;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.ShippingContact')]/descendant::div[contains(@placeholder,'Enter or choose different Contact')]/span")
	public WebElement ShippingContact;
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.ShippingContact')]/descendant::input")
	public WebElement SearchShippingContact;
	
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.AcknowledgementContact')]/descendant::div[contains(@placeholder,'Enter or choose different Contact')]/span")
	public WebElement AcknowledgementContact;
	@FindBy(xpath="//order-contact[contains(@ng-model,'vm.order.AcknowledgementContact')]/descendant::input")
	public WebElement SearchAcknowledgementContact;
	
	@FindBy(xpath="//button[contains(text(),'No')]")
	public WebElement ConfirmationNo;
	
	@FindBy(xpath="//div[contains(@ng-if,'lineItem.ProductId')]/strong/a")
	public WebElement ProductName_Navigation;
	
	@FindBy(xpath="//h3")
	public WebElement ProductName_NavigatedScreen;
	
/*	@FindBy(xpath="//a[contains(@ng-if,'lineItem.Supplier.AsiNumber')]")
	public WebElement SupplierName_Navigation;*/
	
	@FindBy(xpath="//tbody[contains(@ng-repeat,'group in vm.groupedLineItems')]/descendant::a[contains(@ui-sref,'companies.company.view({ id: lineItem.Supplier.Id })')]")
	public WebElement SupplierName_Navigation;
	
	
	@FindBy(xpath="//h2/span")
	public WebElement SupplierName_NavigatedScreen;
	
	//==================================Create Order From Quote===============================================//
	@FindBy(xpath="//button[contains(text(),'Create Order')]")
	public WebElement Quote_CreateOrderbutton;
	
	@FindBy(xpath="//a[contains(@ng-if,'vm.model.length')]")
	public WebElement QuoteOrderLinkedtransaction;
	
	@FindBy(xpath="//ng-content[contains(text(),'Create Invoice')]")
	public WebElement Order_CreateInvoice;
	
	@FindBy(xpath="//div[contains(@class, 'popover-content')]")
	public WebElement LinkedTransactionDisplayedVerification;
	
	@FindBy(xpath="//a[contains(@ui-sref, 'orders.detail({ id: referenceOrder.Id })')]")
	public WebElement LinkedTransactionOrderNumber_Linkedtext;
	
	@FindBy(xpath="//a[contains(@external-app-link, 'ProductDetails&referrerPage')]")
	public WebElement ProductName;
	
	@FindBy(xpath="//a[contains(@class,'ng-binding')][contains(text(),'Invoice')]")
	public WebElement LinkedTransactionInvoice;
	
	@FindBy(xpath="//h4[contains(@ng-if,'!vm.canEditOrderNumber(vm.model)')]")
	public WebElement CreateOrder_OrderQuoteTextVerification;
	//@FindBy(xpath="//ng-content[contains(text(),'More')]")
	@FindBy(xpath="//ng-content[@translate='LABELS.MORE']")
	public WebElement Orderdetails_MoreButton;
	
	@FindBy(xpath="//ng-content[@translate='ORDERS.LABELS.MANAGE_CURRENCY']")
	public WebElement ManageCurrancy;
	
	@FindBy(xpath="//select[contains(@ng-model,'vm.order.CurrencyCode')]")
	public WebElement ManageCurrancyDropDown;
	
	@FindBy(xpath="//input[contains(@name,'conversionRate')]")
	public WebElement conversionRate;
	
	@FindBy(xpath="//button[contains(@analytics-category,'Manage Currency')]")
	public WebElement Save_ManageCurrancy;
	
	
	@FindBy(xpath="//ng-content[contains(@translate,'BUTTONS.CREATE_QUOTE')]")
	public WebElement Orderdetails_MoreButton_CreateQuote;
	
	@FindBy(xpath="//button[contains(@ng-class,'vm.confirmButtonClass')]")
	public WebElement CreateQuote_CopyOptions_Continue_Button;
	
	@FindBy(xpath="//ng-content[contains(@translate,'ORDERS.ALERTS.QUOTE.COPY')]")
	public WebElement CopyQuote_FromOrderDetails_Verification;
	
	@FindBy(xpath="//ng-content[contains(text(),'Delete Order')]")
	public WebElement Orderdetails_MoreButton_DeleteOrder;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.okay()')]")
	public WebElement DeleteOrder_Okbutton;
	
	@FindBy(xpath="//button[contains(@ng-click, 'saveAndClose()')]")
	public WebElement CloseAndExit;
	
	@FindBy(xpath="//ng-content[contains(text(),'Reorder')]")
	public WebElement MoreButton_Reorder;
	
	@FindBy(xpath="//ng-content[contains(text(),'Requote')]")
	public WebElement MoreButton_Requote;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.options.IncludePoReference')]")
	public WebElement VerifyPopUpCheckBox;
	
	@FindBy(xpath="//button[contains(@ng-class, 'vm.confirmButtonClass')]")
	public WebElement ContinueReorder;
	
	@FindBy(xpath="//span[contains(@class, 'ng-scope')]/strong")
	public String Reorder_Verification_Wait;
	
	@FindBy(xpath="//span[contains(@class, 'ng-scope')]/strong")
	public WebElement Reorder_Verifications;
	
	@FindBy(xpath="//div[contains(@class,'toast-message')]")
	public WebElement DeleteOrder_ErrorMessageVerification;
	
    @FindBy(xpath="//input[contains(@ng-model,'vm.contact.Address.Line1')]")
	public WebElement EditShippingAddressField;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.contact.Address.PostalCode')]")
	public WebElement EditShippingPostalCodeField;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement EditShippingSaveButton;
	
	@FindBy(xpath="//button[contains(text(),'Ok')] | //button[contains(text(),'Yes')]")
	public WebElement EditingConfirm;
	
/*	@FindBy(xpath="//button[contains(text(),'Yes')] | //button[contains(text(),'Ok')]")
	public WebElement EditingConfirm1;*/
	
	@FindBy(xpath="//button[contains(text(),'Ok')] | //button[contains(text(),'Yes')]")
	public WebElement DateConfirm;
	
/*	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement DateConfirm1;*/

	//=====================================================Invoice Screen====================================//
	@FindBy(xpath="//button[contains(@ng-click,'vm.openPaymentModal()')]")
	public WebElement Invoice_EnterPaymentButton;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.payment.IsFullPayment')]")
	public WebElement Invoice_EnterPaymentPopup_PayinFullCheckbox;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.payment.Amount')]")
	public WebElement Invoice_EnterPaymentPopup_PayinFullTextField;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement Invoice_EnterPaymentPopup_SaveButton;
	
	@FindBy(xpath="//ng-content[contains(text(),'Delete Invoice')]")
	public WebElement Invoice_DeleteInvoice;
	
	//====================================================Conversions for invoice Screen For Payment Calculation================//
	
	@FindBy(css="#pad-wrapper > div.row > div > div > div:nth-child(2) > div > table > tfoot > tr.subtotals > td:nth-child(2) > strong")
	public WebElement SubtotalWithoutServicecharges_InvoiceScreen;
	
	@FindBy(css="#pad-wrapper > div.row > div > div > div:nth-child(2) > div > table > tfoot > tr:nth-child(2) > td:nth-child(2) > p:nth-child(4)")
	public WebElement SalesTaxWithoutServiceCharges_InvoiceScreen;
	
	@FindBy(css="#pad-wrapper > div.row > div > div > div:nth-child(2) > div > table > tfoot > tr.totals > td:nth-child(2) > strong")
	public WebElement AmountDueWithoutServiceCharges_InvoiceScreen;
	
	
	//==========================================================Total Cost Locators Product Details(Order)========================//
	@FindBy(xpath="//tr[contains(@ng-repeat, 'lineItem in group')]/td[3]/table/tfoot/tr/td[4]/strong")

	public WebElement TotalPrice_SplitShipment1;
	
	@FindBy(xpath="//tr[contains(@ng-repeat, 'lineItem in group')][2]/td[3]/table/tfoot/tr/td[4]/strong")

	public WebElement TotalPrice_SplitShipment2;
	
	@FindBy(xpath="//tr[contains(@class,'total-row')]/td[@class='text-right']")
	public WebElement TotalPricePreview;
	
	@FindBy(xpath="//th[contains(@class,'text-center total-price')]")
	public WebElement POTotalPrice;
	
	
	//===========================================================Sales Order Preview Locators=====================================//
	@FindBy(xpath="//button[contains(@ng-click,'vm.cancel()')]")
	public WebElement ClosePreviewPopup;
	
	@FindBy(xpath="//button[contains(@ng-click,'vm.cancel()')]")
	public List<WebElement> ClosePopup;
	
	@FindBy(xpath="//table[contains(@class,'order-contact-box-row')]/tbody/tr/td[1]/div/div")
	public WebElement SalesOrderPreview_SalesPersonAddressDetails;
	
	@FindBy(xpath="//table[contains(@class,'order-contact-box-row')]/tbody/tr/td[2]/div/div")
	public WebElement SalesOrderPreview_BillingandShippingAddress;
	
	@FindBy(xpath="//table[contains(@class,'table table-bordered table-col-5 ')]/tbody[1]")
	public WebElement SalesOrderPreview_ProductSplit1Details;
	
	@FindBy(xpath="//div[contains(@class,'decorations')]")
	public WebElement SalesOrderPreview_DecorationdetailsSplit1details;
	
	@FindBy(xpath="//*[@id='order-container-table-el']/tbody/tr[4]/td/div/table/tbody/tr[6]/td[1]/div")
	public WebElement SalesOrderPreview_ShippingDetails_ShipFrom;
	
	@FindBy(xpath="//*[@id='order-container-table-el']/tbody/tr[3]/td/div/table/tbody/tr[12]/td[1]/div/table/tbody/tr/td[3]/div/div/div[2]")
	public WebElement SalesOrderPreview_CompleteShippingDetails;
	
	@FindBy(xpath="//tr[contains(@class,'instructions')]")
	public WebElement SalesOrderPreview_InstructionsVerification;
	
	@FindBy(xpath="//*[@id='order-container-table-el']/tbody/tr[5]/td/section/div/table/tbody/tr[1]")
	public WebElement SalesOrderPreview_Freight1Display;
	
	@FindBy(xpath="//*[@id='order-container-table-el']/tbody/tr[5]/td/section/div/table/tbody/tr[2]")
	public WebElement SalesOrderPreview_Freight2Display;
	
	@FindBy(xpath="//section[contains(@id,'total')]/div/table/tbody/tr[2]/td[2]")
	public WebElement SalesOrderPreview_TotalAmount;
	

	@FindBy(xpath="//address[contains(@class,'no-margin')]/parent::div/following::address[1]")
	public WebElement SalesOrderPreview_BillingToAddress;
	
	@FindBy(xpath="//address[contains(@class,'no-margin')]/parent::div/following::address[2]")
	public WebElement SalesOrderPreview_ShippingToAddress;
	
	
	//=================================================Blind Ship Locators======================================================//
	@FindBy(xpath="//input[contains(@ng-model,'vm.order.IsBlindShip')]")
	//@FindBy(xpath="//input[contains(@ng-model,'shippingDetail.IsBlindShip')]")
	public WebElement Orderdetail_BlindShipCheckbox;
	
	//@FindBy(xpath="//button[contains(@ng-class,'vm.confirmButtonClass')]")
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement Order_BlindShipConfirm;
	
	@FindBy(xpath="//span[contains(text(),'Blind Ship')]")
	public WebElement BlindShipText_ShippingDetails_PurchaseOrder;
	
	//===================================================Acknowlodgement Doc Locators==========================================//
	@FindBy(xpath="//tr[contains(@class,'instructions')]")
	public WebElement Acknowledgement_Instructions;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/address")
	public WebElement AcknowledgementPreviewAddress;
	
	//==================================================WESP Locators========================================================//
    @FindBy(xpath="//a[contains(text(),'ESP Web')]")
    public WebElement ESPWeb_Tab;
    
    @FindBy(xpath="//input[contains(@id,'searchKeyword')]")
    public WebElement ProductSearch_TextField;
    
    @FindBy(xpath="//button[contains(@id,'btnQuickSearch')]")
    public WebElement ProductQuickSearchButton;
    
    @FindBy(xpath="//label[contains(@ng-click,'methods.toggleClientSafe(clientSafeEnabled)')]")
    public WebElement Settings_SafeMode_ToggleStatusButton;
    
    @FindBy(xpath="//input[contains(@id,'client-safe-checkbox')]")
    public WebElement Settings_SafeMode_ToggleGetStatusButton;
    
    
    @FindBy(xpath="//input[contains(@ng-model,'searchWithinTerms')]")
    public WebElement SearchWithinTerms_SearchField;
    
    @FindBy(xpath="//button[contains(@id,'btnSearchWithin')]")
    public WebElement SearchWithinTerms_GoButton;
   @FindBy(xpath="//span[contains(@ng-if,'::!product.CanEcommOrder')]")
    public WebElement Product_OrderButton;
    
    @FindBy(xpath="//span[contains(@ng-if,'product.CanEcommOrder')]")
    public WebElement ProductHover_OrderButton;
    
    
	@FindBy(xpath="//table[contains(@class, 'table table-striped table-bordered')]") 
	public List<WebElement> Price_Grid;

  
  
    
    @FindBy(xpath=" //input[contains(@placeholder, 'QTY')]")
    public WebElement QTY_Grid;
 
    
    @FindBy(xpath="//*[@id='configurator-view-table-view']/div[1]/div/div[2]/button")
    public WebElement ClickAtSelect;
    //======= @FindBy(xpath="//button[contains(@ng-click,'::vm.next(variant)')]")
    @FindBy(xpath="//ng-content[contains(@translate, 'SELECT')]")
     public WebElement ShoppingCartProduct_SelectButton;
    
    @FindBy(xpath="//button[contains(@class,'btn btn-xs btn-primary ng-isolate-scope')]")
    public WebElement Order_SavetoclipboardButton;
    
    @FindBy(xpath="//button[contains(@class, 'btn btn-sm btn-default btn-block ng-isolate-scope')]/span")
    public WebElement ProductOrderButton_QuickInfo;
    
    @FindBy(xpath="//a[contains(@ng-click,'methods.closeInPageQuickview($event)')]")
    public WebElement ProductQuickInfo_Close;
    
    @FindBy(xpath="//span/ng-content[contains(@translate, 'BUTTONS.ORDER')]")
    public WebElement CanadianProduct_OrderButton;
    
    @FindBy(xpath="//span[contains(text(),'Enter or Select Company')]")
    public WebElement ChooseCustomer_TextField;
    
    @FindBy(xpath="//span[contains(text(),'Enter or Select Company')]")
    public WebElement ChooseCustomer_TextField1;
    
 //   @FindBy(xpath="//input[contains(@ng-model,'$select.search')]")
 //   public WebElement ChooseCustomer_SearchInsertion;
    
    @FindBy(xpath="//input[contains(@placeholder,'Enter or Select Company')]")
    public WebElement ChooseCustomer_SearchInsertion;
    
  
    @FindBy(xpath="//button[contains(text(),'Create Order')]")
    public WebElement ChooseCustomer_CreateOrderButton;
    
    @FindBy(xpath="//button[contains(@page-name,'ProductDetailsQuickView')]")
    public WebElement Product_CompareDefaultButton;
    
    @FindBy(xpath="//button[contains(@translate,'ESP_WEB.LABELS.COMPARE_COUNT')]")
    public WebElement ProductCompare_CountButton;
    
    @FindBy(xpath="//button[contains(@type,'button')]/ng-content[contains(@translate, 'BUTTONS.ORDER')]")
    public WebElement ProductCompare_OrderButton;
    
    @FindBy(xpath="//div[contains(@class,'overlay-container o-wrapper ng-scope ng-isolate-scope')]")
    public WebElement OrderCreation_FromWESP_Verification;
    
    @FindBy(xpath="//button[contains(@class,'btn btn-default btn-xs btn-block')]")
    public WebElement RemoveProductButton_FromCompare;
    
    @FindBy(xpath="//input[contains(@ng-change,'::methods.markProduct(product)')]")
    public WebElement ProductMark_Checkbox;
    
    @FindBy(xpath="//li[contains(@id,'125117')]")
    public WebElement CopyTo_Toggledropdown;
    
    @FindBy(xpath="//*[@id='125117']/ul/li[2]/a")
    public WebElement CopyTo_Toggledropdown_Project;
    
    @FindBy(xpath="//a[contains(text(),'My Projects')]")
    public WebElement CopyTo_Toggledropdown_Project_MyProjects;
    
 
    @FindBy(xpath="//input[contains(@ng-change,'methods.markProduct(product)')]")
    public WebElement Projects_ProductCheckBox;
    
    @FindBy(xpath="//a[contains(@confirm-method,'vm.methods.product.deleteMarkedProducts')]")
    public WebElement Projects_ProductDelete;
    
    @FindBy(xpath="//button[contains(@ng-click,'okay()')]")
    public WebElement Projects_ProductDeleteConfirm;
    
    @FindBy(xpath="//a[contains(@id,'Clipboard')]")
    public WebElement Clipboard_Icon;
    
    @FindBy(xpath="//*[@id='ngClipboard']/ul/li/div/div[3]/ul/li[1]/div/div[1]/div/div[1]/input")
    public WebElement ClipboardProduct_CheckboxSelection;
    
    @FindBy(xpath="//*[@id='ngClipboard']/ul/li/div/div[3]/ul/li[2]/div/div[1]/div/div[1]/input")
    public WebElement ClipboardProduct_CheckboxSelectionSecondProduct;
    
  
    
    @FindBy(xpath="//ng-content[@translate='ESP_WEB.LABELS.CREATE_PRESENTATION']")
    public WebElement Clipboard_CreatePresentation;
  
    @FindBy(xpath="//input[contains(@ng-model,'vm.presentation.Name')]")
    public WebElement CreatePresentation_NameField;
    
    @FindBy(xpath="//span[contains(@ng-click,'$select.activate()')]")
    public WebElement CreatePresentation_CompanyField;
    
    @FindBy(xpath="//input[contains(@ng-model,'$select.search')]")
    public WebElement CreatePresentation_CompanyFieldSearch;
    
    @FindBy(xpath="//button[contains(text(),'Create')]")
    public WebElement CreatePresentation_CreateButton;
    
    @FindBy(xpath="//ng-content[@translate='ESP_WEB.PRESENTATIONS.LABELS.ORDER']")
    public WebElement Presentation_OrderButton;
    
    @FindBy(xpath="//button[contains(@ng-click,'::vm.save()')]")
    public WebElement SaveToCardButton;
    
    @FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
    public WebElement ProductSearch_ShoppingCart_Idaho_Tab;
    
    @FindBy(css="#shoppingCartProducts > div > div > div:nth-child(1) > div")
    public WebElement ProductSearch_ShoppingCart_Idaho_Selection;
    
    @FindBy(xpath="//i[contains(@class,'icon esp-icon icon-cart')]")
    public WebElement ShoppingCart_Icon;
    
    @FindBy(xpath="//*[@id='ngShoppingCart']/ul/li/div/div[3]/ul/li/table/tbody/tr/td[1]/div/input")
    public WebElement ShoppingCart_ProductSelection_Checkbox;
    
    @FindBy(xpath="//button//ng-content[contains(text(),'Order')]")
    public WebElement ShoppingCart_OrderButton;
    
    @FindBy(xpath="//*[@id='ngClipboard']/ul/li/div/div[4]/div/div/ul/li/a")
    public WebElement CreateQuote_FromClipboard_ThroughOrderButton;
    
    @FindBy(xpath="//ng-content[@translate='ESP_WEB.NAVIGATIONS.PROJECTS']")
    public WebElement WESP_ProjectTab;
    
    @FindBy(xpath="//uib-tab-heading[@translate='ESP_WEB.PROJECTS.LABELS.NUMBER_OF_SAVED_PRODUCTS']")
    public WebElement Projects_SavedProductsTab;
    
  //  @FindBy(css="#productsTabPane > div > slide-panel > div > div > div > div.product-wrapper.media.prod.tile > div.media-left.quickview-click.ng-isolate-scope > div > div > img")
 //   public WebElement ProductImageHover;
    @FindBy(xpath="//div[contains(@ng-repeat,'product in items track by product.TrackingId')]//descendant::div[contains(@class,'tile-row')]")
    public WebElement ProductImageHover;
    
   
  
    @FindBy(xpath="//button[contains(text(),'Quick Info')]")
    public WebElement QuickInfoView;
    
    @FindBy(xpath="//span[contains(@class,'caret')]")
    public WebElement CreateQuote_Toggle;
    
    @FindBy(xpath="//*[@id='appMenu']/li[6]/a")
    public WebElement Delete_ClipboardProduct;
    
    @FindBy(xpath="//button[contains(text(),'Ok')]")
    public WebElement ClipboardDeleteConfirm;
    

    
    //=====================================================Sample Request From WESP Locators============================================
    @FindBy(xpath="//a[contains(@title,'Budget Barrel Duffel')]")
    public WebElement BudgetBarrelProduct_Details_link;
    
    @FindBy(xpath="//button[contains(@class,'btn btn-default btn-block dropdown-toggle')]")
    public WebElement ProductDetial_Requestbutton;
    
    @FindBy(xpath="//a[contains(text(),'Request Sample')]")
    public WebElement RequestSample_Option;
    
    @FindBy(xpath="//span[contains(@class,'ng-binding text-info')]")
    public WebElement DateNeeded_RequestSample;
    
    @FindBy(css="#datepicker-1025-7299-33 > button > span")
    public WebElement DateSelection;
    
    
    @FindBy(xpath="//select[contains(@ng-model,'vm.order.ShippingDetail.Carrier')]")
    public WebElement ShipVia_SampleRequest;
    
    @FindBy(xpath="//input[contains(@ng-model,'$select.search')]")
    public WebElement SampleRequest_SendTo_Field;
    
    @FindBy(xpath="//button[contains(@ng-click,'::vm.next()')]")
    public WebElement SampleRequest_SendButton;
    
    @FindBy(xpath="//a[contains(text(),'Sample Requests')]")
    public WebElement Orders_SampleRequestTab;
    
    @FindBy(css="#pad-wrapper > div.row > div > div.col-xs-12.col-sm-8.col-sm-pull-4.col-md-9.col-md-pull-3 > div:nth-child(3) > div > table > tbody > tr:nth-child(1) > td.text-left.order-number > span")
    public WebElement RequestDetails;
    
    @FindBy(xpath="//button[contains(@ng-click,'vm.save(false, true)')]|//button[contains(@ng-click,'vm.save(false,true)')]")
    public WebElement SampleRequestSaveButton;
    
    @FindBy(xpath="//textarea[contains(@ng-model,'vm.order.Instructions[0].Content')]")
    public WebElement SampleRequest_InstructionsArea;
    
    @FindBy(xpath="//input[contains(@ng-model,'vm.order.inHandsDay')]")
    public WebElement SamplerRequest_Inhand_Date;
    
    @FindBy(xpath="//input[contains(@ng-model,'vm.order.shipDay')]")
    public WebElement ShipdateField;
    
    @FindBy(xpath="//ng-content[contains(text(),'Firm')]/ancestor::label/input")
    public WebElement ShipDateFirmButtonOption;
    
    @FindBy(xpath="//div[contains(@class,'modal-body')]/p")
    public WebElement ConfirmationMessageonDateSelection;

    
    

	
    //===============================================Canadian Product Idaho Calculation Locators===========================//
    @FindBy(css="#pad-wrapper > div:nth-child(11) > div > div > div > div.ng-scope > div > table > tfoot > tr.subtotals > td:nth-child(3) > strong")
    public WebElement CanadianProductOrder_Subtotal;
  
    @FindBy(xpath="//tfoot[contains(@class,'app-tour-hide-on-active')]/tr[2]/td[2]/p[1]")
    public WebElement CanadianProductOrder_Discount;
    
   @FindBy(xpath="//tfoot[contains(@class,'app-tour-hide-on-active')]/tr[2]/td[2]/p[2]")
   public WebElement CanadianProductOrder_BookedMargin;
   
   @FindBy(xpath="//input[contains(@name,'cost')]")
   public WebElement Netcost_Field_BookedMargin;
   
   @FindBy(xpath="//input[contains(@ng-model,'lineItem.Margin')]")
   public WebElement Margin_Field_BookedMargin;
   
   @FindBy(xpath="//input[contains(@ng-model,'lineItem.Price')]")
   public WebElement Price_Field_BookedMargin;
    
    @FindBy(xpath="//tfoot/tr/td[2]/p[3]")
    public WebElement CanadianProductOrder_Tax;
    
    @FindBy(xpath="//tfoot/tr[3]/td[2]/strong")
    public WebElement CanadianProductOrder_AmountDue;
    
    @FindBy(xpath="//tfoot/tr/td[3]/strong")
    public WebElement TotalCost_CanProduct;
    
    @FindBy(xpath="//tfoot/tr/td[4]/strong")
    public WebElement TotalPrice_CanProduct;
    
    @FindBy(xpath="//tfoot/tr[3]/td[2]/strong")
    public WebElement AmountDue_TotalPrice;
    
    @FindBy(xpath="//tfoot/tr[1]/td[2]/strong")
    public WebElement SubTotal_TotalCost;
    
    @FindBy(xpath="//tfoot/tr[1]/td[3]/strong")
    public WebElement SubTotal_TotalPrice;
    
    @FindBy(xpath=" //tfoot/tr[contains(@class,'subtotals')]/td[3]")
    public WebElement SubTotal_TotalPriceCurrancy;
 
 
    @FindBy(xpath="//*[@id='pad-wrapper']/div[9]/div/div/div/div[2]/div/table/tbody[2]/tr/td[3]/table/tfoot/tr/td[4]/strong")
    public WebElement TotalPrice_Product2_BookedMargin;
    
    @FindBy(xpath="//*[@id='pad-wrapper']/div[9]/div/div/div/div[2]/div/table/tbody[2]/tr/td[3]/table/tfoot/tr/td[3]/strong")
    public WebElement TotalCost_Product2_BookedMargin;
    
	@FindBy(xpath="//strong[contains(text(), 'Amount Due:')]/parent::td/parent::tr/td[2]/strong")
	public WebElement CanadianProduct_SalesOrderPreview_AmountDue;
	
	@FindBy(xpath="//tfoot/tr/td[3]")
	public WebElement CanadianProductOrder_Total;
	
	@FindBy(xpath="//table/tbody/tr[7]/td[2]")
	public WebElement CanadianProductOrder_PurchaseOrderPreview_Amountdue;
	
	
	
	//==================================================Quote Total Calculation Locators & Other Locators=================================//
	@FindBy(xpath="//tfoot//tr[contains(@class,'subtotals')]/td[3]/strong")
	
	public WebElement QuoteSubtotal;
	
	@FindBy(xpath="//tfoot/tr/td[2]/p[3]")
	public WebElement QuoteSalesTax;
	
	@FindBy(xpath="//tr[contains(@class,'totals')]/td[2]/strong")
	public WebElement QuoteTotal;
	
	@FindBy(xpath="//tr[contains(@class,'totals')]/td[3]/strong")
	public WebElement QuotePreviewTotal;
	
	@FindBy(xpath="//button[contains(text(),'Preview')]")
	public WebElement QuotePreviewButton;
	
	@FindBy(xpath="//span[contains(text(),'4')][contains(@class,'badge ng-binding')]")
	public WebElement QuoteDetail_QuoteRequestTab;
	
	
	
	//===============================================Order Additional Locators=============================================//
	@FindBy(xpath="//input[contains(@clear-input,'vm.order.inHandsDay')]/parent::div/span/i")
	public WebElement Inhand_Orderdate_CalenderIcon;
	
	@FindBy(xpath="//input[contains(@clear-input,'vm.order.shipDay')]/parent::div/span/i")
	public WebElement InShip_Orderdate_CalenderIcon;
	
	@FindBy(xpath="//i[contains(@class,'glyphicon glyphicon-chevron-right')]")
	public WebElement CalenderMoveNextMonthIcon;
	
	@FindBy(xpath="//span[contains(text(),'15')][contains(@class,'ng-binding')]")
	public WebElement InhandDate_Selection;
	
    @FindBy(xpath="//button[contains(@translate,'BUTTONS.APPLY')]")
    public WebElement InHandDate_Apply_Button;
	
	@FindBy(xpath="//input[contains(@clear-input,'vm.order.shipDay')]/parent::div/span/i")
	public WebElement Shipdate_CalenderIcon;
	
	@FindBy(xpath="//span[contains(text(),'14')][contains(@class,'ng-binding')]")
	public WebElement Shipdate_Selection;
	
	//@FindBy(xpath="//*[@id='pad-wrapper']/div[7]/div/div[2]/div/div[1]/div/div/div[1]/span/span[2]")
	
	@FindBy(xpath="//div[contains(@ng-model , 'vm.order.ShippingDetail.Carrier')]//div/span/i")

	public WebElement OrderShipVia;
	
	@FindBy(xpath="//div[contains(text(),'UPS Ground')]")
	public WebElement ShipviaSelection;
	
	@FindBy(xpath="//label[contains(text(),'Ship Via')]")
	public WebElement ShipViaLabel;
	
	
	//===========================================================Settings(Document Design Locators)===============================//
	@FindBy(xpath="//a[contains(text(),'Document Design')]")
	public WebElement Settings_DocumentDesign;
	
	@FindBy(xpath="//button[contains(@name,'ngFileUpload')]")
	public WebElement Documents_LogoUpload_Button;
	
	@FindBy(xpath="//img[contains(@class,'artwork-preview')]")
	public WebElement Documents_LogoDisplay_Verification;
	
	@FindBy(xpath="//button[contains(@ng-click,'removeFile(file)')]")
	public WebElement Documents_Logo_RemoveButton;
	
	@FindBy(css="#toast-container")
	public WebElement Document_LogofileNotSupported_Error;
	
	@FindBy(xpath="//a[contains(@ng-click,'vm.saveDocSettings()')]")
	public WebElement Documents_Settings_SaveButton;
	
	
	
	
	
	//=============================================Edit Contact Details Locators==================================================//
	@FindBy(xpath="//order-contact[contains(@ng-model, 'vm.order.ShippingContact')]/descendant::button")
	public WebElement EditShippingAddressButton;
	
	@FindBy(xpath="//order-contact[contains(@ng-model, 'vm.order.BillingContact')]/descendant::button")
	public WebElement BillingAddress_EditButton;
	
	@FindBy(xpath="//order-contact[contains(@ng-model, 'vm.order.AcknowledgementContact')]/descendant::button")
	public WebElement AcknowledgementAddress_EditButton;
	
	
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.contact.Name')]")
	public WebElement ContactName;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.contact.Address.Phone.Number')]")
	public WebElement ContactPhoneNo;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.contact.EmailAddress')]")
	public WebElement ContactEmail;
	
	
	//========================================================Order Number Edit Locators==========================================//
	@FindBy(xpath="//button[contains(@class,'btn edit-order-btn')]")
	public WebElement OrderNo_EditButton;
	
	@FindBy(xpath="//div[contains(text(),'Loading...')] | //div[contains(text(),'Saving...')]")
	public String SpinnerLoader;
	
	//@FindBy(xpath="//div[contains(text(),'Loading')] | //div[contains(text(),'Saving')]")
	//public WebElement SpinnerLoader;
	
	//==============================================================Profit Maker Locators=========================================//
	@FindBy(xpath="//*[contains(text(),'Send to ProfitMaker')]")
	public WebElement SendProfitMaker_Button;
	
	@FindBy(xpath="//*[contains(@translate,'BUTTONS.OK')]")
	public WebElement SendProfitMakerSend_ConfirmButton;
	
	@FindBy(xpath="//div[contains(@class,'toast-message')]")
	public WebElement ProfitMakerSend_SuccessMessage;
	
	//==========================================Services Vendor Add Locators=====================================================//
	@FindBy(xpath="//span[contains(@aria-label,'Select a Vendor activate')]")
	public WebElement Vendor_CompanySelection_Field_Services;
	
	@FindBy(xpath="//input[contains(@aria-label,'Select a Vendor')]")
	public WebElement VendorField_TextInsertion_Services;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-building')]")
	public WebElement VendorCompany_Services;
	
	@FindBy(xpath="//*[@id='pad-wrapper']/div[9]/div/div/div/div[2]/div/table/tbody[2]/tr/td[2]/div[2]/a")
	public WebElement VendorCompany_FreightServices_OrdersDetails;
	
	@FindBy(xpath="//span[@class='ng-binding']")
	public WebElement ServicesCompany_Verification_AtCrmLevel;
	
	//--------------------------------------------Orders Action Buttons
	
		@FindBy(xpath="//button[contains(@class,'btn btn-sm btn-default')]") 
		public WebElement 	ActionButtonDropdown;
		@FindBy(xpath="//ng-content[contains(text(),'Send')]") 
		public WebElement	ActionButtonSend;
		@FindBy(xpath="//ng-content[contains(text(),'Preview')]") 
		public WebElement 	ActionButtonPreview;
		@FindBy(xpath="//ng-content[contains(text(),'Download')]") 
		public WebElement 	ActionButtonDownload;
		
	//-----------------------------------------Quote Action Button
		
		@FindBy(xpath="//a[contains(@translate,'ORDERS.TABS.TAB_TITLE_QUOTES')]") 
		public WebElement 	Quotetab;
		@FindBy(xpath="//button[contains(@ng-click,'vm.save(false,true)')]") 
		public WebElement 	SaveQuote;
		
	//-------------------------------------Invoice Locators	
		@FindBy(xpath="//a[contains(text(),'Invoices')]") 
		public WebElement 	Invoicetab;
	//------------------------------------Sample Request
		@FindBy(xpath="//a[contains(text(),'Sample Requests')]") 
		public WebElement 	SampleRequesttab;
	
	//--------------------------------Enter Payment
		@FindBy(xpath="//button[contains(text(),'Enter Payment')]") 
		public WebElement 	EnterPayment;
		
		
	//---------------------------------Copy Line Item
		@FindBy(xpath="//button[contains(text(),'Copy')]") 
		public WebElement 	CopyLineItem;
		@FindBy(xpath="//td[contains(@class,'item-description ng-scope')]") 
		public WebElement 	ProductDetail;
		@FindBy(xpath="//table[contains(@class,'table pricing-table product-table ng-pristine ng-untouched ng-valid ng-isolate-scope ui-sortable ng-not-empty table-hover')]/tbody/tr/td[contains(@class,'item-description ng-scope')][1]") 
		public WebElement 	CopiedProductDetail;
		@FindBy(xpath="//div[contains(@class,'toast toast-success')]") 
		public WebElement 	LineItemCopiedandAdded;
		@FindBy(xpath="//table[contains(@class,'table pricing-table product-table ng-pristine ng-untouched ng-valid ng-isolate-scope ui-sortable ng-not-empty table-hover')]/tbody/tr/td/div/button[contains(@ng-click,'vm.openProductModal(lineItem)')][1]") 
		public WebElement 	EditCopiedLineItem;
		@FindBy(xpath="//li[contains(@select,'vm.tabSet.onShipping()')]/a/uib-tab-heading/ng-content") 
		public WebElement Shipping_Tab;
		@FindBy(xpath="//div[contains(@name,'ShipFrom')]") 
		public WebElement ShippingFromaddressBeforeCopyLineItem;
		@FindBy(xpath="//div[contains(@ng-if,'$ctrl.ngModel.Name || $ctrl.ngModel.Address.isDefined()')]") 
		public WebElement ShippingToaddressBeforeCopyLineItem;
		
		
		//-------------------------------------Import Line Items
		@FindBy(xpath="//thead[contains(@ng-include,'app/modules/orders/partials/order-pricing-thead-content.html')]/tr/th/button[contains(text(),'Import Line Item')]") 
		public WebElement ImportLineItem;
		@FindBy(xpath="//input[contains(@placeholder,'Search by product, supplier, etc.')]") 
		public WebElement SearchLineItem;
		@FindBy(xpath="//td[contains(@data-title-text,'Order #')]") 
		public WebElement VerifySearchehLineItemByOrderNo;
		@FindBy(xpath="//i[contains(@class,'fa fa-chevron-up')]") 
		public WebElement ClickOrderLine;
		@FindBy(xpath="//input[contains(@ng-checked,'vm.selected.indexOf(lineItem.Id) > -1')]") 
		public WebElement SelectOrderLine;
		@FindBy(xpath="//div[contains(@class,'modal-footer ng-scope')]/button[contains(text(),'Import')]") 
		public WebElement ImportLineItembutton;
		@FindBy(xpath="//input[contains(@ng-model,'vm.currentCustomer')]") 
		public WebElement SelectCurrentCustomerOnly;
		@FindBy(xpath="//div[contains(@placeholder,'Enter or Select Company')]") 
		public WebElement SelectCompany;
		@FindBy(xpath="//thead[contains(@ng-include,'templates.header')]/tr/th/div/span[contains(text(),'Customer')]") 
		public WebElement CustomerColumn;
		public static String BeforeXpath_Customer="/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/order-line-item-table/table/tbody/tr[";
		public static String AfterXpath_Customer="]/td[4]/span";
		
		@FindBy(xpath="//option[contains(@translate,'SEARCH.FILTERS.HEADERS.STATUS.ALL')]") 
		public WebElement DefaultFilter;
		
		@FindBy(xpath="//button[contains(text(),'Cancel')]") 
		public WebElement CancelImportLineItemScreen;
		
		//-------------------------- Add Custom Product Attribute
		
		
		@FindBy(xpath="//span[contains(text(),'Add Custom Product Attribute')]") 
		public WebElement AddCustomProductAttribute;

		@FindBy(xpath="//input[contains(@placeholder,'Enter or select product attribute')]") 
		public WebElement WaterMarkAddCustomProductAttribute;
		
		@FindBy(xpath="//span[contains(text(),'Material')]") 
		public WebElement TypeAheadAddProductAttribute;
		
		@FindBy(xpath="//span[contains(text(),'Material')]/a[contains(@aria-label,'Select box clear')]") 
		public WebElement DeleteAddProductAttribute;
		
		@FindBy(xpath="//div[contains(@placeholder,'Enter or Choose Contact')]//i[contains(@class,'glyphicon glyphicon-remove')]") 
		public WebElement CancelShippingAddress;
		
		@FindBy(xpath="//div[contains(@placeholder,'Enter or Choose Contact')]//span[contains(@class,'btn btn-default form-control ui-select-toggle')]") 
		public WebElement CustomerFieldShippingAddress;
		
		@FindBy(xpath="//input[contains(@placeholder,'Enter or Choose Contact')]") 
		public WebElement ProvideCustomerShippingAddress;
		
		@FindBy(xpath="//div[contains(@class,'tab-content')]//li[2]") 
		public WebElement MyCompanyShippingAddress;
		
		@FindBy(xpath="//div[contains(@class,'padding-right-30')]") 
		public WebElement ShippingAddressVerification;
		
		@FindBy(xpath="//ng-content[contains(text(),'Add Task')]") 
		public WebElement AddTaskFromOrders;
		
		@FindBy(xpath="//div/span[contains(@ng-if,'!vm.task.showNotes')]") 
		public WebElement VerifyNotesLinkUderTasks;
		@FindBy(xpath="//a[contains(@ng-click,'vm.openNoteModal($event, vm.task)')]") 
		public WebElement HideNotes;
		@FindBy(xpath="//div[contains(@class,'font-13 text-med ng-binding')]") 
		public WebElement ReviewNotes;
		
	

		//Export Orders,Quote and Invoice
		@FindBy(xpath="	//tbody/tr[1]/descendant::input") public WebElement Order1Selection;
		@FindBy(xpath="	//tbody/tr[2]/descendant::input") public WebElement Order2Selection;
		@FindBy(xpath="	//div[contains(@ng-if,'vm.currentUser.canExport')]/button") public WebElement ExportOrders;
		@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]/li/a[contains(@translate,'NAVIGATION.EXCEL')]") public WebElement ExportOrdersExcel;
		@FindBy(xpath="	//tbody/tr[1]/descendant::input") public WebElement Quote1Selection;
		@FindBy(xpath="	//tbody/tr[2]/descendant::input") public WebElement Quote2Selection;
	
		
		//Select All Orders
		
		@FindBy(xpath="//input[contains(@ng-model,'vm.selectAll')]") public WebElement SelectAllOrders;
		@FindBy(xpath="//b[contains(@translate,'MESSAGES.SELECT_ALL')]") public WebElement SelectAllMessage;
		@FindBy(xpath="//b[contains(@translate,'CLEAR_SELECTION')]") public WebElement ClearSelection;
		

		
		
		
		
	public WebDriver driver;
public OrdersLocators(WebDriver driver) {
	this.driver = driver;

}
}
