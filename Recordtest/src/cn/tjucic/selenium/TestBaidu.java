package cn.tjucic.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jxl.Sheet;  
import jxl.Workbook;  
import jxl.read.biff.BiffException; 
import jxl.Cell;  




@RunWith(Parameterized.class)
public class TestBaidu {
	
  private String studentId;
  private String github;
  private String passwd;
  private String studentName;
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  public TestBaidu(String id,String passwd,String git,String names) {
	this.studentId = id;
	this.github = git;
	this.passwd = passwd;
	this.studentName = names;
  }

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/Resources/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  //121.193.130.195:8800
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
  }
  
@Parameters
  public static Collection<Object[]> getData() throws BiffException, IOException{

		File f=new File(System.getProperty("user.dir") + "/src/软件测试名单.xls");
	        
	        String[] stuid = new String[145];
	        String[] stupw = new String[145];
	        String[] stugh = new String[145];
	        String[] stunm = new String[145];
	        
	        Workbook book=Workbook.getWorkbook(f);// 
	        Sheet sheet=book.getSheet(0); //获得第一个工作表对象
		  	
	        for(int i=2;i<sheet.getRows();i++){ 
	          
	          Cell cell1=sheet.getCell(1, i); 
	          Cell cell2=sheet.getCell(2, i); 
	          Cell cell3=sheet.getCell(3, i);
              stuid [i-2] = cell1.getContents();
              stupw [i-2] = cell1.getContents();
	          stugh [i-2] = cell3.getContents();
	          stunm [i-2] = cell2.getContents();
	         
	        } 
	       for(int s = 0 ;s<142;s++)
	       {
	    	   stupw[s] = stupw[s].substring(4);
	       }
	          Object[][] objects = new Object[142][4];
	          for(int i = 0; i < objects.length; i++)
	          {
	        	  
	              objects[i][0] = stuid[i];
	              objects[i][1] = stupw[i];
	              objects[i][2] = stugh[i];
	              objects[i][3] = stunm[i];
	              
	          }
	          List<Object[]> strlist = Arrays.asList(objects);
	          return strlist;
	  }


  @Test
  public void testBaidu() throws Exception {
    driver.get(baseUrl + "/");
    WebElement we = driver.findElement(By.name("id"));
    we.click();
//    driver.findElement(By.id("kw")).click();
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).click();
    driver.findElement(By.name("id")).sendKeys(this.studentId);
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys(this.passwd);
    driver.findElement(By.id("btn_login")).click();

    Object gitAddress = driver.findElement(By.id("student-git")).getText();
    Object stuname = driver.findElement(By.id("student-name")).getText();
    Object stuid = driver.findElement(By.id("student-id")).getText();
    //System.out.println(gitAddress.toString());
 
    assertEquals(this.github, gitAddress);
    assertEquals(this.studentName, stuname);
    assertEquals(this.studentId, stuid);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

