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
    ArrayList<Cliente> list;

    int tamanho;

    Cinema(int tamanho) {
        this.tamanho = tamanho;
        this.clientes = new ArrayList<>();
        this.list = new ArrayList<Cliente>(Collections.nCopies(tamanho, null));
    }

    void reservar(Cliente cliente, int indice) {
        if(clientes.get(indice).id.equals("")) {
            clientes.set(indice, cliente);
        }else if(clientes.get(indice).id.equals(cliente.id)){
            System.out.println("fail: cliente ja esta no cinema");
        }else if(!clientes.get(indice).id.equals("")) {
            System.out.println("fail: cadeira ja esta ocupada");
        }
    }

    void cancelar(String nome) {

        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).id.equals(nome)) {
                clientes.remove(i);
                System.out.println(nome + " saiu");
            }
        }

    }

    void showInfo(ArrayList<Cliente> clientes) {
        System.out.print("[ ");
        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).id.equals("")) {
                System.out.print(" -");
            }else{
                System.out.print(clientes.get(i).id + ":" + clientes.get(i).fone + " ");
            }
        }
        System.out.print(" ]\n");
    }
 
    public String toString() {
        String infoCadeiras = "";

        for(int i = 0; i < tamanho; i++) {
            if(list.get(i) == null) {
                clientes.add(new Cliente("",""));
            }
        }

        return infoCadeiras;
      
    }


    public static void main(String[] args) {
        
        Cinema cinema = new Cinema(5);
        System.out.println(cinema.list);
        System.out.println(cinema);
        cinema.reservar(new Cliente("davi", "3232"), 0);
        cinema.reservar(new Cliente("eliana", "3131"), 2);
        cinema.reservar(new Cliente("edvaldo", "4242"), 1);
        cinema.reservar(new Cliente("davi", "3232"), 0);
        cinema.showInfo(cinema.clientes);
        cinema.cancelar("davi");
        cinema.showInfo(cinema.clientes);

    }
}
