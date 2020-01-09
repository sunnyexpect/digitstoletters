package com.example.sunny.digitstoletters.service.impl;

import com.example.sunny.digitstoletters.bean.DigitsLetters;
import com.example.sunny.digitstoletters.service.IDTLServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunny
 */
@Service
public class DTLServiceImpl implements IDTLServiceImpl {

    DigitsLetters digitsLetters;

    @Override
    public List<List<String>> getLetters(String inputData) {
        ArrayList<List<String>> result = new ArrayList<>();
        int layer = 0;
        List<String> curList = new ArrayList<String>();
        digitsLetters = new DigitsLetters(inputData);
        List<List<String>> source = digitsLetters.getSource();
        return this.digitsToLetters(digitsLetters.getSource(), result, 0, new ArrayList<String>());
    }

    @Override
    public List<List<String>> digitsToLetters(List<List<String>> source, List<List<String>> result, int layer, List<String> curList) {
        if(layer < source.size() - 1){
            if(source.get(layer).size() == 0){
                digitsToLetters(source, result, layer +1, curList);
            }else{
                source.get(layer).stream().forEach(s -> {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(s);
                    digitsToLetters(source, result, layer + 1, list);
                });
            }
        }else if(layer == source.size() - 1){
            if(source.get(layer).size() == 0){
                result.add(curList);
            }else{
                source.get(layer).stream().forEach(s -> {
                    List<String> list = new ArrayList<String>(curList);
                    list.add(s);
                    result.add(list);
                });
            }
        }
        return result;
    }
}
