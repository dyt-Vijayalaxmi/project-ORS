package com.dyt.ors.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.dyt.generic.BaseClass;
import com.dyt.ors.Screenpages.AddMainCategory;
import com.dyt.ors.Screenpages.AddProducts;
import com.dyt.ors.Screenpages.AddSubCategory;
import com.dyt.ors.Screenpages.DashBoard;
import com.dyt.ors.Screenpages.DeleteMC;
import com.dyt.ors.Screenpages.DeleteProduct;
import com.dyt.ors.Screenpages.DeleteSC;
import com.dyt.ors.Screenpages.EditMainCategory;
import com.dyt.ors.Screenpages.EditProducts;
import com.dyt.ors.Screenpages.EditSubCategory;
import com.dyt.ors.Screenpages.Home;
import com.dyt.ors.Screenpages.Login;
import com.dyt.ors.Screenpages.SearchFunctionality;
import com.dyt.utilities.ExcelLib;



public class Regressiontestcases extends BaseClass {
	//=============================Admin login with valid credentials==========================
		@Test
		public static void TC001_adminLoginValiddata()
		{		
			String[] data = ExcelLib.getRowData("TC001_adminLoginValiddata", "Regression");	
			Home home = PageFactory.initElements(driver, Home.class);
			Login login = PageFactory.initElements(driver, Login.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
	
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.verifyDashboard();
							
		}
	//===========================Admin login with valid credentials==============================
		@Test
		public static void TC002_adminLoginInvaliddata()
		{		
			String[] data = ExcelLib.getRowData("TC002_adminLoginInvaliddata", "Regression");	
			Home home = PageFactory.initElements(driver, Home.class);
			Login login = PageFactory.initElements(driver, Login.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
	
			
			home.navLoginpage();
			login.loginAppInValidData("Admin","admin12");
			
		}
	//===========================Add Main Category=====================
		@Test
		public static void TC003_addMainCategory()
		{		
			String[] data = ExcelLib.getRowData("TC003_addMainCategory", "Regression");	
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.verifyDashboard();
		    addMainCategory.navAddmainCategory();
			addMainCategory.addMainCategory(data[2], data[3],data[4]);
			addMainCategory.verifyAddedMC(data[5]);
		}
	//=====================Verify that Main Category is exist or not===================
		@Test
		public static void TC004_addMainCategoryDuplicateRecord()
		{		
			String[] data = ExcelLib.getRowData("TC004_addMainCategoryDuplicateRecord", "Regression");	
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.verifyDashboard();
		    addMainCategory.navAddmainCategory();
			addMainCategory.addMainCategory(data[2], data[3],data[4]);
			addMainCategory.toVerifyMCAllreadyExist();
		}
	//=========================verify that Add Main Category Without Mandatory field===============================
		@Test
		public static void TC005_addMCWithoutMandatoryfield()
		{		
			String[] data = ExcelLib.getRowData("TC005_addMCWithoutMandatoryfield", "Regression");	
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.verifyDashboard();
		    addMainCategory.navAddmainCategory();
			addMainCategory.addMCWithoutManditoryfields(data[2], data[3]);
		}
	//============== Edit Main Category====================== 	
		@Test
		public static void TC006_editMainCategory()
		{		
			String[] data = ExcelLib.getRowData("TC006_editMainCategory", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddMainCategory addMainCategory= PageFactory.initElements(driver, AddMainCategory.class);
            EditMainCategory editMainCategory= PageFactory.initElements(driver, EditMainCategory.class);
				
			home.navLoginpage();;
			login.loginApp(data[0],data[1]);
			dashBoard.navMainCategories();
			editMainCategory.selectEditicon(data[2]);
			editMainCategory.editMainCategoryPage(data[3],data[4],data[5]);
			editMainCategory.verifyeditedMC(data[6]);
				
		}
	//============== Delete Main Category====================== 
		@Test
		public static void TC007_deleteMainCategory() throws InterruptedException
		{		
			String[] data = ExcelLib.getRowData("TC007_deleteMainCategory", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
		    DeleteMC deleteMC = PageFactory.initElements(driver, DeleteMC.class);
				
			home.navLoginpage();;
			login.loginApp(data[0],data[1]);
			dashBoard.navMainCategories();
			Thread.sleep(3000);
			deleteMC.selectDeleteicon(data[2]);
			Thread.sleep(3000);
			deleteMC.acceptAlert();
			deleteMC.verifyDeletedMC(data[3]);
				
		}
	//============== Add Sub Category====================== 	
		@Test
		public static void TC008_addSubCategory()
		{		
			String[] data = ExcelLib.getRowData("TC008_addSubCategory", "Regression");	
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddSubCategory addSubCategory= PageFactory.initElements(driver, AddSubCategory.class);
			
			home.navLoginpage();;
			login.loginApp(data[0],data[1]);
			addSubCategory.navAddSubCategory();
			addSubCategory.addSubCategory(data[2], data[3],data[4]);
			addSubCategory.verifyAddedSC(data[5]);	
		}
	//=========================verify that Add Sub Category Without Mandatory field===============================
		@Test
		public static void TC009_addSCWithoutMandatoryfield()
		{		
			String[] data = ExcelLib.getRowData("TC009_addSCWithoutMandatoryfield", "Regression");	
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddSubCategory addSubCategory= PageFactory.initElements(driver, AddSubCategory.class);
					
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.verifyDashboard();
			addSubCategory.navAddSubCategory();
			addSubCategory.addSCWithoutManditoryfields(data[2], data[3],data[4]);
			
		}	
		
	//=====================Verify that Sub Category is exist or not===================
		 @Test
		 public static void TC010_addSubCategoryDuplicateRecord()
		 {		
			String[] data = ExcelLib.getRowData("TC010_addSubCategoryDuplicateRecord", "Regression");	
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddSubCategory addSubCategory= PageFactory.initElements(driver, AddSubCategory.class);
					
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.verifyDashboard();
			addSubCategory.navAddSubCategory();
			addSubCategory.addSubCategory(data[2], data[3],data[4]);
			addSubCategory.toVerifySCAllreadyExist();
				}
	//============== Edit Sub Category====================== 	
		@Test
		public static void TC011_editSubCategory()
		{		
			String[] data = ExcelLib.getRowData("TC011_editSubCategory", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			EditSubCategory editSubCategory= PageFactory.initElements(driver, EditSubCategory.class);
			
			home.navLoginpage();;
			login.loginApp(data[0],data[1]);
			dashBoard.navSubCategories();
			editSubCategory.selectEditicon(data[2]);
			editSubCategory.editSubcategoryPage(data[3],data[4],data[5]);
			editSubCategory.verifyediteddetails(data[6]);
					
		}
	//============== Delete Sub Category====================== 
		@Test
		public static void TC0012_deleteSubCategory() throws InterruptedException
		{		
			String[] data = ExcelLib.getRowData("TC0012_deleteSubCategory", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			DeleteSC deleteSC = PageFactory.initElements(driver, DeleteSC.class);
						
			home.navLoginpage();;
			login.loginApp(data[0],data[1]);
			dashBoard.navSubCategories();
			Thread.sleep(3000);
			deleteSC.selectDeleteicon(data[2]);
			Thread.sleep(3000);
			deleteSC.acceptAlert();
			deleteSC.verifyDeletedSC(data[3]);
						
		}
	//============================Add Products================================	
		@Test
		public static void TC013_addProducts()
		{		
			String[] data = ExcelLib.getRowData("TC013_addProducts", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			addproduct.navAddProducts();
			addproduct.addProducts(data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11],data[12],data[13],data[14],data[15],data[16],data[17]);			
		}
	//============================Add Products with out Maindatory fields=====================	
		
	     @Test
		public static void TC014_addProductswithoutMaindatoryFields()
		{		
	    	String[] data = ExcelLib.getRowData("TC014_addProductswithoutMaindatoryFields", "Regression");
	    	Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
		
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			addproduct.navAddProducts();
			addproduct.addProductswithoutMaindarory(data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11]);
				
		}
	 //============================Add Products with out SubCategory=====================	
		public static void TC015_addProductWithoutSubCategory()
		{		
			String[] data = ExcelLib.getRowData("TC015_addProductWithoutSubCategory", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);

			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			addproduct.navAddProducts();
			addproduct.addProductwithoutSubCategory(data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11],data[12],data[13],data[14],data[15],data[16]);	
		}
    //============================Add Products with Duplicate product=====================		
		public static void TC016_addProductwithDuplicateProduct()
		{		
			String[] data = ExcelLib.getRowData("TC016_addProductwithDuplicateProduct", "Regression");
			Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			addproduct.navAddProducts();
			addproduct.addProducts(data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11],data[12],data[13],data[14],data[15],data[16],data[17]);			
		} 
    //=========================Edit product========================
	@Test
		public static void TC017_EditProducts()
		{		
		    String[] data = ExcelLib.getRowData("TC017_EditProducts", "Regression");
		    Login login = PageFactory.initElements(driver, Login.class);
			Home home = PageFactory.initElements(driver, Home.class);
			DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
			AddProducts addproduct= PageFactory.initElements(driver, AddProducts.class);
			EditProducts editProduct= PageFactory.initElements(driver, EditProducts.class);
			
			home.navLoginpage();
			login.loginApp(data[0],data[1]);
			dashBoard.navProducts();
			editProduct.selectEditicon(data[2]);
			editProduct.editProduct(data[3],data[4],data[5],data[6],data[7],data[8],data[9]);
			editProduct.verifyediteddetails(data[6]);
			
			
		}
	//=====================Delete the product==========================================
	
	@Test
	public static void TC0019_deleteProduct() throws InterruptedException
	{		
		String[] data = ExcelLib.getRowData("TC0019_deleteProduct", "Regression");
		Login login = PageFactory.initElements(driver, Login.class);
		Home home = PageFactory.initElements(driver, Home.class);
		DashBoard dashBoard = PageFactory.initElements(driver, DashBoard.class);
		DeleteProduct deleteproduct = PageFactory.initElements(driver, DeleteProduct.class);
					
		home.navLoginpage();;
		login.loginApp(data[0],data[1]);
		dashBoard.navProducts();
		Thread.sleep(3000);
		deleteproduct.selectDeleteicon(data[2]);
		Thread.sleep(3000);
		deleteproduct.acceptAlert();
		deleteproduct.verifyDeletedProduct(data[3]);
					
	}
	//===================Verify home page ==================================================
	
	@Test
	public static void TC020_homePage()
	{		
		String[] data = ExcelLib.getRowData("TC020_homePage", "Regression");
		Home home = PageFactory.initElements(driver, Home.class);
		
		home.verifyLoginlink();
		home.verifyRegisterlink();
		home.searchproduct(data[0]);
		home.navAboutOrbit();
		home.navCOA();
		home.navLiteratures();
		home.navProduct();
		home.navContactus();
	}
	//==================verify the search bar without inputing the data========================
	
	@Test
	public static void TC021_searchWithoutInputTheData()
	{		
		String[] data = ExcelLib.getRowData("TC021_searchWithoutInputTheData", "Regression");
		SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);
		
		searchfuntionality.searchProductNotInputingTheData(data[0]);
	}
		
	//==================verify the search bar with Invalid data========================
	
		@Test
		public static void TC022_searchWithInvalidData()
		{		
			String[] data = ExcelLib.getRowData("TC022_searchWithInvalidData", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);
			
			searchfuntionality.searchProductInvalidData(data[0]);
		}
	//========================Search the Product with product name========================		
		@Test
		public static void TC023_searchWithProductName()
		{		
			String[] data = ExcelLib.getRowData("TC023_searchWithProductName", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);			
			
			searchfuntionality.searchWithProductName(data[0]);
		}
		
	//========================Search the Product with Synonym========================		
		@Test
		public static void TC024_searchWithSynonym()
		{		
			String[] data = ExcelLib.getRowData("TC024_searchWithSynonym", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);					
			
			searchfuntionality.searchWithSynonym(data[0]);
		}
		
    //========================Search the Product with CatNo========================		
		@Test
		public static void TC025_searchWithCatNo()
		{		
			String[] data = ExcelLib.getRowData("TC025_searchWithCatNo", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);							
			
			searchfuntionality.searchWithCatNo(data[0]);
		}
	//========================Search the Product with CasNo========================		
		@Test
		public static void TC026_searchWithCasNo()
		{		
			String[] data = ExcelLib.getRowData("TC026_searchWithCasNo", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
			
			searchfuntionality.searchWithCasNo(data[0]);
		}
		
	//================Verify related Products available are not======================
		@Test
		public static void TC027_searchRelatedProducts()
		{		
		   String[] data = ExcelLib.getRowData("TC027_searchRelatedProducts", "Regression");
		   SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
					
		   searchfuntionality.verifyrelatedProducts(data[0]);
				
		}
		
	//================Verify related Categories available are not======================
		@Test
		public static void TC028_searchRelatedCategories()
		{		
		   String[] data = ExcelLib.getRowData("TC028_searchRelatedCategories", "Regression");
		   SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
							
		   searchfuntionality.verifyrelatedCategories(data[0]);
						
		}
    //================Verify related documents available are not======================
		@Test
		public static void TC029_searchRelatedDocuments()
		{		
			String[] data = ExcelLib.getRowData("TC029_searchRelatedDocuments", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
			
			searchfuntionality.verifyrelateddocumnets(data[0], data[1]);
		}
	//===============verify with invalid LotNo in COA=================================	
		@Test
		public static void TC030_searchWithInvalidLotNo() throws InterruptedException
		{		
			String[] data = ExcelLib.getRowData("TC030_searchWithInvalidLotNo", "Regression");
			SearchFunctionality searchfuntionality = PageFactory.initElements(driver, SearchFunctionality.class);									
			
			searchfuntionality.searchWithInvalidLotNo(data[0],data[1]);
		}
}

