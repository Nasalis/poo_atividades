package projetosPOO.semana10;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeMap;

class Fone {
    String id;
    String number;

    public Fone(String id, String number) {
        this.id = id;    
        this.number = number;     
    }

    public static boolean validate(String fone) {
        String validValues = "1234567890-()";

        for(int i = 0; i < fone.length() ; i++) {
            if(validValues.indexOf(fone.charAt(i)) == -1) {
                System.out.println("Número " + fone + " inválido");
                return false;
            }
        }

        System.out.println("Número " + fone + " registrado");
        return true;
    }

    public String toString() {
        return id + ":" + number;
    }
}

class Contato {
    String name;
    List<Fone> numbers;

    public Contato(String name) {
        this.name = name;
        numbers = new ArrayList<>();
    }


    public String toString() {
        String output = "";
        output += "- " + name;
        for(int i = 0; i < numbers.size(); i++) {
            output += " [" + i + ":" + numbers.get(i).id + ":" + numbers.get(i).number + "]\n";
        }
        return output;
    }

}

class ContatoPlus extends Contato {
    boolean starred;

    public ContatoPlus(String name) {
        super(name);
        starred = false;
    }

    @Override
    public String toString() {
        String output = "";
        output += (starred == true) ? "@ " : "- ";
        output += name;
        for(int i = 0; i < numbers.size(); i++) {
            output += " [" + i + ":" + numbers.get(i).id + ":" + numbers.get(i).number + "]";
        }
        return output;
    }
}

class AgendaPlus extends Agenda {
    static TreeMap<String, ContatoPlus> bookmarks;

    public AgendaPlus() {
        bookmarks = new TreeMap<>();
    }

    public static void bookMark(String id) { 
        bookmarks = new TreeMap<>();


        if(contatos.containsKey(id)) {
            ContatoPlus contatoPlus = (ContatoPlus) contatos.get(id);
            contatoPlus.starred = true;
            bookmarks.put(contatoPlus.name, contatoPlus);
        }else{
            System.out.println("Contato não encontrado. Verifique sua agenda");
            return;
        }
    }

    public static void unBookMark(String id) {

        if(contatos.containsKey(id)) {
            ContatoPlus contatoPlus = (ContatoPlus) contatos.get(id);
            contatoPlus.starred = false;
            bookmarks.remove(id);
        }else{
            System.out.println("Contato não encontrado. Verifique sua agenda");
            return;
        }
        
    }

}

public class Agenda {

    static TreeMap<String, Contato> contatos;

    public Agenda() {
        contatos = new TreeMap<>();
    }

    private TreeMap<String, Contato> getContatos() {
        return contatos;
    }


    public void addContato(ContatoPlus contato, List<Fone> fones){ 
        if(contatos.isEmpty() || contatos.get(contato.name) == null){
            contatos.put(contato.name, new ContatoPlus(contato.name));
            for(int i = 0; i < fones.size(); i++) {
                if(Fone.validate(fones.get(i).number))
                    contatos.get(contato.name).numbers.add(fones.get(i));
            }
            return;
        }
        if(contatos.get(contato.name).name.equals(contato.name)) {
            for(int i = 0; i < fones.size(); i++) {
                contatos.get(contato.name).numbers.add(fones.get(i));
            }
            return;
        }
        contatos.put(contato.name, new ContatoPlus(contato.name));
        for(int i = 0; i < fones.size(); i++) {
            contatos.get(contato.name).numbers.add(fones.get(i));
        }
    }

    public void removeFone(String name, int index) {

        int tam = contatos.get(name).numbers.size();
        String number = contatos.get(name).numbers.get(index).number;

        if(index < 0 || index > tam) {
            System.out.println("Número não encontrado\n");
            return;
        }
        contatos.get(name).numbers.remove(index);
        System.out.println("Número " + number + " de " + name + " foi removido\n"); 
    }

    public void removeContact(String name) {
        if(contatos.get(name) == null) {
            System.out.println("O contato " + name + " não existe\n");
            return;
        }
        contatos.remove(name);
        System.out.println("Contato " + name + " foi removido\n");
    }

    public TreeMap<String, Contato> search(String caracteres) {

        TreeMap<String, Contato> contatosFiltered = new TreeMap<>();

        for(Contato contato : contatos.values()) {
            if(contato.name.contains(caracteres)) {
                contatosFiltered.put(contato.name, contato);
            }else{
                for(int i = 0; i < contato.numbers.size(); i++)
                    if(contato.numbers.get(i).number.contains(caracteres))
                        contatosFiltered.put(contato.name, contato);
            }
        }

        if(!contatosFiltered.isEmpty())
            return contatosFiltered;
        System.out.println("Nenhum valor encontrado");
        return contatos;
    }

    public void star(String name) {
        if(getContatos().containsKey(name)) {
            AgendaPlus.bookMark(name);
        }
    }

    public void unStar(String name) {
        if(getContatos().containsKey(name)) {
            AgendaPlus.unBookMark(name);
        }
    }

    public Collection<ContatoPlus> getStarred() {
        TreeMap<String, ContatoPlus> fav = new TreeMap<>();
        for(Contato contact : contatos.values()) {
            if(contact instanceof ContatoPlus) {
                ContatoPlus contatoPlus = (ContatoPlus) contact;
                if(contatoPlus.starred == true)
                    fav.put(contatoPlus.name, contatoPlus);
            }
        }
        return fav.values();
    };

    public String toString() {
        String output = "";
        output += "\n";
        for(Contato contato : contatos.values()) {
            output += contato + "\n";
        }
        return output;
    }

    public static void main(String[] args) {
        Agenda agenda = new AgendaPlus();

        agenda.addContato(new ContatoPlus("leticia"), Arrays.asList(new Fone("tim", "23d123"), new Fone("cla", "9999")));
        agenda.addContato(new ContatoPlus("leticia"), Arrays.asList(new Fone("tim", "66223"), new Fone("cla", "9779")));
        agenda.addContato(new ContatoPlus("jardeane"), Arrays.asList(new Fone("tim", "J66223"), new Fone("cla", "J9779")));
        agenda.addContato(new ContatoPlus("jardeane"), Arrays.asList(new Fone("tim", "J92102"), new Fone("cla", "J2252")));

        agenda.addContato(new ContatoPlus("eva"), Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContato(new ContatoPlus("ana"), Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContato(new ContatoPlus("bia"), Arrays.asList(new Fone("viv", "5454")));
        agenda.addContato(new ContatoPlus("ana"), Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));

        System.out.println(agenda);

        agenda.removeFone("leticia", 1);

        System.out.println(agenda);

        agenda.removeContact("ana");

        System.out.println(agenda);

        for(Contato contato : agenda.search("le").values()) {
            System.out.println("--- Conteúdo filtrado por Nome ---");
            System.out.println(contato+"\n");
        }

        for(Contato contato : agenda.search("85").values()) {
            System.out.println("--- Conteúdo filtrado por Número ---");
            System.out.println(contato+"\n");
        }

        System.out.println(agenda);

        agenda.star("leticia");
        agenda.star("eva");


        for(ContatoPlus fav : agenda.getStarred()){
            System.out.println(fav);
        }
    
        System.out.println(agenda);

        agenda.unStar("eva");

        for(ContatoPlus fav : agenda.getStarred()){
            System.out.println(fav);
        }

        System.out.println(agenda);

        
    }
}





