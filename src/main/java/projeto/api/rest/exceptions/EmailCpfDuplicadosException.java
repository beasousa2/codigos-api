package projeto.api.rest.exceptions;

public class EmailCpfDuplicadosException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailCpfDuplicadosException(String email, String cpf) {
        super("Esses dados já se encontram cadastrados: \n"
                + "E-mail: "+ email + 
                "\nCpf: " + cpf);
    }

}
