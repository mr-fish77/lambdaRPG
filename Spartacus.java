import java.util.Scanner;

public class Spartacus extends Guerrier{

    public Spartacus(){
        
        super("Spartacus", 728,100,359,339,262,209,20,229,0,0,0,0); //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
    
     public void attaquer(Personnage J2){
        
        Scanner sc = new Scanner(System.in);
        boolean attok = false;
        
         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-");  
        System.out.println("2-");
        System.out.println("3-");
        System.out.println("4-");
        System.out.println("5- Renomme : diminue defense et augmente l'attaque de 10%");
        System.out.println("6- Convertie 5% de sa vie en mana");
        System.out.println("7- Attaque puissante, mais J1 subit egalement des degats");
        System.out.println("8- Augmente la vitesse de 20%");
        System.out.println("9-Passer son tour" );
        
        while(attok == false){
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = attaque1(J2);
                break;
                case 2:
                    attok = attaque2(J2);
                break;
                case 3:
                    attok = attaque3(J2);
                break;
                case 4:
                    attok = attaque4();
                break;
                case 5:
                    attok = attaque5(J2);
                break;
                case 6:
                    attok = attaque6(J2);
                break;
                case 7:
                    attok = attaque7(J2);
                break;
                case 8:
                    attok = attaque8(J2);
                break;
                case 9:
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
    
     public boolean attaque5(Personnage J2){ // Change nom, diminue defense, augmente attaque
        boolean att = false;
        
        if( this.mana >= 50){
            
            this.nom="Spartanus";
            this.defensePhysique=(int)(0.9*this.defensePhysique);
            this.force=(int)(1.1*this.force);
            System.out.println("Spartacus se renomme en Spartanus, sa defense diminue de 10% et son attaque augmente de 10% egalement");
            
            this.mana  = this.mana - 50;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
        }
    
    public boolean attaque6(Personnage J2){ // convertie 5% de sa vie en mana
        boolean att = false;
        
       if (this.mana >= 0){
            
            this.mana+=(int)(this.vie*0.05);
            this.vie=(int)(0.95*this.vie);
            System.out.println(this.nom +"convertie 5% de sa vie en mana");
            att =true;
        }
        
        return att;
        
    }
    
    public boolean attaque7(Personnage J2){ //Attaque puissante mais subit 1/6 des degats
        
        boolean att = false;
        if( this.mana >= 80){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*150)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                this.vie-=(int)(degat/6);
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
                System.out.println("En retour, il subit "+ (int)(degat/6)+" degats");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 80;
            
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
    }
    
    public boolean attaque8(Personnage J2){ //Augmente vitesse de 20%
        
        boolean att = false;
        if( this.mana >= 40){
			this.vitesse=(int)(this.vitesse*1.2);
            System.out.println(this.nom+" augmente sa vitesse de 20%");
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
}
