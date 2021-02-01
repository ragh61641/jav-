import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Jeton {
	
	
    private int positionjeton ; // randomly  0 ou  1
    private String pile ;
    private String face;
    
    public int getPositionjeton() {/// 0 pour les piles et 1 pour les faces 
		return positionjeton;
	}

	public void setPositionjeton(int positionjeton) {
		this.positionjeton = positionjeton;
	}
    
	public String getPile() {
		return pile;
	}

	public void setPile(String pile) {
		this.pile = pile;}
    
    public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}
	 public Jeton(String pile, String face) {//// constructeur des jetons 
	        List<String> listNames = new ArrayList<>();
	        listNames.add(pile);
	        listNames.add(face);
	        
	        this.pile = listNames.get(0);
	        this.face = listNames.get(1);
	    }
    
    
    //Jeton 1 avec ces deux faces 
    
    
    private Scanner scanner = new Scanner(System.in);
   
    	
    public void actionjeton(Plateau plateau){

    	
    	///Jeton 1 avec 2 faces (Holmes , Alibi)
 /////face HOLMES 
    	
    	if (this.pile=="Holmes"){//si on joue le jeton Holmes
    		int nb=0;
    		System.out.println("Tapez 1 ou 2 pour avancer de 1 ou 2 cases avec Holmes");
    		while (nb != 1 && nb != 2) {  ///pour verifier et etre sur que le joueur a print le 1 ou2 
    			System.out.println("Veuillez retaper 1 ou 2 :");}
    		
    		nb=scanner.nextInt();
    		if (plateau.detective.get(0).getPosition() == 10 && nb == 2)//cas exception ou on doit faire bouger le jeton de deux places donc cest sa position intiale  
    			plateau.detective.get(0).setPosition(0);
    		else if (plateau.detective.get(0).getPosition() == 11)//cas ou il faut bouger soit deux soit un, si 2 ca devient 2-1 donc position(1), si 1 donc position(0)
    			plateau.detective.get(0).setPosition(nb - 1);
    		else
    			plateau.detective.get(0).setPosition(plateau.detective.get(0).getPosition() + nb);//tout autres cas la position c est la position ou holmes il est , et on le bouge avec le nb , donc soit de 1 ou 2 
    	}
    	
    	
    	
    	
  ////face ALIBI
    	
    	
    	if(this.face=="Alibi") {//si on joue le jeton Alibi
    		for (int nbTour = 1 ; nbTour <= 8 ; nbTour++) {
    			if (nbTour%2 == 1) { // tour du detective est impair 
    				System.out.print("identite dans la carte alibi piochee : ");//dessous va permettre de lire l'identite a innocente/ou non, parmi celle figurant sur le plateau
    				plateau.carteAlibi.get(0).identiteDuPersonnage();//il reste que 8 carte alibi , vu que mr jack a deja son identite qui represente la 9 eme carte ,

    				int i2 = 0; // initialisation pour parcourir le plateau et chercher le quartier correspondant a la carte alibi picohe par le detective 
    				int j2 = 0;
    				for (int i = 0 ; i < 3 ; i++) {
    					for (int j = 0 ; j < 3 ; j++) {
    				
                            	if (plateau.district[i][j].getPerso() == plateau.carteAlibi.get(0).getPersonnage()) {//cherche perso alibi sur le plateau //??? 
                                    	i2 = i;
                                    	j2 = j;
                            	}
                    	}
            	}
    				if ( plateau.district[i2][j2].getPileFace() == 0) {// si on est a l'etat de base, on retoure le quartier 
    					plateau.district[i2][j2].setPileFace(1); // sur sa face 
    				}
    				if (plateau.district[i2][j2].getPerso().getNom() == "Gris") {//si le personnage gris represente la carte alibi pioche , 
    					plateau.district[i2][j2].setPileFace(-1);//positioner le gris en -1 car y a une excpetion il n a aucun mur pour lorsqu'on retourne le quartier
    					plateau.district[i2][j2].setOrientation(-1); // donc  son orientation est aussi -1 qui represente pas de mur
    				}
    					
			
			 
                plateau.setNbreCase0(plateau.getNbreCase0() - 1);
    			plateau.carteAlibi.remove(0); // enlever la carte alibi deja pioche par le detective, car ce personnage ne fait plus parti des suspects 
    		}
	
    	else {/// tour de Mr jack , on peut aussi l'exprimer avec if (Play.getTour()%2 == 0)
    		 System.out.println("Secret - Carte piochee : ");//l indentite sur cette carte reste cache 
    		 plateau.carteAlibi.get(0).identiteDuPersonnage();//pioche une carte de position 0 parmis les cartes alibi restantes 
    		 plateau.mrJack.setNbSabliers(plateau.mrJack.getNbSabliers() + plateau.carteAlibi.get(0).getNbSablier());//to set le nbre de sablier , en le recevant de la carte alibi pioche et l add a nbre de sablier deja existant pour mrjack
    		 plateau.carteAlibi.remove(0);}//enlever la carte piochee des cartes alibi 
    	}
    	}
     	
    		
    	///Jeton 2 avec 2 faces	( Toby , watson)
    	
    	
 ////Face TOBY le chien  
    		
    		
    		if (this.pile=="Toby le chien"){
    			int nb = 0;
    			
    			System.out.println("Tapez 1 ou 2 pour avancer de 1 ou 2,respectivement, avec le jeton detective Toby ");
    			while (nb != 1 && nb != 2) {//verifier que le joueur tape ce qui lui a ete demander et afficher message erreur  
    				nb = scanner.nextInt();
    			
    				if (nb != 1 && nb != 2)
    					System.out.println("Message erreur:Veuillez retaper 1 ou 2 :");
    				}//les deux premiers if reflete la limite de la liste des places des detectives 
    			
    			if (plateau.detective.get(1).getPosition() == 10 && nb == 2)//on a le detectice est en 10 et si on tape 2 on revient a l intiale (l indice intial)
    				plateau.detective.get(1).setPosition(0);//bien notifier qu'on a que 11 places 
    			
    			else if (plateau.detective.get(1).getPosition() == 11)
    				plateau.detective.get(1).setPosition(nb - 1);// si on tape 1 on est a la postion 0 , si on tape 2 on est a la ppsition une 1 
    			
    			else
    				plateau.detective.get(1).setPosition(plateau.detective.get(1).getPosition() + nb);// on fait bouger le detective de sa place actuelle avec un nb de soit 1 soit 2
    	}	
    		
    	
    		
 /////Face WATSON 
    		
    		
    		if (this.face=="Watson"){// enlever la carte alibi deja pioche par le detective, car ce personnage ne fait plus parti des suspects 
    			int nb = 0;
    			System.out.println("Tapez 1 ou 2 pour avancer de 1 ou 2,respectivement, avec le jeton detective Toby ");
    			while (nb != 1 && nb != 2) {
    				nb = scanner.nextInt();
    				if (nb != 1 && nb != 2)
    					System.out.println("Message erreur :Veuillez retaper 1 ou 2 :");
    		}
    			if (plateau.detective.get(2).getPosition() == 10 && nb == 2)
    				plateau.detective.get(2).setPosition(0);
    			else if (plateau.detective.get(2).getPosition() == 11)
    				plateau.detective.get(2).setPosition(nb - 1);
    			else
    				plateau.detective.get(2).setPosition(plateau.detective.get(2).getPosition() + nb);
    	}
    		
    		
   ///Jeton 3 avec 2 faces(Echange , Rotation ) 
   
   /// face ECHANGE    		
    		
    	
    		if (this.pile=="Echange"){
    				int district1 = 0;
    				int district2 = 0;
    				int i1;
    				int j1;
    				int i2;
    				int j2;

    				System.out.println("Tapez un nombre entre 1 et 9 pour selectioner le 1er district (1 etant haut / gauche et 9 etant bas / droit)");
    				while (!(district1 > 0 && district1 < 10)) {
    					district1 = scanner.nextInt();
    					if (!(district1 > 0 && district1 < 10))
    						System.out.println("Veuillez retaper un nombre entre 1 et 9");
    				}

    				System.out.println("Tapez un nombre entre 1 et 9 pour selection le 2eme district (1 etant haut / gauche et 9 etant bas / droit)");
    				while (!(district2 > 0 && district2 < 10) || district1 == district2) {
    					district2 = scanner.nextInt();
    					if (!(district2 > 0 && district2 < 10) || district1 == district2)
    						System.out.println("Veuillez retaper un nombre entre 1 et 9 (oblige d'echanger 2 cases)");/// faut  absolument faire un swap 
    				}
    				i1 = (district1 - 1) / 3;
    				j1 = (district1 - 1) % 3;
    				i2 = (district2 - 1) / 3;
    				j2 = (district2 - 1) % 3;
    				District temporary = plateau.district[i1][j1];
    				plateau.district[i1][j1] = plateau.district[i2][j2];
    				plateau.district[i2][j2] = temporary;
    			
    		
    		}
    		
    		
    		//// pile jeton 1rotation / ya deux jetons avec l action rotation 
    		if (this.face=="1Rotation"){
    			int nb = 0;
    			int pivot = -1;
    			int i;
    			int j;
                 //pivot est permis soit de 1/4 soit de 1/2
    			System.out.println("Tapez un nombre entre 1 et 9 pour selection la case a tourner (1 etant haut / gauche et 9 etant bas / droit)");
    			while (!(nb > 0 && nb < 10) || nb == plateau.temporary) {//whhy
    				nb = scanner.nextInt();
    				if (!(nb > 0 && nb < 10) || nb == plateau.temporary)
    					System.out.println("Veuillez retaper un nombre entre 1 et 9 (pas le droit de faire tourner une meme case au sein d'un meme tour)");
    			}
    			plateau.temporary = nb;
    			System.out.println("Tapez un nombre entre 1 et 4 pour orienter le mur (1 = nord, 2 = est, 3 = sud et 4 = ouest)");
    			while (!(pivot > 0 && pivot < 5) || plateau.district[(nb - 1) / 3][(nb - 1) % 3].getOrientation() == (pivot - 1)) {// verifier si l'orientation du district est deja dans le l'etat quand veut
    				pivot = scanner.nextInt();
    				if (!(pivot > 0 && pivot < 5) || plateau.district[(nb - 1) / 3][(nb - 1) % 3].getOrientation() == (pivot - 1))// retaper entre 1,4de telle maniere a changer une face d un district  
    					System.out.println("Veuillez retaper un nombre entre 1 et 4 (Action de rotation est exigee)");
    			}
    			i = (nb - 1) / 3;/// selectionne le district[i][j] ou on veut faire un pivot 
    			j = (nb - 1) % 3;
    			plateau.district[i][j].setOrientation(pivot - 1);//set de l orientation qu on veut achever 
    		}
    		
    		
    	
    		
    		
  ///// Jeton 2Rotation et Joker
    		
    	//// Pile  2Rotation
    		if (this.pile=="Echange"){	
    			int nb = 0;
    			int pivot = -1;
    			int i;
    			int j;
                 //pivot est permis soit de 1/4 soit de 1/2
    			System.out.println("Tapez un nombre entre 1 et 9 pour selection la case a tourner (1 etant haut / gauche et 9 etant bas / droit)");
    			while (!(nb > 0 && nb < 10) || nb == plateau.temporary) {//whhy
    				nb = scanner.nextInt();
    				if (!(nb > 0 && nb < 10) || nb == plateau.temporary)
    					System.out.println("Veuillez retaper un nombre entre 1 et 9 (pas le droit de faire tourner une meme case au sein d'un meme tour)");
    			}
    			plateau.temporary = nb;
    			System.out.println("Tapez un nombre entre 1 et 4 pour orienter le mur (1 = nord, 2 = est, 3 = sud et 4 = ouest)");
    			while (!(pivot > 0 && pivot < 5) || plateau.district[(nb - 1) / 3][(nb - 1) % 3].getOrientation() == (pivot - 1)) {// verifier si l'orientation du district est deja dans le l'etat quand veut
    				pivot = scanner.nextInt();
    				if (!(pivot > 0 && pivot < 5) || plateau.district[(nb - 1) / 3][(nb - 1) % 3].getOrientation() == (pivot - 1))// retaper entre 1,4de telle maniere a changer une face d un district  
    					System.out.println("Veuillez retaper un nombre entre 1 et 4 (Action de rotation est exigee)");
    			}
    			i = (nb - 1) / 3;/// selectionne le district[i][j] ou on veut faire un pivot 
    			j = (nb - 1) % 3;
    			plateau.district[i][j].setOrientation(pivot - 1);//set de l orientation qu on veut achever 
    		
    	}
    		
    	//// Pile  Joker
    		
    		
    		if (this.face=="Joker"){	
    			int nb = 0;
    			int perso = -1;
    			if (Player.getName()=="Detective") {
    				System.out.println("Tapez 0 pour avancer Holmes, 1 pour leChien Toby et 2 pour Watson ");
    				while (perso != 0 && perso != 1 && perso != 2) {
    				perso = scanner.nextInt();
    				if (perso != 1 && perso != 2 && perso != 3)
    					System.out.println("Veuillez retaper 1, 2 ou 3");
    				}
    				if (plateau.detective.get(perso).getPosition() == 11)
    					plateau.detective.get(perso).setPosition(0);
    				else
    					plateau.detective.get(perso).setPosition(plateau.detective.get(perso).getPosition() +1);// dans le sens des aiguilles d'une montre 
    				
    		}
    			
    			if (Player.getName()=="Mr jack") {

    				System.out.println("Tapez 0 pour avancer Holmes, 1 pour leChien Toby , 2 pour Watson, ou 3 pour ne faire aucun changement ");
    				while (perso != 0 && perso != 1 && perso != 2  && perso != 3 ) {
    				perso = scanner.nextInt();
    				if (perso != 0 && perso != 1 && perso != 2  && perso != 3  )
    					System.out.println("Veuillez retaper 0, 1, 2 ou 3");
    				}
    				
    				switch(perso) { 
    				case 0:
    				case 1:
    				case 2:	
    					if (plateau.detective.get(perso).getPosition() == 11)
        					plateau.detective.get(perso).setPosition(0);
        				else
        					plateau.detective.get(perso).setPosition(plateau.detective.get(perso).getPosition() +1);// dans le sens des aiguilles d'une montre 
    				default:
    					System.out.println("aucun changement n'est effectue");
        		
        			}
    			
    					
    				
    				
    			}

	
    }
    }
    }
   
