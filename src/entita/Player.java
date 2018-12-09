package entita;

import static avvio.Game.hearts;
import static avvio.Game.sin_level;
import avvio.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import stati.GameOver;
import stati.State;
import world.Assets;

public class Player extends Creature {

    // Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    public boolean dead;
    private boolean bob = true;
    private boolean attaccoSpeciale, attaccoUp, attaccoDown, attaccoLeft, attaccoRight;
    private final Animation specialAttack, animDown, animUp, animLeft, animRight, animAttaccoRight;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        dead = false;
        this.health = 10;
        specialAttack = new Animation(500, Assets.specialAttack);

        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        animAttaccoRight = new Animation(333, Assets.player_attack_right);

    }

    public void tick() {
        //Animations

        animRight.tick();
        animLeft.tick();
        animAttaccoRight.tick();

        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        // Attack
        checkAttacks();
        if (this.health == 0) {
            this.die();
        }
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animRight.getCurrentFrame();
        } else if (xMove > 0) {
            return animLeft.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else {
            return animDown.getCurrentFrame();
        }
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }

        if (handler.getKeyManager().space) {
            handler.getGame().setPause(true);

        }

    }

    @Override
    public void render(Graphics g) {
        int i;
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        if (dead) {
            State.setState(new GameOver(handler));
        } else if (attaccoRight) {
            g.drawImage(animAttaccoRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width * 2, height, null);
        } else {
            g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        }
        if (attaccoSpeciale) {
            //poichè non ho nemico che attacca,aggiungo disegno di un attacco solo quando nemico attacca

            g.drawImage(specialAttack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() + 20), (int) (y - handler.getGameCamera().getyOffset() - 10), width * 6, height * 3, null);

        }/*else if(attaccoUp){
            g.drawImage(specialAttack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()-30), width, height, null);

        }else if(attaccoDown){
            g.drawImage(specialAttack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()+30), width, height, null);

        }else if(attaccoRight){
            g.drawImage(specialAttack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()+30), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        }else if(attaccoLeft){
            g.drawImage(specialAttack.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()-30), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        }*/


    }

    @Override
    public void die() {
        System.out.println("You lose");
        dead = true;
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

        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            /*attaccoDown=false;
            attaccoLeft=false;
            attaccoRight=false;
            attaccoUp=true;*/
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            /*attaccoLeft=false;
            attaccoRight=false;
            attaccoUp=false;
            attaccoDown=true;*/
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            /*attaccoRight=false;
            attaccoUp=false;
            attaccoDown=false;
            attaccoLeft=true;*/
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            /*attaccoUp=false;
            attaccoDown=false;
            attaccoLeft=false;
            attaccoRight=true;*/
            attaccoRight = true;
        } else if (handler.getKeyManager().l) {
            //System.err.println("fase iniziale:"+sin_level);
            if (sin_level > 1) {

                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
                //System.err.println("ar:" + ar.x + ' ' + ar.y);
                ar.x += 150;
                /*
                attaccoUp=false;
                attaccoDown=false;
                attaccoLeft=false;
                attaccoRight=false;*/
                attaccoSpeciale = true;
                sin_level--;
                //System.err.println("decremento=="+sin_level);
            }
        } else {
            attaccoSpeciale = false;/*
            attaccoDown=false;
            attaccoLeft=false;
            attaccoRight=false;
            attaccoUp=false;*/
            attaccoRight = false;
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                //se sei un nemico non incementi la barra del peccato
                if (attaccoSpeciale) {
                    System.out.println("attacco speciale");
                    e.hurt(3);
                    // idea == sin_level--;
                    return;
                }
                e.hurt(1);
                return;
            }
        }

    }

    @Override
    public void hurt(int amt) {
        int diff = abs(health - hearts);
        if (diff != 0) {
            health += diff;
        }
        health -= amt;
        hearts -= amt;
        if (health <= 0) {
            active = false;
            die();

        }
    }
}
