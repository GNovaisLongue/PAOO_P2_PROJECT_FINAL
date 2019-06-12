package strategy_battle_arenaMain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import geese_and_turkeys.Goose;
import geese_and_turkeys.Turkey;
import strategy_battle_Chars.Character;
import strategy_battle_Chars.King;
import strategy_battle_Chars.Knight;
import strategy_battle_Chars.Queen;
import strategy_battle_Chars.Troll;

public class CombateMain {
	public static void main(String[] args) {
		Random random = new Random();
		List<ListaCombateUmVersusUm> listaCombate1v1 = new ArrayList<>();//lista
		ListaCombateUmVersusUm [] vetorCombate1v1 = new ListaCombateUmVersusUm [8];//vetor
		
		/////////////////////////////////////////////////////////////////////

		DecimalFormat dec = new DecimalFormat("#0.00");
		listaCombate1v1.clear();
		
		//sortear armas
		Sort_Weapon_CombateUmVersusUm_Lista armaLista = new Sort_Weapon_CombateUmVersusUm_Lista(listaCombate1v1);//arraylist
		
		Sort_Weapon_CombateUmVersusUm_Vetor armaPrincipal = new Sort_Weapon_CombateUmVersusUm_Vetor(vetorCombate1v1);//array

		//batalha
		Batalha_Vetor batalhaAr = new Batalha_Vetor(vetorCombate1v1);//vetor
		
		Batalha_Lista batalhaLi = new Batalha_Lista(listaCombate1v1);//lista
		
	}

}
