public class Personnage{
    
    String nom;
    int vie;
    int mana;
    int defense;
    int force;
    int vitesse;
    int magie;
    int recuperation;
    
    
    public Personnage(String n, int v, int MP, int d, int f, int s, int m, int r)
    {
        nom = n;
        mana = MP;
        vie = v;
        defense = d;
        force = f;
        vitesse =s;
        magie =m;
        recuperation =r;
        
    }
    
    public void statComplete(){
        
        System.out.println("");
        System.out.println(" nom: " + this.nom + " - vie: " + this.vie + " - mana: " + this.mana);
        System.out.println(" defense: " + this.defense + " - vitesse: " + this.vitesse+ " - force: " + this.force + " - magie: " + this.magie);
    }
    
    public void stat(){
        
        System.out.println("");
        System.out.println(" nom: " + this.nom + " - vie: " + this.vie + " - mana: " + this.mana);
    }
    
    public  void  attaquer(Personnage J2){
        System.out.println("ne dois jamais etre appelé");

    }
    
    
    
}
    
    
    
