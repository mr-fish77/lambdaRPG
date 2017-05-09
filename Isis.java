import java.util.Scanner;

public class Isis extends Necromancien{
    
    public Isis(){
        
        super("Isis", 230, 100 , 550, 120, 257, 0, 10);     //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Sacrifice   2-Malédiction    3-Lancé de macchabées   4- Caresse de la mort   5-Noces funèbres     6-Passer son tour" );
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = sacrifice(J2);
                break;
                case 2:
                    attok = malediction(J2);
                break;
                case 3:
                    attok = attaquePuissante(J2);
                break;
                case 4:
                    attok = attaqueRapide(J2);
                break;
                case 5:
                    attok = attaqueMagiePuissante(J2);
                break;
                case 6:
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
       
    public boolean sacrifice(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){
            
            int degat = 250;
            J2.vie = J2.vie - degat;
            System.out.println(this.nom + " 72 vierges débarquent des enfers pour attaquer l'adversaire " +J2.nom+ "subit 250 de degats");
            this.mana  = this.mana - 50;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
    public boolean malediction(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 40){
            
            int degat =  (int) J2.vie * 10/100;
            J2.vie = J2.vie - degat;
            this.mana = this.mana + degat;
            System.out.println(this.nom + " Convertie 10% de la vie de " +J2.nom+ "en mana." +J2.nom+ "subit" + degat);
            this.mana  = this.mana - 540;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
}
