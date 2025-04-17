package mk.ukim.finki.lab1b.model.Exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }

}
