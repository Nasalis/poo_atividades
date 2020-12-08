/*
package aula05;

enum Moeda {
    M10(0.10f, 1),
    M25(0.25f, 2),
    M50(0.50f, 3),
    M100(1f, 4);

    float valor;
    int volume;

    Moeda(float valor, int volume) {
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + "\nVolume: " + valor + "\n";
    }
}

class Coisa {
    String descricao;
    int volume;

    Coisa(String descricao, int volume) {
        this.descricao = descricao;
        this.volume = volume;
    }

    public String toString() {
        return "Descricao:" + descricao + "\nVolume: " + volume + "\n";
    }
}



class Porco{
    String coisa = "";
    float valor = 0.0f;
    int volume = 0;
    int volumeMax;
    boolean estaQuebrado = false;
    
    Porco(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    boolean adicionarDinheiro(Moeda moeda){
        if(estaQuebrado){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(moeda.volume + this.volume > this.volumeMax){
            System.out.println("Porco esta lotado");
            return false;
        }
        this.valor += moeda.valor;
        this.volume += moeda.volume;
        return true;
    }
    
    boolean adicionarCoisa(Coisa coisa) {
        if(coisa.volume > volumeMax) {
            System.out.println("Objeto insuportável no cofre");
            return false;
        }
        this.volume += coisa.volume;
        return true;
    }

    float pegarDinheiro() {
        if(estaQuebrado == false) {
            
        }
    } 
}

public class Riquinho{
    public static void main(String[] args) {
        Porco porco = new Porco(40);
        Moeda moeda = Moeda.M100;
    }
}

*/