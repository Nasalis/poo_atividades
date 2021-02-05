package projetosPOO.projeto02;

public class Calango {

    int bucho;
    int maxBucho;
    int numPatas;
    float calangoForce;
    float calangoLive;
    int pesAndados;
    double inimigo;
    boolean alive;
    boolean enemyAlive;

    Calango(int bucho, int maxBucho, int numPatas) {
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.numPatas = numPatas;
        this.calangoForce = 50;
        this.calangoLive = 200;
        this.alive = true;
    }

    void comer(int qtd) {
        bucho += qtd;
        if(bucho > maxBucho) {
            bucho = maxBucho;
            // System.out.println("Tô cansado, ó. Aguento mais não. Quero comer!");
            evoluir();
        }else{
            System.out.println("Bucho chein: " + bucho);
        }
    }

    void andar() {
        pesAndados += 1;
        batalha();

        if(numPatas < 2) {
            System.out.println("Diante da situacao cujos meus membros para locomocao encontram-se deploravelmente inutilizáveis, digo que estou em situação de emergência a sucumbir vagarosamente");
            return;
        }
        
        if(bucho > 0) {
            bucho -= 1;
            System.out.println("Ô solzin quente");
        }

        // System.out.println("Aff, doido, tô cansado, ó");
    }

    void acidente() {
        if(numPatas > 0) {
            numPatas -= 1;
            System.out.println("Que disgrama! Perdi uma pata");
        }else{
            System.out.println("Bucho tá vazio. Preciso comer para me recuperar");
        }
    }

    void regenerar() {
        if(numPatas == 4) {
            System.out.println("Bunitin todo recuperado");
        }else if(bucho > 0){
            numPatas += 1;
            calangoLive += 20;
            bucho -= 1;
            System.out.println("Uma pata regenerada");
        }else{
            System.out.println("Sem energia para me recuperar");
        }
    }

    void evoluir() {
        this.maxBucho += 20;
        this.numPatas += 2;
        System.out.println("Ora, rapaz! Agora tô turbinado com " + numPatas + " patas\n");
    }

    void batalha() {
        this.inimigo = Math.random() * 20;

        double enemyForce = Math.random() * 100;
        double enemyLive = Math.random() * 300;

        if(this.inimigo%2 != 0) {
            this.enemyAlive = true;

            System.out.println("O inimigo tem " + enemyForce + " pontos de força e " + enemyLive + " pontos de vida");

            while(this.enemyAlive) {
                this.calangoLive -= enemyForce;
                enemyLive -= this.calangoForce;

                System.out.println("Calango Life: " + calangoLive);
                System.out.println("Inimigo Life: " + enemyLive);

                if(enemyLive <= 0 && calangoLive > 0) {
                    System.out.println("Calango wins!");
                    this.enemyAlive = false;
                }else if(this.calangoLive <= 0){
                    System.out.println("Agora tô pistola!");
                    regenerar();
                }else if(enemyLive > 0 && calangoLive <= 0){
                    System.out.println("Inimigo wins!");
                    this.enemyAlive = false;
                }
            }
        }else{
            System.out.println("Que dia tranquilo!");
        }
    }

    public String toString() {
        return "Bucho " + bucho + "/" + maxBucho + " Patas: " + numPatas;
    }
    public static void main (String[] args) {

        Calango calangowerine = new Calango(0, 10, 4);
        System.out.println(calangowerine);

        calangowerine.andar();

        for(int i = 0; i < 12; i++) {
            calangowerine.comer(1);
        }

        System.out.println(calangowerine);

        calangowerine.acidente();
        calangowerine.acidente();
        calangowerine.acidente();

        calangowerine.regenerar();

        for(int i = 0; i < 22; i++) {
            calangowerine.comer(1);
        }

        System.out.println(calangowerine);

    }
}