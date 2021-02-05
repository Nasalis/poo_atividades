package aula05;

class CalangoFight {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    boolean alive = true;

    //mesmo nome da classe = sombreamento de variavel
    CalangoFight(int bucho, int maxBucho, int nPatas){ //parametros
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

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void brigar(CalangoFight other){
        if(!this.alive){
            System.out.println("Maguila: 'Faleceu'" + "\n");
            return;
        }

        if(other.nPatas > 0){
            other.nPatas -= 1;
            System.out.println("Arranquei uma pata sua!");
        }else{
            System.out.println("Já arranquei todas as patas!!");
            other.alive = false;
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
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " Alive: " + alive;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        CalangoFight deadlango = new CalangoFight(0, 20, 4);
        CalangoFight pool = new CalangoFight(0, 20, 4);

        System.out.println(deadlango);
        System.out.println(pool);

        deadlango.brigar(pool);

        System.out.println(deadlango);
        System.out.println(pool);

    }
}

