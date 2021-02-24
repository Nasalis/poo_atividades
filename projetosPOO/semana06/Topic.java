package projetosPOO.semana06;

import java.util.ArrayList;
import java.util.Collections;

class Pass implements Comparable<Pass> {
    String name;
    int age;

    public Pass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Pass pass) {
        return name.compareTo(pass.name);
    }

    public String toString() {
        return name + ":" + age;
    }
}

public class Topic {
    ArrayList<Pass> chairs;
    int amountPref;
    int capacity;
    int amountPass = 0;
    

    Topic(int capacity, int amountPref) {  
        this.capacity = capacity;
        this.amountPref = amountPref;
        chairs = new ArrayList<Pass>(Collections.nCopies(capacity, null));
    }

    boolean adicionarPassageiro(Pass pass) {
        if(amountPass == capacity) {
            System.out.println("Topic lotada");
            return false;
        }

        if(pass.age >= 60) {
            for(int i = 0; i < amountPref; i++) {
                if(chairs.get(i) == null) {
                    chairs.set(i, pass);
                    System.out.println(pass.name + " entrou na topic");
                    amountPass++;
                    return true;       
                }
            }
        }else if(pass.age < 60){
            for(int j = amountPref; j <= capacity-1; j++) {
                if(chairs.get(j) == null) {
                    chairs.set(j, pass);
                    System.out.println(pass.name + " entrou na topic");
                    amountPass++;
                    return true;       
                }
            }
        }

        for(Pass chair : chairs) {
            if(chair != null && chair.name.equals(pass.name)) {
                System.out.println(pass.name + " ja esta na topic");
                return false;
            }
        }

        return false;
    }

    void desembarcarPassageiro(String name) {
        for(Pass chair : chairs) {
            if(chair != null && chair.name.equals(name)) {
                int index = chairs.indexOf(chair);
                chairs.set(index, null);
                amountPass--;
                System.out.println(name + " desembarcou");
                return; 
            } 
        }

        System.out.println(name + " nao esta na topic");
    }

    public String toString() {
        String output = "[ ";

        for(int i = 0; i < amountPref; i++) {
            if(chairs.get(i) == null)
                output += "@ ";
            else
                output += "@" + chairs.get(i) + " ";
        }

        for(int j = amountPref; j <= capacity - 1; j++) {
            if(chairs.get(j) == null)
                output += "= ";
            else
                output += "=" + chairs.get(j) + " ";
        }
        return output += "]";
    }

    public static void main(String[] args) {
        Topic topic = new Topic(5, 2);
        System.out.println(topic);
        topic.adicionarPassageiro(new Pass("beatriz", 18));
        topic.adicionarPassageiro(new Pass("leticia", 18));
        topic.adicionarPassageiro(new Pass("jorge", 20));
        topic.adicionarPassageiro(new Pass("jorge", 20));
        topic.adicionarPassageiro(new Pass("amanda", 20));
        System.out.println(topic);
        topic.adicionarPassageiro(new Pass("rodrigo", 66));
        topic.adicionarPassageiro(new Pass("marcos", 76));
        topic.adicionarPassageiro(new Pass("amanda", 80));
        System.out.println(topic);
        topic.desembarcarPassageiro("jorge");
        topic.desembarcarPassageiro("marcos");
        topic.desembarcarPassageiro("fernando");
        System.out.println(topic);
    }
}
