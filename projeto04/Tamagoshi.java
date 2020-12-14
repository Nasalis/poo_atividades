package projeto04;

import java.util.Scanner;

class Bichinho {
    private int energia;
    private int minEnergia;
    private int subEnergia;
    private int saciedade;
    private int limpeza;
    private int idade;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idadeMax;
    private int diamantes;
    private boolean alive;

    Bichinho(int energiaMax, int saciedadeMax, int limpezaMax, int idadeMax) {
        this.energia = energiaMax;
        this.minEnergia = 5;
        this.energiaMax = energiaMax;
        this.saciedade = saciedadeMax;
        this.saciedadeMax = saciedadeMax;
        this.limpeza = limpezaMax;
        this.limpezaMax = limpezaMax;
        this.idadeMax = idadeMax;
        this.idade = 0;
        this.diamantes = 0;
        this.alive = true;
        this.subEnergia = energiaMax - minEnergia;
    }

    private void setEnergia(int value) {
        if(value <= 0) {
            energia = 0;
            System.out.println("fail: pet morreu de fraqueza");
            alive = false;
        }else if(value > energiaMax) {
            energia = energiaMax;
        }else{
            energia = value;
        }
    }

    private void setSaciedade(int value) {
        if(value <= 0) {
            saciedade = 0;
            System.out.println("fail: pet morreu de fome");
            alive = false;
        }else if(value > saciedadeMax) {
            saciedade = saciedadeMax;
        }else {
            saciedade = value;
        }
    }

    private void setLimpeza(int value) {
        if(value <= 0) {
            limpeza = 0;
            System.out.println("fail: o pet morreu de sujeira");
            alive = false;
        }else if(value > limpezaMax) {
            limpeza = limpezaMax;
        }else {
            limpeza = value;
        }
    }

    private void setDiamantes(int value) {
        diamantes += value;
    }

    private void setIdade(int value) {
        if(idade > idadeMax) {
            idade = idadeMax;
            System.out.println("fail: pet morreu de velhice");
            alive = false;
        }
        idade = value;
    }

    public int getEnergia() {
        return energia;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isAlive() {
        return alive;
    }

    boolean testaMorto() {
        if(alive) 
            return false;
        System.out.println("Pet está morto");
        return true; 
    }

    public void brincar() {
        if(testaMorto()){
            return;
        }
        setEnergia(getEnergia() - 3);
        setSaciedade(getSaciedade() - 1);
        setLimpeza(getLimpeza() - 2);
        setDiamantes(getDiamantes() + 1);
        setIdade(getIdade() + 1);
    }

    public void comer() {
        setEnergia(getEnergia() - 1);
        setSaciedade(getSaciedade() + 4);
        setLimpeza(getLimpeza() - 2);
        setDiamantes(getDiamantes() + 0);
        setIdade(getIdade() + 1);
    }

    public void dormir() {
        if(energia >= subEnergia){
            System.out.println("fail: Pet não está com sono");
            return;
        }else{
            while(energia != energiaMax) {
                setEnergia(getEnergia() + 1);
                setIdade(getIdade() + 1);
            }
        }
    }

    public void banho() {
        setEnergia(getEnergia() - 3);
        setSaciedade(getSaciedade() - 1);
        setLimpeza(getLimpeza() + limpezaMax);
        setIdade(getIdade() + 2);
    }

    public String toString() {
        return "E: " + energia + "/" + energiaMax + " S: " + saciedade + "/" + saciedadeMax + " L: " + limpeza + "/" + limpezaMax + " D: " + diamantes + " I: " + idade;
    }
}

public class Tamagoshi {
    public static void main(String[] args) {
        Bichinho tama = new Bichinho(20, 10, 20, 50);
        Scanner input = new Scanner(System.in);
        

        while(true) {
            String line = input.nextLine();
            String[] comando = line.split(" ");

            if(comando[0].equals("brincar")) {
                tama.brincar();
                System.out.println(tama);
            }else if(comando[0].equals("comer")) {
                tama.comer();
                System.out.println(tama);
            }else if(comando[0].equals("dormir")) {
                tama.dormir();
                System.out.println(tama);
            }else if(comando[0].equals("banho")) {
                tama.banho();
                System.out.println(tama);
            }else if(comando[0].equals("sair")) {
                break;
            }
        }

        input.close();
    }
}
