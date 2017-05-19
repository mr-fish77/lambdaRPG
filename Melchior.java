import java.util.Scanner;
public class Melchior extends Mage{

    public Melchior(){
        
        super("Melchior", 500, 100 , 50, 100, 200, 400, 20); //nom, vie, mana, defense, force, vitesse, magie, recupération
    }
      /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
    public void  attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Or       2-La Main De Midas     3-Yami no mahO    4- Flammeche    5-Passer son tour" );
        
        while(attok == false){ /**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = or();
                break;
                case 2:
                    attok = laMainDeMidas();
                break;
                case 3:
                    attok = attaqueRapide(J2);
                break;
                case 4:
                    attok = attaqueMagiePuissante(J2);
                break;
                case 5:
                    System.out.println(this.nom +  " passe son tour !");
                    attok = true;
                break;
                default:
                    attok = false;
                    System.out.println("attaque saisie incorrect. Rechoisi ton attaque !! ");
                break;
            }
        }
        

        
    }
     /**
    *Cette methode decrit l'attaque speciale du personnage. 
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean or(){
        boolean att = false;
        
        if( this.mana >= 50){ //condtion de mana
            this.magie += 50; //augmente la magie du personnage
            System.out.println(this.nom + " utilise une amulette qui augmente sa magie de 50 " );
            this.mana -=50; //cout en mana
            att = true; //modifie l'etat d'attaque et sors de la boucle du choix d'attaque
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            
        }

        
        return att;
    }
    
  
     
}
