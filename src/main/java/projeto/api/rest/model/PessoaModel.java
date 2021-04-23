package projeto.api.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "pessoa")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoId;

    @Column(name = "nome", nullable = false, length = 50)
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Column(name = "cpf", nullable = false, length = 14, unique = true)
    @NotNull(message = "Cpf é obrigatório")
    @CPF(message = "Cpf invalido")
    private String cpf;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    @Size(min=5, max = 255, message = "E-mail deve conter entre 5 a 255 caracteres")
    @NotNull(message = "E-mail é obrigatório")
    private String email;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    @Deprecated
    public PessoaModel() {}
    
    public PessoaModel( String nome,
                       String cpf,
                        String email, 
                        LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }
    
    public Long getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Long codigoId) {
        this.codigoId = codigoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
