Feature: Calculating Borrowing Estimate

  Scenario Outline: Calculate borrowing estimate for a person
    Given launch the website url as https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/
    When user should be on How much could I borrow screen
    When user can able to select application type as single
    And user can able to select number of dependants as <number of dependants>
    And user can able to select the Property you would like to buy as home to live in
    And user enters your annual income as <annual income>
    And user enters your annual other income as <annual other income>
    And user enters monthly living expenses as <monthly living expenses>
    And user enters current home loan monthly repayments as <home loan monthly repayments>
    And user enters other loan monthly repayments as <other loan monthly repayments>
    And user enters Other monthly commitment as <other monthly commitment>
    And user enters total credit card limits as <total credit card limits>
    Then user click on how much I could borrow option
    Then validate the loan estimate amount as <estimate>

    Examples: 
      | number of dependants | annual income | annual other income | monthly living expenses | home loan monthly repayments | other loan monthly repayments | other monthly commitment | total credit card limits | estimate |
      |                    0 |         80000 |               10000 |                     500 |                            0 |                           100 |                        0 |                    10000 |   426000 |
