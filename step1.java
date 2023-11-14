import java.util.HashMap;
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,String> utenti=new HashMap<>();
        String risposta;
        boolean utenteEsistente = false;


        while (utenteEsistente) {
            
        
            System.out.println("Inserisci il nome utente:");
            String username = scanner.nextLine();
            System.out.println("Inserisci la password:");
            String password = scanner.nextLine();

            
                if (utenti.containsKey(username)) {
                    System.out.println("Errore l' utente  esiste già!");
                utenteEsistente = true;
                
            }

            if (!utenteEsistente) {
                utenti.put(username, password);
                System.out.println("Utente aggiunto con successo!");
            }
        }
    }
    
}