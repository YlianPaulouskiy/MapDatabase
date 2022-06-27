package edu.mystate.collections.exersise07;

import edu.mystate.collections.exersise07.catalog.Frame;

public class Main {

    public static void main(String[] args) {

        Frame frame = new Frame();
        frame.showMainMenu();
//        frame.addUser();

//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            Database database = new Database();
//            try {
//                while (true) {
//                    System.out.println(
//                            "\n0. выход" +
//                                    "\n1. Добавить нового пользователя" +
//                                    "\n2. Удалить существующегго пользователя" +
//                                    "\n3. Проверить существует ли пользователь" +
//                                    "\n4. Изменить логин существующиего пользователя" +
//                                    "\n5. Изменить пароль существующего пользователя" +
//                                    "\n6. Показать всех пользователей"
//                    );
//                    int choice = Integer.parseInt(bufferedReader.readLine());
//                    if (choice == 0) {
//                        break;
//                    } else if (choice < 0 || choice > 6) {
//                        System.out.println("Неверный ввод");
//                    }
//                    switch (choice) {
//                        case 1:
//                            database.addUser();
//                            break;
//                        case 2:
//                            System.out.println("Введите логин пользователя, которого хотите удалить.");
//                            database.removeUser(bufferedReader.readLine());
//                            break;
//                        case 3:
//                            System.out.println("Введите логин пользователя");
//                            if (database.isAlreadyExists(bufferedReader.readLine())) {
//                                System.out.println("пользователь существует");
//                            } else {
//                                System.out.println("Такого пользователя нет");
//                            }
//                            break;
//                        case 4:
//                            System.out.println("Введите логин пользователя, для которого нужно изменить логин.");
//                            database.changeLogin(bufferedReader.readLine());
//                            break;
//                        case 5:
//                            System.out.println("Введите логин пользователя, для которого нужно изменить пароль.");
//                            database.changePass(bufferedReader.readLine());
//                            break;
//                        case 6:
//                            database.showUsers();
//                    }
//                }
//            } catch (IOException | NumberFormatException exception) {
//                exception.printStackTrace();
//            }
        }

}
