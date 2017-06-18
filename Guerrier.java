public class Guerrier extends Personnage{
    
 
    
    public Guerrier(String n, int v, int MP, int d, int f, int s, int m, int r, int RM, int poi, int br, int dd, int pr){ //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
	    
        
        super( n,  v,  MP,  d,  f,  s,  m, r, RM, poi, br, dd, pr); //appele le constructeur de la classe mère 
        
    }
    
     /**
    *Cette methode decrit l'attaque 1 commune à tous les guerriers 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque1(Personnage J2){ //Attaque faible et peut aleatoirement diminuer defense physique J2 de 20%
        
        boolean att = false;
        if( this.mana >= 30){ //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*40)/(50*J2.defensePhysique*100)); //calcul des dégats
            if(degat >= 0){ // si les dégats sont suffisants le joueur peut attquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                int baisse= (int)(Math.random()*100); //proba de diminution de la défence physique
                if (baisse<11){ //proba favorable
			J2.defensePhysique=(int)(J2.defensePhysique*0.8); //dimition de la défence physique de l'ennemie
                         System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et diminue sa defense de 20%");
		 }else{
			System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom);
		}
            }else{ //les dégts sont insuffisants 
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
	    this.mana -= 30; //diminution du mana
            att = true; //attaque a eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
         return att; //retourne l'état de l'attaque
        
    }
	
     /**
    *Cette methode decrit l'attaque 2 commune à tous les guerriers 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque2(Personnage J2){ //Attaque puissante qui provoque legere paralysie
        
       boolean att = false;
        if( this.mana >= 50){ //si le mana est suffisant le joueur peut attaquer
	    int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //calcul de l'esquive
		if(esquive>10){  //si la precission est suffisante le joueur peut attaquer
            		int aleat = (int)(Math.random()*10+90);
            		int degat = (int)(aleat*(42*this.force*80)/(50*J2.defensePhysique*100)); //calcul des degats
            		if(degat >= 0){ // si les dégats sont suffisants le joueur peut attquer
                		J2.vie -= degat; //diminution de la vie de l'ennemi
                		System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" celui ci est paralyse");
            		}else{  //les dégats sont insuffisants
                		System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            		}
            		J2.paralysie=3; //paralyse l'enneie sur 3 tours
            	}else{ //si la precission n'est pas suffisante le joueur ne peut pas attaquer
			System.out.println(J2.nom +" esquive l'attaque");
		}
	    this.mana  -= 50;  //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att;  //retourne l'état de l'attaque
    }
	
	 
     /**
    *Cette methode decrit l'attaque 3 commune à tous les guerriers 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque3 (Personnage J2){ // Attaque moyenne 
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*70)/(50*J2.defensePhysique*100)); //calcul des degats
            if(degat >= 0){ // si les dégats sont suffisants le joueur peut attquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom );
            }else{ //les dégts sont insuffisants
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
	    this.mana  -= 40;  //diminution du mana
            att = true;  //attaque a bien eut lieu 
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att;  //retourne l'état de l'attaque
        
    }
	
    /**
    *Cette methode decrit l'attaque 4 commune à tous les guerriers 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque4(){ //Augmente la defense du joueur de 20%
     	boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
	    this.defensePhysique=(int)(this.defensePhysique*1.2); //augmentatiode la defence
	    System.out.println("La defense de "+ this.nom+" augmente de 20%");
	    this.mana  -= 40; //diminution du mana
            att = true; //attaque a bien eut lieu 
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu 
        } 
        return att;  //retourne l'état de l'attaque
        
    }
    
   
        
        
    





}
