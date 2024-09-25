package com.javarush.app;

import com.javarush.controller.MainController;
import com.javarush.entity.Result;
import com.javarush.repository.FunctionCode;
import com.javarush.services.Function;

import static com.javarush.constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(){
        String[] parameters = mainController.getView().getParameters();
        String mode = parameters[0];
        Function function = getFunction(mode);
        return function.executes(parameters);

    }

    private Function getFunction(String mode) {
        return switch (mode){
            case "1"-> FunctionCode.valueOf(ENCODE).getFunction();
            case "2" -> FunctionCode.valueOf(DECODE).getFunction();
            case "3" -> FunctionCode.valueOf(BROOTFORCE).getFunction();
            case "4" -> FunctionCode.valueOf(STATIC_ANALIZ).getFunction();
            default -> FunctionCode.valueOf(UNSUPORTED_FUNCTION).getFunction();

        };
    }

    public void printResult(Result result){
        mainController.getView().printResult(result);
    }
}
