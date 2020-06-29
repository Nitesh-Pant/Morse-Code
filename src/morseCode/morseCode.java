package morseCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class morseCode {
	static String convert = "", converted = "";
	static String str = "<html>Morse Translator by Nitesh Pant <br>Note:<br>Morse code words are separated by: / <br>Press English>>Morse button to generate morse code</html>";
	public static void main(String[] args) {
		final LinkedHashMap<Character,String> map = new LinkedHashMap<Character,String>();
			map.put('a',".-");
			map.put('b',"-...");
			map.put('c',"-.-.");
			map.put('d',"-..");
			map.put('e',".");
			map.put('f',"..-.");
			map.put('g',"--.");
			map.put('h',"....");
			map.put('i',"..");
			map.put('j',".---");
			map.put('k',"-.-");
			map.put('l',".-..");
			map.put('m',"--");
			map.put('n',"-.");
			map.put('o',"---");
			map.put('p',".--.");
			map.put('q',"--.-");
			map.put('r',".-.");
			map.put('s',"...");
			map.put('t',"-");
			map.put('u',"..-");
			map.put('v',"...-");
			map.put('w',".--");
			map.put('x',"-..-");
			map.put('y',"-.--");
			map.put('z',"--..");
			map.put('1',".----");
			map.put('2',"..---");
			map.put('3',"...--");
			map.put('4',"....-");
			map.put('5',".....");
			map.put('6',"-....");
			map.put('7',"--...");
			map.put('8',"---..");
			map.put('9',"----.");
			map.put('0',"-----");
			
			JFrame frame=new JFrame("Morse Code");
			frame.setSize(600,700);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setLayout(null);
			
			final JLabel jl = new JLabel("English Text");
			jl.setBounds(10,110,100,10);
			
			final JLabel jl2 = new JLabel("Morse Code");
			jl2.setBounds(320,110,100,10);
			
			final JLabel jl3 = new JLabel(str);
			jl3.setBounds(10,10,500,100);
			
			final TextArea ta = new TextArea();
			ta.setBounds(10,150,270,400);
			
		/*	Font font = new Font("Segoe Script", Font.BOLD, 20);
	        ta.setFont(font);
	        ta.setForeground(Color.BLUE);
	      */  
			final TextArea ta2 = new TextArea();
			ta2.setBounds(300,150,270,400);
			
			JButton jb = new JButton("English>>Morse");
			jb.setBounds(10,580,130,50);
			
			JButton jb2 = new JButton("Clear Text");
			jb2.setBounds(200,580,130,50);
			
			JButton jb3 = new JButton("English<<Morse");
			jb3.setBounds(390,580,130,50);
			
			frame.add(ta);
			frame.add(ta2);
			frame.add(jb);
			frame.add(jb2);
			frame.add(jb3);
			frame.add(jl);
			frame.add(jl2);
			frame.add(jl3);
			
			jb.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					convert = ta.getText();
					convert = convert.toLowerCase();
					for(int i=0;i<convert.length();i++){
						if(convert.charAt(i)==' '){
							converted +=" / ";
						}
						else{
							converted += (map.get(convert.charAt(i))+" ");
						}
						
					}
					Font font = new Font("Segoe Script", Font.BOLD, 20);
			        ta2.setFont(font);
			        ta2.setForeground(Color.BLUE);
			        
					ta2.append(converted);
			
				}
			});
			
			jb2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					converted = "";
					convert = "";
					ta.setText(null);
					ta2.setText(null);
				}
			});
		
			
			jb3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					convert = ta2.getText();
					List<Character> lst = new ArrayList<Character>();
					
					for(int i=0;i<=convert.length();i++){
						if(i==convert.length() || convert.charAt(i)==' '){
							StringBuilder sb = new StringBuilder();
							for(Character ch : lst){
								sb.append(ch);
							}
							lst.removeAll(lst);
							String s = sb.toString();
							for(java.util.Map.Entry<Character, String> entry : map.entrySet()){
								if(entry.getValue().equals(s)){
									converted += entry.getKey();
								}
							}
						}
						else{
							lst.add(convert.charAt(i));
						}
					}
					Font font = new Font("Segoe Script", Font.BOLD, 20);
			        ta.setFont(font);
			        ta.setForeground(Color.BLUE);
					ta.setText(converted);
				}
			});

	}
	
}
