import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Picture extends JFrame{
	Picture(String title){
		super(title);
		setLayout(new FlowLayout());
	}
	
	public static void makeNewWindow(String makePic,String title){
		Picture pic = new Picture(title);
		
		pic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pic.setSize(300,300);
		pic.setVisible(true);
		pic.add(new JLabel(new ImageIcon(makePic)));
		
		SwingUtilities.updateComponentTreeUI(pic);
	}
}
//we will want to add something where it wont make it so that you could indefinitely make windows, i feel like ms gerb would try that haaha
//not sure where to put that tho