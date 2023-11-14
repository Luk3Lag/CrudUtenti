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
        loggato=false; 
    }



      
    
}