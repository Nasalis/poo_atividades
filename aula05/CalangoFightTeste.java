package aula05;

class Inseto {
    int tamanho;
    int energia;
    Inseto(int tamanho, int energia){
        this.tamanho = tamanho;
        this.energia = energia;
    }

    public String toString() {
        return "Tamanho: " + tamanho + " Energia: " + energia;
    }
}

class Calango {
    Inseto barriga;
    int energia; //atributos
    int maxEnergia;
    int nPatas;
    int vida;
    boolean alive;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxEnergia){ //parametros
        this.energia = maxEnergia;
        this.maxEnergia = maxEnergia;
        this.nPatas = 4;
        this.vida = 4;
        this.alive = true;
        this.barriga = null;
    }

    boolean comer (Inseto Inseto){
        if(this.barriga != null){
            System.out.println("Barriga esta cheia");
            return false;
        }
        if(Inseto.tamanho > 3){
            System.out.println("Inseto muito grande");
            return false;
        }
        barriga = Inseto;
        return true;
    }

    Inseto vomitar() {
        if(barriga == null) {
            System.out.println("Barriga vazia");
            return null;
        }
        Inseto aux = barriga;
        barriga = null;
        return aux;
    }

    void digerir(){
        if(barriga == null) {
            System.out.println("Não tem o que digerir");
            return;
        }
        energia += barriga.energia;
        if(energia > maxEnergia){
            energia = maxEnergia;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
        barriga = null;
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(energia > 0){
            if(energia < dist){
                System.out.println("Andei só " + energia);
                energia = 0;
                return;
            }
            energia -= dist;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void brigar(Calango other){
        if(!this.alive){
            System.out.println("Morto nao luta");
            return;
        }
        if(other.nPatas > 0){
            other.nPatas -= 1;
            System.out.println("Arranquei uma pata sua com meu Ninjutso");
        }else{
            System.out.println("Morra com meu golpe do dedo das 4 folhas!!");
            other.alive = false;
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (energia > 0){
            nPatas += 1;
            energia -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "energia: " + energia + "/" + maxEnergia + " Patas: " + nPatas  + " Alive:" + alive + " Barriga: " + barriga;
    }
}


public class CalangoFightTeste {
    public static void main(String[] args) {
        Calango dead = new Calango(100);
        Inseto barata = new Inseto(1, 10);

        dead.andar(50);
        dead.comer(barata);
        System.out.println(dead);
        dead.digerir();
        dead.vomitar();
        System.out.println(dead);
    }
}
