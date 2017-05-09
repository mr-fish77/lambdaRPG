public class Mage extends Personnage{
    
    
    public Mage(String n, int v, int MP, int d, int f, int s, int m, int r){
        
        super( n,  v,  MP,  d,  f,  s,  m, r);
    }
    
   
    
    public boolean attaqueMagiePuissante(Personnage J2){
        
        boolean att = false;
        
        if( this.mana >= 40){
            int degat = this.magie - J2.defense;
            if(degat >= 0){
                J2.vie = J2.vie - this.magie + J2.defense;
                System.out.println(this.nom + " fais une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie à trop de defense !!");
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
            int degat =  this.vitesse - J2.defense;
            if(degat >= 0){
                J2.vie = J2.vie - this.vitesse + J2.defense;
                System.out.println(this.nom + " fais une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
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
    
    

        
        





}
