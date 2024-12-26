package com.example.order_service;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.example.orderservice.steps",
    plugin = {"pretty", "html:target/cucumber.html"}
)
public class CucumberTest {
}

