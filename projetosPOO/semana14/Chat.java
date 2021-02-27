package projetosPOO.semana14;

import java.util.TreeMap;

public class Chat {
    String id;
    TreeMap<Integer, Inbox> inboxes;
    TreeMap<String, User> users;

    public Chat(String id) {
        this.id = id;
        this.inboxes = new TreeMap<>();
        this.users = new TreeMap<>();
    }

    public boolean verifyUser(String userID) {
        return users.containsKey(userID) ? true : false;
    }

    public void addByInvite(String userId, User user) {
        users.put(userId, user);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append("--------------------\n");
            output.append("-> " + id+":\n");
            output.append("\nUsers:\n");
            for(User user : users.values()) {
                output.append(user+"\n");
            }
        return output.toString();
    }
}
