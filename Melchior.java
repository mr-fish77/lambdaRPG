import java.util.Scanner;
public class Melchior extends Mage{

    public Melchior(){
        
        super("Melchior", 500, 100 , 50, 100, 200, 400, 10); //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
    public void  attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Or       2-La Main De Midas     3-Yami no mahO    4- Flammeche    5-Passer son tour" );
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = or();
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
                    System.out.println("attaque saisie incorrect. Rechoisi ton attaque !! ");
                break;
            }
        }
        

        
    }
    
    public boolean or(){
        boolean att = false;
        
        if( this.mana >= 50){
            this.magie += 50;
            System.out.println(this.nom + " utilise une amulette qui augmente sa magie de 50 " );
            this.mana -=50;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
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
            this.mana -=40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
        }
        
        return att;

    }
        
        
        
        
    
    
    
}
