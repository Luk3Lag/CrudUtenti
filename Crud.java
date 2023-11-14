import java.util.ArrayList;
import java.util.List;

public class Crud {
    private Utente currentUtente;
    private List<Utente> utenti = new ArrayList<>();
    private Crud instance;
    
    private Crud(Utente utente){
        this.currentUtente = utente;
        this.utenti.add(utente);
    }

    public Crud getIstance(){
        return this.instance;
    }

    public Utente getUtente(){
        return this.currentUtente;
    }

    public void createUtente(Utente utente){
        this.utenti.add(utente);
    }

    public Utente readCurrentUtente(){
        return this.currentUtente;
    }
    public List<Utente> readUtenti(){
        return this.utenti;
    }

    public void updateUtente(String username, String password){
        for(Utente u : this.utenti){
            if(u.getUtente().equals(username)){
                u.setPassword(password);
            }
        }
    }

    public void deleteUtente(Utente utente){
        this.utenti.remove(utente);
    }
}
