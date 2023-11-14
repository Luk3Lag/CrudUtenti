import java.util.Scanner;

public class Login{
    Utente utente;
    boolean accessoEseguito=false;
    int tentativi=0;
    boolean loggato= false;

   
    Scanner scanner= new Scanner(System.in);
     public void login(){
    
     while (tentativi<3 && accessoEseguito==false){
      System.out.println("Inserire l'username");
      String username= scanner.nextLine();
      System.out.println("Inserire la password:");
      String password= scanner.nextLine();
      tentativi++;
      
      for (Utente u: utenti){
        if (username.equals(u.getUsername) && password.equals(u.getPassword)){
            System.out.println("Accesso eseguito correttamente!");
            accessoEseguito=true;
            loggato= true;
        }
      }

      if (!accessoEseguito && tentativi<3){
        System.out.println("Username o password errati. Riprova. Ti rimangono "+ (3 - tentativi)+" tentativi.");
      }

      if (!accessoEseguito && tentativi==3){
        System.out.println("Spiacenti, hai sbagliato troppe volte l'username e/o la password. Prova ad accedere nuovamente tra 15 minuti.");
      }
     
     }  
    }

    public void logout(){
        System.out.println("Sicuro di voler uscire dalla sessione?");
        boolean scelta= false;
        while(!scelta){
        System.out.println("1. Si");
        System.out.println("2. No");

        int uscire=scanner.nextInt();
        if (uscire==1){
        loggato=false; 
        scelta=true;
        }

        else {
            System.out.println("Scelta inserita non valida. Riprova.");
        }
    }
    }



      
    
}