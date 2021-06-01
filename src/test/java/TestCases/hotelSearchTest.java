package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePack.browserLaunch;
import Pages.hotelSearchPage;

public class hotelSearchTest extends browserLaunch {

	
	@BeforeTest
	public void launch() throws IOException {
		browserLaunch.setup();
		browserLaunch.launchBrowser();
	}
	
	@Test
	public void validation() {
		hotelSearchPage hsp = new hotelSearchPage();
		hsp.hotelSearch();
		String title = hsp.readTitle();
		Assert.assertTrue(title.contains("Hyderabad"));
		
	}
	
	@AfterTest
	public void terminateBrowser() {
		browserLaunch.terminate();
	}
	
}
