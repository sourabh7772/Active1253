package CreateCampaign;


import java.io.FileInputStream;


public class Create_Campaign01Test extends Base_Class01 {

	@Test(groups = "SmokeTest")
	public void  Create_Campaign01Test() throws Throwable {
	 WebDriver driver = new ChromeDriver();
			
       //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                         WebDriver_Utility01 web = new WebDriver_Utility01();
                         web.Pagetoload(driver);
                         web.WindowMaximize(driver);
                         File_Utility01 futi = new File_Utility01();
                        String URL = futi.getkeyandvaluepair("url");
                        String BROWSER = futi.getkeyandvaluepair("browser");
                        String USERNAME = futi.getkeyandvaluepair("username");
                       String PASSWORD = futi.getkeyandvaluepair("password");
                                 
		                 
            /*    FileInputStream file = new FileInputStream("./src/test/resources/PropertiesData.properties.txt");
                           Properties pro = new Properties();
                           pro.load(file);
                           
                           String BROWSER = pro.getProperty("browser");
                           String URL = pro.getProperty("url");
                           String USERNAME = pro.getProperty("username");
                           String PASSWORD = pro.getProperty("password");*/
                           
                           driver.get(URL);
                           
                           VtigerLoginPage01 login = new VtigerLoginPage01(driver);
                           login.LoginTOVtiger(USERNAME, PASSWORD);
                           
                                       Home_Page home = new Home_Page(driver);
                                      home.Morelink();
                                     home.Campaignlink();
                           
                            Create_Campaign_Page camppage = new Create_Campaign_Page(driver);
                            camppage.Lookupimg();
                      
                              //  driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
                                
                                
                                Random ran = new Random();
                               int rannum = ran.nextInt();
                                
                                  Excel_Utility01 exut = new Excel_Utility01();
                                  String Campname = exut.getExcelData("Campaign", 0, 0)+rannum;
                                
                                /*  FileInputStream fol = new FileInputStream("./src/test/resources/Nike.xlsx");
                                         Workbook book = WorkbookFactory.create(fol);
                                         Sheet sheet = book.getSheet("Campaign");
                                        Row row = sheet.getRow(0);
                                       Cell cell = row.getCell(0);
                                       String Campname = cell.getStringCellValue();*/
                                
                                                
                                       camppage.enterCampname(Campname);
                               // driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(Campname);
                                
                                JavascriptExecutor js = (JavascriptExecutor)driver;
                                js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                                
                                camppage.Savebutton();
                                
                              Validation_Page vali = new Validation_Page(driver);
                              vali.Validation_CampPage(driver, Campname);
                                
                              //  driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
                                
                              /*  String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
                               
                          
                               
                               
                               if (actdata.contains(Campname)) 
                                {
									System.out.println("Camp name is created");
								}
                                else 
                                {
                                     System.out.println("Camp name is not created");
								}*/
                                
                           //    home.Adminlink();
                           //    home.Signout();
                              // driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
                            //   driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();

                             
                        //   driver.quit();   
                           
                           

	}


	@Test(groups = {"SmokeTest","RegressionTest","SanityTest"})
	public void Create_Product01Test() throws Throwable {
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get("http://localhost:8888/");
         driver.manage().window().maximize();
         
         driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
         driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
         driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
         
                                  Home_Page home = new Home_Page(driver);
                                  home.ProductLink();
        // driver.findElement(By.xpath("//a[text()=\"Products\"]")).click();
                                  
                               Create_Product_Page pro = new Create_Product_Page(driver);
                               pro.createProductLink();
       //  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
                               
                                  Java_Utility_01 juti = new Java_Utility_01();
                               int rannum = juti.getrandomnumber();
         
                      //   Random ran = new Random();
                      //    int rannum = ran.nextInt(1000);
         
            
                            Excel_Utility01 exuti = new Excel_Utility01();
                            String Productname = exuti.getExcelData("Product", 0, 0)+rannum;
     /*  FileInputStream file = new FileInputStream("./src/test/resources/Nike.xlsx");
       Workbook book = WorkbookFactory.create(file);
       Sheet sheet = book.getSheet("Product");
      Row row = sheet.getRow(0);
      Cell cell = row.getCell(0);
      String Productname = cell.getStringCellValue()+rannum;*/
             
                
                      Scroll_Utility sc = new Scroll_Utility();
                      sc.ScrollToUp(driver);
      
              //  JavascriptExecutor js = (JavascriptExecutor)driver;
               // js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                
                pro.productName(Productname);   
                
               // driver.findElement(By.xpath("//input[@name=\"productname\"]")).sendKeys(Productname);
                
                pro.productSaveButton();
             //   driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
                
          
                Validation_Page valid = new Validation_Page(driver);
                valid.Validation_ProductPage(driver, Productname);
           
                /*  String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
                
                if (actdata.contains(Productname))
                {
						System.out.println("Productname is created");
			    }
                else 
                {
                 System.out.println("Productname is not created");
				}
				*/
                
              
                 home.Adminlink();
                 home.Signout();
               // driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
               // driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
        
      
      
        


	}

}
