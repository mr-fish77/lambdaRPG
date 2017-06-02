import java.util.Scanner;

public class Donatello extends Assassin{
    
    
    public Donatello(){
        
        super("Donatello",680,100,229,383,286,229,20,329,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
        
    }
     /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);
       

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Attaque faible mais qui diminue la defense de J2");  
        System.out.println("2- Attaque puissante avec 1 chance sur 2 de causer 2 fois plus de degats ");
        System.out.println("3- Attaque moyenne ");
        System.out.println("4- Augmente la vitesse de J1 de 20%");
        System.out.println("5- Attaque moderee mais possibilite de recuperer 100 HP");
        System.out.println("6- Diminue vitesse de J2 de 10%");
        System.out.println("7- Vous recuperez 100 HP");
        System.out.println("8- Attaque faible mais qui empoisonne l'ennemi");
        System.out.println("9-Passer son tour" );
        
        while(attok == false){/**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
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
    public boolean attaque5(Personnage J2){
        boolean att = false;
        if( this.mana >= 50){
			
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*80)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                int revi= (int)(Math.random()*100);
                if (revi<11){
					this.vie +=100;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et recupere 100 HP");
			}else{
				System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom);
			}
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
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
    
     public boolean attaque6(Personnage J2){ //diminution vitesse J2
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

    public boolean attaque7(){ // regen vie
        boolean att = false;
        if( this.mana >= 40){
			
           this.vie +=100;
                System.out.println(this.nom + " recupere 100 PV");
			this.mana  -= 40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque8(Personnage J2){ //degats + poison
        
        boolean att = false;
        if( this.mana >= 40){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)(aleat*(42*this.force*30)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et l'empoisonne");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est empoisonne");
            }
            
            J2.poison=4;
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

    
}
