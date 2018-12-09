package avvio;

import design.Menu;
import java.net.MalformedURLException;

public class Launcher {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        //Game game=new Game(); e game.start();
        Menu menu = new Menu();
        menu.setSize(832, 640);
        menu.setLocation(300, 110);
        menu.setVisible(true);
        // Game game = new Game("Retro Dante", 800,672);
        //game.start();

    }//end main
}
