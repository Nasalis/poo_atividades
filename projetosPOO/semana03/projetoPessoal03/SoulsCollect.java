package projetosPOO.semana03.projetoPessoal03;

import java.util.Random;
import java.util.Scanner;

class EnemySouls {

    int amountSouls;
    String name;
    String natureSouls;
    String infoAbout;

    EnemySouls(int amountSouls, String name, String natureSouls, String infoAbout) {
        this.amountSouls = amountSouls;
        this.natureSouls = natureSouls;
        this.name = name;
        this.infoAbout = infoAbout;
    }

    void soulsSearched() {
        System.out.println("Alma de " + name + " encontrada. Há " + amountSouls + " almas para coletar\n");
    }

    public String toString() {
        return "Amount souls: " + amountSouls + "\nName: " + name + "\nNature Souls: " + natureSouls + "\nInfo: " + infoAbout + "\n";
    }
}

class Collector {
    EnemySouls soulsCollected;
    int numSouls;
    int maxSouls;
    int leftovers;
    String typeSouls;
    String nameSpell;

    Collector() {
        this.numSouls = 0;
        this.maxSouls = 200;
        this.typeSouls = "demon";
    }

    void identifySouls() {
        if(soulsCollected != null) {
            System.out.println(soulsCollected);
        }else{
            System.out.println("Nenhuma alma para ler informações.\n");
        }
    }

    boolean collectSouls(EnemySouls target) {
        if(this.soulsCollected != null) {
            System.out.println("One souls already collected. Absorb or abandon it.\n");
            return false;
        }else if(this.soulsCollected != null && this.soulsCollected.equals(target)) {
            System.out.println("That souls have already been collected. Try it another one.\n");
        }else if(target.natureSouls.equals(this.typeSouls)) {
            System.out.println("Souls collected.\n");
            soulsCollected = target;
            return true;
        }
        System.out.println("Hm... Are you sure that you prepared to collect this type souls, Collector?\nBecause I suppose the opposite...\n");
        return false;
    }

    void absorbSouls() {
        if(soulsCollected == null) {
            System.out.println("There is no souls to collect, my dear Collector\n");
            return;
        }
        numSouls += soulsCollected.amountSouls;
        if(numSouls > maxSouls) {
            numSouls = maxSouls;
            System.out.println("Ah! You reached your promotion! Now you have a new souls to collect...\n");
        }else{
            System.out.println("One more souls... It's getting interestanting,\n");
        }
        soulsCollected = null;
    }

    EnemySouls abandonSouls() {
        if(soulsCollected == null) {
            System.out.println("No more Souls collected...");
            return null;
        }
        System.out.println("Souls abandoned");
        EnemySouls aux = soulsCollected;
        soulsCollected = null;
        return aux;
    }

    void collectorPower(String nameSpell) {
        switch (nameSpell) {
            case "Soul's_Shout":
                numSouls -= 20;
                System.out.println("Feitiço " + nameSpell + " utilizado\n");
                break;
            case "Revitalize": 
                numSouls -= 40;
                System.out.println("Feitiço " + nameSpell + " utilizado\n");
                break;
            case "Decrepit_Vision":
                numSouls -= 70;
                System.out.println("Feitiço " + nameSpell + " utilizado\n");
                break;
            case "Bone_Armor":
                numSouls -= 100;
                System.out.println("Feitiço " + nameSpell + " utilizado\n");
                break;
            case "Cancelar":
                break;
        }
    }

    public String toString() {
        return "Amount souls: " + numSouls + "/" + maxSouls + "\nLeftovers: " + leftovers + "\nType Collector: " + typeSouls + "\nSouls info: " + soulsCollected + "\n";
    }
}

public class SoulsCollect {
    public static void main(String[] args) {
        Collector souls = new Collector();
        Scanner input = new Scanner(System.in);

       
        SoulsList soulslist[] = new SoulsList[5];
        soulslist[0] = new SoulsList(0, "Nenhuma alma encontrada", "Vazio", "Vazio");
        soulslist[1] = new SoulsList(20, "Nahru Barshkman", "demon", "'Nos interiores do submundo das Cavernas de Ighorah jazem as mais bestiais criaturas abandonadas pelos Criadores,\naquelas cujo sangue enfraquece a terra e as águas e perturba a consciência dos homens tais como os pesadelos que atormentam os que vagam noturnamente pelas mentes.\nDe almas robustas e algoz da Criação, nenhuma mente sã as desejam vagando pelo mundo'\n--- Heroghito, Historiador, 457 a.C..\n");
        soulslist[2] = new SoulsList(72, "Weretolfus", "licantropo", "'Os antigos acreditavam que durante o alvorecer nasciam os homens: saudáveis e agéis, devotos e leais ao seu povo,\ne durante os vislumbres noturnos, aqueles que derramam lágrimas após a luz do parto, pouco restam de humanidade, pois esta fora tomada pela malícia do mundo.\nAssim resta-lhes uivar a noite, caçar as presas, abandonar os humanos e viver na solidão quando a lua banha o céu\n--- Perclarius, Historiador, 398 a.C..'");
        soulslist[3] = new SoulsList(55, "Squirin", "centauro", "'De postura robusta, força e destreza icomensurável os centauros dominam as florestas e vasculham os campos em vigilância com maior primor do que qualquer outro soldado extramamente qualificado em sua melhor performance. Quando desermados, pisoteiam e desfiguram o rosto do alvo; quando seguram seus arcos, causam pavor; com as lanças, uma vitória na guerra'\n--- Casius, general militar, 257 a.C..");
        soulslist[4] = new SoulsList(100, "Kashimaren", "baku", "'Nem animal nem homem, tampouco compreensível aos primeiros olhares, seja à distância ou próximo de qualquer visão, jamais compreenderei tamanha imagem mitológica.\nDigo assim não por sua elegância ou carga de poder, mas pela atrocidade de acreditar que, de fato, a Criação a fez na Terra'\n--- Heramus, Sacerdote, 320 a.C..");

        while(true) {
            String line = input.nextLine();
            String[] command = line.split(" ");

            Random number = new Random();
            int soulsSelected = number.nextInt(5);


            if(command[0].equals("identify")) {
                souls.identifySouls();
            }else if(command[0].equals("colect")) {

                int qtdSouls = soulslist[soulsSelected].getAmountSouls();
                String name = soulslist[soulsSelected].getName();
                String nature = soulslist[soulsSelected].getNatureSouls();
                String info = soulslist[soulsSelected].getInfoAbout();

                EnemySouls demon = new EnemySouls(qtdSouls, name, nature, info);
                demon.soulsSearched();
                souls.collectSouls(demon);

            }else if(command[0].equals("absorb")) {
                souls.absorbSouls();
            }else if(command[0].equals("abandon")) {
                souls.abandonSouls();
            }else if(command[0].equals("spell")) {
                souls.collectorPower(command[1]);
            }else if(command[0].equals("infoCollector")) {
                System.out.println(souls);
            }else if(command[0].equals("end")) {
                break;
            }
        }

        input.close();
    }
}