package ProjetosPessoais;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

class Passaporte {
    String dataNascimento;
    String cor;
    String genero;
    String estadoCivil;
    String pais;
    String cidade;
    String estado;

    public Passaporte(String data,String cor, String genero, String estadoCivil, String pais, String cidade, String estado) {
        this.dataNascimento = data;
        this.cor = cor;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.pais = pais;
        this.cidade = cidade;
        this.estado = estado;
    }

    public static boolean validateEstadoCivil(String estadoCivil) {
        ArrayList<String> validos = new ArrayList<>(Arrays.asList("casado", "solteiro", "separado", "divorciado", "viuvo"));

        for(int i = 0; i < validos.size(); i++) {
            if(estadoCivil.toLowerCase().equals(validos.get(i).toLowerCase())) {
                System.out.println("-> Estado civil validado");
                return true;
            }
        }
        System.out.println("-> Conteudo invalido");
        return false;
    }

    public static boolean verificaIdade(String data) {
        int nascimento = Integer.parseInt(data);
        int ano = Calendar.getInstance().getWeekYear();

        if((ano - nascimento) >= 18) {
            System.out.println("-> Idade permitida");
            return true;
        }
        System.out.println("-> Idade invalida");
        return false;
    }

    public String toString() {
        return " { Data de Nascimento: " + dataNascimento + ", Cor: " + cor + ", Genero: " + genero + ", Estado Civil: " + estadoCivil + ", País: " + pais + ", Cidade: " + cidade + ", Estado: " + estado + " }";
    }
}


class Validacao {
    String nome;
    String sobrenome;
    ArrayList<String> nomeCompleto;
    ArrayList<Passaporte> infos;

    public Validacao(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.infos = new ArrayList<>();
        this.nomeCompleto = new ArrayList<>();
    }

    public void addInfos(String data,String cor, String genero, String estadoCivil, String pais, String cidade, String estado) {
        boolean dataValida = Passaporte.verificaIdade(data);
        boolean estadoCivilValido = Passaporte.validateEstadoCivil(estadoCivil);
        if(dataValida && estadoCivilValido) {
            infos.add(new Passaporte(data, cor, genero, estadoCivil, pais, cidade, estado));
            nomeCompleto.add(nome+" "+sobrenome);
        }else{
            System.out.println("Idade ou estado civil invalidos\n");
            return;
        }
    }

    public String toString() {
        String saida = "";
        int i = 0;
        for(Passaporte info : infos) {
            saida += nomeCompleto.get(i) + "\n" + info;
            i++;
        }
        return saida;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Validacao registro = new Validacao("","");
        ArrayList<Validacao> users = new ArrayList<>();

        while(true) {
            String line = entrada.nextLine();
            String[] input = line.split(" ");

            if(input[0].equals("registrar")) {
                registro = new Validacao(input[1], input[2]);
            }else if(input[0].equals("addInfo")) {
                registro.addInfos(input[1], input[2], input[3], input[4], input[5], input[6], input[7]);
                users.add(registro);
            }else if(input[0].equals("showAll")) {
                for(int i = 0; i < users.size(); i++) {
                    System.out.println(users.get(i));
                }
            }else if(input[0].equals("sair")) {
                break;
            }
        }

        entrada.close();
    }
}
