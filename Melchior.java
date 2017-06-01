import java.util.Scanner;
public class Melchior extends Mage{

    public Melchior(){
        
        super("Melchior", 688, 100, 289, 209, 268, 317, 20, 319, 0, 0, 0, 0); //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
      /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
    public void  attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-");  
        System.out.println("2-");
        System.out.println("3-");
        System.out.println("4-");
        System.out.println("5- Attaque magique puissante");
        System.out.println("6- Attaque faible mais qui paralyse l'ennemie");
        System.out.println("7- Endort J2");
        System.out.println("8- Attaque puissante, si J2 dort, les degats sont multiplies par 2 et J2 se reveil");
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
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean attaque5(Personnage J2){ //attaque magique puissante
         boolean att = false;
        
        if( this.mana >= 80){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>30){
			int aleat = (int)(Math.random()*10+90); // coefficient valeur attaque
            int degat = (int)(aleat*(42*this.magie*150)/(50*J2.resistanceMagique));
				if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
				
		
				}else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
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
    
     public boolean attaque6(Personnage J2){ //attaque faible + paralysie 
        
        boolean att = false;
        if( this.mana >= 40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*30)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom +" et le paralyse");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais il est paralyse");
            }
            this.mana  -= 40;
            J2.paralysie=4;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
    public boolean attaque7(Personnage J2){ // endort J2
		
        boolean att = false;
        if( this.mana >= 40){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>40){
            J2.dodo=3;
            System.out.println(this.nom+" endort l'ennemie ");
            }else{
			System.out.println(J2.nom +" esquive l'attaque");
			}
            this.mana -=40;
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
    }
    
   public boolean attaque8(Personnage J2){ //Attaque puissnate, si j2 dort, degat *2 + le reveil
         boolean att = false;
        
        if( this.mana >= 60){
			int aleat = (int)(Math.random()*10+90); // coefficient valeur attaque
            int degat = (int)(aleat*(42*this.magie*100)/(50*J2.resistanceMagique));
				if(degat >= 0){
					if (J2.dodo>0){
                J2.vie -= 2*degat;
                J2.dodo=0;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom+" et le reveil" );
			}else{
				J2.vie -= degat;
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom);
			}
				
		
				}else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
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
     
}
