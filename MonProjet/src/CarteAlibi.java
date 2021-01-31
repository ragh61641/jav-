import java.util.ArrayList;

public class CarteAlibi {
    
    private  int nbSablier;
    private PersonnagePlateau personnage ;
	private int pileFaceCarte ;/// 1=pile et montre les indetites des perso , 0= face et ne montre rien 
	

    public CarteAlibi(int nbSablier,int pileFaceCarte,PersonnagePlateau personnage) {
        this.nbSablier = nbSablier;
        this.personnage= personnage;
        this.pileFaceCarte=0;
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

	public int getPileFaceCarte() {
		return pileFaceCarte;
	}

	public void setPileFaceCarte(int pileFaceCarte) {
		this.pileFaceCarte = pileFaceCarte;
	}
    
}
