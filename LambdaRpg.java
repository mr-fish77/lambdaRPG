/**
	 <h1>Lambda RPG</h1>
	* Jeu réalisé dans le cadre des projets d'informatique en première année à l'INSA de Lyon
	* Le jeu est un tour pas tour dans lequel deux joueurs s'affrontent sur le meme terminal
	* Les joueurs commencent par choisir leur classe puis leur personnage parmis ceux disponiblent
	* Une fois les joeurs prêts, ils choisissent chacun leur tour leurs attaques, celle-ci ont différentes caractéristiques ce qui permet d'ajouter de la stratégie
	* Evidemment, lorsque les HP d'un des deux joueurs tombent à zéro, le jeu s'arrête et l'autre joueur est déclarer vainqueur
	* @author  Vladimir Muhlstein, Adrien Stricher, Igor Falk, Mathieu Rocfort.
*/





import java.util.Scanner; // importe la classe Scanner du package java.util
import java.io.*; //importe l'ensemble du package java.io


public class LambdaRpg{
	
	/**
	 * Permet d'ajouter un labs de temps entre 2 executions
	*/
	public static void jouerSuite (){
		long t1 = System.currentTimeMillis(); //Recupere l'heure du systeme
		int i = 0;
		for(; i < 2000000000;i++) //boucle contenant un grand nombre de repetitions
		if((System.currentTimeMillis() - t1) > 3000) break; //Compare l'heure actuelle avec l'heure enregistree, lorsque la difference de temps est attente la boucle est cassee
		}
	/**
	*  Permet d'éfface l'invitée de commande sous Linux
	*/
     public static void effaceEcran () {   
		for(int i=0; i<100;i++) System.out.println();
		String ESC = "\033[";
		System.out.print(ESC+"0;0H");
		System.out.print(ESC+"0;0H");
		System.out.flush();
	
	}
    /**
     *  Permet d'afficher l'ecran de demarage du jeu
     *  Conseille au joueur de se mettre en plein écran
     */
    public static void intro () {
        
        System.out.println("Veuillez passer votre invite de commande en plein ecran pour une meilleur experience de jeu");
        System.out.println("");
        System.out.println("Appuyez sur espace puis entree pour commencer");
		Scanner sc = new Scanner(System.in); //attend que le joueur appuit sur une touche pour commencer
		String s = sc.nextLine();
	    	effaceEcran(),
		
	try{ //lit le fichier comptenant le logos du jeu
            InputStream flux=new FileInputStream("LambdAsciiGS.txt"); 
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
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
   * Methode principale du jeu
   * @param args inutilise.
   */
    
    public static void main(String[] args){
        
        //appelle de l'écran d'intro du jeu
        intro();
	//Ajoute un l'abs de temps en l'intro et le jeux
        jouerSuite();
        //efface l'ecran pour demarrer le jeux
        effaceEcran();
        
        
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
            int personageJ1 =0;
            if(classeJ1 == 1  ){ //le joueur 1 a chosit un mage
                saisie1 =true; // choix de classe valide
                System.out.println("Ton mage:");
                System.out.println("1-Melchior      2-Gaspard    3-Balthazar   4-Pikachu");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    personageJ1 = sc.nextInt(); // stocke le numéro correspondant à au personnage chosie par J1
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
                        saisie2 = false;  //entrée est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
                    
            }else if(classeJ1 == 2  ){ //le joueur 1 a chosit un guerrier
                saisie1 = true;  // choix de classe valide
                System.out.println("Choisis ton guerrier:");
                System.out.println("1-Kim jong un     2-Achille     3-Spartacus");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnag
                    personageJ1 = sc.nextInt(); // stocke le numéro correspondant a au personnage chosie par J1
                    if(personageJ1 == 1  ){
                        saisie2 = true;  //entree valide
                        j1 = new Kimjongun(); //l'ojet J1 correspond au guerrier Kimjongun
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;  //entree valide
                        j1 = new Achille();  //l'ojet J1 correspond au guerrier Achille
                    }else if(personageJ1 == 3  ){
                        saisie2 = true;  //entree valide
                        j1 = new Spartacus();  //l'ojet J1 correspond au guerrier Spartacus
                    }else{
                        saisie2 = false;  //entree est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ1 == 3  ){ //le joueur 1 a chosit un Assasin
                saisie1 = true; // choix de classe valide
                System.out.println("Choisis ton Assasin:");
                System.out.println("1-Jack l'Eventreur   2-Omar m'a tuer   3-Ezio Auditore da Firenze");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    personageJ1 = sc.nextInt();  // stocke le numéro correspondant au personnage chosie par J1
                    if(personageJ1 == 1  ){
                        saisie2 = true; //entree valide
                        j1 = new Jackeventreur(); //l'ojet J1 correspond à l'Assasin Jackeventreur
                    }else if(personageJ1 == 2  ){
                        saisie2 = true;//entree valide
                        j1 = new Omar();  //l'ojet J1 correspond à l'Assasin Omar
                     }else if(personageJ1 == 3  ){
                        saisie2 = true; //entree valide
                        j1 = new Ezio(); //l'ojet J1 correspond à l'Assasin Ezio
                    }else{ 
                        saisie2 = false;  //entree est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ1 == 4  ){ //le joueur 1 a chosit un Necromancien
                saisie1 = true;
                System.out.println("Choisis ton Necromancien");
                System.out.println("1-Isis      2-Hades   3-Sauron");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt(); // stocke le numéro correspondant au personnage chosie par J1
                    if(personageJ1 == 1  ){
                        saisie2 = true; //entree valide
                        j1 = new Isis(); //l'ojet J1 correspond au Necromancien Isis
                    }else if(personageJ1 == 2  ){
                        saisie2 = true; //entree valide
                        j1 = new Hades(); //l'ojet J1 correspond au Necromancien Hades
                    }else if(personageJ1 == 3  ){
                        saisie2 = true; //entree valide
                        j1 = new Sauron(); //l'ojet J1 correspond au Necromancien Sauron
                    }else{
                        saisie2 = false;  //entree est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else{
                saisie1 = false; //entree est invalide le jouer doix rechoisir une classe
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
        
        while(saisie3 == false){
            int classeJ2 = sc.nextInt();
            
            if(classeJ2 == 1  ){
                saisie3 =true;
                System.out.println("Choisis ton mage:");
                System.out.println("1-Melchior      2-Gaspard   3-Balthazar  4-Pikachu");
                                
                while(saisie4 == false){ 
                    
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
                                
                while(saisie4 == false){ 
                    
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
                                
                while(saisie4 == false){ 
                    
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
                                
                while(saisie4 == false){ 
                    
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
        
        //récap des choix effectués par les deux joueurs
        
        j1.statComplete();
        j2.statComplete();
        
        //début du combat
	    
    while( (j1.vie > 0) && (j2.vie > 0) ){ //Le combat dure jusqu'à ce qu'un personnage n'ai plus de vie
        
        for(int i=0;i<5;i++)System.out.println(""); //saut de lignes
        
        j1.attaquer(j2); // le J1 attaque J2
        
        if(j2.vie > 0){ //Si J2 à encore de la vie il attaque J1
            System.out.println("");
            j2.attaquer(j1); // J2 attaque J1
        }
        
        j1.mana += j1.recuperation; //les personnage régénèrent leur mana.
        j2.mana += j2.recuperation;
		
	jouerSuite(); //pause
	effaceEcran();//mise à jour de l'affichage
        
        j1.statComplete();//affiche les stats des personnages
        j2.statComplete();
        
    }
    
    System.out.println("");
    //affiche le vainqueur 
    if(j2.vie >= 0){
            System.out.println(j2.nom + " a vaincu " + j1.nom);
    }else if(j1.vie >= 0){
            System.out.println(j1.nom + " a vaincu " + j2.nom);
    }else{//si jamais ça plante 
            System.out.println("il y a un problem quelque part....");
    }
     
        
       
    

        
    }
    
    
}
