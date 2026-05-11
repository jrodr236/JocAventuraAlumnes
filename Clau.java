public class Clau extends Item {
    private String idPany;

    public Clau(String idPany) {
        super("clau", "Una Clau", true);
        this.idPany = idPany;
    }

    public String getidPany() {
        return idPany;
    }
}
