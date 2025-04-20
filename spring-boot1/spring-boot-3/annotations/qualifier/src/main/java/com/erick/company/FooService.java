package com.erick.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooService {

    @Autowired
    @Qualifier("fooFormatter") //Tell spring IOc which dependency of Formatter type to inject
    private Formatter formatter;
}
