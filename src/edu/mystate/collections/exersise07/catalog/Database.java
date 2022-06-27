package edu.mystate.collections.exersise07.catalog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Database {

    Map<String, Map<String, String>> userData = new HashMap<>();

    public Database() {
    }

    public boolean addUser(String userName, String login, String password) {
        int length = userData.size();
        Map<String, String> logAndPass = new HashMap<>();
        logAndPass.put(login, password);
        if (userName != null) {
            userData.putIfAbsent(userName, logAndPass);
        }
        return userData.size() > length;
    }

    public boolean removeUser(String userName) {
        if (userData.containsKey(userName)) {
            userData.remove(userName);
            return true;
        } else {
            return false;
        }
    }
//
    public boolean changeLogin(String userName, String newLogin) {
        if (userData.containsKey(userName)) {
            String password = null;
            for (String key : userData.get(userName).keySet()) {
                password = userData.get(userName).get(key);
            }
            Map<String, String> logAndPass = new HashMap<>();
            logAndPass.put(newLogin, password);
            userData.put(userName, logAndPass);
            return true;
        }
        return false;
    }
//
//    public void changePass(String login) {
//        try {
//            for (Map<String, String> logAndPass : userData.keySet()) {
//                if (logAndPass.containsKey(login)) {
//                    logAndPass.put(login,getPassword());
//                    System.out.println("Пароль сменен");
//                    return;
//                }
//            }
//        } catch (NullPointerException exception) {
//            exception.printStackTrace();
//        }
//    }
//
    public boolean isAlreadyExists(String userName) {
        return userData.containsKey(userName);
    }
//
//
//
//    public void showUsers() {
//        userData.forEach((key, value) -> {
//            System.out.print(value + " -> ");
//            key.forEach((key1,value1) -> System.out.print("login: " + key1 + " password: " + value1 + "\n"));
//        });
//    }
//
//
//    private String getPassword() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите пароль пользователя.");
//        String password = null;
//        try {
//            password = bufferedReader.readLine();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//        return password;
//    }
//
//    private String getLogin() {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите логин пользователя.");
//        String login = null;
//        try {
//            login = bufferedReader.readLine();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//        return login;
//    }

}
