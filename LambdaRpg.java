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
	public static void jouerSuite (double arret){
		long t1 = System.currentTimeMillis(); //Recupere l'heure du systeme
		int i = 0;
		for(; i < 2000000000;i++) //boucle contenant un grand nombre de repetitions
		if((System.currentTimeMillis() - t1) > arret) break; //Compare l'heure actuelle avec l'heure enregistree, lorsque la difference de temps est attente la boucle est cassee
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
	 
	 public static void dialogueintro(){ // Methode de dialogue pour alleger choix des personnages
        System.out.println("1-Mage          : Personnages specialises en attaques magiques et defense speciale");
        System.out.println("2-Guerrier      : Personnages specialises en defense et attaque physique");
        System.out.println("3-Assassin      : Personnages specialises en vitesse et attaque physique");
        System.out.println("4-Necromancien  : Personnages specialises en defense speciale et attaque speciale");
}
	
	 public static void dialogueMage(){   // Methode de dialogue pour alleger choix des personnages
		for(int i=0;i<4;i++)System.out.println(""); //sauts de lignes
		System.out.println(" 1:     Melchior:           2:     Gaspard :           3:     Balthazar :         4:       Pikachu :");
		System.out.println(" 688 HP                     788 HP                     628 HP                     680 HP");
		System.out.println(" 289 defense physique       259 defense physique       189 defense physique       229 defense physique ");
		System.out.println(" 319 defense magique        319 defense magique        289 defense magique        329 defense magique ");
		System.out.println(" 209 puissance physique     249 puissance physique     199 puissance physique     229 puissance physique");
		System.out.println(" 317 puissance magique      328 puissance magique      369 puissance magique      405 puissance magique ");
		System.out.println(" 268 vitesse                260 vitesse                292 vitesse                272 vitesse");
	}
	 
	 public static void dialogueGuerrier(){ // Methode de dialogue pour alleger choix des personnages
		for(int i=0;i<4;i++)System.out.println(""); //sauts de lignes
		System.out.println(" 1:    Kim Jong Un :        2:      Achille :          3:     Spartacus :         4:  Hadrien le Hun :");
		System.out.println(" 863 HP                     708 HP                     728 HP                     688 HP");
		System.out.println(" 359 defense physique       559 defense physique       359 defense physique       559 defense physique ");
		System.out.println(" 209 defense magique        259 defense magique        229 defense magique        259 defense magique ");
		System.out.println(" 379 puissance physique     379 puissance physique     339 puissance physique     379 puissance physique");
		System.out.println(" 209 puissance magique      219 puissance magique      209 puissance magique      219 puissance magique ");
		System.out.println(" 259 vitesse                256	 vitesse               262 vitesse                264 vitesse");
	}
	 
	 public static void dialogueAssassin(){  // Methode de dialogue pour alleger choix des personnages
		for(int i=0;i<4;i++)System.out.println(""); //sauts de lignes
		System.out.println(" 1:Jack l'Eventreur :       2:Omar m'a tuer :          3:Ezio Auditore da Firenze :   4:Donatello :");
		System.out.println(" 668 HP                     688 HP                     648 HP                         680 HP");
		System.out.println(" 299 defense physique       299 defense physique       259 defense physique           229 defense physique ");
		System.out.println(" 239 defense magique        259 defense magique        219 defense magique            329 defense magique ");
		System.out.println(" 383 puissance physique     394 puissance physique     395 puissance physique         383 puissance physique");
		System.out.println(" 219 puissance magique      209 puissance magique      219 puissance magique          229 puissance magique ");
		System.out.println(" 284 vitesse                280 vitesse                284 vitesse                    286 vitesse");
	
	}
	 
	 public static void dialogueNecromancien(){
		for(int i=0;i<4;i++)System.out.println(""); //sauts de lignes
		System.out.println(" 1:Isis :                   2:Hades :                   3:Sauron :                  4:Loki :");
		System.out.println(" 990 HP                     1000 HP                     1196 HP                     990 HP");
		System.out.println(" 223 defense physique       259  defense physique       189  defense physique       243 defense physique ");
		System.out.println(" 261 defense magique        289  defense magique        189  defense magique        283 defense magique ");
		System.out.println(" 293 puissance physique     269  puissance physique     279  puissance physique     253 puissance physique");
		System.out.println(" 299 puissance magique      269  puissance magique      279  puissance magique      297 puissance magique ");
		System.out.println(" 268 vitesse                264  vitesse                264  vitesse                262 vitesse");
	}
		
	 public static void texteLent(String texte, int vitesse) {  //Permet de faire passer un texte lettre par lettre plus lentement 
		 for (int i=0;i<texte.length();i++){
			 char c= texte.charAt(i);
			 System.out.print(c);
			 jouerSuite(vitesse);
		 }
		 System.out.println("");
	 }
    /**
     *  Permet d'afficher l'écran de démarage du jeu
     *  Conseille au joueur de se mettre en plein écran
     */
    public static void intro () {
        
        texteLent("Veuillez passer votre invite de commande en plein ecran pour une meilleur experience de jeu", 25);
        System.out.println("");
        texteLent("Appuyez sur espace puis entree pour commencer",25);
		Scanner sc = new Scanner(System.in); //attend que le joueur appuit sur une touche pour commencer
		String s = sc.nextLine();
	    	effaceEcran();
		
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
   * @param args inutilise.
   */
    
    public static void main(String[] args){
        
        //appelle de l'écran d'intro du jeu
        intro();
	//Ajoute un l'abs de temps en l'intro et le jeux
        jouerSuite(4000);
        //efface l'ecran pour demarrer le jeux
        effaceEcran();
        
        
        Scanner sc = new Scanner(System.in); 
        Personnage j1=null; //création d'un ojet nul de type personnage pour le joueur 1  
        Personnage j2=null;  //création d'un ojet nul de type personnage pour le joueur 2
        
        //initialisation joueur 1
       
        texteLent("Joueur 1 choisis ta classe:",25);
        jouerSuite(500);
        dialogueintro();
        
        boolean saisie1 = false; //variable utilisée pour s'assurer que le joueur entre un choix de classe valide
        boolean saisie2 = false; //variable utilisée pour s'assurer que le joueur entre un choix de personnage valide
        
        while(saisie1 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ1 = sc.nextInt(); // stocke le numéro correspondant à la classe chosie par J1
            int personageJ1 =0;
            if(classeJ1 == 1  ){ //le joueur 1 a chosit un mage
                saisie1 =true; // choix de classe valide
                dialogueMage();
                                
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
                dialogueGuerrier();
                                
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
                    }else if(personageJ1 == 4  ){
                        saisie2 = true;  //entree valide
                        j1 = new Hadrien();  //l'ojet J1 correspond au guerrier Hadrien Le Hun                   
                    }else{
                        saisie2 = false;  //entree est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ1 == 3  ){ //le joueur 1 a chosit un Assasin
                saisie1 = true; // choix de classe valide
              dialogueAssassin();
                
                                
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
                    }else if(personageJ1 == 4  ){
                        saisie2 = true; //entree valide
                        j1 = new Donatello(); //l'ojet J1 correspond à l'Assasin Donatello
                    }else{ 
                        saisie2 = false;  //entree est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ1 == 4  ){ //le joueur 1 a chosit un Necromancien
                saisie1 = true;
                dialogueNecromancien();
                                
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
                    }else if(personageJ1 == 4  ){
                        saisie2 = true; //entree valide
                        j1 = new Loki(); //l'ojet J1 correspond au Necromancien Loki
                    }else{
                        saisie2 = false;  //entree est invalide le joueur doix rechoisir un personnage
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else{
                saisie1 = false; //entree est invalide le jouer doix rechoisir une classe
                System.out.println("Choix saisi incorrect. Rechoisi ta classe !!");
                
            }
            jouerSuite(1500);
            effaceEcran();
        }
        
        //initialisation joueur 2 même logique que pour le joueur 1
        texteLent("Joueur 2 choisis ta classe :",25);
        jouerSuite(500);
        dialogueintro();
        
        boolean saisie3 = false;
        boolean saisie4 = false;
        int personageJ2 = 0;
        
        while(saisie3 == false){
            int classeJ2 = sc.nextInt();
            
            if(classeJ2 == 1  ){
                saisie3 =true;
                dialogueMage();
                                
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
                dialogueGuerrier();
                                
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
                    }else if(personageJ2 == 4  ){
                        saisie4 = true;
                        j2 = new Hadrien();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }
            else if(classeJ2 == 3  ){
                
                saisie3 = true;
                dialogueAssassin();
                                
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
                    }else if(personageJ2 == 4  ){
                        saisie4 = true;
                        j2 = new Donatello();
                    }else{
                        saisie4 = false;
                        System.out.println("Choix saisi incorrect. Rechoisi ton personnage !");
                    }
                }
            }else if(classeJ2 == 4  ){
                
                saisie3 = true;
                dialogueNecromancien();
                                
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
                    }else if(personageJ2 == 4 ){
                        saisie4 = true;
                        j2 = new Loki();
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
        
        //récap des choix effectué par les deux joueurs
        
        j1.statComplete();
        j2.statComplete();
        
        //début du combat
	    
    while( (j1.vie > 0) && (j2.vie > 0) ){ //Le combat dure jusqu'à ce qu'un personnage n'ai plus de vie
        
        for(int i=0;i<5;i++)System.out.println(""); //sauts de lignes
        if (j1.dodo==0){ // Verifie si J1 n'est pas endormi
			  
			int paralysiej1 =(int) Math.random()*100;
			switch(j1.paralysie){  // verifie l'etat de paralysie de j1
				
				case 0 :
				j1.attaquer(j2);
				break;
				
				case 1:
				System.out.println(j1.nom+" n'est plus paralyse et peut attaquer ");
				jouerSuite(1000);
				j1.attaquer(j2); // le J1 attaque J2
				break;
				
				case 2:
				if (paralysiej1<75){
					
					System.out.println(j1.nom + " ne souffre pas de sa paralysie et peut attaquer");
					jouerSuite(1000);
					j1.attaquer(j2);
				}else{
					System.out.println(j1.nom +" est paralyse et ne peut pas attaquer");
				}
				break;
				case 3:
				if (paralysiej1<50){
					System.out.println(j1.nom + " ne souffre pas de sa paralysie et peut attaquer");
					jouerSuite(1000);
					j1.attaquer(j2);
				}else{
					System.out.println(j1.nom +" est paralyse et ne peut pas attaquer");
				}
				break;
				case 4:
				if (paralysiej1<25){
					System.out.println(j1.nom + " ne souffre pas de sa paralysie et peut attaquer");
					jouerSuite(1000);
					j1.attaquer(j2);
				}else{
					System.out.println(j1.nom +" est paralyse et ne peut pas attaquer");
				}
				break;
			}
		
        
		
	}
        
        if(j2.vie > 0 || j2.dodo==0){ //Si J2 à encore de la vie et qu'il n'est pas endormi il attaque J1
            System.out.println("");
            
            int paralysiej2 =(int) Math.random()*100;
			switch(j2.paralysie){  // verifie l'etat de paralysie de j1
				
				case 0 :
				j2.attaquer(j1);
				break;
				
				case 1:
				System.out.println(j2.nom+" n'est plus paralyse et peut attaquer ");
				jouerSuite(1000);
				j2.attaquer(j1); // le J2 attaque J1
				break;
				
				case 2:
				if (paralysiej2<75){
					
					System.out.println(j2.nom + " ne souffre pas de sa paralysie et peut attaquer");
					jouerSuite(1000);
					j2.attaquer(j1);
				}else{
					System.out.println(j2.nom +" est paralyse et ne peut pas attaquer");
				}
				break;
				case 3:
				if (paralysiej2<50){
					System.out.println(j2.nom + " ne souffre pas de sa paralysie et peut attaquer");
					jouerSuite(1000);
					j2.attaquer(j1);
				}else{
					System.out.println(j2.nom +" est paralyse et ne peut pas attaquer");
				}
				break;
				case 4:
				if (paralysiej2<25){
					System.out.println(j2.nom + " ne souffre pas de sa paralysie et peut attaquer");
					jouerSuite(1000);
					j2.attaquer(j1);
				}else{
					System.out.println(j2.nom +" est paralyse et ne peut pas attaquer");
				}
				break;
			}
        }
        
        j1.mana += j1.recuperation; //les personnage régénèrent leur mana.
        j2.mana += j2.recuperation;
        
        //controle des etats et degats en consequence, plus diminution d'un tour
        
		if (j1.poison >0) {
			j1.vie = (int) (0.9*j1.vie);
			j1.poison --;
			System.out.println(j1.nom+" est empoisonné, il perd 10% de sa vie. Il est affecté pendant encore "+ j1.poison+" tours.");
		}
		if (j1.brulure >0) {
			j1.vie = (int) (j1.vie - 30);
			j1.brulure --;
			System.out.println(j1.nom +" souffre de ses brulures et perd 30 HP. Il est affecté pendant encore "+ j1.brulure+" tours.");
		}
		if (j1.dodo >0) { // Probabilité de reveil varie selon depuis combien de temps le joueur dort
			int reveilj1 =(int) Math.random()*100;
			switch(j1.dodo){
				case 1:
				j1.dodo=0;
				System.out.println(j1.nom + " s'est reveille et peut jouer au tour suivant !");
				break;
				case 2:
				if (reveilj1<75){
					j1.dodo=0;
					System.out.println(j1.nom + " s'est reveille et peut jouer au tour suivant !");
				}else{
					j1.dodo=1;
				}
				break;
				case 3:
				if (reveilj1<50){
					j1.dodo=0;
					System.out.println(j1.nom + " s'est reveille et peut jouer au tour suivant !");
				}else{
					j1.dodo=2;
				}
				break;
				case 4:
				if (reveilj1<25){
					j1.dodo=0;
					System.out.println(j1.nom + " s'est reveille et peut jouer au tour suivant !");
				}else{
					j1.dodo=3;
				}
				break;
			}
		}
		if (j1.paralysie>0){
				j1.paralysie --;
			}
		
		
		if (j2.poison >0) {
			j2.vie = (int) (0.9*j2.vie);
			j2.poison --;
			System.out.println(j2.nom+" est empoisonné, il perd 10% de sa vie. Il est affecté pendant encore "+ j2.poison+" tours.");
		}
		if (j2.brulure >0) {
			j2.vie = (int) (j2.vie - 30);
			j2.brulure --;
			System.out.println(j2.nom +" souffre de ses brulures et perd 30 HP. Il est affecté pendant encore "+ j2.brulure+" tours.");
		}
		if (j2.dodo >0) {
			int reveilj2 =(int) Math.random()*100;
			switch(j2.dodo){
				case 1:
				j2.dodo=0;
				System.out.println(j2.nom + " s'est reveille et peut jouer au tour suivant !");
				break;
				case 2:
				if (reveilj2<75){
					j2.dodo=0;
					System.out.println(j2.nom + " s'est reveille et peut jouer au tour suivant !");
				}else{
					j2.dodo=1;
				}
				break;
				case 3:
				if (reveilj2<50){
					j2.dodo=0;
					System.out.println(j2.nom + " s'est reveille et peut jouer au tour suivant !");
				}else{
					j2.dodo=2;
				}
				break;
				case 4:
				if (reveilj2<25){
					j1.dodo=0;
					System.out.println(j2.nom + " s'est reveille et peut jouer au tour suivant !");
				}else{
					j2.dodo=3;
				}
				break;
		}
		
		
	
        
    }
		if (j2.paralysie>0){
			j2.paralysie --;
		}
		jouerSuite(3000); //pause
	effaceEcran();//mise à jour de l'écran
        
        j1.statComplete();//affiche les stats des personnages
        j2.statComplete();
	}
    
    System.out.println("");
    //affiche le vainqueur 
    if(j2.vie >= 0){
            System.out.println(j2.nom + " a vaincu " + j1.nom);
    }else if(j1.vie >= 0){
            System.out.println(j1.nom + " a vaincu " + j2.nom);
    }else{ //si jamais ça plante 
            System.out.println("il y a un problem quelque part....");
    }
     
        
       
    


}
}


