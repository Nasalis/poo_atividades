package ArrayList.aula07.atividadeaula07;

import java.util.ArrayList;
import java.util.Scanner;

class Telefone {
    String label;
    String fone;
    ArrayList<String> numero = new ArrayList<>();

    Telefone(String label, String numero) {
        this.numero.add(label);
        this.numero.add(numero);
        this.label = label;
        this.fone = numero;
    }
}

class Contatos {
    String nome;
    Telefone telefone;
    ArrayList<String> infoContact = new ArrayList<String>();

    boolean adicionarNumero(Telefone target) {
        // this.telefone = target;
        // this.telefone.numero.add(target.fone);
        // this.telefone.numero.add(target.label);
        this.infoContact.add(target.label);
        this.infoContact.add(target.fone);
        return true;
    }

    public void criarContato(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome + infoContact;
    }
}

public class ArrayAtt {
    public static void main(String[] args) {
        Contatos contato = new Contatos();
        Scanner input = new Scanner(System.in);

        while(true) {
            String infos = input.nextLine();
            String[] info = infos.split(" ");

            if(info[0].equals("new")) {
                contato.criarContato(info[1]);
            }else if(info[0].equals("number")) {
                Telefone pessoa = new Telefone(info[1], info[2]);
                contato.adicionarNumero(pessoa);
            }else if(info[0].equals("show")) {
                System.out.println(contato);
            }else if(info[0].equals("sair")) {
                break;
            }
        }

        input.close();
    }
}
