package chat;
import java.awt.Checkbox;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
public class ex1 extends JFrame{//�α���ȭ��
	Image img = null;
	String IPP;
	public ex1()
	{
		JPanel p = new JPanel();
        p.setLayout(null);
        JLabel label = new JLabel(new ImageIcon("/Users/ogyutae/eclipse-workspace/자바프로젝트/src/chat/image/ㅎ.png"));
		add(label);

		Label ID_L= new Label("ID:");
		add(ID_L);
		Label PWD_L= new Label("PWD:");
		add(PWD_L);
		Label IP_L= new Label("IP:");
		add(IP_L);
		TextField ID_T = new TextField();
		add(ID_T);
		TextField PWD_T = new TextField();
		add(PWD_T);
		TextField IP_T = new TextField();
		add(IP_T);
		
		PWD_T.setEchoChar('*');
		JButton Login = new JButton("로그인");
		add(Login);
		JButton NEW = new JButton("회원가입");
		add(NEW);
		
		Checkbox id_save = new Checkbox("ID저장");
		add(id_save);
		Checkbox lo_save = new Checkbox("로그인 유지");
		add(lo_save);
		
		label.setBounds(10, 5, 350, 255);
		
		ID_L.setBounds(40,350,50,20);
		ID_T.setBounds(85,350,220,20);
		
		PWD_L.setBounds(40,380,50,20);
		PWD_T.setBounds(85,380,220,20);
		
		IP_L.setBounds(40,410,50,20);
		IP_T.setBounds(85,410,220,20);
		
		Login.setBounds(85, 480, 220, 50);
		NEW.setBounds(85, 320, 80, 20);
		
		id_save.setBounds(85, 410, 80, 20);
		lo_save.setBounds(224, 410, 80, 20);
		
		add(p);
		setSize(400, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면");
		setVisible(true);
		IP_T.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//ȸ������â���� �̵�
				// TODO Auto-generated method stub
				IPP = IP_T.getText();
			}
		});;
		NEW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//ȸ������â���� �̵�
				// TODO Auto-generated method stub
				ex2 f2= new ex2();
			}
		});;
		Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {//�α��� �Ҷ� 
				// TODO Auto-generated method stub
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("회원명단.txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
						for(String i : array) {
							System.out.println(i+"p");
						}
						System.out.println(array[0]);
						System.out.println(array[1]);
						System.out.println(array[2]);
						System.out.println(ID_T.getText());
						System.out.println(PWD_T.getText());
						if(ID_T.getText().equals(array[array.length-2])&&PWD_T.getText().equals(array[array.length-1]) || PWD_T.getText().equals(array[array.length-1])&&ID_T.getText().equals(array[array.length-2]))
						{
							JOptionPane.showMessageDialog(null,"로그인이 되었습니다!");
							client a = new client(IPP);
							a.serverConnection();
							IPP = "";
							bos.close();
							dispose();
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "로그인 실패");
							bos.close();
						}
					}
					bos.close();
					///dispose();
				}catch (IOException E10){
					E10.printStackTrace();
				}
			}
		});
	}
}

