package projetosPOO.projetoAncoradouro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class InfoShip {
    String[] subclasses;
    String construido;
    String tipo;
    String tonelagem;
    String comprimento;
    String altura;
    String propulsao;
    String velocidade;

    public InfoShip(String[] subclasses, String construido, String tipo, String tonelagem, String comprimento,  String altura, String propulsao, String velocidade) {
        this.subclasses = subclasses;
        this.construido = construido;
        this.tipo = tipo;
        this.tonelagem = tonelagem;
        this.comprimento = comprimento;
        this.altura = altura;
        this.propulsao = propulsao;
        this.velocidade = velocidade;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append("Tipo: " + tipo + "\nConstruído: " + construido + "\nTonelagem: " + tonelagem);
            output.append("\nComprimento: " + comprimento + "\nAltura: " + altura );
            output.append("\nPropulsão: " + propulsao + "\nVelocidade: " + velocidade);
            output.append("\nSubclasses:\n");
            for(int i = 0; i < subclasses.length; i++) {
                int pos = i+1;
                output.append(" -> " + pos + " =[ " + subclasses[i] + "\n");
            }
        return output.toString();
    }
}

class PortaContentor extends CargoShip {
    int maxContainers;
    int weightContainer;
    int currentContainer;
    int crewAmount;
    
    public PortaContentor(String name, String codeSeries, TypesShips type, int weightContainer) {
        super(name, codeSeries, type);
        this.maxContainers = type.weight;
        this.currentContainer = 0;    
        this.weightContainer = weightContainer;
        this.crewAmount = 0;
    }

    public void manageContainer(int value) {
        if(value > 0) {
            addContainer(value);
        }else{
            removeContainer(value);
        }
    }

    private void addContainer(int value) {
        if(currentContainer > maxContainers) {
            System.out.println("fail: Limite atingido\n");
            return;
        }else{
            this.currentWeight += value * weightContainer;
            currentContainer += value;
            System.out.println("Container(s) adicionado(s). Quantidade atual : " + currentContainer + "\n");
        }
    }

    private void removeContainer(int value) {
        if(currentContainer <= 0 ) {
            System.out.println("fail: Navio está sem nenhum container para ser retirado\n");
            return;
        }else{
            this.currentWeight += value * weightContainer;
            currentContainer += value;
            System.out.println("Container adicionado. O peso do navio é: " + currentContainer + "\n");
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(super.toString());
            output.append("Container: " + currentContainer + "/" + maxContainers + "\n\n");
        return output.toString();
    }

}

class FerriBoat extends CargoShip {
    String function;
    int maxPassagers;
    int currentPassagers;
    int maxProduct;
    int currentProduct;
    
    public FerriBoat(String name, String codeSeries, TypesShips type, String function, int maxPassagers, int maxProduct) {
        super(name, codeSeries, type);
        this.function = function;
        this.maxPassagers = maxPassagers;
        this.currentPassagers = 0;
        this.maxProduct = maxProduct;
        this.currentProduct = 0;
    }

    public void managePassagers(int value) {
        if(function.equals("viagem"))
            currentPassagers = manageFerriBoat(value);
        else
            System.out.println("\nFAIL: O navio não é do tipo viagem\n");
    }

    public void manageProducts(int value) {
        if(function.equals("cargueiro"))
            currentProduct = manageFerriBoat(value);
        else
            System.out.println("\nFAIL: O navio não é do tipo cargueiro\n");
    }

