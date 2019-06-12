package geese_and_turkeys.behavior;

import strategy_battle_weapons.WeaponBehavior;

public class Goose_behavior_one implements WeaponBehavior,Goose_n_Turkey_Behavior {
	//armas exclusivas para gansos/perus

	@Override
	public String makeNoise() {
		return "Honk";//causarDano == fazerBarulho
		//System.out.println("Honk!");
	}
	
	@Override
	public double useWeapon() {
		makeNoise();
		return 0;
	}
	
	@Override
	public String toString() {
		return "Honk!";
	}
	
}
