public class Item {
        private String nom;
        private String descripcio;

        public Item(String nom, String descripcio) {
            this.nom = nom;
            this.descripcio = descripcio;
        }

        public String getNom() { return nom; }

        public String getDescripcio() { return descripcio; }

        @Override
        public String toString() {
            return nom + ": " + descripcio;
        }
}

