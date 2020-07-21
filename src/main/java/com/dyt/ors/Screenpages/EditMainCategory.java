package com.dyt.ors.Screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dyt.Reports.Reporter;
import com.dyt.generic.WebLibrary;

public class EditMainCategory extends WebLibrary{
	
		@FindBy(xpath="//table[@id='dataTable']/tbody/tr[2]/td[3]")
		public static WebElement select_MainCategory;
	
		@FindBy(xpath="//table[@id='dataTable']/tbody/tr[2]/td[5]/a[1]/i")
		public static WebElement click_editicon;
		
		@FindBy(xpath="//input[@name='ors_mc_category_name']")
		public static WebElement edit_Maincategory;	
		
		@FindBy(xpath="//select[@name='ors_order']")
		public static WebElement edit_Assignedorder;
		
		@FindBy(xpath="//input[@name='catgImage']")
		public static WebElement edit_Image;		
		
		@FindBy(xpath="//input[@class='btn btn-success']")
		public static WebElement Submit_button;	

		
		
		//================= To select edit icon=========================
		public static boolean selectEditicon(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int tabrowscount=rows.size();
						
			for(int i=1; i<=tabrowscount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
			
			if ((actValue.equals(expValue)))  {
				driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[5]/a[1]/i")).click();
				break;
				}
			}
			}
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		}
		
		public static void editMainCategoryPage(String MCName , String OrderValue,String filepath) {
			boolean bStatus;
			
			
			bStatus = setValueEscape(edit_Maincategory, MCName);
			Reporter.log(bStatus, "MainCategory entered", "MainCategory not entered");
			
			bStatus = clickElement(edit_Assignedorder);
			Reporter.log(bStatus, " clicked", " not clicked");
					
			bStatus = selectListItem(edit_Assignedorder, OrderValue);
			Reporter.log(bStatus, "Order Value Selected", "Order Value not Selected");
			
			bStatus = uploadFile(edit_Image, filepath);
			Reporter.log(bStatus, "Image Uploaded", "Image not Uploaded");
			
		    bStatus = clickElement(Submit_button);
			Reporter.log(bStatus, "Submit button clicked", "Submit button not clicked");
			
			bStatus = verifyText(Submit_button);
			Reporter.log(bStatus, "Submit button clicked", "Submit button not clicked");
			
			
		}
		
		public static boolean verifyeditedMC(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int tabrowscount=rows.size();
			
			
			for(int i=1; i<=tabrowscount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
			
			if ((actValue.equals(expValue)))  {
				System.out.println("Main Category is added in MC list page");
				break;
				}
			
			}
			}
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		}

		//=========================================================================


	}



