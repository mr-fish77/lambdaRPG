import java.util.Scanner;

public class Hades extends Necromancien{
    
    public Hades(){
        
        super("Hades", 600, 100 , 50, 90, 180, 450, 10);     //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Persephone Gate   2-Malediction    3-Lance de macchabées   4- Caresse de la mort   5-Noces funebres     6-Passer son tour" );
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = persephone(J2);
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
       
    public boolean persephone(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){
            this.vie =(int) (this.vie* 0.9);
            J2.vie = (int)(J2.vie* 0.7);
            this.defense = this.defense*2;
            System.out.println(this.nom + " Persephone ouvre la porte des enfers !! " +this.nom + " perd 10% de vie mais " +J2.nom+ " en pert 30%");
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
