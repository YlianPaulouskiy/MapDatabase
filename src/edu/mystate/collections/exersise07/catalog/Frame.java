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

                }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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
                        addUserWindow.setSize(301,281);
                    } else {
                        addUserWindow.add(new JLabel("Такой пользователь уже существует"));
                    }
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
