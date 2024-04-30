package chat;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame{
	/*버튼생성*/
	/*그려주기*/
	//static Image background = new ImageIcon(Main.class.getResource("../src/chat/image/background.png")).getImage();//배경이미지
	//생성자 
	String ID;
	String PWD;
	String IP;
	public Main() {
		JButton Login_btn=new JButton("Login");
		Login_btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				client a = new client(IP);
				a.serverConnection();
			}
			
		});
		// Login Button
		Login_btn.setLayout(null);//레이아웃
		Login_btn.setBounds(85, 480, 220, 50);//위치, 크기 
		//b1.setBackground(Color.blue);
		//b1.setForeground(Color.WHITE);
		add(Login_btn);//프레임에 추가 
		
		// ID & PW TextField
		Label IDlabel = new Label("ID : ",Label.RIGHT);
		TextField tf1 = new TextField(); //생성, 초기화 및 텍스트가 나올 상자의사이즈 지정
		tf1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ID = tf1.getText();
				System.out.print(ID);
			}
		});
		
		Label PWDlabel = new Label("PWD : ",Label.RIGHT);
		TextField tf2 = new TextField(); //생성, 초기화 및 텍스트가 나올 상자의사이즈 지정
		tf2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PWD = tf2.getText();
			}
		});
		
		Label IPlabel = new Label("IP : ",Label.RIGHT);
		TextField tf3 = new TextField(); //생성, 초기화 및 텍스트가 나올 상자의사이즈 지정
		tf3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IP = tf3.getText();
			}
		});
		
		tf1.selectAll();   //아이디의 입력된 모든 문자열 선택가능 
		tf2.selectAll();   //아이디의 입력된 모든 문자열 선택가능 
		tf3.selectAll();   //아이디의 입력된 모든 문자열 선택가능
		
		IDlabel.setBounds(40,350,50,20);
		PWDlabel.setBounds(40,380,50,20);
		IPlabel.setBounds(40,410,50,20);
		
		//tf2.setEchoChar('*');  //비밀번호의 입력을 *모양으로 표시되도록 설정
		tf1.setBounds(85,350,220,20);
		tf2.setBounds(85,380,220,20);
		tf3.setBounds(85,410,220,20);
		
		add(IDlabel);
		add(tf1);     //아이디 입력창을 패널에 추가 
		
		add(PWDlabel);
		add(tf2);     //비밀번호 입력창을 패널에 추가
		
		add(IPlabel);
		add(tf3);//IP 입력창을 패널에 추
		
		
		// CheckBox
		Checkbox cb1 = new Checkbox("회원가입");
		cb1.setBounds(85, 320, 80, 20);
		Checkbox cb2 = new Checkbox("ID저장");
		cb2.setBounds(85, 410, 80, 20);
		Checkbox cb3 = new Checkbox("로그인 유지");
		cb3.setBounds(224, 410, 80, 20);
		add(cb1);
		add(cb2);
		add(cb3);
		

		// Frame
		setSize(400,650);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게 
		setLayout(null);//레이아웃을 내맘대로 설가능하게 해줌.
		setVisible(true);//창이 보이게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
		
	}
	public void paint(Graphics g) {//그리는 함
		//g.drawImage(background, 0, 0, null);//background를 그려
		//paintComponents(g);//add로 추가해준부분을 그려
	}
	/*메인함수*/
	public static void main(String[] args){
		new Main();
	}
}