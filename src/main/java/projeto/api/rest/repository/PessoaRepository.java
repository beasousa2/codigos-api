package projeto.api.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.api.rest.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel,Long> {
    Optional<PessoaModel> findByEmailAndCpf(String email, String cpf);
    
    Optional<PessoaModel> findByEmail(String email); 
    
    
}
