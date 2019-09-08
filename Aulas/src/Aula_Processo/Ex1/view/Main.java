package view;

import javax.swing.JOptionPane;

import controller.RedeController;

public class Main {

	public static void main(String[] args) {
		//Programa cria interface que permite 2 opções:
		//IP ou Ping para ambos os Sistemas Windows e Linux

		/*
		 * Ex. 1 Criar em Eclipse, um novo Java Project com uma classe chamada
		 * RedesController.java no package controller e uma classe Main.java no package
		 * view. A classe RedesController.java deve ter 2 mï¿½todos.
		 * 
		 * O primeiro, chamado ip, que recebe o nome do Sistema Operacional como
		 * parï¿½metro e, de acordo com o S.O., faz a chamada de configuraï¿½ï¿½o de IP e
		 * filtra a saï¿½da do processo, retornando um String com o nome do Adaptador
		 * Ethernet e o IPv4 apenas (Nï¿½o importa o nï¿½mero de adaptadores ethernet, devem
		 * aparecer todos). Os adaptadores que nï¿½o tiverem IPv4 nï¿½o devem ser mostrados.
		 * 
		 * O segundo, chamado ping, que recebe o nome do Sistema Operacional como
		 * parï¿½metro e, de acordo com o S.O., faz a chamada de ping com 10 iteraï¿½ï¿½es,
		 * filtra a saï¿½da, pegando apenas o tempo e dï¿½ a saï¿½da, em ms, do tempo mï¿½dio do
		 * ping. (O endereï¿½o para ping, pode ser o www.google.com.br).
		 * 
		 * A Classe Main.java deve ter a possibilidade de o usuï¿½rio escolher a aï¿½ï¿½o que
		 * quer fazer e, dependendo da escolha, instanciar a Classe RedesController.java
		 * e chamar o mï¿½todo escolhido. A opï¿½ï¿½o de finalizar a aplicaï¿½ï¿½o tambï¿½m deve
		 * estar disponï¿½vel.
		 * 
		 * Para filtrar a saï¿½da String, considere utilizar contains, Split, substring, ,
		 * trim; contains - Confere se contem uma determinada palavra dentro da variavel
		 * e retorna boolean Split - Dividi a string em uma matriz de string baseada na
		 * expressï¿½o regular fornecida. substring - Seleciona parte de um texto
		 */

		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - IP \n 2 - Ping \n 9 - Fim"));
			switch (opc) {
			case 1:

				// RedesController IP
				RedeController.Ip();
				break;

			case 2:

				// RedesController PING
				RedeController.Ping();
				break;

			case 9:

				// fim
				break;

			default:

				JOptionPane.showMessageDialog(null, "Opção Inválida");

			}
		}
		System.exit(0);
	}
}