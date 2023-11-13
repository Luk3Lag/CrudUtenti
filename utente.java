public class utente {
    private String utente;
    private String password;

    public utente(String utente,String password){
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
}
