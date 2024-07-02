package jeu;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<ObjetJeu> objets = new LinkedList<>();

    public void tick(){
        for(int i = 0; i < objets.size(); i++){
            ObjetJeu obj = objets.get(i);

            obj.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < objets.size(); i++){
            ObjetJeu obj = objets.get(i);

            obj.render(g);
        }

    }

    public void addObjet(ObjetJeu obj){
        this.objets.add(obj);
    }

    public void removeObjet(ObjetJeu obj){
        this.objets.remove(obj);
    }
}
