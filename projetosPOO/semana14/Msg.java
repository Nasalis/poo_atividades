package projetosPOO.semana14;

public class Msg {
    String userId;
    String text;

    public Msg(String userId, String text) {
        this.userId = userId;
        this.text = text;
    }

    public String toString() {
        return this.userId + ": " + this.text;
    }
}
