package geese_and_turkeys.behavior;

import strategy_battle_weapons.WeaponBehavior;

public class Turkey_behavior_one implements WeaponBehavior,Goose_n_Turkey_Behavior {
	//armas exclusivas para gansos/perus

	@Override
	public String makeNoise() {//causarDano == fazerBarulho
		return "Gobble";
//		System.out.println("Gobble");
	}
	
	@Override
	public double useWeapon() {
		makeNoise();
		return 0;
	}
	
	@Override
	public String toString() {
		return "Gobble!";
	}
	
}