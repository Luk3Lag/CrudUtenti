import java.util.HashMap;
import java.util.Map;

public class Crud {
    private Utente currentUtente;
    private Map<Integer, Utente> utenti = new HashMap<>();
    private Crud instance;
    private int id = 0;
    
    private Crud(Utente utente){
        this.currentUtente = utente;
        this.utenti.put(id, utente);
        this.id++;
    }

    public Crud getIstance(){
        return this.instance;
    }

    public Utente getUtente(){
        return this.currentUtente;
    }

    public void createUtente(Utente utente){
        this.utenti.put(id, utente);;
        this.id++;
    }

    public void readCurrentUtente(){
        System.out.println(this.currentUtente);
    }
    public void readUtenti(){
        for(Integer i : this.utenti.keySet()){
            System.out.println(this.utenti.get(i));
        }
    }

    public void updateUtente(String username, String password){
        for(Utente u : this.utenti.values()){
            if(u.getUtente().equals(username)){
                u.setPassword(password);
            }
        }
    }

    public void deleteUtente(Utente utente){
        if(utente!=null) utenti.remove((Object) utente);
    }
}
