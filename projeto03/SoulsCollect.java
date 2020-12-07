package projeto03;

import java.util.Scanner;

class EnemySouls {
    int amountSouls;
    String name;
    String natureSouls;
    String infoAbout;

    EnemySouls(int amountSouls, String natureSouls) {
        this.amountSouls = amountSouls;
        this.natureSouls = natureSouls;
        this.name = "Nahru Barshkman";
        this.infoAbout = "'Nos interiores do submundo das Cavernas de Ighorah jazem as mais bestiais criaturas abandonadas pelos Criadores,\n aquelas cujo sangue enfraquece a terra e as águas e perturba a consciência dos homens tais como os pesadelos que atormentam os que vagam noturnamente pelas mentes.\nDe almas robustas e algoz da Criação, nenhuma mente sã as desejam vagando pelo mundo'\n--- Heroghito, Historiador, 457 a.C..\n";
    }

    void soulsSearched() {
        System.out.println("Alma de " + name + " encontrada. Há " + amountSouls + " almas para coletar");
    }

    public String toString() {
        return "Amount souls " + amountSouls + "\nName: " + name + "\nNature Souls: " + natureSouls + "\nInfo: " + infoAbout;
    }
}

class Collector {
    EnemySouls soulsCollected = null;
    int numSouls = 0;
    int maxSouls = 200;
    int leftovers;
    String typeSouls = "demon";

    // void info(int maxSouls, String typeSouls) {
    //     this.numSouls = 0;
    //     this.leftovers = 0;
    //     this.maxSouls = 200;
    //     this.typeSouls = "demon";
    // }

    void identifySouls() {
        if(soulsCollected != null) {
            System.out.println(soulsCollected);
        }else{
            System.out.println("Nenhuma alma para ler informações");
        }
    }

    boolean collectSouls(EnemySouls target) {
        if(this.soulsCollected != null) {
            System.out.println("That souls even collected.");
            return false;
        }else if(!typeSouls.equals(target.natureSouls)) {
            System.out.println("Hm... Are you sure that you prepared to collect this type souls, Collector?\nBecause I suppose the opposite...\n");
            return false;
        }
        System.out.println("Souls collected");
        soulsCollected = target;
        return true;
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
            System.out.println("One more souls... It's getting interestanting");
        }
        soulsCollected = null;
    }

    public String toString() {
        return "Amount souls " + numSouls + "/" + maxSouls + "\nLeftovers: " + leftovers + "\nType Collector: " + typeSouls + "\nSouls: " + soulsCollected;
    }
}

public class SoulsCollect {
    public static void main(String[] args) {
        Collector souls = new Collector();
        EnemySouls demon = new EnemySouls(20, "demon");
        Scanner input = new Scanner(System.in);

        while(true) {
            String line = input.nextLine();
            String[] command = line.split(" ");

            if(command[0].equals("identify")) {
                souls.identifySouls();
            }else if(command[0].equals("search")) {
                demon.soulsSearched();
            }else if(command[0].equals("coletar")) {
                souls.collectSouls(demon);
            }else if(command[0].equals("absorver")) {
                souls.absorbSouls();
            }else if(command[0].equals("infoSouls")) {
                souls.identifySouls();
            }else if(command[0].equals("infoCollector")) {
                System.out.println(souls);
            }else if(command[0].equals("sair")) {
                break;
            }
        }

        input.close();
    }
}
