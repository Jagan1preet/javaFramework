package testCases;

import org.testng.annotations.Test;
import pageEvents.adminPageEvents.AdminProjectEvents;

public class AdminProject extends LogIn {


    AdminProjectEvents adminProjectsRoutes = new AdminProjectEvents();

    //  Test case to navigate to Admin Project Routes Page
    @Test(description = "Verify user able to Navigate To AdminProject Routes Page")
    public void navigateToAdminProjectsRoutesPage() {
        loginPage.login();
        adminProjectsRoutes.navigateToAdminProjectsRoutesPage();
    }

    //  Test case to search Project by ID
    @Test(description = "Verify user able to Search Project By Id")
    public void searchProjectById() {
        loginPage.login();
        adminProjectsRoutes.navigateToAdminProjectsRoutesPage();
        adminProjectsRoutes.searchProjectById();

    }

    //   Test case to open project
    @Test(description = "Verify user able to Open Project")
    public void openProject() throws InterruptedException {
        loginPage.login();
        adminProjectsRoutes.navigateToAdminProjectsRoutesPage();
        adminProjectsRoutes.searchProjectById();
        adminProjectsRoutes.openProject();
    }

    @Test(description = "Verify user able to download the file")
    public void compareCMTFiles() throws InterruptedException {
        loginPage.login();
        adminProjectsRoutes.navigateToAdminProjectsRoutesPage();
        adminProjectsRoutes.searchProjectById();
        adminProjectsRoutes.openProject();
        adminProjectsRoutes.downloadCMTFile();
    }
}