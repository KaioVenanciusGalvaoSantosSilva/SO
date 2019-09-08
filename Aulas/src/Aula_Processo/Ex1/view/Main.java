package view;

import javax.swing.JOptionPane;

import controller.RedeController;

public class Main {

	public static void main(String[] args) {
		//Programa cria interface que permite 2 op��es:
		//IP ou Ping para ambos os Sistemas Windows e Linux

		/*
		 * Ex. 1 Criar em Eclipse, um novo Java Project com uma classe chamada
		 * RedesController.java no package controller e uma classe Main.java no package
		 * view. A classe RedesController.java deve ter 2 m�todos.
		 * 
		 * O primeiro, chamado ip, que recebe o nome do Sistema Operacional como
		 * par�metro e, de acordo com o S.O., faz a chamada de configura��o de IP e
		 * filtra a sa�da do processo, retornando um String com o nome do Adaptador
		 * Ethernet e o IPv4 apenas (N�o importa o n�mero de adaptadores ethernet, devem
		 * aparecer todos). Os adaptadores que n�o tiverem IPv4 n�o devem ser mostrados.
		 * 
		 * O segundo, chamado ping, que recebe o nome do Sistema Operacional como
		 * par�metro e, de acordo com o S.O., faz a chamada de ping com 10 itera��es,
		 * filtra a sa�da, pegando apenas o tempo e d� a sa�da, em ms, do tempo m�dio do
		 * ping. (O endere�o para ping, pode ser o www.google.com.br).
		 * 
		 * A Classe Main.java deve ter a possibilidade de o usu�rio escolher a a��o que
		 * quer fazer e, dependendo da escolha, instanciar a Classe RedesController.java
		 * e chamar o m�todo escolhido. A op��o de finalizar a aplica��o tamb�m deve
		 * estar dispon�vel.
		 * 
		 * Para filtrar a sa�da String, considere utilizar contains, Split, substring, ,
		 * trim; contains - Confere se contem uma determinada palavra dentro da variavel
		 * e retorna boolean Split - Dividi a string em uma matriz de string baseada na
		 * express�o regular fornecida. substring - Seleciona parte de um texto
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

				JOptionPane.showMessageDialog(null, "Op��o Inv�lida");

			}
		}
		System.exit(0);
	}
}