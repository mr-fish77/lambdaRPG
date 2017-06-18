public class Necromancien extends Personnage{
    
 
    
    public Necromancien(String n, int v, int MP, int d, int f, int s, int m, int r, int RM, int poi, int br, int dd, int pr){
        
        super( n,  v,  MP,  d,  f,  s,  m, r, RM, poi, br, dd, pr); //appele le constructeur de la classe mère 

        
    }
    
     /**
    *Cette methode decrit l'attaque 1 commune à tous les Necromancien 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque1(Personnage J2){ //Attaque magique faible qui peut aleatoirement empoisonner l'ennemi
        
       boolean att = false;
        if( this.mana >= 40){	 //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.magie*30)/(50*J2.resistanceMagique*100)); //calcul des degats
            if(degat >= 0){ // si les dégats sont suffisants le joueur peut attaquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                int empoi= (int)(Math.random()*100); //proba de d'enpoisonement
                if (empoi<11){  //proba favorable
		 	J2.poison=3; //ennemie empoissonné pour 3 tours
                	System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et l'empoisonne");
		}else{  //proba non favorable
			System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom);
		}
            }else{ //les dégats sont insuffisants 
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 40; //diminution du mana
            att = true; //attaque a eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att; //retourne l'état de l'attaque
    }
    
     /**
    *Cette methode decrit l'attaque 2 commune à tous les Necromancien 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque2(Personnage J2){ // Attaque magique moyenne qui peut diminuer  resistance magique de l'ennemi
        
        boolean att = false;
        if( this.mana >= 50){  //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.magie*80)/(50*J2.resistanceMagique*100)); //calcul des dégats
            if(degat >= 0){  // si les dégats sont suffisants le joueur peut attaquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                int baisse= (int)(Math.random()*100);  //proba de diminution de la resistance magique
                if (baisse<11){ //proba favorable
			J2.resistanceMagique=(int)(0.9*J2.resistanceMagique);
                        System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom +" et diminue sa resistance magique de 10%");
			}else{ //proba non favorable
				System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{ //les dégats sont insuffisants 
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 50; //diminution du mana
            att = true;  //attaque a eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att; //retourne l'état de l'attaque
    }

      
    /**
    *Cette methode decrit l'attaque 3 commune à tous les Necromancien 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
     public boolean attaque3(Personnage J2){ // Attaque magique moyenne, J1 peut aleatoirement recuperer 100 PV
        boolean att = false;
        if( this.mana >= 50){  //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*80)/(50*J2.defensePhysique*100)); //calcul des dégats
            if(degat >= 0){ // si les degats sont suffisants le joueur peut attaquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                int revi= (int)(Math.random()*100); //proba de recuperer 100 PV
                	if (revi<11){ //proba favorable
				this.vie +=100; //recuperationde 100 PV
                		System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom +" et recupere 100 HP");
			}else{ //proba non favorable
				System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{ //les degats sont insuffisants
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! ");
            }
            
            this.mana  -= 40; //diminution du mana
            att = true; //l'attaque a eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaque
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eut lieu
        }
        return att;  //retourne l'état de l'attaque
    }
    


/**
    *Cette methode decrit l'attaque 4 commune à tous les Necromancien 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque4(Personnage J2){ //Attaque physique faible qui provoque un empoissnnement
        
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
		int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //calcul de l'esquive
		if(esquive>40){  //si la precission est suffisante le joueur peut attaquer
            		int aleat = (int)(Math.random()*10+90);
            		int degat = (int)(aleat*(42*this.force*30)/(50*J2.defensePhysique*100)); //calcul des degats
            		if(degat >= 0){ // si les dégats sont suffisants le joueur peut attaquer
                		J2.vie -= degat; //diminution de la vie de l'ennemi
                		System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et l'empoisonne");
           		 }else{
                		System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est empoisonne");
            		}
            		J2.poison=3; //ennemie empoissoné pour 3 tours
            	}else{
			System.out.println(J2.nom +" esquive l'attaque");
			}
		this.mana  -= 40;  //diminution du mana
            	att = true; //l'attaque a eut lieu
        }else{  //si le mana n'est pas suffisant le joueur ne peut pas attaque
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //l'attaque n'a pas eut lieu
        }

        
        return att; //retourne l'état de l'attaque
        
    }
}

    
