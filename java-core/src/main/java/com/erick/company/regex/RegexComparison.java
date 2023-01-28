package com.erick.company.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexComparison {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,30})");
        Matcher m = p.matcher("n!k1abcD#!");

        System.out.println(m.find());
        System.out.println(m.matches());
    }
}
