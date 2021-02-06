package aulasPOO.aula06;

import java.util.ArrayList;

class Pessoa implements Comparable<Pessoa> {
    String id;
    String fone;

    Pessoa(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }

    public String toString() {
        return this.id + ":" + this.fone;
    }

    public int compareTo(Pessoa other) {
        return id.compareTo(other.id);
    }
}

class Sala {
    ArrayList<Pessoa> cadeiras;

    Sala(int tamanho) {
        cadeiras = new ArrayList<>();
        Pessoa pessoa = null;
        for(int i = 0; i < tamanho; i++) {
            cadeiras.add(pessoa);
        }
    }

    public void reservar(Pessoa pessoa, int index) {
        if(index <= cadeiras.size()) {
            cadeiras.set(index, pessoa);
        }else if(cadeiras.get(index) != null) {
            System.out.println("fail: essa cadeira esta ocupada");
        }else if(cadeiras.get(index) == pessoa) {
            System.out.println("fail: essa já está na sala");
        }
    }

    public void cancelar(String id) {
        for(Pessoa cadeira : cadeiras) {
            if(cadeira != null && cadeira.id.equals(id)) {
                int index = cadeiras.indexOf(cadeira);
                cadeiras.set(index, null);
                return;
            }
        }

        System.out.println("Pessoa não encontrada");
    }

    public String toString() {
        String saida = "[ ";
        for(Pessoa pessoa : cadeiras) {
            if(pessoa == null)
                saida += "- ";
            else
                saida += pessoa + " ";
        }
        return saida + "]";
    }

}

public class Cinema_Resolucao {
    public static void main(String[] args) {
        Sala sala = new Sala(6);
        System.out.println(sala);
    }
}
