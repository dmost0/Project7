import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUIDriver extends JFrame implements ActionListener{
	String[] standardA;
	String[] holidayA;
	JTextField tlnf; 
	JTextField tfnf; 
	JTextField tstrf; 
	JTextField tcityf; 
	JTextField tstatef; 
	JTextField tzipf;
	JTextField totalCost;
	
	JTextField flnf;
	JTextField ffnf; 
	JTextField fstrf; 
	JTextField fcityf;
	JTextField fstatef; 
	JTextField fzipf;
	JTextField msg;
	
	JRadioButton s;
	JRadioButton m;
	JRadioButton l;
	JRadioButton standard; 
	JRadioButton holiday;
	JCheckBox before;
	
	JComboBox box;
	OrderManager orderM;
	
	public static void main(String[] args)
	{
		new GUIDriver();
	}
	
	public GUIDriver()
	{
		standardA = new String[3];
		holidayA = new String[2];
		standardA[0] = "May 8";
		standardA[1] = "May 9";
		standardA[2] = "May 10";
		holidayA[0] = "May 11";
		holidayA[1] = "May 12";
		orderM = new OrderManager();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));
		setSize(557,685);
		setResizable(false);
		buildGUI();
		

		
		this.setVisible(true);
	}

	private void buildGUI() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		JPanel to  = new JPanel();
		JPanel from = new JPanel();
		JPanel b = new JPanel();
		JPanel message = new JPanel();
		JPanel delivery = new JPanel();
		JPanel total = new JPanel();
		JPanel b1 = new JPanel();
		JPanel b2 = new JPanel();
		JPanel b3 = new JPanel();
		
		
		to.setSize(100, 3000);
		to.setLayout(new GridLayout(0,2));
		to.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "To"));
		from.setSize(100,80);
		from.setLayout(new GridLayout(0,2));
		from.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "From"));
		b.setSize(100,30);
		b.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "Buoquet Size"));
		message.setSize(100,30);
		message.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "Message"));
		delivery.setSize(100,60);
		delivery.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "Delivery Options"));
		total.setSize(100,30);
		total.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.lightGray,1), "Total Cost"));
		b1.setSize(100,30);
		b2.setSize(100,30);

		
		JLabel tln = new JLabel("Last Name");
		JLabel tfn = new JLabel("First Name");
		JLabel tstr = new JLabel("Street");
		JLabel tcity = new JLabel("City");
		JLabel tstate = new JLabel("State");
		JLabel tzip = new JLabel("ZIP");
		
		JLabel fln = new JLabel("Last Name");
		JLabel ffn = new JLabel("First Name");
		JLabel fstr = new JLabel("Street");
		JLabel fcity = new JLabel("City");
		JLabel fstate = new JLabel("State");
		JLabel fzip = new JLabel("ZIP");
		
		
		tlnf =  new JTextField("Last Name");
		tfnf =  new JTextField("First Name");
		tstrf =  new JTextField("Street");
		tcityf =  new JTextField("City");
		tstatef =  new JTextField("State");
		tzipf =  new JTextField("ZIP");
		
		flnf =  new JTextField("Last Name");
		ffnf =  new JTextField("First Name");
		fstrf =  new JTextField("Street");
		fcityf =  new JTextField("City");
		fstatef =  new JTextField("State");
		fzipf =  new JTextField("ZIP");
		
		
		to.add(tln);
		to.add(tlnf);
		to.add(tfn);
		to.add(tfnf);
		to.add(tstr);
		to.add(tstrf);
		to.add(tcity);
		to.add(tcityf);
		to.add(tstate);
		to.add(tstatef);
		to.add(tzip);
		to.add(tzipf);
		
		
		from.add(fln);
		from.add(flnf);
		from.add(ffn);
		from.add(ffnf);
		from.add(fstr);
		from.add(fstrf);
		from.add(fcity);
		from.add(fcityf);
		from.add(fstate);
		from.add(fstatef);
		from.add(fzip);
		from.add(fzipf);
		
		
		
		
		
		
		
		
		s = new JRadioButton("Small - $19");
		m = new JRadioButton("medium - $35");
		l = new JRadioButton("Large - $49");
		ButtonGroup g = new ButtonGroup();
		s.setSelected(true);
		g.add(s);
		g.add(m);
		g.add(l);
		b.add(s);
		b.add(m);
		b.add(l);
		
		msg = new JTextField("Type Message Here");
		message.add(msg);
		
		standard = new JRadioButton("Standard");
		holiday = new JRadioButton("Holiday");
		holiday.addActionListener(this);
		standard.addActionListener(this);
		standard.setSelected(true);
		ButtonGroup g2 = new ButtonGroup();
		g2.add(standard);
		g2.add(holiday);
		before = new JCheckBox();
		before.setActionCommand("before");
		before.addActionListener(this);
		JLabel bNoon = new JLabel("Before Noon");
		JLabel date = new JLabel("Delivery Date");
		box = new JComboBox(standardA);
		delivery.add(standard);
		delivery.add(holiday);
		delivery.add(before);
		delivery.add(bNoon);
		delivery.add(box);
		delivery.add(date);
		
		totalCost = new JTextField(15);
		totalCost.setEditable(false);
		total.add(totalCost);
		
		JButton submit = new JButton("Submit Order");
		JButton print = new JButton("Print Message Cards");
		JButton deliverySchedule = new JButton("Delivery Schedule");
		JButton clear = new JButton("Clear");
		JButton exit = new JButton("Exit");
		submit.setActionCommand("submit");
		print.setActionCommand("print");
		deliverySchedule.setActionCommand("delivery");
		clear.setActionCommand("clear");
		exit.setActionCommand("exit");
		
		submit.addActionListener(this);
		print.addActionListener(this);
		deliverySchedule.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);
		
		b1.add(submit);
		b1.add(print);
		b2.add(deliverySchedule);
		b2.add(clear);
		b2.add(exit);
		
		
		this.add(to);
		this.add(from);
		this.add(b);
		this.add(message);
		this.add(delivery);
		this.add(total);
		this.add(b1);
		this.add(b2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("submit")){
			int size, ship;
			if(s.isSelected())
				size = 1;
			else if(m.isSelected())
				size = 2;
			else
				size = 3;
			if(standard.isSelected())
				ship = 1;
			else
				ship = 2;
			orderM.addOrder(tlnf.getText(), tfnf.getText(), tstrf.getText(),  tcityf.getText(),
					 tstatef.getText(), Integer.parseInt(tzipf.getText()),  flnf.getText(),  ffnf.getText(),
					 fstrf.getText(),  fcityf.getText(),  fstatef.getText(), Integer.parseInt(fzipf.getText()),
					before.isSelected(),  box.getSelectedItem().toString(), ship, size ,  msg.getText());
		}
		else if(e.getActionCommand().equals("print")){
			JOptionPane.showMessageDialog(this, orderM.printMessageCards());
		}
		else if(e.getActionCommand().equals("delivery")){
			JOptionPane.showMessageDialog(this,orderM.deliverySchedule());
		}
		else if(e.getActionCommand().equals("clear")){
			
			tlnf.setText(""); 
			tfnf.setText(""); 
			tstrf.setText(""); 
			tcityf.setText(""); 
			tstatef.setText(""); 
			tzipf.setText("");
			flnf.setText("");
			ffnf.setText(""); 
			fstrf.setText(""); 
			fcityf.setText("");
			fstatef.setText(""); 
			fzipf.setText("");
		}
		else if(e.getActionCommand().equals("exit")){
			setVisible(false);
			dispose();
		}
		else{
			if(holiday.isSelected()){
				box.removeAllItems();
				for(int i = 0; i < holidayA.length; i++){
					box.insertItemAt(holidayA[i], i);
				}
			}
			else{
				box.removeAllItems();
				for(int i = 0; i < standardA.length; i++){
					box.insertItemAt(standardA[i], i);
				}
			}
				
		}

		
	}
	
	

}
