import java.util.List;
import java.util.Scanner;

class nuovapw{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Username", "Password");
        System.out.print("Inserisci la vecchia password: ");
            String oldPassword = scanner.nextLine();

            // Verifica che la vecchia password sia corretta
            if (isPasswordCorrect(account, oldPassword)) {
                System.out.print("Inserisci la nuova password: ");
                String newPassword = scanner.nextLine();

                // Aggiorna la password nell'archivio dati
                account.setPassword(newPassword);

                System.out.println("Password cambiata con successo!");
            } else {
                System.out.println("Vecchia password non corretta. Impossibile cambiare la password.");
            }

        // Chiusura dello scanner
        scanner.close();
    }

    private static boolean isUsernameTaken(List<Account> accountList, String username) {
        for (Account account : accountList) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPasswordCorrect(Account account, String password) {
        return account.getPassword().equals(password);
    }
}

class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}