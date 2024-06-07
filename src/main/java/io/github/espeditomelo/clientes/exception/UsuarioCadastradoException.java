package io.github.espeditomelo.clientes.exception;

public class UsuarioCadastradoException extends RuntimeException {

    // sobrescrita do construtor da classe super
    public UsuarioCadastradoException(String login) {
        super("Usuário cadastrado anteriormente para o login: " + login);
    }
}

