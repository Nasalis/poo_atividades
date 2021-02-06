package projetosPOO.projetoAncoradouro;

import java.util.Scanner;
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

    public void typeShip() {
        System.out.println("________________________________________________");
        System.out.println("\n[]-[]-[]- |_ TIPOS DE NAVIOS _| -[]-[]-[]\n");
        System.out.println("1 - GR - sigla para Graneleiro");
        System.out.println("2 - FB - sigla para FerriBoat");
        System.out.println("3 - PT - sigla para Petroleiro");
        System.out.println("4 - PC - sigla para PortaContentor");
        System.out.println("5 - QU - sigla para Quimico");
        System.out.println("________________________________________________");

    }

    public void rulesRegister() {
        System.out.println("\n[]-[]-[]- PARAMETROS DE REGISTRO DE NAVIOS -[]-[]-[]\n");
        System.out.println("1 - Todos os navios precisam de um nome, código de identificação e a sigla do seu tipo declrados");
        System.out.println("  1.1 - Para ver a lista de tipos de navios, digite 'registerShip'");
        System.out.println("2 - Graneleiro:");
        System.out.println("  - Esse navio não terá parâmetros adicionais");
        System.out.println("3 - FerriBoat:");
        System.out.println("  - Deve-se informar a sua função (viagem ou cargueiro) e a quantidade máxima de passageitos e produtos");
        System.out.println("4 - Petroleiro:");
        System.out.println("  - Informar-se-á a classe do navio e a gravidade específica do petróleo");
        System.out.println("5 - PortaContentor:");
        System.out.println("  - Informa-se o peso uniforme dos containers a serem transportados");
        System.out.println("6 - Quimico:");
        System.out.println("  - Como parâmetro, somente o seu tipo (tipo-1, tipo-2, tipo-3) para a escolha da rota\n");
        System.out.println("Para especificações de cada navio, digite 'seeInfos' e o nome do navio");
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

       

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("\nSeja bem-vindo ao sistema de notas! Veja os comados para integragir!");
        System.out.println("1 - 'end' para sair");
        System.out.println("2 - 'registerShip' registrará um novo navio com nome, código de identificação e a sigla do seu tipo");
        System.out.println("     contudo cada tipo de navio contém parâmetros adicionais únicos de registro");
        System.out.println("     para consultá-los, digite 'rulesRegister'");  
        System.out.println("3 - 'typesShip' exibirá uma lista com os tipos de navio do ancoradouro");
        System.out.println("4 - 'show' exibe a lista de navios registrados");
        System.out.println("5 - 'manageShip' será o comando para efeutar ações nos navios");
        System.out.println("  -  Graneleiro: poderá adicionar um produto, com nome, origem, destino e quantidade;");
        System.out.println("  -  FerriBoat: poderá manusear a quantidade de passageiros ou produtos de acordo com sua função;");
        System.out.println("  -  PortaContentor: poderá administrar a quantidade de containers;");
        System.out.println("  -  Quimico: poderá administrar o volume que carrega a bordo;");

        while(running) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            try {
                switch (ui[0]) {
                    case "end":
                        running = false;
                        break;
                    case "registerShip": {
                        if(ui[3].equals("GR")) {
                            ancoradouro.ships.put(ui[1], new Graneleiro(ui[1], ui[2], TypesShips.GR));
                        }else if(ui[3].equals("FB")) {
                            ancoradouro.ships.put(ui[1], new FerriBoat(ui[1], ui[2], TypesShips.GR, ui[4], Integer.parseInt(ui[5]), Integer.parseInt(ui[6])));
                        }else if(ui[3].equals("PT")) {
                            ancoradouro.ships.put(ui[1], new Petroleiro(ui[1], ui[2], TypesShips.PT, ui[4], Float.parseFloat(ui[5])));
                        }else if(ui[3].equals("PC")) {
                            ancoradouro.ships.put(ui[1],new PortaContentor(ui[1], ui[2], TypesShips.PC, Integer.parseInt(ui[4])));
                        }else if(ui[3].equals("QU")) {
                            ancoradouro.ships.put(ui[1], new Quimico(ui[1], ui[2], TypesShips.QU, ui[4]));
                        }
                        break;
                    }
                    case "rulesRegister":
                        ancoradouro.rulesRegister();
                        break;
                    case "typesShip":
                        ancoradouro.typeShip();;
                        break;
                    case "seeInfos":
                        if(ancoradouro.ships.get(ui[1]) instanceof CargoShip) {
                            CargoShip ship = (CargoShip) ancoradouro.ships.get(ui[1]);
                            ancoradouro.seeInfos(ship);
                        }
                        break;
                    case "manageShip":
                        if(ancoradouro.ships.get(ui[1]) instanceof Graneleiro) {
                            Graneleiro ship = (Graneleiro) ancoradouro.ships.get(ui[1]);
                            ship.addProducts(ui[2], new Product(ui[2], ui[3], ui[4], Integer.parseInt(ui[5])));

                        }else if(ancoradouro.ships.get(ui[1]) instanceof FerriBoat) {
                            FerriBoat ship = (FerriBoat) ancoradouro.ships.get(ui[1]);
                            if(ui[2].equals("pass"))
                                ship.managePassagers(Integer.parseInt(ui[3]));
                            else if(ui[2].equals("product"))
                                ship.manageProducts(Integer.parseInt(ui[3]));

                        }else if(ancoradouro.ships.get(ui[1]) instanceof PortaContentor) {
                            PortaContentor ship = (PortaContentor) ancoradouro.ships.get(ui[1]);
                            ship.manageContainer(Integer.parseInt(ui[2]));
                        }else if(ancoradouro.ships.get(ui[1]) instanceof Quimico) {
                            Quimico ship = (Quimico) ancoradouro.ships.get(ui[1]);
                            ship.manageVolume(Integer.parseInt(ui[2]));
                        }
                        break;
                    case "show":
                        System.out.println(ancoradouro);
                        break;
                }
            }catch(IndexOutOfBoundsException e) {
                System.out.println("Fail: Esqueceu uma parte do comando. Verifique");
            }
        }

        scanner.close();
        
    }
}