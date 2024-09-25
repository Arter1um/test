package com.javarush.view;

import com.javarush.constants.FunctionCodeConstants;
import com.javarush.entity.Result;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static com.javarush.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.constants.ApplicationCompletionConstants.SUCCESS;

public class GUIView implements View {
    private final String[] parameters = new String[4];

    @Override
    public String[] getParameters() {
        JFrame frame = new JFrame("Crypto Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        // Operation selection
        JLabel operationLabel = new JLabel("Виберіть операцію:");
        c.gridx = 0;
        c.gridy = 0;
        frame.add(operationLabel, c);

        String[] operations = {
                "1 " + FunctionCodeConstants.ENCODE,
                "2 " + FunctionCodeConstants.DECODE,
                "3 " + FunctionCodeConstants.BROOTFORCE,
                "4 " + FunctionCodeConstants.STATIC_ANALIZ
        };
        JComboBox<String> operationComboBox = new JComboBox<>(operations);
        c.gridx = 1;
        c.gridy = 0;
        frame.add(operationComboBox, c);

        // Key input
        JLabel keyLabel = new JLabel("Введіть ключ:");
        c.gridx = 0;
        c.gridy = 1;
        frame.add(keyLabel, c);

        JTextField keyInput = new JTextField();
        c.gridx = 1;
        c.gridy = 1;
        frame.add(keyInput, c);

        // File selection
        JLabel fileLabel = new JLabel("Виберіть файл:");
        c.gridx = 0;
        c.gridy = 2;
        frame.add(fileLabel, c);

        JButton fileButton = new JButton("Вибрати файл");
        c.gridx = 1;
        c.gridy = 2;
        frame.add(fileButton, c);

        JLabel filePathLabel = new JLabel("Файл не вибрано");
        c.gridx = 2;
        c.gridy = 2;
        frame.add(filePathLabel, c);

        // Language selection for static analysis
        JLabel languageLabel = new JLabel("Мова зашифрованого тексту:");
        c.gridx = 0;
        c.gridy = 3;
        frame.add(languageLabel, c);

        String[] languages = {"1 Англійська", "2 Українська"};
        JComboBox<String> languageComboBox = new JComboBox<>(languages);
        c.gridx = 1;
        c.gridy = 3;
        frame.add(languageComboBox, c);

        // Submit button
        JButton submitButton = new JButton("Виконати");
        c.gridx = 1;
        c.gridy = 4;
        frame.add(submitButton, c);

        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathLabel.setText(selectedFile.getPath());
                    parameters[2] = selectedFile.getPath();
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parameters[0] = ((String) operationComboBox.getSelectedItem()).substring(0, 1);
                parameters[1] = keyInput.getText();

                if (parameters[0].equals("4")) {
                    parameters[3] = ((String) languageComboBox.getSelectedItem()).substring(0, 1);
                }

                // Викликати метод для виконання функції з параметрами
                // (Це можна зробити через інтерфейс контролера або сервісу)
            }
        });

        frame.setVisible(true);

        // Блокуючий режим, поки користувач не завершить ввід
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return parameters;
    }
    @Override
    public void printResult(Result result) {

    }
}
