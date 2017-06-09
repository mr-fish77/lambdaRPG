import java.util.Scanner;

public class Gaspard extends Mage{

    public Gaspard(){
        
        super("Gaspard", 788, 100, 259, 249, 260, 328, 20, 319, 0, 0, 0,0);  //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
    /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Attaque puissante qui peut aleatoirement diminuer resistance magique de J2 \n cout : 50 puissance : 90 precision : 100");  
        System.out.println("2- Attaque faible qui peut aleatoirement bruler J2 \n cout : 30 puissance : 50 precision : 100");
        System.out.println("3- Attaque moyenne \n cout : 40 puissance : 80 precision : 100");
        System.out.println("4- Augmentation magie de 20% \n cout : 40 puissance :-  precision : 100");
        System.out.println("5- Coup de bidon : inflige des degats et paralyse l'ennemi \n cout : 40, puissance : 30, precision : 60");
        System.out.println("6- Grace de l'obese : endors l'ennemi pendant 3 tours \n cout : 40, puissance : -, precision : 60");
        System.out.println("7- Rage de l'ivrogne : Inflige des degats a l'ennemi et egalement a soi meme \n cout : 80, puissance : 150, precision : 100");
        System.out.println("8- Coma hydrolique : Attaque moderee avec 50% de chance que le cout en mana soit nul \n cout : 80, puissance : 70, precision : 90");
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
                    attok = attaque8(J2);
                break;
                case 9:
                    System.out.println(this.nom +  " passe son tour !");
                    attok = true;
                break;
                default: //choix par defaut si les entrees sont invalides 
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
     public boolean attaque5(Personnage J2){ //inflige des degats a J2 et le paralyse
        
              
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //calcul de l'esquive
			if(esquive>40){ //condition de precision
            int aleat = (int)(Math.random()*10+90); //coefficient valeur attaque
            int degat = (int)((aleat*42*this.force*30)/(50*J2.defensePhysique*100)); //calcul des degats
            if(degat >= 0){ //si les degats sont suffisant alors effectue l'attaque
                J2.vie -= degat; //inflige les degats
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et le paralyse");
            }else{ //si les degats sont insuffisant 
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            }
            
            J2.paralysie=4; //paralyse J2 pendant 4 tours
            }else{ //si le joueur esquive
			System.out.println(J2.nom +" esquive l'attaque");
			}
			this.mana  -= 40; //cout en mana
            att = true; //l'attaque a bien eu lieu
        }else{ //si le mana est insuffisant le joueur peut attaquer a nouveau
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eu lieu
        }

        
        return att;
        
    }
           /**
    *Cette methode decrit l'attaque speciale 6 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */  
    
	public boolean attaque6(Personnage J2){ //Endors l'ennemi pendant 3 tours
		
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //calcul de l'esquive
			if(esquive>40){ //condition de précision 
            J2.dodo=3; //endors J2 pendant 3 tours
            System.out.println(this.nom+" endort l'ennemie ");
            }else{ //si J2 esquive l'attaque
			System.out.println(J2.nom +" esquive l'attaque");
			}
            this.mana -=40; //diminution du mana
            att = true; //l'attaque a bien eu lieu
        }else{ //si le mana est insuffisant le joueur peut attaquer a nouveau
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eu lieu
        }

        
        return att;
    }
   
	/**
    *Cette methode decrit l'attaque speciale 7 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */  
	
    public boolean attaque7(Personnage J2){ //inflige de lourds degats a J2 et moindre a soi meme
        
   boolean att = false;
        if( this.mana >= 80){ //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90); //coefficient valeur attaque
            int degat = (int)((aleat*42*this.force*150)/(50*J2.defensePhysique*100)); //calcul degats
            if(degat >= 0){ //si les degats sont suffisant le joueur peut attaquer
                J2.vie -= degat; //inflige les degats a J2
                this.vie-=(int)(degat/6); //inflige une partie des degats a J1
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
                System.out.println("En retour, il subit "+ (int)(degat/6)+" degats");
            }else{ //si les degats sont insuffisants
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 80; //cout en mana
            
            att = true; //l'attaque a bien eu lieu
        }else{ //si le mana est insuffisant le joueur peut attaquer a nouveau
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eu lieu
        }
        
        return att;
        
    }
    /**
    *Cette methode decrit l'attaque speciale 8 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */  
        public boolean attaque8(Personnage J2){ //Attaque moyenne avec chance de ne pas couter de mana
        
       boolean att = false;
        
        if( this.mana >= 80){ //si le mana est suffisant le joueur peut attaquer
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //calcul esquive
			if(esquive>10){ //condition precision
			int aleat = (int)(Math.random()*10+90); //coefficient valeur attaque
            int degat = (int)((aleat*42*this.magie*70)/(50*J2.resistanceMagique*100)); //calcul des degats
				if(degat >= 0){ //si les degats sont suffisant l'attaque a lieu
                J2.vie -= degat; //inflige les degats
                System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom );
				int cout = (int)(Math.random()*100); //tire aléatoire
					if (cout<=50) { //détermine la probabilité a 1/2
					
					System.out.println("L'attaque ne coute aucun mana");
					}
		
				}else{
					
                this.mana -=80;
				}
        
            }else{ //si l'attaque ne touche pas
			System.out.println(J2.nom +" esquive l'attaque");
            this.mana-=80; //cout en mana 
		}
            att = true; //l'attaque a bien eu lieu
        }else{ //si mana insuffisant le joueur peut attaquer a nouveau
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eu lieu
        }

        
        return att;
        
    }
    
}
