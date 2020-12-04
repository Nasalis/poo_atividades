package aula04;

import java.util.Scanner;

class Mission {
    String name;
    String region;
    int choice;
    int force;
    int mana;

    int choiceOption() {
        Scanner decision = new Scanner(System.in);
        return this.choice = decision.nextInt();
    }


    void menu(String option) {
            if(option.equals("init")) {
                init();
            }else if(option.equals("regions")) {
                regions();
            }
    }

    void open() {
        System.out.println("\nBem-vindo ao seu novo jogo! Para iniciar, digite 'init', caso queira sair, 'end'");
    }

    void init() {
        System.out.println("Digite o nome do seu personagem, região, force e a mana. Caso não conheça as regiões, volte ao menu e digite 'regions'");
        System.out.println("Digite 'create'\n");
    }

    void createCharacter(String name, String region, int force, int mana) {
        this.name = name;
        this.region = region;
        this.force = force;
        this.mana = mana;
    }

    void regions() {
        System.out.println("1. Boletaria\n2. Belmont\n3. Highrock\n4. Deimont\n5. Lightmount\n");
    }

    void start() {
        if(region.equals("Boletaria")) {
            System.out.println("Você se encontra na região de Boletaria, uma antiga região hostial e decadente após os efeitos desastrosos após a Batalha de Nahru-Orkhan há mais de um século.\n");
            System.out.println("Em meio ao ambiente desértico, de arquitetura decrepita, apenas domada pela vegetação que se alastra por cima das antigas e belas construções. Nem mesmo animais selvagens vasculham os locais. Somente aves que decidem demarcar os seus ninhos por cima das altas torres.\n");
            System.out.println("Em torno de um corredor de muros altos formados por pedras cobertas de levedura, avista um túnel logo a frente, uma árvore à direita próxima a um penhasco e uma segunda passagem à direita\n");
            System.out.println("O que desejas fazer, " + name + "?");
            System.out.println("1. Acampar no túnel\n2. Ir até a árvore\n3. Seguir a passagem à direita\n");
            System.out.println("Digite 'choice' e depois selecione uma opção");

            boolean choiced = true;
            int verify = 0;

            while(choiced) {
                verify = choiceOption();
                if(verify == 1 || verify == 2 || verify == 3) {
                    choiced = false;
                }
            }

            if(verify == 1) {
                System.out.println("Você consegue montar uma pequena fogueira através dos gravetos retirados de uma árvore próxima e encontradas no chão e algumas pedras para que as faíscas primordias surgissem.\n");
                System.out.println("No interior do túnel há um frio suspenso sobre o corpo pedrogoso outrora perfeitamente lapidado pelas forças braçais da cidade. Uma história perdida no tempo em um local que, talvez, abraça um enorme cemitério de trabalhadores mortos ao longo dos séculos.\n");
                System.out.println("O decair do dia avança vagarosamente ao longo dos minutos e os seus olhos sentem o peso da fatiga ao longo de tantos dias de viagem. A vigília indisposta e o adormecer abrupto surge adjacente a consciência...");
            }

        }
    }


    public String toString() {
        return "Name: " + name + "\nRegion: " + region + "\nForce: " + force + "\nMana " + mana;
    }

}

public class Quest {
    public static void main(String[] args) {
        Mission character = new Mission();  
        Scanner scanner = new Scanner(System.in);

        character.open();
        
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("end")) {
                break;
            }else if(ui[0].equals("menu")) {
                System.out.println("1. Iniciar\n2. Regioes\n");
            }else if(ui[0].equals("menuTravel")) {
                character.menu(ui[1]);
            }else if(ui[0].equals("create")) {
                character.createCharacter(ui[1], ui[2], Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));
            }else if(ui[0].equals("status")) {
                System.out.println(character);
            }else if(ui[0].equals("start")) {
                character.start();
            }
        }

        scanner.close();
        
    }
}
