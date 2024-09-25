package com.javarush.view;

import com.javarush.constants.FunctionCodeConstants;
import com.javarush.entity.Result;
import java.util.Scanner;
import static com.javarush.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View {

    @Override
    public String[] getParameters() {
        System.out.println("Виберіть операцію");
        System.out.println("1 " + FunctionCodeConstants.ENCODE);
        System.out.println("2 " + FunctionCodeConstants.DECODE);
        System.out.println("3 " + FunctionCodeConstants.BROOTFORCE);
        System.out.println("4 " + FunctionCodeConstants.STATIC_ANALIZ);
        Scanner scanner = new Scanner(System.in);
        String[] parameters = new String[4];
        String command = scanner.nextLine();
        parameters[0] = command;
        if (command.equals("1") || command.equals("2")) {
            System.out.println("Введіть ключ:");
            String key = scanner.nextLine();
            parameters[1] = key;
        }  else {
            parameters[1] = "";
        }
        if (command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4")) {
            System.out.println("Виберіть файл:");
            System.out.println("1. Стандартний файл");
            System.out.println("2. Ваш файл");
            String fileChoice = scanner.nextLine();
            if (fileChoice.equals("2")) {
                System.out.println("Введіть шлях до файлу:");
                String filePath = scanner.nextLine();
                parameters[2] = filePath;
            } else {
                if (parameters[0].equals("1")) {
                    parameters[2] = "/Users/admin/IdeaProjects/CeaserProbe/resources/file.txt";
                } else {
                    parameters[2] = "/Users/admin/IdeaProjects/CeaserProbe/resources/file_encrypt.txt";
                }
            }
        }
        if (command.equals("4")){
            System.out.println("Введіть 1, якщо зашифрований текст англійською мовою, або 2, якщо українською:");
            String languageChoise = scanner.nextLine();
            if (languageChoise.equals("1")){
                parameters[4]=languageChoise;
            }else{
                parameters[3]="2";
            }
        }

        return parameters;
    }
    @Override
    public void printResult(Result result) {
        switch (result.getResultCode()){
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }

    }
}
