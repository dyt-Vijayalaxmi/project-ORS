package com.dyt.ors.Screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.Reports.Reporter;
import com.dyt.generic.WebLibrary;

public class EditSubCategory extends WebLibrary{
	//=================WebElements for EditSubCategorypage====================================
		@FindBy(xpath="//select[@id='mainCatgDropdown']")
		public static WebElement edit_maincategory;
	
		@FindBy(xpath="//input[@id=orsMainCategories ors_mc_id']")
		public static WebElement click_editicon;
		
		@FindBy(xpath="//input[@id='subCatgName']")
		public static WebElement edit_Subcategory;
		//input[@id='subCatgName']
		@FindBy(xpath="//select[@id='ors_sub_order']")
		public static WebElement edit_Assignorder;
		
		@FindBy(xpath="//input[@name=Litimage']")
		public static WebElement edit_image;
		
		@FindBy(xpath="//input[@class='btn btn-success']")
		public static WebElement submit_button;
		
		//=============WebElements forEdit SubcategoryPage=========================================
		public static boolean selectEditicon(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int trcount=rows.size();
			
			
			for(int i=1; i<=trcount; i++) {
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
		//============================edit Sub Category page===========================================
		
		public static void editSubcategoryPage(String MainCategoryname,String SubCategoryname, String ordervalue) 
		{
			boolean bStatus;
			
			bStatus = selectListItem(edit_maincategory,MainCategoryname);
			Reporter.log(bStatus, "MainCategoryname is changed", "MainCategoryname is not changed");
			
			bStatus = setValueEscape(edit_Subcategory,SubCategoryname);
			Reporter.log(bStatus, "SubCategoryname is changed", "SubCategoryname is not changed");
			
			bStatus = clickElement(edit_Assignorder);
			Reporter.log(bStatus, " clicked", " not clicked");
		
			bStatus=selectListItem(edit_Assignorder,ordervalue);
			Reporter.log(bStatus, "Order value selected", "order value not selected");
			
			bStatus=mouseHover(submit_button);
			Reporter.log(bStatus, "mousehover to submit button", "notmousehover to submit button");
			
			bStatus=clickElement(submit_button);
			Reporter.log(bStatus, "Submit button clicked", "Submit button not clicked");
			
		}
	//===================verify edited details in the SC list page================================

		
		public static boolean verifyediteddetails(String expValue) {
			boolean bStatus = false;
			try {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
			int trcount=rows.size();
			
			
			for(int i=1; i<=trcount; i++) {
			String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
			
			if ((actValue.equals(expValue)))  {
				System.out.println("edited details are added in SC list page");
				break;
			}
			
				
				}
			}
			
			catch(Exception e) {
				bStatus = false;
			}
			return bStatus;
			
			
		}
}
