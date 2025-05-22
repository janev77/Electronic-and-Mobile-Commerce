package mk.ukim.finki.lab1b.security;

public class JwtConstants {
    public static final String SECRET_KEY = "a5fa1dfa3e56153d139c14c70f5b50a8b9e7229e1fcb05050e297add67904cf2";
    public static final Long EXPIRATION_TIME = 864000000L;
    public static final String HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
