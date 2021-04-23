package projeto.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projeto.api.rest.DTO.PessoaDTO;
import projeto.api.rest.DTO.PessoaIdNomeDTO;
import projeto.api.rest.exceptions.EmailCpfDuplicadosException;
import projeto.api.rest.model.PessoaModel;
import projeto.api.rest.repository.PessoaRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<PessoaModel> get() {
    	 return pessoaRepository.findAll();
    }

    @PostMapping
    public PessoaDTO save(@RequestBody @Valid PessoaDTO pessoaDto) {
    	
    	  Optional<PessoaModel> isPessoaExiste = pessoaRepository.findByEmailAndCpf(pessoaDto.getEmail(), pessoaDto.getCpf());

          if(isPessoaExiste.isPresent()) {
        	  throw new EmailCpfDuplicadosException(pessoaDto.getEmail(), pessoaDto.getCpf());        	  
          } 
           
        //PessoaModel pessoa = pessoaDto.salvar();
        PessoaModel pessoa = new PessoaModel(pessoaDto.getNome(), pessoaDto.getCpf(), pessoaDto.getEmail(),  pessoaDto.getDataNascimento());
        pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoa);
        
    }

    @GetMapping("/{id}")
    public Optional<PessoaModel> getById(@PathVariable("id") Long codigoId) {
        return pessoaRepository.findById(codigoId);
    }
    
    @GetMapping("/dto/{id}")
    public PessoaIdNomeDTO getDTOById(@PathVariable("id") Long codigoId) {
       Optional<PessoaModel> pessoa = pessoaRepository.findById(codigoId);
       return new PessoaIdNomeDTO(pessoa.get());
    }

}
