public class Mage extends Personnage{
    
    
    public Mage(String n, int v, int MP, int d, int f, int s, int m, int r,int RM, int poi, int br, int dd, int pr){
        
        super( n,  v,  MP,  d,  f,  s,  m, r, RM, poi, br, dd, pr);
    }
    
   
    
    public boolean attaque1(Personnage J2){ // degats + baisse def spe
        
        boolean att = false;
        
        if( this.mana >= 50){
			
			int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.magie*90)/(50*J2.resistanceMagique*100));
				if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
				int baisse = (int)(Math.random()*100);
					if (baisse<=10) {
					J2.resistanceMagique = (int)(J2.resistanceMagique*0.9);
					System.out.println(J2.nom+" a pris peur lors de l'attaque et voit sa defense speciale diminuer de 10%");
					}
		
				}else{
                System.out.println("l'attaque est sans effet. L'ennemie e trop de defense !!");
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

    public boolean attaque2(Personnage J2){ // degats + brulure
        
        boolean att = false;
        if( this.mana >= 30){
			int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.magie*50)/(50*J2.resistanceMagique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
				int brulure = (int)(Math.random()*100);
					if (brulure<=10) {
					J2.brulure=3;
					System.out.println(J2.nom+" a ete brule lors de l'attaque");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 30;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
	}

        
        return att;
	
	}
    
    public boolean attaque3(Personnage J2){ //degats
        
        boolean att = false;
        if( this.mana >= 40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*80)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
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
    
    public boolean attaque4(){ //Augmentation att spe
         
        boolean att = false;
        if( this.mana >= 40){
            this.magie = (int)(this.magie*1.2);
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

