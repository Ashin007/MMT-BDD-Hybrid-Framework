Feature: Login flipkart
  The test case is all about login into flipkart application with email and password and check the user name is properly showing on home page.
  Example:Login onto application
  Scenario: Home Page Default login
    Given User is on landing page
    When User login into application with username as "Ashin" and password as 123
    Then Home page is populated result 200
    And Cards are shown properly 12