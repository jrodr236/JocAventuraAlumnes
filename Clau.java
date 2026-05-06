public class Clau extends Item {
    private String idPany;

    public Clau(String nom, String descripcio, boolean agafar, String idPany) {
        super(nom, descripcio, agafar);
        this.idPany = idPany;
    }

    public String getidPany() {
        return idPany;
    }
}
