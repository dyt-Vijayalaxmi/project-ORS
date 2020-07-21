package com.dyt.ors.Screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.dyt.Reports.Reporter;
import com.dyt.generic.WebLibrary;

public class AddMainCategory extends WebLibrary {
	//=========WebElements for Add Main Category page==================
	
				@FindBy(xpath="//span[text()='Products']")
				public static WebElement navlink_Products;	
				
				@FindBy(xpath="//a[text()='Main Categories']")
				public static WebElement link_MainCategories;
				
				@FindBy(xpath="//a[text()=' Add Main Categories']")
				public static WebElement btn_AddMainCategories;
				
				@FindBy(xpath="//input[@id='ors_mc_category_name']")
				public static WebElement edit_Name;	
				
				@FindBy(xpath="//select[@id='ors_order']")
				public static WebElement edit_AssOrder;
				
				@FindBy(xpath="//input[@id='catgImage']")
				public static WebElement edit_ChooseFile;	
				
				@FindBy(xpath="//input[@type='submit']")
				public static WebElement btn_Submit;	
				
				@FindBy(xpath="//span[text()=' Error: Main Category Name was already exist']")
				public static WebElement text_existMC;
				
				@FindBy(xpath="//span[text()='Main Category Name is Mandatory']")
				public static WebElement text_MCMandatory;
				
			
		//=================Methods for Add Main Category =========================
			public static void navAddmainCategory()
			{
				boolean bstatus;
				
				bstatus = clickElement(navlink_Products);
				Reporter.log(bstatus, "Main Category Navigation Clicked","Main Category Navigation Not Clicked");
				
				bstatus = clickElement(link_MainCategories);
				Reporter.log(bstatus, "Main Category Link Clicked","Main Category Link Not Clicked");
				
				bstatus = clickElement(btn_AddMainCategories);
				Reporter.log(bstatus, "Add Main Category Button Clicked","Add Main Category Button not Clicked");
				
			}
			
		//=========================================================================
			
			public static void addMainCategory(String MainCategoryName,String SelectOrder,String filepath)
			{
				boolean bstatus;
		
				bstatus = setEditValue(edit_Name, MainCategoryName);
				Reporter.log(bstatus, "Main Category Name Entered","Main Category Name Not Entered");
				
				bstatus = selectListItem(edit_AssOrder,SelectOrder);
				Reporter.log(bstatus, "Main Category Assigned Order Selected","Main Category Assigned Order Selected");
				
				bstatus = clickElement(btn_Submit);
				Reporter.log(bstatus, "Submit Button Clicked","Submit Button Not Clicked");
				
			}
       //==================================to verify Main Category exist ==========================
			public static void toVerifyMCAllreadyExist()
			{
				boolean bstatus;
				bstatus = verifyText(text_existMC);
				Reporter.log(bstatus, "Main Category name is already exist","Main Category name is not exist");
				
			}
	  //=================verify added MC present in the Main Category List page===================
			public static boolean verifyAddedMC(String expValue) {
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
			
			public static void addMCWithoutManditoryfields(String MainCategoryName,String SelectOrder)
			{
				boolean bstatus;
		
				bstatus = setEditValue(edit_Name, MainCategoryName);
				Reporter.log(bstatus, "Main Category Name Entered","Main Category Name Not Entered");
				
				/*bstatus = selectListItem(edit_AssOrder,SelectOrder);
				Reporter.log(bstatus, "Main Category Assigned Order Selected","Main Category Assigned Order Selected");*/
				
				/*bstatus = uploadFile(edit_ChooseFile,filepath);
				Reporter.log(bstatus, "Main Category Image Slected","Main Category Image Not Slected");*/
				
				bstatus = clickElement(btn_Submit);
				Reporter.log(bstatus, "Submit Button Clicked","Submit Button Not Clicked");
				
				bstatus = verifyText(text_MCMandatory);
				Reporter.log(bstatus, "Main Category name is Manditory, alert message is displayed","Main Category name is Manditory, alert message is not displayed");
				
			}
}
