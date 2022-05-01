package CrmTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class robot{

    public static void main(String[] args) throws AWTException
    {
        Robot r = new Robot();
        String s = "FaFce\\:aa...";
        
        for (int i = 0; i < s.length(); i++) 
        {
            char res = s.charAt(i);
            final boolean upperCase = Character.isUpperCase(res);
            final int keyCode = KeyEvent.getExtendedKeyCodeForChar(res);
            System.out.println(keyCode);

            if (upperCase || keyCode>500) {
                r.keyPress(KeyEvent.VK_SHIFT);
                	if(keyCode==513) {
                		r.keyPress(KeyEvent.VK_SEMICOLON);	
                		r.keyRelease(KeyEvent.VK_SEMICOLON);
                	}

            }
            
            if(keyCode<500) {
            r.keyPress(keyCode);
            r.keyRelease(keyCode);
            }

            if (upperCase || keyCode>500) {
            r.keyRelease(KeyEvent.VK_SHIFT);
            }
        }  
        r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    	
    }
}