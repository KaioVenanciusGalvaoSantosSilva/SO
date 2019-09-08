package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class RedeController {

	public static void Ip() {
		// Declarar variaveis
		String ipConfig = "";
		int opc = 0;

		while (opc != 9) {// Enquanto opc for diferente de 9
			opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Windows \n 2 - Linux \n 9 - Voltar"));// mostrar na
																											// tela ...

			switch (opc) {
			case 1:// Windows
				String Sistem = System.getProperty("os.name");// Pega o nome do sistema

				if (Sistem.contains("Windows")) {// Verifica se o nome contem a palavras Windows

					JOptionPane.showMessageDialog(null, "O seu sistema é " + Sistem);// Imprimi na tela "O seu sistema ï¿½
																						// + (Nome do sistema)"
					ipConfig = "ipconfig";// comando do terminal a executar
					leipConfig(ipConfig);// inicia metodo leipConfig enviando a variave ipConfig
				} else {// Caso a condicão acima não seja atendida
					JOptionPane.showMessageDialog(null, "O seu Sistema não é Windows");// Mostra na tela que o sistema
																						// "O seu Sistema nï¿½o ï¿½ Windows"
				}
				break;// Quebra encerra ninhas de cï¿½digos relacionadas ao case1

			case 2:// Linux

				Sistem = System.getProperty("os.name");// Pega o nome do sistema

				if (Sistem.contains("Linux")) {// Verifica se o nome contem a palavras Linux

					JOptionPane.showMessageDialog(null, "O seu sistema é " + Sistem);// Imprimi na tela "O seu sistema ï¿½
																						// + (Nome do sistema)"

					ipConfig = "ifconfig";// comando do terminal a executar
					leipConfig(ipConfig);// inicia metodo leipConfig enviando a variave ifConfig
				} else {
					JOptionPane.showMessageDialog(null, "O seu Sistema não é Linux");// Mostra na tela que o sistema "O
																						// seu Sistema nï¿½o ï¿½ Linux"
					// System.out.println("O seu Sistema nï¿½o ï¿½ Windows");
				}
				break;// Quebra encerra ninhas de cï¿½digos relacionadas ao case2

			case 9:// Caso seja escolhido a opï¿½ao 9 - Encerra
					// fim
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcão InvÃ¡lida");// Caso seja inserido qualquer informaï¿½ï¿½o
																		// diferente dos cases 1, 2 ou 9 exibe :"Opï¿½ï¿½o
																		// Invï¿½lida"
			}
		}
	}

	public static void Ping() {
		// Declarar variaveis
		int opc = 0;
		String nomeProcesso = "";

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Windows \n 2 - Linux \n 9 - Voltar"));

			switch (opc) {
			case 1:
				String Sistem = System.getProperty("os.name");

				if (Sistem.contains("Windows")) {

					JOptionPane.showMessageDialog(null, "O seu sistema é " + Sistem);

					nomeProcesso = "ping www.google.com -n 10";// comando que serï¿½ inserido no terminal
					leProcesso(nomeProcesso);// inicia metodo leProcesso enviado a variavel nomeProcesso
				} else {
					JOptionPane.showMessageDialog(null, "O seu Sistema não é Windows");
					// System.out.println("O seu Sistema nï¿½o ï¿½ Windows");
				}

				break;
			case 2:// Linux

				Sistem = System.getProperty("os.name");

				if (Sistem.contains("Linux")) {

					JOptionPane.showMessageDialog(null, "O seu sistema é " + Sistem);

					nomeProcesso = "ping www.google.com -c 10";// comando que serï¿½ inserido no terminal
					leProcesso(nomeProcesso);// inicia metodo leProcesso enviado a variavel nomeProcesso

				} else {
					JOptionPane.showMessageDialog(null, "O seu Sistema não é Linux");
					// System.out.println("O seu Sistema não é Windows");
				}

				break;

			case 9:
				// fim
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcão Invalida");
			}
		}
	}

	public static void leipConfig(String ipConfig) {

		String adaptador = null;

		// criar variavel processo - Process
		try {
			Process processo = Runtime.getRuntime().exec(ipConfig);// executa no terminal o que esta escrito na variavel
																	// ipConfig
			InputStream fluxo = processo.getInputStream();// pega fluxo de erro/retorno
			InputStreamReader leitor = new InputStreamReader(fluxo);// Transforma fluxo em string
			BufferedReader buffer = new BufferedReader(leitor);// Joga no buffer
			String linha = buffer.readLine();// le a linha

			while (linha != null) {// enquanto a linha for diferente de vazio.

				String[] vetorPalavras2 = linha.split(" ");// O mï¿½todo split quebra uma String em vï¿½rias substrings a
															// partir de um caracter definido por vocï¿½.

				for (String palavra : vetorPalavras2) {// ciclo condicional enquanto o array vetorPalavras2 possuir
														// alguma palavra faï¿½a
					// ipconfig Windows
					if (palavra.contains("Adaptador")) {// Se a linha de palavras contenha "Adaptador"

						adaptador = linha;// atribui palavras da linha a string adaptador
					}

					if (palavra.contains("IPv4.")) {// Se a linha de palavras contenha "IPv4."

						System.out.println(adaptador);// imprime na tela as linhas que foram coletadas os adaptadores
						System.out.println(linha);// imprime na tela as linhas que foram coletadas os IPV4
					}
					// ifconfig Linux - pc precisa ter o pacote net-tools
					// sudo apt install net-tools
					if (palavra.contains("flags")) {// Se a linha de palavras contenha "Adaptador"

						adaptador = linha;// atribui palavras da linha a string adaptador
					}

					if (palavra.contains("broadcast")) {// Se a linha de palavras contenha "IPv4."

						System.out.println(adaptador);// imprime na tela as linhas que foram coletadas os adaptadores
						System.out.println(linha);// imprime na tela as linhas que foram coletadas os IPV4
					}

				} // encerra ciclo condicional

				// System.out.println(linha);//imprime linha
				linha = buffer.readLine();// le linha
			}

			buffer.close();// fecha e limpa da memoria.
			leitor.close();// fecha leitor
			fluxo.close();// fecha fluxo

		} catch (IOException e) {// sai por exception
			e.printStackTrace();
		}
	}

	public static void leProcesso(String nomeProcesso) {
		// criar variavel processo - Process
		double ms = 0;
		double media = 0;

		try {
			Process processo = Runtime.getRuntime().exec(nomeProcesso);// executa no terminal o que esta escrito na
																		// variavel nomeProcesso
			InputStream fluxo = processo.getInputStream();// pega fluxo de erro.
			InputStreamReader leitor = new InputStreamReader(fluxo);// Transforma fluxo em string
			BufferedReader buffer = new BufferedReader(leitor);// Joga no buffer
			String linha = buffer.readLine();// le a linha

			while (linha != null) {

				String[] vetorPalavras = linha.split(" ");// O mï¿½todo split quebra uma String em vï¿½rias substrings a
															// partir de um caracter definido por vocï¿½.

				for (String palavra : vetorPalavras) {// ciclo condicional enquanto o array vetorPalavras possuir alguma
														// palavra faï¿½a

					if (palavra.contains("tempo=")) {// Se a linha contiver a palavra tempo=
						String encontrada = palavra.replace("tempo=", "");// A palavra encontrada na linha - tempo= ï¿½
																			// substituida por vazio
						encontrada = encontrada.replace("ms", "");// A palavra encontrada na linha - ms ï¿½ substituida
																	// por vazio

						ms = Double.parseDouble(encontrada);// converte String em Double
						media = ms + media;// concatena o valor ms e soma com o valor que estiver na variavel media
					}
					if (palavra.contains("time=")) {// Se a linha contiver a palavra tempo=
						String encontrada = palavra.replace("time=", "");// A palavra encontrada na linha - tempo= ï¿½
																			// substituida por vazio
						encontrada = encontrada.replace("ms", "");// A palavra encontrada na linha - ms ï¿½ substituida
																	// por vazio

						ms = Double.parseDouble(encontrada);// converte String em Double
						media = ms + media;// concatena o valor ms e soma com o valor que estiver na variavel media
						// System.out.println(ms);//Imprimi todos os 10 pings
					}

				}

				linha = buffer.readLine();// le linha no buffer
			}

			media = media / 10;// divide valor somado da media pela quantidade de pings realizados
			System.out.println("A média de tempo é de: " + media + " ms");// imprime na tela

			buffer.close();// fecha e limpa da memoria.
			leitor.close();// fecha leitor
			fluxo.close();// fecha fluxo

		} catch (IOException e) {// Sai por exception
			e.printStackTrace();
		}
	}

}