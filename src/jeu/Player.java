package jeu;

import java.awt.*;
import java.util.Random;

public class Player extends  ObjetJeu{

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler){
        super( x,  y, id);
        this.handler = handler;




    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }


    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Jeu.clamp(x, 0, Jeu.WIDTH - 37);
        y = Jeu.clamp(y, 0, Jeu.HEIGHT - 60);

        handler.addObjet(new Trail(x, y, ID.Trail, Color.black, 32, 32, 0.06F, handler));

        collision();

    }

    private void collision(){
        for (int i = 0; i < handler.objets.size(); i++) {

            ObjetJeu tempObjet = handler.objets.get(i);

            if(tempObjet.getId() == ID.Enemy){
                if(getBounds().intersects(tempObjet.getBounds())) {
                    //code collision
                    HUD.HEALTH -= 2;
                }
            }
        }
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
