public class Mapa {
    private Habitacio habitacioInicial;

    public Mapa() {
        Habitacio entrada = new Habitacio(
                "Entrada del Castell",
                "Una porta de ferro massís bloqueja el camí enrere. Està fosc."
        );
        habitacioInicial = entrada;

        Habitacio passadisLlarg = new Habitacio(
                "Passadís Llarg",
                "Un passadís ple de teranyines. Sents passes al fons."
        );
        Habitacio passadisCurt = new Habitacio(
                "Passadís Curt",
                "Un passadís ple de teranyines pero mes curt. Sents passes al fons, pero un fons que esta mes aprop."
        );
        Habitacio biblioteca = new Habitacio(
                "Biblioteca",
                "Milers de llibres vells agafen pols. Hi ha una olor dolça."
        );
        HabitacioFosca fosca = new HabitacioFosca(
                "Fosca",
                "Tinc po."
        );
        Habitacio oculta = new Habitacio(
                "Oculta",
                "Una habitació meravellosa, però necessites el DLC per a poder-la gaudir."
        );
        HabitacioAmbPortaTancada tancada = new HabitacioAmbPortaTancada(
                "Tancada",
                "Et trobas davant una porta tancada mes gran que en ratatui, veig que no poseeixes l'objecta necessari per proseguir la teva aventura, dona mitja volta i marxa",
                "clau1"
        );
        HabitacioCofre salaTresor = new HabitacioCofre(
                "Sala del Tresor",
                "Una habitació plena de joies i or."
        );

        Llanterna llanterna = new Llanterna("Llanterna", "Una llanterna que illumina les habitacions fosques.");
        Clau clau = new Clau("Clau", "Una clau.", "clau1");
        Item estrella = new Item("Estrella", "Un objecte màgic en forma d'estrella.");

        biblioteca.setItem(llanterna);
        passadisLlarg.setItem(clau);
        fosca.setItem(estrella);

        entrada.setSortida(Direccio.NORD, passadisLlarg);
        passadisLlarg.setSortida(Direccio.SUD, entrada);
        passadisLlarg.setSortida(Direccio.EST, biblioteca);
        passadisLlarg.setSortida(Direccio.OEST, fosca);
        passadisLlarg.setSortida(Direccio.NORD, tancada);
        tancada.setSortida(Direccio.SUD, passadisLlarg);
        tancada.setSortida(Direccio.NORD, passadisCurt);
        tancada.setSortidaOculta(Direccio.EST, oculta);
        oculta.setSortida(Direccio.OEST, tancada);
        passadisCurt.setSortida(Direccio.NORD, salaTresor);
        passadisCurt.setSortida(Direccio.SUD, tancada);
        fosca.setSortida(Direccio.EST, passadisLlarg);
        biblioteca.setSortida(Direccio.OEST, passadisLlarg);
        salaTresor.setSortida(Direccio.SUD, passadisCurt);
    }

    public Habitacio getHabitacioInicial() {
        return habitacioInicial;
    }
}
