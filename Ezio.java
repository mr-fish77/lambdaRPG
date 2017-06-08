import java.util.Scanner;

public class Ezio extends Assassin{
    
    
    public Ezio(){
        
        super("Ezio Auditore da Firenze",648,100,259,394,284,219,20,219,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
        
    }
     /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);
        

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Feinte: Attaque physique faible qui diminue la defence de J2 \n cout : 30, puissance : 40, precision : 80");  
        System.out.println("2-Sournoiserie: Attaque physique puissante \n cout : 50, puissance : 90, precision : 100");
        System.out.println("3-Infiltration: Attaque magique puissante \n cout : 40, puissance : 80, precision : 100");
        System.out.println("4-Pulsions: Augmente la vitesse du joueur \n cout : 40, puissance : -, precision : 100");
        System.out.println("5-Bug dans la mémoire: Attaque moderee avec 10% chance de diminuer defense de J2 \n cout : 50, puissance : 90, precision : 100");
        System.out.println("6-Manque de FPS: Endort J2 \n cout : 40, puissance : -, precision : 100");
        System.out.println("7-Chatte a Mireille: Attaque moyenne avec 50% chance d'annuler le cout mana \n cout : 80, puissance : 70 , precision : 90");
        System.out.println("8-Image remanante: Attaque magique moderee, 50% de chance de recuperer moitie des degats infliges en HP \n cout : 80, puissance : 70 , precision : 90");
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
    public boolean attaque5(Personnage J2){ // degats + chance baisse def spe
        
        boolean att = false;
        
        if( this.mana >= 50){
			
			int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.magie*90)/(50*J2.resistanceMagique*100));
				if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
				int baisse = (int)(Math.random()*100);
					if (baisse<=10) {
					J2.resistanceMagique = (int)(J2.resistanceMagique*0.9);
					System.out.println(J2.nom+" a pris peur lors de l'attaque et voit sa defense speciale diminuer de 10%");
					}
		
				}else{
                System.out.println("l'attaque est sans effet. L'ennemie e trop de defense !!");
				}
        
            
		
		this.mana  -= 50;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque6(Personnage J2){ // provoque dodo
		
        boolean att = false;
        if( this.mana >= 40){
            J2.dodo=3;
            System.out.println(this.nom+" endort "+J2.nom+". Celui-ci ne pourra pas attaquer tant qu'il ne sera pas reveille");
            this.mana -=40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
    }

      public boolean attaque7(Personnage J2){ // attaque moyenne avec 50% chance cout mana =0
        
       boolean att = false;
        
        if( this.mana >= 80){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>10){
			int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.magie*70)/(50*J2.resistanceMagique*100));
				if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque pmoderee. Il cause " +degat+ " degats a " + J2.nom );
				int cout = (int)(Math.random()*100);
					if (cout<=50) {
					
					System.out.println("L'attaque ne coute aucun mana");
					}
		
				}else{
					
                this.mana -=80;
				}
        
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
		}
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque8(Personnage J2){ //50% de chance de recup degats causes en PV
        
       boolean att = false;
        
        if( this.mana >= 80){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>10){
			int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.magie*70)/(50*J2.resistanceMagique*100));
				if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
				int recup = (int)(Math.random()*100);
					if (recup<=50) {
					this.vie +=(int)(degat/2);
					System.out.println(this.nom +" recupere "+ (int)(degat/2) +" HP");
					}
		
                }
        
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
		}
            this.mana -=80;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }

    
}
