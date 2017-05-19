public class Assassin extends Personnage{
    
 
    
    public Assassin(String n, int v, int MP, int d, int f, int s, int m, int r){
        
        super( n,  v,  MP,  d,  f,  s,  m, r);
        
    }
    
    
    public boolean attaquePuissante(Personnage J2){
        
        boolean att = false;
        
        if( this.mana >= 30){
            int degat = this.vitesse/10 + this.force/2 - J2.defense/5;
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  = this.mana - 30;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
    public boolean attaqueRapide(Personnage J2){
        
        boolean att = false;
        
        if( this.mana >= 10){
            int degat =  this.vitesse/2 + this.force/10 - J2.defense/5;
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
        this.mana  = this.mana - 10;
        att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
    }
    
    
    public boolean augmentationDefense(){
        boolean att = false;
        
        if( this.mana >= 40){
            
            int augmentation =  (int) this.force * 10/100;
            this.force = this.force + augmentation; 
            System.out.println(this.nom + " se camoufle. Defense +10% " );
            
            this.mana  = this.mana - 40;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
    
         /**
    *Cette methode decrit une attaque commune aux assasins. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean aconite(Personnage J2){
        
        
        boolean att = false;
        
        if( this.mana >= 50){
            int diminution =  (int) J2.force * 15/100; //calcul de la diminution de force de J2
            J2.force = J2.force - diminution; //calcul de la nouvelle force de J2
            int degat = 50; //inflige les degats à J2
            System.out.println( this.nom + " s'infiltre dans le camp ennemie et empoisonne l'eau de l'adversaire. " + J2.nom + " est afaiblie et voit sa defense diminuer de 15% et est empoisonne!! (" + degat + " degats pendant 3 tours)");
            this.poison = 3; //établit le nombre de tour d'empoisonnement
            this.mana -= 50; //cout en mana
            att = true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
    }
             
        
    





}
