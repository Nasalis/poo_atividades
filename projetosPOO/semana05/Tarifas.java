package projetosPOO.semana05;

import java.util.ArrayList;
import java.util.Scanner;

class Operacao {
    String descricao;
    float valor;
    float saldo;

    public Operacao(String descricao, float valor, float saldo) {
        this.descricao = descricao;
        this.valor = valor;
        this.saldo = saldo;
    }

    public String toString() {
        return descricao + " : "+ valor +" : "+saldo;
    }

}

class Conta {
    float saldo;
    int numero;
    int conta;
    ArrayList<Operacao> extrato;

    public Conta(int numero) {
        this.numero = numero;
        this. extrato = new ArrayList<>();
        this.conta = 0;
        extrato.add(new Operacao("abertura", 0, 0));
    }

    public boolean verificaConta(Conta conta) {
        if(conta.numero == numero) {
            System.out.println("-> Conta invalida");
            return false;
        }else if(conta.numero > 0) {
            return true;
        }
        return false;
    }

    public void depositar(float deposito) {
        if(deposito >= 0) {
            saldo += deposito;
            extrato.add(new Operacao("deposito", deposito, saldo));
            return;
        }
        System.out.println("fail: valor invalido\n");
    }

    public void debito(float debito) {
        saldo -= debito;
        extrato.add(new Operacao("debito", debito, saldo));
    }

    public void tarifa(float tarifa) {
        saldo -= tarifa;
        extrato.add(new Operacao("tarifa", -tarifa, saldo));
    }

    public void saque(float saque) {
        if(saque > saldo) {
            System.out.println("fail: saldo insuficiente\n");
            return;
        }
        saldo -= saque;
        extrato.add(new Operacao("saque", -saque, saldo));
    }

    public void extornar(int pos) {
        try {
            if(!extrato.get(pos).descricao.equals("tarifa")) {
                System.out.println("fail: indice " + pos + " nao eh tarifa");
                return;
            }else{
                float novoValor = (extrato.get(pos).valor < 0) ? -extrato.get(pos).valor : extrato.get(pos).valor;
                saldo += novoValor;
                extrato.add(new Operacao("extorno", novoValor, saldo));
            }
        }catch(IndexOutOfBoundsException e) {
            System.out.println("fail: indice " + pos + " invalido");
            return;
        }        
    }

    public void extratoEspecifico(int qtd) {
        int tam = extrato.size()-1 - qtd;
        for(int i = extrato.size()-1; i > tam; i--) {
            System.out.format(i + ":" + extrato.get(i) + "\n");
        }
    }

    public void extratoTotal() {
        // for(int i = 0; i < extrato.size(); i++) {
        //     System.out.format(i + ":" + extrato.get(i) + "\n");
        // }
        conta = 0;
        extrato.forEach(item -> {
            System.out.println(conta + ":" + item.descricao + ":" + item.valor + ":" + item.saldo);
            conta++;
        });
    }

    public String toString() {
        return "conta: " + numero + " saldo: " + saldo;
    }
}

public class Tarifas {
    public static void main(String[] args) {

        Conta conta = new Conta(0);
        Conta conta0 = new Conta(0);
        Scanner input = new Scanner(System.in);

        while(true) {
            String line = input.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("sair")) {
                break;
            }else if(ui[0].equals("abrirConta")) {
                conta = new Conta(Integer.parseInt(ui[1]));
                if(conta0.verificaConta(conta)) {
                    System.out.println("-> Nova conta aberta");
                }
            }else if(ui[0].equals("depositar")) {
                conta.depositar(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("debito")) {
                conta.debito(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("tarifa")) {
                conta.tarifa(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("saque")) {
                conta.saque(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("extornar")) {
                conta.extornar(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("extratoN")) {
                conta.extratoEspecifico(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("extratoT")) {
                conta.extratoTotal();
            }
            else if(ui[0].equals("exibir")) {
                System.out.println(conta);
            }
        }

        input.close();
    }
}
