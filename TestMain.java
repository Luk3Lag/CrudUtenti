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
                if(utente==null){
                    System.out.println("Login");
                    utente = login.login();
                }else{
                    System.out.println("Registrazione eseguita con successo!");
                }
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
            System.out.println("1. Aggiungi utente corrente\n2. Leggi utenti\n3. Modifica password\n4. Elimina utente\n5. Logout");
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
                    scan.nextLine();
                    String password = scan.nextLine();
                    if(password.equals(utente.getPassword())){
                        System.out.print("Inserisci la nuova password: ");
                        String newPassword = scan.nextLine();
                        Map<Integer, Utente> utenti = crud.getUtenti();
                        for(Utente u : utenti.values()){
                            if(u.getUsername().equals(utente.getUsername())){
                                u.setPassword(newPassword);
                                System.out.println("Password cambiata con successo!");
                            }
                        }
                    }else{
                        System.out.println("Password errata!");
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