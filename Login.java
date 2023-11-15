import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
      if(readFile()){
        boolean registrato=false;
        while(!registrato){
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
                return utente;
              }
            }
          }
          utenti.put(nextId, utente);
          nextId++;
          registrato=true;
          System.out.println("Utente aggiunto con successo!");
          return utente;
        }
      }

      return null;
    }

    public Utente login(){
      if(readFile()){
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

      return null;
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

      return false;
    }

    public boolean readFile(){
      try (FileReader fr = new FileReader("utenti.txt"); BufferedReader br = new BufferedReader(fr)) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] utente = line.split(",");

          Utente u = new Utente(utente[0].split("=")[1], utente[1].split("=")[1].substring(0, utente[1].split("=")[1].length() - 1));
          utenti.put(nextId, u);
          nextId++;
        }
        return true;
      } catch (IOException e) {
        System.out.println("Errore nella lettura del file");
        return false;
      }
    }
}