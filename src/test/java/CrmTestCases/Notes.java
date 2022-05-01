
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class Notes extends HelpingFunction {
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);

				public static void AddNote() throws InterruptedException, AWTException, IOException{
						 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Click("Please click at Note button",GetData.Notes);
						 String notes=GetData.ResultFound.getText();
						 Click("Please click at Note button",GetData.AddCompNoteButton);
						 Input("Please Enter content", GetData.NoteContent, CrmTestData.NoteCont);
						 ClickAt("Please click at Save note button ",GetData.SaveNote);
						 Thread.sleep(5000);
						 driver.navigate().refresh();
						 Thread.sleep(15000);
						 if(!notes.equals(GetData.ResultFound.getText())) {
							 Verify(CrmTestData.NoteCont, GetData.GetNoteCont.getText(), "Note  is not created");

						 }
						 else {
							 Assert.assertTrue(false);
						 }
						 RefreshPage();
						 Verify(CrmTestData.NoteCont, GetData.GetNoteCont.getText(), "Note content is not showing after refresh");

						} 
				
				public static void AddCompanyNote963218(boolean b) throws InterruptedException, AWTException, IOException{
					
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 if(b) {
					 Click("Please click at Note button",GetData.CompDetails);
					 }
					 Click("Please click at Note button",GetData.Notes);
					 String notes=GetData.ResultFound.getText();
					 Click("Please click at Note button",GetData.AddCompNoteButton);
					 Input("Please Enter content", GetData.NoteContent, CrmTestData.NoteCont);
					 ClickAt("Please click at Save note button ",GetData.SaveNote);
					 Thread.sleep(5000);
					 driver.navigate().refresh();
					 Thread.sleep(15000);
					 if(!notes.equals(GetData.ResultFound.getText())) {
						 Verify(CrmTestData.NoteCont, GetData.GetNoteCont.getText(), "Note  is not created");

					 }
					 else {
						 Assert.assertTrue(false);
					 }
					 RefreshPage();
					 Verify(CrmTestData.NoteCont, GetData.GetNoteCont.getText(), "Note content is not showing after refresh");

					} 
				public static void EditNote() throws InterruptedException, AWTException, IOException{
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Edit button",GetData.EditCompNoteButton);
					 Input("Please Enter content", GetData.NoteContent, CrmTestData.EditNoteCont);
					 ClickAt("Please click at Save note button ",GetData.SaveNote);
					 Thread.sleep(5000);
					 driver.navigate().refresh();
					 Thread.sleep(15000);
					 Verify(CrmTestData.EditNoteCont, GetData.GetNoteCont.getText(), "Edit Note content is not matching");
					 
					} 
				
				public static void DelNote() throws InterruptedException, AWTException, IOException{
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());

					 Click("Please click at Remove button",GetData.RemoveCompNoteButton);
					 Click("Please click Ok to Remove task", GetData.OK);
					 
					 RefreshPage();
					 Thread.sleep(5000);
					 Verify("No Notes Found", GetData.ResultFound.getText(), "Note is not deleted");
					 

					 
					}
						
					
			  	public static void AddNoteFromMain() throws InterruptedException, AWTException, IOException{
		  			 
		  			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		  			 Click("Please Click at Main note link",GetData.MainNotes);
		  			 Click("Please Click Add note button",GetData.AddNoteButtonFromMain);
		  			 Input("Please Enter note content in content field", GetData.NoteContent, CrmTestData.MainNoteContent);
		  			 Thread.sleep(3000);
		  			 GetData.SaveNote.click();
		  			 Thread.sleep(5000);
		  			 Verify(CrmTestData.MainNoteContent, GetData.GetMainNoteContent.getText(), "Main Note content is not matching");
		  			 
		  			} 
			
			  		
}
