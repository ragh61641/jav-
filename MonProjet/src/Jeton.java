import java.util.Random;
import java.util.Scanner;

import mrjack.Plateau;

public class Jeton {
    
    private String typeAction;
    
    public Jeton(String typeAction) {
        this.typeAction = typeAction;
    }
    
    //Jeton 1 avec ces deux faces 
////pour la face du jeton et que pour les 4 lances ils doinvent etres elimines le tour aui suit 
    public String getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(String typeAction) {
        this.typeAction = typeAction;
    }
    private Scanner scanner = new Scanner(System.in);

    public void actionjeton(Plateau plateau){

    	
    	///Jeton 1 avec 2 faces (Holmes , Alibi)
 /////Jeton HOLMES 
    	
    	if (this.typeAction=="Holmes"){//si on joue le jeton Holmes
    		int nb=0;
    		System.out.println("Tapez 1 ou 2 pour avancer de 1 ou 2 cases avec Holmes");
    		while (nb != 1 && nb != 2) {  ///pour verifier et etre sur que le joueur a print le 1 ou2 
    			System.out.println("Veuillez retaper 1 ou 2 :");}
    		
    		nb=scanner.nextInt();//????? est ce aue ca permet que tout detective fera la meme chose si il est dans ce ca
    		if (plateau.Detective.get(0).getPosition() == 10 && nb == 2)//cas exception ou on doit faire bouger le jeton de deux places donc cest sa position intiale  
    			plateau.Detective.get(0).setPosition(0);
    		else if (plateau.Detective.get(0).getPosition() == 11)//cas ou il faut bouger soit deux soit un, si 2 ca devient 2-1 donc position(1), si 1 donc position(0)
    			plateau.Detective.get(0).setPosition(nb - 1);
    		else
    			plateau.Detective.get(0).setPosition(plateau.Detective.get(0).getPosition() + nb);//tout autres cas la position c est la position ou holmes il est , et on le bouge avec le nb , donc soit de 1 ou 2 

    			
    			
    	}
    	
    	
  ////Jeton ALIBI
    	
    	
    	if(this.typeAction=="Alibi") {//si on joue le jeton Alibi
    		if (Play.getTour()%2 != 0) { // tour du detective est impair 
    			System.out.print("identite dans la carte alibi piochee : ");//dessous va permettre de lire l'identite a innocente/ou non, parmi celle figurant sur le plateau
    			plateau.CarteAlibi.get(0).identiteDuPersonnage();//il reste que 8 carte alibi , vu que mr jack a deja son identite qui represente la 9 eme carte ,
    			
    			int i2 = 0; // initialisation pour parcourir le plateau et chercher le quartier correspondant a la carte alibi picohe par le detective 
            	int j2 = 0;

            	for (int i = 0 ; i < 3 ; i++) {
                    	for (int j = 0 ; j < 3 ; j++) {
                            	if (plateau.district[i][j].getPerso() == plateau.CarteAlibi.get(0).getPersonnage()) {//cherche perso alibi sur le plateau //??? 
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
			//pourquoi enlever la case de la carte du plateau 
            	plateau.setNbCase0(plateau.getNbCase0() - 1);
            	plateau.CarteAlibi.remove(0); // enlever la carte alibi deja pioche par le detective, car ce personnage ne fait plus parti des suspects 
            	}
	}
    	 else {/// tour de Mr jack , on peut aussi l'exprimer avec if (Play.getTour()%2 == 0)
    		 System.out.println("Secret - Carte piochee : ");//l indentite sur cette carte reste cache 
    		 plateau.CarteAlibi.get(0).identiteDuPersonnage();//pioche une carte de position 0 parmis les cartes alibi restantes 
    		 plateau.mrJack.setNbSabliers(plateau.mrJack.getNbSabliers() + plateau.CarteAlibi.get(0).getNbSablier());//to set le nbre de sablier , en le recevant de la carte alibi pioche et l add a nbre de sablier deja existant pour mrjack
    		 plateau.CarteAlibi.remove(0);//enlever la carte piochee des cartes alibi 
	}
    	
    	
    		
    	///Jeton 2 avec 2 faces	( Toby , watson)
    	
    	
 ////Jeton TOBY le chien  
    		
    		
    		if (this.typeAction=="Toby le chien"){
    			int nb = 0;
    			
    			System.out.println("Tapez 1 ou 2 pour avancer de 1 ou 2,respectivement, avec le jeton detective Toby ");
    			while (nb != 1 && nb != 2) {//verifier que le joueur tape ce qui lui a ete demander et afficher message erreur  
    				nb = scanner.nextInt();
    			
    				if (nb != 1 && nb != 2)
    					System.out.println("Message erreur:Veuillez retaper 1 ou 2 :");
    				}//les deux premiers if reflete la limite de la liste des places des detectives 
    			
    			if (plateau.Detective.get(1).getPosition() == 10 && nb == 2)//on a le detectice est en 10 et si on tape 2 on revient a l intiale (l indice intial)
    				plateau.Detective.get(1).setPosition(0);//bien notifier qu'on a que 11 places 
    			
    			else if (plateau.Detective.get(1).getPosition() == 11)
    				plateau.Detective.get(1).setPosition(nb - 1);// si on tape 1 on est a la postion 0 , si on tape 2 on est a la ppsition une 1 
    			
    			else
    				plateau.Detective.get(1).setPosition(plateau.Detective.get(1).getPosition() + nb);// on fait bouger le detective de sa place actuelle avec un nb de soit 1 soit 2
    	}	
    		
    	
    		
 /////Jeton WATSON 
    		
    		
    		if (this.typeAction=="Watson"){// enlever la carte alibi deja pioche par le detective, car ce personnage ne fait plus parti des suspects 
    			int nb = 0;
    			System.out.println("Tapez 1 ou 2 pour avancer de 1 ou 2,respectivement, avec le jeton detective Toby ");
    			while (nb != 1 && nb != 2) {
    				nb = scanner.nextInt();
    				if (nb != 1 && nb != 2)
    					System.out.println("Message erreur :Veuillez retaper 1 ou 2 :");
    		}
    			if (plateau.Detective.get(2).getPosition() == 10 && nb == 2)
    				plateau.Detective.get(2).setPosition(0);
    			else if (plateau.Detective.get(2).getPosition() == 11)
    				plateau.Detective.get(2).setPosition(nb - 1);
    			else
    				plateau.Detective.get(2).setPosition(plateau.Detective.get(2).getPosition() + nb);
    	}
    		
    		
   ///Jeton 3 avec 2 faces(Echange , Rotation ) 
   
   /// Jeton ECHANGE    		
    		
    	
    		if (this.typeAction=="Echange"){
    			for (int i = 0 ; i < 3 ; i++) {
                	for (int j = 0 ; j < 3 ; j++) {
                		
                	}
    				
    			}
    		}
    	}
    
}
    