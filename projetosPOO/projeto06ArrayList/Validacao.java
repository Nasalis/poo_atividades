package projetosPOO.projeto06ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

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
    boolean suspeito;

    public Validacao(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.verificaInfos = false;
        this.infosGerais = new ArrayList<>();
        this.nomeCompleto = new ArrayList<>();
        this.docsGerais = new ArrayList<>();
        this.suspeito = false;
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

    public void rondaDeVigilancia() {
        suspeito = true;
        if(suspeito) {
            for(int i = 0; i < infosGerais.size(); i++) {
                if(!infosGerais.get(i).pais.equals("Berloks")) {
                    System.out.println(nomeCompleto.size());
                    ativarVigilancia(nomeCompleto.get(i));
                }
            }
        }
        System.out.println("Guarda: Continuemos o trabalho.\n");
        suspeito = false;
        return;
    }

    public void ativarVigilancia(String suspeito) {
        System.out.println("Guarda: Um momento! Achamos que " + suspeito + " seja um estrangeiro de um país dos blocos econômicos.\nFaremos a inspeção");

        for(int i = 0; i < infosGerais.size(); i++) {
            if(nomeCompleto.get(i).equals(suspeito)) {
                nomeCompleto.remove(i);
                infosGerais.remove(i);
                docsGerais.remove(i);
            }
        }
        
        System.out.println("Guarda: Nossa inspeção revelou que " + suspeito + " é um estrangeiro. Portanto removemos os seus dados do seu registro de passaporte. Obrigado por sua colaboração\n");
        System.out.println(suspeito + " removido\n");
        
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
