package model;

import java.io.Serializable;

public class ModelLogin  implements Serializable {
	 private String login;
	 private String senha;
	private static final long serialVersionUID = 1L;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
