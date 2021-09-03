package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarroController extends Thread
{
	private String sentido;
	private String destino;
	private Semaphore semaforo;
	
	public ThreadCarroController(String sentido, Semaphore semaforo)
	{
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run()
	{
		SentidoDoDestino();
		
		try 
		{
			sleep(1000);
			semaforo.acquire();
			passandoNoCruzamento();
			sleep(2000);
			
		} 
		catch (InterruptedException ie) 
		{
			ie.printStackTrace();
		}
		finally 
		{
			semaforo.release();
		}
		
	}
	
	private void SentidoDoDestino()
	{
		switch (sentido) 
		{
			case "Norte": destino = "Sul";
			break;
			
			case "Sul": destino = "Norte";
			break;
			
			case "Leste": destino = "Oeste";
			break;
			
			case "Oeste": destino = "Leste";
			break;
				
		}
	}
	
	private void passandoNoCruzamento() 
	{
		System.out.println("Passando no cruzamento: \nO carro " + sentido + " indo para " + destino + "\n");
	}
}
