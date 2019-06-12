package geese_and_turkeys;

import strategy_battle_Chars.Character;

public class Goose extends Character {

	@Override
	public double causarDano() {
		return Weapon.useWeapon();//WeaponBehavior. Trocar para makeNoise()
	}
	
	public String toString() {
		return this.nome + ": " + Weapon;
	}
	
	public Goose() {
		setNome("Ganso");
	}

}
