package Ex2;

public class Tocar {

	public static void main(String[] args) {
		//Incompleto
		/*
		 * Criar uma Thread que receba um int como parametro que sera o N da sequencia.
		 * 
		 * 4 *(1/1 - 1/3 +1/5 - 1/7 + 1/9 - 1/11+ ... 1/N)
		 * 
		 * O metodo deve exibirN e o resultado da sequencia.
		 * 
		 * O main da classe pricipal deve inciar 10 threads com valores randomicos.
		 */

		for (int i = 0; i < 10; i++) {
			int n = (int) (Math.random() * 100);// valor qualquer
			
			Thread t = new ThreadConta(n);
			t.start();
		}

		// n = (int)(Math.random()*100);

	}

}
