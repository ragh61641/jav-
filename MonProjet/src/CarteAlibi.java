import java.util.ArrayList;

public class CarteAlibi {
    
    private  int nbSablier;
    private PersonnagePlateau personnage ;
	

    public CarteAlibi(int nbSablier,PersonnagePlateau personnage) {
        this.nbSablier = nbSablier;
        this.personnage= personnage;
    }

    public int getNbSablier() {
        return nbSablier;
    }

    public void setNbSablier(int nbSablier) {
        this.nbSablier = nbSablier;
    }

    
    public void identiteDuPersonnage() {//lorsqu'on appelle cette fonction elle nous donne l identitee de la carte alibi qu'on a (nbre sablier et personnage)
		System.out.println(this.personnage + " et " + this.nbSablier);
	}

	public  PersonnagePlateau getPersonnage() {
		return personnage;
	}

	public void setPersonnage(PersonnagePlateau personnage) {
		this.personnage=personnage; 
	}
    
}