import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Login{
    Map<Integer, Utente> utenti = new HashMap<>();
    Utente utente;
    boolean accessoEseguito=false;
    int tentativi=0;
    boolean loggato= false;
    int nextId=0;

    public Utente registrazione(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Inserire l'username");
      String username= scanner.nextLine();
      System.out.println("Inserire la password:");
      String password= scanner.nextLine();
      Utente utente = new Utente(username, password);
      if(utenti.size()>0){
        for(Utente u : utenti.values()){
          if(u.getUsername().equals(utente.getUsername())){
            System.out.println("Errore l' utente  esiste già!");
            return null;
          }
        }
      }
      utenti.put(nextId, utente);
      nextId++;
      System.out.println("Utente aggiunto con successo!");
      return utente;
    }

    public Utente login(){
      Scanner scanner = new Scanner(System.in);
      while (tentativi<3 && accessoEseguito==false){
        System.out.println("Inserire l'username");
        String username= scanner.nextLine();
        System.out.println("Inserire la password:");
        String password= scanner.nextLine();
        tentativi++;
        if(utenti.size()>0){
          for (Utente u : utenti.values()){
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())){
                System.out.println("Accesso eseguito correttamente!");
                accessoEseguito=true;
                loggato= true;
                this.utente=u;
                return this.utente;
            }
          }
        }else{
          System.out.println("Utente non trovato");
          this.utente= new Utente(username, password);
          return this.utente;
        }

        if (!accessoEseguito && tentativi<3){
          System.out.println("Username o password errati. Riprova. Ti rimangono "+ (3 - tentativi)+" tentativi.");
          return null;
        }

        if (!accessoEseguito && tentativi==3){
          System.out.println("Spiacenti, hai sbagliato troppe volte l'username e/o la password. Prova ad accedere nuovamente tra 15 minuti.");
          return null;
        }
      }
      return utente;
    }

    public boolean logout(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Sicuro di voler uscire dalla sessione?");

      System.out.println("1. Si");
      System.out.println("2. No");
        
      int uscire = scanner.nextInt();
      if (uscire == 1){
        loggato=false;
        return true;
      }

      return true;
    }
}