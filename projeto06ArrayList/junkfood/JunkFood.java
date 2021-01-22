package projeto06ArrayList.junkfood;

import java.util.ArrayList;
import java.util.Scanner;

class Espiral {
    String nome;
    int qtd;
    float preco;

    public Espiral(String nome, int qtd, float preco) {
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;    
    }

    public String toString() {
        return nome + " : " + qtd + " U : " + preco + " R$";
    }
}

class Maquina {
    ArrayList<Espiral> espirais;
    float saldoCliente = 0;
    float lucro = 0;
    float troco;
    int maxProdutos;
    int qtdEspirais;

    public Maquina(int qtdEspirais, int maxProdutos) {
        this.maxProdutos = maxProdutos;
        this.qtdEspirais = qtdEspirais;
        espirais = new ArrayList<>();        
    }

    public boolean alterarEspiral(int indice, String nome, int qtd, float preco) {
        if(indice < 0 || indice > espirais.size()) {
            System.out.println("fail: indice nao existe");
            return false;
        }else if(qtd > maxProdutos) {
            System.out.println("fail: quantidade excedida");
            return false;
        }else if(espirais.get(indice).nome.equals("empty")) {
            espirais.set(indice, new Espiral(nome, qtd, preco));
            return true;
        }
        System.out.println("fail: limite excedido");
        return false; 
    }

    public boolean limparEspiral(int indice) {
        if(indice < 0 || indice > espirais.size()) {
            System.out.println("fail: indice nao existe");
            return false;
        }else{
            espirais.set(indice, new Espiral("empty", 0, 0.0f));
            return true;
        }
    }

    public boolean inserirDinheiro(float valor) {
        if(valor < 0)
            return false;
        saldoCliente += valor;
        return true;
    }

    public float pedirTroco() {
        if(troco == 0) {
            troco = 0;
            troco = saldoCliente;
            System.out.println("voce recebeu " + saldoCliente);
            saldoCliente -= troco;
            return saldoCliente;
        }else{
            return saldoCliente;
        }
    }

    public boolean vender(int indice) {
        if(indice < 0 || indice > espirais.size()) {
            System.out.println("fail: indice nao existe");
            return false;
        }

        float valorProduto = espirais.get(indice).preco;
        int qtdProduto = espirais.get(indice).qtd;
        String nomeProduto = espirais.get(indice).nome;

        if(espirais.get(indice).nome.equals("empty")){
            System.out.println("fail: espiral sem produtos");
            return false;
        }else if(saldoCliente < valorProduto) {
            System.out.println("fail: saldo insuficiente");
            return false;
        }else if(saldoCliente > 0) {
            if(qtdProduto <= 0) {
                System.out.println("fail: espiral sem produtos");
                return false;
            }
            float dinheiro = saldoCliente - valorProduto;
            saldoCliente = dinheiro;
            espirais.get(indice).qtd--;
            System.out.println("voce comprou um " + nomeProduto);
            return true;
        }else if(saldoCliente < 0) {
            saldoCliente = 0;
            return false;
        }
        System.out.println("fail: item nao encontado");
        return false;
    }

    public String toString() {
        String output = "";
        output += "Saldo: " + saldoCliente + "\n";
        for(int i = 0; i < qtdEspirais; i++) {
            output += "" + i + " [ " + espirais.get(i) + " ]\n";
        }

        return output;
    }
}

class JunkFood {
    public static void main(String[] args) {
      

        Maquina maquina = new Maquina(0, 0);
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while(loop) {
            System.out.println("Digite um comando:");
            String line = input.nextLine();
            String[] cmd = line.split(" ");

            switch(cmd[0]) {
                case "init":
                    maquina = new Maquina(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    int max = Integer.parseInt(cmd[1]);
                    for(int i = 0; i < max; i++) {
                        maquina.espirais.add(new Espiral("empty", 0, 0.0f));
                    }
                    break;
                case "set":
                    maquina.alterarEspiral(Integer.parseInt(cmd[1]), cmd[2], Integer.parseInt(cmd[3]), Float.parseFloat(cmd[4]));
                    break;
                case "limpar":
                    maquina.limparEspiral(Integer.parseInt(cmd[1]));
                    break;
                case "dinheiro":
                    maquina.inserirDinheiro(Float.parseFloat(cmd[1]));
                    break;
                case "troco":
                    maquina.pedirTroco();
                    break;
                case "comprar":
                    maquina.vender(Integer.parseInt(cmd[1]));
                    break;
                case "show":
                    System.out.println(maquina);
                    break;
                case "end":
                    loop = false;
                    break;

            }
        }

    }
}