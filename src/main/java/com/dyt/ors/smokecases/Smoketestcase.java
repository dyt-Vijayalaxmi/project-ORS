package com.dyt.ors.smokecases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dyt.generic.BaseClass;
import com.dyt.ors.Screenpages.AddMainCategory;
import com.dyt.ors.Screenpages.AddProducts;
import com.dyt.ors.Screenpages.AddSubCategory;
import com.dyt.ors.Screenpages.DashBoard;
import com.dyt.ors.Screenpages.EditMainCategory;
import com.dyt.ors.Screenpages.EditProducts;
import com.dyt.ors.Screenpages.EditSubCategory;
import com.dyt.ors.Screenpages.Home;
import com.dyt.ors.Screenpages.Login;
import com.dyt.utilities.ExcelLib;

public class Smoketestcase extends BaseClass {


	//============== Add Main Category====================== 	
	@Test
	public static void TC001_addMainCategory()
	{		
		String[] data = ExcelLib.getRowData("TC001_addMainCategory", "Smoke");	
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
		
		home.navLoginpage();
		login.loginApp(data[0],data[1]);
	//	addMainCategory.navAddmainCategory();
		//addMainCategory.addMainCategory(data[2], data[3],data[4]);
				
	}

	/*
	//============== Add Sub Category====================== 	
	@Test
	public static void TC002_addSubCategory()
	{		
		String[] data = ExcelLib.getRowData("TC002_addSubCategory", "Smoke");	
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		AddSubCategory addSubCategory= PageFactory.initElements(driver, AddSubCategory.class);
		
		home.navLoginpage();;
		login.loginApp(data[0],data[1]);
		addSubCategory.navAddSubCategory();
		addSubCategory.addSubCategory(data[2], data[3],data[4]);
				
	}
	
	//============== Add Products=========================== 	
	@Test
	public static void TC003_addProducts()
	{		
		String[] data = ExcelLib.getRowData("TC003_addProducts", "Smoke");
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		AddProducts addproduts= PageFactory.initElements(driver, AddProducts.class);
		
		home.navLoginpage();;
		login.loginApp(data[0],data[1]);
		addproduts.navAddProducts();
		addproduts.addProducts("mono", "inse", "456", "chemical", "A++", "chemical", "678", "reddyslab", "30", "10", "Code150", "6000", "E","C:\\Users\\Chaitanya\\Desktop\\Project details\\Sample images\\images9.jpg","E:\\pdf\\sel_Manul_Pdf.pdf","E:\\pdf\\Manual.pdf");
				
	}
	
	//============== Edit Main Category====================== 	
	@Test
	public static void TC004_editMainCategory()
	{		
		String[] data = ExcelLib.getRowData("TC004_editMainCategory", "Smoke");
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
		EditMainCategory editMainCategory= PageFactory.initElements(driver, EditMainCategory.class);
		
		home.navLoginpage();;
		login.loginApp(data[0],data[1]);
		dashBoard.navMainCategories();
		editMainCategory.selectEditicon("ethane");
		editMainCategory.editMainCategoryPage("dimethy", "E","C:\\Users\\Chaitanya\\Desktop\\Project details\\Sample images\\bencodryl-sf-500x500.jpg");
		
		
	}
	
	//============== Edit Sub Category====================== 	
	@Test
	public static void TC005_editSubCategory()
	{		
		String[] data = ExcelLib.getRowData("TC005_editSubCategory", "Smoke");
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
		EditSubCategory editSubCategory= PageFactory.initElements(driver, EditSubCategory.class);
		
		home.navLoginpage();
		login.loginApp(data[0],data[1]);
		dashBoard.navSubCategories();
		editSubCategory.selectEditicon("sample");
		editSubCategory.editSubcategoryPage("testsample", "E");
		
		}
	
	//============== Edit Products ====================== 	
	@Test
	public static void TC006_editProducts()
	{		
		String[] data = ExcelLib.getRowData("TC006_editProducts", "Smoke");
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
		EditProducts editProduct= PageFactory.initElements(driver, EditProducts.class);
		
		home.navLoginpage();;
		login.loginApp(data[0],data[1]);
		dashBoard.navProducts();
		editProduct.selectEditicon("123");
		editProduct.editProduct( "chlorine", "B++", "reddys", "2litres","50units","50000","E:\\pdf\\sel_Manul_Pdf.pdf");
		}
	
	//============== Search Products ====================== 	
	@Test
	public static void TC007_searchProducts()
	{		
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.searchproduct();
		home.navAboutOrbit();
		home.navCOA();
		home.navLiteratures();
		home.navProduct();
		home.navContactus();
	}
*/
}