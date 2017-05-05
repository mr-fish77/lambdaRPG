import java.util.Scanner;

public class LambdaRpg{
    
    public static void main(String[] args){
        
        
        //debut de la partie
        
        Scanner sc = new Scanner(System.in);
        Personnage j1=null;
        Personnage j2=null;
        
        //initialisation joueur 1
       
        System.out.println("joueur 1 Choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier");
        
        boolean saisie1 = false;
        boolean saisie2 = false;
        int personageJ1 = 0;
        
        while(saisie1 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ1 = sc.nextInt();
            
            if(classeJ1 == 1  ){
                saisie1 =true;
                System.out.println("choisi ton mage:");
                System.out.println("1-Melichor      2-Gaspard");
                                
                while(saisie2 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ1 = sc.nextInt();
                    if(personageJ1 == 1  ){
                        saisie2 = true;
                        j1 = new Melichor();
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
                
            }else{
                saisie1 = false;
                System.out.println("Choix saisi incorrect. Rechoisi ta classe !!");
                
            }
        }
        
        //initialisation joueur 2 même logique que pour le joueur 1
        
        System.out.println("joueur 2 Choisis ta classe:");
        System.out.println("1-Mage      2-Guerrier");
        
        boolean saisie3 = false;
        boolean saisie4 = false;
        int personageJ2 = 0;
        
        while(saisie3 == false){ //attend une entrée valide pour le choix de la classe
            int classeJ2 = sc.nextInt();
            
            if(classeJ2 == 1  ){
                saisie3 =true;
                System.out.println("choisi ton mage:");
                System.out.println("1-Melichor      2-Gaspard");
                                
                while(saisie4 == false){ //attend une entrée valide pour le choix du personnage
                    
                    personageJ2 = sc.nextInt();
                    if(personageJ2 == 1  ){
                        saisie4 = true;
                        j2 = new Melichor();
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
                
            }else{
                saisie3 = false;
                System.out.println("Choix saisi incorrect. Rechoisi ta classe !!");
                
            }
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
