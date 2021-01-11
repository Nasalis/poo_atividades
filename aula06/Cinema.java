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
    ArrayList<String> cadeiras;
    ArrayList<Cliente> clientes;
    ArrayList<Cliente> list;

    int tamanho;

    Cinema(int tamanho) {
        this.tamanho = tamanho;
        this.clientes = new ArrayList<>();
        this.cadeiras = new ArrayList<>();
        this.list = new ArrayList<Cliente>(Collections.nCopies(tamanho, null));
    }

    void reservar(Cliente cliente, int indice) {
        if(list.get(indice) == null) {
            cadeiras.add(indice, cliente.id+":"+cliente.fone);
            // clientes.add(indice, cliente);
            clientes.set(indice, cliente);
            // list.remove(indice);
        }
    }

    void cancelar(String nome) {
        for(Cliente cliente : clientes) {
            if(cliente.id.equals(nome)) {
                int index = clientes.indexOf(cliente);
                cadeiras.remove(index);
                System.out.println(nome + " saiu");
            }
        }
    }

    public String toString() {
        String infoCadeiras = "";

    
        for(int i = 0; i < tamanho; i++) {
            if(list.get(i) == null) {
                cadeiras.add("-");
                clientes.add(null);
            }
        }

        return infoCadeiras;
      
    }


    public static void main(String[] args) {
        
        Cinema cinema = new Cinema(5);
        System.out.println(cinema.list);
        System.out.println(cinema);
        System.out.println(cinema.cadeiras);
        System.out.println(cinema.clientes);
        cinema.reservar(new Cliente("davi", "3232"), 0);
        cinema.reservar(new Cliente("eliana", "3131"), 2);
        cinema.reservar(new Cliente("edvaldo", "4242"), 1);
        System.out.println(cinema.cadeiras);

        for(int i = 0; i < cinema.clientes.size(); i++) {
            System.out.print("[ ");
            System.out.print(cinema.clientes.get(i).id + ":" + cinema.clientes.get(i).fone);
            System.out.print(" ]");
        }
        
        cinema.cancelar("davi");
        System.out.println(cinema.cadeiras);
        // System.out.println(cinema);


    }
}
