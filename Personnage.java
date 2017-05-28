public class Personnage{
    
    String nom;
    int vie;
    int mana;
    int defensePhysique;
    int force;
    int vitesse;
    int magie;
    int recuperation;
    int resistanceMagique;
    int poison;
    int brulure;
    int dodo;
    int paralysie;
    
    
    public Personnage(String n, int v, int MP, int d, int f, int s, int m, int r, int RM, int poi, int br, int dd, int pr)
    {
        nom = n;
        mana = MP;
        vie = v;
        defensePhysique = d;
        force = f;
        vitesse =s;
        magie =m;
        recuperation =r;
        resistanceMagique = RM;
        poison = poi;
        brulure=br;
        dodo = dd;
        paralysie=pr;
    }
    
    public void statComplete(){
        
        System.out.println("");
        System.out.println(" nom: " + this.nom + " - vie: " + this.vie + " - mana: " + this.mana + "-resistance magique: "+ this.resistanceMagique);
        System.out.println(" defense physique: " + this.defensePhysique + " - vitesse: " + this.vitesse+ " - force: " + this.force + " - magie: " + this.magie);
    }
    
    public void stat(){
        
        System.out.println("");
        System.out.println(" nom: " + this.nom + " - vie: " + this.vie + " - mana: " + this.mana);
    }
    
    public  void  attaquer(Personnage J2){
        System.out.println("ne dois jamais etre appelé");

    }
    
    
    
}
    
    
    
