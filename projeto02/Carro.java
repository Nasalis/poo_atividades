package projeto02;

public class Carro {

    int passageiros = 0;
    int combustivel = 0;
    int distanciaP = 0;
    int km = 0;


    Carro(int tanque, int passageiros, int km) {
        this.combustivel = tanque;
        this.passageiros = passageiros;
        this.distanciaP =  km;
    }

    void entraPassageiro() {
        int pessoaEntra = 0;
        pessoaEntra += 1;

        if(passageiros > 2) {
            System.out.println("Capacidade máxima já atingida");
            return;
        }else{
            this.passageiros += pessoaEntra;
        }
    }

    void saiPassageiro() {
        int pessoaSai = 0;
        pessoaSai += 1;

        if(passageiros > 0) {
            passageiros -= pessoaSai;
        }else{
            System.out.println("Não há nenhuma pessoa no carro");
            return;
        }
    }

    void abastecer() {
        double abastecer = Math.random()*100;
        if(abastecer > 100) {
            abastecer = 100;
        }
        combustivel = (int) abastecer;
        System.out.println("Tanque: " + this.combustivel + " litros de agua");
    }

    void dirigir() {
        
        distanciaP = combustivel;

        if(passageiros > 0 && combustivel > 0) {
            for(int i = 0; i < distanciaP; i++) {
                km += 1;
                combustivel -= 1;
            }
        }
    }

    public String toString() {
        return ("Dados da Viagem\nDistância percorrida: " + km);
    }


    public static void main(String[] args) {
        Carro carro = new Carro(0, 0, 50);

        carro.entraPassageiro();
        carro.entraPassageiro();
        carro.abastecer();
        carro.saiPassageiro();
        carro.dirigir();

        System.out.println(carro);

    }
}
