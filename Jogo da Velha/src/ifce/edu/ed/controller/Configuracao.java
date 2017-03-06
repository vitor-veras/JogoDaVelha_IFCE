package ifce.edu.ed.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Configuracao {
	private FileReader in;
	private BufferedReader out;
	private String url, user, pass;
		
	public Configuracao() {
		try {
			this.in = new FileReader("resource/cfg/config.cfg");
			this.out = new BufferedReader(in);
			url = out.readLine();
			user = out.readLine();
			pass = out.readLine();
			out.close();
			in.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("Arquivo nao encontrado.");
		} catch (IOException ioe) {
			System.out.println("Input/Output erro.");
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
