package world;

import avvio.Handler;
import dev.codenmore.tilegame.items.Item;
import dev.codenmore.tilegame.items.ItemManager;
import entita.Enemy.Inferno.SpiritoDiFuoco;
import entita.EntityManager;
import entita.Enemy.Paradiso.Angelo;
import entita.Enemy.Paradiso.Anima;
import entita.Enemy.Purgatorio.NonMorto;
import entita.Enemy.SpineTerreno;
import entita.Enemy.Trappola;
import entita.Player;
import java.awt.Graphics;

import world.tiles.Tile;

public class World {

    private Handler handler;
    private int width, height; // dimensioni mappa
    private int[][] tiles; // matrice per posizionare le tiles tramite i loro ID (int)
    private int spawnX;
    private int spawnY;

    //Entities
    private EntityManager entityManager;
    private ItemManager itemManager;
    // path del file dove risiede il world

    public World(Handler handler, String path) {
        this.handler = handler;

        entityManager = new EntityManager(handler, new Player(handler, 130, 300));
        itemManager = new ItemManager(handler);
        //Item fioriBianchi=new Item(Assets.fioriBianchi, "ok", 2);
        //fioriBianchi.setPosition(100,100);
        //Item fioriRossi=new Item(Assets.fioriRossi, "ok", 3);
        //fioriRossi.setPosition(150,100);
        //itemManager.addItem(fioriBianchi);
        //itemManager.addItem(fioriRossi);
        //Item fontana=new Item(Assets.fontana, "ok", 4);
        //fontana.setPosition(200,100);
        //itemManager.addItem(fontana);
        // nemico dinamico
        //entityManager.addEntity(new DemoneLeftRight(handler, 900, 400));
        // entityManager.addEntity(new DemoneUpDown(handler, 1100, 250));
        itemManager.addItem(Item.potionItem.createNew((int) 1420, (int) 250));
        itemManager.addItem(Item.potionItem.createNew((int) 1420, (int) 270));
        itemManager.addItem(Item.potionItem.createNew((int) 1420, (int) 290));

        entityManager.addEntity(new Angelo(handler, 1100, 250));
        //entityManager.addEntity(new Anima(handler, 600, 250));
        //entityManager.addEntity(new SpiritoDiFuoco(handler, 600, 250));
        //entityManager.addEntity(new SpineTerreno(handler, 100,30));
        entityManager.addEntity(new Trappola(handler, 600, 250));
        loadWorld(path);
        // posizione player,la seconda riga del file txt
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

    }

    public void tick() {
        itemManager.tick();
        entityManager.tick();
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        // Items
        itemManager.render(g);
        //Entities
        entityManager.render(g);
    }
    // facciamo ritornare tile,se non lo trova ritorna rock,per non lasciare buchi nella canvas

    public Tile getTile(int x, int y) {

        // tiles[x][y] prendo l'elemento(ID) e vedo che tile è
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.nuvolaCentraleBasso; // default tile
        }
        return t;
    }
    // prendo percorso e carico il file dentro la matrice delle posizioni

    private void loadWorld(String path) {
        // carico contenuto file come stringhe
        String file = Utils.loadFileAsString(path);
        // \\s+-->spit della matrice di stringhe in caratteri individuali 
        // separati da uno spazio bianco o carattere di new line \n
        // e metto nel vettore tokens
        String[] tokens = file.split("\\s+");
        // leggo il primo numero del file.txt cioè il numero di colonne
        // che indica la larghezza della mappa
        width = Utils.parseInt(tokens[0]);
        // analogamente l'altezza
        height = Utils.parseInt(tokens[1]);
        // da dove costruire la mappa
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // ora tutto leggo tutto dal vettore tiles,+4 perche i primi quattro posti
                // li abbiamo letti precedentemente
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

}
