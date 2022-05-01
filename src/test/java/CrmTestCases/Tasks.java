
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import OrdersTestcases.CreateOrder;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;



public class Tasks extends HelpingFunction {
	static OrdersLocators CreateOrders = PageFactory.initElements(driver, OrdersLocators.class);	
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	public static String tasknameveri;
	public static String TaskForm_Visibility_Private;
	public static String TaskForm_Visibility_Public;
	public static String TaskForm_Visibility_Private_Order;
	public static String TaskForm_Visibility_Public_Order;
	public static String parentWindow;
	public static boolean supplier;
	public static boolean CreatorOnly;
	
	public static void CommonTaskCreation() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 RefreshPage();
		 Thread.sleep(4000);
		//Click the userInfoIcon on My Order screen	 
		 Click("User settings icon", GetData.OrderListing_UserInfoIcon);
		 //Click the settings option
		 Click("Settings", GetData.UserInfoIcon_Settings);
		//Click the default task option
		 Click("Create Task",GetData.default_tasks);
		
		//Click the Add task option
		 Click("Save task",GetData.AddCommon_tasks);
	
		 Thread.sleep(2000);
		 //Provide task name
		 Input("Enter Team name ",GetData.TaskName,CrmTestData.Task);
		 Click("a",GetData.CommonTaskAssignedToDropDown);
		 Input("Enter Team name ",GetData.CommonTaskAssignedTo,CrmTestData.admin);
		 GetData.CommonTaskAssignedTo.sendKeys(Keys.ENTER);
		 //save task
		 Click("a",GetData.savetask);
		 driver.navigate().refresh();
		 String Commontask=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.Task+"')]")).getText();
		 System.out.print(Commontask+'\n');
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.Task+"')]")).isDisplayed());
		
		 }
	
	public static void Unique_CommonTaskCreation() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Thread.sleep(2000);
		//Click the Add task option
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();",  GetData.AddCommon_tasks);
		 Click("Add common task",GetData.AddCommon_tasks);
		
		 Thread.sleep(2000);
		 //Provide task name
		 Input("Enter Team name ",GetData.TaskName,CrmTestData.Task);
		
		 //save task
		 Click("a",GetData.savetask);
		// driver.navigate().refresh();
		
		 Thread.sleep(1000);
		 Assert.assertTrue(GetData.Error.isDisplayed());
		// Verify("ERROR", GetData.Error.getText(), "Error message is not displaying when task is created with unique name.");
		
		 }
	public static void CommonTaskForm_DueDate() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 if(GetData.NoDueDate.isSelected())
		 {
			 Assert.assertTrue(!GetData.DueINTextField.isEnabled());
		 }
		 Click("Select Due Same Day",GetData.DueSameDate);
		 Thread.sleep(2000);
		 Assert.assertTrue(!GetData.DueINTextField.isEnabled());
	 
		/* String textname=GetData.DueINTextField.getAttribute("disabled");
		 System.out.println(textname);
		 Thread.sleep(2000);
		 Assert.assertTrue(true);*/
		 Click("Select Due Same Day",GetData.DueINDays);
		 Input("Provide Days ",GetData.EnableDueINTextField,CrmTestData.Days);
		 String days=GetData.EnableDueINTextField.getAttribute("value");
		System.out.println(days);
		Thread.sleep(2000);
		Verify(CrmTestData.Days,days,"Days are not matched");
		 
		 }
	
	public static void EditCommonTask() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Click("Click Cancel Button",GetData.Cancel );
		 Thread.sleep(5000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.Task+"')]"));
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		 Thread.sleep(5000);
		 
		 driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.Task+"')]/parent::tr/td[7]/button[1]")).click();
		 Input("Edit Task Name ",GetData.TaskName,CrmTestData.EditCommonTask);
		 Click("a",GetData.CommonTaskAssignedToDropDown);
		 Input("Enter Team name ",GetData.CommonTaskAssignedTo,CrmTestData.nonadmin);
		 GetData.CommonTaskAssignedTo.sendKeys(Keys.ENTER);
		 String CommonTaskAssignedTo= GetData.CommonTaskAssignedToText.getText();
		 System.out.print(CommonTaskAssignedTo+'\n');
		 
		 Select TaskType=new Select(GetData.CommonTaskTypeDropDown);
		 TaskType.selectByVisibleText("Email");
		 WebElement optionCommonTaskType = TaskType.getFirstSelectedOption();
		 String CommonTaskType=optionCommonTaskType.getText();
		 System.out.print(CommonTaskType+'\n');
		
		
		 Select TaskPriority=new Select(GetData.CommonTaskPriorityDropDown);
		 TaskPriority.selectByVisibleText("High");
		 WebElement optionTaskPriority = TaskPriority.getFirstSelectedOption();
		 String CommonTaskPriority=optionTaskPriority.getText();
		 System.out.print(CommonTaskPriority+'\n');
		 //save task
		 Click("a",GetData.savetask);
		 driver.navigate().refresh();
		 String EditCommonTask=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]")).getText();
		 System.out.print(EditCommonTask+'\n');
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]")).isDisplayed());
		 WebElement Element1=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]"));
		 js.executeScript("arguments[0].scrollIntoView();", Element1);
		 
		 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CommonTaskAssignedTo+"')]/parent::tr/td[2]")).isDisplayed());
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CommonTaskType+"')]/parent::tr/td[3]")).isDisplayed());
		 Thread.sleep(2000);
		 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CommonTaskPriority+"')]/parent::tr/td[6]")).isDisplayed());
		 }
	public static void CreateTaskFromMainTask_AfterEditTaskNameFromSettings() throws InterruptedException, AWTException, IOException
	{
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		// Click("Click Cancel Button",GetData.Cancel );
		 Click("Click Cancel Button",GetData.CRM);
		 Thread.sleep(5000);
		 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
		 Thread.sleep(2000);
		 Click("Please Click Add Task button",GetData.AddTaskButton);
		 Thread.sleep(2000);
		 Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
		 Click("Click on task name drop down to select task name",driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.EditCommonTask+"')]")));
		 WebElement element1=  GetData.SaveTask;
			// Configure the Action
			Actions action = new Actions(driver);

			//Focus to element
			action.moveToElement(element1).perform();

			// To click on the element
			action.moveToElement(element1).click().perform();
			
			
			 Thread.sleep(2000);
			
			 Input("Please Enter Main task in Search field", GetData.TaskSearchField, CrmTestData.EditCommonTask);
			 Thread.sleep(10000);
			 Verify(CrmTestData.EditCommonTask, GetData.GetMainTaskContent.getText(), "Task content is not saved");
	}
	
	public static void DeleteCommonTask() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 GetData.OrderListing_UserInfoIcon.click();
		 //Click the settings option
		 GetData.UserInfoIcon_Settings.click();
		//Click the default task option
		 GetData.default_tasks.click();
		 Thread.sleep(5000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]"));
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		 Thread.sleep(5000);
		 String Commontask=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]")).getText();
		 System.out.print(Commontask+'\n');
		 driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]/parent::tr/td[7]/button[2]")).click();
		 Click("Delete Confirmation ",GetData.ConfirmDel);
		 Thread.sleep(2000);
		 Verify("Success", GetData.Success.getText(), "Task content is not matching");
		// Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.EditCommonTask+"')]")).isDisplayed());
		
		 }
	public static void DeleteCommonTask_VerityFromMainAddTaskDropDown() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		// Click("Click Cancel Button",GetData.Cancel );
		 Click("Click Cancel Button",GetData.CRM);
		 Thread.sleep(5000);
		 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
		 Thread.sleep(2000);
		 Click("Please Click Add Task button",GetData.AddTaskButton);
		 Thread.sleep(2000);
		 Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
		 List<WebElement> DeleteTaskName=driver.findElements(By.xpath("//span[contains(text(),'"+CrmTestData.EditCommonTask+"')]"));
		 int size=DeleteTaskName.size();
		 System.out.println(size);
		 Thread.sleep(2000);
		 Assert.assertTrue(size==0);
		 }
	public static void DeleteCommonTask_VerityCreatedTaskFromMainTask() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Thread.sleep(2000);
		 Click("Click Cancel Button",GetData.Cancel );
		 Input("Please Enter Main task in Search field", GetData.TaskSearchField, CrmTestData.EditCommonTask);
		 Thread.sleep(10000);
		 Verify(CrmTestData.EditCommonTask, GetData.GetMainTaskContent.getText(), "Created Task is deleted once user delete common task from settings");
		 }
		 
	public static void VerifyCommonTaskCreation() throws InterruptedException, AWTException, IOException{
		
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Thread.sleep(2000);
		 Click("Please click at Add Task button",GetData.AddTaskButton);
		 Thread.sleep(2000);
		 Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
		 Thread.sleep(2000);
		 Input("Provide Common Task Name", GetData.ProvideCommonTaskname, CrmTestData.Task);
	/*	List<WebElement>taskverifylist=driver.findElements(By.xpath("//li[contains(@id,'ui-select-choices-8')]//descendant::span[contains(text(),'"+CrmTestData.Task+"')]"));
		String taskverify= taskverifylist.get(1).getText();
		 System.out.print(taskverify+'\n');*/
		 List<WebElement>taskverifylist=driver.findElements(By.xpath("//span[contains(text(),'"+CrmTestData.Task+"')]"));
		 String taskverify= taskverifylist.get(1).getText();
		 System.out.print(taskverify+'\n');
		 Thread.sleep(2000);
		
		Verify(taskverify,CrmTestData.Task,"Common task is not showing in drop down");
		
		// driver.findElement(By.xpath("//button[contains(@translate,'BUTTONS.CANCEL')]")).click();
		 
	}

	public static void AddTask() throws InterruptedException, AWTException, IOException
	{
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		RefreshPage();
		Thread.sleep(2000);
		Click("Please click at Add Task button",GetData.AddTaskButton);
		Thread.sleep(2000);
		Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
		Click("Click on task name drop down to select task name",driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.Task+"')]")));
		LocalDate localDate = LocalDate.now();
		System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate)+'\n');
		String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
		int ext=abc.lastIndexOf("/");						
		// Get last word
		TaskCurdat=abc.substring (ext+1);
		System.out.println(TaskCurdat);
		Thread.sleep(2000);
		Click("Click to open celender",GetData.OpenCalender);
		driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
		Thread.sleep(2000);
		Click("Click to Open AssignTo DropDown",GetData.AssignedTo);
		Input("Enter Team name ",GetData.SearchTeam,CrmTestData.TeamName);
		String Teamverify=driver.findElement(By.xpath("//div[contains(@title,'"+CrmTestData.TeamName+"')]")).getText();
		Teamverify=Teamverify.trim();
		System.out.println(Teamverify+'\n');
		Verify(CrmTestData.TeamName,Teamverify,"Team name is not showing in drop down");
		Click("Click to open celender",GetData.MoreDetail);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", GetData.SaveTask);
		Thread.sleep(2000);
		WebElement element1=  GetData.SaveTask;
		// Configure the Action
		Actions action = new Actions(driver);
		//Focus to element
		action.moveToElement(element1).perform();
		// To click on the element
		action.moveToElement(element1).click().perform();
		//Click("save",GetData.SaveTask);*/
		Thread.sleep(2000);
		System.out.println(GetData.VerifyTask.getText());
		String Taskverify=driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.Task+"')]")).getText();
		System.out.print(Taskverify+'\n');
		Thread.sleep(2000);
		Verify(CrmTestData.Task, Taskverify, "Task content is not showing");
		RefreshPage();
		Thread.sleep(3000);
		Verify(CrmTestData.Task,Taskverify, "Task content is not showing after refresh");

	} 
				public static void VerifyTaskInAppointment() throws InterruptedException, AWTException, IOException
				{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click to Appointment" ,GetData.Appointment);
					 Thread.sleep(15000);
					 Click("Click to Appointment" ,GetData.MonthView);

					 Thread.sleep(10000);
					 Assert.assertTrue(driver.findElement(By.id("appointmentsCalendar")).getText().contains(CrmTestData.Task));
					
		} 

				
				
				public static void EditTask() throws InterruptedException, AWTException, IOException{
					
					 driver.navigate().back();
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Add Task button",GetData.EditTask);
					 Thread.sleep(2000);
			
					 Input("Please Enter Task Name", GetData.EditTaskName, CrmTestData.EditTask);
					 
					 Thread.sleep(2000);
					 Click("Click to Open AssignTo DropDown",GetData.AssignedTo);
					 Input("Enter Team name ",GetData.SearchTeam,CrmTestData.TeamName);
					 String Teamverify=driver.findElement(By.xpath("//div[contains(@title,'"+CrmTestData.TeamName+"')]")).getText();
					 Teamverify=Teamverify.trim();
					 System.out.println(Teamverify+'\n');
					 Verify(CrmTestData.TeamName,Teamverify,"Team name is not showing in drop down");
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 js.executeScript("arguments[0].scrollIntoView();", GetData.SaveTask);
					
					
					 Thread.sleep(2000);
					// Click("save",GetData.SaveTask);
					 
					WebElement element1=  GetData.SaveTask;
					// Configure the Action
					Actions action = new Actions(driver);

					//Focus to element
					action.moveToElement(element1).perform();

					// To click on the element
					action.moveToElement(element1).click().perform();
					
					//Click("save",GetData.SaveTask);*/
					 Thread.sleep(2000);
						Click("Please click at Open Task Filter",GetData.OpenFilterlist);
					 Click("Select Open Task Filter",GetData.OpenTaskFilter);
					 Thread.sleep(3000);
					 
					 String EditTaskverify=driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.EditTask+"')]")).getText();
					 System.out.print(EditTaskverify+'\n');
					 
					 Thread.sleep(2000);
					 Verify(CrmTestData.EditTask, EditTaskverify, "Task content is not matching");
					

				}
				
				public static void CompleteTask() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Complete Task checkbox",GetData.CompleteTask);
					 Click("Please click at Complete Task checkbox",GetData.OpenFilterlist);
					 Click("Please click at Completed Task Filter",GetData.CompletedTaskFilter);
					 Thread.sleep(5000);
					 Verify(CrmTestData.EditTask, GetData.VerifyTask.getText(), "Completed content is not matching");
					 RefreshPage();
					 
					 Click("Please click at Complete Task checkbox",GetData.OpenFilterlist);
					 Click("Please click at Completed Task Filter",GetData.CompletedTaskFilter);
					 String EditTaskverify=driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.EditTask+"')]")).getText();
					 System.out.print(EditTaskverify+'\n');
					 Verify(CrmTestData.EditTask, EditTaskverify, "Completed task content is not showing after refresh");


				}
				
				public static void DeleteTask() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Complete Task checkbox",GetData.DeleteTask);
					 Thread.sleep(2000);
					 Click("Please click at Complete Task checkbox",GetData.ConfirmDel);
					 Verify("Success", GetData.Success.getText(), "Task content is not matching");
				}
					
				public static void CompletedDatAndBY() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Assert.assertTrue(GetData.CompletedDate.isDisplayed());
					 Assert.assertTrue(GetData.CompletedBy.isDisplayed());
				}
				
				public static void AssignTaskToNonAdmin() throws InterruptedException, AWTException, IOException{
					
		  			 Thread.sleep(20000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
					 Click("Please Click Add Task button",GetData.AddTaskButton);
					 Thread.sleep(2000);
					 
					 
					 driver.findElement(By.xpath("//a[contains(text(), 'Notes')]")).click();
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//textarea[contains(@ng-model, 'vm.newNote.Content')]")).sendKeys(CrmTestData.MainTask);
					 Thread.sleep(2000);
					 Click("Please Click Add Task button",GetData.AddCompNoteButton);
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//a[contains(text(), 'Details')]")).click();
					 Thread.sleep(2000);
					 Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
					 Click("Click on task name drop down to select task name",driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.Task+"')]")));
					// Input("Please Enter Main Task Name", GetData.TaskName, CrmTestData.MainTask);
					 Thread.sleep(2000);
					
					 Click("Click to open celender",GetData.OpenCalender);
					 Thread.sleep(2000);
					 LocalDate localDate = LocalDate.now();
				     System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
				     String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);

					    int ext=abc.lastIndexOf("/");						
					// Get last word
					    TaskCurdat=abc.substring (ext+1);
					    System.out.println(TaskCurdat);
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
					 Click("Click to Open AssignTo DropDown",GetData.AssignedTo);
					 Input("Enter nonadmin user",GetData.SearchTeam,CrmTestData.nonadmin);
					 GetData.SearchTeam.sendKeys(Keys.ARROW_DOWN);
					 GetData.SearchTeam.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 WebElement element1=  GetData.SaveTask;
					// Configure the Action
				 	 Actions action = new Actions(driver);

					//Focus to element
				 	 action.moveToElement(element1).perform();

					// To click on the element
				 	 action.moveToElement(element1).click().perform();
					/* Input("Please Enter Main task in Search field", GetData.TaskSearchField, CrmTestData.Task);
					 Thread.sleep(10000);
					 Verify(CrmTestData.Task, GetData.GetMainTaskContent.getText(), "Task content is not matching");*/
				 	Thread.sleep(15000);
				 	 GetData.OrderListing_UserInfoIcon.click();
				 	 Click("Click on Logout",GetData.LogoutButton);
				 	 Thread.sleep(2000);
				 	Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASINONAdmin);
					Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.USERNONAdmin);
				 	Input("Please Enter Password", GetData.Password, CrmTestData.PASSNONAdmin);
				 	Click("Please click login button",GetData.LoginButton);
				 	//..
				 	Thread.sleep(2000);
				 	Click("a",GetData.CRM);
				 	Thread.sleep(2000);
				 	 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
				 	 Click("Click on My Taks",GetData.MyTask);
				 	 Input("Please Enter Main task in Search field", GetData.TaskSearchField, CrmTestData.Task);
				 	 Thread.sleep(2000);
				 	Verify(CrmTestData.Task, GetData.GetMainTaskContent.getText(), "Task content is not matching");
				 	 
				 	
				
					 
		  			} 
				
			  	public static void AddTaskFromMain() throws InterruptedException, AWTException, IOException{
			  		
			  		
		  			 
		  			 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(15000);
				 	 GetData.OrderListing_UserInfoIcon.click();
				 	 Click("Click on Logout",GetData.LogoutButton);
				 	 Thread.sleep(2000);
					 Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASI);
					Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.USER);
					 Input("Please Enter Password", GetData.Password, CrmTestData.PASS);
					 Click("Please click login button",GetData.LoginButton);
					 
					 Thread.sleep(2000);
					 Click("a",GetData.CRM);
					 Thread.sleep(2000);
					 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
					 Click("Please Click Add Task button",GetData.AddTaskButton);
					 Thread.sleep(2000);
					 
					 
					 driver.findElement(By.xpath("//a[contains(text(), 'Notes')]")).click();
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//textarea[contains(@ng-model, 'vm.newNote.Content')]")).sendKeys(CrmTestData.MainTask);
					 Thread.sleep(2000);
					 Click("Please Click Add Task button",GetData.AddCompNoteButton);
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//a[contains(text(), 'Details')]")).click();
					 Thread.sleep(2000);
					 Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
					 Click(" select task name",driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.Task+"')]")));
					// Input("Please Enter Main Task Name", GetData.TaskName, CrmTestData.MainTask);
					 Thread.sleep(2000);
					/* driver.findElement(By.xpath("//i[contains(@ng-click, '$select.toggle($event)')]")).click();
					
					 Thread.sleep(2000);
				
					 driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter or Select Team or Individual')]")).sendKeys("TeamForTask");
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter or Select Team or Individual')]")).sendKeys(Keys.DOWN);
					 Thread.sleep(1000);
					 driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter or Select Team or Individual')]")).sendKeys(Keys.ENTER);*/

					 Click("Click to open celender",GetData.OpenCalender);
					 Thread.sleep(2000);
					 LocalDate localDate = LocalDate.now();
				     System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
				     String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);

					    int ext=abc.lastIndexOf("/");						
					// Get last word
					    TaskCurdat=abc.substring (ext+1);
					    System.out.println(TaskCurdat);
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
				 	 WebElement element1=  GetData.SaveTask;
					// Configure the Action
				 	 Actions action = new Actions(driver);

					//Focus to element
				 	 action.moveToElement(element1).perform();

					// To click on the element
				 	 action.moveToElement(element1).click().perform();
					 Input("Please Enter Main task in Search field", GetData.TaskSearchField, CrmTestData.Task);
					 Thread.sleep(10000);
					 Verify(CrmTestData.Task, GetData.GetMainTaskContent.getText(), "Task content is not matching");
					// driver.findElement(By.xpath("//span[contains(text(), 'TeamForTask')]")).isDisplayed();
					// String notes =driver.findElement(By.xpath("//span[contains(@ng-if, 'task.Note')]")).getText();
					// Verify(CrmTestData.MainTask, notes, "Notes content is not matching");
					 
		  			} 
			  	
			  	public static void ViewTaskBasesOnCategory() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(10000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					driver.navigate().refresh();
					 
					 List<WebElement> Categories = GetData.GetCategoriesTypes;
					 int CategoryCount=Categories.size();
					 String[] result = new String[5];
					 
					 if(CategoryCount>1) {
						 for(int a=0; a<CategoryCount; a++) {
							 if(a>0) {
								 int b=a-1;
								 Categories.get(b).click();
							 }
							 Categories.get(a).click();
							 Thread.sleep(5000);
							result[a]= driver.findElement(By.xpath("//div[contains(@ng-if, 'vm.showCountMessage')]")).getText();
							System.out.println(result[a]);
						 }
						 
						 Assert.assertNotEquals(result[0], result[1]);
					 }
					 
					 
					 
					 
		  			} 
			  	
			  	
			  	
				public static void TaskFromAppointment() throws InterruptedException, AWTException, IOException{
					
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click to Appointment" ,GetData.Appointment);
					 Thread.sleep(2000);
					 Click("Click on dropdown to select New task", GetData.Appointmentdropdown);
					 Click("Please click at Add Task button", GetData.NewTask);
					 Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
					 Click("Click on task name drop down to select task name",driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.Task+"')]")));
					// Click("Click to Appointment" ,GetData.ToggleButton);
					// Input("Please Enter Task Name", GetData.TaskName, CrmTestData.Task);					
					 Thread.sleep(2000);
					 Click("Click to open celender",GetData.OpenCalender);
					 Thread.sleep(2000);
					 LocalDate localDate = LocalDate.now();
				     System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
				     String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
				     int ext=abc.lastIndexOf("/");						
					// Get last word
				     TaskCurdat=abc.substring (ext+1);
				     System.out.println(TaskCurdat);
					 driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
					 WebElement element1=  GetData.SaveTask;
						// Configure the Action
						Actions action = new Actions(driver);

						//Focus to element
						action.moveToElement(element1).perform();

						// To click on the element
						action.moveToElement(element1).click().perform();
					 Thread.sleep(2000);
					 Verify("Success", GetData.Success.getText(), "Task content is not matching");


				} 
				
				public static void CreateDefaultTask_DefaultItemVisibilityPrivate() throws InterruptedException, AWTException, IOException{
					 Thread.sleep(10000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 //Update visibility as private from Default item visibility
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					Thread.sleep(5000);
					 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
					 Thread.sleep(2000);
					 Click("Select Private",GetData.TaskDefaultItemVisibilty_Private);
					 String TaskDefaultItemVisibiltyPrivate=GetData.TaskDefaultItemVisibilty_Private.getText();
					 System.out.println(TaskDefaultItemVisibiltyPrivate);
					 Thread.sleep(2000);
					 Click("Click Save",GetData.TaskDefaultItemVisibilty_Save);
				
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'toast-title')]")));
					
					Assert.assertTrue(GetData.Success.isDisplayed());
					//Access Default task window
					Click("Please click at Sales Tax",GetData.DefaultTasks);
					//Add Default Task
					Click("Please Click Add Task button",GetData.AddDefaultTask);
					
					Thread.sleep(2000);
					//Provide task name 
					 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.PrivateDefaultTask);
					 Click("Please select Sales Order",GetData.DefaultTaskSalesOrderCheckbox);
					 Thread.sleep(2000); 
					 //Review task visibility
					 TaskForm_Visibility_Private=GetData.DefaultTaskForm_Visibility_Private.getText();
					System.out.println(TaskForm_Visibility_Private);
					Thread.sleep(2000);
					//Verify Default item visibility and Add default visibility are the same
					Assert.assertTrue(TaskDefaultItemVisibiltyPrivate.equalsIgnoreCase(TaskForm_Visibility_Private), "Task visibility is not update on form");
					 Click("Save task",GetData.SaveAddress);
					 driver.navigate().refresh();
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.PrivateDefaultTask+"')]"));
					 js.executeScript("arguments[0].scrollIntoView();", Element);
					 Thread.sleep(2000);
					 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.PrivateDefaultTask+"')]")).isDisplayed());
					 
		  			} 
				
				public static void DefaultItemVisibilityPrivate_MainTaskPage() throws InterruptedException, AWTException, IOException{
			
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("CRM Tab",GetData.CRM);
					 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
					 Click("Please Click Add Task button",GetData.AddTaskButton);
					 Thread.sleep(2000);
					 Click("More Details",GetData.MoreDetail);
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.DefaultTaskForm_Visibility_Private_Order.getText().contains("Private"));
					
					
					 
		  			} 
				
				public static void DefaultItemVisibilityPrivate_MainAppointmentPage() throws InterruptedException, AWTException, IOException{
					
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click to Appointment" ,GetData.Appointment);
					 Thread.sleep(2000);
					 Click("Click on dropdown to select New task", GetData.Appointmentdropdown);
					 Click("Please click at Add Task button", GetData.NewTask);
					 Thread.sleep(2000);
					 Click("More Details",GetData.MoreDetail);
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.DefaultTaskForm_Visibility_Private_Order.getText().contains("Private"));
					
					
					 
		  			} 
				
				
				
				public static void VerifyPrivateDefaultTask_Order() throws InterruptedException, AWTException, IOException{
		  		
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 SoftAssert softAssert = new SoftAssert();
					 Click("Please click at Orders Tab",GetData.Orders);
					 Click("Create Order",GetData.CreateOrder);
					 Thread.sleep(5000);
					 Click("Please click at Save Button",GetData.SaveOrders.get(1));
					 Thread.sleep(20000);
					 driver.navigate().refresh();
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Thread.sleep(2000);
					 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.PrivateDefaultTask));
					 softAssert.assertAll();
					 WebElement PrivateTaskelement= driver.findElement(By.xpath("//span/strong[contains(text(),'"+CrmTestData.PrivateDefaultTask+"')]"));
					 WebElement ClickEditelement= driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.PrivateDefaultTask+"')]/ancestor::div[contains(@class, 'task-details')]/descendant::i[contains(@class, 'fa fa-pencil')]"));
					 HelpingFunction.HoverandClick(PrivateTaskelement,ClickEditelement, driver);
					
					 Thread.sleep(2000);
					 TaskForm_Visibility_Private_Order=GetData.DefaultTaskForm_Visibility_Private_Order.getText();
					System.out.println(TaskForm_Visibility_Private_Order);
					 Thread.sleep(2000);
					Assert.assertTrue(TaskForm_Visibility_Private_Order.equalsIgnoreCase(TaskForm_Visibility_Private), "Task visibility is not update on form");
					
		  			} 
				public static void UpdatePrivateDefaultTaskVisibiltyToPublic_OrderLevelImpact() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 SoftAssert softAssert = new SoftAssert();
					Select publicvisibility=new Select(GetData. DefaultTaskForm_SelectVisibility);
					publicvisibility.selectByVisibleText("Public");
					Click("Click save visibility",GetData.SaveTask_OrderTaskbar);
					Thread.sleep(2000);
					Click("Click save visibility",GetData.CloseOrder_Icon);
					Click("Create Order",GetData.CreateOrder);
					Thread.sleep(5000);
					 Click("Please click at Save Button",GetData.SaveOrders.get(1));
					Thread.sleep(2000);
					driver.navigate().refresh();
					Click("Please click at Settings",GetData.OpenTaskInSidebar);
					Thread.sleep(15000);
					Assert.assertTrue( driver.getPageSource().contains(CrmTestData.PrivateDefaultTask));
					softAssert.assertAll();
					WebElement PrivateTaskelement= driver.findElement(By.xpath("//span/strong[contains(text(),'"+CrmTestData.PrivateDefaultTask+"')]"));
					WebElement ClickEditelement= driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.PrivateDefaultTask+"')]/ancestor::div[contains(@class, 'task-details')]/descendant::i[contains(@class, 'fa fa-pencil')]"));
					HelpingFunction.HoverandClick(PrivateTaskelement,ClickEditelement, driver);
					Thread.sleep(2000);
					TaskForm_Visibility_Private_Order=GetData.DefaultTaskForm_Visibility_Private_Order.getText();
					System.out.println(TaskForm_Visibility_Private_Order);
					Assert.assertTrue(TaskForm_Visibility_Private_Order.equalsIgnoreCase(TaskForm_Visibility_Private), "Task visibility is not update on form");
					
					
		  			} 
				
				public static void CreateDefaultTask_DefaultItemVisibilityPublic() throws InterruptedException, AWTException, IOException{
					 //Click("Cancel Task",GetData.CancelTask);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 SoftAssert softAssert = new SoftAssert();
					 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
					 Thread.sleep(2000);
					 Click("Defualt Item Visibilty",GetData.TaskDefaultItemVisibilty_Public);
					 
					 String TaskDefaultItemVisibiltyPublic=GetData.TaskDefaultItemVisibilty_Public.getText();
					 System.out.println(TaskDefaultItemVisibiltyPublic);
					 Click("Click Save",GetData.TaskDefaultItemVisibilty_Save);
					 WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-title')]")));
					Click("Please click at Sales Tax",GetData.DefaultTasks);
					Click("Please Click Add Task button",GetData.AddDefaultTask);
					TaskForm_Visibility_Public=GetData.DefaultTaskForm_Visibility_Public.getText();
					System.out.println(TaskForm_Visibility_Public);
					
					Thread.sleep(2000);
					
					 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.PublicDefaultTask);
					 Click("Please select Sales Order",GetData.DefaultTaskSalesOrderCheckbox);
					Assert.assertTrue(TaskDefaultItemVisibiltyPublic.equalsIgnoreCase(TaskForm_Visibility_Public), "Task visibility is not update on form");
					softAssert.assertAll();
					 Click("Save task",GetData.SaveAddress);
					 driver.navigate().refresh();
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.PublicDefaultTask+"')]"));
					 js.executeScript("arguments[0].scrollIntoView();", Element);
					 Thread.sleep(2000);
					 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.PublicDefaultTask+"')]")).isDisplayed());
					 
		  			} 
			  	public static void CreateDefaultTask() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(10000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Click("Please click at Sales Tax",GetData.DefaultTasks);
					 Click("Please Click Add Task button",GetData.AddDefaultTask);
					 Thread.sleep(2000);
					 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.DefaultTask);
					 Thread.sleep(2000); 
					 Click("Please select Due Date",GetData.DefaultTaskDueDate);
					 Click("Please select Sales Order",GetData.DefaultTaskSalesOrderCheckbox);
					 Click("Save task",GetData.SaveAddress);
					 driver.navigate().refresh();
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DefaultTask+"')]"));
					 js.executeScript("arguments[0].scrollIntoView();", Element);
					 Thread.sleep(2000);
					 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DefaultTask+"')]")).isDisplayed());
				//	 Verify(CrmTestData.MainTask, GetData.GetMainTaskContent.getText(), "Task content is not matching");
					 
		  			} 
			  	
			  	public static void VerifyDefaultTask_Order() throws InterruptedException, AWTException, IOException{
		  			 Thread.sleep(5000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Orders Tab",GetData.Orders);
					 Click("Create Order",GetData.CreateOrder);
					 Thread.sleep(5000);
					 Click("Please click at Save Button",GetData.SaveOrders.get(1));
					 Thread.sleep(2000);
					 driver.navigate().refresh();
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Thread.sleep(15000);
					 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.DefaultTask));
					
		  			} 
				
			  	public static void DeleteDefaultTask() throws InterruptedException, AWTException, IOException{
		  			 
					 Thread.sleep(20000);
		  			// JavascriptExecutor js = (JavascriptExecutor) driver;
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.CloseOrder_Icon);
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at aviator",GetData.settings);
					 Click("Please click at Sales Tax",GetData.DefaultTasks);
					 Thread.sleep(3000);
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 WebElement Element= driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DefaultTask+"')]/parent::tr/td[9]/button[2]"));
					 js.executeScript("arguments[0].scrollIntoView();", Element);
					 driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DefaultTask+"')]/parent::tr/td[9]/button[2]")).click();
					 Click("Please OK to delete",GetData.ConfirmDel);
					 Thread.sleep(2000);
					 Verify("Success", GetData.Success.getText(), "Task is not deleted");
					 
		  			} 
			  	public static void AllDeleteDefaultTask() throws InterruptedException, AWTException, IOException{
					 int i;
					 Thread.sleep(20000);
						// JavascriptExecutor js = (JavascriptExecutor) driver;
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at aviator",GetData.settings);
					 Click("Please click at Sales Tax",GetData.DefaultTasks);
					 Thread.sleep(3000);
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 List<WebElement>  Element= driver.findElements(By.xpath("//td/parent::tr/td[9]/button[2]"));
					
					 for(i=50;i<Element.size();i++)
					 {
						 if(i==50)
						 {
							 js.executeScript("arguments[0].scrollIntoView();", Element.get(i));
							 Element.get(i).click();
							 Click("Please OK to delete",GetData.ConfirmDel);
							 Thread.sleep(2000);
							 WebDriverWait wait = new WebDriverWait(driver,500);
							 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner']")));
						 }
						if(i>50)
						{
							driver.navigate().refresh();
							Thread.sleep(2000);
							Element.get(i).click();
							 Click("Please OK to delete",GetData.ConfirmDel);
							 Thread.sleep(2000);
							 WebDriverWait wait = new WebDriverWait(driver,500);
							 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner']")));
						}
						 
					 }
						 
					 
					 
						} 
			 
				public static void CreateContactWhileCreatingOrder() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			//		 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Click("Please click at Settings",GetData.Orders);
					 Click("Please click at Settings",GetData.CreateOrder);
					 driver.findElement(By.xpath("//span[contains(text(), 'Enter or Choose Contact')]")).click();
					 driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter or Choose Contact')]")).sendKeys(CrmTestData.ContactFromOrder);
					 driver.findElement(By.xpath("//ng-content[contains(text(), 'Create a new contact named')]")).click();	
					 Input("Please Enter address", GetData.Address, CrmTestData.Address);
					 Thread.sleep(2000);
					 GetData.Address.sendKeys(Keys.ARROW_DOWN);
					 Thread.sleep(2000);
					 GetData.Address.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.Save);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.CloseOrder_Icon);
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.SaveandClose);
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.CRM);
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.NavigatetoContacts);
					 Thread.sleep(3000);
					 Input("Please Enter address", GetData.CompaniesSearchField, CrmTestData.ContactFromOrder);
					 Thread.sleep(5000);
					 Verify("Number of Contacts: 1", GetData.ResultFound.getText(), "Contact is not created");
		
		  			} 
				
				public static void VerifyCompanyContactIconAndAddress() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			//		 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Click("Please click at Settings",GetData.Orders);
					 Click("Please click at Settings",GetData.CreateOrder);
					 Thread.sleep(5000);
					 driver.findElement(By.xpath("//span[contains(text(),'Enter or Select Company')]")).click();
					 Thread.sleep(2000);
					 driver.findElement(By.xpath("//div[contains(@name,'Customer')]/input[contains(@ng-model,'select.search')]")).sendKeys("Auto-");
					 Thread.sleep(10000);
					 driver.findElement(By.xpath("//div[contains(@name,'Customer')]/input[contains(@ng-model,'select.search')]")).sendKeys(Keys.ARROW_DOWN);
					 driver.findElement(By.xpath("//div[contains(@name,'Customer')]/input[contains(@ng-model,'select.search')]")).sendKeys(Keys.ENTER);
					 Thread.sleep(10000);
					 Assert.assertTrue(driver.findElement(By.xpath("//order-contact[contains(@ng-model, 'vm.order.BillingContact')]/div/div/div/i")).isDisplayed());
					 
					 Assert.assertTrue(driver.findElement(By.xpath("//order-contact[contains(@ng-model, 'vm.order.BillingContact')]/div/div/div[2]/div/strong")).isDisplayed());

					
		
		  			} 
				public static void PresentationDefaultVisibility() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click Cancel Button",GetData.Cancel );
					 Click("Click save visibility",GetData.CloseOrder_Icon);
					 Click("Click Cancel Button",GetData.CRM);
					 Thread.sleep(5000);
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at settings",GetData.settings);
					 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.PresentationDefaultVisibility.isEnabled(), "CreateOnly is not selected by default");
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.PresentationEveryoneVisibility.isDisplayed(), "Everyone option is not displayed");
		
		  			}
				
				public static void TasksDefaultVisibility(boolean Private) throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					if(Private)
					{
					 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
					 Thread.sleep(2000);
					
					 
						 if(GetData.TaskDefaultVisibilityPublic.isEnabled())
					 {
						 Click("Select Private Visibility",GetData.TaskDefaultVisibilityPrivate);
						 
					 }
					
						 
					 Click("Save Private Visibility",GetData.TaskDefaultItemVisibilty_Save);
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.TaskDefaultVisibilityPrivate.isEnabled());
					}
					 else
						 
					 {
						 RefreshPage();
						 Thread.sleep(5000);
						 Click("Please click at aviator",GetData.aviator);
						 Thread.sleep(2000);
						 Click("Please click at Settings",GetData.settings);
						 Thread.sleep(3000); 
						 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
						 Thread.sleep(2000);
						 if(GetData.TaskDefaultVisibilityPrivate.isEnabled())
						 {
							 Click("Select Private Visibility",GetData.TaskDefaultVisibilityPublic);
						 }
						 Click("Save Private Visibility",GetData.TaskDefaultItemVisibilty_Save);
						 Thread.sleep(2000);
						 Assert.assertTrue(GetData.TaskDefaultVisibilityPublic.isEnabled());
					 }
					
		  			}
				
				public static void ReviewTaskVisibility_MainTaskPage(boolean Private) throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(2000);
					 Click("a",GetData.CRM);
					 Thread.sleep(2000);
					 Click("Please Click Add Task Link main",GetData.AddTaskFromMain);
					 Click("Please Click Add Task button",GetData.AddTaskButton);
					 Thread.sleep(2000);
					 Click("More Details Link",GetData.MoreDetail);
					 Thread.sleep(2000);
					 if(Private)
					 {
						 //Review task visibility
						 TaskForm_Visibility_Private=GetData.DefaultTaskForm_Visibility_Private_Order.getText();
						 System.out.println(TaskForm_Visibility_Private);
						 Thread.sleep(2000);
						 //Verify Default item visibility and Add default visibility are the same
						 Assert.assertTrue("Private".equalsIgnoreCase(TaskForm_Visibility_Private), "Task visibility is not update on form");
					 }
					 else
					 {
						 //Review task visibility
						 TaskForm_Visibility_Public=GetData.DefaultTaskForm_Visibility_Public_Order.getText();
						 System.out.println(TaskForm_Visibility_Public);
						 Thread.sleep(2000);
						 //Verify Default item visibility and Add default visibility are the same
						 Assert.assertTrue("Public".equalsIgnoreCase(TaskForm_Visibility_Public), "Task visibility is not update on form");
					 }
					 }
				
				public static void ReviewTaskVisibility_AppointmentPage(boolean Private) throws InterruptedException, AWTException, IOException{
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 RefreshPage();
					 Thread.sleep(2000);
					 Click("Click to Appointment" ,GetData.Appointment);
					 Thread.sleep(2000);
					 Click("Click on dropdown to select New task", GetData.Appointmentdropdown);
					 Click("Please click at Add Task button", GetData.NewTask);
					 Thread.sleep(2000);
					
					 Click("More Details Link",GetData.MoreDetail);
					 Thread.sleep(2000);
					 if(Private)
					 {
						 //Review task visibility
						 TaskForm_Visibility_Private=GetData.DefaultTaskForm_Visibility_Private_Order.getText();
						 System.out.println(TaskForm_Visibility_Private);
						 Thread.sleep(2000);
						 //Verify Default item visibility and Add default visibility are the same
						 Assert.assertTrue("Private".equalsIgnoreCase(TaskForm_Visibility_Private), "Task visibility is not update on form");
					 }
					 else
					 {
						 //Review task visibility
						 TaskForm_Visibility_Public=GetData.DefaultTaskForm_Visibility_Public_Order.getText();
						 System.out.println(TaskForm_Visibility_Public);
						 Thread.sleep(2000);
						 //Verify Default item visibility and Add default visibility are the same
						 Assert.assertTrue("Public".equalsIgnoreCase(TaskForm_Visibility_Public), "Task visibility is not update on form");
					 }
					
		  			}
				public static void ReviewTaskVisibility_UnderCompany(boolean Private) throws InterruptedException, AWTException, IOException{
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 RefreshPage();
					
					 Thread.sleep(2000);
					 Click("Access Companies",GetData.NavigatetoCompanies);
					 Thread.sleep(2000);
					 Input("Provide Company Name",GetData.CompaniesSearchField,"Auto Supplier ASIQA I");
					 Thread.sleep(3000);
			 		 GetData.CompDetails.click();
			 		 Thread.sleep(2000);
					 Click("Please click at Add Task button",GetData.AddTaskButton);
					 Thread.sleep(2000);
					 Click("More Details Link",GetData.MoreDetail);
					 Thread.sleep(2000);
					 if(Private)
					 {
						 //Review task visibility
						 TaskForm_Visibility_Private=GetData.DefaultTaskForm_Visibility_Private_Order.getText();
						 System.out.println(TaskForm_Visibility_Private);
						 Thread.sleep(2000);
						 //Verify Default item visibility and Add default visibility are the same
						 Assert.assertTrue("Private".equalsIgnoreCase(TaskForm_Visibility_Private), "Task visibility is not update on form");
					 }
					 else
					 {
						 //Review task visibility
						 TaskForm_Visibility_Public=GetData.DefaultTaskForm_Visibility_Public_Order.getText();
						 System.out.println(TaskForm_Visibility_Public);
						 Thread.sleep(2000);
						 //Verify Default item visibility and Add default visibility are the same
						 Assert.assertTrue("Public".equalsIgnoreCase(TaskForm_Visibility_Public), "Task visibility is not update on form");
					 }
					
		  			}
				
				public static void CreateDefaultTask_PerOrderLinkToSupplierORDecorator(boolean supplier) throws InterruptedException, AWTException, IOException
				{
					 Thread.sleep(10000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Thread.sleep(2000);
					 Click("Please click at Sales Tax",GetData.DefaultTasks);
					 Click("Click To Default Task",GetData.DefaultTasks);
					//Add Default Task
					 Click("Please Click Add Task button",GetData.AddDefaultTask);
					 Thread.sleep(2000);
					//Provide task name 
					 if(supplier)
					 {
						 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.SupplierDefaultTask);
						 Click("Please select Sales Order",GetData.DefaultTaskSalesOrderCheckbox);
						 Thread.sleep(2000);
						 Click("Check-in Orders from Per selection",GetData.Per_Supplier);
						// Click("Link To Supplier",GetData.LinkTo_Supplier);
					 }
					 else
					 {
						 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.DecoratorDefaultTask);
						 if(!GetData.DueSameDay.isSelected())
						 {
							 GetData.DueSameDay.click();
						 }
						 Click("Please select Sales Order",GetData.SampleRequestCheckbox);
						 Thread.sleep(2000);
						 Click("Check-in Orders from Per selection",GetData.Per_Decorator);
						 //Click("Link To Supplier",GetData.LinkTo_Decorator);
					 }
					 	Click("Save task",GetData.SaveAddress);
					 	driver.navigate().refresh();
					
					 if(supplier)
					 {
						 JavascriptExecutor js = (JavascriptExecutor) driver;
						 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.SupplierDefaultTask+"')]"));
						 js.executeScript("arguments[0].scrollIntoView();", Element);
						 Thread.sleep(2000);
						 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.SupplierDefaultTask+"')]")).isDisplayed()); 
					 }
					 else
					 {
						 JavascriptExecutor js = (JavascriptExecutor) driver;
						 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DecoratorDefaultTask+"')]"));
						 js.executeScript("arguments[0].scrollIntoView();", Element);
						 Thread.sleep(2000);
						 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DecoratorDefaultTask+"')]")).isDisplayed()); 
					 }
					 
		  			} 
				
				public static void VerifySupplierORDecoratorDefaultTask(boolean Supplier) throws InterruptedException, AWTException, IOException
				{
		  			 Thread.sleep(5000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 
	    		   	 if(Supplier)
	    		   	 {
	    		   		 Click("Please click at Orders Tab",GetData.Orders);
						 Click("Create Order",GetData.CreateOrder);
		    			 //Select the company first on create order screen
						 Click("Search Company",GetData.CreateOrderScreen_CompanySearch_Textfield);
		    		   	 Thread.sleep(2000);
	    		   		 Input("Provide Company Name", GetData.CreateOrderScreen_CompanyField_SendData, "Auto Supplier ASIQA I");
	    		   	 }
	    		   	 else
	    		   	 {
	    		   		Click("Please click at Orders Tab",GetData.Orders);
	    		   		Click("a", CreateOrders.Orders_SampleRequestTab);
	    		  		Thread.sleep(10000);
	    		  		Click("a", CreateOrders.CreateSampleRequest);
	    		  		Click("Search Company",GetData.CreateOrderScreen_CompanySearch_Textfield);
		    		   	Thread.sleep(2000);
	    		   		Input("Provide Company Name", GetData.CreateOrderScreen_CompanyField_SendData, "Auto Decorator ASIQA I");
	    		   	 }
	    		   	 Thread.sleep(6000);
	    		   	 GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    		   	 Thread.sleep(1000);
	    		   	//Select company from company dropdown
	    		   	 GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
					 Thread.sleep(5000);
					 CreateOrder.AddProductConfiguration_Order();
					 Thread.sleep(1000);
					 Click("Please click at Save Button",GetData.SaveOrders.get(1));
					 Thread.sleep(20000);
					 driver.navigate().refresh();
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Thread.sleep(15000);
					 if(Supplier)
					 {
						 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.SupplierDefaultTask));
					 }
					 else
					 {
						 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.DecoratorDefaultTask));
					 }
					
					
					
		  			} 
				public static void CreateDefaultTask_PerProductLineItemLinkToSupplierORDecorator(boolean supplier) throws InterruptedException, AWTException, IOException
				{
					test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					// Click("Please click at aviator",GetData.CloseOrder_Icon);
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at aviator",GetData.settings);
					 Thread.sleep(2000);
					 Click("Please click at Default Task",GetData.DefaultTasks);
					 Thread.sleep(3000);
					//Add Default Task
					 Click("Please Click Add Task button",GetData.AddDefaultTask);
					 Thread.sleep(2000);
					//Provide task name 
					 if(supplier)
					 {
						 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.SupplierDefaultTaskProductLineItem);
						 if(!GetData.DueSameDay.isSelected())
						 {
							 GetData.DueSameDay.click();
						 }
						 Click("Please select Sales Order",GetData.QuoteCheckbox);
						 Thread.sleep(2000);
						 Click("Check-in Orders from Per selection",GetData.ProductLineItem);
						 Click("Link To Supplier",GetData.LinkTo_Supplier);
					 }
					 else
					 {
						 Input("Please Enter Main Task Name", GetData.DefaultTaskName, CrmTestData.DecoratorDefaultTaskProductLineItem);
						 Click("Please select Invoice",GetData.InvoiceCheckbox);
						 Thread.sleep(2000);
						 Click("Check-in Orders from Per selection",GetData.ProductLineItem);
						 Click("Link To Supplier",GetData.LinkTo_Decorator);
					} 
					 Click("Save task",GetData.SaveAddress);
					 driver.navigate().refresh();
					 if(supplier)
					 {
						 JavascriptExecutor js = (JavascriptExecutor) driver;
						 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.SupplierDefaultTaskProductLineItem+"')]"));
						 js.executeScript("arguments[0].scrollIntoView();", Element);
						 Thread.sleep(2000);
						 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.SupplierDefaultTaskProductLineItem+"')]")).isDisplayed());
					 }
					 else
					 {
						 JavascriptExecutor js = (JavascriptExecutor) driver;
						 WebElement Element=driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DecoratorDefaultTaskProductLineItem+"')]"));
						 js.executeScript("arguments[0].scrollIntoView();", Element);
						 Thread.sleep(2000);
						 Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+CrmTestData.DecoratorDefaultTaskProductLineItem+"')]")).isDisplayed());
					 }
					
		  			} 
				
				public static void VerifySupplierORDecoratorDefaultTask_ProductLineItem(boolean supplier) throws InterruptedException, AWTException, IOException
				{
		  			 Thread.sleep(5000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					
	    		   	 if(supplier)
	    		   	 {
	    		   		Click("Please click at Orders Tab",GetData.Orders);
	    		   		Click("a", CreateOrders.Quotetab);
	    		  		Thread.sleep(10000);
	    			   	CreateOrders.Orderdetails_MoreButton_CreateQuote.click();
		    			 //Select the company first on create order screen
						Click("Search Company",GetData.CreateOrderScreen_CompanySearch_Textfield);
		    		   	Thread.sleep(2000);
	    		   		Input("Provide Company Name", GetData.CreateOrderScreen_CompanyField_SendData, "Auto Supplier ASIQA I");
	    		   	 }
	    		   	 else
	    		   	 {	
	    		   		Click("Please click at Orders Tab",GetData.Orders); 
	    		   		Click("a", CreateOrders.Invoicetab);
	    		  		Thread.sleep(10000);
	    			   	CreateOrders.CreateOrder_InvoiceOption.click();
	    			   	Thread.sleep(2000);
		    			 //Select the company first on create order screen
						Click("Search Company",GetData.CreateOrderScreen_CompanySearch_Textfield);
		    		   	Thread.sleep(2000);
	    		   		Input("Provide Company Name", GetData.CreateOrderScreen_CompanyField_SendData, "Auto Decorator ASIQA II");
	    		   	 }
	    		   	 
	    		   	 Thread.sleep(6000);
	    		   	 GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    		   	 Thread.sleep(1000);
	    		   	//Select company from company dropdown
	    		   	 GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
					 Thread.sleep(5000);
					 //Add Product
					 CreateOrder.AddProductConfiguration_Order();
					 Click("Please click at Save Button",GetData.SaveOrders.get(1));
					 Thread.sleep(20000);
					//First store parent window to switch back
					 parentWindow = driver.getWindowHandle();
					 Click("Click on supplier product",GetData.SupplierProduct);
					 Thread.sleep(2000);
					 
					//Switch to new window opened
					  	for(String winHandle : driver.getWindowHandles()){
					  	    if(!winHandle.equals(parentWindow)) {
					  	        driver.switchTo().window(winHandle);
					  	    }
					  	}
					if(supplier)
					{
					
					 
						Thread.sleep(5000);
						Assert.assertTrue( driver.getPageSource().contains(CrmTestData.SupplierDefaultTaskProductLineItem));
						
					  }
					else
					{
						//Thread.sleep(10000);
					  	JavascriptExecutor js = (JavascriptExecutor) driver;
					  	WebElement Element=driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.DecoratorDefaultTaskProductLineItem+"')]"));
						js.executeScript("arguments[0].scrollIntoView();",Element);
						String Taskverify=driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.DecoratorDefaultTaskProductLineItem+"')]")).getText();
						System.out.print(Taskverify+'\n');
						Thread.sleep(5000);
						//Assert.assertTrue( driver.getPageSource().contains(CrmTestData.DecoratorDefaultTaskProductLineItem));
						Verify(CrmTestData.DecoratorDefaultTaskProductLineItem, Taskverify, "Task content is not showing");
						RefreshPage();
						Thread.sleep(3000);
						Verify(CrmTestData.DecoratorDefaultTaskProductLineItem,Taskverify, "Task content is not showing after refresh");
					}
					
					
					
					
					
		  		} 
				public static void VerifySupplierORDecoratorProductLineItemDefaultTask_TaskPane(boolean supplier) throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(2000);
					 driver.close();
				     Thread.sleep(5000);
				     driver.switchTo().window(parentWindow);
		  			 Thread.sleep(5000);
					 driver.navigate().refresh();
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Thread.sleep(15000);
					 if(supplier)
					 {
						 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.SupplierDefaultTaskProductLineItem));
					 }
					 else
					 {
						 Assert.assertTrue( driver.getPageSource().contains(CrmTestData.DecoratorDefaultTaskProductLineItem));
					 }
					
					 
				}
				
				public static void VerifySupplierORDecoratorProductLineItemDefaultTask_TaskPane_AfterDeleteProductLineItem(boolean supplier) throws InterruptedException, AWTException, IOException
				{
		  			 Thread.sleep(5000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Thread.sleep(5000);
					 Click("Delete Product",GetData.DeleteProduct);
					 Thread.sleep(2000);
					 Click("Delete Confirmation ",GetData.ConfirmDel);
					 Thread.sleep(2000);
					 driver.navigate().refresh();
					 Click("Please click at Settings",GetData.OpenTaskInSidebar);
					 Thread.sleep(15000);
					 if(supplier)
					 {
						 Assert.assertTrue( !driver.getPageSource().contains(CrmTestData.SupplierDefaultTaskProductLineItem));
					 }
					 else
					 {
						 Assert.assertTrue( !driver.getPageSource().contains(CrmTestData.DecoratorDefaultTaskProductLineItem));
					 }
					
					 
				}
				public static void AppointmentDefaultVisibility(boolean CreatorOnly) throws InterruptedException, AWTException, IOException
				{
		  			 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					
					 if(CreatorOnly)
					 {
						 Click("Please click at aviator",GetData.aviator);
						 Click("Please click at aviator",GetData.settings);
						 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
						 Thread.sleep(2000);
						 if(GetData.AppointmentEveryone.isEnabled())
					 {
						 Click("Select CreatorOnly option",GetData.AppointmentCreatorOnly);
						 String CreatorOnly1=GetData.AppointmentCreatorOnly.getText();
						 System.out.println(CreatorOnly1);
					 }
					 }
					 else
					 {
						 RefreshPage();
						 Thread.sleep(2000);
						 Click("Please click at aviator",GetData.aviator);
						 Click("Please click at aviator",GetData.settings);
						 Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
						 if(GetData.AppointmentCreatorOnly.isEnabled())
						 {
							 Click("Select CreatorOnly option",GetData.AppointmentEveryone);
							 String Everyone=GetData.AppointmentEveryone.getText();
							 System.out.println(Everyone);
						 }
					 }
					 Click("Access CRM",GetData.CRM);
					 Click("Access Appointment",GetData.Appointment);
					 Thread.sleep(2000);
					 Click("Access Appointment",GetData.AddAppointment);
					 Thread.sleep(2000);
					 Click("More Details Link",GetData.MoreDetail);
					 Thread.sleep(2000);
					 if(CreatorOnly)
					 {
						 Assert.assertTrue(GetData.AppointmentOwnerAccesslevel.isEnabled());
					 }
					 else
					 {
						 Assert.assertTrue(GetData.AppointmentEveryoneAccesslevel.isEnabled());
					 }
				}
				
}
