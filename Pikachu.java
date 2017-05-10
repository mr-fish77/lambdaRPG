import java.util.Scanner;

public class Pikachu extends Mage{

    public Pikachu(){
        
        super("Pikachu", 700, 100 , 50, 85, 230, 350, 10); //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Fatal Foudre      2-Boul'armure     3-Vive attaque    4- Queue de fer    5-Passer son tour");
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = pika(J2);
                break;
                case 2:
                    attok = boularmure();
                break;
                case 3:
                    attok = attaqueRapide(J2);
                break;
                case 4:
                    attok = attaqueMagiePuissante(J2);
                break;
                case 5:
                    System.out.println(this.nom +  " passe son tour !");
                    attok = true;
                break;
                default:
                    attok = false;
                    System.out.println("attaque saisie incorrect. Rechoisi ton attaque !! ");
                break;
            }
        }
        
    }
    
    public boolean pika(Personnage J2){
        
        boolean att = false;
                
        if( this.mana >= 80){
            int degat = (int)( Math.random()*( J2.vie + 1 ) );
            J2.vie -= degat;
            System.out.println( "Pikaaaaachuuuuuuu !!! "+ J2.nom+ " subit " + degat + " degats" );
            this.mana -= 80;
            att = true;
        
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
    }
    
    
    public boolean boularmure(){
        
        boolean att = false;
        
        if( this.mana >= 40){
        
            
            int augmentation =  (int) this.defense * 20/100;
            this.defense = this.defense + augmentation;  
            System.out.println(this.nom + " se roule en boule. Defense +20%." );
            this.mana -= 40;
            att = false;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;

    }
   
    
    
}
