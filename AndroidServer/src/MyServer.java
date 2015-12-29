import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {
	private static String exePath = "C:\\Users\\Wild\\Desktop\\Compass\\CompassCamera\\bin\\Release\\Compass.exe";
	private static String exeFolder="C:\\Users\\Wild\\Desktop\\Compass\\CompassCamera\\bin\\Release\\";
	
 public static void main(String[] args) throws InterruptedException{
  ServerSocket serverSocket = null;
  Socket socket = null;
  DataInputStream dataInputStream = null;
  DataOutputStream dataOutputStream = null;
  
  try {
   serverSocket = new ServerSocket(8888);
   System.out.println("Listening :8888");
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  while(true){
   try {
    socket = serverSocket.accept();
    dataInputStream = new DataInputStream(socket.getInputStream());
    dataOutputStream = new DataOutputStream(socket.getOutputStream());
    System.out.println("ip: " + socket.getInetAddress());
    int flag = Integer.parseInt(dataInputStream.readUTF());
    System.out.println("Flag is now  "+flag);
    if (flag == 1){
    	System.out.println("Executing the exe... ");
    	Runtime.getRuntime().exec(exePath, null, new File(exeFolder));
    	//dataOutputStream.writeUTF("Data is recorded, Thank you :)");
		Thread.sleep(3500);
		System.out.println("Done... ");
    }
    //System.out.println("message: " + dataInputStream.readUTF());
    
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   finally{
    if( socket!= null){
     try {
      socket.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    if( dataInputStream!= null){
     try {
      dataInputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
    
    if( dataOutputStream!= null){
     try {
      dataOutputStream.close();
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
   }
  }
 }
}