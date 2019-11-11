import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataStructsFrame extends JFrame {
	int [] inputs1;
	int [] inputs2;
	
	public DataStructsFrame(String title, int[] numbers, int[] numbers2) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		ArrayList<ListItem> list = arrayToList(numbers,numbers2);

		ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort List 1");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton sortButton2 = new JButton("Sort List 2");
		sortButton2.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				sortButton.setEnabled(false);
				pack();
			}
		});
		
		sortButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list);
				Collections.reverse(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				sortButton2.setEnabled(false);
				pack();
			}
		});

		JTextField textfield = new JTextField();
		JButton addButton = new JButton("Add Numbers");
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textfield.getText();
				String[] text1 = text.split(" ");
				inputs1 = new int[1];
				inputs2 = new int [1];
				for(int i=0; i < text1.length;i++) {
					if(i == 0) {
						inputs1[0] = Integer.parseInt(text1[i]);
					}
					else {
						inputs2[0] = Integer.parseInt(text1[i]);
					}
				}
				ArrayList<ListItem> nums = new ArrayList<ListItem>();
				ListItem li = new ListItem(inputs1[0],inputs2[0]);
				nums.add(li);
				unorderedList.addItems(nums);
				orderedList.addItems(nums);
			}
			
		});
		
		panel.add(unorderedList);
		panel.add(sortButton);
		panel.add(sortButton2);
		panel.add(textfield);
		panel.add(addButton);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(int[] numbers, int[] numbers2) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i],numbers2[i]);
			list.add(item);
		}
		return list;
	}
	
}
