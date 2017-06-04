import java.util.Scanner;

public class Achille extends Guerrier{

    public Achille(){
        
        super("Achille", 708,100,559,379,256,219,20,259,0,0,0,0); //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
      /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){ 
        Scanner sc = new Scanner(System.in);
        boolean attok = false;
        



	//affichage des attaques du personnage
        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Pichenette: Attaque faible et peut aleatoirement diminuer defense J2 de 20% \n cout : 30 puissance : 40 precision : 100");  
        System.out.println("2- This is Sparta !: Attaque puissante qui provoque legere paralysie \n cout : 50 puissance : 80 precision : 90 ");
        System.out.println("3- Fureur sanguine: Attaque moyenne \n cout : 40 puissance : 70 precision : 100");
        System.out.println("4- Rempart: Augmente la defense de J1 de 20% \n cout : 40 puissance :-  precision : 100");
        System.out.println("5- Talonette: Attaque puissante mais le joueur se blesse en contrepartie \n cout: 80, puissance: 150, precision: 100 ");
        System.out.println("6- Foudre de Zeus: Attaque provoquant paralysie \n cout: 40, puissance: 30, precision: 60 ");
        System.out.println("7- Mélasse: Diminue vitesse J2 \n cout: 40, puissance: - , precision: -  ");
        System.out.println("8- AirMesMax: Augmentation attaque \n cout: 40, puissance: - , precision: -  "");
        System.out.println("9-Passer son tour" );
        
        while(attok == false){ /**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = attaque1(J2);
                break;
                case 2:
                    attok = attaque2(J2);
                break;
                case 3:
                    attok = attaque3(J2);
                break;
                case 4:
                    attok = attaque4();
                break;
                case 5:
                    attok = attaque5(J2);
                break;
                case 6:
                    attok = attaque6(J2);
                break;
                case 7:
                    attok = attaque7(J2);
                break;
                case 8:
                    attok = attaque8();
                break;
                case 9:
                    System.out.println(this.nom +  " passe son tour !");
                    attok = true;
                break;
                default:  //choix par défaut si les entrée sont invalides 
                    attok = false;
                    System.out.println("attaque saisie incorrecte. Rechoisi ton attaque !! ");
                break;
            }
        }
        
    }
	
    /**
    *Cette methode decrit l'attaque5 speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
     public boolean attaque5(Personnage J2){ //attaque avec degats pour J2 mais aussi des dégats  pour J1 en contrepartie
        
        boolean att = false;
        if( this.mana >= 80){  //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90); 
            int degat = (int)((aleat*42*this.force*150)/(50*J2.defensePhysique*100));
            if(degat >= 0){ // si les dégats sont suffisants le joueur peut attquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                this.vie-=(int)(degat/6);  //diminution de la vie du joeur
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom ); //texte de description
                System.out.println("Cependant il se blesse et il subit "+ (int)(degat/6)+" degats");
            }else{ //les dégats sont insuffisants 
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 80; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" ); 
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        
        return att; //retourne l'état de l'attaque
    }
    
	/**
    *Cette methode decrit l'attaque6 speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
     public boolean attaque6(Personnage J2){ //attaque avec degats pour J2 et une paralysie
        
        boolean att = false; 
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
	   int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //valeur de l'esquive
		if(esquive>40){ //si la precission est suffisante le joueur peut attaquer
            		int aleat = (int)(Math.random()*10+90); 
            		int degat = (int)((aleat*42*this.force*30)/(50*J2.defensePhysique*100)); //calcul des degat
            		if(degat >= 0){ // si les dégats sont suffisants le joueur peut attquer
                		J2.vie -= degat; //diminution de la vie de l'ennemi
                		System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et le paralyse");
            		}else{ //les dégats sont insuffisants
                		System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            			}
            		J2.paralysie=4; //J2 est paralyser pendant 4 tours
            	}else{ //si la precission n'est pas suffisante le joueur ne peut pas attaquer
			System.out.println(J2.nom +" esquive l'attaque");
		}
	    this.mana  -= 40; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;//attaque n'a pas eut lieu
        }
        return att;//retourne l'etat de l'attaque
    }
    
    /**
    *Cette methode decrit l'attaque7 speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque7(Personnage J2){ // attaque diminuant la  vitesse  de J2
        boolean att = false; 
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer	
           J2.vitesse= (int)(J2.vitesse*0.9); //diminution de la vitesse 
            System.out.println("La vitesse de "+J2.nom + " diminue de 10%");
	    this.mana  -= 40; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }   
        return att; //retourne l'état de l'attaque
        
    }
			   
   /**
    *Cette methode decrit l'attaque7 speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque8(){ //Augmentation attaque  du joueur
         
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
            this.force = (int)(this.force*1.2); //augmznte la force du joueur
            System.out.println(this.nom+" augmente sa force de 20%");
            this.mana  -= 40; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }

        return att; //retourne l'état de l'attaque
    }
    
}
