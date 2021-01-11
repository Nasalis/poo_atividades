package aula06;

import java.util.ArrayList;
import java.util.Collections;

class Cliente {
    String id;
    String fone;

    Cliente(String id, String fone) {
        this.id = id;    
        this.fone = fone;        
    }

}

public class Cinema {
    ArrayList<Cliente> clientes;
    ArrayList<Cliente> cadeiras;
    ArrayList<Cliente> list;

    int tamanho;

    Cinema(int tamanho) {
        this.tamanho = tamanho;
        this.clientes = new ArrayList<>();
        this.cadeiras = new ArrayList<>();
        this.list = new ArrayList<Cliente>(Collections.nCopies(tamanho, null));
    }

    void reservar(Cliente cliente, int indice) {
        clientes.add(indice, cliente);
        cadeiras.add(indice, clientes.get(indice));
        // cadeiras.remove(indice);
    }

    public String toString() {
        String infoCadeiras = "";
        String infoCinemas = "";

        if(clientes.isEmpty()) {
            for(int i = 0; i < tamanho; i++) {
                cadeiras.add(i, new Cliente(" - ", ""));
            }

            infoCadeiras += "[";
            for(int i = 0; i < tamanho; i++) {
                infoCadeiras += cadeiras.get(i).id;
            }
            infoCadeiras += "]";
            return infoCadeiras;
        }
        
        infoCinemas += "[";
        for(int i = 0; i < tamanho; i++) {
            infoCinemas += cadeiras.get(i).id + ":" + cadeiras.get(i).fone + " ";
        }
        infoCinemas += "]";
        return infoCinemas;
      
    }


    public static void main(String[] args) {
        
        Cinema cinema = new Cinema(5);
        System.out.println(cinema.list);
        System.out.println(cinema);
        cinema.reservar(new Cliente("davi", "3232"), 0);
        cinema.reservar(new Cliente("davi", "3232"), 1);
        System.out.println(cinema);


    }
}
