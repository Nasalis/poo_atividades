package projetosPOO.projetoAncoradouro;

public enum TypesShips {
    PC("PC", "Porta Contentor", 4000),
    FB("FB", "Ferri Boat", 3000),
    PT("PT", "Petroleiro", 2000),
    GR("GR", "Graneleiro", 1500),
    QU("QU", "Químico", 3200);

    String sigla;
    String name;
    int weight;

    TypesShips(String sigla, String name, int weight) {
        this.sigla = sigla;
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return "" + sigla + " - " + name + " - " + weight;
    }

}
