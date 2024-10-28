package pageEvents.adminPageEvents;

import base.BaseTest;
import org.openqa.selenium.By;
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
        // Store the current window handle
        String mainWindow = driver.getWindowHandle();

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

    public void openProject() {

        String mainWindow = driver.getWindowHandle();
        logger.info("Clicking on Project with ID: " + 1579594004);

        // Click on the project with a specific ID
        WebElement selectProject = elementFetch.getWebElement("XPATH", AdminProjectElements.selectProject1579594004);
        selectProject.click();

        // Wait until the project with ID 161070481 is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '161070481')]")));

        logger.info("Opening Project with ID: 161070481");

        // Click on the project with ID 161070481
        WebElement project161070481 = elementFetch.getWebElement("XPATH", AdminProjectElements.selectProject161070481);
        project161070481.click();

        // Wait for the open button to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apri Progetto')]")));

        // Click on the open button to open the project
        WebElement openButton = elementFetch.getWebElement("XPATH", AdminProjectElements.projectOpen);
        openButton.click();
        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }


        }
    }

//    private void switchToNewTab() {
//        // Store the current window handle
//        String currentWindow = driver.getWindowHandle();
//
//        // Wait for the new window/tab to open
//        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(1));
//
//        // Switch to the new tab
//        for (String windowHandle : driver.getWindowHandles()) {
//            if (!windowHandle.equals(currentWindow)) {
//                driver.switchTo().window(windowHandle);
//                break;
//            }
//        }
//    }

//        // Wait for an element in the child window to be visible
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementInChildWindow")));


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

        logger.info("Click on Exteact");
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


    private void switchToChildWindow() {
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window handle: " + parentWindow);
        java.util.Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindows);
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        System.out.println("Window Title: " + driver.getTitle());

    }


}





//        WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30));
//        waitt.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='menuBarItem_1_Button_label']")));
//
//
//
//
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        // Switch to the new tab
//        driver.switchTo().window(tabs.get(2));



//
//              logger.info("click on data");
//        WebElement data = elementFetch.getWebElement("XPATH", builtPageElements.data);
//        data.click();
//
//
//
//        // Get the window handles
//        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
//
//        // Switch to the new tab
//        driver.switchTo().window(windows.get(0));
//        driver.close();








