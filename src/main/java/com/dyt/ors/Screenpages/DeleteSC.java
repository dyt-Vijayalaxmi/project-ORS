package com.dyt.ors.Screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.dyt.generic.BaseClass;

public class DeleteSC extends BaseClass  {
	
	//===================To select the delete icon======================
	
	public static boolean selectDeleteicon(String expValue) {
		boolean bStatus = false;
		try {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
		int tabrowscount=rows.size();
		
		for(int i=1; i<=tabrowscount; i++) {
		String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
		
		if ((actValue.equals(expValue)))  {
			driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[5]/a[2]/i")).click();
			break;
			
			}
		}
		}
		catch(Exception e) {
			bStatus = false;
		}
		return bStatus;
		
		
	}
	//==========================Accept the alert=================================
	public static boolean acceptAlert() {
		boolean bStatus = true;
		try {
			driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			bStatus = false;
		}
		return bStatus;
	}
	//======================verify that SC is deleted from the MC List page ========================
	public static boolean verifyDeletedSC(String expValue) {
		boolean bStatus = false;
		try {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
		int tabrowscount=rows.size();
		
		for(int i=1; i<=tabrowscount; i++) {
		String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[3]")).getText();
				
		if ((actValue.equals(expValue))) { 
			System.out.println("SC is not deleted sucessfully");}
		else {
			System.out.println("SC is deleted sucessfully");
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
