package projeto.api.rest.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import projeto.api.rest.model.PessoaModel;

public class PessoaDTO {	

    
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    
    @NotNull(message = "Cpf é obrigatório")
    @Length(max = 20)
    @CPF(message = "Cpf invalido")
    private String cpf;

    
    @Size(min=5, max = 255, message = "E-mail deve conter entre 5 a 255 caracteres")
    @NotNull(message = "E-mail é obrigatório")
    private String email;

   
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataNascimento;
    
    @Deprecated
    public PessoaDTO() {
    	
    }

    public PessoaDTO(PessoaModel pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.email = pessoa.getEmail();
		this.dataNascimento = pessoa.getDataNascimento();
	}

	public PessoaModel salvar() {
        PessoaModel pessoa = new PessoaModel(nome, cpf, email, dataNascimento);
        return pessoa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    
}
