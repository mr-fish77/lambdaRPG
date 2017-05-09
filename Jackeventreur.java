import java.util.Scanner;

public class Jackeventreur extends Guerrier{

    public Jackeventreur(){
        
        super("Jack l'Eventreur", 250, 100 , 600, 100, 250, 0, 10);     //nom, vie, mana, defense, force, vitesse, magie, recupération

    }
    
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-A mort la catin    2-Aconite     3-Burqa    4- Dague vengeresse   5-Exécution     6-Passer son tour" );
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = amortlacatin(J2);
                break;
                case 2:
                    attok = aconite(J2);
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
       
    public boolean amortlacatin(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){
            
            int degat = 250;
            J2.vie = J2.vie - degat;
            System.out.println(this.nom + " s'acharne sur l'ennemi. IL provoque de profondes balafres à la gorge de " + J2.nom + ", puis lui mutile l'abdomen et finie avec les parties génitales");
            this.mana  = this.mana - 50;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
     
    public boolean aconite(Personnage J2){
        
        
        boolean att = false;
        
        if( this.mana >= 50){
            int diminution =  (int) J2.force * 15/100;
            J2.force = J2.force - diminution;
            System.out.println( this.nom + " s'infiltre dans le camp ennemie et empoisonne l'eau de l'adversaire. " + J2.nom + " est afaiblie et voit sa défence diminuer diminue de 15% ");
            this.mana -= 50;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
    }
        
    
}
