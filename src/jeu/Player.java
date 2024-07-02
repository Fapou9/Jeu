package jeu;

import java.awt.*;
import java.util.Random;

public class Player extends  ObjetJeu{

    Random r = new Random();

    public Player(int x, int y, ID id){
        super( x,  y, id);




    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Jeu.clamp(x, 0, Jeu.WIDTH - 37);
        y = Jeu.clamp(y, 0, Jeu.HEIGHT - 60);

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
