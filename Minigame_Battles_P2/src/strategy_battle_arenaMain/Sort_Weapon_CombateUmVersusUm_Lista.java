package strategy_battle_arenaMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import geese_and_turkeys.Goose;
import geese_and_turkeys.Turkey;
import geese_and_turkeys.behavior.Goose_behavior_one;
import geese_and_turkeys.behavior.Goose_behavior_three;
import geese_and_turkeys.behavior.Goose_behavior_two;
import geese_and_turkeys.behavior.Turkey_behavior_one;
import geese_and_turkeys.behavior.Turkey_behavior_three;
import geese_and_turkeys.behavior.Turkey_behavior_two;
import strategy_battle_Chars.Character;
import strategy_battle_Chars.King;
import strategy_battle_Chars.Knight;
import strategy_battle_Chars.Queen;
import strategy_battle_Chars.Troll;
import strategy_battle_weapons.AxeBehavior;
import strategy_battle_weapons.BowAndArrowBehavior;
import strategy_battle_weapons.KnifeBehavior;
import strategy_battle_weapons.SwordBehavior;

public class Sort_Weapon_CombateUmVersusUm_Lista {
	List <ListaCombateUmVersusUm> listaCombate1v1;//lista
	Random random = new Random();
	int charFake=0;
	
	public Sort_Weapon_CombateUmVersusUm_Lista(List <ListaCombateUmVersusUm> listaCombate1v1) {
		this.listaCombate1v1 = new ArrayList<>();
		
		//SORTEIO PESSOAS
		for (int i = 0; i < 8; i++) {
			Character pessoa1 = null, pessoa2 = null;
			int p1 = random.nextInt(4);
			switch (p1) {
				case 0:
					pessoa1 = new King();
					break;
				case 1:
					pessoa1 = new Queen();
					break;
				case 2:
					pessoa1 = new Troll();
					break;
				case 3:
					pessoa1 = new Knight();
					break;
				case 4:
					pessoa1 = new Goose();
					charFake=1;
					break;
				case 5:
					pessoa1 = new Turkey();
					charFake=1;
					break;
			}
			int p2=0;
			if(charFake==1){
				p2 = random.nextInt(4);//p2 nao pode ser goose ou turkey
				charFake=0;
			}
			else {
				p2 = random.nextInt(6);//						
			}
			switch (p2){
				case 0:
					pessoa2 = new King();
					break;
				case 1:
					pessoa2 = new Queen();
					break;
				case 2:
					pessoa2 = new Troll();
					break;
				case 3:
					pessoa2 = new Knight();
					break;
				case 4:
					pessoa2 = new Goose();
					break;
				case 5:
					pessoa2 = new Turkey();
					break;
			}
			listaCombate1v1.add(new ListaCombateUmVersusUm(pessoa1, pessoa2));//Lista - arraylist - OK
		}
		//// SORTEIO ARMAS
		for(ListaCombateUmVersusUm listA : listaCombate1v1) {
			int weapon = random.nextInt(3);
			
			if(listA.getPessoa1().getClass().getSimpleName().matches("Goose")) {
				switch (weapon) {
					case 0:
						listA.getPessoa1().setWeapon(new Goose_behavior_one());
						break;
					case 1:
						listA.getPessoa1().setWeapon(new Goose_behavior_two());
						break;
					case 2:
						listA.getPessoa1().setWeapon(new Goose_behavior_three());
						break;
				}
			}
			else if(listA.getPessoa1().getClass().getSimpleName().matches("Turkey")) {//
				switch (weapon) {
					case 0:
						listA.getPessoa1().setWeapon(new Turkey_behavior_one());
						break;
					case 1:
						listA.getPessoa1().setWeapon(new Turkey_behavior_two());
						break;
					case 2:
						listA.getPessoa1().setWeapon(new Turkey_behavior_three());
						break;
				}
			}
			else {
				weapon = random.nextInt(4);
				switch (weapon) {
					case 0:
						listA.getPessoa1().setWeapon(new BowAndArrowBehavior());
						break;
					case 1:
						listA.getPessoa1().setWeapon(new AxeBehavior());
						break;
					case 2:
						listA.getPessoa1().setWeapon(new KnifeBehavior());
						break;
					case 3:
						listA.getPessoa1().setWeapon(new SwordBehavior());
						break;
				}
			}
			//-------------------Player2-------------------
				weapon = random.nextInt(3);
				
				if(listA.getPessoa2().getClass().getSimpleName().matches("Goose")) {//
					switch (weapon) {
						case 0:
							listA.getPessoa2().setWeapon(new Goose_behavior_one());
							break;
						case 1:
							listA.getPessoa2().setWeapon(new Goose_behavior_two());
							break;
						case 2:
							listA.getPessoa2().setWeapon(new Goose_behavior_three());
							break;
					}
				}
				else if(listA.getPessoa2().getClass().getSimpleName().matches("Turkey")) {//
					switch (weapon) {
						case 0:
							listA.getPessoa2().setWeapon(new Turkey_behavior_one());
							break;
						case 1:
							listA.getPessoa2().setWeapon(new Turkey_behavior_two());
							break;
						case 2:
							listA.getPessoa2().setWeapon(new Turkey_behavior_three());
							break;
					}
				}
				else {
					weapon = random.nextInt(4);
					switch (weapon) {
						case 0:
							listA.getPessoa2().setWeapon(new BowAndArrowBehavior());
							break;
						case 1:
							listA.getPessoa2().setWeapon(new AxeBehavior());
							break;
						case 2:
							listA.getPessoa2().setWeapon(new KnifeBehavior());
							break;
						case 3:
							listA.getPessoa2().setWeapon(new SwordBehavior());
							break;
					}
				}
			}//for
	}//construtor

	
}