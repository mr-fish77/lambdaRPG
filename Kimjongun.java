import java.util.Scanner;

public class Kimjongun extends Guerrier{

    public Kimjongun(){
        
        super("Kim jong un", 868,100,359,379,259,209,20,209,0,0,0,0);    //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie

    }
     /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Attaque faible et peut aleatoirement diminuer defense J2 de 20%");  
        System.out.println("2- Attaque puissante qui provoque legere paralysie");
        System.out.println("3- Attaque moyenne ");
        System.out.println("4- Augmente la defense de J1 de 20%");
        System.out.println("5- Augmente vitesse, force et defense");
        System.out.println("6- L'attaque a 50% de chance de causer 200 degats");
        System.out.println("7- Augmente la vitesse de 20%");
        System.out.println("8- Vote");
        System.out.println("9-Passer son tour" );
        
        while(attok == false){ /**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
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
       
    /**
    *Cette methode decrit l'attaque speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
   public boolean attaque5(Personnage J2){// augmente vitesse force defense 
        boolean att = false;
        
        if( this.mana >= 50){
            
            this.defensePhysique = (int)(this.defensePhysique*1.2);
            this.vitesse = (int)(this.vitesse*1.2);
            this.force = (int)(this.force*1.2);
            System.out.println(this.nom + " augmente sa defense, sa vitesse et sa force de 20%");
            this.mana  -= 50;
            att =true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
        
    }
    
        public boolean attaque6(Personnage J2){ //50% chance causer 200 degats
        
        boolean att = false;
        if( this.mana >= 60){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>50){
            J2.vie-=200;  
            System.out.println("La defense de "+J2.nom+" est innefficace, il perd 200 PV");         
            }else{
			System.out.println(" Les missiles se sont encore une fois ecrases dans la mer du Japon");
			}
			this.mana  -= 60;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque7(Personnage J2){ //augmente vitesse de 20%
        
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
    
     public boolean attaque8(Personnage J2){ //Rien ne se passe 
        
        boolean att = false;
        if( this.mana >= 10){
			
            System.out.println(this.nom+" organise un vote");
            System.out.println("Il est elu a l'unanimite");
            System.out.println("Rien ne se passe ");
			this.mana  -= 10;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
}
