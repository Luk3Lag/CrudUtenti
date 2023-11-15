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

        do{
            System.out.println("1. Aggiungi utente\n2. Leggi utenti\n3. Modifica password\n4. Elimina utente\n5. Logout");
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
                        for(Utente u : utenti.values()){
                            if(u.getUsername().equals(utente.getUsername())){
                                u.setPassword(newPassword);
                            }
                        }
                    }
                    break;
                case 4:
                    crud.deleteUtente(utente);
                    break;
                case 5:
                    if(login.logout()){
                        System.out.println("Logout eseguito correttamente!");
                        return;
                    }
                    break;
            }
        }while(true);
    }
}