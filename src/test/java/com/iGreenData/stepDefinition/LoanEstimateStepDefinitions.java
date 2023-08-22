package com.iGreenData.stepDefinition;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.iGreenData.baseSetup.baseClass;
import com.iGreenData.extentReports.reportConfig;
import com.iGreenData.pageObjects.CalculatorsAndToolsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoanEstimateStepDefinitions {
	private CalculatorsAndToolsPage estimatePage;
	private baseClass base;
	private static reportConfig report;
	private WebDriver driver;

	
	@Given("^launch the website url as (.*)$")
	public void launchTheURL(String url) {
	    base = new baseClass();
		report = new reportConfig();
	    driver = base.setupBrowser("chrome");
		base.launchURL(driver, url);
		report.test = report.startTestCase("Test");
		estimatePage =new CalculatorsAndToolsPage(driver);
		estimatePage.checkPageTitle();
	}
	
	@When("^user should be on How much could I borrow screen$")
	public void user_should_be_on_calculators_and_tools_screen() {
		estimatePage.checkHowMuchCouldIBorrowScreenHeader();
	}

	@When("user can able to select application type as single")
	public void applicationTypeAsSingle() {
		estimatePage.clickOnSingleOptionAppType();
	}

	@When("^user can able to select number of dependants as (.*)$")
	public void numberOfDependants(int value) {
		estimatePage.selectNumOfDependants(value);
	}

	@When("^user can able to select the Property you would like to buy as home to live in$")
    public void propertyYouWouldLikeToBuy() {
        estimatePage.selectPropertyYouWouldLikeToBuyAs();
    }

    @When("^user enters your annual income as (.*)$")
    public void yourAnnualIncome(String annualIncome) {
        estimatePage.enterYourAnnualIncome(annualIncome);
    }

	@When("^user enters your annual other income as (.*)$")
	public void yourAnnualOtherIncome(String annualOtherIncome) {
		estimatePage.enterAnnualOtherIncome(annualOtherIncome);
	}

	@When("^user enters monthly living expenses as (.*)$")
	public void monthlyLivingExpenses(String monthlyLivingExp) {
		estimatePage.enterMothlyLiveingExpenses(monthlyLivingExp);
	}

	@When("^user enters current home loan monthly repayments as (.*)$")
	public void currentHomeLoanMonthlyRepayments(String currenHomeLoan) {
		estimatePage.enterCurrentHomeLoanMonthly(currenHomeLoan);
	}

	@When("^user enters other loan monthly repayments as (.*)$")
	public void otherLoanMonthlyRepayments(String otherLoan) {
		estimatePage.enterOtherLoanMonthlyRepayments(otherLoan);
	}

	@When("^user enters Other monthly commitment as (.*)$")
	public void otherMonthlyCommitment(String monthlyCommitment) {
		estimatePage.enterOtherMonthlyCommitments(monthlyCommitment);
	}

	@When("^user enters total credit card limits as (.*)$")
    public void totalCreditCardLimits(String creditCardLimits) {
        estimatePage.enterTotalCreditCardLimits(creditCardLimits);
    }

    @Then("^user click on how much I could borrow option$")
    public void clickOnHowMuchICouldBorrowOption() {
        estimatePage.clickOnWorkOutHowMuchICouldBorrow();
    }

    @Then("^validate the loan estimate amount as (.*)$")
    public void validateTheLoanEstimateAmount(String expectedLoanEstimate) throws InterruptedException {
        double value =	Double.valueOf(expectedLoanEstimate);
        NumberFormat format  =NumberFormat.getCurrencyInstance(Locale.US);
        String expectedValue = format.format(value);
        estimatePage.checkEstimateBorrow(expectedValue);
    }
}
