import java.util.Scanner;

public class Main{
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

        boolean esci = false;

        while(!esci){
            Crud crud = Crud.getInstance(utente);

            System.out.println("1. Cambia Password\n2. Logout");

            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    utente.changePassword();
                    break;
                case 2:
                    System.out.println("Logout? (s/n)");
                    scan.nextLine();
                    char scelta = scan.nextLine().charAt(0);
                    if(scelta=='s'){
                        if(login.logout()){
                            System.out.println("Logout eseguito correttamente!");
                            esci = true;
                        }
                    }
                    break;
            }
        }
    }
}
