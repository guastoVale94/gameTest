package entita.Enemy.NemiciLeftRightORUpDown;

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

public class DemoneUpDown extends Creature {

    private Animation nemico_up, nemico_down, nemico_attack;
    // Attack timer
    private long lastAttackTimer, attackCooldown = 1500, attackTimer = attackCooldown;
    private boolean up;
    private boolean attaccoUp, attaccoDown;

    public DemoneUpDown(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH * 2, Creature.DEFAULT_CREATURE_HEIGHT * 2);
        up = true;//parti con il nemico rivolto verso sinistra
        //right = false;
        nemico_up = new Animation(500, Assets.demone_up);
        nemico_down = new Animation(500, Assets.demone_down);
        nemico_attack = new Animation(500, Assets.demone_attack);
    }

    public void tick() {
        // animazioni
        if (up) {
            nemico_up.tick();
        } else {
            nemico_down.tick();
        }
        if (attaccoUp || attaccoDown) {
            nemico_attack.tick();
        }
        //Movement
        moveLeftRight();
        move();
        if (this.getY() == 150) {// anziche mettere i numeri,per rendere generico???
            //right = true;
            up = false;
        } else if (this.getY() == 400) {
            //right = false;
            up = true;
        }
        // Attack
        checkAttacks();
    }

    private void moveLeftRight() {
        xMove = 0;
        yMove = 0;
        //va in diagonale così
        /*
        if (left) {
            xMove = -speed / 2;// o metti intero
            yMove = -speed / 2;
        } else {
            xMove = speed / 2;
            yMove = speed / 2;
        }*/
        if (up) {
            yMove = -speed / 2;
        } else {
            yMove = speed / 2;
        }
    }

    @Override
    public void render(Graphics g) {
        if (up) {
            g.drawImage(nemico_up.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        } else {
            g.drawImage(nemico_down.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        }
        if (attaccoUp) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset() - 50), width, height, null);
        }
        if (attaccoDown) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset() + 50), width, height, null);
        }

    }

    @Override
    public void die() {
        System.out.println("nemico ucciso");
        handler.getWorld().getItemManager().addItem(Item.potionItem.createNew((int) x, (int) y));

    }

    private void checkAttacks() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) {
            return;
        }

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 40;
        ar.width = arSize;
        ar.height = arSize;

        if (this.checkEntityCollisions(xMove, yMove) && up) {//collision verso sinistra
            System.err.println("attacco da sinistra");
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            //animazione attacco a sinistra
            attaccoUp = true;
        } else {
            attaccoUp = false;
        }

        if (this.checkEntityCollisions(xMove, yMove) && !up) {//se collision verso destra...
            System.err.println("attacco da sotto");
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            //animazione attacco a destra
            attaccoDown = true;
        } else {
            attaccoDown = false;//disabilata l'attacco
        }
        attackTimer = 0;
        if (attaccoUp || attaccoDown) {
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
            sin_level++;

        }
    }
}
