
import java.util.Scanner;

public class JocAventura {
    private HabitacioTancada tencada;
    private Jugador jugador;

    public JocAventura() {
        Habitacio entrada    = new Habitacio("Entrada del Castell", "Una porta de ferro massís bloqueja el camí enrere. Està fosc.");
        this.jugador = new Jugador(entrada);
        Habitacio passadis   = new Habitacio("Passadís Llarg",      "Un passadís ple de teranyines. Sents passes al fons.");
        Habitacio passadis2   = new Habitacio("Passadís Curt",      "Un passadís ple de teranyines pero mes curt. Sents passes al fons, pero un fons que esta mes aprop.");
        Habitacio biblioteca = new Habitacio("Biblioteca",           "Milers de llibres vells agafen pols. Hi ha una olor dolça.");
        Habitacio fosca = new Habitacio_fosca("Fosca",           "Timc po.",jugador);
        tencada= new HabitacioTancada("Tencada","Et trobas davant una porta tencada mes gran que en ratatui, veig que no poseeixes l'objecta necessari per proseguir la teva aventura, dona mitja volta i marxa","clau");



        // Creem l'ítem i el posem a la biblioteca
        Llanterna llanterna = new Llanterna();

        biblioteca.setItem(llanterna);

        Clau clau = new Clau("clau");
        passadis.setItem(clau);

        entrada.setSortida(Direccio.NORD, passadis);
        passadis.setSortida(Direccio.SUD, entrada);
        passadis.setSortida(Direccio.EST, biblioteca);
        biblioteca.setSortida(Direccio.OEST, passadis);
        passadis.setSortida(Direccio.NORD, tencada);
        passadis.setSortida(Direccio.OEST,fosca);
        tencada.setSortida(Direccio.SUD,passadis);
        fosca.setSortida(Direccio.EST,passadis);
    }

    public void executar() {
        System.out.println("BENVINGUT A L'AVENTURA TEXTUAL");
        System.out.println("Escriu 'ajuda' per veure les comandes disponibles.");
        System.out.println(jugador.getPosicioActual());

        try (Scanner teclat = new Scanner(System.in)) {
            boolean actiu = true;
            while (actiu) {
                System.out.print("\n> ");
                String[] parts = teclat.nextLine().toLowerCase().trim().split("\\s+");
                if (parts.length == 0 || parts[0].isEmpty()) continue;
                actiu = executarComanda(parts);
            }
        }
    }

    private boolean executarComanda(String[] parts) {
        boolean actiu = true;
        switch (parts[0]) {
            case "anar":
                if (parts.length > 1) {
                    Direccio dir = Direccio.desDeString(parts[1]);
                    if (dir != null) {
                        jugador.moureA(dir);
                    } else {
                        System.out.println("Aquesta direcció no existeix.");
                    }
                } else {
                    System.out.println("Anar on?");
                }
                break;

            case "mirar":
                System.out.println(jugador.getPosicioActual());
                break;

            case "agafar":
                Item itemHabitacio = jugador.getPosicioActual().getItem();
                if (itemHabitacio != null) {
                    if (itemHabitacio.isAgafable()) {
                        jugador.agafarItem(itemHabitacio);
                        jugador.getPosicioActual().treureItem();
                    } else {
                        System.out.println("No pots agafar això, no es pot moure.");
                    }
                } else {
                    System.out.println("No hi ha res aquí per agafar.");
                }
                break;

            case "inventari":
                jugador.mostrarInventari();
                break;

            case "obrir":
                if (parts.length > 1 && parts[1].equals("cofre")) {
                    Habitacio actual = jugador.getPosicioActual();
                    if (actual instanceof HabitacioCofre) {
                        ((HabitacioCofre) actual).obrirCofre(jugador);
                    } else {
                        System.out.println("Aquí no hi ha cap cofre per obrir.");
                    }
                } else {
                    System.out.println("Obrir què? Usa 'obrir cofre'.");
                }
                break;

            case "ajuda":
                System.out.println("Comandes disponibles:");
                System.out.println("  anar [direcció] - Mou-te en una direcció (nord, sud, est, oest)");
                System.out.println("  mirar           - Observa l'habitació actual");
                System.out.println("  ajuda           - Mostra aquesta llista de comandes");
                System.out.println("  sortir          - Acaba la partida");
                System.out.println("  agafar          - Agafar l'Ítem que trobis");
                System.out.println("  inventari       - Mostrar el teu inventari d'Ítems");
                System.out.println("  obrir cofre     - Obre el cofre (si n'hi ha un a l'habitació)");
                break;

            case "sortir":
                System.out.println("Fins la pròxima!");
                return false;
            default:
                System.out.println("No sé com fer això.");
                break;
        }
        return true;
    }




}