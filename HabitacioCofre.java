public class HabitacioCofre extends Habitacio {
    private boolean obert;

    public HabitacioCofre(String nom, String descripcio) {
        super(nom, descripcio);
        this.obert = false;
    }

    public void obrirCofre(Jugador jugador) {
        if (!obert) {
            obert = true;
            System.out.println("FELICITATS!");
            System.out.println("Has obert el cofre del tresor i has guanyat l'aventura!");
            System.exit(0);
        } else {
            System.out.println("El cofre ja estava obert.");
        }
    }

    @Override
    public String toString() {
        String text = super.toString();
        if (!obert) {
            text += "\nHi ha un cofre daurat brillant aquí.";
        }
        return text;
    }
}