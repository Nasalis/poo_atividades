package projetosPOO.semana14;

import java.util.List;
import java.util.ArrayList;


public class Inbox {
    User user;
    List<Msg> mensages;

    public Inbox(User user) {
        this.user = user;
        this.mensages = new ArrayList<>();
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(user);
            for(Msg msg : mensages) {
                output.append(msg);
            }
        return output.toString();
    }
}
