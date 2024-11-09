class Banque2 {

    public static void main(String[] args) {
        // Créer les clients avec leurs comptes
        Client client1 = new Client("Pedro", "Geneve", true, 1000.0, 0.01, 2000.0, 0.02);
        Client client2 = new Client("Alexandra", "Lausanne", false, 3000.0, 0.01, 4000.0, 0.02);

        // Afficher les données avant le bouclement des comptes
        System.out.println("Donnees avant le bouclement des comptes:");
        client1.afficherClient();
        client2.afficherClient();

        // Boucler les comptes des clients
        client1.bouclerComptes();
        client2.bouclerComptes();

        // Afficher les données après le bouclement des comptes
        System.out.println("Donnees apres le bouclement des comptes:");
        client1.afficherClient();
        client2.afficherClient();
    }
}

class Client {
    private String nom;
    private String ville;
    private boolean masculin;  
    
    // true pour homme, false pour femme
    private Compte comptePrive;
    private Compte compteEpargne;

    public Client(String nom, String ville, boolean masculin, double soldePrive, double tauxPrive, double soldeEpargne, double tauxEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.masculin = masculin;
        this.comptePrive = new Compte(soldePrive, tauxPrive);
        this.compteEpargne = new Compte(soldeEpargne, tauxEpargne);
    }

    public void afficherClient() {
        String titre = masculin ? "Client" : "Cliente";
        System.out.println(titre + " " + nom + " de " + ville);
        System.out.println(" Compte prive: " + comptePrive.getSolde() + " francs");
        System.out.println(" Compte d'epargne: " + compteEpargne.getSolde() + " francs");
    }

    public void bouclerComptes() {
        comptePrive.ajouterInterets();
        compteEpargne.ajouterInterets();
    }
}

class Compte {
    private double solde;
    private double tauxInteret;

    public Compte(double solde, double tauxInteret) {
        this.solde = solde;
        this.tauxInteret = tauxInteret;
    }

    public void ajouterInterets() {
        solde += solde * tauxInteret;
    }

    public double getSolde() {
        return solde;
    }
}
