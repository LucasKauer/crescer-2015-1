package filmator.model;

public class Avaliacao {
	private int idFilme;
	private String loginUsuario;
	private int nota;
	
	public Avaliacao(int idFilme, String loginUsuario, int nota) {
		this.setIdFilme(idFilme);
		this.setLoginUsuario(loginUsuario);
		this.setNota(nota);
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
}