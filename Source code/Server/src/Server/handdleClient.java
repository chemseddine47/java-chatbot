
package Server;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class handdleClient implements Runnable{
    //********variables********//
    private Socket client;
    private BufferedReader in;
    private PrintWriter pr;
    private String User;
    private static final String connect = "¿con:";
    private static final String disconnect = "¿dis:";
    private static final String err = "¿err:";
    private boolean isRunning= false;
    //**************************//
    
    //******class constructor******//
    public handdleClient(Socket cli){
        try{
            this.client = cli;
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pr = new PrintWriter(client.getOutputStream(),true);
            isRunning = true;
        }catch(IOException ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
    }
    
    //******Overrided methode run()*****//
    @Override
    public void run() {
        try{
            while(isRunning){
                //***read the message sent by client***//
                String clientMesg = in.readLine(); 
                //**check if the message is a command else it will be sent to others**//
                if(!isCommand(clientMesg)){
                    BroadcastToall(this.User+": "+clientMesg); 
                } 
            }
        }catch(IOException ex){JOptionPane.showMessageDialog(null, ex.getMessage());}  
        finally{
            try {
                in.close();
            } catch (IOException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
    
    //*******Controle methodes******//
    private boolean isCommand(String msg){
        if(msg.startsWith(connect)){
            this.User= msg.substring(msg.indexOf(":")+1);
            if(UserExist(this.User)){
                 pr.println(err+"User already existe");
                 return true;
            }else{
                BroadcastToall(this.User+" has joint the chat");
                 return true;
            }
        }
        else if(msg.startsWith(disconnect)){
            Disconnect();
            return true;
        }
        else if(msg.startsWith(err)){
            DisconnectError();
            return true;
        }
        return false;
    }
    private void Disconnect(){
        try {
            ServerGui.DashList.append("["+LocalTime.now()+"]"+"  IP:"+client.getInetAddress().toString().replace("/","")+" PORT:"+client.getPort()+" Disconnected!\n");
            isRunning = false;
            this.in.close();
            this.pr.close();
            this.client.close();
            BroadcastToall(this.User+" left the chat");
            removeFromList(this);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    private void DisconnectError(){
        try {
            isRunning = false;
            this.in.close();
            this.pr.close();
            this.client.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    private boolean UserExist(String user){
        for (handdleClient aclient: ServerGui.clients){
                if(!(aclient==this) && aclient.User.toLowerCase().equals(user.toLowerCase())){
                    return true;
                }
            }
        return false;
    } 
    private void BroadcastToall(String msg){
        for (handdleClient aclient: ServerGui.clients){
            aclient.pr.println(msg);
        }
    }
    private void removeFromList(handdleClient so){
        
        ServerGui.clients.removeIf(aclient -> aclient == so);
          /*for (handdleClient aclient: ServerGui.clients){   
            if (aclient.client == so){
                ServerGui.clients.remove(aclient);
            }            
        }*/
    }
    //*******************************//
    
}