    public int manageFerriBoat(int value) {

        String message = this.function.equals("viagem") ? "passageiros" : "produtos";
        int currentValue = this.function.equals("viagem") ? currentPassagers : currentProduct;
        int maxValue = this.function.equals("viagem") ? maxPassagers : maxProduct;

        if(value > 0) {
            if(currentValue > maxValue) {
                System.out.println("fail: limite atingido\n");
            }else{
                this.currentWeight += value;
                currentValue += value;
                System.out.println(currentValue);
                System.out.println(value + " " + message + " " + "adicionados\n");
                return currentValue;
            }
        }else{
            if(currentValue == 0) {
                System.out.println("fail: Sem" + " " + message + " " + "a bordo\n");
            }else{
                this.currentWeight += value;
                currentValue += value;
                System.out.println(-value + " " + message + " " + "removidos\n");
                return currentValue;
            }
        }

        return currentValue;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(super.toString());
            output.append("Passagers: " + currentPassagers + "/" + maxPassagers);
            output.append("\nProducts: " + currentProduct + "/" + maxProduct + "\n\n");
        return output.toString();
    }
    
    
}

class Petroleiro extends CargoShip {
    ArrayList<String> routes = new ArrayList<>(Arrays.asList("Golfo Pérsico - Japão", "África Ocidental - Caribe", "Cruz-Mediterrâneo", "Golfo do México"));
    String betterRoute;
    String typeShip; 
    String typeOil;
    float API;
    final float maxOil = 300;
    float currentOilAmount;

    public Petroleiro(String name, String codeSeries, TypesShips type, String typeShip, float specificGravity) {
        super(name, codeSeries, type);
        this.typeShip = typeShip;
        this.currentOilAmount = 0;
        defineTypeOil(specificGravity);
        decideRoute();
    }

    public double calcApiValue(float specificGravity) {
        double calc = (141.5 / specificGravity) - 131.5;
        return calc;
    }

    public String defineTypeOil(float specificGravity) {
        double api = calcApiValue(specificGravity);
        this.API = (float) api; 
        if(api < 10)
            return typeOil = "Extra Pesado";
        if(api < 22.3)
            return typeOil = "Pesado";
        if(api >= 22.3 && api <= 31.1)
            return typeOil = "Médio";
        if(api > 31.1)
            return typeOil = "Leve";
        return "";
    }

    public void decideRoute() {
        switch(typeShip) {
            case "VLCC":
                betterRoute = routes.get(0);
                break;
            case "Suezmax":
                betterRoute = routes.get(1);
                break;
            case "Aframax":
                betterRoute = routes.get(2);
                break;  
            default:
                betterRoute = routes.get(3);
                break;
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(super.toString());
            output.append("Ship: " + typeShip);
            output.append("\nRoute: " + betterRoute);
            output.append("\nOil: " + typeOil + "/" + API +"\n\n");
        return output.toString();
    }

}

class Graneleiro extends CargoShip {

    TreeMap<String, Product> products;

    public Graneleiro(String name, String codeSeries, TypesShips type) {
        super(name, codeSeries, type);
        products = new TreeMap<>();
    }

    public void addProducts(String id, Product product) {
        if(products.isEmpty()) {
            products.put(id, product);
        } else {
            for(Product item : products.values()) {
                if(item.nome.equals(id))
                    System.out.println("fail: Esse produto já existe");
            }
        }
        products.put(id, product);
        System.out.println(id + " foi adicionado");
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(super.toString());
            for(Product product : products.values()) {
                output.append(product);
            }
        return output.toString();
    }
}

class Quimico extends CargoShip {
    String type1 = "substancias perigosas com efeitos graves para além da vizinhança imediata do navio";
    String type2 = "substancias perigosas que não têm efeitos graves para além da vizinhança imediata do navio";
    String type3 = "substancias menos perigosas para o meio ambiente";
    String description;

    ArrayList<String> types = new ArrayList<>(Arrays.asList(type1, type2, type3));

    int volume;
    int currentVolume;

    public Quimico(String name, String codeSeries, TypesShips type, String tipo) {
        super(name, codeSeries, type);
        this.volume = type.weight;
        this.currentVolume = 0;
        identifyDescription(tipo);
    }

    private void identifyDescription(String tipo) {
        int pos = Integer.parseInt(tipo.substring(5, 6));
        description = types.get(pos);
    }

    public void manageVolume(int value) {
        if(value > 0 && currentVolume < volume) {
            currentVolume += value;
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append(super.toString());
            output.append("Descrição: \nNavio com " + description + "\n");
        return output.toString();
    }
}