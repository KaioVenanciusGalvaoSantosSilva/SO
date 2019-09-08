package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Estacionamento {

	public static void main(String[] args) {

		int permissoes = 3;// Número de permissoes.
		
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro = 0; idCarro < 10 ; idCarro++) {
			ThreadCarro Carro = new ThreadCarro(idCarro, semaforo); //Instancia ThreadCarro
			Carro.start();//Inicia Thread
			
			
		}
		
		
		
	}

}
