package dev.danvega;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LambdaDemoTest {

    @Test
    @DisplayName("Should Return Hello Message")
    void testHandleRequest() {
        var lambdaDemo = new LambdaDemo();
        Assertions.assertEquals("Hello, AWS Lambda!", lambdaDemo.handleRequest());
    }
}