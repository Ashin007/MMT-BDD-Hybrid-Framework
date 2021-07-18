Feature: Make My Trip Application Assignment Test
  Scenario: Price Validation
    Given User is on landing page
    When User click on flight
    And click on round trip
    Then Select from: "Delhi" and to:"Bangalore"
    And Select departure date:today
    And return date: after 7 days
    Then click on search
    Then print total number of records of departure flight
    And print return flight list
    Then select non-stop and 1 stop filter options
    And print total number of departure flight and return flight
    Then select radio button of top 10 options of departure flight and return flight
    And verify the same departure flight price and return flight price are getting reflected in bottom page
    Then verify the correct total amount is getting reflected correctly