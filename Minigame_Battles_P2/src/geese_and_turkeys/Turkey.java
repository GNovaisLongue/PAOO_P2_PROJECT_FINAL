package geese_and_turkeys;

import strategy_battle_Chars.Character;

public class Turkey extends Character {

	@Override
	public double causarDano() {
		return Weapon.useWeapon();//WeaponBehavior. Trocar para makeNoise()
	}
	
	public String toString() {
		return this.nome + ": " + Weapon;
	}
	
	public Turkey() {
		setNome("Peru");
	}

}
