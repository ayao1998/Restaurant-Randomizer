import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



/**
 * make a list of places to eat and sort via jFrame and also randomize
 * @author Aaron
 *
 */
public class app {
	
	public static void main(String args[])
	{
		//INPUT FROM TXT FILE
		
		ArrayList<String> data = new ArrayList<String>();
		Scanner filein;
		java.io.File file = new java.io.File("food.txt");
		try
		{
			filein = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Can't open input file");
			System.out.println();
			return;
		}
		String temp;
		while (filein.hasNext())
		{
			temp = filein.nextLine();
			data.add(temp);
		}
		
		filein.close();

		
		
		
		//JFRAME
		JFrame frame = new JFrame("Let's get food");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 325);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JButton viewAll = new JButton("View list");
		viewAll.setBounds(25, 25, 525, 100);
		viewAll.setFont(new Font("Calibri", Font.PLAIN, 40));
		frame.add(viewAll);
		viewAll.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			JFrame listPlaces = new JFrame("All places");
			listPlaces.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			listPlaces.setSize(600, 400);
			listPlaces.setLocationRelativeTo(null);
			listPlaces.setVisible(true);
			JList<String> myList = new JList(data.toArray());
			//listPlaces.setFont( new Font("monospaced", Font.PLAIN, 40) );
	        
			myList.setFont(new Font("Calibri", Font.PLAIN, 20));
			JPanel mypanel = new JPanel();  //create a new panel
			mypanel.add(myList); //add list to panel
			JScrollPane scroll = new JScrollPane(mypanel); //create a scrollpane with the panel
			listPlaces.add(scroll); //add the scrollpane to the frame
			
			
		}
		});
		
		JButton random = new JButton("Random");
		random.setBounds(25, 150, 525, 100);
		random.setFont(new Font("Calibri", Font.PLAIN, 40));
		frame.add(random);
		random.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame result = new JFrame("bone apple teeth!");
				result.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				result.setSize(300, 100);
				result.setLocationRelativeTo(null);
				result.setVisible(true);
				int random = (int)(Math.random() * data.size());
				JLabel destination = new JLabel(data.get(random), SwingConstants.CENTER);
				destination.setFont(new Font("Calibri", Font.PLAIN, 40));
				result.add(destination);
				
			}
		});
		
		
	}
	
		
	
	
}
