package ArrayList;

import java.util.ArrayList;


public class Array {
    public static void main(String[] args) {
        ArrayList<String> users = new ArrayList<String>();


        users.add("A");
        users.add("C");
        users.add("D");

        System.out.println(users);

        users.add(1, "E");

        System.out.println(users);

        boolean existe = users.contains("A");

        if(existe) {
            System.out.println("Elemento existe\n");
        }else{
            System.out.println("Elemento não existe\n");
        }

        int pos = users.indexOf("D");

        if(pos > -1) {
            System.out.println("Elemento existe " + pos + "\n");
        }else{
            System.out.println("Elemento não existe " + pos + "\n");
        }

        System.out.println(users.get(2));

        users.remove(0);
        users.remove("B");

        System.out.println(users);
        System.out.println(users.size());

    }
}
