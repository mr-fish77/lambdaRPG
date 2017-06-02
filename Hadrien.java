import java.util.Scanner;

public class Hadrien extends Guerrier{

    public Hadrien(){
        
        super("Hadrien le Hun",688,100,559,379,264,219,20,259,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie

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
        System.out.println("5- Attaque puissante mais J1 subit la moitie des degats");
        System.out.println("6- Attaque puissante qui diminue la defense adverse de 20%");
        System.out.println("7- Augmente la vitesse de J1 de 20%");
        System.out.println("8- Paralyse J2");
        System.out.println("9- Passer son tour" );
        
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
                    attok = attaque7();
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
    public boolean attaque5(Personnage J2){ //attaque puissante + J1 prend la moitie des degats
        
       boolean att = false;
        if( this.mana >= 80){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>10){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*250)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                this.vie-=(int)(degat/2);
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom+" et "+this.nom+" prend la moitie des degats soit "+ (int)(degat/2) );
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! ");
            }
            
           
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
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
    
    public boolean attaque6(Personnage J2){  // attaque puissante et def ennemie -20%
        boolean att = false;
        
        if( this.mana >= 80){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.defensePhysique*100)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                J2.defensePhysique=(int)(J2.defensePhysique*0.8);
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom+" et brise sa defense" );
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
    
    public boolean attaque7(){ // augmente vitesse de 20%
        
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
    
    public boolean attaque8(Personnage J2){ // paralyse J2
        
        boolean att = false;
        
        if( this.mana >= 40){
			J2.paralysie=4;
        System.out.println(this.nom+"terrorise "+J2.nom+", il est paralyse");
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
