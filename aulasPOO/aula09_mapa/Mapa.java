package aulasPOO.aula09_mapa;

import java.util.Map.Entry;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;


class Pass {
    String name;
    int idade;
    final int idadePref = 60;

    public Pass(String name, int idade) {
        this.name = name;    
        this.idade = idade;        
    }

    public String toString() {
        return name + ":" + idade; 
    }
}

public class Mapa {
    public static void main(String[] args) {
        TreeMap<String, Pass> pessoas = new TreeMap<>();
        pessoas.put("Camilla", new Pass("Camilla", 18));
        pessoas.put("Nátaly", new Pass("Nátaly", 19));
        pessoas.put("Davi", new Pass("Davi", 18));
        // Na forma abaixo, o comando sobescreve
        pessoas.put("Davi", new Pass("Davi", 20));

        System.out.println(pessoas);

        System.out.println(pessoas.containsKey("Camilla"));

        Pass passNataly = pessoas.get("Nátaly");
        Pass passFernando = pessoas.get("Fernando"); // null

        // for(int i = 0; i < pessoas.size(); i++) // acesso aleatório não existe em maps

        TreeSet<Integer> conj = new TreeSet<>(Arrays.asList(4,1,2,4,5,7,3,2,3));

        System.out.println(conj);

        // Set = sem repetição
        for(Pass values : pessoas.values()) {
            System.out.println(values);
        } 

        for(Entry<String, Pass> par : pessoas.entrySet())
            System.out.println(par.getKey() + " " + par.getValue());
            
        

        // TreeMap ou HashMap
            // TreeMap -> Árvore -> Chave Ordenável -> Menos Memória -> desempenho um pouco pior
            // HashMap -> Hash -> Chave Hasheavel -> Maior Memória - Desempenho melhor
            //             |=> índice espalhado na tabela do vetor
            //             |=> Procura evitar a colisão de dados ocupados em locais próximos
    }
}
