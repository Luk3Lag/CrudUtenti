import java.util.ArrayList;
import java.util.Scanner;

public class step1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<utente> utenti = new ArrayList<>();
        String risposta;

        do {
            System.out.println("Inserisci il nome utente:");
            String username = scanner.nextLine();
            System.out.println("Inserisci la password:");
            String password = scanner.nextLine();

            boolean utenteEsistente = false;
            for (utente utente : utenti) {
                if (utente.getUtente().equals(username)) {
                    System.out.println("Errore l' utente  esiste già!");
                    utenteEsistente = true;
                    break;
                }
            }

            if (!utenteEsistente) {
                utenti.add(new utente(username, password));
                System.out.println("Utente aggiunto con successo!");
            }

            System.out.println("Vuoi continuare? (si/no)");
            risposta = scanner.nextLine();
        } while (risposta.equals("si"));
    }
}