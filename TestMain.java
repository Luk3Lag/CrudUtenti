import java.util.Map;
import java.util.Scanner;

public class TestMain{
    public static void main(String[] args) {
        Login login = new Login();
        Utente utente = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("1. Registrazione\n2. Login\n3. Esci");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                utente = login.registrazione();
                break;
            case 2:
                utente = login.login();
                break;
            case 3:
                System.out.println("Arrivederci!");
                return;
        }

        Crud crud = Crud.getInstance(utente);

        System.out.println("1. Aggiungi utente\n2. Leggi utenti\n3. Modifica password\n4. Elimina utente");
        choice = scan.nextInt();
        switch(choice){
            case 1:
                crud.createUtente(utente);
                break;
            case 2:
                crud.readUtenti();
                break;
            case 3:
                System.out.print("Inserisci la password: ");
                String password = scan.nextLine();
                if(password.equals(utente.getPassword())){
                    System.out.print("Inserisci la nuova password: ");
                    String newPassword = scan.nextLine();
                    Map<Integer, Utente> utenti = crud.getUtenti();
                    crud.updateUtente(0, utente.getUsername(), newPassword);
                }
                break;
        }

        utente.changePassword();

        System.out.println("Utente singolo");
        crud.readCurrentUtente();
        System.out.println("\nLista utenti");
        crud.readUtenti();

        crud.updateUtente(0, "pippo", "pluto");

        System.out.println("Utente singolo");
        crud.readCurrentUtente();
        System.out.println("\nLista utenti");
        crud.readUtenti();

        crud.deleteUtente(utente);

        System.out.println("Utente singolo");
        crud.readCurrentUtente();
        System.out.println("\nLista utenti");
        crud.readUtenti();
        
        System.out.println("Logout? (s/n)");
        scan.nextLine();
        char scelta = scan.nextLine().charAt(0);
        if(scelta=='s'){
            if(login.logout()){
                System.out.println("Logout eseguito correttamente!");
                return;
            }
        }
    }
}