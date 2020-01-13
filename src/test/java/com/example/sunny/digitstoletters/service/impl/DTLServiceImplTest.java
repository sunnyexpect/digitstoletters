package com.example.sunny.digitstoletters.service.impl;

import com.example.sunny.digitstoletters.bean.DigitsLetters;
import com.example.sunny.digitstoletters.service.IDTLServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DTLServiceImpl.class)
class DTLServiceImplTest {

    @Autowired
    private  IDTLServiceImpl dtlService;

    @Test
    void SingleDigitsToLetters() {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> curList = new ArrayList<>();
        String input = "4";
        DigitsLetters digitsLetters = new DigitsLetters(input);
        dtlService.digitsToLetters(digitsLetters.getSource(), result, 0, curList);
        assertEquals(digitsLetters.getCount(), result.stream().distinct().count());
        boolean allMatch = result.stream().allMatch(l -> {
            boolean flag = true;
            for(int i = 1; i< l.size(); i++){
                if(!digitsLetters.getSource().get(i).contains(l.get(i))){
                    flag = false;
                    break;
                }
            }
            return flag;
        });
        assertEquals(true, allMatch);
    }

    @Test
    void MultipleDigitsToLetters() {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> curList = new ArrayList<>();
        Random random = new Random();
        String input = "4,6";
        DigitsLetters digitsLetters = new DigitsLetters(String.valueOf(input));
        dtlService.digitsToLetters(digitsLetters.getSource(), result, 0, curList);
        assertEquals(digitsLetters.getCount(), result.stream().distinct().count());
        boolean allMatch = result.stream().allMatch(l -> {
            boolean flag = true;
            for(int i = 1; i< l.size(); i++){
                if(!digitsLetters.getSource().get(i).contains(l.get(i))){
                    flag = false;
                    break;
                }
            }
            return flag;
        });
        assertEquals(true, allMatch);
    }

    @Test
    void BoundaryDigitsToLetters() {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> curList = new ArrayList<>();
        Random random = new Random();
        String input = "4,1,3,0";
        DigitsLetters digitsLetters = new DigitsLetters(String.valueOf(input));
        dtlService.digitsToLetters(digitsLetters.getSource(), result, 0, curList);
        assertEquals(digitsLetters.getCount(), result.stream().distinct().count());
        boolean allMatch = result.stream().allMatch(l -> {
            boolean flag = true;
            for(int i = 1; i< l.size(); i++){
                if(!digitsLetters.getSource().get(i).contains(l.get(i))){
                    flag = false;
                    break;
                }
            }
            return flag;
        });
        assertEquals(true, allMatch);
    }

    @Test
    void Stage2InputDigitsToLetters() {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> curList = new ArrayList<>();
        Random random = new Random();
        String input = "4103";
        DigitsLetters digitsLetters = new DigitsLetters(String.valueOf(input));
        dtlService.digitsToLetters(digitsLetters.getSource(), result, 0, curList);
        assertEquals(digitsLetters.getCount(), result.stream().distinct().count());
        boolean allMatch = result.stream().allMatch(l -> {
            boolean flag = true;
            for(int i = 1; i< l.size(); i++){
                if(!digitsLetters.getSource().get(i).contains(l.get(i))){
                    flag = false;
                    break;
                }
            }
            return flag;
        });
        assertEquals(true, allMatch);
    }

    @Test
    void RandomDigitsToLetters() {
        List<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> curList = new ArrayList<>();
        Random random = new Random();
        int input = random.nextInt(100000000);
        DigitsLetters digitsLetters = new DigitsLetters(String.valueOf(input));
        dtlService.digitsToLetters(digitsLetters.getSource(), result, 0, curList);
        assertEquals(digitsLetters.getCount(), result.stream().distinct().count());
        boolean allMatch = result.stream().allMatch(l -> {
           boolean flag = true;
           for(int i = 1; i< l.size(); i++){
               if(!digitsLetters.getSource().get(i).contains(l.get(i))){
                   flag = false;
                   break;
               }
           }
            return flag;
        });
        assertEquals(true, allMatch);
    }
}