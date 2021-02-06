package projetosPOO.projetoAncoradouro;

public class Product {
    String nome;
    String origins;
    String destiny;
    int quantity;
    int productAmount;

    public Product(String nome, String origins, String destiny, int quantity) {
        this.nome = nome;
        this.quantity = quantity;
        this.origins = origins;
        this.destiny = destiny;
        this.productAmount = quantity;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
            output.append("-----------------\n");
            output.append("Nome: " + nome + "\nProduct Amount: " + productAmount);
            output.append("\nOrigins: " + origins + "\nDestiny" + destiny);
            output.append("\n-----------------\n\n");
        return output.toString();
    }
}
