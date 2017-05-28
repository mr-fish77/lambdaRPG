import java.util.Scanner;

public class Hadrien extends Guerrier{

    public Hadrien(){
        
        super("Hadrien le Hun",688,100,559,379,199,219,20,259,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération

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
        System.out.println("6-");
        System.out.println("7-");
        System.out.println("8-Passer son tour" );
        
        while(attok == false){ /**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = lanceMissile(J2);
                break;
                case 2:
                    attok = augmentationDefense();
                break;
                case 3:
                    attok = augmentationForce();
                break;
                case 4:
                    attok = attaqueRapide(J2);
                break;
                case 5:
                    attok = attaquePhysiquePuissante(J2);
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
    public boolean lanceMissile(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){ //condition de mana
            
            int degat = this.vitesse; //détermine les dégats comme égaux à la vitesse du joueur
            J2.vie = J2.vie - degat; //inflige les dégats de l'attaque
            System.out.println(this.nom + " lance ses missiles sur l'adversaire!! La defense de " + J2.nom + " est sans effet !!   Il fait " + degat + " degats a " + J2.nom);
            this.mana  = this.mana - 50; //cout en mana de l'attaque
            att =true;  //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false; //renvoie au choix de l'attaque
        }
        
        return att;
        
    }
}
