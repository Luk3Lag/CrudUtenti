public class Utente {
    private String utente;
    private String password;

    public Utente(String utente,String password){
        this.utente=utente;
        this.password=password;
    }

    
    public String getUtente() {
        return utente;
    }
       public String getPassword() {
        return password;
    }
    public void setUtente(String utente) {
        this.utente = utente;
    }
      public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return " ";
    }
}
