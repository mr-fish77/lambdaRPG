import java.util.Scanner;

public class Gaspard extends Mage{

    public Gaspard(){
        
        super("Gaspard", 600, 100 , 50, 90, 180, 300, 10); //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Encens       2-La Main De Midas     3-Yami no mahO    4- Flammeche    5-Passer son tour");
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = encens(J2);
                break;
                case 2:
                    attok = laMainDeMidas();
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
                    System.out.println("attaque saisie incorrecte. Rechoisi ton attaque !! ");
                break;
            }
        }
        
    }
    
    public boolean encens(Personnage J2){
        
        boolean att = false;
        
        if( this.mana >= 50){
            int diminution =  (int) J2.force * 15/100;
            J2.force = J2.force - diminution;
            System.out.println( this.nom + " lance un nuage d'encens qui affaiblit " + J2.nom + ". La force de " +J2.nom + "diminue de 15% ");
            this.mana -= 50;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
    }
    
    
    public boolean laMainDeMidas(){
        
        boolean att = false;
        
        if( this.mana >= 40){
        
            int diminution =  (int) this.vitesse * 10/100;
            this.vitesse = this.vitesse - diminution;
            int augmentation =  (int) this.defense * 20/100;
            this.defense = this.defense + augmentation;  
            System.out.println(this.nom + " change sa cape en armure d'or. Defense +20%. Vitesse -10%" );
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
