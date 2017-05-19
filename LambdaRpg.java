/*
* <h1>Lambda RPG</h1>
* Jeu réalisé dans le cadre des projets d'informatique en première année à l'INSA de Lyon
* <p>
*
* @author  Vladimir Muhlstein, Adiren Stricher, Igor Falk, Mathieu Rocfort.
*/





import java.util.Scanner; // importe la classe Scanner du package java.util
import java.io.*; //importe l'ensemble du package java.io


public class LambdaRpg{
      /*
      *  Permet d'éfface l'invitée de commande sous Linux
      */
     public static void effaceEcran () {   
		for(int i=0; i<50;i++) System.out.println();
		String ESC = "\033[";
		System.out.print(ESC+"0;0H");
		System.out.print(ESC+"0;0H");
		System.out.flush();
	
	}
    /*
     *  Permet d'afficher l'écran de démarage du jeu
     *  Conseille au joueur de se mettre en plein écran
     */
    public static void intro () {
        
        System.out.println("Veuillez passer votre invite de commande en plein ecran pour une meilleur experience de jeu");
        System.out.println("");
        System.out.println("Appuyez sur espace puis entree pour commencer");
		Scanner sc = new Scanner(System.in); //attend que le joueur appuit sur une touche pour commencer
		String s = sc.nextLine();
		
	try{ //lit le fichier comptenant le logos du jeu
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
     
   /**
   * Méthode principale du jeu
   * @param args inutilisé.
   */
    
    public static void main(String[] args){
        
        //appelle de l'écran d'intro du jeu
        intro();
        
        
        Scanner sc = new Scanner(System.in); 
        Personnage j1=null; //création d'un ojet nul de type personnage pour le joueur 1  
        Personnage j2=null;  //création d'un ojet nul de type personnage pour le joueur 2
        
        //initialisation joueur 1
       
        System.out.println("Joueur 1 choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier    3-Assassin    4-Necromancien");
        
        boolean saisie1 = false; //variable utilisée pour s'assurer que le joueur entre un choix de classe valide
        boolean saisie2 = false; //variable utilisée pour s'assurer que le joueur entre un choix de personnage valide
        
        while(saisie1 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ1 = sc.nextInt(); // stocke le numéro correspondant à la classe chosie par J1
        
            if(classeJ1 == 1  ){ //le joueur 1 a chosit un mage
                saisie1 =true; // choix de classe valide
                System.out.println("Ton mage:");
                System.out.println("1-Melchior      2-Gaspard    3-Balthazar   4-Pikachu");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                     int personageJ1 = sc.nextInt(); // stocke le numéro correspondant à au personnage chosie par J1
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Melchior();  //l'ojet J1 correspond à Melchior
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;  
                        j1 = new Gaspard(); //l'ojet J1 correspond à Gaspard
                    }else if(personageJ1 == 3  ){
                        saisie2 = true;  
                        j1 = new Balthazar();   //l'ojet J1 correspond à Balthazar    
                    }else if(personageJ1 == 4  ){
                        saisie2 = true;  
                        j1 = new Pikachu();  //l'ojet J1 correspond à Pikachu
                    }else{
                        saisie2 = false;  //entrée est invalide le jouer doix rechoisir un personnage
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
                System.out.println("Choisis ton Assasin:");
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
                System.out.println("Choisis ton Necromancien");
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
