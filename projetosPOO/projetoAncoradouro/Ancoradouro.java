package projetosPOO.projetoAncoradouro;

import java.util.TreeMap;

interface Actions {
    int removeLoad(int quantity);
    int adicionarLoad(int quantity);
}

class Ship implements Actions {
    String name;
    String codeSeries;
    int capacity;
    int currentWeight;

    public Ship(String name, String codeSeries, int capacity) {
        this.name = name;    
        this.codeSeries = codeSeries;    
        this.capacity = capacity;
    }

    public int adicionarLoad(int quantity) {
        if(this.currentWeight > capacity) {
            this.currentWeight = capacity;
            return currentWeight;
        }else{
            int calc = this.currentWeight + quantity;
            System.out.println(quantity + " cargas foram adicionadas");
            System.out.println("Quantidade de carga atual: " + calc);
            return this.currentWeight += quantity;
        }
    }

    public int removeLoad(int quantity) {
        if(this.currentWeight == 0) {
            System.out.println("fail: O navio não armazena nenhuma carga para ser retirada");
            return currentWeight;
        }else{
            int calc = currentWeight - quantity;
            System.out.println(quantity + " cargas foram removidas");
            System.out.println("Quantidade de carga atual: " + calc);
            return currentWeight -= quantity;
        }
    }

    public String toString() {
        return "Name: " + name + " | " + "Code-Series: " + codeSeries + " | " + "Current-Occupation: " + currentWeight + "/" + capacity;
    }
}

class CargoShip extends Ship {
    TypesShips type;

    public CargoShip(String name, String codeSeries, TypesShips type) {
        super(name, codeSeries, type.weight);
        this.type = type;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append("Name: " + name + "\nCodeSeries: " + codeSeries + "\nCapacity: " + currentWeight + "/" + capacity);
            output.append("\nType:\n - " + type + "\n");
        return output.toString();
    }
}

public class Ancoradouro {
    TreeMap<String, Ship> ships;

    public Ancoradouro() {
        ships = new TreeMap<>();
    }

    public void seeInfos(CargoShip ship) {
        switch(ship.type.sigla) {
            case "PC": {
                String[] subclasses = {"Engrenado", "Cargueiro", "Panamax", "Alimentador"};
                InfoShip info = new InfoShip(subclasses, "1956-presente", "Navio de contêineres", "até 24.000 TEU", "300m", "Mais de 20", "Tipicamente diesel desde 1990", "Tipicamente 16-25 nós (30-46 km/h)");
                System.out.println(info);
                break;
            }
            case "FB": {
                String[] subclasses = {"Dupla-ended", "Hidrofólio", "Hovercraft", "Catamarã"};
                InfoShip info = new InfoShip(subclasses, "século IV - presente", "Balsa", "variável", "variável", "variável", "diesel convencional em alguns tipos", "60,2 nós (111,5 km/h)");
                System.out.println(info);
                break;
            }
            case "PT": {
                String[] subclasses = {"Handysize" , "Panamax" , "Aframax" , "Suezmax" , "Very Large Crude Carrier (VLCC)", "Ultra Large Crude Carrier (ULCC)"};
                String tipo = "Petroleiro, 	Navio tanque";
                InfoShip info = new InfoShip(subclasses, "1963-presente", tipo, "até 550.000  DWT", "máximo de 458,45m", "indefinido", "indefinido", "indefinido");
                System.out.println(info);
                break;
            }
            case "GR": {
                String[] subclasses = {"Handymax", "Handysize", "Panamax", "Capesize"};
                InfoShip info = new InfoShip(subclasses, "1850-presente", "Graneleiro", "até 400.000 DWT", "300m", "Mais de 20", "Motor diesel de 2 tempos e 1 hélice", "12 nós");
                System.out.println(info);
                break;
            }
            case "QU":{
                String[] subclasses = {"sem subclasses"};
                InfoShip info = new InfoShip(subclasses, "indefinido", "Químico", "média de 37 000 TDW", "180m", "variável", "indefinido", "indefinido");
                System.out.println(info);
                break;
            }
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        int listPosition = 0;
            for(Ship ship : ships.values()) {
                output.append("-[]-[]-> Ship " + listPosition + " <-[]-[]-\n");
                output.append((CargoShip) ship);
                listPosition++;
            }
        return output.toString();
    }

    public static void main(String[] args) {
        Ancoradouro ancoradouro = new Ancoradouro();

        ancoradouro.ships.put("Windstoß", new Graneleiro("Windstoß", "C-634", TypesShips.GR));
        ancoradouro.ships.put("SharCross",new FerriBoat("SharCross", "F-124", TypesShips.FB, "viagem", 400, 500));
        ancoradouro.ships.put("Wortlos", new Petroleiro("Wortlos", "J-342", TypesShips.PT, "Suezmax", 0.4f));
        ancoradouro.ships.put("Ehre", new PortaContentor("Ehre", "X-2324", TypesShips.PC, 20));
        ancoradouro.ships.put("Übermensch", new Quimico("Übermensch", "Z-1664", TypesShips.QU, "tipo-2"));

        if(ancoradouro.ships.get("Windstoß") instanceof Graneleiro) {
            Graneleiro graneleiro = (Graneleiro) ancoradouro.ships.get("Windstoß");
            graneleiro.addProducts("banana", new Product("banana", "Brasil", "Alemanha", 500));
            graneleiro.addProducts("café", new Product("café", "Brasil", "EUA", 500));
            graneleiro.addProducts("arroz", new Product("arroz", "Japão", "China", 500));
        }

        System.out.println(ancoradouro);

        System.out.println("-----------------------------\n");

        if(ancoradouro.ships.get("Ehre") instanceof CargoShip) {
            CargoShip ship = (CargoShip) ancoradouro.ships.get("Ehre");
            ancoradouro.seeInfos(ship);
        }
        
    }
}