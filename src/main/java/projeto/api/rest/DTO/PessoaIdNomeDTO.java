package projeto.api.rest.DTO;


import projeto.api.rest.model.PessoaModel;

public class PessoaIdNomeDTO {
	
	private Long id;
	
	private String nome;
	
	
	@Deprecated
	public PessoaIdNomeDTO() {}

	
	public PessoaIdNomeDTO( PessoaModel pessoa) {
		this.id = pessoa.getCodigoId();
		this.nome = pessoa.getNome();
	}


	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
}
