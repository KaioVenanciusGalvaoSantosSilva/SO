package view;

import javax.swing.JOptionPane;

import controller.controller;

//Exercicio 2 de Processo de SO
public class Principal {

	public static void main(String[] args) {

		/*
		 * 
		 * Fazer, em java, uma aplica��o que liste os processos ativos, permita ao
		 * usu�rio entrar com o nome ou o PID do processo e o mate.
		 * 
		 * A aplica��o dever� funcionar, minimamente em Windows e Linux (Alunos com Mac
		 * podem fazer para os 3 SO).
		 * 
		 * � not�rio que cada SO tem comandos diferentes para as a��es supracitadas.
		 * Pesquisar os comandos para cada SO.
		 * 
		 * A aplica��o dever� ter, no package view, uma classe que tenha um m�todo main
		 * que d� ao usu�rio a possibilidade de ver os processos ativos ou matar os
		 * processos (Por Nome ou PID).
		 * 
		 * 
		 * No package controller, dever� ter: 1) Uma classe que tenha um m�todo que
		 * identifique o SO; 2) Um m�todo que, recebendo o SO, no qual est� rodando,
		 * como par�metro de entrada, selecione o comando para listar os processos
		 * ativos; 3) Um m�todo que, recebendo o SO, no qual est� rodando, e o PID do
		 * processo, como par�metros de entrada, selecione o comando para matar o
		 * processo e o finalize; 4) Um m�todo que, recebendo o SO, no qual est�
		 * rodando, e o Nome do processo, como par�metros de entrada, selecione o
		 * comando para matar o processo e o finalize;
		 */

		int opc = 0;

		while (opc != 9) {
			opc = Integer
					.parseInt(JOptionPane.showInputDialog(" 1 - Processos Ativos \n 2 - Matar Processos \n 9 - Fim"));
			switch (opc) {
			case 1:
				
				//Identificar o SO e realizar o tasklist de acordo com o sistema
				controller.Executa1();// Processos Ativos
				
				break;

			case 2:

				// Matar Processos
				controller.Executa2();
				// RedeController.Ping();
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
