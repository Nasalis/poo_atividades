package projetoAgiota;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

class Client {
    String codename;
    float limit;
    float balance;

    public Client(String codename, float limit, float balance) {
        this.codename = codename;    
        this.limit = limit;    
        this.balance = balance;        
    }

    public String toString() {
        return "" + codename + " " + balance + "/" + limit; 
    }
}

class Transaction {
    String codename;
    int id;
    float value;

    public Transaction(String codename, int id, float value) {
        this.codename = codename;
        this.id = id;
        this.value = value;   
    }

    public String toString() {
        return "" + "id:" + id + " " + codename + ":" + value;
    }
}

public class Agiota {
    Map<String, Client> repCliente;
    Map<Integer, Transaction> repTrans;
    int nextTrid;
    float balance;
    float taxaJuros = 0.02f;

    public Agiota(float balance) {
        nextTrid = 0;
        this.balance = balance;
        this.repCliente = new TreeMap<String, Client>();
        this.repTrans = new TreeMap<Integer, Transaction>();    
    }

    public void addClient(String codename, float limit) {

        if(repCliente.isEmpty()) {
            repCliente.put(codename, new Client(codename, limit, 0));
            return;
        }else if(repCliente.containsKey(codename)) {
            System.out.println("fail: cliente " + codename + " já existe");
            return;
        }
        repCliente.put(codename, new Client(codename, limit, 0));
    }

    public void lend(String codename, float value) {

        if(!verifyClient(repCliente.get(codename), codename))
            throw new RuntimeException("fail: cliente " + codename + " não existe");

        if(this.balance < value){
            System.out.println("fail: fundos insuficientes");
            return;
        }else if((value + repCliente.get(codename).balance) > repCliente.get(codename).limit) {
            System.out.println("fail: limite excedido");
            return;
        }
        repTrans.put(nextTrid, new Transaction(codename, nextTrid, value));
        repCliente.get(codename).balance += value;
        this.balance -= value;
        nextTrid++;
        
    }

    public void receive(String codename, float value) {

        if(!verifyClient(repCliente.get(codename), codename))
            throw new RuntimeException("fail: cliente " + codename + " não existe");

        if(value > repCliente.get(codename).limit) {
            System.out.println("fail: valor maior que a dívida");
            return;
        }
        double valueToPay = calcMontante(repCliente.get(codename).limit);
        this.balance += valueToPay;
        repCliente.get(codename).balance -= valueToPay;
        repTrans.put(nextTrid, new Transaction(codename, nextTrid, -(float)valueToPay));
        nextTrid++;
    }

    public double calcMontante(float value) {
        double montante = value*(Math.pow(1 + this.taxaJuros, 6));
        return montante;
    }

    public void kill(String codename) {
        
        if(!verifyClient(repCliente.get(codename), codename))
            throw new RuntimeException("fail: cliente " + codename + " não existe");

        repCliente.remove(codename);
        ArrayList<Integer> dex = new ArrayList<>();

        for(Entry<Integer, Transaction> lend : repTrans.entrySet()) {
            if(lend.getValue().codename.equals(codename))
                dex.add(lend.getKey());
        }

        dex.forEach(key -> {
            if(repTrans.containsKey(key))
                repTrans.remove(key);
        });

        System.out.println("Fredo, pode atualizar a lista, pois o cliente foi expulso da cidade");
        
    }

    private boolean verifyClient(Client cliente, String name) {
        if(cliente == null) {
            // System.out.println("fail: cliente " + name + " nao existe");
            return false;
        }
        return true;
    }

    public String toString() {
        String output = "";

        output += "clientes:\n";

        for(Client client : repCliente.values()) {
            output += "- " + client + "\n";
        }

        output += "transactions:\n";

        for(Transaction lend : repTrans.values()) {
            output += "- " + lend + "\n";
        }

        output += "balance: " + this.balance; 
        
        return output;
    }

    public static void main(String[] args) {
        Agiota ptolomeu = new Agiota(500);
        try {

            ptolomeu.addClient("maria", 500);
            ptolomeu.addClient("josue", 60);
            ptolomeu.addClient("maria", 300);
            
            ptolomeu.lend("maria", 300);
            ptolomeu.lend("josue", 50);
            ptolomeu.lend("maria", 100);

            System.out.println(ptolomeu);

            ptolomeu.lend("bruno", 300);
            ptolomeu.lend("maria", 60);
            ptolomeu.lend("josue", 30);

            System.out.println(ptolomeu);

            ptolomeu.receive("maria", 1000);
            ptolomeu.receive("maria", 350);
            ptolomeu.receive("josue", 1);
            ptolomeu.receive("maria", 10);

            System.out.println(ptolomeu);

            ptolomeu.kill("maria");

            System.out.println(ptolomeu);
        }catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }


    }
}
