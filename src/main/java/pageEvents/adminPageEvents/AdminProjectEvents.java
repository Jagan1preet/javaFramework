package pageEvents.adminPageEvents;

import base.BaseTest;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;
import pageObjects.adminProject.AdminProjectElements;
import pageObjects.logIn.LoginPageElements;
import utils.ElementFetch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.*;

import static base.BaseTest.driver;
import static base.BaseTest.logger;

public class AdminProjectEvents {


    private ElementFetch elementFetch = new ElementFetch();
    private static String adminproject;
    private static String projectpage;
// Folder location to download file

    String location = System.getProperty("user.dir") + "\\CMTFile";

    private Map<String, Object> vars;JavascriptExecutor js;

//    @Before
//    public void setUp() {
//
//        js = (JavascriptExecutor) driver;
//        vars = new HashMap<String, Object>();
//    }

//    public String waitForWindow(int timeout) {
//        try {
//            Thread.sleep(timeout);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Set<String> whNow = driver.getWindowHandles();
//        Set<String> whThen = (Set<String>) vars.get("window_handles");
//        if (whNow.size() > whThen.size()) {
//            whNow.removeAll(whThen);
//        }
//        return whNow.iterator().next();
//    }


    //  Read the data from the config file
    public AdminProjectEvents() {
        try (InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("config.yml")) {
            if (inputStream == null) {
                throw new FileNotFoundException("config.yml not found in the classpath");
            }
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);

            adminproject = (String) config.get("adminproject");
            projectpage = (String) config.get("projectpage");
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
        }
    }


    //  Navigates to Admin Projects Routes page
    public void navigateToAdminProjectsRoutesPage() {
        logger.info("Click on As built in the dashboard");
        WebElement select = elementFetch.getWebElement("XPATH", AdminProjectElements.selectAsBuiltText);
        select.click();

//        logger.info("Open Admin ProjectsEvents Routes");
//        WebElement adminProjectsRoutes = elementFetch.getWebElement("XPATH", AdminProjectElements.adminProjectsRoutes);
//        adminProjectsRoutes.click();

//        // Get the window handles
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//
//        // Switch to the new tab
//        driver.switchTo().window(tabs.get(1));


        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(adminproject);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '107248507')][2]")));

    }

    //  Searches project by ID
    public void searchProjectById() {
        logger.info("Search Project by Id");
        WebElement search = elementFetch.getWebElement("XPATH", AdminProjectElements.searchFilter);
        search.click();

        WebElement field = elementFetch.getWebElement("XPATH", AdminProjectElements.searchField);
        field.click();
        field.clear();
        field.sendKeys("1579594004");

        WebElement searchButton = elementFetch.getWebElement("CSS", AdminProjectElements.searchButton);
        searchButton.click();

        WebElement closeFilter = elementFetch.getWebElement("CSS", AdminProjectElements.closeButton);
        closeFilter.click();


    }


    //  Opens project
    public void openProject() {
        logger.info("Click on Project having project id " + 1579594004);

        // Click on the project with a specific ID
        WebElement selectProject = elementFetch.getWebElement("XPATH", AdminProjectElements.selectProject1579594004);
        selectProject.click();

        // Wait until the project with ID 161070481 is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '161070481')]")));

        logger.info("Open Project having id 161070481");

        // Click on the project with ID 161070481
        WebElement project161070481 = elementFetch.getWebElement("XPATH", AdminProjectElements.selectProject161070481);
        project161070481.click();

        WebDriverWait wAit = new WebDriverWait(driver, Duration.ofSeconds(30));
        wAit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(),'Apri Progetto')]")));


//         Click on the open button to open the project
        WebElement open = elementFetch.getWebElement("XPATH", AdminProjectElements.projectOpen);
        open.click();


//        vars.put("win4359", waitForWindow(2000));
//        driver.switchTo().window(vars.get("win4359").toString());

    }

    public void downloadCMTFile() throws InterruptedException {


//        // Wait for an element in the child window to be visible
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementInChildWindow")));


        System.out.println("Window Title: " + driver.getTitle());
//        // Wait until the new page is fully loaded
//        WebDriverWait waait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        waait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(),'Progetto AB_SIC4SANTANGELOMU_1_DA_CANCELLARE')]")));


//        WebDriverWait waait = new WebDriverWait(driver, Duration.ofSeconds(50));
//       waait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OpenLayers_Layer_Vector_62_svgRoot']")));
        System.out.println("Window Title: " + driver.getTitle());
        WebElement data = elementFetch.getWebElement("XPATH", AdminProjectElements.documentManagement);
        logger.info("Click on data");
        data.click();


        logger.info("click on doc management");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(ExpectedConditions.v("//span[contains(text(), 'Progetto AB_SIC4SANTANGELOMU_1_DA_CANCELLARE')]")));

        logger.info("click on printManagement");
        WebElement printmanagement = elementFetch.getWebElement("XPATH", AdminProjectElements.printManagement);
        printmanagement.click();

        logger.info("Click on CMT");
        WebElement clickonCMT = elementFetch.getWebElement("XPATH", AdminProjectElements.CMT);
        clickonCMT.click();

        logger.info("Click on Extract");
        WebElement extract = elementFetch.getWebElement("XPATH", AdminProjectElements.extract);
        extract.click();
        WebDriverWait waaait = new WebDriverWait(driver, Duration.ofSeconds(20));
        waaait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AdminProjectElements.sendButton)));


        // Set download path for the Excel file
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", location);


        // code to download file

        Thread.sleep(5000);


    }
}



