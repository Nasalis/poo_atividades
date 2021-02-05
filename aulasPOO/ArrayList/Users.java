package ArrayList;

public class Users {
    private String nome;
    private String sobrenome;

    Users(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public void setSobreNome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getName() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
