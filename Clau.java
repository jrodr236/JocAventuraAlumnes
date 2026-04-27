public class Clau extends Item {
    private String IdPany;

    public Clau(String nom, String descripcio, boolean agafar) {
        super(nom, descripcio, agafar);
        this.IdPany = IdPany;
    }

    public String getIdpany() {
        return IdPany;
    }
}
