package entidade;

public class Login {
	
	private String cpf;
	private int senha;
	
	// Construtores
	public Login() {
	}
	
	public Login(String cpf, int senha) {
		this.cpf = cpf;
		this.senha = senha;
	}
	
	// Método para realizar a validação do login
    public boolean fazerLogin(Cadastro cadastro) {
        return cadastro.verificarLogin(cpf, senha);
    }
    
    
    
    
}
