package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.adminPageEvents.AdminProjectEvents;
import pageEvents.loginEvents.LoginPageEvents;

public class TestCase extends BaseTest {

    LoginPageEvents loginPage = new LoginPageEvents();
    AdminProjectEvents adminProjectsRoutes = new AdminProjectEvents();


// Test case to validate if the login page load properly
    @Test(description = "Verify Login page is loaded completely")
    public void verifyLoginPage() {
        loginPage.verifyIfLoginPageIsLoaded();
    }

//  Test case for incorrect Log in
    @Test(description = "Verify Login with incorrect credentials")
    public void verifyIncorrectLogin(){
        loginPage.incorrectLogin();
    }

//  Test case to Log in
    @Test(description = "Verify User able to Login")
    public void verifyLogin() {
        loginPage.login();
    }


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
        adminProjectsRoutes.selectProject();
    }

//   Test case to open project
     @Test(description = "Verify user able to Open Project")
     public void openProject() {
        loginPage.login();
        adminProjectsRoutes.navigateToAdminProjectsRoutesPage();
        adminProjectsRoutes.searchProjectById();
        adminProjectsRoutes.selectProject();
        adminProjectsRoutes.openProject();
    }
}