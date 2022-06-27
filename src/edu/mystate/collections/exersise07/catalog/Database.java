package edu.mystate.collections.exersise07.catalog;

import java.util.HashMap;
import java.util.Map;


/**backSide of project
 *
 */
public class Database {

    Map<String, Map<String, String>> userData = new HashMap<>();

    public Database() {
    }

    /**Add new User in map
     *
     * @param userName userName
     * @param login login user
     * @param password password
     * @return return true if user added
     */
    public boolean addUser(String userName, String login, String password) {
        int length = userData.size();
        Map<String, String> logAndPass = new HashMap<>();
        logAndPass.put(login, password);
        if (userName != null) {
            userData.putIfAbsent(userName, logAndPass);
        }
        return userData.size() > length;
    }


    /**remove exist user from map
     *
     * @param userName user name
     * @return true if user deleted
     */
    public boolean removeUser(String userName) {
        if (userData.containsKey(userName)) {
            userData.remove(userName);
            return true;
        } else {
            return false;
        }
    }

    /**change login of user
     *
     * @param userName user Name
     * @param newLogin new Login
     * @return true if login was change
     */
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

    /**change password of user
     *
     * @param userName user name
     * @param newPassword user password
     * @return true if password was change
     */
    public boolean changePassword(String userName, String newPassword) {
        if (userData.containsKey(userName)) {
            for (String key : userData.get(userName).keySet()) {
                userData.get(userName).put(key,newPassword);
            }
            return true;
        }
        return false;
    }

    /**check is user exist
     *
     * @param userName user name
     * @return true if user exist
     */
    public boolean isAlreadyExists(String userName) {
        return userData.containsKey(userName);
    }

    /**show all users with logins and password
     *
     * @return info about users
     */
    public String showUsers() {
        StringBuilder stringBuilder = new StringBuilder();
        userData.forEach((key, value) -> {
            stringBuilder.append(key).append(" -> ");
            value.forEach((key1,value1) -> stringBuilder.append("login: ").append(key1).
                            append(" password: ").append(value1).append("\n\n"));
        });
        return stringBuilder.toString();
    }

}
