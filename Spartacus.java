import java.util.Scanner;

public class Spartacus extends Guerrier{

    public Spartacus(){
        
        super("Spartacus", 728,100,359,339,189,209,20,229,0,0,0,0); //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
     public void attaquer(Personnage J2){
        
        Scanner sc = new Scanner(System.in);
        boolean attok = false;
        
         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-");  
        System.out.println("2-");
        System.out.println("3-");
        System.out.println("4-");
        System.out.println("5-");
        System.out.println("6-");
        System.out.println("7-");
        System.out.println("8-Passer son tour" );
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = guerrecivile(J2);
                break;
                case 2:
                    attok = augmentationForce();
                break;
                case 3:
                    attok = augmentationDefense();
                break;
                case 4:
                    attok = attaqueRapide(J2);
                break;
                case 5:
                    attok = attaquePhysiquePuissante(J2); 
                break;
                case 6:
                    System.out.println(J2.nom +  " passe son tour !");
                    attok = true;
                break;
                default:
                    attok = false;
                    System.out.println("attaque saisie incorrect. Rechoisi ton attaque !! ");
                break;
            }
        }
        
    }
    
    public boolean guerrecivile(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){
            
             int degat = this.vitesse/10 + this.force/2 ;
            J2.vie = J2.vie - degat;
            System.out.println("Les esclaves se libèrent et vont attaquer " + J2.nom + " Il fait " + degat + " a "+ J2.nom);
            
            this.mana  = this.mana - 50;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
}
