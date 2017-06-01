import java.util.Scanner;

public class Achille extends Guerrier{

    public Achille(){
        
        super("Achille", 708,100,559,379,256,219,20,259,0,0,0,0); //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
      /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){ 
        Scanner sc = new Scanner(System.in);
        boolean attok = false;
        
         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- : attaque puissante avec 10% de chance de baisser def spe");  
        System.out.println("2-");
        System.out.println("3-");
        System.out.println("4-");
        System.out.println("5- Attaque puissante mais avec une contrepartie");
        System.out.println("6- Attaque provoquant paralysie");
        System.out.println("7- Diminue vitesse J2");
        System.out.println("8- Augmentation attaque");
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
    /**
    *Cette methode decrit l'attaque speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
     public boolean attaque5(Personnage J2){ //attaque avec degats pour J2 mais aussi une partie pour J1
        
        boolean att = false;
        if( this.mana >= 80){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*150)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                this.vie-=(int)(degat/6);
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
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
    
     public boolean attaque6(Personnage J2){ //degats + paralysie
        
        boolean att = false;
        if( this.mana >= 40){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*30)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et le paralyse");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            }
            
            J2.paralysie=4;
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
			}
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque7(Personnage J2){ // diminue vitesse J2
        boolean att = false;
        if( this.mana >= 40){
			
           J2.vitesse= (int)(J2.vitesse*0.9);
                System.out.println("La vitesse de "+J2.nom + " diminue de 10%");
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque8(){ //Augmentation att
         
        boolean att = false;
        if( this.mana >= 40){
            this.force = (int)(this.force*1.2);
            System.out.println(this.nom+" augmente sa force de 20%");
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
