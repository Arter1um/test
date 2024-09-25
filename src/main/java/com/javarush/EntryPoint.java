package com.javarush;

import com.javarush.app.Application;
import com.javarush.controller.MainController;
import com.javarush.entity.Result;
import com.javarush.view.ConsoleView;
import com.javarush.view.GUIView;
import com.javarush.view.View;

public class EntryPoint {
    public static void main(String[] args) {
        //View view = new ConsoleView();
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);

        Result result = application.run();
        application.printResult(result);
    }
}