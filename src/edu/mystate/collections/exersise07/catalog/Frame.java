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

                }
            });
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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

        public void addUser() {
            JFrame addUserWindow = new JFrame("add User");
            addUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addUserWindow.setSize(300, 280);
            addUserWindow.setLayout(new FlowLayout());

            JTextField userName = new JTextField(20);
            JTextField login = new JTextField(20);
            JTextField password = new JTextField(20);

            JLabel userNameLab = new JLabel("Введите имя пользователя");
            JLabel loginLab = new JLabel("Введите логин ");
            JLabel passwordLab = new JLabel("Введите пароль ");

            JButton add = new JButton("Добавить");
            JButton back = new JButton("Назад");

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.addUser(userName.getText(), login.getText(), password.getText())) {
                        addUserWindow.add(new JLabel("Пользователь добавлен"));
                    } else {
                        addUserWindow.add(new JLabel("Такой пользователь уже существует"));
                    }
                    addUserWindow.setSize(301,281);
                }
            });

            backActionListener(addUserWindow, back);

            addUserWindow.add(userNameLab);
            addUserWindow.add(userName);
            addUserWindow.add(loginLab);
            addUserWindow.add(login);
            addUserWindow.add(passwordLab);
            addUserWindow.add(password);
            addUserWindow.add(add);
            addUserWindow.add(back);

            addUserWindow.setVisible(true);
        }

        public void removeUser() {
            JFrame removeUserWindow = new JFrame("remove User");
            removeUserWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            removeUserWindow.setSize(300, 160);
            removeUserWindow.setLayout(new FlowLayout());

            JLabel userNameLab = new JLabel("Введите имя пользователя");

            JTextField userName = new JTextField(20);

            JButton remove = new JButton("Удалить");
            JButton back = new JButton("Назад");

            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.removeUser(userName.getText())) {
                        removeUserWindow.add(new JLabel("Пользователь удален"));
                    } else {
                        removeUserWindow.add(new JLabel("Пользователь не найден"));
                    }
                    removeUserWindow.setSize(301, 161);
                }
            });

            backActionListener(removeUserWindow, back);

            removeUserWindow.add(userNameLab);
            removeUserWindow.add(userName);
            removeUserWindow.add(remove);
            removeUserWindow.add(back);

            removeUserWindow.setVisible(true);
        }

        public void isAlreadyExist() {

            JFrame existsWindow = new JFrame("Already exists");
            existsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            existsWindow.setSize(300, 160);
            existsWindow.setLayout(new FlowLayout());

            JLabel userNameLab = new JLabel("Введите имя пользователя");

            JTextField userName = new JTextField(20);

            JButton check = new JButton("Проверить");
            JButton back = new JButton("Назад");

            check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (database.isAlreadyExists(userName.getText())) {
                        existsWindow.add(new JLabel("Пользователь существует"));
                    } else {
                        existsWindow.add(new JLabel("Пользователь не найден"));
                    }
                    existsWindow.setSize(301, 161);
                }
            });

            backActionListener(existsWindow, back);

            existsWindow.add(userNameLab);
            existsWindow.add(userName);
            existsWindow.add(check);
            existsWindow.add(back);

            existsWindow.setVisible(true);
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
