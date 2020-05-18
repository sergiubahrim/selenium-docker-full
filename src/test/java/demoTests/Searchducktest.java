package demoTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import searchSite.SearchPage;
import tests.BaseTest;

public class Searchducktest extends BaseTest {



    @Test
    @Parameters({"keyword"})
    public void search(String keyword) throws InterruptedException{
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult(keyword);

        Assert.assertTrue(size > 0);
    }
}
