    private String Nom;

    
    public PersonnagePlateau(String Nom) {
   
        this.Nom=Nom;
    
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        }

    

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
   
    public void displayPersonnagePlateau() {
		System.out.println(this.Nom + " et " +this.position);
	}
    
}
