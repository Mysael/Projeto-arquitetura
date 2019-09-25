package br.com.cesed.arquitetura.serasa.serasa.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	//recebe a msg, e uma outra exceção que seria a causa de alguma coisa que aconteceu antes
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
