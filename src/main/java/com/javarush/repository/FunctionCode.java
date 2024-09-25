package com.javarush.repository;

import com.javarush.services.*;
import com.javarush.services.BruteForce;

public enum FunctionCode {
    ENCODE(new Encode()),DECODE(new Decode()),BROOTFORCE(new BruteForce()),UNSUPPORTED_FUNCTION(new UnsuportedFunction()),STATIC_ANALIZ(new StaticAnaliz());

    private final Function function;
    FunctionCode(Function function) {
        this.function = function;
    }
    public Function getFunction(){
        return function;
    }
}
