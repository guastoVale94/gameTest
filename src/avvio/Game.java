package avvio;

import design.PauseMenu;
import entita.KeyManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import stati.GameSaved;
import stati.GameState;
import stati.MenuState;
import stati.State;
import world.Assets;
import world.Display;
import world.World;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    protected boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private GameState gameState;
    //private State menuState;
    //Input
    private KeyManager keyManager;
    private GameCamera gameCamera;
    private Handler handler;

    public static int sin_level = 1;
    public static int hearts = 10;
    protected boolean pause;
    public GameSaved gameStateDue;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

        keyManager = new KeyManager();
    }

    private void init() throws IOException {

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        // menu di pausa durante il gioco
        // menuState = new MenuState(this);

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        gameState = new GameState(handler);
        gameStateDue = new GameSaved(handler); //tengo per salvare i dati
        State.setState(gameState);
        pause = false;

    }
    // fai tick dello stato corrente

    private void tick() {
        keyManager.tick();

        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() throws IOException {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!

        BufferedImage image1 = ImageIO.read(new File("./src/se_mainwindow/sin_bar2/0/sin_bar2.0_" + sin_level + ".png"));
        g.drawImage(image1, 20, 0, null);
        
        if (hearts > 0) {
            BufferedImage image2 = ImageIO.read(new File("./src/se_mainwindow/hearts_bar2/0/hearts_bar2.0_" + hearts + ".png"));
            g.drawImage(image2, 450, 0, null);
        }

        if (State.getState() != null) {
            State.getState().render(g);
        }

        //End Drawing!
        bs.show();
        g.dispose();
    }

    public void run() {

        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                try {
                    render();
                    pause();
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void pause() {

        if (pause) {

            //System.out.println("invoco pause");   
            State.setState(new MenuState(handler));

        }

    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public World getWorld() {
        return gameState.getWorld();
    }

    protected void setRunning(boolean running) {
        this.running = running;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setRunning() {
        running = true;
    }

    public void setPause(boolean b) {
        pause = b;
    }

}
