public class Guerrier extends Personnage{
    
 
    
    public Guerrier(String n, int v, int MP, int d, int f, int s, int m, int r, int RM, int poi, int br, int dd, int pr){
        
        super( n,  v,  MP,  d,  f,  s,  m, r, RM, poi, br, dd, pr);
        
    }
    
    
    public boolean attaque1(Personnage J2){ //Attaque faible et peut aleatoirement diminuer defense J2 de 20%
        
        boolean att = false;
        if( this.mana >= 30){
			
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*40)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                int baisse= (int)(Math.random()*100);
                if (baisse<11){
					J2.defensePhysique=(int)(J2.defensePhysique*0.8);
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et diminue sa defense de 20%");
			}else{
				System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est brule");
            }
            
            
			this.mana  -= 30;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque2(Personnage J2){ //Attaque puissante qui provoque legere paralysie
        
       boolean att = false;
        if( this.mana >= 50){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>10){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*80)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" celui ci est paralyse");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            }
            
           J2.paralysie=3;
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
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
    
    public boolean attaque3(Personnage J2){ // Attaque moyenne 
        
        
        boolean att = false;
        if( this.mana >= 40){
			
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*70)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque moderee. Il cause " +degat+ " degats a " + J2.nom );
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
    public boolean attaque4(){ //Augmente la defense de J1 de 20%
    boolean att = false;
        if( this.mana >= 40){
			this.defensePhysique=(int)(this.defensePhysique*1.2);
			System.out.println("La defense de "+ this.nom+" augmente de 20%");
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
