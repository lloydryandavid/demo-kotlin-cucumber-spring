Feature: Add, and fetch a customer

  Scenario Outline: This scenario uses a web service request to create a customer, and then another web service request
            to fetch it.

    Given I have a payload containing the following properties: "<first_name>" "<last_name>"
    And   I have set the message headers "<headers>"
    When  I send this message to the add customer path
    Then  the http response code must be 200
    When  I retrieve the customer "<first_name>" "<last_name>" using the get customer path
    Then  the "<first_name>" "<last_name>" must be retrieved

    Examples:
      | headers                       | first_name | last_name |
      | Content-Type:application/json | Andy       | Murray    |
      | Content-Type:application/json | Rafael     | Nadal     |
