package com.example.sunny.digitstoletters.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface IDTLServiceImpl {

    public List<List<String>> digitsToLetters(List<List<String>> source, List<List<String>> result, int layer, List<String> curList);
    public List<List<String>> getLetters(String inputData);
}
