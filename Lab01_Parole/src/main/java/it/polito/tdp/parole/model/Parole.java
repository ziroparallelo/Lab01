package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
		
	private List<String> parole;
	
	public Parole() {
		parole = new LinkedList<String> ();
	}
	
	public void addParola(String p) 
	{
		parole.add(p);
	}
	
	public List<String> getElenco() 
	{
		LinkedList<String> l = new LinkedList<String>(parole);
		Collections.sort(l);
		return l;
	}
	
	public void reset() 
	{
		parole.clear();
	}

	public List<String> getParole() {
		return parole;
	}

	@Override
	public String toString() {
		return "Parole: " + parole;
	}
	
	public void cancella(String p) throws ParolaNonTrovata
	{
		boolean flag = parole.contains(p);
		if(flag)
			parole.remove(p);
		else
		{
			ParolaNonTrovata e = new ParolaNonTrovata();
			throw e;
		}
	}
	
	

}
