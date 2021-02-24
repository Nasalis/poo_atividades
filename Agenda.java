import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Fone {
    String label;
    String number;

    public Fone(String label, String number) {
        this.label = label;
        this.number = number;
    }

    public String toString() {
        return label + ":" + number;
    }
}

class Contact {
    public String name;
    public ArrayList<Fone> fones;
    boolean starred;

    public Contact(String name) {
        this.name = name;
        this.starred = false;
        this.fones = new ArrayList<>();
    }

    public void setBookMark(boolean value) {
        this.starred = value;
    }

    public String toString() {
        String output = "";
        String simbol = (this.starred == true) ? "@" : "-";
        output += simbol + " " + name + " ";
        for(int i = 0; i < fones.size(); i++) {
            output +=  "[" + i + ":" + fones.get(i) + "]";
        }
        output += "\n";

        return output;
    }
    
}

public class Agenda {
    TreeMap<String, Contact> contacts;
    TreeMap<String, Contact> bookmark;

    public Agenda() {
        this.contacts = new TreeMap<>();
        this.bookmark = new TreeMap<>();
    }

    public TreeMap<String, Contact> getBookMarks() {
        return this.bookmark;
    }

    public void addContact(String name, List<Fone> fones) {
        // contacts.add(new Contact(name));

        if(contacts.isEmpty()) {
            contacts.put(name, new Contact(name));
            for(int i = 0; i < fones.size(); i++) {
                contacts.get(name).fones.add(fones.get(i));
            }

        }else{
            if(contacts.containsKey(name)) {
                for(int i = 0; i < fones.size(); i++) {
                    contacts.get(name).fones.add(fones.get(i));
                }
            }else{
                contacts.put(name, new Contact(name));
                for(int i = 0; i < fones.size(); i++) {
                    contacts.get(name).fones.add(fones.get(i));
                }
            }
        }
         
    }

    public void removeNumber(String name, int index) {
        if(index < 0 || index >= contacts.get(name).fones.size()) {
            System.out.println("Index não existe");
        }else if(contacts.containsKey(name)) {
            ArrayList<Fone> fones = contacts.get(name).fones;
            fones.remove(index);
        }
    }

    public void removeContact(String name) {
        if(contacts.containsKey(name)) {
            contacts.remove(name);
        }else{
            System.out.println("Contato " + name + " não existe");
        }
    }

    public void bookmark(String name) {
        if(contacts.containsKey(name)) {
            contacts.get(name).setBookMark(true);
            getBookMarks().put(name, new Contact(name));
        }else{
            System.out.println("Contato não existe");
        }
    }

    public void unBookMark(String name) {
        if(contacts.containsKey(name)) {
            contacts.get(name).setBookMark(false);
            getBookMarks().remove(name);
        }else{
            System.out.println("Contato não existe");
        }
    }

    public TreeMap<String, Contact> search(String caractere) {
        TreeMap<String, Contact> contentFiltered = new TreeMap<>();

        for(Contact contact : contacts.values()) {
            if(contact.name.contains(caractere)) {
                contentFiltered.put(contact.name, contact);
            }
            for(int i = 0; i < contact.fones.size(); i++) {
                if(contact.fones.get(i).number.contains(caractere)) {
                   contentFiltered.put(contact.name, contact);
                }
            }
        }

        return contentFiltered;
    }

    public String toString() {
        String output = "";

        for(Contact contact : contacts.values()) {
            output += contact;
        }

        return output;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.addContact("eva", Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContact("ana", Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContact("bia", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContact("ana", Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));

        System.out.println(agenda);

        agenda.removeContact("bruno");
        agenda.removeNumber("ana", 1);
        agenda.bookmark("bia");


        System.out.println(agenda);

        agenda.unBookMark("bia");

        agenda.addContact("ava", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContact("rui", Arrays.asList(new Fone("viv", "2222"),new Fone("oio", "9991")));
        agenda.addContact("zac", Arrays.asList(new Fone("rec", "3131")));

        agenda.bookmark("rui");
        agenda.bookmark("zac");

        System.out.println(agenda);

        System.out.println("Contatos filtrados:");
        for(Contact contato : agenda.search("b").values()){    
            System.out.print(contato);
        }

        System.out.println("Números filtrados:");
        for(Contact contato : agenda.search("999").values()){
            System.out.print(contato);
        }
    }
}
