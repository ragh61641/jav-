import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;




public class Plateau {

    
	///private static final PersonnageDetective[] personnageDetectives = null;/// no idea
	//private List<District> district;
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
 
    
    
	public List<Detective> Detective = new ArrayList<Detective>() ;//detectives 
	public ArrayList<CarteAlibi> CarteAlibi;// pour liste des cartes alibi
    public ArrayList<PersonnagePlateau> Personnage;//pour liste des persoPl 
    public MrJack mrJack;
    
	
	public int flag; ///  ??
	private int mNbCase0;// ??
	private int mTour; // 0 correspond au tour des detective et 1 au tour du mechant
	public Plateau() {
		Random rand = new Random();
		this.mTour = 0;
		this.mNbCase0 = 9;
		

		flag = -1;
		
		Detective holmes = new Detective("Holmes",null,0 );
		Detective toby = new Detective("Toby le chien",null,4);
		Detective Watson = new Detective("Watson",null,8);

		//initialisation des cartes alibi 
		CarteAlibi.add(new CarteAlibi(2,new PersonnagePlateau("rose")));
		CarteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Blanc")));
		CarteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Orange")));
		CarteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Violet")));
		CarteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("vert")));
		CarteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Jaune")));
		CarteAlibi.add(new CarteAlibi(1,new PersonnagePlateau("Gris")));
		CarteAlibi.add(new CarteAlibi(0,new PersonnagePlateau("Noir")));
		CarteAlibi.add(new CarteAlibi(0,new PersonnagePlateau("Bleu")));

		Collections.shuffle(CarteAlibi);
		
		List<PersonnagePlateau> personnagePlateau = new ArrayList<>();/// list des personnages su le plateay
		
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

