package jeu;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Jeu extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 640;

    public static final int HEIGHT = WIDTH / 12 * 9;

    private Thread thread;

    private boolean running = false;


    private Random r;
    private Handler handler;

    public Jeu(){

        handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Bogoss", this);

        r = new Random();


        handler.addObjet(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
        handler.addObjet(new Enemy(WIDTH/2, HEIGHT/2, ID.Enemy));



    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
       try {
            thread.join();
            running = false;
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public void run() {
        // Initialise le temps actuel en nanosecondes
        long lastTime = System.nanoTime();

        // Nombre de mises à jour (ticks) par seconde
        double amountOfTicks = 60.0;

        // Nombre de nanosecondes par tick
        double ns = 1000000000 / amountOfTicks;

        // Delta pour suivre le temps écoulé entre les ticks
        double delta = 0;

        // Initialise le timer pour compter les FPS
        long timer = System.currentTimeMillis();

        // Compteur de frames rendues par seconde
        int frames = 0;

         // Boucle principale du jeu, s'exécute tant que 'running' est vrai
        while (running) {
            // Récupère le temps actuel en nanosecondes
            long now = System.nanoTime();

            // Ajoute le temps écoulé depuis le dernier cycle à delta
            delta += (now - lastTime) / ns;

            // Met à jour le temps du dernier cycle
            lastTime = now;

            // Met à jour le jeu (tick) si suffisamment de temps s'est écoulé
            while (delta >= 1) {
                tick(); // Méthode pour la logique de mise à jour du jeu
                delta--; // Décrémente delta pour chaque tick exécuté
            }

            // Rend l'image actuelle si 'running' est toujours vrai
            if (running) {
                render(); // Méthode pour le rendu graphique
            }

            // Incrémente le compteur de frames rendues
            frames++;

            // Si une seconde s'est écoulée
            if (System.currentTimeMillis() - timer > 1000) {
                // Ajoute une seconde au timer
                timer += 1000;

                // Affiche le nombre d'images par seconde (FPS)
               // System.out.println("FPS: " + frames);

                // Réinitialise le compteur de frames
                frames = 0;
            }
        }

        // Appelle la méthode pour arrêter le jeu
        stop();

    }

    private void tick() {
        handler.tick();

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Jeu();
    }

}
