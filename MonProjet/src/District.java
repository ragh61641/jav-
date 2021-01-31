public class District{//quartiers {
    
    private int orientation;//-1: pas de mur , 0:vers le nord ,1:vers l'est,2:vers le sud ,3: vers l'ouest
    private int PileFace ;//0:etat de base , 1: pour face , -1: carte retournee sans aucun mur  -I-
    private PersonnagePlateau Perso; // personnage qui figure sur la district 

    public District(int orientation,int PileFace,PersonnagePlateau Perso) {
        this.orientation = orientation;
        this.Perso=Perso;
        this.PileFace=0;
        
        
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

	public int getPileFace() {
		return PileFace;
	}

	public void setPileFace(int pileFace) {
		this.PileFace = pileFace;
	}

	public PersonnagePlateau getPerso() {
		return Perso;
	}

	public void setPerso(PersonnagePlateau Perso) {
		this.Perso=Perso;
		
	}
	
}
