package world;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    // scenario paradiso
    public static BufferedImage erbaChiara, erbaScura, fioriBianchi, fioriRossi, fontana;
    public static BufferedImage nuvolaCentraleAlto, nuvolaCentraleCentrale, nuvolaCentraleBasso,
            nuvolaDestraAlto, nuvolaDestraBasso, nuvolaDestraCentrale,
            nuvolaSinistraAlto, nuvolaSinistraBasso, nuvolaSinistraCentrale, nuvolaCentraleCentraleDue, vuoto;
    // scenario inferno
    public static BufferedImage dirt, magma, rocciaFuoco;
    // scenario purgatorio
    public static BufferedImage stone1, stone2;
    public static BufferedImage player, potion;
    // nemico demone
    public static BufferedImage[] demone_left, demone_right, demone_up, demone_down;
    public static BufferedImage[] angelo_left, angelo_right, angelo_up, angelo_down;
    public static BufferedImage[] cerbero_left, cerbero_right, cerbero_up, cerbero_down;
    public static BufferedImage[] nonMorto_left, nonMorto_right, nonMorto_up, nonMorto_down;
    public static BufferedImage[] anima_left, anima_right, anima_up, anima_down;
    public static BufferedImage[] spiritoFuoco_left, spiritoFuoco_right, spiritoFuoco_up, spiritoFuoco_down;
    public static BufferedImage[] demone_attack, angelo_attack, cerbero_attack, anima_attack,spiritoFuoco_attack,nonMorto_attack;

    public static BufferedImage[] player_left, player_right, player_up, player_down, specialAttack;
    public static BufferedImage[] player_attack_right;

    public static void init() {
        // hell
        SpriteSheet sheetHell = new SpriteSheet(ImageLoader.loadImage("/res/hell.png"));

        // heaven
        SpriteSheet sheetHeaven = new SpriteSheet(ImageLoader.loadImage("/res/heaven/heaven1.png"));
        SpriteSheet sheetFontana = new SpriteSheet(ImageLoader.loadImage("/res/heaven/fontane.png"));
        // nuvole
        SpriteSheet sheetnuvolaCentraleAlto = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaCentraleAlto.png"));
        SpriteSheet sheetnuvolaCentraleCentrale = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaCentraleCentrale.png"));
        SpriteSheet sheetnuvolaCentraleCentraleDue = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaCentraleCentraleDue.png"));
        SpriteSheet sheetnuvolaCentraleBasso = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaCentraleBasso.png"));
        SpriteSheet sheetnuvolaDestraAlto = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaDestraAlto.png"));
        SpriteSheet sheetnuvolaDestraBasso = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaDestraBasso.png"));
        SpriteSheet sheetnuvolaDestraCentrale = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaDestraCentrale.png"));
        SpriteSheet sheetnuvolaSinistraAlto = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaSinistraAlto.png"));
        SpriteSheet sheetnuvolaSinistraBasso = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaSinistraBasso.png"));
        SpriteSheet sheetnuvolaSinistraCentrale = new SpriteSheet(ImageLoader.loadImage("/res/nuvole/nuvolaSinistraCentrale.png"));

        /**
         * ************* SHEET-->POTION ***********
         */
        SpriteSheet sheetPotion = new SpriteSheet(ImageLoader.loadImage("/res/healthPotion.png"));
        /**
         * ************* SHEET-->NEMICI ************
         */
        // demone + attacco
        SpriteSheet sheetDemone = new SpriteSheet(ImageLoader.loadImage("/res/nemici/devil.png"));
        SpriteSheet sheetDemoneAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/attaccoNemico.png"));
        // angelo + attacco
        SpriteSheet sheetAngelo = new SpriteSheet(ImageLoader.loadImage("/res/nemici/angelo.png"));
        SpriteSheet sheetAngeloAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/thunder.png"));
        // cerbero + attacco
        SpriteSheet sheetCerbero = new SpriteSheet(ImageLoader.loadImage("/res/nemici/cerbero.png"));
        SpriteSheet sheetCerberoAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/wind.png"));
        // anime + attacco
        SpriteSheet sheetAnima = new SpriteSheet(ImageLoader.loadImage("/res/nemici/anima.png"));
        SpriteSheet sheetAnimaAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/attaccoOscuro.png"));
        // spirito di fuoco + attacco
        SpriteSheet sheetSpiritoFuoco = new SpriteSheet(ImageLoader.loadImage("/res/nemici/spiritoFuoco.png"));
        SpriteSheet sheetSpiritoFuocoAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/fire.png"));
        // nonMorto +attacco
        SpriteSheet sheetNonMorto = new SpriteSheet(ImageLoader.loadImage("/res/nemici/undead.png"));
        SpriteSheet sheetNonMortoAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/attaccoOscuro.png"));
        
        
        /**
         * ************* SHEET-->DANTE ************
         */
        SpriteSheet sheetDante = new SpriteSheet(ImageLoader.loadImage("/res/danteAnimation.png"));
        SpriteSheet sheetDanteAttacco = new SpriteSheet(ImageLoader.loadImage("/res/DanteAttackAnimation.jpeg"));
        SpriteSheet sheetSpecialAttack = new SpriteSheet(ImageLoader.loadImage("/res/nemici/Attacchi/raggioThunder.png"));

        /**
         * ********************************** CREAZIONE TILES *****************************************
         */
        /**
         * ********************** TILES DANTE/GIOCATORE *****************
         */
        player = sheetDante.crop(0, 0, 24, 32);
        // animazione demone verso sinistra
        player_left = new BufferedImage[2];
        player_left[0] = sheetDante.crop(0, 0, 23, 32);
        player_left[1] = sheetDante.crop(23, 0, 25, 32);
        // animazione verso destra
        player_right = new BufferedImage[2];
        player_right[0] = sheetDante.crop(0, 64, 23, 32);
        player_right[1] = sheetDante.crop(23, 64, 25, 32);
        // animazione verso sopra
        player_up = new BufferedImage[1];
        player_up[0] = sheetDante.crop(23, 32, 25, 32);
        // animazione verso sotto
        player_down = new BufferedImage[1];
        player_down[0] = sheetDante.crop(0, 32, 23, 32);
        // animazione attacco verso destra
        player_attack_right = new BufferedImage[3];
        player_attack_right[0] = sheetDanteAttacco.crop(0, 0, 64, 32);
        player_attack_right[1] = sheetDanteAttacco.crop(64, 0, 64, 32);
        player_attack_right[2] = sheetDanteAttacco.crop(128, 0, 64, 32);
        // attacco speciale
        specialAttack = new BufferedImage[1];
        specialAttack[0] = sheetSpecialAttack.crop(0, 0, 192, 144);

        /**
         * ********************** TILES NEMICI *****************
         */
        // animazione demone verso sinistra
        demone_left = new BufferedImage[4];
        demone_left[0] = sheetDemone.crop(0, 80, 80, 80);
        demone_left[1] = sheetDemone.crop(80, 80, 80, 80);
        demone_left[2] = sheetDemone.crop(160, 80, 80, 80);
        demone_left[3] = sheetDemone.crop(240, 80, 80, 80);
        // animazione verso destra
        demone_right = new BufferedImage[4];
        demone_right[0] = sheetDemone.crop(0, 160, 80, 80);
        demone_right[1] = sheetDemone.crop(80, 160, 80, 80);
        demone_right[2] = sheetDemone.crop(160, 160, 80, 80);
        demone_right[3] = sheetDemone.crop(240, 160, 80, 80);
        // animazione verso sopra
        demone_up = new BufferedImage[4];
        demone_up[0] = sheetDemone.crop(0, 240, 80, 80);
        demone_up[1] = sheetDemone.crop(80, 240, 80, 80);
        demone_up[2] = sheetDemone.crop(160, 240, 80, 80);
        demone_up[3] = sheetDemone.crop(240, 240, 80, 80);
        // animazione verso sotto
        demone_down = new BufferedImage[4];
        demone_down[0] = sheetDemone.crop(0, 0, 80, 80);
        demone_down[1] = sheetDemone.crop(80, 0, 80, 80);
        demone_down[2] = sheetDemone.crop(160, 0, 80, 80);
        demone_down[3] = sheetDemone.crop(240, 0, 80, 80);
        // attacco nemico demone
        demone_attack = new BufferedImage[3];
        demone_attack[0] = sheetDemoneAttack.crop(0, 0, 100, 100);
        demone_attack[1] = sheetDemoneAttack.crop(80, 0, 100, 100);
        demone_attack[2] = sheetDemoneAttack.crop(160, 0, 100, 100);

        // animazione angelo verso sinistra
        angelo_left = new BufferedImage[4];
        angelo_left[0] = sheetAngelo.crop(20, 75, 50, 50);
        angelo_left[1] = sheetAngelo.crop(105, 75, 50, 50);
        angelo_left[2] = sheetAngelo.crop(180, 75, 50, 50);
        angelo_left[3] = sheetAngelo.crop(265, 75, 50, 50);
        // animazione verso destra
        angelo_right = new BufferedImage[4];
        angelo_right[0] = sheetAngelo.crop(5, 140, 50, 50);
        angelo_right[1] = sheetAngelo.crop(90, 140, 50, 50);
        angelo_right[2] = sheetAngelo.crop(165, 140, 50, 50);
        angelo_right[3] = sheetAngelo.crop(250, 140, 50, 50);
        // animazione verso sopra
        angelo_up = new BufferedImage[4];
        angelo_up[0] = sheetAngelo.crop(0, 200, 75, 55);
        angelo_up[1] = sheetAngelo.crop(80, 200, 75, 55);
        angelo_up[2] = sheetAngelo.crop(160, 200, 75, 55);
        angelo_up[3] = sheetAngelo.crop(240, 200, 75, 55);
        // animazione verso sotto
        angelo_down = new BufferedImage[4];
        angelo_down[0] = sheetAngelo.crop(0, 0, 80, 60);
        angelo_down[1] = sheetAngelo.crop(80, 0, 80, 60);
        angelo_down[2] = sheetAngelo.crop(160, 0, 80, 60);
        angelo_down[3] = sheetAngelo.crop(240, 0, 80, 60);
        // attacco nemico
        angelo_attack = new BufferedImage[2];
        angelo_attack[1] = sheetAngeloAttack.crop(620, 0, 100, 200);
        angelo_attack[0] = sheetAngeloAttack.crop(800, 0, 100, 200);

        // animazione cerbero verso sinistra
        cerbero_left = new BufferedImage[4];
        cerbero_left[0] = sheetCerbero.crop(0, 64, 64, 64);
        cerbero_left[1] = sheetCerbero.crop(64, 64, 64, 64);
        cerbero_left[2] = sheetCerbero.crop(128, 64, 64, 64);
        cerbero_left[3] = sheetCerbero.crop(192, 64, 64, 64);
        // animazione verso destra
        cerbero_right = new BufferedImage[4];
        cerbero_right[0] = sheetCerbero.crop(0, 128, 64, 64);
        cerbero_right[1] = sheetCerbero.crop(64, 128, 64, 64);
        cerbero_right[2] = sheetCerbero.crop(128, 128, 64, 64);
        cerbero_right[3] = sheetCerbero.crop(192, 128, 64, 64);
        // animazione verso sopra
        cerbero_up = new BufferedImage[4];
        cerbero_up[0] = sheetCerbero.crop(0, 192, 64, 64);
        cerbero_up[1] = sheetCerbero.crop(64, 192, 64, 64);
        cerbero_up[2] = sheetCerbero.crop(128, 192, 64, 64);
        cerbero_up[3] = sheetCerbero.crop(192, 192, 64, 64);
        // animazione verso sotto
        cerbero_down = new BufferedImage[4];
        cerbero_down[0] = sheetCerbero.crop(0, 0, 64, 64);
        cerbero_down[1] = sheetCerbero.crop(64, 0, 64, 64);
        cerbero_down[2] = sheetCerbero.crop(128, 0, 64, 64);
        cerbero_down[3] = sheetCerbero.crop(192, 0, 64, 64);
        // attacco nemico
        cerbero_attack = new BufferedImage[2];
        cerbero_attack[1] = sheetCerberoAttack.crop(620, 252, 100, 200);
        cerbero_attack[0] = sheetCerberoAttack.crop(800, 252, 100, 200);

        // animazione anima verso sinistra
        anima_left = new BufferedImage[4];
        anima_left[0] = sheetAnima.crop(0, 50, 32, 48);
        anima_left[1] = sheetAnima.crop(32, 50, 32, 48);
        anima_left[2] = sheetAnima.crop(64, 50, 32, 48);
        anima_left[3] = sheetAnima.crop(96, 50, 32, 48);
        // animazione verso destra
        anima_right = new BufferedImage[4];
        anima_right[0] = sheetAnima.crop(0, 100, 32, 48);
        anima_right[1] = sheetAnima.crop(32, 100, 32, 48);
        anima_right[2] = sheetAnima.crop(64, 100, 32, 48);
        anima_right[3] = sheetAnima.crop(96, 100, 32, 48);
        // animazione verso sopra
        anima_up = new BufferedImage[4];
        anima_up[0] = sheetAnima.crop(0, 142, 32, 48);
        anima_up[1] = sheetAnima.crop(32, 142, 32, 48);
        anima_up[2] = sheetAnima.crop(64, 142, 32, 48);
        anima_up[3] = sheetAnima.crop(96, 142, 32, 48);
        // animazione verso sotto
        anima_down = new BufferedImage[4];
        anima_down[0] = sheetAnima.crop(0, 0, 32, 48);
        anima_down[1] = sheetAnima.crop(32, 0, 32, 48);
        anima_down[2] = sheetAnima.crop(64, 0, 32, 48);
        anima_down[3] = sheetAnima.crop(96, 0, 32, 48);
        // attacco nemico
        anima_attack = new BufferedImage[2];
        anima_attack[1] = sheetAnimaAttack.crop(620, 0, 100, 200);
        anima_attack[0] = sheetAnimaAttack.crop(800, 0, 100, 200);
        
        // animazione spirito di fuoco verso sinistra
        spiritoFuoco_left = new BufferedImage[4];
        spiritoFuoco_left[0] = sheetSpiritoFuoco.crop(0, 50, 32, 48);
        spiritoFuoco_left[1] = sheetSpiritoFuoco.crop(32, 50, 32, 48);
        spiritoFuoco_left[2] = sheetSpiritoFuoco.crop(64, 50, 32, 48);
        spiritoFuoco_left[3] = sheetSpiritoFuoco.crop(96, 50, 32, 48);
        // animazione verso destra
        spiritoFuoco_right = new BufferedImage[4];
        spiritoFuoco_right[0] = sheetSpiritoFuoco.crop(0, 100, 32, 48);
        spiritoFuoco_right[1] = sheetSpiritoFuoco.crop(32, 100, 32, 48);
        spiritoFuoco_right[2] = sheetSpiritoFuoco.crop(64, 100, 32, 48);
        spiritoFuoco_right[3] = sheetSpiritoFuoco.crop(96, 100, 32, 48);
        // animazione verso sopra
        spiritoFuoco_up = new BufferedImage[4];
        spiritoFuoco_up[0] = sheetSpiritoFuoco.crop(0, 142, 32, 48);
        spiritoFuoco_up[1] = sheetSpiritoFuoco.crop(32, 142, 32, 48);
        spiritoFuoco_up[2] = sheetSpiritoFuoco.crop(64, 142, 32, 48);
        spiritoFuoco_up[3] = sheetSpiritoFuoco.crop(96, 142, 32, 48);
        // animazione verso sotto
        spiritoFuoco_down = new BufferedImage[4];
        spiritoFuoco_down[0] = sheetSpiritoFuoco.crop(0, 0, 32, 48);
        spiritoFuoco_down[1] = sheetSpiritoFuoco.crop(32, 0, 32, 48);
        spiritoFuoco_down[2] = sheetSpiritoFuoco.crop(64, 0, 32, 48);
        spiritoFuoco_down[3] = sheetSpiritoFuoco.crop(96, 0, 32, 48);
        // attacco nemico
        spiritoFuoco_attack = new BufferedImage[2];
        spiritoFuoco_attack[0] = sheetSpiritoFuocoAttack.crop(0, 0, 190, 190);
        spiritoFuoco_attack[1] = sheetSpiritoFuocoAttack.crop(190, 0, 190, 190);

        // non morto animazione verso sinistra
        nonMorto_left = new BufferedImage[4];
        nonMorto_left[0] = sheetNonMorto.crop(0, 96, 80, 96);
        nonMorto_left[1] = sheetNonMorto.crop(80, 96, 80, 96);
        nonMorto_left[2] = sheetNonMorto.crop(160, 96, 80, 96);
        nonMorto_left[3] = sheetNonMorto.crop(240, 96, 80, 96);
        // animazione verso destra
        nonMorto_right = new BufferedImage[4];
        nonMorto_right[0] = sheetNonMorto.crop(0, 192, 80, 96);
        nonMorto_right[1] = sheetNonMorto.crop(80, 192, 80, 96);
        nonMorto_right[2] = sheetNonMorto.crop(160, 192, 80, 96);
        nonMorto_right[3] = sheetNonMorto.crop(240, 192, 80, 96);
        // animazione verso sopra
        nonMorto_up = new BufferedImage[4];
        nonMorto_up[0] = sheetNonMorto.crop(0, 288, 80, 96);
        nonMorto_up[1] = sheetNonMorto.crop(80, 288, 80, 96);
        nonMorto_up[2] = sheetNonMorto.crop(160, 288, 80, 96);
        nonMorto_up[3] = sheetNonMorto.crop(240, 288, 80, 96);
        // animazione verso sotto
        nonMorto_down = new BufferedImage[4];
        nonMorto_down[0] = sheetNonMorto.crop(0, 0, 80, 96);
        nonMorto_down[1] = sheetNonMorto.crop(80, 0, 80, 96);
        nonMorto_down[2] = sheetNonMorto.crop(160, 0, 80, 96);
        nonMorto_down[3] = sheetNonMorto.crop(240, 0, 80, 96);
        // attacco nemico demone
        nonMorto_attack = new BufferedImage[4];
        nonMorto_attack[0] = sheetNonMortoAttack.crop(192, 192, 192, 192);
        nonMorto_attack[1] = sheetNonMortoAttack.crop(384, 192, 192, 192);
        nonMorto_attack[2] = sheetNonMortoAttack.crop(576, 192, 192, 192);
        nonMorto_attack[3] = sheetNonMortoAttack.crop(760, 192, 192, 192);
        /**
         * ************ TILES PARADISO **************
         */
        //tiles per paradiso,i primi 4 sono gli angoli della nuvola
        erbaChiara = sheetHeaven.crop(0, 0, width, height);
        erbaScura = sheetHeaven.crop(32, 0, width, height);
        fioriBianchi = sheetHeaven.crop(64, 0, width, height);
        fioriRossi = sheetHeaven.crop(64, 32, width, height);
        fontana = sheetFontana.crop(width * 4, 0, width * 2, height * 2);

        // pozione o mettere cuore per la vita
        potion = sheetPotion.crop(0, 0, 22, 24);

        // nuvole
        nuvolaCentraleAlto = sheetnuvolaCentraleAlto.crop(0, 0, width, height);
        nuvolaCentraleCentrale = sheetnuvolaCentraleCentrale.crop(0, 0, width, height);
        nuvolaCentraleCentraleDue = sheetnuvolaCentraleCentraleDue.crop(0, 0, width, height);
        nuvolaCentraleBasso = sheetnuvolaCentraleBasso.crop(0, 0, width, height);
        nuvolaDestraAlto = sheetnuvolaDestraAlto.crop(0, 0, width, height);
        nuvolaDestraBasso = sheetnuvolaDestraBasso.crop(0, 0, width, height);
        nuvolaDestraCentrale = sheetnuvolaDestraCentrale.crop(0, 0, width, height);
        nuvolaSinistraAlto = sheetnuvolaSinistraAlto.crop(0, 0, width, height);
        nuvolaSinistraBasso = sheetnuvolaSinistraBasso.crop(0, 0, width, height);
        nuvolaSinistraCentrale = sheetnuvolaSinistraCentrale.crop(0, 0, width, height);
        vuoto = sheetHeaven.crop(0, width, width, height);

        /**
         * ****************** TILES INFERNO ***************************
         */
        magma = sheetHell.crop(width * 7, height * 9, width, height);
        dirt = sheetHell.crop(width * 6, height * 2, width, height);
        rocciaFuoco = sheetHell.crop(width * 3, height * 2, width, height);
        /**
         * ****************** TILES PURGATORIO ***************************
         */
        stone1 = sheetHell.crop(width, height * 2, width, height);
        stone2 = sheetHell.crop(width * 7, height * 2, width, height);
    }

}
