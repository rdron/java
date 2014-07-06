/**
*There are two indepemdent threads running in the program
*- one which increments and prints the counter continiously
*- second which waits for a user input and reinitiates the counter value
*/

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ron
 */
public class ThreadExample {
    static int x=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread a = new Thread(){
            public void run(){
                while(true){
                    System.out.println(x++);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThreadExample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        a.start();
        Thread b = new Thread(){
            public void run(){
                while(true){
                    Scanner in = new Scanner(System.in);
                    x=in.nextInt();
                    System.out.println("Value Changed");
                }
            }
        };
        b.start();
    }
    
}
