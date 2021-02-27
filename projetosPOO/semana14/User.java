package projetosPOO.semana14;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class User {
    String id;
    TreeMap<String, Chat> chats;
    List<Notify> notify;

    public User(String id) {
        this.id = id;
        this.chats = new TreeMap<>();
        this.notify = new ArrayList<>();
    }

    public Chat getChat(String chatId) {
        return chats.get(chatId);
    }

    public Notify getNotify(String chatId) {

        for(int i = 0; i < notify.size(); i++) {
            if(notify.get(i).chatId.equals(chatId))
                return notify.get(i);
        }

        return null;
    }
    
    public void addChat(String chatId, Chat chat) {
        chats.put(chatId, chat);
    }

    public void removeChat(String chatId) {
        chats.remove(chatId);
    }

    public String toString() {
        return this.id;
    }
}
