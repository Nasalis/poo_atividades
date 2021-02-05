package projeto08;

import java.util.*;

class Fone{
    String operadora;
    String numero;

    public Fone(String operadora, String numero){
        this.operadora = operadora;
        this.numero = numero; 
    }
    public String toString(){
        return this.operadora + ":" + this.numero;
    }
}

class Contato {
    String nome;
    ArrayList<Fone> fone;

    public Contato(String nome){
        this.nome = nome;
        this.fone = new ArrayList<>();
    }

    String getNome(){
        return nome;
    }

}

class Agenda{
    ArrayList<Contato> contato;

    public Agenda(){
        this.contato = new ArrayList<>();
    }

    void add(String name, List<Fone> fones){

        if(contato.isEmpty()) {
            contato.add(new Contato(name));
            for(int i = 0; i < contato.size(); i++) {
                if(contato.get(i).nome.equals(name)) {
                    for(int j = 0; j < fones.size(); j++) {
                        contato.get(i).fone.add(fones.get(j));
                    }
                }
            }
        }else{
            for(int i = 0; i<contato.size(); i++){
                if(contato.get(i).nome.equals(name)){
                    for(int j = 0; j < fones.size(); j++) {
                        contato.get(i).fone.add(fones.get(j));
                    }
                    return;
                }
            }

            contato.add(new Contato(name));
            for(int i = 0; i < contato.size(); i++) {
                if(contato.get(i).nome.equals(name)) {
                    for(int j = 0; j < fones.size(); j++) {
                        contato.get(i).fone.add(fones.get(j));
                    }
                }
            }
        }

    }

    public String toString() {
        String saida = "";
        for(int i = 0; i < contato.size(); i++) {
            saida += contato.get(i).nome;
            saida += "[";
            for(int j = 0; j < contato.get(i).fone.size(); j++) {
                saida += "" + i + ":" + contato.get(i).fone.get(j).operadora + ":";
            }
            saida += "]";
            saida += "\n";
        }
        return saida;
    }

}

class Busca{
    public static void main(String[] args){
        Agenda agenda = new Agenda();
        agenda.add("Ana", Arrays.asList(new Fone("tim", "66223"), new Fone("cla", "9779")));
        agenda.add("Mateus", Arrays.asList(new Fone("vivo", "643"), new Fone("oi", "979")));
        agenda.add("Ana", Arrays.asList(new Fone("vivo", "2222")));
        System.out.println(agenda);
    }
}