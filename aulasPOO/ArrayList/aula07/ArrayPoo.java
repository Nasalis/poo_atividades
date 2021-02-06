package aulasPOO.ArrayList.aula07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayPoo {
    public static void main(String[] args) {
        // Array Estático
        String[] daysweeks = {"dom", "seg", "ter", "qua", "qui", "sex", "sab"};
    
        for(String dia : daysweeks)
            System.out.println(dia + " ");
        System.out.println("");

        System.out.println(Arrays.asList(daysweeks));
    }
}

class ListaTest {
    public static void main(String[] args) {
        String[] daysweeks = {"dom", "seg", "ter", "qua", "qui", "sex", "sab"};
        List<String> lista_dds = Arrays.asList(daysweeks); // collection
        System.out.println(lista_dds);

        // Esse objeto não suporta adição
        List<String> cores = Arrays.asList("blue", "yellow", "pink", "silver", "gold");
        System.out.println(cores);
    }
}


class ArrayListTest {
    public static void main(String[] args) {
        // List<String> cores = Arrays.asList("blue", "yellow", "pink", "silver", "gold");
        
        ArrayList<String> alCores = new ArrayList<>();
        alCores.add("red");
        alCores.add("blue");
        alCores.add("yellow");
        System.out.println(alCores);


        ArrayList<String> times = new ArrayList<String>(Arrays.asList("Ferroviária", "Aquele lá"));
        System.out.println(times);
        
        for(int i = 0; i < times.size(); i++){ // não funciona com []
            times.set(i, "Ceará");
        }
        System.out.println(times);
    }
}