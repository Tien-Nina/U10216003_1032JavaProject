import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	
	//資料存放
	private String number = "";
	private double sum1 = 0;
	private double sum2 = 1;
	private JButton n1 = new JButton("1");
	private JButton n2 = new JButton("2");
	private JButton n3 = new JButton("3");
	private JButton plus = new JButton("+");
	private JButton n4 = new JButton("4");
	private JButton n5 = new JButton("5");
	private JButton n6 = new JButton("6");
	private JButton minus = new JButton("-");
	private JButton n7 = new JButton("7");
	private JButton n8 = new JButton("8");
	private JButton n9 = new JButton("9");
	private JButton times = new JButton("*");
	private JButton n0 = new JButton("0");
	private JButton dot = new JButton(".");
	private JButton equal = new JButton("=");	
	private JButton divide = new JButton("/");
	private JTextField result = new JTextField();
	private JButton ac = new JButton("AC");
	
	//main method
	public static void main(String[] args){	
		Password frame = new Password();
		frame.setTitle("Password");
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	
	public Calculator(){
	
	//放入數字鍵與功能鍵
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,4));
		p1.add(n1);
		p1.add(n2);
		p1.add(n3);
		p1.add(plus);
		p1.add(n4);
		p1.add(n5);
		p1.add(n6);
		p1.add(minus);
		p1.add(n7);
		p1.add(n8);
		p1.add(n9);
		p1.add(times);
		p1.add(n0);
		p1.add(dot);
		p1.add(equal);
		p1.add(divide);
		
		//放入執行結果與歸零的按鍵
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,2));
		p2.add(result);
		p2.add(ac);
		
		//把p1跟p2做版面配置
		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(p2,BorderLayout.NORTH);
		p3.add(p1,BorderLayout.CENTER);
		
		add(p3);
		
		//按鈕的動作監聽
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		n4.addActionListener(this);
		n5.addActionListener(this);
		n6.addActionListener(this);
		n7.addActionListener(this);
		n8.addActionListener(this);
		n9.addActionListener(this);
		n0.addActionListener(this);
		dot.addActionListener(this);
		
		//"+"的動作監聽
		plus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				result.setText(number + " + ");
				sum1 = sum1 + Double.parseDouble(number);
				number = "";
				
				//"="的動作監聽		
				equal.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						sum1 = sum1 + Double.parseDouble(number);
						number = "";
						result.setText(sum1 + "");
					}
				});
			}
		});
		
		//"-"
		minus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				result.setText(number + " - ");
				sum1 = Double.parseDouble(number);
				number = "";
				
				//"="
				equal.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						sum1 = sum1 - Double.parseDouble(number);
						number = "";
						result.setText(sum1 + "");
					}			
				});
			}			
		});
		
		//"*"
		times.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				result.setText(number + " * ");
				sum2 = sum2 * Double.parseDouble(number);
				number = "";
				
				//"="		
				equal.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						sum2 = sum2 * Double.parseDouble(number);
						number = "";
						result.setText(sum2 + "");
					}			
				});
			}			
		});
		
		//"/"
		divide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				result.setText(number + " / ");
				sum2 = Double.parseDouble(number);
				number = "";
				//"="		
				equal.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						sum2 = sum2 / Double.parseDouble(number);
						number = "";
						result.setText(sum2 + "");
					}			
				});
			}			
		});
		
		//清空
		ac.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				number = "";
				sum1 = 0;
				sum2 = 1;
				result.setText(number);
			}			
		});
		
	}
	
	//數字鍵與dot的動作監聽
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == n1){
			number = number + "1";
			result.setText(number);
		}else if(e.getSource() == n2){
			number = number + "2";
			result.setText(number);
		}else if(e.getSource() == n3){
			number = number + "3";
			result.setText(number);
		}else if(e.getSource() == n4){
			number = number + "4";
			result.setText(number);
		}else if(e.getSource() == n5){
			number = number + "5";
			result.setText(number);
		}else if(e.getSource() == n6){
			number = number + "6";
			result.setText(number);
		}else if(e.getSource() == n7){
			number = number + "7";
			result.setText(number);
		}else if(e.getSource() == n8){
			number = number + "8";
			result.setText(number);
		}else if(e.getSource() == n9){
			number = number + "9";
			result.setText(number);
		}else if(e.getSource() == n0){
			number = number + "0";
			result.setText(number);
		}else if(e.getSource() == dot){
			number = number + ".";
			result.setText(number);
		}
	}
	
}


class Password extends JFrame{
	
	//資料存放
	private JTextField jpassword = new JTextField(8);
	private JButton enter = new JButton("Enter");
	private JLabel wrong = new JLabel();
	private String password = "0000";
	
	public Password(){
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		add(new JLabel("Enter the password:"));
		add(jpassword);
		add(enter);
		add(wrong);		
		
		//enter的動作監聽
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(jpassword.getText().equals(password)){			
				
				//產生Calculator的界面
					Calculator frame = new Calculator();
					frame.setTitle("Caculator");
					frame.setSize(300,200);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);					
				}else{
				
				//顯示錯誤訊息
					wrong.setText("wrong password");
				}
			}
		});
		
	}
	
}
