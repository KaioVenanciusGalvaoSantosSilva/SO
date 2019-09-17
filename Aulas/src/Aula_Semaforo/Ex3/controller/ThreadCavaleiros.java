package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import view.Principal;

public class ThreadCavaleiros extends Thread {

	// Tirar duvida com professor pois isso não esta me parecendo thread - Esta
	// sequencial em vez de simultaneo.

	private int distancia[] = new int[4];
	private int cavaleiros;
	private int valor = 0;
	private int valor2 = 0;
	private int guardaTochaCavaleiro;
	private int guardaPedraCavaleiro;
	boolean finalizou = false;
	Semaphore semaforo;

	// Não necessita de permissão pois as Threads(cavaleiros) são simultaneas.
	// É necessário permissão para acessar as Portas

	public ThreadCavaleiros(int cavaleiros, Semaphore semaforo) {

		this.cavaleiros = cavaleiros;
		this.semaforo = semaforo;
	}
	// -------------------------------------------------------------

	public void Inicio() {

		for (cavaleiros = 0; cavaleiros < 4; cavaleiros++) {

			distancia[cavaleiros] = 0;
			// System.out.println("O Cavaleiro " + cavaleiros + " percorreu " +
			// distancia[cavaleiros] + " metros.");
		}
		// System.out.println("");// "\n"
	}
	// -------------------------------------------------------------

	public void Caminhar() {// inicio
		// System.out.println("Caminhar");

		Inicio();

		while ((distancia[0] < 2000) || (distancia[1] < 2000) || (distancia[2] < 2000) || (distancia[3] < 2000)) {

			try {
				// 1000 ms = 1 segundo.
				// 50 ms = 0.05 seg
				Thread.sleep(0);// atraso de 50 ms - // Bloqueia a Thread por parametros milisegundos.

				for (cavaleiros = 0; cavaleiros < 4; cavaleiros++) {

					if ((distancia[cavaleiros] < 2000)) {

						Tocha();/// TOCHA
						Pedra();/// PEDRA

						distancia[cavaleiros] = (int) (distancia[cavaleiros] + ((double) Math.random() * 3) + 2);
						// System.out.println(
						// "O Cavaleiro " + cavaleiros + " percorreu " + distancia[cavaleiros] + "
						// metros.");
					} else {
						distancia[cavaleiros] = distancia[cavaleiros];
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println("");
		}
		// System.out.println("");

		for (cavaleiros = 0; cavaleiros < 4; cavaleiros++) {
			// System.out.println("O cavaleiro " + cavaleiros + " percorreu " +
			// distancia[cavaleiros] + " metros.");
			// Todos chegaram aos 2000 m
		}
		System.out.println("");
	}// fim

	// -------------------------------------------------------------

	public void Tocha() {/// INICIO TOCHA

		if ((distancia[cavaleiros] >= 500) && Principal.tocha) {
			if (valor == 0) {
				distancia[cavaleiros] = (int) (distancia[cavaleiros] + 2);
				Principal.tocha = false;
				System.out.println("O cavaleiro " + cavaleiros + " Pegou a tocha.");
				guardaTochaCavaleiro = cavaleiros;// Cavaleiro alcançou os 500 metros e pegou a tocha
				valor = 1;
			} else if (guardaTochaCavaleiro == cavaleiros) {// Buff da tocha +2

				distancia[cavaleiros] = (int) (distancia[cavaleiros] + 2);
				System.out.println("O cavaleiro " + cavaleiros + " esta andando com a tocha e esta a "
						+ distancia[cavaleiros] + " metros");
			}
		}
	}// Fim TOCHA

	// -------------------------------------------------------------

	public void Pedra() { // INICIO PEDRA

		if ((distancia[cavaleiros] >= 1500) && Principal.pedra) {

			if (valor2 == 0) {
				distancia[cavaleiros] = (int) (distancia[cavaleiros] + 2);
				Principal.pedra = false;
				System.out.println("O cavaleiro " + cavaleiros + " Pegou a Pedra.");
				guardaPedraCavaleiro = cavaleiros;// Cavaleiro alcançou os 1500 metros e pegou a tocha
				valor2 = 1;
			} else if (guardaPedraCavaleiro == cavaleiros) {// Buff da tocha +2

				distancia[cavaleiros] = (int) (distancia[cavaleiros] + 2);
				System.out.println("O cavaleiro " + cavaleiros + " esta andando com a pedra e esta a "
						+ distancia[cavaleiros] + " metros");
			}
		}
	}// FIM PEDRA

	// -------------------------------------------------------------

	public void Corredores() {

		// Referencia para sorteio:
		// https://www.guj.com.br/t/randomico-limitado-sem-repeticao/58358/6
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			numeros.add(i);
		}

		Random random = new Random();
		int rand;
		int numeroSorteado;

		for (int i = 0; i < 4; i++) {
			rand = random.nextInt(numeros.size());
			numeroSorteado = numeros.get(rand);
			numeros.remove(rand);
			cavaleiros = i;

			if (numeroSorteado == 0) {
				System.out.println("Cavaleiro " + cavaleiros + " saiu da caverna");
			} else {
				System.out.println("Cavaleiro " + cavaleiros + " foi Morto pelo Monstro");
			}
		}
	}

	// -------------------------------------------------------------

	public void run() {

		Caminhar();

		try {
			semaforo.acquire();// inicializa o semaforo // Começa a concorrencia
			Corredores();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {// forçando continuar mesmo depois do Catch

			semaforo.release();// Continua em paralelo
		}

	}
	// -------------------------------------------------------------
}