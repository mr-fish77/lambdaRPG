public class Necromancien extends Personnage{
    
 
    
    public Necromancien(String n, int v, int MP, int d, int f, int s, int m, int r, int RM, int poi, int br, int dd, int pr){
        
        super( n,  v,  MP,  d,  f,  s,  m, r, RM, poi, br, dd, pr);
        
    }
    
    
    public boolean attaque4(Personnage J2){ //Attaque faible qui provoque poison 
        
        boolean att = false;
        if( this.mana >= 40){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*30)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et l'empoisonne");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est empoisonne");
            }
            
            J2.poison=3;
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
			}
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque1(Personnage J2){ //Attaque faible qui peut aleatoirement empoisonner l'ennemi
        
       boolean att = false;
        if( this.mana >= 40){
			
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.magie*30)/(50*J2.resistanceMagique*100));
            if(degat >= 0){
                J2.vie -= degat;
                int empoi= (int)(Math.random()*100);
                if (empoi<11){
					J2.poison=3;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et l'empoisonne");
			}else{
				System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            
            
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    
    public boolean attaque2(Personnage J2){ // Attaque moyenne qui peut diminuer resistance magique de J2
        
         boolean att = false;
        if( this.mana >= 50){
			
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.magie*80)/(50*J2.resistanceMagique*100));
            if(degat >= 0){
                J2.vie -= degat;
                int baisse= (int)(Math.random()*100);
                if (baisse<11){
					J2.vitesse=(int)(0.9*J2.vitesse);
                System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom +" et diminue sa resistance magique de 10%");
			}else{
				System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            
            
			this.mana  -= 50;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }

      
    
     public boolean attaque3(Personnage J2){ // Attaque moyenne, J1 peut aleatoirement recuperer 100 HP
        boolean att = false;
        if( this.mana >= 50){
			
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*80)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                int revi= (int)(Math.random()*100);
                if (revi<11){
					this.vie +=100;
                System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom +" et recupere 100 HP");
			}else{
				System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! ");
            }
            
            
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
}
    
