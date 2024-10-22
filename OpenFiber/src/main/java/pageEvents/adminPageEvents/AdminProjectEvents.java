package pageEvents.adminPageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.adminProject.AdminProjectElements;
import utils.ElementFetch;

import java.time.Duration;
import java.util.Set;

import static base.BaseTest.driver;
import static base.BaseTest.logger;

public class AdminProjectEvents {


    private ElementFetch elementFetch = new ElementFetch();


//  Navigates to Admin Projects Routes page
    public void navigateToAdminProjectsRoutesPage() {
        logger.info("Click on As built in the dashboard");
        WebElement select = elementFetch.getWebElement("XPATH", AdminProjectElements.selectAsBuiltText);
        select.click();

        logger.info("Open Admin ProjectsEvents Routes");
        WebElement adminProjectsRoutes = elementFetch.getWebElement("XPATH", AdminProjectElements.adminProjectsRoutes);
        adminProjectsRoutes.click();

//     window Handling
//     switchToNewWindow();

        switchToChildWindow();


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

//  Selects a project
    public void selectProject() {
        logger.info("Click on Project having project id " + 1579594004);
        WebElement selectProject = elementFetch.getWebElement("XPATH", AdminProjectElements.selectProject1579594004);
        selectProject.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '161070481')]")));
    }

//  Opens project
    public void openProject() {
        logger.info("Open Project having id 161070481");
        WebElement project161070481 = elementFetch.getWebElement("XPATH", AdminProjectElements.selectProject161070481);
        project161070481.click();

        WebElement openProject = elementFetch.getWebElement("XPATH", AdminProjectElements.openProject);
        openProject.click();


        switchToNewWindow();


//
//        WebElement data = elementFetch.getWebElement("XPATH", AdminProjectElements.cable);
//        data.click();
    }


    //  To handle window
//    private void switchToNewWindow() {

//// Get the window handles
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//
//// Switch to the new tab
//        driver.switchTo().window(tabs.get(1));
//
//// Perform actions in the new window
//        System.out.println("Title of the new window: " + driver.getTitle());

//        Set<String> windowHandles = driver.getWindowHandles();
//
//        // Print all window handles
//        System.out.println("Open Windows:");
//        for (String handle : windowHandles) {
//            System.out.println(handle);
//        }
//
//        // Optionally, switch to each window and print its title
//        for (String handle : windowHandles) {
//            driver.switchTo().window(handle);
//            System.out.println("Window Title: " + driver.getTitle());
//        }
//
//        String parentWindow = driver.getWindowHandle();
//        Set<String> windowHandles = driver.getWindowHandles();
//        String childWindow = null;
//
//        for (String handle : windowHandles) {
//            if (!handle.equals(parentWindow)) {
//                childWindow = handle;
//                break;
//            }
//        }
//        driver.switchTo().window(childWindow);

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


        private void switchToNewWindow () {


            String parentWindow = driver.getWindowHandle();
            String childWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            String newWindow = null;

            for (String handle : windowHandles) {
                if (!handle.equals(parentWindow) && !handle.equals(childWindow)) {
                    newWindow = handle;

                }
            }
            driver.switchTo().window(newWindow);
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








