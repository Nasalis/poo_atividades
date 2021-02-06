package aulasPOO.aula10_excessoes;

import java.util.Scanner;

class Calculadora {
    int bateria;

    public Calculadora() {
        this.bateria = 0;
    }

    void gastar_bateria() {
        if(bateria == 0)
            throw new RuntimeException("Bateria acabou");
    }

    int soma(int a, int b) {
        gastar_bateria();
        return a + b;
    }

    int div(int a, int b) {
        gastar_bateria();
        return a / b;
    }

    void recarregar(int value) {
        this.bateria += value;
    }
}

public class Excessao {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try{
                String line = scanner.nextLine();
                String[] ui = line.split(" ");
                
                if(ui[0].equals("end")) {
                    break;
                }else if(ui[0].equals("charge")) {
                    calculadora.recarregar(Integer.parseInt(ui[1]));
                }else if(ui[0].equals("sum")) {
                    int value = calculadora.soma(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                    System.out.println(value);
                }else {
                    System.out.println("fail: comando invalido");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("Provavelmente você esqueceu um parâmetro");
            }catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
