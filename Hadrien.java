import java.util.Scanner;

public class Hadrien extends Guerrier{

    public Hadrien(){
        
        super("Hadrien le Hun",688,100,559,379,264,219,20,259,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie

    }
     /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Pichenette: Attaque faible et peut aleatoirement diminuer defense J2 de 20% \n cout : 30, puissance : 40, precision : 100");  
        System.out.println("2- This is Sparta !: Attaque puissante qui provoque legere paralysie  \n cout : 50, puissance : 80, precision : 90 ");
        System.out.println("3- Fureur sanguine: Attaque magique moyenne \n cout : 40, puissance : 70, precision : 100");
        System.out.println("4- Rempart: Augmente la defense de J1 de 20% \n cout : 40, puissance :-,  precision : 100");
        System.out.println("5- Charge BarBare: Attaque puissante mais J1 subit la moitie des degats qu'il cause \n cout : 80, puissance :250,  precision : 90");
        System.out.println("6- A l'assaut: Attaque puissante qui diminue la defense adverse de 20% \n cout : 80, puissance :100,  precision : 100");
        System.out.println("7- Nouvelle Femme: Augmente la vitesse de J1 de 20% \n cout : 40, puissance :-,  precision : -");
        System.out.println("8- Sourire parfait: Paralyse J2 \n cout : 40, puissance :-,  precision : 100");
        System.out.println("9- Passer son tour" );
        
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
                    attok = attaque7();
                break;
                case 8:
                    attok = attaque8(J2);
                break;
                case 9:
                    System.out.println(this.nom +  " passe son tour !");
                    attok = true;
                break;
                default:
                    attok = false;
                    System.out.println("attaque saisie incorrecte. Rechoisi ton attaque !! ");
                break;
            }
        }
        
    }
       
    /**
    *Cette methode decrit l'attaque speciale 5 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque5(Personnage J2){ //le joeur fait une attaque puissante mais subit en contre partie des dégats
        
       boolean att = false;
        if( this.mana >= 80){ //si le mana est suffisant le joueur peut attaquer
	    int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //valeur de l'esquive
		if(esquive>10){//si la precission est suffisante le joueur peut attaquer
            		int aleat = (int)(Math.random()*10+90);
            		int degat = (int)(aleat*(42*this.force*250)/(50*J2.defensePhysique*100));
            			if(degat >= 0){ //si le joueur fait des dégats
                			J2.vie -= degat; //diminution de la vie de l'ennemi
                			this.vie-=(int)(degat/2); //diminuetion de la vie du joueur
                			System.out.println(this.nom + " fait une attaque puissant. Il cause " +degat+ " degats a " + J2.nom+" mais  "+this.nom+" prend la moitie des degats soit "+ (int)(degat/2) );
            			}else{ //si le joeur ne fais pas de dégats
                			System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! ");
            			}
            	}else{ //si la precission n'est pas suffisante le joueur ne peut pas attaquer
			System.out.println(J2.nom +" esquive l'attaque");
		}
		this.mana  -= 80; //diminution du mana
            	att = true; //attaque a bien eut lieu
        }else{   //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att; //retourne l'etat de l'attaque
    }
	
     /**
    *Cette methode decrit l'attaque speciale 6 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque6(Personnage J2){  // je joeur fait une attaque puissante et diminue la défence physique de l'ennemie de 20%
        boolean att = false;
        
        if( this.mana >= 80){ //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90); //calcul des dégats
            int degat = (int)((aleat*42*this.defensePhysique*100)/(50*J2.defensePhysique*100));
            if(degat >= 0){ //si le jouer fait des dégats
                J2.vie -= degat; //diminution de la vie de l'ennemi
                J2.defensePhysique=(int)(J2.defensePhysique*0.8); //diminution de la defence physique de l'ennemi
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom+" et brise sa defense" );
            }else{ //si le joeur ne fais pas de dégats
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana -= 80; //diminution du mana
            att = true;  //attaque a bien eut lieu
        }else{  //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        
        return att; //retourne l'etat de l'attaque
        
    }
    
    /**
    *Cette methode decrit l'attaque speciale 7 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque7(){ // le joeur augmente sa vitesse de 20%
        
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
	    this.vitesse=(int)(this.vitesse*1.2); //le joeur augmente sa vitesse de 20%
            System.out.println(this.nom+" augmente sa vitesse de 20%");
            this.mana  -= 40; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att; //retourne l'etat de l'attaque
    }
     
     /**
    *Cette methode decrit l'attaque speciale 8 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque8(Personnage J2){ // paralyse J2
        
        boolean att = false;
        
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
	    J2.paralysie=4; //l'ennemie est paralysé
            System.out.println(this.nom+"terrorise "+J2.nom+", il est paralyse");
            this.mana  -= 40; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att;//retourne l'etat de l'attaque
    }
}
