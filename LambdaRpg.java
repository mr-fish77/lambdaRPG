import java.util.Scanner;
import java.io.*;


public class LambdaRpg{
	
	public static void effaceEcran () {
		for(int i=0; i<25;i++) System.out.println();
		String ESC = "\033[";
		System.out.print(ESC+"0;0H");
		System.out.print(ESC+"0;0H");
		System.out.flush();
	
	}
    
    public static void intro () {
        
        System.out.println("Veuillez passer votre invite de commande en plein ecran pour une meilleur experience de jeu");
        System.out.println("");
        System.out.println("Appuyez sur espace puis entree pour commencer");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		try{
            InputStream flux=new FileInputStream("LambdAsciiGS.txt"); 
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            while ((ligne=buff.readLine())!=null){
                System.out.println(ligne);
            }
            buff.close(); 
        }		
        catch (Exception e){
            System.out.println(e.toString());
        }
	}
    
    
    public static void main(String[] args){
        
        
        intro();
        //debut de la partie
        
        Scanner sc = new Scanner(System.in);
        Personnage j1=null;
        Personnage j2=null;
        
        //initialisation joueur 1
       
        System.out.println("Joueur 1 choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier    3-Assassin    4-Necromancien");
        
        boolean saisie1 = false;
        boolean saisie2 = false;
        int personageJ1 = 0;
        
        while(saisie1 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ1 = sc.nextInt();
            
            if(classeJ1 == 1  ){
                saisie1 =true;
                System.out.println("Ton mage:");
                System.out.println("1-Melchior      2-Gaspard    3-Balthazar   4-Pikachu");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Melchior();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        j1 = new Gaspard();
                    }else if(personageJ1 == 3  ){
                        saisie2 = true;
                        j1 = new Balthazar();    
                    }else if(personageJ1 == 4  ){
                        saisie2 = true;
                        j1 = new Pikachu(); 
                    }else{
                        saisie2 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
                    
                    
               
            }else if(classeJ1 == 2  ){
                
                saisie1 = true;
                System.out.println("Choisis ton guerrier:");
                System.out.println("1-Kim jong un     2-Achille     3-Spartacus");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Kimjongun();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        j1 = new Achille();
                    }else if(personageJ1 == 3  ){
                        saisie2 = true;
                        j1 = new Spartacus();
                    }else{
                        saisie2 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ1 == 3  ){
                
                saisie1 = true;
                System.out.println("Choisis ton Assasin:");
                System.out.println("1-Jack l'Eventreur   2-Omar m'a tuer   3-Ezio Auditore da Firenze");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Jackeventreur();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        j1 = new Omar();
                     }else if(personageJ1 == 3  ){
                        saisie2 = true;
                        j1 = new Ezio();
                    }else{
                        saisie2 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ1 == 4  ){
                
                saisie1 = true;
                System.out.println("Choisis ton Necromancien");
                System.out.println("1-Isis      2-Hades   3-Sauron");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Isis();
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;
                        j1 = new Hades();
                    }else if(personageJ1 == 3  ){
                        saisie2 = true;
                        j1 = new Sauron();
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
        
        System.out.println("Joueur 2 choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier      3-Assassin    4-Necromancien");
        
        boolean saisie3 = false;
        boolean saisie4 = false;
        int personageJ2 = 0;
        
        while(saisie3 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ2 = sc.nextInt();
            
            if(classeJ2 == 1  ){
                saisie3 =true;
                System.out.println("Choisis ton mage:");
                System.out.println("1-Melchior      2-Gaspard   3-Balthazar  4-Pikachu");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Melchior();
                    }else if(personageJ2 == 2  ){
                        saisie4 = true;
                        j2 = new Gaspard();
                    }else if(personageJ2 == 3  ){
                        saisie4 = true;
                        j2 = new Balthazar();    
                    }else if(personageJ2 == 4  ){
                        saisie4 = true;
                        j2 = new Pikachu(); 
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
                    
                    
                
            }else if(classeJ2 == 2  ){
                
                saisie3 = true;
                System.out.println("Choisis ton guerrier:");
                System.out.println("1-Kim jong un   2-Achille   3-Spartacus");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Kimjongun();
                    }else if(personageJ2 == 2  ){
                        saisie4 = true;
                        j2 = new Achille();
                    }else if(personageJ2 == 3  ){
                        saisie4 = true;
                        j2 = new Spartacus();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }
            else if(classeJ2 == 3  ){
                
                saisie3 = true;
                System.out.println("choisi ton Assasin:");
                System.out.println("1-Jack l'Eventreur   2-Omar m'a tuer   3-Ezio Auditore da Firenze");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Jackeventreur();
                    }else if(personageJ2 == 2  ){
                        saisie4 = true;
                        j2 = new Omar();
                    }else if(personageJ2 == 3  ){
                        saisie4 = true;
                        j2 = new Ezio();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ2 == 4  ){
                
                saisie3 = true;
                System.out.println("choisi ton Necromancien");
                System.out.println("1-Isis     2-Hades       3-Sauron");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Isis();
                    }else if(personageJ2 == 2  ){
                        saisie4 = true;
                        j2 = new Hades();
                    }else if(personageJ2 == 3  ){
                        saisie4 = true;
                        j2 = new Sauron();
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
        
        for(int i=0;i<5;i++)System.out.println("");
        
        j1.attaquer(j2);
        
        if(j2.vie > 0){
            System.out.println("");
            j2.attaquer(j1);
        }
        
        j1.mana += j1.recuperation;
        j2.mana += j2.recuperation;
		
		effaceEcran();
        
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
