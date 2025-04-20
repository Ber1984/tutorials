package com.erick.company.LeetCode.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Arrays;

public class TestNullObject {
    private String id;
    private String name;
    private String errorObj;

    public TestNullObject(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public TestNullObject(String id, String name, String errorObj) {
        this.id = id;
        this.name = name;
        this.errorObj = errorObj;
    }

    @Override
    public String toString() {
        String s = ", errorObj='" + errorObj + '\'';
        return "TestNullObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                s +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var objs = Arrays.asList(new TestNullObject("1", "erick", "error"));
        var newList = new ArrayList<String>();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String jsonString = mapper.writeValueAsString(new TestNullObject("1", "erick", "error"));
        for(TestNullObject obj : objs) {
            if(obj.errorObj == null) {
                newList.add(mapper.writeValueAsString(obj));
            }
        }

        System.out.println(newList);
    }
}
