package projetosPOO.semana14;

public class Notify {
    String chatId;
    int unreadCount;

    public Notify(String chatId) {
        this.chatId = chatId;
        this.unreadCount = 0;
    }

    public void addCount() {
        unreadCount++;
    }

    public String toString() {

        String notification = unreadCount == 0 ?  "" : ("(" + Integer.toString(unreadCount) + ")");
        return chatId + notification;
    }
}
