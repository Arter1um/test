package com.javarush.services;

import com.javarush.entity.Result;

public interface Function {
    Result executes(String[] parameters);
}
