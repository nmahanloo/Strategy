package Abilities;

import Monsters.Monster;

public interface Attack extends Ability {
    public abstract Integer attack(Monster target);
}
