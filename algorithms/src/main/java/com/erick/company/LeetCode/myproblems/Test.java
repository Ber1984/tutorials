package com.erick.company.LeetCode.myproblems;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void shouldReturnNOrP() {
        String extracted = GetFirstCharacterWithOnlyOneOccurrence.extracted();
        Assert.assertTrue("Found " + extracted, extracted.contains("n") | extracted.contains("m") | extracted.contains("y"));
    }
}
