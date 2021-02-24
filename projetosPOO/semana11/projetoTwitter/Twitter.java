package projetosPOO.semana11.projetoTwitter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class Tweet {
    int idTw;
    String userName;
    String msg;
    TreeMap<String, String> likes;

    public Tweet(int idTw, String userName, String msg) {
        this.idTw = idTw;
        this.userName = userName;
        this.msg = msg;
        this.likes = new TreeMap<>();
    }

    public TreeMap<String, String> giveLike(String username) {
        likes.put(username, username);
        return likes;
    }

    public String toString() {
        StringBuilder likesNames = new StringBuilder();
        if(!likes.isEmpty()) {
            likesNames.append("[ ");
            for(String name : likes.values()) {
                likesNames.append(name + " ");
            }
            likesNames.append("]");
        }
        return "" + this.idTw + ":" + this.userName + "(" + this.msg + ")" + " " + likesNames;
    }
}


class User {
    String username;
    int unReads;
    ArrayList<Tweet> timeline;
    TreeMap<Integer, Tweet> timelineOrdenered;
    ArrayList<Tweet> myTweets;

    TreeMap<String, User> followers;
    TreeMap<String, User> following;

    public User(String username) {
        this.username = username;
        this.unReads = 0;
        this.timeline = new ArrayList<>();
        this.myTweets = new ArrayList<>();
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.timelineOrdenered = new TreeMap<>();
    }

    public void followUser(User other) {
        if(following.containsKey(other.username)) {
            System.out.println("fail: " + username + " já segue " + other.username);
            return;
        }
        this.following.put(other.username, other);
        other.followers.put(this.username, new User(this.username));
    }

    public void unfollowUser(User other) {
        this.following.remove(other.username);
        other.followers.remove(this.username);
    }

    public void twittar(Tweet tweet) {
        myTweets.add(tweet);
        timeline.add(tweet);
        for(User follower : followers.values()) {
            follower.timeline.add(tweet);
            follower.unReads++;
            // System.out.println(follower.timeline);
        }
    }
        

    public void darLike(String username, int idTw) {
        if(this.timelineOrdenered.get(idTw) == null) {
            throw new RuntimeException("fail: tweet não existe");
        }
        Tweet tweet = this.timelineOrdenered.get(idTw);
        tweet.giveLike(username);
    }
        

    public TreeMap<Integer, Tweet> updateTimeLineOrdenered() {
        
        for(User user : following.values()) {
            for(Tweet tweet : user.myTweets) {
                timelineOrdenered.put(tweet.idTw, tweet);
            }
        }

        for(Tweet tweet : timeline) {
            timelineOrdenered.put(tweet.idTw, tweet);
        }

        return timelineOrdenered;
    }
        
    public void getTimeline() {
        for(Tweet timeline : updateTimeLineOrdenered().values()) {
            System.out.println(timeline);
        }
        System.out.println();
    }
        
    public String toString() {
        return this.username;
    }
        
}

public class Twitter {
    TreeMap<String, User> repUsers;
    TreeMap<Integer, Tweet> repTweet;

    int nextTwId;

    public Twitter() {
        repUsers = new TreeMap<>();
        repTweet = new TreeMap<>();
        nextTwId = 0;
    }

    public void sendTweet(String username, String msg) {
        if(!repUsers.containsKey(username)) {
            System.out.println("fail: usuário não cadastrado no sistema");
            return;
        }
        Tweet tweet = new Tweet(this.nextTwId, username, msg);
        repUsers.get(username).twittar(tweet);
        repTweet.put(this.nextTwId, tweet);
        nextTwId++;
    }


    public void addUser(String username) {
        if(repUsers.isEmpty()) {
            repUsers.put(username, new User(username));
            return;
        }else if(repUsers.containsKey(username)) {
            System.out.println("fail: usuario já cadastrado no sistema");
            return;
        }
        repUsers.put(username, new User(username));
    }

    public User getUser(String username) {
        if(repUsers.get(username) == null) {
            throw new RuntimeException("fail: usuário não encontrado");
        }else{
            User user;
            user = repUsers.get(username);
            return user;
        }
    }

    public void follow(String from, String to) {
        getUser(from).followUser(getUser(to));
    }
    public void unfollow(String from, String to) {
        getUser(from).unfollowUser(getUser(to));
    }

    private String listInfoProfile(TreeMap<String, User> infoProfile) {
        StringBuilder output = new StringBuilder();
        output.append("[ ");
        for(User info: infoProfile.values())
            output.append(info.username + " ");
        output.append("]\n");
        return output.toString();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        for(User user : repUsers.values()) {
            output.append(user.username+"\n");
            output.append("   Following ");
            output.append(listInfoProfile(user.following));
            output.append("   Followers ");
            output.append(listInfoProfile(user.followers));
        }

        return output.toString();
    }
       
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Twitter twitter = new Twitter();

        while(true){

            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");

            try {
                if (ui[0].equals("end"))
                    break;
                else if (ui[0].equals("addUser")) {
                    twitter.addUser(ui[1]);
                } else if (ui[0].equals("show")) {
                    System.out.print(twitter);
                } else if (ui[0].equals("follow")) {//goku tina
                    twitter.follow(ui[1], ui[2]);
                }
                else if (ui[0].equals("twittar")) {//goku msg
                    String username = ui[1];
                    String msg = "";
                    for(int i = 2; i < ui.length; i++)
                        msg += ui[i] + " ";
                    twitter.sendTweet(username, msg);
                }
                else if (ui[0].equals("timeline")) {//goku tina
                    if(twitter.repUsers.get(ui[1]) == null) {
                        throw new RuntimeException("fail: usuário não encontrado");
                    }else{
                        User user = twitter.repUsers.get(ui[1]);
                        user.getTimeline();
                    }
                }
                else if (ui[0].equals("like")) {//goku tina
                    User user = twitter.repUsers.get(ui[1]);
                    int index = Integer.parseInt(ui[2]);
                    user.darLike(user.username, index);
                }else if (ui[0].equals("unfollow")) {//goku tina
                    User user = twitter.repUsers.get(ui[1]);
                    User user2 = twitter.repUsers.get(ui[2]);
                    twitter.unfollow(user.username, user2.username);
                }else{
                    System.out.println("fail: comando invalido");
                }
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }

        scanner.close();
    }
}