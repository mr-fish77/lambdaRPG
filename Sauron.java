import java.util.Scanner;

public class Sauron extends Necromancien{
    
    public Sauron(){
        
        super("Sauron", 1196,100,189,279,264,279,20,189,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
         System.out.println("1- Attaque faible qui peut aleatoirement empoisonner l'ennemi \n cout : 40 puissance : 30 precision : 100");  
        System.out.println("2- Attaque moyenne qui peut diminuer resistance magique de J2 \n cout : 50 puissance : 80 precision : 100");
        System.out.println("3- Attaque moyenne, J1 peut aleatoirement recuperer 100 HP \n cout : 50 puissance :80  precision : 100");
        System.out.println("4- Attaque faible qui provoque poison \n cout : 40 puissance : 30 precision : 60");
        System.out.println("5- La vie de J1 est divise par 2 mais celle de J2 par 4");
        System.out.println("6- J2 perd 30% de sa vie mais J1 en perd 10% egalement");
        System.out.println("7- Vole 10% des HP de J2");
        System.out.println("8- J1 convertie 10% de sa vie en mana");
        System.out.println("9- Passer son tour" );
        
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
                    attok = attaque4(J2);
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
                    attok = attaque8();
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
       
    public boolean attaque5(Personnage J2){ //vie J1/2 et J2/4
        
        boolean att = false;
        if( this.mana >= 120){
			J2.vie=(int)(J2.vie/4);
            this.vie=(int)(this.vie/2);
            System.out.println("La vie de "+this.nom+" est reduite de moitie, tandis que celle de "+J2.nom+" est reduite au quart");
			this.mana  -= 120;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque6(Personnage J2){ // J2 perd 30% de sa vie et J1 10%
        boolean att = false;
        
        if( this.mana >= 50){ //condition de mana
            this.vie =(int) (this.vie* 0.9); //Enleve 10% de sa propre vie  
            J2.vie = (int)(J2.vie* 0.7); //Enleve 30% de la vie de J2
            this.defensePhysique = (int) (this.defensePhysique*1.2); //Augmente de 20% sa propre défense
            System.out.println(this.nom + " ouvre les portes du Mordor, " +this.nom + " perd 10% de vie mais " +J2.nom+ " en pert 30%");
            this.mana  -= 50; //cout en mana de l'attaque
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
    public boolean attaque7(Personnage J2){ // vole 10% des HP de J2
        boolean att = false;
        
        if( this.mana >= 60){ //condition de mana
            
            int degat = (int)(0.1*J2.vie);
            J2.vie -= degat; //inflige les dégats de l'attaque
            this.vie += degat;
            System.out.println(this.nom +" vole 10% des PV de "+ J2.nom);
            this.mana  -=60; //cout en mana de l'attaque 
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
    public boolean attaque8(){ //Convertie 10% de la vie en mana
        boolean att = false;
        
        if( this.mana >= 40){ //condition de mana
            this.magie=(int)(this.magie+(this.vie*0.1));
            this.vie=(int)(this.vie*0.9);
            System.out.println(this.nom +" convertie 10% de sa vie en puissance magique");
            this.mana  -=40; //cout en mana de l'attaque 
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
   
}
