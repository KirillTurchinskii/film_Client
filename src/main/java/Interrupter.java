import java.util.Scanner;

public class Interrupter extends Thread {

  public Interrupter() {
    setDaemon(true);
    System.out.println("Press Enter to quit");
  }

  @Override public void run() {
    Scanner keyboard = new Scanner(System.in);
    while (Data.isParsing) {
      String input = keyboard.nextLine();
      if (input != null) {
        System.out.println("Exit program");
        Data.isKeyPressed = true;
      }
    }
    keyboard.close();
  }

}

