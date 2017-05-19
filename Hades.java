import java.util.Scanner;

public class Hades extends Necromancien{
    
    public Hades(){
        
        super("Hades", 600, 100 , 50, 90, 180, 450, 20);     //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
          /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Persephone Gate   2-Malediction    3-Lance de macchabes   4- Caresse de la mort   5-Noces funebres     6-Passer son tour" );
        
        while(attok == false){ /**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = persephone(J2);
                break;
                case 2:
                    attok = malediction(J2);
                break;
                case 3:
                    attok = attaquePuissante(J2);
                break;
                case 4:
                    attok = attaqueRapide(J2);
                break;
                case 5:
                    attok = attaqueMagiePuissante(J2);
                break;
                case 6:
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
    public boolean persephone(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){ //condition de mana
            this.vie =(int) (this.vie* 0.9); //Enleve 10% de sa propre vie  
            J2.vie = (int)(J2.vie* 0.7); //Enleve 30% de la vie de J2
            this.defense = this.defense*1.2; //Augmente de 20% sa propre défense
            System.out.println(this.nom + " Persephone ouvre la porte des enfers !! " +this.nom + " perd 10% de vie mais " +J2.nom+ " en pert 30%");
            this.mana  = this.mana - 50; //cout en mana de l'attaque
            att =true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
    
   
}
