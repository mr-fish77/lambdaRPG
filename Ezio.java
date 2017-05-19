import java.util.Scanner;

public class Ezio extends Assassin{
    int poison; //variable de stockage du nombre de tour d'empoisonnement
    
    public Ezio(){
        
        super("Ezio Auditore da Firenze", 280, 100 , 650, 110, 230, 0, 20);     //nom, vie, mana, defense, force, vitesse, magie, recupération
        int poison =0;
    }
     /** 
     *La methode attaquer permet au joueur de selectionner son attaque.
     *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
     */
     public void attaquer(Personnage J2){
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);
        //Boucle d'empoisonnement
        if(poison != 0){ //condition d'empoisonnement
            J2.vie = J2.vie - 50; //inflige les dégats de l'attaque
            System.out.println(J2.nom + " est empoisonne, il subit 50 degats !! ");
            System.out.println("");
            poison --; //décrémente le nombre de tour d'empoisonnement
        }

        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1-Lames secretes    2-Aconite     3-Burqa    4- Dague vengeresse   5-Execution     6-Passer son tour" );
        
        while(attok == false){/**Attend que le joueur fasse un choix d'attaque valide (= choisir une attaque + mana suffisant)
                                  Attribut chaque attaque a un nombre*/
            int choixAttaque = sc.nextInt();
            
            switch (choixAttaque){
                case 1:
                    attok = lamesecrete(J2);
                break;
                case 2:
                    attok = aconite(J2);
                break;
                case 3:
                    attok = augmentationDefense();
                break;
                case 4:
                    attok = attaqueRapide(J2);
                break;
                case 5:
                    attok = attaquePuissante(J2);
                break;
                case 6:
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
    *@param Personnage J2 prend en parametre le joueur 2 qui est le joueur a attaquer.
    *@return att modifie l'etat attaque du joueur pour poursuivre le combat.
    */
    public boolean lamesecrete(Personnage J2){
        boolean att = false;
        
        if( this.mana >= 50){  //condition de mana
            
            int degat = 250;
            J2.vie = J2.vie - degat; //inflige les degats à J2
            System.out.println(this.nom + " attaque avec des lames cachees dans ses gantelets situes sur ses avant-bras. Il fait " + degat + " degats a " + J2.nom);
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
