package projeto.api.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import projeto.api.rest.model.EnderecoModel;
import projeto.api.rest.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

   public EnderecoModel save(EnderecoModel endereco){
       return repository.save(endereco);
   }
   public List<EnderecoModel> get(){return repository.findAll();}

   public Optional<EnderecoModel> getById(Long id){return repository.findById(id);}

//    @FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
//    public interface CepService {
//
//        @GetMapping("{cep}/json")
//        EnderecoModel buscaEnderecoPorCep(@PathVariable("cep") String cep);
//    }

}
