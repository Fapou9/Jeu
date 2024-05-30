package jeu;

import java.awt.*;
import java.util.Random;

public class Enemy extends  ObjetJeu{

    Random r = new Random();

    public Enemy(int x, int y, ID id){
        super( x,  y, id);




    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, 32, 32);

    }

    public Random getR() {
        return r;
    }
}
