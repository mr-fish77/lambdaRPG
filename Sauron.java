import java.util.Scanner;

public class Sauron extends Necromancien{
    
    public Sauron(){
        
        super("Sauron", 1196,100,189,279,219,279,20,189,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

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
                    attok = monPrecieux(J2);
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
                    System.out.println("attaque saisie incorrecte. Rechoisi ton attaque !! ");
                break;
            }
        }
        
    }
       
    public boolean monPrecieux(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){
            
            this.defensePhysique = (int)(this.defensePhysique*1.2);
            this.vitesse = (int)(this.vitesse*1.2);
            this.force = (int)(this.force*1.2);
            System.out.println(this.nom + " augmente sa defense, sa vitesse et sa force de 20%");
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
