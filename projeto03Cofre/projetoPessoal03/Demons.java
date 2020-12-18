package projeto03Cofre.projetoPessoal03;

class SoulsList {
    private int amountSouls;
    private String name;
    private String natureSouls;
    private String infoAbout;


    public SoulsList(int amountSouls, String name, String natureSouls, String infoAbout) {
        this.name = name;
        this.amountSouls = amountSouls;
        this.natureSouls = natureSouls;
        this.infoAbout = infoAbout;
    }
    
    public int getAmountSouls() {
        return amountSouls;
    }

    public void setAmountSouls(int amountSouls) {
        this.amountSouls = amountSouls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNatureSouls() {
        return natureSouls;
    }

    public void setNatureSouls(String natureSouls) {
        this.natureSouls = natureSouls;
    }

    public String getInfoAbout() {
        return infoAbout;
    }

    public void setInfoAbout(String infoabout) {
        this.infoAbout = infoabout;
    }
}