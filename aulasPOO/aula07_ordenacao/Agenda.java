package aulasPOO.aula07_ordenacao;

import java.util.ArrayList;
import java.util.Comparator;

class Pessoa implements Comparable<String> {
    String id;
    int idade;

    public Pessoa(String id, int idade) {
        this.id = id;
        this.idade = idade;
    }

    public String toString() {
        return id + ":" + idade;
    }

    @Override
    public int compareTo(String arg0) {
        return this.id.compareTo(arg0);
    }    
}

class ComparadorPessoas implements Comparator<Pessoa> {
    @Override

    public int compare(Pessoa arg0, Pessoa arg1) {
        if(arg0 == null)
            return -1;
        if(arg1 == null)
            return 1;
        int resultado = arg0.id.compareTo(arg1.id);
        if(resultado != 0)
            return resultado;
        return Integer.compare(arg0.idade, arg1.idade);
    }
}


public class Agenda {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Davi", 18));
        pessoas.add(new Pessoa("Letícia", 18));
        pessoas.add(new Pessoa("Beatriz", 19));
        pessoas.add(new Pessoa("Jardeane", 24));
        pessoas.add(new Pessoa("Nátaly", 20));
        pessoas.add(new Pessoa("Camila", 17));

        System.out.println(pessoas);

        for(Pessoa pessoa: pessoas) {
            if(pessoa.id.equals("Davi"))
                System.out.println(pessoa);
        }
        
        System.out.println(pessoas.contains(new Pessoa("Davi", 18)));

        pessoas.sort(new ComparadorPessoas());

        System.out.println(pessoas);
    }
}
