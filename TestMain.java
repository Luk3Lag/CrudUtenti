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