package aulasPOO.aula04;

import java.util.Scanner;

public class Mago {
    String name;
    int mana;

    Mago(String name, int mana) {
        this.name = name;
        this.mana = mana;
    }

    void lancarFeitico(String nomeFeitico) {

        switch (nomeFeitico) {
            case "fireball":
                mana -= 100;
                break;
            case "frost sword":
                mana -= 200;
                break;
            case "healer":
                mana -= 50;
                break;
        }

        System.out.println(this.name + " usou o feitico " + nomeFeitico);
    }

    public String toString() {
        return "Nome: " + this.name + "\nMana: " + this.mana;
    }

    public static void main(String[] args) {
        Mago mago = new Mago("Alkamore Mu'ha", 300);
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){ // init _nome _mana
                mago = new Mago(ui[1], Integer.parseInt(ui[2]));
            }else if(ui[0].equals("feiticos")){
                mago.lancarFeitico(ui[1]);
            }else if(ui[0].equals("show")){
                System.out.println(mago);
            }else{
                System.out.println("Invalid command");
            }
        }       
        scanner.close();
    }
}
