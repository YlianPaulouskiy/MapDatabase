package edu.mystate.collections.exersise07.catalog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    private final Database database = new Database();

        public void showMainMenu() {
            JFrame window = new JFrame("DataBases");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(500, 250);
            window.setLayout(new FlowLayout());

            JButton button1 = new JButton("Добавить нового пользователя");
            JButton button2 = new JButton("Удалить существующего пользователя");
            JButton button3 = new JButton("Проверить существует ли пользователь");
            JButton button4 = new JButton("Изменить логин существующего пользователя");
            JButton button5 = new JButton("Изменить пароль существующего пользователя");
            JButton button6 = new JButton("Показать всех пользователей");

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    addUser();
                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    removeUser();
                }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    isAlreadyExist();
                }
            });
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    changeLogin();
                }
            });
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    changePassword();
                }
            });
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    showUsers();
                }
            });

            window.add(button1);
            window.add(button2);
            window.add(button3);
            window.add(button4);
            window.add(button5);
            window.add(button6);

            window.setVisible(true);
        }

        private void addUser() {
            JFrame addUserWindow = new JFrame("add User");
            addUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addUserWindow.setSize(300, 280);
            addUserWindow.setLayout(new FlowLayout());

            JTextField userNameTextField = new JTextField(20);
            JTextField loginTextField = new JTextField(20);
            JTextField passwordTextField = new JTextField(20);

            JLabel userNameLab = new JLabel("Введите имя пользователя");
            JLabel loginLab = new JLabel("Введите логин ");
            JLabel passwordLab = new JLabel("Введите пароль ");

            JButton addButton = new JButton("Добавить");
            JButton backButton = new JButton("Назад");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.addUser(userNameTextField.getText(), loginTextField.getText(), passwordTextField.getText())) {
                        addUserWindow.add(new JLabel("Пользователь добавлен"));
                    } else {
                        addUserWindow.add(new JLabel("Такой пользователь уже существует"));
                    }
                    addUserWindow.setSize(301,281);
                }
            });

            backActionListener(addUserWindow, backButton);

            addUserWindow.add(userNameLab);
            addUserWindow.add(userNameTextField);
            addUserWindow.add(loginLab);
            addUserWindow.add(loginTextField);
            addUserWindow.add(passwordLab);
            addUserWindow.add(passwordTextField);
            addUserWindow.add(addButton);
            addUserWindow.add(backButton);

            addUserWindow.setVisible(true);
        }

        private void removeUser() {
            JFrame removeUserWindow = new JFrame("remove User");
            removeUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            removeUserWindow.setSize(300, 160);
            removeUserWindow.setLayout(new FlowLayout());

            JLabel userNameLab = new JLabel("Введите имя пользователя");

            JTextField userNameTextField = new JTextField(20);

            JButton removeButton = new JButton("Удалить");
            JButton backButton = new JButton("Назад");

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.removeUser(userNameTextField.getText())) {
                        removeUserWindow.add(new JLabel("Пользователь удален"));
                    } else {
                        removeUserWindow.add(new JLabel("Пользователь не найден"));
                    }
                    removeUserWindow.setSize(301, 161);
                }
            });

            backActionListener(removeUserWindow, backButton);

            removeUserWindow.add(userNameLab);
            removeUserWindow.add(userNameTextField);
            removeUserWindow.add(removeButton);
            removeUserWindow.add(backButton);

            removeUserWindow.setVisible(true);
        }

        private void isAlreadyExist() {

            JFrame existsWindow = new JFrame("Already exists");
            existsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            existsWindow.setSize(300, 160);
            existsWindow.setLayout(new FlowLayout());

            JLabel userNameLab = new JLabel("Введите имя пользователя");

            JTextField userNameTextField = new JTextField(20);

            JButton checkButton = new JButton("Проверить");
            JButton backButton = new JButton("Назад");

            checkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.isAlreadyExists(userNameTextField.getText())) {
                        existsWindow.add(new JLabel("Пользователь существует"));
                    } else {
                        existsWindow.add(new JLabel("Пользователь не найден"));
                    }
                    existsWindow.setSize(301, 161);
                }
            });

            backActionListener(existsWindow, backButton);

            existsWindow.add(userNameLab);
            existsWindow.add(userNameTextField);
            existsWindow.add(checkButton);
            existsWindow.add(backButton);

            existsWindow.setVisible(true);
        }

        private void changeLogin() {
            JFrame changeWindow = new JFrame("change Login");
            changeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            changeWindow.setSize(300, 280);
            changeWindow.setLayout(new FlowLayout());

            JTextField userNameTextField = new JTextField(20);
            JTextField loginTextField = new JTextField(20);


            JLabel userNameLab = new JLabel("Введите имя пользователя");
            JLabel loginLab = new JLabel("Введите новый логин ");

            JButton changeButton = new JButton("Изменить");
            JButton backButton = new JButton("Назад");

            changeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.changeLogin(userNameTextField.getText(), loginTextField.getText())) {
                        changeWindow.add(new JLabel("Логин изменен."));
                    } else {
                        changeWindow.add(new JLabel("Пользователь не найден"));
                    }
                    changeWindow.setSize(301, 281);
                }
            });

            backActionListener(changeWindow, backButton);

            changeWindow.add(userNameLab);
            changeWindow.add(userNameTextField);
            changeWindow.add(loginLab);
            changeWindow.add(loginTextField);
            changeWindow.add(changeButton);
            changeWindow.add(backButton);

            changeWindow.setVisible(true);
        }

        private void changePassword() {
            JFrame changeWindow = new JFrame("change Password");
            changeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            changeWindow.setSize(300, 280);
            changeWindow.setLayout(new FlowLayout());

            JTextField userNameTextField = new JTextField(20);
            JTextField passwordTextField = new JTextField(20);


            JLabel userNameLab = new JLabel("Введите имя пользователя");
            JLabel passwordLab = new JLabel("Введите новый логин ");

            JButton changeButton = new JButton("Изменить");
            JButton backButton = new JButton("Назад");

            changeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.changePassword(userNameTextField.getText(), passwordTextField.getText())) {
                        changeWindow.add(new JLabel("Пароль изменен."));
                    } else {
                        changeWindow.add(new JLabel("Пользователь не найден"));
                    }
                    changeWindow.setSize(301, 281);
                }
            });

            backActionListener(changeWindow, backButton);

            changeWindow.add(userNameLab);
            changeWindow.add(userNameTextField);
            changeWindow.add(passwordLab);
            changeWindow.add(passwordTextField);
            changeWindow.add(changeButton);
            changeWindow.add(backButton);

            changeWindow.setVisible(true);
        }

        public void showUsers() {
            JFrame usersWindow = new JFrame("All Users");
            usersWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            usersWindow.setSize(500,500);
            usersWindow.setLayout(new FlowLayout());

            JTextArea usersInfoLabel = new JTextArea(database.showUsers());
            usersInfoLabel.setEditable(false);

            JButton backButton = new JButton("Назад");

            backActionListener(usersWindow, backButton);

            usersWindow.add(usersInfoLabel);
            usersWindow.add(backButton);

            usersWindow.setVisible(true);
        }


        private void backActionListener(JFrame window , JButton button) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    window.removeAll();
                    window.dispose();
                    showMainMenu();
                }
            });
        }
}
