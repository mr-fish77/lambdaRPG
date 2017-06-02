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
         System.out.println("1- Pichenette: Attaque faible et peut aleatoirement diminuer defense J2 de 20% \n cout : 30 puissance : 40 precision : 100");  
+        System.out.println("2- This is Sparta !: Attaque puissante qui provoque legere paralysie  \n cout : 50 puissance : 80 precision : 90 ");
+        System.out.println("3- Fureur sanguine: Attaque magique moyenne \n cout : 40 puissance : 70 precision : 100");
+        System.out.println("4- Rempart: Augmente la defense de J1 de 20% \n cout : 40 puissance :-  precision : 100");
+        System.out.println("5- Purge: Augmente vitesse, force et defense \n cout: 50, puissance: - , precision: -");
+        System.out.println("6- Lance missile: L'attaque a 50% de chance de causer 200 degats \n cout: 60, puissance: - , precision: 50");
+        System.out.println("7- Regime (communiste): Augmente la vitesse de 20% \n cout: 40, puissance: - , precision: - ");
+        System.out.println("8- Vote \n cout: 10, puissance: - , precision: 100");
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
   public boolean attaque5(Personnage J2){// augmente vitesse force defense du joueur
        boolean att = false;
        
        if( this.mana >= 50){ //si le mana est suffisant le joueur peut attaquer
          	this.defensePhysique = (int)(this.defensePhysique*1.2);  //augmente la défense physique
          	 this.vitesse = (int)(this.vitesse*1.2); //augmente la vitesse
           	this.force = (int)(this.force*1.2);//augmente la force
           	System.out.println(this.nom + " elimine tous les opposants politiques. \n Il augmente sa defense, sa vitesse et sa force de 20%");
           	this.mana  -= 50; //diminution du mana
           	att =true; //attaque a bien eut lieu
        }else{  //si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }
        
        return att; //retourne l'etat de l'attaque
        
    }
    
         /**
   *Cette methode decrit l'attaque speciale 6 du personnage. 
   *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
  *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
   */
  public boolean attaque6(Personnage J2){ //50% chance causer 200 degats
        
        boolean att = false;
        if( this.mana >= 60){  //si le mana est suffisant le joueur peut attaquer
	  int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100); //valeur de l'esquive
		if(esquive>50){  //si la precission est suffisante le joueur peut attaquer
            		J2.vie-=200;  
            		System.out.println("La defense de "+J2.nom+" est innefficace, il perd 200 PV");         
           	 }else{  //si la precission n'est pas suffisante le joueur ne peut pas attaquer
			System.out.println(" Les missiles se sont encore une fois ecrases dans la mer du Japon");
			}
	    this.mana  -= 60; //diminution du mana
            att = true; //attaque a bien eut lieu
        }else{//si le mana n'est pas suffisant le joueur peut attaquer
            System.out.println(this.nom +  " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //attaque n'a pas eut lieu
        }

        
        return att; //retourne l'etat de l'attaque
        
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
