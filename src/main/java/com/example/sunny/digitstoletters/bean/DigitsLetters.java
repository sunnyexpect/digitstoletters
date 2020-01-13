package com.example.sunny.digitstoletters.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Sunny
 */

public class DigitsLetters {
    private List<String> l2 = Arrays.asList("A", "B", "C");
    private List<String> l3 = Arrays.asList("D", "E", "F");
    private List<String> l4 = Arrays.asList("G", "H", "I");
    private List<String> l5 = Arrays.asList("J", "K", "L");
    private List<String> l6 = Arrays.asList("M", "N", "O");
    private List<String> l7 = Arrays.asList("P", "Q", "R", "S");
    private List<String> l8 = Arrays.asList("T", "U", "V");
    private List<String> l9 = Arrays.asList("W", "X", "Y", "Z");
    private List<List<String>> list = new ArrayList<List<String>>();
    private List<List<String>> source = new ArrayList<List<String>>();
    private int count = 1;

    public DigitsLetters(String inputData) {
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);
        list.add(l7);
        list.add(l8);
        list.add(l9);
        List<String> data = Arrays.asList(inputData.trim().split(""));
        //Filter: only filter 2-9 are valid input
        Pattern pattern = Pattern.compile("[2-9]");
        if(data.size() > 0) {
            data.stream().filter(s -> (pattern.matcher(s).matches())).forEach(s -> {
                source.add(list.get(Integer.parseInt(s) - 2));
                count = count * list.get(Integer.parseInt(s) - 2).size();
            });
        }
    }

    public List<List<String>> getSource(){
        return source;
    }

    public int getCount() { return count; }
}
