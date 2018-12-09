package entita;

import avvio.Handler;
import java.awt.Graphics;
import java.util.ArrayList;



public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities; // arrayList di entità,contiene nemici,oggetti
        // tutto quello che interagisce col player,il world è solo lo sfondo
        // il player è un'entità speciale,non fa parte del vettore
	
	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
                
	}
	
	public void tick(){
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
                        // se elemento morto,rimuovi dal gioco
                        if(!e.isActive())
				entities.remove(e);
		}
	}
	
	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	//GETTERS SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
