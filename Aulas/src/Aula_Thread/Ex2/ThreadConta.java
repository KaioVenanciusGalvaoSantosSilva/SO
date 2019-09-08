package Ex2;

import javax.swing.JOptionPane;

public class ThreadConta extends Thread {

	int n = 0;

	public ThreadConta(int n) {
		this.n = n;
	}
	//Run
	
	@Override
	public void run() {
		CalcAscoisa();
	
	}
	
	

	public void CalcAscoisa() {

		n = Integer.parseInt(JOptionPane.showInputDialog("Insira o valor de N"));

		if (n % 2 == 0) {
			n--;
		}

//	System.out.println(n);

		for (int i = 0; i < n; i = n + 2) {

		}

	}
}
