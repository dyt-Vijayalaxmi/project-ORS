package com.dyt.ors.Screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.dyt.Reports.Reporter;
import com.dyt.generic.WebLibrary;

public class DashBoard extends WebLibrary{
	
	    //=========WebElements for Dashboard page================
		@FindBy(xpath="//span[text()='Dashboard']")
		public static WebElement navlink_Dashboard;
		
		@FindBy(xpath="//span[text()='Products']")
		public static WebElement navlink_Products;	
		
		@FindBy(xpath="//a[text()='Main Categories']")
		public static WebElement link_MainCategories;
		
		@FindBy(xpath="//a[text()='Sub Categories']")
		public static WebElement link_SubCategories;
		
		@FindBy(xpath="//a[text()='Products']")
		public static WebElement link_Products;
				
		//================ navigate to MainCategories Link ============================
		public static void navMainCategories() {
			boolean bStatus;
			
			bStatus = clickElement(navlink_Products);
			Reporter.log(bStatus, "Products nav link clicked", "Products nav link not clicked");
			
			bStatus = clickElement(link_MainCategories);
			Reporter.log(bStatus, "Main Categories link clicked", "Main Categories link not clicked");		
		}
		//======================navigate to SubCategories Link =================================
		public static void navSubCategories() {
			boolean bStatus;
			
			bStatus = clickElement(navlink_Products);
			Reporter.log(bStatus, "Products nav link clicked", "Products nav link not clicked");
			
			bStatus = clickElement(link_SubCategories);
			Reporter.log(bStatus, "Sub Categories link clicked", "Sub Categories link not clicked");		
		}
		//===================navigate to Products Link  ====================================
		public static void navProducts() {
			boolean bStatus;
			
			bStatus = clickElement(navlink_Products);
			Reporter.log(bStatus, "Products nav link clicked", "Products nav link not clicked");
			
			bStatus = clickElement(link_Products);
			Reporter.log(bStatus, "Products link clicked", "Products link not clicked");		
		}
		//======================verify default Dashboard page is opened===================================
		public static void verifyDashboard() {
			boolean bStatus;
			
			bStatus=verifyText(navlink_Dashboard);
			Reporter.log(bStatus, "Default Dashboard page is open sucessfully", "Default Dashboard page is not opened");
		}
}
