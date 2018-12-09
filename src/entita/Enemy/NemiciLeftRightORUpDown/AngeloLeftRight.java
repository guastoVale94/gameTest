package entita.Enemy.NemiciLeftRightORUpDown;

import static avvio.Game.sin_level;
import avvio.Handler;
import dev.codenmore.tilegame.items.Item;
import entita.Animation;
import entita.Creature;
import entita.Entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import world.Assets;

public class AngeloLeftRight extends Creature {

    private Animation nemico_left, nemico_right, nemico_attack;
    // Attack timer
    private long lastAttackTimer, attackCooldown = 1500, attackTimer = attackCooldown;
    private boolean left;
    private boolean attaccoLeft, attaccoRight;

    public AngeloLeftRight(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH + 20, Creature.DEFAULT_CREATURE_HEIGHT + 20);
        left = true;//parti con il nemico rivolto verso sinistra
        //right = false;
        nemico_left = new Animation(500, Assets.angelo_left);
        nemico_right = new Animation(500, Assets.angelo_right);
        nemico_attack = new Animation(500, Assets.angelo_attack);
    }

    public void tick() {
        // animazioni
        if (left) {
            nemico_left.tick();
        } else {
            nemico_right.tick();
        }
        if (attaccoLeft || attaccoRight) {
            nemico_attack.tick();
        }
        //Movement
        moveLeftRight();
        move();
        if (this.getX() == 80) {// anziche mettere i numeri,per rendere generico???
            //right = true;
            left = false;
        } else if (this.getX() == 270) {
            //right = false;
            left = true;
        }
        // Attack
        checkAttacks();
    }

    private void moveLeftRight() {
        xMove = 0;
        yMove = 0;

        if (left) {
            xMove = -speed / 2;// o metti intero
        } else {
            xMove = speed / 2;
        }
    }

    @Override
    public void render(Graphics g) {
        if (left) {
            g.drawImage(nemico_left.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        } else {
            g.drawImage(nemico_right.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        }
        if (attaccoLeft) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 50), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        }
        if (attaccoRight) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca
            g.drawImage(nemico_attack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() + 50), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
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

        if (this.checkEntityCollisions(xMove, yMove) && left) {//collision verso sinistra
            System.err.println("attacco da sinistra");
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            //animazione attacco a sinistra
            attaccoLeft = true;
        } else {
            attaccoLeft = false;
        }

        if (this.checkEntityCollisions(xMove, yMove) && !left) {//se collision verso destra...
            System.err.println("attacco da destra");
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            //animazione attacco a destra
            attaccoRight = true;
        } else {
            attaccoRight = false;//disabilata l'attacco
        }
        attackTimer = 0;

        if (attaccoRight || attaccoLeft) {
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
