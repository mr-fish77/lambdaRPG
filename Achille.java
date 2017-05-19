import java.util.Scanner;

public class Achille extends Guerrier{

    public Achille(){
        
        super("Achille", 250, 100 , 350, 230, 110, 0, 20); //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
      /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){ 
        Scanner sc = new Scanner(System.in);
        boolean attok = false;
        
        System.out.println(this.nom + " Attaque. Choisi ton attaque :"); 
        System.out.println("1-Talonnette     2-Boularmure     3-Tibo Yinshape    4- Pichenette   5-This is sparta   6-Passer son tour" );
        
        while(attok == false){ /**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){ 
                case 1:
                    attok = talonnette(J2);
                break;
                case 2:
                    attok = augmentationForce();
                break;
                case 3:
                    attok = augmentationDefense();
                break;
                case 4:
                    attok = attaqueRapide(J2);
                break;
                case 5:
                    attok = attaquePhysiquePuissante(J2); 
                break;
                case 6:
                    System.out.println(J2.nom +  " passe son tour !");
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
    public boolean talonnette(Personnage J2){ 
        boolean att = false;
        
        if( this.mana >= 50){ //condition de mana
            
             int degat = 250;
            J2.vie = J2.vie - degat; //inflige les degats à J2
            System.out.println(this.nom + " se propulse sur l'ennemi par la force se son talon !! La défense " + J2.nom + " est sans effet !! Il fait " + degat + " a "+ J2.nom);
            
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
