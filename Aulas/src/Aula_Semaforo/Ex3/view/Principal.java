package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCavaleiros;

public class Principal {// Corredor

	public static boolean tocha = true;
	public static boolean pedra = true;
	public static int cavaleiros;
	public static Semaphore semaforo = new Semaphore(1);// Permissoes

	public static void main(String[] args) {
		/*
		 * 4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms.
		 * OK O corredor � escuro, tem 2 km e em 500 m, h� uma �nica tocha. OK O
		 * cavaleiro que pegar a tocha, aumenta sua velocidade, somando mais 2 m por 50
		 * ms ao valor que j� fazia. OK Em 1,5 km, existe uma pedra brilhante. OK O
		 * cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50
		 * ms ao valor que j� fazia. OK
		 * 
		 * Ao final dos 2 km, OK os cavaleiros se separam em 4 corredores cada um com
		 * uma porta e, um por vez pega uma porta aleat�ria (que n�o pode repetir) e
		 * entra nela. Apenas uma porta leva � sa�da. As outras 3 tem monstros que os
		 * devoram
		 * 
		 */
		int cavaleiros = 0;
		// for (cavaleiros= 0; cavaleiros < 4; cavaleiros++){
		ThreadCavaleiros Cavaleiros = new ThreadCavaleiros(cavaleiros, semaforo);
		Cavaleiros.start();
		// }
	}
}