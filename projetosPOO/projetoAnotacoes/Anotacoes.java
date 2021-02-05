package projetosPOO.projetoAnotacoes;

import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;

class Notes {
    String title;
    String text;

    public Notes(String title, String text) {
        this.title = title;    
        this.text = text; 
    }

    public String toString() {
        return "Title: " + this.title.toUpperCase() + " <-> Text: " + this.text;
    }
}

class Users {
    String userName;
    String password;
    TreeMap<String, String> notes;

    public Users(String userName, String password) {
        this.userName = userName;    
        this.password = password;        
        this.notes = new TreeMap<>();
    }

    public boolean addNote(String title, String text) {
        notes.put(title, text);
        return true;
    }

    public String toString() {
        int pos = 0;
        StringBuilder output = new StringBuilder();
            for(Entry<String, String> note : notes.entrySet()) {
                output.append("[");
                output.append(pos + ":");
                output.append(note.getKey() + ":");
                output.append(note.getValue().replace("-", ", ").replace("^", " e ").replace("/", " "));
                pos++;
                output.append("]\n");
            }
        return output.toString();
    }

}

class Systema {
    Users currentUser;
    TreeMap<String, Users> users;

    public Systema() {
        this.currentUser = null;
        this.users = new TreeMap<>();
    }

    public boolean addUser(String userName, String password) {
        if(users.containsKey(userName))
            throw new RuntimeException("fail: já existe um usuário com esse nome");

        users.put(userName, new Users(userName, password));
        return true;
    }

    public void loginAccount (String userName, String password) {
        try {
            boolean name = users.get(userName).userName.equals(userName);
            boolean pass = users.get(userName).password.equals(password);

            if(pass == false)
                System.out.println("fail: senha não econtrada. Verifique");   
            else if(name && pass) {
                currentUser = users.get(userName);
                System.out.println("Conta de " + userName + " acessada");
                // System.out.println(currentUser.userName);
                return;
            }    
        }catch(RuntimeException e){
            System.out.println("fail: usuário não cadastrado");
        }
    }

    public void logoutAccount() {
        if(currentUser == null) {
            System.out.println("fail: ninguem logado");
            return;
        }
        else {
            System.out.println("Usuário " + currentUser.userName + " deslogado");
            currentUser = null;
            return;
        }
    }

    public void showAccountLogin() {
        String verifyLogin = "";
            verifyLogin += currentUser == null ? "fail: ninguem logado" :  ("user: " + currentUser.userName);
        System.out.println(verifyLogin);
        if(currentUser != null) {
            System.out.println(currentUser);
        }
    }

    public void addNotesList(String title, String text) {
        try {
            currentUser.addNote(title, text);
            System.out.println("Notas em " + "'" + title + "'" + " adicionadas");
        }catch(RuntimeException e ) {
            System.out.println("fail: não está logado em nenhuma conta");
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append("[ ");
            for(Users user : users.values())
                output.append(user.userName  + " ");
            output.append("]");
        return output.toString();
    }
}

public class Anotacoes {
    public static void main(String[] args) {
        Systema system = new Systema();
        Scanner scanner = new Scanner(System.in);
        boolean end = true;

        System.out.println("\nSeja bem-vindo ao sistema de notas! Veja os comados para integragir!");
        System.out.println("1 - 'end' para sair");
        System.out.println("2 - 'addUser' para cadastrar um novo usuário com nome e senha");
        System.out.println("3 - 'users' para verificar os usuários cadastrados");
        System.out.println("4 - 'login' acessará a conta de um usuário cadastrado");
        System.out.println("5 - 'logout' sai de uma conta específica logada no sistema");
        System.out.println("6 - 'show' exibe a conta logada atualmente");
        System.out.println("7 - 'addNotes' cria uma lista de notas. O primeiro valor é o título");
        System.out.println("     o segundo é uma linha encadeada de textos separados por '-',"); 
        System.out.println("     que representa o espaço e '^', indicando a conjunção 'e' para o último item da lista");
        System.out.println("     e '/' representa uma sentença composta, como 'comprar ovos', indicando uma única ação");
        System.out.println("     Exemplo de entrada: addNotes filmes Avatar-O/Ultimo/Selo-Hamilton-Mother!^Cemiter");


        while(end) {
            try {
                String line = scanner.nextLine();
                String[] ui = line.split(" ");

                switch (ui[0]) {
                    case "end":
                        end = false;
                        break;
                    case "addUser":
                        system.addUser(ui[1], ui[2]);
                        break;
                    case "users":
                        System.out.println(system);
                        break;
                    case "login":
                        system.loginAccount(ui[1], ui[2]);
                        break;
                    case "logout":
                        system.logoutAccount();
                        break;
                    case "show":
                        system.showAccountLogin();
                        break;
                    case "addNotes":
                        system.addNotesList(ui[1], ui[2]);

                }
            }catch(IndexOutOfBoundsException e) {
                System.out.println("fail: faltou completar o comando escrito");
            }catch(RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();

    }   
}
