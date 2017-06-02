import java.util.Scanner;
public class Melchior extends Mage{

    public Melchior(){
        
        super("Melchior", 688, 100, 289, 209, 268, 317, 20, 319, 0, 0, 0, 0); //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
      /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
    public void  attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-");  
        System.out.println("2-");
        System.out.println("3-");
        System.out.println("4-");
        System.out.println("5- Baillement : Attaque magique puissante \n cout : 80 puissance : 150 precision : 70  ");
        System.out.println("6- Rêve Lucide : Attaque faible mais qui paralyse l'ennemie \n cout : 40, puissance : 30, precision : 100");
        System.out.println("7- Appel du Grand Sommier : endort J2 jusqu'a 4 tours \n cout : 40, puissance : -, precision : 60");
        System.out.println("8- Prière à Dlul : Attaque puissante, si J2 dort, les degats sont multiplies par 2 et J2 se reveil \n cout : 60, puissance : 100-200, precision : 100 ");
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
    public boolean attaque5(Personnage J2){ //inflige des degats a J2.
         boolean att = false;
        
        if( this.mana >= 80){ //si le mana est suffisant le joueur peut attaquer
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //calcul de l'esquive
			if(esquive>30){ //condition de precision 
			int aleat = (int)(Math.random()*10+90); // coefficient valeur attaque
            int degat = (int)(aleat*(42*this.magie*150)/(50*J2.resistanceMagique)); //calcul des degats
				if(degat >= 0){ // si les degats sont suffisants le joueur peut attaquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
				
		
				}else{ //les degats sont insuffisants
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
				}
		}else{
			System.out.println(J2.nom +" esquive l'attaque");
		}
            this.mana  -= 80; //diminution du mana
            att = true; //attaque a bien eu lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer a nouveau
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
    
     public boolean attaque6(Personnage J2){ //attaque faible sur J2 avec paralysie
        
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90); //coefficient valeur attaque
            int degat = (int)((aleat*42*this.force*30)/(50*J2.defensePhysique*100)); //calcul degats
            if(degat >= 0){ // si les degats sont suffisants le joueur peut attaquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et le paralyse");
            }else{ //les degats sont insuffisants
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            }
            this.mana  -= 40; //diminution du mana
            J2.paralysie=4; //paralyse J2 pour 4 tours
            att = true; //attaque a bien eu lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer a nouveau
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
    
    public boolean attaque7(Personnage J2){ //attaque speciale qui endors J2
		
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
    *Cette methode decrit l'attaque speciale 8 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
   public boolean attaque8(Personnage J2){ //Attaque puissante, inflige de lourds degats a J2 qui sont doublés si J2 est endormi. Reveille J2
         boolean att = false;
        
        if( this.mana >= 60){ //si le mana est suffisant le joueur peut attaquer
			int aleat = (int)(Math.random()*10+90); // coefficient valeur attaque
            int degat = (int)(aleat*(42*this.magie*100)/(50*J2.resistanceMagique)); //calcul des degats
				if(degat >= 0){ //si les degats sont suffisants le joueur peut attaquer
					if (J2.dodo>0){ //vérifie que J2 dors
                J2.vie -= 2*degat; //double les degats de l'attaque et enleve la vie de l'ennemi
                J2.dodo=0; //reveille J2
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom+" et le reveil" );
			}else{ //si J2 ne dors pas
				J2.vie -= degat; //inflige les degats normaux a J2
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom);
			}
				
		
				}else{ //degats insuffisants
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
				}
        
            this.mana  -= 60; //diminution du mana
            att = true; //l'attaque a bien eu lieu
        }else{ //si le mana est insuffisant le joueur peut attaquer a nouveau
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eu lieu
        }

        
        return att;
    }
     
}
