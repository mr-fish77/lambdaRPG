import java.util.Scanner;

public class Spartacus extends Guerrier{

    public Spartacus(){
        
        super("Spartacus", 728,100,359,339,262,209,20,229,0,0,0,0); //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
    
     public void attaquer(Personnage J2){
        
        Scanner sc = new Scanner(System.in);
        boolean attok = false;
	     
        //affichage des attaques du personnage
        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Pichenette: Attaque faible et peut aleatoirement diminuer defense J2 de 20% \n cout : 30, puissance : 40, precision : 100");  
        System.out.println("2- This is Sparta !: Attaque puissante qui provoque legere paralysie \n cout : 50, puissance : 80, precision : 90 ");
        System.out.println("3- Fureur sanguine: Attaque moyenne \n cout : 40, puissance : 70, precision : 100");
        System.out.println("4- Rempart: Augmente la defense de J1 de 20% \n cout : 40, puissance :- , precision : 100");
        System.out.println("5- Renomme : diminue defense physique et magique de 20% et augmente l'attaque de 40% \n cout : 60, puissance :- , precision : - ");
        System.out.println("6- Sang bleu: Convertie 5% de sa vie en mana \n cout : 60 ,puissance :-  ,precision : - ");
        System.out.println("7- Bourinage: Attaque puissante, mais J1 subit egalement des degats \n cout : -, puissance :-  precision : - ");
        System.out.println("8- Nouvelle sandale: Augmente la vitesse de 20% \n cout : 40, puissance :- ,precision : - ");
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
    *Cette methode decrit l'attaque5 speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
     public boolean attaque5(Personnage J2){ // Le jouer change de nom, diminue sa defense et  augmenteattaque
        boolean att = false; 
        if( this.mana >= 60){ //si le mana est suffisant le joueur peut attaquer
            this.nom="Spartanus";
            this.defensePhysique=(int)(0.8*this.defensePhysique);
	    this.resistanceMagique=(int)(0.8*this.resistanceMagique);
            this.force=(int)(1.4*this.force);
            System.out.println("Spartacus se renomme en Spartanus, sa defense  physique et magique diminue de 20% et son attaque augmente de 40% egalement");
            
            this.mana  = this.mana - 60; //diminution du mana
            att =true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur ne peut pas attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        
        return att;
        
        }
/**
    *Cette methode decrit l'attaque 6 speciale du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque6(Personnage J2){ // convertie 5% de la vie du joueur en mana
            boolean att = false;
            this.mana+=(int)(this.vie*0.05); 
            this.vie=(int)(0.95*this.vie);
            System.out.println(this.nom +"convertie 5% de sa vie en mana");
            att =true; //attaque a bien eut lieu
            return att;//retourne l'état de l'attaque    
    }
	
    /**
    *Cette methode decrit l'attaque  speciale 7 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque7(Personnage J2){ //le joueur fait une attaque puissante mais subit 1/6 des degats
        
        boolean att = false;
        if( this.mana >= 80){ //si le mana est suffisant le joueur peut attaquer
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*150)/(50*J2.defensePhysique*100));
            if(degat >= 0){ // si les dégats sont suffisants le joueur peut attquer
                J2.vie -= degat; //diminution de la vie de l'ennemi
                this.vie-=(int)(degat/6);  //diminution de la vie du joeur
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
                System.out.println("En retour, il subit "+ (int)(degat/6)+" degats");
            }else{ //les dégts sont insuffisants 
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 80;  //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        
        return att; //retourne l'état de l'attaque  
    }
	/**
    *Cette methode decrit l'attaque  speciale 8 du personnage. 
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    
    public boolean attaque8(Personnage J2){ //Augmente vitesse du joueur de 20%
        
        boolean att = false;
        if( this.mana >= 40){ //si le mana est suffisant le joueur peut attaquer
	    this.vitesse=(int)(this.vitesse*1.2); //augmentation de la vitesse du joueur
            System.out.println(this.nom+" augmente sa vitesse de 20%");
	    this.mana  -= 40;  //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{ //si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        return att;  //retourne l'état de l'attaque        
    }  
}
