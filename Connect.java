import java.net.*;
import java.io.*;
import java.util.*;

public class Connect {

        public static void main(String[] args) throws IOException{
        /*Socket s = new Socket("www.google.com",80);
        if (!s.isConnected()){
            System.out.println("Error, Connection failed");
            System.exit(1);
        }
        PrintStream sout = new PrintStream(s.getOutputStream());
        Scanner sin = new Scanner(s.getInputStream());
        sout.print("GET / HTTP/1.0\r\n\r\n");
        while(sin.hasNext()){
            System.out.println(sin.nextLine());
        }
        s.close();*/
        ServerSocket ss = new ServerSocket(1234);
        Socket s;
        while(true){
            s=ss.accept();
            new ProcessClient(s).start();
        }
    }
}

class ProcessClient extends Thread{
    Socket s;
    ProcessClient(Socket snew){s = snew;}
    
    public void run(){
        try{
            Scanner sin = new Scanner(s.getInputStream());
            PrintStream sout = new PrintStream(s.getOutputStream());
            int i=0;
            sout.print("Give me line "+i+":");
            String input = sin.nextLine();
            while (!input.equalsIgnoreCase("EXIT")){                
                System.out.println(s.getInetAddress().toString()+":"+input);
                i++;
                sout.print("Give me line "+i+":");
                input = sin.nextLine();
            }
            s.close();
        }
        catch (IOException e){}
        
    }
}
