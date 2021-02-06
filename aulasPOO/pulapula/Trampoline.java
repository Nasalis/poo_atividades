package aulasPOO.pulapula;

import java.util.ArrayList;

class Kid {
    String name;
    int age;

    Kid(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class Trampoline {

    ArrayList<Kid> kidsWaiting;
    ArrayList<Kid> kidsPlaying;

    public Trampoline() {
        this.kidsWaiting = new ArrayList<>();
        this.kidsPlaying = new ArrayList<>();
    }

    public void waitingList(Kid kid) {
        kidsWaiting.add(0, kid);
    }

    public void playingList() {
        kidsPlaying.add(0, kidsWaiting.get(0));
        kidsWaiting.remove(0);
    }

    public void leavingTrampoline() {
        if(kidsPlaying.isEmpty())
            return;
        int pos = kidsPlaying.size()-1;
        kidsWaiting.add(kidsPlaying.get(pos));
        kidsPlaying.remove(pos);
    }

    public void callingKid(String name) {
        for(Kid kid : kidsPlaying) {
            if(kid.name.equals(name)) {
                int index = kidsPlaying.indexOf(kid);
                kidsPlaying.remove(index);
                System.out.println(name = " saiu do Pula-Pula");
            }
        }
        System.out.println("Criança não encontrada");
        return;
    }

    public String toString() {
        String output = ""; 
        String outputP = "";

        for(int i = 0; i < kidsWaiting.size(); i++) {
            output += kidsWaiting.get(i) + "\n";
        }

        for(int i = 0; i < kidsPlaying.size(); i++) {
            outputP += kidsPlaying.get(i) + "\n";
        }
        return "Fila de espera:\n" + output + "\nPula-Pula:\n" + outputP;
    }

    public static void main(String[] args) {
        Trampoline trampoline = new Trampoline();
        trampoline.waitingList(new Kid("Mario", 5));
        trampoline.waitingList(new Kid("Livia", 2));
        trampoline.waitingList(new Kid("Luana", 1));
        trampoline.waitingList(new Kid("Fábio", 4));
        trampoline.waitingList(new Kid("Rodolfo", 10));
        trampoline.waitingList(new Kid("João", 7));
        System.out.println(trampoline);
        trampoline.playingList();
        trampoline.playingList();
        trampoline.playingList();
        System.out.println(trampoline);
        trampoline.leavingTrampoline();
        System.out.println(trampoline);
        trampoline.callingKid("Fábio");
        System.out.println(trampoline);
    }
}
