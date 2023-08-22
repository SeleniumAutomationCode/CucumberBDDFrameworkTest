# Loan Estimation Calculator

This project is a loan estimation calculator web application that helps users determine how much they could borrow for a home loan.

## Scenarios In Feature file

- Calculate borrowing estimate based on user inputs.
- Clear the estimation details and validate the field inputs

### Details to be followed to run automation script
- Clone the project to local 
    git clone https://github.com/your-username/loan-estimation-calculator.git
- Need to have code developement environment like eclipse or intellij
- Import project to eclipse workspace as exisiting maven project
- Install maven plugin from eclipse market place
- Build the maven tool
- Clean the maven project
- Update the maven project
- Configure Junit Library on Configure build path
- Install cucumber eclipse plugin from eclipse market place
- navigate to configure option convert project to cucumber project
- you can find the feature file and scenario under /TechnicalAssessment/src/test/resources/com/iGreenData/featuresForUI/
- you can find the stepdefinition class under /TechnicalAssessment/src/test/java/com/iGreenData/runnerClass/
- you can find the test runner class under /TechnicalAssessment/src/test/java/com/iGreenData/stepDefinition/

# Components
- BaseSetup - To setup browser configuration
- CommonUtils - CommonMethods - To Create reusable components for web element
- CommonUtils - ValidationUtils - Created Validation methods to reuse
- CommonUtils - WaitUtils - Created Webdriver wait methods
- PageObjects - Created Page class and created each web elements to reuse on step definition file
- Runner class - To execute the feature files
- Step defintion - Created all steps
- Feature file - created set of scenarios
- Pom.XML file - Here manintained all the required dependencies and added surfire/compiler plugin for cmd run and integrated for CI run
  
# Execute the test runner file from runner class
- Go to TestRunner.class right click run as Juni test > Test will start to execute and generte the report after executed the feature file
- Every time it generate new results after run

# Run From Common line
- Install maven check version
commond : mvn -v
- open common prompt project directory 
- Use below commond to execute specfic feature file
commond : mvn test -Dcucumber.options="src/test/resources/com/iGreenData/featuresForUI/firstTestCase.feature"
- Alternate commond to execute specific scenario 
commond : mvn test -Dcucumber.options="src/test/resources/com/iGreenData/featuresForUI/firstTestCase.feature:3"

## Results
You can find the test results in the `reports` directory. The reports include detailed information about test cases, pass/fail status, and coverage if applicable.
- HTML Report: Open the HTML report in a web browser for a user-friendly view.
- JSON Report: Analyze the JSON report for additional data or integration purposes.
- XML Report: XML report format can be useful for integration with other systems.
