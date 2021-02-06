package aulasPOO.aula04;

import java.util.Scanner;

class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int bucho, int maxBucho, int nPatas){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            if(bucho < dist){
                System.out.println("Aguentei só " + bucho + " pés, doido");
                bucho = 0;
            }
            bucho -= dist;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas;
    }
}

public class Interativo {
    public static void main(String[] args) {
        Calango calango = new Calango(0, 20, 4);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(line.equals("end")){
                break;
            }else if(line.equals("show")){
                System.out.println(calango);
            }else if(ui[0].equals("andar")){
                calango.andar(Integer.parseInt(ui[1]));
            }else if(line.equals("regenerar")){
                calango.regenerar();
            }else if(ui[0].equals("comer")){
                calango.comer(Integer.parseInt(ui[1]));
            }else if(line.equals("brigar")) {
                calango.acidentar();
            }
        }

        scanner.close();


        // while(true) {
        //     String line = scanner.nextLine();
        //     if(line.equals("end")) { // == não compara conteúdo, só objeto
        //         break;
        //     }else{
        //         System.out.println("faild: comando inválido");
        //     }
        // }

        // scanner.close();
    }
}
