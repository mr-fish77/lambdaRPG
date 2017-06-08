import java.util.Scanner;

public class Hades extends Necromancien{
    
    public Hades(){
        
        super("Hades", 1000,100,259,269,264,269,20,289,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
          /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);
	     
         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Putréfaction: Attaque faible qui peut aleatoirement empoisonner l'ennemi \n cout : 40, puissance : 30, precision : 100");  
        System.out.println("2- Décrépitude: Attaque moyenne qui peut diminuer resistance magique de J2 \n cout : 50, puissance : 80, precision : 100");
        System.out.println("3- Buveuse d'ame: Attaque moyenne, J1 peut aleatoirement recuperer 100 HP \n cout : 50, puissance : 80,  precision : 100");
        System.out.println("4- Tourment: Attaque faible qui provoque poison \n cout : 40, puissance : 30, precision : 60");
        System.out.println("5- Retour des enfers: J2 perd 30% de sa vie mais J1 en perd 10% egalement \n cout : 50, puissance : - precision : -");
        System.out.println("6- Un mal pour un bien: Convertie 10% de la vie de J2 en mana pour J1 \n cout : 40 puissance : - precision : -");
        System.out.println("7- Bain de lave: Attaque faible mais qui brule l'ennemie \n cout : 40 puissance : - precision : - ");
        System.out.println("8- Chant morbide: Attaque faible avec 10% de chance d'endormir l'ennemie \n cout : 30 puissance : - precision : -");
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
   public boolean attaque5(Personnage J2){ // 30% vie de J2 mais 10% vie de J1
        boolean att = false;
        
        if( this.mana >= 50){ //condition de mana
            this.vie =(int) (this.vie* 0.9); //Enleve 10% de sa propre vie  
            J2.vie = (int)(J2.vie* 0.7); //Enleve 30% de la vie de J2
            
            System.out.println(" Persephone ouvre la porte des enfers !! " +this.nom + " perd 10% de vie mais " +J2.nom+ " en pert 30%");
            this.mana  -= 50; //cout en mana de l'attaque
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
    public boolean attaque6(Personnage J2){ // vole de vie vers mana
        boolean att = false;
        
        if( this.mana >= 50){ //condition de mana
            this.mana+=(int)(0.1*J2.vie);
            J2.vie=(int)(0.9*J2.vie);
            System.out.println(this.nom + " vole 10% des PV de" + J2.nom+ " et les convertie en mana");
            this.mana  -= 50; //cout en mana de l'attaque
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
    public boolean attaque7(Personnage J2){ //degats + brulure
        
        boolean att = false;
        if( this.mana >= 40){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*30)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " force son ennemi à prendre un bain de lave. Il cause " +degat+ " degats a " + J2.nom +" et le brule");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est brule");
            }
            
            J2.brulure=3;
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
   
   public boolean attaque8(Personnage J2){ // degats + 10% chance de sommeil
        
        boolean att = false;
        if( this.mana >= 30){
	    int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.magie*50)/(50*J2.resistanceMagique*100));
            	if(degat >= 0){
                	J2.vie -= degat;
                	System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
			int sommeil = (int)(Math.random()*100);
				if (sommeil<=10) {
				 	J2.dodo=3;
					System.out.println(J1.nom+" chante la macabrena. Il endore son ennemie");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 30;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
	}

        
        return att;
	
	}
    
   
}
