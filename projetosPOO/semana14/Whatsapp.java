package projetosPOO.semana14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;


class Msg {
    String userId;
    String text;

    public Msg(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }

    public String toString() {
        return this.userId + ": " + this.text;
    }
}

class Inbox {
    User user;
    List<Msg> mensages;

    public Inbox(User user) {
        this.user = user;
        this.mensages = new ArrayList<>();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(user);
            for(Msg msg : mensages) {
                output.append(msg);
            }
        return output.toString();
    }
}

class Notify {
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

class User {
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

class Chat {
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

public class Whatsapp {

    TreeMap<String, Chat> repChat;
    TreeMap<String, User> repUser;
    int indexInBox;

    public Whatsapp() {
        this.repChat = new TreeMap<>();    
        this.repUser = new TreeMap<>();
        this.indexInBox = 0;        
    }

    public boolean verifyUser(String userId) {
        return repUser.containsKey(userId) ? true : false;
    }

    public boolean verifyChat(String chatId) {
        return repChat.containsKey(chatId) ? true : false;
    }

    public void createNotifyChats(User user) {

        if(user.notify.isEmpty()) {
            for(Chat chatNotify : user.chats.values()) {
                user.notify.add(new Notify(chatNotify.id));
            }
        }
        else{
            for(Chat chatNotify : user.chats.values()) {
                for(int i = 0; i < user.notify.size(); i++) {
                    boolean verifyNotifyChat = user.notify.get(i).chatId.equals(chatNotify.id);
                    if(!verifyNotifyChat)
                        user.notify.add(new Notify(chatNotify.id));
                }
            }
        }
    }

    public void createUser(String userId) {

        if(!repUser.isEmpty()) {
            if(verifyUser(userId))
                System.out.println("fail: usuário " + userId + " já existe");
        }
        repUser.put(userId, new User(userId));
    }

    public String allUsers() {
        StringBuilder output = new StringBuilder();
            output.append("[ ");
            for(User user : repUser.values())
                output.append(user + " ");
            output.append("]");

        return output.toString();
    }

    public void createChat(String userId, String chatId) {

        if(!repChat.isEmpty()) {
            if(repChat.containsKey(chatId)) {
                System.out.println("fail: chat " + chatId + " já existe");
                return;
            }
        }

        Chat chat = new Chat(chatId);
        User user = repUser.get(userId);
        String id = repUser.get(userId).id;

        repChat.put(chatId, chat);
        repChat.get(chatId).users.put(id, user);

        if(verifyUser(userId)) {
            user.addChat(chatId, chat);
            user.getChat(chatId).addByInvite(userId, user);
        }

        createNotifyChats(user);
    }


    public String getChatsUser(String userId) {

        StringBuilder output = new StringBuilder();

        if(verifyUser(userId)) {
            output.append("[ ");
            for(Chat chat : repUser.get(userId).chats.values()) {
                output.append(chat.id + " ");
            }
            output.append("]");
        }
        return output.toString();
    }

    public String getUsersChat(String chatId) {

        StringBuilder output = new StringBuilder();

        if(verifyChat(chatId)) {
            output.append("[ ");
            for(User user : repChat.get(chatId).users.values()) {
                output.append(user + " ");
            }
            output.append("]");
        }
        return output.toString();
    }

    public String getNotifyUser(String userId) {

        StringBuilder output = new StringBuilder();

        if(!verifyUser(userId)) {
            System.out.println("fail: usuário não existe");
            return null;
        }

        output.append(repUser.get(userId).notify); 

        return output.toString();
    }

    public void addByInvite(String guessId, String inviteId, String chatId) {
        if(!verifyUser(guessId) || !verifyUser(inviteId)) {
            System.out.println("fail: usuário não existe");
            return;
        }else if(!repChat.get(chatId).users.containsKey(guessId)) {
            System.out.println("fail: user " + guessId + " não está no chat " + chatId);
            return;
        }

        User userGuess = repUser.get(guessId);
        User userInvite = repUser.get(inviteId);
        Chat chat = userGuess.chats.get(chatId);

        repChat.get(chatId).users.put(userInvite.id, userInvite);
        chat.addByInvite(userInvite.id, userInvite);
        userInvite.addChat(chat.id, chat);

        createNotifyChats(userInvite);
        
    }

    public void removeUserChat(String userId, String chatId) {
        
        if(!verifyUser(userId) || !verifyChat(chatId)) {
            System.out.println("fail: usuário ou grupo não existem");
            return;
        }

        User user = repUser.get(userId);

        repChat.get(chatId).users.remove(userId);
        user.removeChat(chatId);

    }

    public void sendMessage(String userId, String chatId, String message) {

        if(!verifyUser(userId) || !verifyChat(chatId)) {
            System.out.println("fail: usuário ou grupo não existem");
            return;
        }

        User user = repUser.get(userId);

        indexInBox++;
        int index = indexInBox;

        user.getChat(chatId).inboxes.put(index, new Inbox(user));
        user.getChat(chatId).inboxes.get(index).mensages.add(new Msg(userId, message));
        
        for(User otherUser : repUser.values()) {
            if(!otherUser.equals(user)) {
                for(int i = 0; i < otherUser.notify.size(); i++) {
                    if(otherUser.notify.get(i).chatId.equals(chatId)){
                        otherUser.notify.get(i).addCount();
                    }
                }
            }
        }

    }

