package jeu;

import java.awt.*;
import java.util.Random;

public class Enemy extends  ObjetJeu{

    private Handler handler;

    Random r = new Random();

    public Enemy(int x, int y, ID id, Handler handler){
        super( x,  y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y > Jeu.HEIGHT - 32) velY *= -1;
        if(x <= 0 || x > Jeu.WIDTH - 16) velX *= -1;

        handler.addObjet(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.03F, handler));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 16, 16);

    }

    public Random getR() {
        return r;
    }
}
