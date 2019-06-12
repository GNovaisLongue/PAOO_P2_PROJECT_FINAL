package strategy_battle_arenaMain;

import java.text.DecimalFormat;
import java.util.Random;

import strategy_battle_Chars.Character;
import strategy_battle_char_buff.BeastTamerBuff;
import strategy_battle_char_buff.FireMagicBuff;
import strategy_battle_char_buff.ThornsBuff;

public class Batalha_Vetor {

	ListaCombateUmVersusUm [] vetorCombate1v1 = new ListaCombateUmVersusUm [8];//vetor
	Random random = new Random();
	DecimalFormat dec = new DecimalFormat("#0.00");
	//
	public Batalha_Vetor(ListaCombateUmVersusUm [] vetorCombate1v1){
		
		int vitoriaDaRodada = 0; // (flag)quem venceu o duelo 1v1 e avanca
		int armaExtra; // (Decorator)ganha um dano extra entre 4 possibilidades
		Character vencedorDuelo;// quem venceu sua partida
		
		System.out.println("\n---------------------------------------------------------------------------------------------\n" + 
		"\t\t\t\tBatalha no Vetor\n" + 
				"---------------------------------------------------------------------------------------------");
		// --------------------------Batalha-----------------------
			for (int i = 1; i < 5; i++	) {
				int j = 0;
				int vitoriosos=0;
				System.out.println("Fase " + i + ": ");
				
				for (ListaCombateUmVersusUm cadaDuelo : vetorCombate1v1) {
					System.out.print("Batalha " + ++j + ": ");
					System.out.println(cadaDuelo);
				}
				
				Character duelista1 = null, duelista2 = null;
				// lista para os vencedores
				ListaCombateUmVersusUm [] listaVencedores = new ListaCombateUmVersusUm [4];//vetor	
				
				if(i==2 ) {
					listaVencedores = new ListaCombateUmVersusUm [2];//vetor
				}
				if(i==3) {
					listaVencedores = new ListaCombateUmVersusUm [1];//vetor
				}

				int cont = 0;
				for (ListaCombateUmVersusUm cadaDuelo : vetorCombate1v1) {
					cont++;
					System.out.println("--------------------------------------------------------------------");
					System.out.println("\nBatalha " + cont + " - " + cadaDuelo + "\n");
					System.out.println("///////////////////////[Relatorio da batalha]///////////////////////\n");
					
					//combate contra um ave
					if((cadaDuelo.getPessoa1().getClass().getSimpleName().matches("Turkey")||cadaDuelo.getPessoa1().getClass().getSimpleName().matches("Goose"))) {
						cadaDuelo.getPessoa1().setVida(0);
						System.out.println("A Ave Fugiu!");
					}
					else if ((cadaDuelo.getPessoa2().getClass().getSimpleName().matches("Turkey")||cadaDuelo.getPessoa2().getClass().getSimpleName().matches("Goose"))) {
						cadaDuelo.getPessoa2().setVida(0);
						System.out.println("A Ave Fugiu!");
					}
					
					while (cadaDuelo.batalhando()) {
						int turno = random.nextInt(2);
						switch (turno) {
							case 0:
								System.out.println("P1 ATACA!");
								cadaDuelo.p1Ataca();
								break;
							case 1:
								System.out.println("P2 ATACA!");
								cadaDuelo.p2Ataca();
								break;
						}
						System.out
								.println("\nVida de " + cadaDuelo.getPessoa1() + ": " + dec.format(cadaDuelo.getPessoa1().getVida()));
						System.out.println(
								"Vida de " + cadaDuelo.getPessoa2() + ": " + dec.format(cadaDuelo.getPessoa2().getVida()) + "\n");
					}
					
					
					System.out.println("**********************************************************");
					System.out.println("Vencedor:" + cadaDuelo.quemVenceu());
					System.out.println("**********************************************************");
					vencedorDuelo = cadaDuelo.quemVenceu();
					// Buff para o vitorioso
					int tipo_elemento = random.nextInt(4);
					switch (tipo_elemento) {
						case 0:
							System.out
									.println("\n" + vencedorDuelo + " obteve controle sobre magias de fogo, aumentando em +20 seu dano");
							vencedorDuelo = new FireMagicBuff(vencedorDuelo);
							break;
						case 1:
							System.out.println("\n" + vencedorDuelo + " tem muitos espinhos em suas armas, aumentando em +15 seu dano");
							vencedorDuelo = new ThornsBuff(vencedorDuelo);
							break;
						case 2:
							System.out
									.println("\n" + vencedorDuelo + " Abusou muito de sua sorte chegando até aqui. Sem Buff para você!");
							break;
						case 3:
							System.out
									.println("\n" + vencedorDuelo + " tem uma animal feroz como ajudante, aumentando em +10 seu dano");
							vencedorDuelo = new BeastTamerBuff(vencedorDuelo);
							break;
					}
					System.out.println(
							"\n-----------------------------------------------------------------------------------------------");
					if (vitoriaDaRodada == 0) {
						// vencedor se torna futuro pessoa1
						duelista1 = vencedorDuelo;
						duelista1.recuperarMaxVida();
						vitoriaDaRodada = 1;
					} 
					else {
						// vencedor se torna futuro pessoa2
						duelista2 = vencedorDuelo;
						duelista2.recuperarMaxVida();
						vitoriaDaRodada = 0;
						// e fecha um futuro novo combate 1v1
						listaVencedores [vitoriosos] = new ListaCombateUmVersusUm(duelista1, duelista2);
						vitoriosos++;
						
					}
					System.out
							.println("///////////////////////////////////////////////////////////////////////////////////////////\n");
				}
				vetorCombate1v1 = listaVencedores;
				if (i == 4) {
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					System.out.println("\nCampeão: " + duelista1);
					System.out.println(
							"\n--------------------------------------------------------------------------------------------------------------");
				}
			}//for batalha
	}//construtor
	
}
