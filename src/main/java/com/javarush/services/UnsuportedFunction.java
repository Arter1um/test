package com.javarush.services;

import com.javarush.entity.Result;
import com.javarush.exception.ApplicationException;
import com.javarush.repository.ResultCode;

public class UnsuportedFunction implements Function{
    @Override
    public Result executes(String[] parameters) {
        String message = "This feature is not yet supported.";
        System.out.println(message);
        return new Result(ResultCode.ERROR, new ApplicationException(message));

    }
}
