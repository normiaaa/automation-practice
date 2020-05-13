package NormiaTest;

import Pages.Chapter1Page;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chapter1 extends TestClassParent {


    Chapter1Page ch1p;

//    private static final String KEY = "test";

//    @BeforeClass
//    public void beforeClass(ITestContext context) {
//        String value = context.getCurrentXmlTest().getParameter(KEY);
//        System.out.println("VALUEEE >> " + value);
//    }
//
//    @Test
//    public void testMethod() {
//        String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(KEY);
//        System.out.println("VALUEEE >> " + value);
//    }
//


    @BeforeTest
    public void setup() {

        super.beforeTest();
        ch1p = new Chapter1Page(driver);
        ch1p.navigate();
    }



    //Elements are displayed

    @Test(description = "Display Elements", priority = 1, groups = {"display_elements"})
    public void contentTest(ITestContext context) {

        //Check title
        ch1p.checkTitle();
        ch1p.checkIfButtonIsDisplayed();

    }

    @Test(description = "Radio Button and List", priority = 2, groups = { "display_elements"})
    public void radioButtonListTest() throws InterruptedException {

        ch1p.clickOnRadioButton();
        ch1p.selectItemsFromDropdown();
        ch1p.selectSpecificItemFromDropdown(utils.SELECT_SELENIUM_VALUE2);


        //I made this by Value text, it should be more ok by index?
    }

    @Test(description = "Links", priority = 3)
    public void links() throws InterruptedException {
        driver.get(utils.URL_CHAPTER1);

        //Open the first Window

        ch1p.clickOnNewWindow1();
        ch1p.checkNewWindow1();

        //Open the second window

        ch1p.openNewWindow2();
        ch1p.checkNewWindow2();

        //Load a page with Ajax

        ch1p.clickFirstAjaxElement();
        ch1p.checkFirstAjaxElement();


    }

    @Test(description = "Radio Button and List", priority = 4)
    public void loadText() throws InterruptedException {

        //Find second ajax button and click on it

        ch1p.clickSecondAjaxElement();
        ch1p.checkSecondAjaxElement();

    }


    public void title() {

        ch1p.checkTitle();


    }
}



