import java.util.Scanner;

public class LambdaRpg{
	
	public static void effaceEcran () {
		for(int i=0; i<23;i++) System.out.println();
		String ESC = "\033[";
		System.out.print(ESC+"0;0H");
		System.out.print(ESC+"0;0H");
		System.out.flush();
	
	}
    
    public static void main(String[] args){
        
        
        //debut de la partie
        
        Scanner sc = new Scanner(System.in);
        Personnage j1=null;
        Personnage j2=null;
        
        //initialisation joueur 1
       
        System.out.println("joueur 1 Choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier    3-Assassin");
        
        boolean saisie1 = false;
        boolean saisie2 = false;
        int personageJ1 = 0;
        
        while(saisie1 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ1 = sc.nextInt();
            
            if(classeJ1 == 1  ){
                saisie1 =true;
                System.out.println("choisi ton mage:");
                System.out.println("1-Melchior      2-Gaspard");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Melchior();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        j1 = new Gaspard();
                    }else{
                        saisie2 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
                    
                    
                
            }else if(classeJ1 == 2  ){
                
                saisie1 = true;
                System.out.println("choisi ton guerrier:");
                System.out.println("1-Kimjongun'      2-Achille");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Kimjongun();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        j1 = new Achille();
                    }else{
                        saisie2 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }
            else if(classeJ1 == 3  ){
                
                saisie1 = true;
                System.out.println("choisi ton Assasin:");
                System.out.println("1-Jack l'Eventreur      2-");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Jackeventreur();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        //j1 = new ();
                    }else{
                        saisie2 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else{
                saisie1 = false;
                System.out.println("Choix saisi incorrect. Rechoisi ta classe !!");
                
            }
            effaceEcran();
        }
        
        //initialisation joueur 2 même logique que pour le joueur 1
        
        System.out.println("joueur 2 Choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier      3-Assassin");
        
        boolean saisie3 = false;
        boolean saisie4 = false;
        int personageJ2 = 0;
        
        while(saisie3 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ2 = sc.nextInt();
            
            if(classeJ2 == 1  ){
                saisie3 =true;
                System.out.println("choisi ton mage:");
                System.out.println("1-Melchior      2-Gaspard");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Melchior();
                    }else if(personageJ2 == 2  ){
                        saisie4 = true;
                        j2 = new Gaspard();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
                    
                    
                
            }else if(classeJ2 == 2  ){
                
                saisie3 = true;
                System.out.println("choisi ton guerrier:");
                System.out.println("1-Kimjongun'      2-Achille");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Kimjongun();
                    }else if(personageJ2 == 2  ){
                        saisie4 = true;
                        j2 = new Achille();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }
            else if(classeJ2 == 3  ){
                
                saisie1 = true;
                System.out.println("choisi ton Assasin:");
                System.out.println("1-Jack l'Eventreur      2-");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Jackeventreur();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        //j1 = new ();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else{
                saisie3 = false;
                System.out.println("Choix saisi incorrect. Rechoisi ta classe !!");
                
            }
        effaceEcran();
        }
        
        //récap des choix
        
        j1.statComplete();
        j2.statComplete();
        
        
    while( (j1.vie > 0) && (j2.vie > 0) ){
        
        System.out.println("");
        
        j1.attaquer(j2);
        
        if(j2.vie > 0){
            System.out.println("");
            j2.attaquer(j1);
        }
        
        j1.mana += j1.recuperation;
        j2.mana += j2.recuperation;
		
		effaceEcran();
        System.out.println("");
        j1.statComplete();
        j2.statComplete();
        
    }
    
    System.out.println("");
    
    if(j2.vie >= 0){
            System.out.println(j2.nom + " a vaincu " + j1.nom);
    }else if(j1.vie >= 0){
            System.out.println(j1.nom + " a vaincu " + j2.nom);
    }else{
            System.out.println("il y a un problem quelque part....");
    }
     
        
       
    

        
    }
    
    
}
