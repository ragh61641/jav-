import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;




public class Plateau {

    

	public District[][] district=new District[3][3] ; //plateau compose dune matrice des quartiers (district) 
	
    public Plateau(District[][] district) {
        this.district = district;
    }

    public  District[][] getDisctrict() {
        return district;
    }

    public void setDistrict(District[][] district) {
        this.district = district;
    }
 
    
    
	public List<Detective> detective = new ArrayList<Detective>() ;//detectives 
	public ArrayList<CarteAlibi> carteAlibi;// pour liste des cartes alibi
	public ArrayList<PersonnagePlateau> personnage;//pour liste des persoPl 
    public MrJack mrJack;
    
	
	public int temporary ; ///  ??
	//private int mNbCase0;// ??
	
	public Plateau() {
		Random rand = new Random();// est ce qu on va l utiliser >?
		
		//this.mNbCase0 = 9;// why?
		

		temporary =-1;// case provisoire utiliser pour le jeton echange /rotation
		
		Detective holmes = new Detective("Holmes",null,0 ); // 
		Detective toby = new Detective("Toby le chien",null,4);
		Detective watson = new Detective("Watson",null,8);

		//liste des detectives
		detective.add(0,holmes);
		detective.add(1,toby);
		detective.add(2,watson);
		//initialisation des cartes alibi 
		carteAlibi.add(new CarteAlibi(2,new PersonnagePlateau("rose")));
		carteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Blanc")));
		carteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Orange")));
		carteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Violet")));
		carteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("vert")));
		carteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Jaune")));
		carteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Gris")));
		carteAlibi.add(new CarteAlibi(0,new PersonnagePlateau("Noir")));
		carteAlibi.add(new CarteAlibi(0,new PersonnagePlateau("Bleu")));

		Collections.shuffle(carteAlibi);
		
		List<PersonnagePlateau> personnagePlateau = new ArrayList<>();/// list des personnages su le plateau
		
		personnagePlateau.add(new PersonnagePlateau("rose"));
		personnagePlateau.add(new PersonnagePlateau("Blanc"));
		personnagePlateau.add(new PersonnagePlateau("Orange"));
		personnagePlateau.add(new PersonnagePlateau("Violet"));
		personnagePlateau.add(new PersonnagePlateau("vert"));
		personnagePlateau.add(new PersonnagePlateau("Jaune"));
		personnagePlateau.add(new PersonnagePlateau("Gris"));
		personnagePlateau.add(new PersonnagePlateau("Noir"));
		personnagePlateau.add(new PersonnagePlateau("Bleu"));
		
		Collections.shuffle(personnagePlateau);// to desorder personnage on table
		
		
		district[0][0] = new District(3,-1,personnagePlateau.get(0)); /////  creation du plateau par les districts
		district[0][1] = new District((int)(Math.random() * 4) -1, 0,personnagePlateau.get(1) );
		district[0][2] = new District(1, 0,personnagePlateau.get(2));
		district[1][0] = new District((int)(Math.random() * 4) -1, 0,personnagePlateau.get(3) );
		district[1][1] = new District((int)(Math.random() * 4) -1, 0,personnagePlateau.get(4) );
		district[1][2] = new District((int)(Math.random() * 4) -1, 0,personnagePlateau.get(5) );
		district[2][0] = new District((int)(Math.random() * 4) -1, 0,personnagePlateau.get(6) );
		district[2][1] = new District(2,0,personnagePlateau.get(7));
		district[2][2] = new District((int)(Math.random() * 4) -1, 0,personnagePlateau.get(8));


	
}
	
}	

