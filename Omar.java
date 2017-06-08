import java.util.Scanner;

public class Omar extends Assassin{
  
    
    public Omar(){
        
        super("Omar m'a tuer", 688,100,299,394,280,209,20,259,0,0,0,0);     //nom, vie, mana, defense, force, vitesse, magie, recupération, resistance magique, poison, brulure, sommeil, paralysie
       
    }
    
     public void attaquer(Personnage J2){
        
        
        boolean attok = false;
        Scanner sc = new Scanner(System.in);
        
        System.out.println(this.nom + " Attaque. Choisi ton attaque:");
        System.out.println("1- Feinte: Attaque physique faible qui diminue la defence de J2 \n cout : 30, puissance : 40, precision : 80");  
        System.out.println("2- Sournoiserie: Attaque physique puissante \n cout : 50, puissance : 90, precision : 100");
        System.out.println("3- Infiltration: Attaque magique puissante \n cout : 40, puissance : 80, precision : 100");
        System.out.println("4- Pulsions: Augmente la vitesse du joueur \n cout : 40, puissance : -, precision : 100");
        System.out.println("5- Cours de Maths : 50% de chance de causer 200 degats \n cout : 60, puissance : -, precision : 50");
        System.out.println("6- Sous la terrasse: Attaque puissante mais J1 subit aussi des degats \n cout : 80, puissance : 150, precision : -");
        System.out.println("7- Bescherelle: Attaque tres faible \n cout : 10, puissance : 10, precision : 100");
        System.out.println("8- Dictée: Attaque faible qui empoisonne l'ennemie \n cout : 40, puissance : 30, precision : 100");
        System.out.println("9- Passer son tour " );
        
        while(attok == false){
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
       
    public boolean attaque5(Personnage J2){ //50% de chance de causer 200 degats 
        boolean att = false;
        if( this.mana >= 60){
			int esquive=(int)((Math.random()*this.vitesse/J2.vitesse)*100);
			if(esquive>50){
            J2.vie-=200;  
            System.out.println(this.nom + " ecrit des equations avec son sang. " + J2.nom + " n'y comprend rien. Il se sent mal et subit 200 de degat");        
            }else{
			System.out.println(" Il ne se passe rien");
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
       
       
    
     public boolean attaque6(Personnage J2){ //attaque puissante, J1 subit 1/6 des degats 
        
        boolean att = false;
        if( this.mana >= 80){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*150)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                this.vie-=(int)(degat/6);
                System.out.println(this.nom + " fait une attaque puissante. Il cause " +degat+ " degats a " + J2.nom );
                System.out.println("En retour, il subit "+ (int)(degat/6)+" degats");
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
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
    
         public boolean attaque7(Personnage J2){ // attaque tres faible 
        
        boolean att = false;
        if( this.mana >= 10){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*10)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                
                System.out.println(this.nom + " fait une attaque rapide. Il cause " +degat+ " degats a " + J2.nom );
               
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !!");
            }
            this.mana  -= 10;
            
            att = true;
        }else{
            System.out.println(this.nom + " n'a pas assez de mana pour attaquer" );
            System.out.println("Rechoisi ton attaque !! ");
            att = false;
        }
        
        return att;
    }
    
    public boolean attaque8(Personnage J2){ //attaque faible qui empoisonne l'ennemie
        
        boolean att = false;
        if( this.mana >= 40){
            int aleat = (int)(Math.random()*10+90);
            int degat = (int)((aleat*42*this.force*30)/(50*J2.defensePhysique*100));
            if(degat >= 0){
                J2.vie -= degat;
                
                System.out.println(this.nom + " noie "+J2.nom+" dans un la mer noire, le forte teneur en sel de l'eau empoisonne "+J2.nom);
               
            }else{
                System.out.println("l'attaque est sans effet. L'ennemie a trop de defense !! Mais la noyade l'empoisonne car l'eau n'etait pas tres nette");
            }
            J2.poison=4;
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
