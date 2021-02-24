package projetosPOO.semana04.Contato;

import java.util.ArrayList;
import java.util.Scanner;

class Telefone {
    String label;
    String fone;
    String infoContato;

    Telefone(String label, String fone) {
        this.infoContato = label.concat("-"+fone);
        this.label = label;
        this.fone = fone;
    }
}

class Contatos {
    String nome;
    ArrayList<String> infoContact = new ArrayList<String>();
    String invalidos = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

    public boolean adicionarNumero(Telefone target) {
        if(target.infoContato == null) {
            System.out.println("Nenhum numero adicionado");
            return false;
        }
        this.infoContact.add(target.infoContato.replace("-", " "));
        return true;
    }

    public boolean validarNumero(Telefone target) {
        for(int i = 0; i < invalidos.length(); i++) {
            if(target.fone.contains(invalidos.substring(i,i+1))) {
                System.out.println("Numero invalido\n");
                return false;
            }
        }
        System.out.println("Numero valido\n");
        return true;
    }

    public boolean removerNumero(int numero) {
        if(infoContact.get(numero) == null) {
            System.out.println("Numero não encontrado.\nO seu contato tem " + infoContact.size() + " numeros");
            return false;
        }
        infoContact.remove(numero);
        System.out.println("Numero removido!\n");
        return true;

    }

    public void criarContato(String nome) {
        this.nome = nome;
    }

    public void exibirContato() {
        System.out.print(nome + " ");
        for(int i = 0; i < infoContact.size(); i++) {
            System.out.print("[" + i + ":" + infoContact.get(i).replace(" ", ":") + "]" + " ");
        }
        System.out.println("\n");
    }
}

public class Contato {
    public static void main(String[] args) {
        Contatos contato = new Contatos();
        Telefone pessoa;
        Scanner input = new Scanner(System.in);


        while(true) {
            String infos = input.nextLine();
            String[] info = infos.split(" ");

            if(info[0].equals("new")) {
                contato.criarContato(info[1]);
            }else if(info[0].equals("number")) {
                pessoa = new Telefone(info[1], info[2]);
                if(contato.validarNumero(pessoa)){
                    contato.adicionarNumero(pessoa);   
                }
            }else if(info[0].equals("remover")) {
                contato.removerNumero(Integer.parseInt(info[1]));
            }else if(info[0].equals("show")) {
                contato.exibirContato();
            }else if(info[0].equals("sair")) {
                break;
            }
        }

        input.close();
    }
}
