import java.util.Scanner;

public class Utente {
    private String username;
    private String password;

    public Utente(String utente,String password){
        this.username=utente;
        this.password=password;
    }
    
    public String getUsername() {
        return username;
    }
       public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
      public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la vecchia password: ");
        String oldPassword = scanner.nextLine();

        // Verifica che la vecchia password sia corretta
        if (oldPassword.equals(this.password)) {
            System.out.print("Inserisci la nuova password: ");
            String newPassword = scanner.nextLine();

            // Aggiorna la password nell'archivio dati
            this.password=newPassword;

            System.out.println("Password cambiata con successo!");
        } else {
            System.out.println("Vecchia password non corretta. Impossibile cambiare la password.");
        }
    }

    @Override
    public String toString() {
        return "Utente{" + "username=" + username + ", password=" + password + "}";
    }
}
