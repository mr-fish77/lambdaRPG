import java.util.Scanner;

public class Isis extends Necromancien{
    
    public Isis(){
        
        super("Isis", 990,100,223,293,268,299,20,261,0,0,0,0);    //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
    }
          /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

         System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-");  
        System.out.println("2-");
        System.out.println("3-");
        System.out.println("4-");
        System.out.println("5-");
        System.out.println("6- Attaque faible mais qui paralyse l'ennemie");
        System.out.println("7- Cancer : Provoque brulure, poison et paralysie");
        System.out.println("8- Haleine fetide : J1 endort J2");
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
    public boolean attaque5(Personnage J2){ //vole de 10% de HP
        boolean att = false;
        
        if( this.mana >= 60){ //condition de mana
            
            int degat = (int)(0.1*J2.vie);
            J2.vie -= degat; //inflige les dégats de l'attaque
            this.vie += degat; // J1 recupere les degats 
            System.out.println(this.nom +" vole 10% des HP de "+ J2.nom);
            this.mana  -=60; //cout en mana de l'attaque 
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
    public boolean attaque6(Personnage J2){ //attaque faible +paralysie
        
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
    
    public boolean attaque7(Personnage J2){ //cancer, brulure + poison + paralysie
        
        boolean att = false;
        if( this.mana >= 80){
            J2.brulure=3;
            J2.poison=3;
            J2.paralysie=4;
            System.out.println(this.nom+" consomme son energie et cree une vague de magie noire qui brule, empoisonne et paralyse "+J2.nom);
            this.mana  -= 80;
            
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }

        
        return att;
        
    }
    
     public boolean attaque8(Personnage J2){ // provoque dodo
		
        boolean att = false;
        if( this.mana >= 40){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>40){
            J2.dodo=3;
            System.out.println(this.nom+" souffle son haleine au visage de "+J2.nom+", il s'endort sous le choc");
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

    
}
