package com.iGreenData.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.iGreenData.Common.utilities.CommonMethods;
import com.iGreenData.Common.utilities.ValidationUtils;

public class CalculatorsAndToolsPage {

	public WebDriver driver;
	CommonMethods common = new CommonMethods();
	ValidationUtils validate = new ValidationUtils();

	public CalculatorsAndToolsPage(WebDriver driver) {
		this.driver = driver;
	}

	// How much could I borrow Screen
	private By pageHeader = By.xpath("//span[contains(text(),'How much could')]");
	private By singleOption = By.xpath("//input[@id='application_type_single']");
	private By numberOfDependantsDropDown = By.xpath("//select[@title='Number of dependants']");
	private By homeToLiveInOption = By.id("borrow_type_home");
	private By annualIncomeInput = By.xpath("//span[@id='q2q1i1']//following-sibling::input[1]");
	private By annualOtherIncomeInput = By.xpath("//span[@id='q2q2i1']//following-sibling::input[1]");
	private By mothlyLiveingExpInput = By.id("expenses");
	private By curHomeLoanMonthlyInput = By.id("homeloans");
	private By otherLoansInput = By.id("otherloans");
	private By otherMonthlyInput = By.xpath("//span[@id='q3q4i1']//following-sibling::input[1]");
	private By totalCreditCardInput = By.id("credit");
	private By workOutHowMuchButton = By.id("btnBorrowCalculater");
	private By starOverButton = By.xpath("//input[@id='credit']//following::button[3]");
	private By borrowResult = By.id("borrowResultTextAmount");
	private By borrowEstimateMessage = By.xpath("//span[@id='borrowResultTextAmount']//preceding-sibling::h3");

	// How much could I borrow Screen
	public void checkPageTitle() {
		validate.validatePageTitle(driver, "Home loan borrowing power calculator | ANZ", "Check Page Title");
	}
	
	public void checkHowMuchCouldIBorrowScreenHeader() {
		validate.validateElementIsExists(driver, pageHeader, "Check How much could I borrow Screen title");
	}

	public void clickOnSingleOptionAppType() {
		common.clickElement(driver, singleOption, "Select On Signle On Appliction Type");
	}

	public void selectNumOfDependants(int indexValue) {
		common.selectByIndexFromDropDown(driver, numberOfDependantsDropDown, indexValue,
				"Select Number of dependants :" + indexValue);
	}

	public void selectPropertyYouWouldLikeToBuyAs() {
		common.clickElement(driver, homeToLiveInOption, "Select Property you would like to buy As Home to live In");
	}

	public void enterYourAnnualIncome(String annualIncome) {
		common.enterValue(driver, annualIncomeInput, annualIncome, "Your annual income (before tax)" + annualIncome);
	}

	public void enterAnnualOtherIncome(String annualOtherIncome) {
		common.enterValue(driver, annualOtherIncomeInput, annualOtherIncome,
				"Your annual other income (optional)" + annualOtherIncome);
	}

	public void enterMothlyLiveingExpenses(String mothlyLiveingExp) {
		common.enterValue(driver, mothlyLiveingExpInput, mothlyLiveingExp,
				"Monthly living expenses" + mothlyLiveingExp);
	}

	public void enterCurrentHomeLoanMonthly(String curHomeLoanMonthly) {
		common.enterValue(driver, curHomeLoanMonthlyInput, curHomeLoanMonthly,
				"Current home loan monthly repayments" + curHomeLoanMonthly);
	}

	public void enterOtherLoanMonthlyRepayments(String otherLoans) {
		common.enterValue(driver, otherLoansInput, otherLoans, "Other loan monthly repayments" + otherLoans);
	}

	public void enterOtherMonthlyCommitments(String otherMonthly) {
		common.enterValue(driver, otherMonthlyInput, otherMonthly, "Other monthly commitments" + otherMonthly);
	}

	public void enterTotalCreditCardLimits(String totalCreditCard) {
		common.enterValue(driver, totalCreditCardInput, totalCreditCard,
				"Total credit card limits" + totalCreditCardInput);
	}

	public void clickOnWorkOutHowMuchICouldBorrow() {
		common.clickElement(driver, workOutHowMuchButton, "Click On Work out how much I could borrow");
	}

	public void clickOnStartOver(String annualIncome) {
		common.clickElement(driver, starOverButton, "Click On Start Over");
	}

	public void checkEstimateBorrow(String estimateAmount) throws InterruptedException {
		validate.validateText(driver, borrowEstimateMessage, "We estimate you could borrow:",
				"Check We estimate you could borrow Message");
		Thread.sleep(10000);
		validate.validateText(driver, borrowResult, estimateAmount, "Check Borrow Amount Result " + estimateAmount);
	}

	public void createBorrowEstimate(int numOfDep, String annualIncome, String annualOtherIncome,
			String monthlyLivingExp, String currHomeLoan, String otherLoan, String otherMonthly, String creditLimit) {
		selectNumOfDependants(numOfDep);
		selectPropertyYouWouldLikeToBuyAs();
		enterYourAnnualIncome(annualIncome);
		enterAnnualOtherIncome(annualOtherIncome);
		enterMothlyLiveingExpenses(monthlyLivingExp);
		enterCurrentHomeLoanMonthly(currHomeLoan);
		enterOtherLoanMonthlyRepayments(otherLoan);
		enterOtherMonthlyCommitments(otherMonthly);
		enterTotalCreditCardLimits(creditLimit);
	}
}
