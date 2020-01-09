package com.example.sunny.digitstoletters.controller;

import com.example.sunny.digitstoletters.service.IDTLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunny
 */
@RestController
public class DTLController {

    @Autowired
    private IDTLServiceImpl idtlServiceImpl;

    @GetMapping("digits")
    public String digits(String inputData) {
        List<List<String>> result = new ArrayList<List<String>>();
        result = idtlServiceImpl.getLetters(inputData);
        return result.toString();
    }

}
