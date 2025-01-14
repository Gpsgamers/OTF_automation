package asserts;

import org.openqa.selenium.By;

import Runners.base;

public class Elements_methods extends base {

	public static By Toast(String content) {
		return By.xpath("//*[text()='" + content + "']");
	}

	public static By loader = By.xpath("//div[contains(@class,'pageLoader')]");

	public static By show_stopper_Ui = By.xpath("//*[text()='Something went wrong']");
	public static By show_stopper_overlay = By.xpath("//*[@class='outside_wraper']");
	public static By tryagain_btn = By.xpath("//*[text()='Try again']");
	public static By pageinfo = By.xpath("//div[@class='pagesInfo']");

	// login page
	public static By emailfield = By.xpath("//*[@label ='email']");
	public static By password = By.xpath("//*[@label ='password']");
	public static By sign_in = By.xpath("//*[text() ='Sign In']");

	// top header
	public static By orginazation_Dropdown = By.xpath("//button[@class='multi_login btn-icon ']");

	// left menu
	public static By logo = By.xpath("(//a[@href='/broadcast'])[1]");
	public static By stream_menu = By.xpath("(//a[@href='/broadcast'])[2]");
	public static By destination_menu = By.xpath("//a[@href='/integration']");
	public static By library_menu = By.xpath("//a[@href='/recordings']");
	public static By members_menu = By.xpath("//a[@href='/users']");

	// stream page
	public static By create_stream_btn(int index) {
		return By.xpath("(//*[text()='Create Stream'])[" + index + "]");
	}

	public static By record_Video_btn = By.xpath("//*[text()='Record Video']");
	public static By schedule_Webinar_btn = By.xpath("//*[text()='Schedule Webinar']");
	public static By create_with_Studio_btn = By.xpath("//*[text()='Stream with Studio']");
	public static By pre_Recorded_stream_btn = By.xpath("//*[text()='Pre-Recorded Stream']");
	public static By all_Tab = By.xpath("//button[text()='All']");
	public static By upcomming_Tab = By.xpath("//button[text()='Upcoming']");
	public static By past_Tab = By.xpath("//button[text()='Past']");
	public static By searchField = By.xpath("//input[@class='table_search_input     ']");
	public static By bulk_Select = By.xpath("//input[@id='SelectAll']");

	public static By row(int index, String element) {
		return By.xpath("(// div[@class='sc-eqUAAy bHUsHq sticky-table-row'])[" + index + "]" + element);
	}

	public static String enterStudio_btn = "//button[@class='action_join ']";
	public static String play_btn = "//a[@class='action_join']";
	public static String disabled_play_btn = "//div[@class='action_join disable record ']";
	public static String ellipses_btn = "//button[@class='  cp-btn-icon blue rounded ']";

	// Create Stream popup
	public static By Title_field = By.xpath("//input[@id='title']");
	public static By createLivestream_btn = By.xpath("//*[text()='Create Live Stream']");

	// pre-previw screen
	public static By entering_stream_loader = By.xpath("entering_stream_wraper_loader");
	public static By enter_stream_btn = By.xpath("//*[text()='Enter Stream']");
	public static By enter_stream_disable_btn = By.xpath("//button[@class='entering_stream_enter disabled']");

///////
///
///
	public static void login(String Email, String Password) {
		driver.findElement(emailfield).sendKeys(Email);
		driver.findElement(password).sendKeys(Password);
		driver.findElement(sign_in).click();
	}

	public static void stream_creation(String name) {
		driver.findElement(create_stream_btn(1)).click();
		driver.findElement(create_with_Studio_btn).click();
		driver.findElement(Title_field).sendKeys(name);
		driver.findElement(createLivestream_btn).click();
	}
}
