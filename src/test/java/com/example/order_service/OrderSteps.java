package com.example.order_service;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;

@SpringBootTest(classes = OrderServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderSteps {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private ResponseEntity<Order[]> responseEntity;

    @Given("the product with name {string} exists")
    public void the_product_with_name_exists(String productName) {
        Order order = new Order();
        order.setProductName(productName);
        order.setQuantity(10);
        order.setPrice(1000.0);
        orderRepository.save(order);
    }

    @When("I create an order with product name {string} and quantity {int}")
    public void i_create_an_order_with_product_name_and_quantity(String productName, int quantity) {
        Order order = new Order();
        order.setProductName(productName);
        order.setQuantity(quantity);
        order.setPrice(1000.0);
        orderRepository.save(order);
    }

    @Then("I should see the order in the list of all orders")
    public void i_should_see_the_order_in_the_list_of_all_orders() {
        responseEntity = restTemplate.getForEntity("/api/orders", Order[].class);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(responseEntity.getBody()).isNotEmpty();
    }
}

