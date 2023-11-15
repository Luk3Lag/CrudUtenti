import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Crud {
    private Utente currentUtente;
    private Map<Integer, Utente> utenti = new HashMap<>();
    private static Crud instance;
    private int id = 0;
    
    private Crud(Utente utente){
        this.currentUtente = utente;
        this.utenti.put(id, utente);
        this.id++;
    }

    public static Crud getInstance(Utente utente){
        if(instance==null){
            instance = new Crud(utente);
        }
        return instance;
    }

    public Utente getUtente(){
        return this.currentUtente;
    }

    public Map<Integer, Utente> getUtenti(){
        return this.utenti;
    }

    public void createUtente(Utente utente){
        if(utenti.size()>0){
            for(Utente u : this.utenti.values()){
                if(u.getUsername().equals(utente.getUsername())){
                    System.out.println("Utente già creato!");
                    return;
                }
            }
        }
        this.utenti.put(id, utente);;
        this.id++;
        writeFile();
    }

    public void readCurrentUtente(){
        System.out.println(this.currentUtente);
    }
    public void readUtenti(){
        for(Integer i : this.utenti.keySet()){
            System.out.println(this.utenti.get(i));
        }
    }

    public void updateUtente(int i, String username, String password){
        if(this.utenti.containsKey(i)){
            Utente utente = this.utenti.get(i);
            utente.setUsername(username);
            utente.setPassword(password);
            this.utenti.put(i, utente);
            writeFile();
        }
    }

    public void deleteUtente(Utente utente){
        if(utente!=null){
            for(Integer i : this.utenti.keySet()){
                if(this.utenti.get(i).getUsername().equals(utente.getUsername())){
                    this.utenti.remove(i);
                    writeFile();
                }
            }
        }
    }

    public void writeFile(){
      try (FileWriter fw = new FileWriter("utenti.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
        for (Utente u : utenti.values()) {
          bw.write(u.toString());
          bw.newLine();
        }
      } catch (IOException e) {
        System.out.println("Errore nella lettura del file");
      }
    }
}
