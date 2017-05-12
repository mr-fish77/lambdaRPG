public class Guerrier extends Personnage{
    
 
    
    public Guerrier(String n, int v, int MP, int d, int f, int s, int m, int r){
        
        super( n,  v,  MP,  d,  f,  s,  m, r);
        
    }
    
    
    public boolean attaquePhysiquePuissante(Personnage J2){
        
        boolean att = false;
        
        if( this.mana >= 40){
            int degat = this.vitesse/10 + this.force/2 - J2.defense/5;
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie à trop de defense !!");
            }
            this.mana  = this.mana - 40;
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
        
        if( this.mana >= 20){
            int degat =  this.vitesse/2 + this.force/10 - J2.defense/5;
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie à trop de defense !!");
            }
        this.mana  = this.mana - 20;
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
        
        if( this.mana >= 20){
            
           
            this.defense = (int) (this.defense *1.1); 
            System.out.println(this.nom + " se met en boule. Defense +10% " );
            
            this.mana  = this.mana - 20;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
    public boolean augmentationForce(){
        boolean att = false;
        
        if( this.mana >= 20){
            
           
            this.force = (int) (this.force * 1.1); 
            System.out.println(this.nom + " se prepare un Riz-Dinde. Force +10% " );
            
            this.mana  = this.mana - 20;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
   
        
        
    





}
