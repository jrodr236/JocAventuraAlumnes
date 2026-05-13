import java.util.Scanner;

public class JocAventura {
    private Jugador jugador;
    private Mapa mapa;

    public JocAventura() {
        this.mapa = new Mapa();
        this.jugador = new Jugador();
        this.jugador.setPosicioActual(mapa.getHabitacioInicial());
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
                    jugador.agafarItem(itemHabitacio);
                    jugador.getPosicioActual().treureItem();
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
                actiu = false;
                break;
            case "usar":
                if (parts.length > 1) {
                    String nomItem = parts[1];

                    Item item = jugador.buscarItem(nomItem);

                    if (item instanceof Clau clau) {

                        Habitacio actual = jugador.getPosicioActual();

                        if (actual instanceof HabitacioAmbPortaTancada tancada) {

                            if (tancada.intentarObrir(clau)) {
                                System.out.println(" Has obert la porta!");
                            } else {
                                System.out.println(" Aquesta clau no funciona.");
                            }

                        } else {
                            System.out.println("Aquí no hi ha res per obrir.");
                        }

                    } else {
                        System.out.println("No tens aquesta clau.");
                    }

                } else {
                    System.out.println("Què vols usar?");
                }
                break;

            default:
                System.out.println("No sé com fer això.");
                break;
        }
        return actiu;
    }
}