    public String readMessageUser(String userId, String chatId) {
        StringBuilder output = new StringBuilder();
        int countReadMessages = 0;

        if(!repChat.get(chatId).verifyUser(userId)) {
            System.out.println("fail: user " + userId + " não está no " + chatId);
            return "";
        }

        User user = repUser.get(userId);
        Collection<Inbox> inboxes = repUser.get(userId).getChat(chatId).inboxes.values();

        for(Inbox inbox : inboxes) {
            if(!inbox.user.equals(user)) {
                output.append(inbox.mensages +"\n");
                countReadMessages++;
            }
        }

        for(Inbox inbox : inboxes) {
            if(inbox.user.equals(user)) {
                for(Notify notify : inbox.user.notify) {
                    if(notify.unreadCount > 0) {
                        notify.unreadCount -= countReadMessages;
                        if(notify.unreadCount < 0) 
                            notify.unreadCount = 0;
                    }
                } 
            }
        }


        return output.toString();
    }

    public static void main(String[] args) {

        Whatsapp whatsapp = new Whatsapp();
        whatsapp.createUser("goku");
        whatsapp.createUser("sara");
        whatsapp.createUser("tina");
        whatsapp.createUser("sara");
        
        System.out.println(whatsapp.allUsers());

        System.out.println("-----------------");

        whatsapp.createChat("goku", "guerreiros");
        whatsapp.createChat("goku", "homens");
        whatsapp.createChat("sara", "familia");

        whatsapp.createChat("sara", "guerreiros");

        System.out.println("-----------------");

        System.out.println(whatsapp.getChatsUser("goku"));
        //[guerreiros homens]
        System.out.println(whatsapp.getChatsUser("sara"));
        //[familia]
        System.out.println(whatsapp.getChatsUser("tina"));
        //[]

        System.out.println("-----------------");


        whatsapp.addByInvite("goku", "sara", "guerreiros");
        whatsapp.addByInvite("sara", "tina", "guerreiros");
        whatsapp.addByInvite("tina", "goku", "familia");
        //fail: user tina nao esta em chat familia
        System.out.println(whatsapp.getChatsUser("sara"));
        //[guerreiros familia]
        System.out.println(whatsapp.getChatsUser("tina"));
        //[guerreiros]
        System.out.println(whatsapp.getChatsUser("goku"));
        //[guerreiros homens]

        System.out.println("-----------------");

        System.out.println(whatsapp.getUsersChat("guerreiros"));
        //[goku sara tina]
        System.out.println(whatsapp.getUsersChat("familia"));
        //[sara]

        System.out.println("-----------------");

        //case leaving
        whatsapp.removeUserChat("sara", "guerreiros");
        System.out.println(whatsapp.getUsersChat("guerreiros"));
        //[goku tina]
        System.out.println(whatsapp.getChatsUser("sara"));
        //[familia]

        System.out.println("-----------------");

        whatsapp.sendMessage("goku", "guerreiros", "oi, eu sou o goku");
        whatsapp.sendMessage("tina", "guerreiros", "oi goku");


        System.out.println(whatsapp.getNotifyUser("goku"));
        //[guerreiros(1) homens]
        System.out.println(whatsapp.getNotifyUser("tina"));
        //[guerreiros(1)]


        System.out.println("-----------------");


        System.out.println(whatsapp.readMessageUser("goku", "guerreiros"));
        //[tina: oi goku]

        System.out.println(whatsapp.readMessageUser("tina", "guerreiros"));
        //[goku: oi, eu sou o goku]

        System.out.println(whatsapp.readMessageUser("sara", "guerreiros"));
        //fail: user sara nao esta no chat guerreiros

        System.out.println(whatsapp.getNotifyUser("goku"));
        //[guerreiros(1) homens]
        System.out.println(whatsapp.getNotifyUser("tina"));
        //[guerreiros(1)]

        whatsapp.sendMessage("goku", "guerreiros", "vamos sair tina?");
        whatsapp.sendMessage("tina", "guerreiros", "voce ta com fome goku?");
        whatsapp.sendMessage("goku", "guerreiros", "to com saudade de voce.");

        System.out.println(whatsapp.getNotifyUser("tina"));
        //[guerreiros(2)]
        System.out.println(whatsapp.getNotifyUser("goku"));
        //[guerreiros(1) homens]

        System.out.println(whatsapp.readMessageUser("goku", "guerreiros"));
        //[tina: voce ta com fome goku?]
        System.out.println(whatsapp.readMessageUser("tina", "guerreiros"));
        //[goku: vamos sair tina?]
        //[goku: to com saudade de voce.]
    }
}