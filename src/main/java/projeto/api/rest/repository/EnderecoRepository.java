package projeto.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.api.rest.model.EnderecoModel;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
    EnderecoModel findByCep(String cep);
    EnderecoModel findByLogradouro(String lograduro);
}
