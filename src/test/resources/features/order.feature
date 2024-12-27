Feature: Order Management

  Scenario: Create a new order
    Given the product with name "Laptop" exists
    When I create an order with product name "Laptop" and quantity 2
    Then I should see the order in the list of all orders
