package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class controller {
	
	public controller() {
	}
	
	public String os() {//Identifica o SO.
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void chamaProcesso(String processo, String os) {//Combina os dados (que estavam no metodo mataProcesso) e o comandodo terminal para matar o processo 
		
		if (os.contains("Windows")) {

			try {
				Runtime.getRuntime().exec(processo);
			} catch (Exception e) {
				if(e.getMessage().contains("740")) {
					//cmd /c processo
					StringBuffer buffer = new StringBuffer();
					buffer.append("cmd /c");
					buffer.append(" ");
					buffer.append(processo);
					try {
						Runtime.getRuntime().exec(buffer.toString());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}else {
					e.printStackTrace();
				}
			}
			
		}
		else if (os.contains("Linux")) {
			
			//Realizar etapas para Linux
			
		}
	}
	
	public void leProcesso(String nomeProcesso) {//Recebe a String do comando "do terminal", armazena e imprime na tela o mesmo que seria exibido no terminal
		try {
			Process processo = Runtime.getRuntime().exec(nomeProcesso);
			InputStream fluxo = processo.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//Não precisa de etapas para Linux pois são as mesmas etapas
	
	public void mataProcesso(String param, String os) {//Cria o comando para matar o processo e encaminha para o metodo chamaProcesso
				
		if (os.contains("Windows")) {
			String cmdPid = "TASKKILL /PID ";
			String cmdNome = "TASKKILL /IM ";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try {
				pid = Integer.parseInt(param);
				buffer.append(cmdPid);
				buffer.append(pid);
			}catch(NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(param);
			}
			chamaProcesso(buffer.toString(), os);
		}
		else if (os.contains("Linux")) {
			
			//Realizar etapas para Linux
			
		}
	}
	
	public static void Executa1() {
		
		controller proc = new controller();
		String os = proc.os();		
		if (os.contains("Windows")) {
		
			//System.out.println(os);
			String processo = "tasklist /FO Table";
			proc.leProcesso(processo);
		}
		else if (os.contains("Linux")) {
		//Ainda preciso identificar o comando que lista os processos no linux
			System.out.println(os);
			String processo = "top";
			proc.leProcesso(processo);
		}
	}
	
	public static void Executa2() {
		
		controller proc = new controller();
		String os = proc.os();	
		String processo = "";
		processo = JOptionPane.showInputDialog("Digite o nome ou o PID do Processo");
		proc.mataProcesso(processo, os);
	}
}
