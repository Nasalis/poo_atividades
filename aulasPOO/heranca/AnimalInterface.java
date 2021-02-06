package aulasPOO.heranca;

import java.util.ArrayList;

interface Pet {
    String getNome();
    void receberCarinho();
}

class Cachorro implements Pet {
    String nome;

    public Cachorro(String nome) {
        this.nome = nome;
    }

    void latir() {
        System.out.println("Auau");
    }


    public void receberCarinho() {
        System.out.println("Estou me espreguiçando");
        latir();
    }

    public String getNome() {
        return nome;
    }
}

class Gato implements Pet {
    String nome;

    public Gato(String nome) {
        this.nome = nome;
    }

    void miar() {
        System.out.println("Móou");
    }

    public void receberCarinho() {
        System.out.println("Estou me esfregando nas suas pernas");
    }

    public String getNome() {
        return nome;
    }
}

class Calango implements Pet {
    String nome;

    public Calango(String nome) {
        this.nome = nome;
    }

    void xiar() {
        System.out.println("Xiaxia");
    }

    public void receberCarinho() {
        System.out.println("Calorzinho bom");
        xiar();
    }

    public String getNome() {
        return nome;
    }
}

public class AnimalInterface {
    public static void main(String[] args) {
        ArrayList<Pet> animais = new ArrayList<>();
        animais.add(new Cachorro("Vamp"));
        animais.add(new Gato("Wash"));
        animais.add(new Calango("Tobi"));
        for(Pet pet : animais) {
            System.out.println("Fazendo carinho no: " + pet.getNome());
            pet.receberCarinho();
        }
    }
}
