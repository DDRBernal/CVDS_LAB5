package edu.eci.cvds.game;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.Random;
@ManagedBean(name="guessBean")
@SessionScoped
public class BeanGame {
	private int numIntentos;
	private int numeroAdivinar;
	private int puntaje;
	private String estado;
	

	public BeanGame() {
		 restart();
	}
	
	public void restart() {
		Random r=new Random();
		numeroAdivinar=r.nextInt(51);
		puntaje=100000;
		numIntentos=0;
		estado="";
	} 
	
	public void guess(int intento) {
		if (puntaje==0){
			estado="Has perdido! Intentalo de nuevo!";
		}
		else if(intento!=numeroAdivinar) {
			estado="Fallastes! Intenta con otro numero del 0 al 50!";
			numIntentos+=1;
			puntaje-=10000;
		}
		else {
			estado="Has adivinado el numero! Has ganado el juego!";
		}
	} 

	public int getNumeroAdivinar() {
		return numeroAdivinar;
	}

	public int getNumIntentos() {
		return numIntentos;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public String getEstado() {
		return estado;
	}


}