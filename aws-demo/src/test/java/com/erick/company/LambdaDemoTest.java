package com.erick.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LambdaDemoTest {

    @Test
    @DisplayName("Should Return Hello Message")
    void testHandleRequest() {
        var lambdaDemo = new LambdaDemo();
        Assertions.assertEquals("Hello, AWS Lambda!", lambdaDemo.handleRequest());
    }
}