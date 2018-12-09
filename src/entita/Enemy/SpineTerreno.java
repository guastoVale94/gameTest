package entita.Enemy;

import static avvio.Game.sin_level;
import avvio.Handler;
import entita.Creature;
import entita.Entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import world.Assets;

public class SpineTerreno extends Creature {

    // Attack timer
    private long lastAttackTimer, attackCooldown = 1500, attackTimer = attackCooldown;
    private boolean attacco;

    public SpineTerreno(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
       
        attacco=true;
    }

    public void tick() {
        
        
        // Attack
        checkAttacks();
    }

    

    @Override
    public void render(Graphics g) {
        
            g.drawImage(Assets.magma, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
       

    }

    @Override
    public void die() {
        System.out.println("nemico ucciso");

    }

    private void checkAttacks() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) {
            return;
        }

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

       

        
        if (attacco) {
            //System.err.println("attacco");
            for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this)) {
                    continue;
                }
                if (e.getCollisionBounds(0, 0).intersects(ar)) {
                    //System.err.println("okokokkoko");
                    e.hurt(2);// mi tolgono 2 di vita per esempio,aumenta sin bar,da togliere????????????
                    return;
                }
            }
        }

    }

    @Override
    public void hurt(int amt) {
        health -= amt;

        if (health <= 0) {
            active = false;

        }
    }

}
