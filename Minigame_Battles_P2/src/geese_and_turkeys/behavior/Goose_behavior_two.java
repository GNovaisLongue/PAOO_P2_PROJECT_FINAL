package geese_and_turkeys.behavior;

import strategy_battle_weapons.WeaponBehavior;

public class Goose_behavior_two implements WeaponBehavior,Goose_n_Turkey_Behavior {

	@Override
	public String makeNoise() {//causarDano == fazerBarulho
		return "howk";
//		System.out.println("howk");
	}

	@Override
	public double useWeapon() {
		makeNoise();
		return 0;
	}
	
	@Override
	public String toString() {
		return "howk!";
	}

}
