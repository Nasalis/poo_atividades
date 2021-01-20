package projeto08;

import java.util.ArrayList;
import java.util.Comparator;

class FoneTeste {
    String id;
    String number;

    public FoneTeste(String id, String number) {
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

class ContatoTeste {
    String name;
    ArrayList<FoneTeste> numbers;

    public ContatoTeste(String name, ArrayList<FoneTeste> fones) {
        this.name = name;
        this.numbers = fones;
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

class OrdenaValores implements Comparator<ContatoTeste> {
    @Override
    public int compare(ContatoTeste o1, ContatoTeste o2) {
        if(o1 == null)
            return -1;
        if(o2 == null)
            return 1;
        return o1.name.compareTo(o2.name);
    }
}

public class AgendaComplete {
    ArrayList<ContatoTeste> contatos;

    public AgendaComplete() {
        contatos = new ArrayList<>();
    }

    public void addContato(String name, ArrayList<FoneTeste> fones){ 
        if(contatos.isEmpty()) {
            for(int i = 0; i < fones.size(); i++) {
                if(verifyNewNumber(fones.get(i)))
                    contatos.add(new ContatoTeste(name, fones));
            }
            return;
        }else{
            for(int i = 0; i < contatos.size(); i++) {
                if(contatos.get(i).name.equals(name)) {
                    for(int k = 0; k < contatos.get(i).numbers.size(); k++) {
                        if(verifyNewNumber(fones.get(i))) {
                            contatos.get(i).numbers.add(fones.get(k));
                            contatos.get(i).numbers.remove(contatos.get(i).numbers.size()-1);
                            return;
                        }else{
                            contatos.remove(i);
                        }
                    }
                }
            }
        }
        for(int i = 0; i < fones.size(); i++) {
            if(verifyNewNumber(fones.get(i)))
                contatos.add(new ContatoTeste(name, fones));
            else
                fones.remove(i);
        }
    }

    public boolean verifyNewNumber(FoneTeste fone) {
        if(FoneTeste.validate(fone.number)) {
            System.out.println("Número " + fone.number + " é válido");
            return true;
        }
        System.out.println("Núemro " + fone.number + " é inválido");
        return false;
    }

    public void removeFone(String name, int index) {
        for(int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).name.equals(name)) {
                contatos.get(i).numbers.remove(index);
                return;
            }
        }
        System.out.println("Número não encontrado");
        
    }

    public void removeContact(String name) {
        for(int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).name.equals(name)) {
                contatos.remove(i);
                return;
            }
        }
        System.out.println("Contato " + name + " não encontrado");
    }

    public ArrayList<ContatoTeste> search(String name) {
        ArrayList<ContatoTeste> contatosFiltered = new ArrayList<>();
        for(int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).name.contains(name)) {
                contatosFiltered.add(contatos.get(i));
                return contatosFiltered;
            }   
        }
        return contatos;
    }

    public String toString() {
        String output = "";
        contatos.sort(new OrdenaValores());

        for(int i = 0; i < contatos.size(); i++) {
            output +=  contatos.get(i).name + " ";
            for(int j = 0; j < contatos.get(i).numbers.size(); j++) {
                output += "[" + j + ":" + contatos.get(i).numbers.get(j).id + ":" + contatos.get(i).numbers.get(j).number + "] ";
            }
            output += "\n";
        }

        return output;
    }

    public static void main(String[] args) {
        AgendaComplete agenda = new AgendaComplete();
        
        ArrayList<FoneTeste> davi = new ArrayList<FoneTeste>();
        ArrayList<FoneTeste> bea = new ArrayList<FoneTeste>();
        ArrayList<FoneTeste> anne = new ArrayList<FoneTeste>();
        ArrayList<FoneTeste> jorge = new ArrayList<FoneTeste>();

        davi.add(new FoneTeste("tim", "343434"));
        agenda.addContato("davi", davi);
        bea.add(new FoneTeste("cas", "4568"));
        agenda.addContato("bia", bea);
        davi.add(new FoneTeste("tim", "242424"));
        agenda.addContato("davi", davi);
        anne.add(new FoneTeste("vivo", "992925"));
        agenda.addContato("jardeane", anne);
        bea.add(new FoneTeste("oi", "2525s25"));
        agenda.addContato("bia", bea);
        anne.add(new FoneTeste("vivo", "8882323"));
        anne.add(new FoneTeste("vivo", "7722889"));
        agenda.addContato("jardeane", anne);
        // agenda.removeFone("bia", 0);
        // agenda.removeContact("davi");
        agenda.removeContact("rogerio");
        jorge.add(new FoneTeste("morto", "6233145"));
        jorge.add(new FoneTeste("vivo", "ae32424"));
        agenda.addContato("jorge", jorge);
        agenda.removeFone("jardeane", 1);
        
        System.out.println(agenda);

        for(ContatoTeste contato : agenda.search("ja")) {
            System.out.print(contato);
        }
    
    }
}
