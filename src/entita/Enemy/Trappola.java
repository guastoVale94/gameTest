package entita.Enemy;

import entita.Enemy.Inferno.*;
import entita.Enemy.*;
import static avvio.Game.sin_level;
import avvio.Handler;
import dev.codenmore.tilegame.items.Item;
import entita.Animation;
import entita.Creature;
import entita.Entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import world.Assets;

public class Trappola extends Creature {

    private Graphics g;

    private Animation nemico_left, nemico_right, nemico_attack, nemico_up, nemico_down;
    // Attack timer
    private long lastAttackTimer, attackCooldown = 1500, attackTimer = attackCooldown;
    private boolean left, up;
    private boolean attaccoLeft, attaccoRight, attaccoUp, attaccoDown;
    private boolean target = false;

    public Trappola(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH * 2, Creature.DEFAULT_CREATURE_HEIGHT * 2);
        left = false;//parti con il nemico rivolto verso sinistra
        up = false;
        //right = false;
        nemico_left = new Animation(500, Assets.cerbero_left);
        nemico_right = new Animation(500, Assets.cerbero_right);
        nemico_up = new Animation(500, Assets.cerbero_up);
        nemico_down = new Animation(500, Assets.cerbero_down);
        nemico_attack = new Animation(500, Assets.cerbero_attack);
        this.setSpeed(1.5f);
    }

    @Override
    public void tick() {
        // animazioni destra-sinistra
        if (left) {
            nemico_left.tick();
        } else {
            nemico_right.tick();
        }
        //animazione sopra-sotto
        if (up) {
            nemico_up.tick();
        } else {
            nemico_down.tick();
        }
        if (attaccoLeft || attaccoRight || attaccoDown || attaccoUp) {
            nemico_attack.tick();
        }
        //Movement

        checkArea();

        if (target) {
            // Attack
            checkAttacks();
        }

    }

    @Override
    public void render(Graphics g) {
            g.drawImage(Assets.erbaScura, (int) (x - handler.getGameCamera().getxOffset() - 30), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        if (attaccoLeft) {
            //poichÃ¨ non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 30), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        } else
        if (attaccoRight) {
            //poichÃ¨ non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() + 30), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        } else
        if (attaccoUp) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset() - 30), width, height, null);
        } else
        if (attaccoDown) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset() + 30), width, height, null);
        } 

    }

    @Override
    public void die() {
        System.out.println("nemico ucciso");

    }

    private void checkArea() {

        if (this.checkEntityTarget(0, 0)) {
            target = true;
        } else {
            target = false;
        }

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

        if (this.checkEntityCollisions(xMove, yMove)) {//collision verso sinistra
            System.err.println("attacco da sinistra");
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            //animazione attacco a sinistra
            attaccoLeft=true;
            attaccoDown=false;
            attaccoUp=false;
            attaccoRight=false;
        }else

         if (this.checkEntityCollisions(xMove, yMove)) {//se collision verso destra...
            System.err.println("attacco da destra");
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            //animazione attacco a destra
            attaccoRight = true;
            attaccoDown=false;
            attaccoUp=false;
            attaccoLeft=false;
            
        } else 
         if (this.checkEntityCollisions(xMove, yMove)) {//se collision verso destra...
            System.err.println("attacco da sotto");
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            //animazione attacco a destra
            attaccoDown = true;
            attaccoLeft=false;
            attaccoUp=false;
            attaccoRight=false;
         }
         else if (this.checkEntityCollisions(xMove, yMove)) {//collision verso sinistra
            System.err.println("attacco da sopra");
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            //animazione attacco a sinistra
            attaccoUp = true;
            attaccoDown=false;
            attaccoLeft=false;
            attaccoRight=false;
            
        } else{
             attaccoUp = false;
            attaccoDown=false;
            attaccoLeft=false;
            attaccoRight=false;
         }

        
        
        attackTimer = 0;

        if (attaccoRight || attaccoLeft || attaccoDown || attaccoUp) {
            for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.equals(this)) {
                    continue;
                }
                if (e.getCollisionBounds(0, 0).intersects(ar)) {
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
            die();
            
        }
    }
}
