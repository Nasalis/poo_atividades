package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Calendar;
import java.util.Scanner;
import jdk.jfr.Timespan;


class Documentos {
    String identidade;
    String cpf;
    String tituloEleitor;
    String servicoMilitar;

    public Documentos(String identidade, String cpf, String tituloEleitor, String servicoMilitar) {
        this.identidade = identidade;
        this.cpf = cpf;
        this.tituloEleitor = tituloEleitor;
        this.servicoMilitar = servicoMilitar;
    }

    public static boolean validate(String documento) {
        String validos = "0123456789";
        for(int i = 0; i < documento.length(); i++) {
            if(validos.indexOf(documento.charAt(i)) == -1) {
                System.out.println("-> Documentos invalidos\n");
                return false;
            }
        }
        System.out.println("-> Documento "+ documento + " valido\n");
        return true;
    }

    public String toString() {
        return "[ Identidade: " + identidade + ", CPF: " + cpf + ", Titulo Eleitor: " + tituloEleitor + ", Servico Militar: " + servicoMilitar + " ]";
    }
}

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
        ArrayList<String> validos = new ArrayList<>(Arrays.asList("casado", "casada", "solteiro", "solteira", "separado", "separada", "divorciado", "divorciada", "viuvo", "viuva"));

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
    ArrayList<Documentos> docsGerais;
    ArrayList<String> nomeCompleto;
    ArrayList<Passaporte> infosGerais;
    boolean verificaInfos;
    int contRegistros = 0;
    int cont = -1;

    public Validacao(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.verificaInfos = false;
        this.infosGerais = new ArrayList<>();
        this.nomeCompleto = new ArrayList<>();
        this.docsGerais = new ArrayList<>();
    }

    public void addInfos(Passaporte infos) {
        boolean dataValida = Passaporte.verificaIdade(infos.dataNascimento);
        boolean estadoCivilValido = Passaporte.validateEstadoCivil(infos.estadoCivil);
        if(dataValida && estadoCivilValido) {
            infosGerais.add(infos);
            nomeCompleto.add(nome+" "+sobrenome);
            verificaInfos = true;
        }else{
            System.out.println("Idade ou estado civil invalidos\n");
            return;
        }
    }

    public void addDocumentos(Documentos docs) {
        boolean identidadeValida = Documentos.validate(docs.identidade);
        boolean titulo = Documentos.validate(docs.tituloEleitor);
        boolean cpfValido = Documentos.validate(docs.cpf);
        
        if(identidadeValida && cpfValido && titulo) {
            docsGerais.add(docs);
        }   
    }

    private int setContRegistros(int value) {
        return contRegistros += value;
    }

    private int getRegistros() {
        return contRegistros;
    }

    public void rondaDeVigilancia() {
        setContRegistros(getRegistros() + 1);
        if(contRegistros%2 != 0) {
            cont++;
            ativarVigilancia(nomeCompleto.get(cont));
        }
        System.out.println("Guarda: Nenhuma suspeita...");
        System.out.println("Continuamos o trabalho.\n");
        return;
    }

    public void ativarVigilancia(String suspeito) {
        System.out.println("Guarda: Um momento! Achamos que " + suspeito + " tenha uma longa ficha criminal. Faremos a inspeção");

        Random random = new Random();
        int nivelSuspeita = random.nextInt(100);

        try {
            System.out.println("--- Espere 3 segundos... ---");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            if(nivelSuspeita%2 == 0) {
                System.out.println("Guarda: Nossa inspeção revelou que " + suspeito + " é um criminoso. Portanto removemos os seus dados do falso do seu registro de passaporte. Obrigado por sua colaboração");

                for(String nome : nomeCompleto) {
                    if(nome.equals(suspeito)) {
                        int index = nome.indexOf(nome);
                        nomeCompleto.remove(index);
                        infosGerais.remove(index);
                        docsGerais.remove(index);
                        System.out.println(suspeito + " removido");
                    }
                }
            }
        }
    }


    public String toString() {
        String saida = "";

        for(int i = 0; i < nomeCompleto.size(); i++) {
            saida += nomeCompleto.get(i)+":" + "\nDados Gerais:\n" + infosGerais.get(i) + "\nDocumentos Gerais:\n" + docsGerais.get(i) + "\n";
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
                registro.addInfos(new Passaporte(input[1], input[2], input[3], input[4], input[5], input[6], input[7]));
                if(registro.verificaInfos){
                    registro.addDocumentos(new Documentos(input[8], input[9], input[10], input[11]));
                    users.add(registro);
                    registro.rondaDeVigilancia();
                }
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
