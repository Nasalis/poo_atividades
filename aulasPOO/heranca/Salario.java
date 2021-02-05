package heranca;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Funcionario {
    String nome;
    int max_diarias;
    int qtd_diarias;
    double salario;
    double bonus;
    String job;

    public Funcionario(String nome, int max_diarias) {
        this.nome = nome;
        this.max_diarias = max_diarias;
        this.qtd_diarias = 0;
        salario = 0;
    }
}

class Professor extends Funcionario {
    char classe;

    public Professor(String nome, int max_diarias, char classe) {
        super(nome, max_diarias);
        this.classe = classe;
        this.job = "Prof";
        calcSalario(classe);
    }

    public double calcSalario(char classe) {
        String classes = "ABCDE";
        Double[] salarios = {3000.0, 5000.0, 7000.0, 9000.0, 11000.0};

        for(int i = 0; i < classes.length(); i++) {
            if(classes.charAt(i) == classe)
                return this.salario = salarios[i];
        }
        return this.salario = 0;
    }

    public String info(String nome, String job, String classe, double salario ) {
        StringBuilder output = new StringBuilder();
            output.append(job + " " + nome + " classe: " + classe + "\n");
            output.append("salario: " + salario);
        return output.toString();
    }

    public String toString() {
        return "prof" + ":" + nome + ":" + classe + ":" + salario; 
    }
}

class STA extends Funcionario {
    int nivel;

    public STA(String nome, int max_diarias, int nivel) {
        super(nome, max_diarias);
        this.nivel = nivel;
        this.job = "Sta";
        calcSalario(nivel);
    }

    public double calcSalario(int nivel) {
        return this.salario += 3000 + 300*nivel;
    }

    public String toString() {
        return "sta" + ":" + nome + ":" + nivel + ":" + salario; 
    }
}


class Terceirizado extends Funcionario {
    int horas_trab;
    boolean insalubre;

    public Terceirizado(String nome, int max_diarias, int horas_trab, boolean insalubre) {
        super(nome, max_diarias);
        this.horas_trab = horas_trab;    
        this.insalubre = insalubre;
        this.job = "Ter";
        calcSalario(horas_trab, insalubre);
    }

    public double calcSalario(int horas_trab, boolean insalubre) {
        return this.salario += 4 * horas_trab + addDiaria(insalubre);
    }

    public double addDiaria(boolean insalubre) {
        double adicional = 0;
        adicional += insalubre == true ? 500.0 : 0;
        return adicional;
    }

    public String toString() {
        String formatInsalubre = "";
        formatInsalubre += insalubre == true ? "sim" : "nao";
        return "ter" + ":" + nome + ":" + horas_trab + ":" + formatInsalubre + ":" + salario; 
    }
}

public class Salario {

    ArrayList<Funcionario> funcionarios;

    public Salario() {
        funcionarios = new ArrayList<>();
    }

    public void removerFuncionario(String name) {
        int index = 0;

        for(int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).nome.equals(name)) {
                index = i;
                break;
            }
        }

        System.out.println(name + " foi removido");
        funcionarios.remove(index);
    }

    public void addDiaria(String name) {
        for(int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).nome.equals(name)) {
                if(verifyAddDiaria(funcionarios.get(i))) {
                    funcionarios.get(i).qtd_diarias++;
                    funcionarios.get(i).salario += 100;
                    return;
                }else{
                    System.out.println("fail: limite de diarias atingido");
                    return;
                }
            }
        }
    }

    private boolean verifyAddDiaria(Funcionario funcionario) {
        if(funcionario.qtd_diarias < funcionario.max_diarias && funcionario.max_diarias != 0){
            return true;
        }else{
            return false;
        }
    }

    public String showFuncionarioInfo(String name) {

        for(int i = 0; i < funcionarios.size(); i++) {
            if(funcionarios.get(i).nome.equals(name)) {
                if(funcionarios.get(i) instanceof Professor) {
                    Professor func = (Professor) funcionarios.get(i);
                    System.out.println(func.job + " " + func.nome + " classe: " + func.classe); 
                    System.out.println("salario: " + func.salario);
                }else if(funcionarios.get(i) instanceof STA) {
                    STA func = (STA) funcionarios.get(i);
                    System.out.println(func.job + " " + func.nome + " nivel: " + func.nivel);
                    System.out.println("salario: " + func.salario);
                }else if(funcionarios.get(i) instanceof Terceirizado) {
                    Terceirizado func = (Terceirizado) funcionarios.get(i);
                    System.out.println(func.job + " " + func.nome + " horas: " + func.horas_trab);
                    System.out.println("insalubre" + func.insalubre + "salario: " + func.salario);
                }
            }
        }

        return "fail: funcionário nao encontrado";
    }

    public void setBonus(double value) {
        double valueDivided = value/funcionarios.size();

        for(Funcionario func : funcionarios) {
            func.salario += valueDivided;
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            for(Funcionario func : funcionarios) {
                output.append(func + "\n");
            }
       return output.toString();
    }

    public static void main(String[] args) {
        Salario sistema = new Salario();
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while(exit) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            switch(ui[0]) {
                case "end":
                    exit = false;
                    break;
                case "addProf":
                    sistema.funcionarios.add(new Professor(ui[1], 2, ui[2].charAt(0)));
                    break;
                case "addSta":
                    sistema.funcionarios.add(new STA(ui[1], 1, Integer.parseInt(ui[2])));
                    break;
                case "addTer":
                    sistema.funcionarios.add(new Terceirizado(ui[1], 0, Integer.parseInt(ui[2]), Boolean.parseBoolean(ui[3])));
                    break;
                case "remove":
                    sistema.removerFuncionario(ui[1]);
                    break;
                case "addDiaria":
                    sistema.addDiaria(ui[1]);
                    break;
                case "bonus":
                    sistema.setBonus(Double.parseDouble(ui[1]));
                    break;
                case "showFunc":
                    sistema.showFuncionarioInfo(ui[1]);
                    break;
                case "showAll": {
                    System.out.println(sistema);
                    break;
                }

            }
        }
        scanner.close();
    }
}
