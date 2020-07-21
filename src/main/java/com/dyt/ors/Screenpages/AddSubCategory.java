package com.dyt.ors.Screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dyt.Reports.Reporter;
import com.dyt.generic.WebLibrary;

public class AddSubCategory extends WebLibrary{
	//===============WebElements for AddSubCategory============
		@FindBy(xpath="//span[text()='Products']")
		public static WebElement navlink_Products;	
		
		@FindBy(xpath="//a[text()='Sub Categories']")
		public static WebElement link_SubCategories;
		
		@FindBy(xpath="//a[@class='d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm']")
		public static WebElement btn_AddSubCategories;
		
		@FindBy(xpath="//select[@id ='mainCatgDropdown']")
		public static WebElement select_mainCategory;
		
		@FindBy(xpath="//input[@id ='subCatgName']")
		public static WebElement Enter_SubCategory;
		
		@FindBy(xpath="//select[@id ='ors_sub_order']")
		public static WebElement select_AssignedOrder;
		
		@FindBy(xpath="//input[@id='LitImage']")
		public static WebElement select_LiteratureImage;
		
		@FindBy(xpath="//input[@id='LitPDF']")
		public static WebElement select_LiteratureDocument;
		
		@FindBy(xpath="//input[@class='btn btn-success']")
		public static WebElement Submit_Button;
		
		@FindBy(xpath="//span[text()=' Error: Sub Category Name was already exist']")
		public static WebElement text_existSC;
		
		//====================Methods For AddSubCategory Page ================
		public static void navAddSubCategory()
		{
			boolean bstatus;
			
			bstatus = clickElement(navlink_Products);
			Reporter.log(bstatus, "Products Navigation Clicked","Products Navigation Not Clicked");
			
			bstatus = clickElement(link_SubCategories);
			Reporter.log(bstatus, "Sub Category Link Clicked","Sub Category Link Not Clicked");
			
			bstatus = clickElement(btn_AddSubCategories);
			Reporter.log(bstatus, "Add Sub Category Button Clicked","Add Sub Category Button not Clicked");
			
		}
		
	//=========================================================================
		
		
		public static void addSubCategory(String nameMainCategogy,String nameSubCategogy,String AssignedOrder )
		{
			boolean bstatus;
			
			 bstatus = selectListItem(select_mainCategory, nameMainCategogy );
			 Reporter.log(bstatus,"Main category is selected from dropdown","Main Category is not selected");
			 
			 bstatus = setEditValue(Enter_SubCategory, nameSubCategogy );
			 Reporter.log(bstatus,"Sub Category Value is Entered","Sub Category Value not entered");	
				
			 bstatus = selectListItem(select_AssignedOrder,AssignedOrder);
			 Reporter.log(bstatus,"Assigned Order is selected from dropdown","Assigned Order is not selected");
			
			 bstatus = clickElement(Submit_Button);
			 Reporter.log(bstatus,"Submit Button is clicked","Submit Button not clicked");
			 
		}
		 //==================================to verify Main Category exist ==========================
		public static void toVerifySCAllreadyExist()
		{
			boolean bstatus;
			bstatus = verifyText(text_existSC);
			Reporter.log(bstatus, "Sub Category name is already exist","Sub Category name is not exist");
			
		}
  //=================verify added SC present in the Sub Category List page===================
		public static boolean verifyAddedSC(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int tabrowscount=rows.size();
			
			
			for(int i=1; i<=tabrowscount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
			
			if ((actValue.equals(expValue)))  {
				System.out.println("Sub Category is added in SC list page");
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
		
		public static void addSCWithoutManditoryfields(String nameMainCategogy,String nameSubCategogy,String AssignedOrder )
		{
			boolean bstatus;
	
			bstatus = selectListItem(select_mainCategory, nameMainCategogy );
			 Reporter.log(bstatus,"Main category is selected from dropdown","Main Category is not selected");
			 
			 bstatus = setEditValue(Enter_SubCategory, nameSubCategogy );
			 Reporter.log(bstatus,"Sub Category Value is Entered","Sub Category Value not entered");	
				
			 bstatus = selectListItem(select_AssignedOrder,AssignedOrder);
			 Reporter.log(bstatus,"Assigned Order is selected from dropdown","Assigned Order is not selected");
			
			 bstatus = clickElement(Submit_Button);
			 Reporter.log(bstatus,"Submit Button is clicked","Submit Button not clicked");
			 
		}
	}

