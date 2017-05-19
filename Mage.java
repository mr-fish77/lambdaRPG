public class Mage extends Personnage{
    
    
    public Mage(String n, int v, int MP, int d, int f, int s, int m, int r){
        
        super( n,  v,  MP,  d,  f,  s,  m, r);
    }
    
   
    
    public boolean attaqueMagiePuissante(Personnage J2){
        
        boolean att = false;
        
        if( this.mana >= 40){
            int degat = this.vitesse/10 + this.magie/2 - J2.defense/5;
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie e trop de defense !!");
            }
        
            this.mana  = this.mana - 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaqueRapide(Personnage J2){
        
        boolean att = false;
        if( this.mana >= 20){
            int degat =  this.vitesse/2 + this.force/10 - J2.defense/5;
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  = this.mana - 20;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
        
     /**
    *Cette methode decrit une attaque commune aux mages
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean laMainDeMidas(){
        
        boolean att = false;
        
        if( this.mana >= 40){ //condition de mana
        
            int diminution =  (int) this.vitesse * 10/100; //calcul la diminution de vitesse
            this.vitesse = this.vitesse - diminution; //calcul la nouvelle vitesse
            int augmentation =  (int) this.defense * 20/100; //calcul l'augmentation de defense
            this.defense = this.defense + augmentation;  //calcul la nouvelle de defense
            System.out.println(this.nom + " change sa cape en armure d'or. Defense +20%. Vitesse -10%" );
            this.mana -= 40; //cout en mana de l'attaque
            att = true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;

    }


}
