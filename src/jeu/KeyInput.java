package jeu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.objets.size(); i++){
            ObjetJeu tempObject = handler.objets.get(i);

            if(tempObject.getId() == ID.Player){
                //KeyEvent pour joueur 1

                if(key == KeyEvent.VK_Z) tempObject.setVelY(-2);
                if(key == KeyEvent.VK_S) tempObject.setVelY(2);
                if(key == KeyEvent.VK_D) tempObject.setVelX(2);
                if(key == KeyEvent.VK_Q) tempObject.setVelX(-2);

            }
            if(tempObject.getId() == ID.Enemy){
                //key events pour ennemie
                if(key == KeyEvent.VK_UP) tempObject.setVelY(-2);
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(2);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(2);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-2);
            }
        }

        if(key == KeyEvent.VK_ESCAPE) System.exit(1);

        System.out.println(key);

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.objets.size(); i++){
            ObjetJeu tempObject = handler.objets.get(i);

            if(tempObject.getId() == ID.Player){
                //KeyEvent pour joueur 1

                if(key == KeyEvent.VK_Z) tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) tempObject.setVelY(0);
                if(key == KeyEvent.VK_D) tempObject.setVelX(0);
                if(key == KeyEvent.VK_Q) tempObject.setVelX(0);

            }
            if(tempObject.getId() == ID.Enemy){
                //key events pour ennemie
                if(key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }
        }

        System.out.println(key);
    }
}
