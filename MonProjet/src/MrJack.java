public class MrJack extends Player {

    private int nbSabliers;
    private PersonnagePlateau personnagePlateau;/// carte alibi pour chercher son identite?
    
    public MrJack(String name, String role, int nbSabliers, PersonnagePlateau personnagePlateau) {
        super(name);
        this.nbSabliers = 0;
        this.personnagePlateau = personnagePlateau;
    }

    public int getNbSabliers() {
        return nbSabliers;
    }

    public void setNbSabliers(int nbSabliers) {
        this.nbSabliers = nbSabliers;
    }

    public PersonnagePlateau getPersonnagePlateau() {
        return personnagePlateau;
    }

    public void setPersonnagePlateau(PersonnagePlateau personnagePlateau) {
        this.personnagePlateau = personnagePlateau;
    }
    public void displayIdentiteMrJack() {
		System.out.println( this.personnagePlateau .getNom() + " et " + nbSabliers);
	}

   
	
	
}
