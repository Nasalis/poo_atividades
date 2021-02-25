package projetosPOO.semana12;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

class Conta {
    int id;
    float saldo;
    String idCliente;

    public Conta(int id, String idCliente) {
        this.id = id;
        this.idCliente = idCliente;
        this.saldo = 0;     
    }

    public void depositar(float value) {
        if(value < 0) 
            throw new RuntimeException("fail: valor inválido");
        saldo += value;
    }

    public void sacar(float value) {
        if(value > saldo)
            throw new RuntimeException("fail: saldo insuficiente");
        saldo -= value;
    }

    public void transferir(Conta other, float value) {
        if(value > saldo) {
            System.out.println("fail: valor inválido");
            return;
        }
        this.saldo -= value;
        other.saldo += value;
    }
}

class ContaCorrente extends Conta {
    float tarifaMensal;

    public ContaCorrente(int id, String idCliente) {
        super(id, idCliente);
        this.tarifaMensal = 20;
    }

    public void atualizacaoMensal() {
        saldo -= tarifaMensal;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            NumberFormat formatter = new DecimalFormat("#0.00");
            output.append(this.idCliente+":"+formatter.format(this.saldo)+":"+"CC");
        return output.toString();
    }
}

class ContaPoupanca extends Conta {
    float rendimento;

    public ContaPoupanca(int id, String idCliente) {
        super(id, idCliente);
        this.rendimento = 0.01f;
    }

    public void atualizacaoMensal() {
        float calculoDeRendimento = saldo * rendimento;
        saldo += calculoDeRendimento;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            NumberFormat formatter = new DecimalFormat("#0.00");
            output.append(this.idCliente+":"+ formatter.format(this.saldo) +":"+"CP");
        return output.toString();
    }
}

class Cliente {
    String id;
    ArrayList<Conta> contas;

    public Cliente(String id) {
        this.id = id;
        this.contas = new ArrayList<>();
    }
}

public class Agencia {
    ArrayList<Cliente> clientes;
    ArrayList<Conta> contas;
    int indexCC;
    int indexCP;

    public Agencia() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.indexCC = 0;
        this.indexCP = 1;
    }

    public void adicionarCliente(String id) {
        clientes.add(new Cliente(id));
        for(Cliente cliente : clientes) {
            if(cliente.id.equals(id)) {

                cliente.contas.add(new ContaCorrente(indexCC, id));
                this.contas.add(new ContaCorrente(indexCC, id));
                cliente.contas.add(new ContaPoupanca(indexCP, id));
                this.contas.add(new ContaPoupanca(indexCP, id));

                indexCC += 2;
                indexCP += 2;
            }
        }
    }

    public void update() {
        for(Conta conta : contas) {
            if(conta instanceof ContaCorrente) {
                ContaCorrente cc = (ContaCorrente) conta;
                cc.atualizacaoMensal();
            }else if(conta instanceof ContaPoupanca) {
                ContaPoupanca cp = (ContaPoupanca) conta;
                cp.atualizacaoMensal();
            }
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < contas.size(); i++) {
            output.append(i +":"+contas.get(i)+"\n");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Agencia agenda = new Agencia();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while(running) {

            try {

                String line = scanner.nextLine();
                System.out.println("$" + line);
                String[] ui = line.split(" ");

                    switch(ui[0]) {
                        case "end": 
                            running = false;
                            break;
                        case "addCli": 
                            agenda.adicionarCliente(ui[1]);
                            break;
                        case "show":
                            System.out.println(agenda);
                            break;
                        case "deposito": {
                            Conta conta =  agenda.contas.get(Integer.parseInt(ui[1]));
                            conta.depositar(Float.parseFloat(ui[2]));
                            break;
                        }
                        case "saque": {
                            Conta conta =  agenda.contas.get(Integer.parseInt(ui[1]));
                            conta.sacar(Float.parseFloat(ui[2]));
                            break;
                        }
                        case "transfer": {
                            Conta contaEnviaValue = agenda.contas.get(Integer.parseInt(ui[1]));
                            Conta contaRecebeValue = agenda.contas.get(Integer.parseInt(ui[2]));
                            float value = Float.parseFloat(ui[3]);
                            contaEnviaValue.transferir(contaRecebeValue, value);
                            break;
                        }
                        case "update":
                            agenda.update();
                            break;
                    }
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("fail: inserção de dados incorreto");
                } catch(RuntimeException e) {
                    System.out.println(e.getMessage());
                }
        }
        scanner.close();
    }
}
