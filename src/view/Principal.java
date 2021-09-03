package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarroController;

public class Principal 
{
	public static void main(String[] args)
	{
		String[] sentido = {"Norte", "Leste", "Oeste", "Sul"};
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		
		for(String sent : sentido)
		{
			Thread tCarro = new ThreadCarroController(sent, semaforo);
			tCarro.start();
		}
	}
}
