package com.javarush.view;

import com.javarush.entity.Result;

public interface View {
    String [] getParameters();
    void printResult(Result result);
}
