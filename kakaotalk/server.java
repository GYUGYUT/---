package chat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
class server extends Thread{
	 
	  gui server;
	  PrintWriter pw;
	  String name;
	  public server(gui server){
	      this.server = server;
	  }
	  @Override
	  public void run() {
	      try {
	      //읽기 준비
	      BufferedReader br= new BufferedReader(new InputStreamReader(server.sk.getInputStream()));
	     
	      //쓰기 준비
	      pw = new PrintWriter(server.sk.getOutputStream(),true);
	             
	      name = br.readLine(); //대화명 읽기
	     
	      server.broadCast("["+name+"]님 입장하셨습니다.");
	     
	      String data= null;
	      while((data = br.readLine()) != null){
	          server.broadCast("[ "+name+" ] "+ data);          
	      }
	     
	     
	     
	      } catch (Exception e) {
	          //현재 쓰레드를 ArrayList에 제거한다.
	          server.removeThread(this);
	          server.broadCast("[ "+name+" ] 님이 퇴장하셨습니다.");
	          System.out.println
	          (server.sk.getInetAddress()+"주소의 ["+name+" ] 님이 퇴장하셨습니다.");
	          System.out.println(e + "----> ");
	      }      
	     
	  }
	}
