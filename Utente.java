public class Utente{
    private String username;
    private String password;

    public Utente(String username, String password){
        this.username = existsUsername(username) ? null : username;
        this.password = password;
    }

    // Getters

    // Setters


    boolean existsUsername(String username){
        // Check existance of usernam
    }
}