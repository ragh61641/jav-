public class PersonnagePlateau {
    
    private int position;//  
    private boolean visible; // sa visibilte par rapport aux 3 detectives 
    private String Nom;
    public PersonnagePlateau(int position, boolean visible,String Nom) {
        this.position = position;
        this.visible = visible;
        this.Nom=Nom;
    
    }
    public PersonnagePlateau(String Nom) {
   
        this.Nom=Nom;
    
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
   
    public void displayPersonnagePlateau() {
		System.out.println(this.Nom + " et " + this.visible +"et"+this.position);
	}
    
}