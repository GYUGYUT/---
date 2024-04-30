package chat;

//ChatGuiServer.java

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
* 멀티 채팅을 위한 서버 구성
*/
public class gui {
/**
 *  필요한 Field 선언  
 */
ServerSocket server;
Socket sk;
ArrayList<server> list = new ArrayList<server>();

/*
 * ServerSocket을 생성하여 client 접속 대할 생성자
 */
public gui(){ //생성자
    try {
        server = new ServerSocket(7776);
        while(true){
            System.out.println("\nClient접속이 대기중입니다.");
            sk = server.accept(); // 클라이언트 접속 대기중
            System.out.println(sk.getInetAddress()+"의 주소가 연결되었습니다. ");
           
            //접속된 클라이언트를 스레드로 만들어 ArrayList에 추가
            server st = new server(this);
            addThread(st); //ArrayList 에 추가하기
            st.start(); //쓰레드 시작하기                    
       
        } //while문 끝
    } catch (IOException e) {
        System.out.println(e + " -> ServerSocket fil");
    }
}//생성자 끝

/**
 * 접속된 클라이언트를 저장하기
 */
public void addThread(server st){
        list.add(st);  //추가
}

/**
 * 접속이 끊긴 클라이언트를 ArrayList에 제거하기
 **/
public void removeThread(server st){
        list.remove(st); //제거
}

/**
 * 접속된 각각의 클라이언트에게 데이터 전송하기.
 */
public void broadCast(String message){
   
    for(server st : list){
        st.pw.println(message);
    }              
}


public static void main(String[] args) {
    new gui();
   
}

} //클래스 끝
