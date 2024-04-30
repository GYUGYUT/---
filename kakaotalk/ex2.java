package chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.*;
import java.awt.*;
public class ex2 extends JFrame {//ȸ������ȭ��
	public ex2(){
		  	JPanel p = new JPanel();
	        Label l2 = new Label("id:");
	        Label l3= new Label("패스워드:");

	        add(l2);
	        add(l3);

	        TextField t2 = new TextField();
	        TextField t3 = new TextField();
	        add(t2);
	        add(t3);
	        t3.setEchoChar('*');
	        JButton j1 = new JButton("저장");
	        JButton j2 = new JButton("취소");
	        add(j1);
	        add(j2);
	        l2.setBounds(40, 50, 40, 40);
	        l3.setBounds(40,90,60,40);
	        t2.setBounds(120, 50, 280, 30);
	        t3.setBounds(120, 90, 280, 30);
	        j1.setBounds(125, 330, 80, 30);
	        j2.setBounds(240, 330, 80, 30); 
	    add(p);
		setSize(500,500);
		setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       j1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
			try{
				BufferedWriter bos = new BufferedWriter(new FileWriter("회원명단.txt",true));
				bos.write(t2.getText()+"/");
				bos.write(t3.getText()+"/");
				bos.close();
				JOptionPane.showMessageDialog(null, "회원가입을 축하합니다!!");
				dispose();
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
			}
		}
	});
       j2.addActionListener(new ActionListener() {
   		@Override
   		public void actionPerformed(ActionEvent T) {//회원가입 데이터 저장
   			try{
   				dispose();
   			}catch (Exception ex){
   				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
   			}
   		}
   	});
	}    
}

