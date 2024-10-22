package pageObjects.adminProject;

public interface AdminProjectElements {

// Click on As Built after Login
    String selectAsBuiltText = "//span[@id='tabBarButton_3_label']";

// Click on Admin Project Routes
    String adminProjectsRoutes = "//div[@id='dijit_layout_ContentPane_95']";

//  Click on Search Filter on Admin Project Routes Page
    String searchFilter = "//span[@class='dijitReset dijitInline dijitIcon iconFilter']";

//  Click on Search field to enter data
    String searchField = "//input[@id='sf_value_13446436']";

//  Click on Search Button
    String searchButton = ".iconDone";

//  Click on Close After searching the Project
    String closeButton = ".iconclose";

//  Click on the search Project1579594004
    String selectProject1579594004 = "//td[contains(text(), '1579594004')][2]";

//  Click on 161070481
    String selectProject161070481 = "//div[contains(text(), '161070481')]" ;

//  Click to open the project
    String openProject = "//span[@id='dijit_form_Button_281_label']";

//  Click on Project Data
    String data = "//span[@id='menuBarItem_1_Button_label']" ;

    String cable = "//span[contains(text(),'Cable Level')]";


}