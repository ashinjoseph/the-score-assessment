package org.the.score.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.the.score.common.pages.BasePage;

public class TeamPage extends BasePage {
    private final AndroidDriver driver;

    public TeamPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private final String lbl_TeamName_Id = "com.fivemobile.thescore:id/team_name";
    private final String lbl_TeamStatsTab_Xpath = "//android.widget.TextView[@text='TEAM STATS']";
    private final String lbl_StatsScreen_Xpath = "//*[@resource-id='com.fivemobile.thescore:id/recyclerView']/*/android.widget.TextView[contains(@text, 'STATS')]";


    public void verifyTeamScreenIsDisplayed(String teamName) {
        WebElement lbl_TeamName = driver.findElement(MobileBy.id(lbl_TeamName_Id));
        isElementWithTextDisplayed(lbl_TeamName, teamName);
        //todo log
    }
    public void navigateToTeamStatsTab() {
        clickAndTransition(MobileBy.xpath(lbl_TeamStatsTab_Xpath));
        driver.findElement(MobileBy.xpath(lbl_StatsScreen_Xpath)).isDisplayed();
    }

}
