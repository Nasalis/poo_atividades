package projetoAgendaV3;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.TreeMap;


class Fone {
    String id;
    String number;

    public Fone(String id, String number) {
        this.id = id;    
        this.number = number;     
    }

    public static boolean validate(String number) {
        String validValues = "1234567890-()";

        for(int i = 0; i < number.length(); i++) {
            if(validValues.indexOf(number.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return id + ":" + number;
    }
}

class Contato {
    String name;
    List<Fone> numbers;
    boolean starred;

    public Contato(String name) {
        this.name = name;
        numbers = new ArrayList<>();
        starred = false;
    }


    public String toString() {
        String output = "";
        output += name;
        for(int i = 0; i < numbers.size(); i++) {
            output += " [" + i + ":" + numbers.get(i).id + ":" + numbers.get(i).number + "]";
        }
        return output;
    }

}

public class Agenda {
    TreeMap<String, Contato> contatos;
    TreeMap<String, Contato> bookmarks;

    public Agenda() {
        contatos = new TreeMap<>();
        bookmarks = new TreeMap<>();
    }

    private TreeMap<String, Contato> getContatos() {
        return contatos;
    }


    public void addContato(String name, List<Fone> fones){ 
        if(contatos.isEmpty() || contatos.get(name) == null){
            contatos.put(name, new Contato(name));
            for(int i = 0; i < fones.size(); i++) {
                contatos.get(name).numbers.add(fones.get(i));
            }
            return;
        }
        if(contatos.get(name).name.equals(name)) {
            for(int i = 0; i < fones.size(); i++) {
                contatos.get(name).numbers.add(fones.get(i));
            }
            return;
        }
        contatos.put(name, new Contato(name));
        for(int i = 0; i < fones.size(); i++) {
            contatos.get(name).numbers.add(fones.get(i));
        }
    }

    public void bookMark(String id) {  

        boolean star = false;

        if(getContatos().containsKey(id)) {
            getContatos().get(id).starred = true;
            star = getContatos().get(id).starred;
        }else{
            System.out.println("Contato não encontrado. Verifique sua agenda");
            return;
        }

        if(star) {
            System.out.println("Contato " + id + " favoritado!");
            bookmarks.put(id, contatos.get(id));
            return;
        }
    }

    public void unBookMark(String id) {

        boolean star = true;

        if(getContatos().containsKey(id)) {
            getContatos().get(id).starred = false;
            star = getContatos().get(id).starred;
        }else{
            System.out.println("Contato não encontrado. Verifique sua agenda");
            return;
        }

        if(!star) {
            System.out.println("Contato " + id + " retirado dos favoritos!");
            bookmarks.remove(id);
            return;
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

    public String toString() {
        String output = "";

        for(Contato contato : contatos.values()) {
            output += contato.starred == true ? "@ " : "- ";
            output += contato.name + " ";
                for(int i = 0; i < contato.numbers.size(); i++)
                    output += "[" + i + ":" + contato.numbers.get(i) + "] ";
                output += "\n";
        }

        return output;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.addContato("leticia", Arrays.asList(new Fone("tim", "23123"), new Fone("cla", "9999")));
        agenda.addContato("leticia", Arrays.asList(new Fone("tim", "66223"), new Fone("cla", "9779")));
        agenda.addContato("jardeane", Arrays.asList(new Fone("tim", "J66223"), new Fone("cla", "J9779")));
        agenda.addContato("jardeane", Arrays.asList(new Fone("tim", "J92102"), new Fone("cla", "J2252")));

        agenda.addContato("eva", Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContato("ana", Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContato("bia", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContato("ana", Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));

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

        agenda.bookMark("leticia");
        agenda.bookMark("eva");

        System.out.println(agenda.bookmarks);
    
        System.out.println(agenda);

        agenda.unBookMark("eva");

        System.out.println(agenda.bookmarks);

        System.out.println(agenda);


    }
}
