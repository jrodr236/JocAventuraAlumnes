public class Clau extends Item {
    private String idPany;

    public Clau(String nom, String descripcio, String idPany) {
        super(nom, descripcio);
        this.idPany = idPany;
    }

    public String getIdPany() {
        return idPany;
    }
}
