package heranca;

import java.util.ArrayList;

abstract class Pet {
    String nome;
    public Pet(String nome) {
        this.nome = nome;
    }
    String getNome() {
        return nome;
    }
    abstract void receberCarinho();
}

interface Adoravel {
    int conquistar();
}

class Cachorro extends Pet {

    public Cachorro(String nome) {
        super(nome);
    }

    void latir() {
        System.out.println("Auau");
    }


    public void receberCarinho() {
        System.out.println("Estou me espreguiçando");
        latir();
    }

}

class Gato extends Pet implements Adoravel {
    int fofura;

    public Gato(String nome, int fofura) {
        super(nome);
        this.fofura = fofura;
    }

    void miar() {
        System.out.println("Móou");
    }

    public void receberCarinho() {
        System.out.println("Estou me esfregando nas suas pernas");
    }

    @Override
    public int conquistar() {
        return fofura;
    }
}

class GatoNinja extends Gato {
    int poder;
    public GatoNinja(String nome, int poder) {
        super(nome, -100);
        this.poder = poder;
    }

    String getNome() {
        return "ninja jedi master: " + super.getNome();
    }

    void miar() {
        System.out.println("Oroki Nhiatu!");
    }

    public void receberCarinho() {
        super.receberCarinho();
        System.out.println("Cortei suas pernas com meu poder");
    }
}

class Calango extends Pet {

    public Calango(String nome) {
        super(nome);
    }

    void xiar() {
        System.out.println("Xiaxia");
    }

    public void receberCarinho() {
        System.out.println("Calorzinho bom");
        xiar();
    }
}

public class Animal {
    public static void main(String[] args) {
        ArrayList<Pet> animais = new ArrayList<>();
        animais.add(new Cachorro("Vamp"));
        animais.add(new Gato("Wash", 52));
        animais.add(new GatoNinja("Jojo", 500));
        animais.add(new Calango("Tobi"));
        for(Pet pet : animais) {
            System.out.println("Fazendo carinho no: " + pet.getNome());
            pet.receberCarinho();
        }

        Adoravel adoravel = new Gato("Giba", 50);
        adoravel.conquistar();
        if(adoravel instanceof Gato) {
            System.out.println("Sou um gato");
            Gato gato = (Gato) adoravel;
            System.out.println("Fazendo carinho no: " + gato.getNome());
            gato.receberCarinho();
        }
    }
}
