Feature: proceed to check-out page flow

  Background:
    Given initialize the data fields to process with the flow

  Scenario: Verify the proceed to check-out page flow by adding the selected TV from the search list with single quantity
    Given user is in the home after successfully logging into the application
    And user checks if the status of the add to cart is empty or not to clear add to cart
    And user proceeds to the check-out page by adding the selected TV from the search list with "single" quantity
    Then verify user have successfully proceeded with the checkout page and redirected to the shipping and payment page

  Scenario: Verify the proceed to check-out page flow by adding the selected TV from the search list with multiple quantity
    Given user is in the home after successfully logging into the application
    And user checks if the status of the add to cart is empty or not to clear add to cart
    And user proceeds to the check-out page by adding the selected TV from the search list with "multiple" quantity
    Then verify user have successfully proceeded with the checkout page and redirected to the shipping and payment page
