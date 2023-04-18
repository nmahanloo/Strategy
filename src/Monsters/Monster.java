package Monsters;

import Abilities.Attack;
import java.util.HashMap;
import java.util.Random;

public abstract class Monster {
    private Integer hp;
    private Integer xp = 10;
    Integer agility;
    Integer defense;
    Integer strength;
    Attack attack;
    private Integer maxHP;
    private HashMap<String, Integer> items;
    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
        agility = 10;
        defense = 10;
        strength = 10;
    }
    public Integer getHp() {
        return hp;
    }
    public void setHp(Integer hp) {
        this.hp = hp;
    }
    public Integer getXp() {
        return xp;
    }
    public Integer getMaxHP() {
        return maxHP;
    }
    public HashMap<String, Integer> getItems() {
        return items;
    }
    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
    public Integer getAgility() {
        return agility;
    }
    public Integer getDefense() {
        return defense;
    }
    public Integer getStrength() {
        return strength;
    }
    public Integer attackTarget(Monster target) {
        Integer attackPoint = this.attack.attack(target);
        boolean isTargetAlive = target.takeDamage(attackPoint);
        return attackPoint;
    }
    public boolean takeDamage(Integer damage) {
        if (damage > 0) {
            hp -= damage;
            System.out.println("The creature was hit for " + damage + " damage");
        }
        if (hp <= 0) {
            System.out.println("Oh no! the creature has perished");
        }
        System.out.println(this.toString());
        return (hp > 0);
    }
    Integer getAttribute(Integer min, Integer max) {
        Random rand =new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max-min)+min;
    }
    public boolean equals(Object o) {
        return false;
    }
    public int hashCode() {
        return 0;
    }
    @Override
    public String toString() {
        return ("hp="+hp+"/"+maxHP);
    }
}
