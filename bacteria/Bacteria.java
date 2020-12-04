package bacteria;

import java.util.Random;

class Bacteriahache{
    int infectados;
    int maxInfectados;
    int saudaveis;
    int maxSaudaveis;
    int vivos;
    int turnos;
    int morto;
    int chance;
    boolean doente = false;

    //parametros//
    Bacteriahache(int infectados, int saudaveis){
        this.infectados = infectados;
        this.saudaveis = saudaveis;
        this.maxSaudaveis = saudaveis;
        this.maxInfectados = maxSaudaveis;
        this.vivos = saudaveis;
    }

    void infectar(){//contagem
        Random random = new Random();
        chance = random.nextInt((10 - 1) + 1) + 1;

        System.out.println(chance);

        if(infectados >= 1){
            if(chance%2 == 0){
                infectados++;
                saudaveis -= 1;
                doente = true;
                morre();
                System.out.println("Mais infectados");
            }else if(chance%2 != 0){
                doente = false;
                System.out.println("Contido");
            }
        }
    }

    // void chance(){
    //     if (chance == 2) {
    //         System.out.println("Estou normal");
    //     }else if(chance == 1){
    //         System.out.println("Tamo bem");
    //     }
    // }

    // void taxa(){
    //     if(infectados < maxSaudaveis){
    //         System.out.println(turnos);  
    //         infectados += turnos;
    //     }else{
    //         infectados = turnos;
    //     System.out.println(turnos);
    //     }
    // }

    void morre(){
        Random random = new Random();
        morto = random.nextInt((2 - 1) + 1) + 1;

        if(doente && morto == 2){
            vivos--;
            infectados--;
            System.out.println("Mais um falecido");
        }
    }


    public String toString() {
        return "Bacteriahache:\nInfectados: " + infectados + "\nSaudaveis: " + saudaveis + "\nVivos: " + vivos;
    }
}

public class Bacteria {
    public static void main(String[] args) { 
        //referencial main//
        Bacteriahache VirusH = new Bacteriahache(1, 8);
        System.out.println(VirusH);
    
            for(int i = 0; i < 4; i++) {
                VirusH.infectar();
                System.out.println(VirusH);
            }
    }
}
    


