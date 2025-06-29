package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import addApp.ComboFunction;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainFunction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox twoComboBox;
	private JButton btnListComboBox;
	private JComboBox<Student> comboBoxStu;
	private JButton btnAddListStu;
	private JButton btnPassData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFunction frame = new MainFunction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFunction() {
		setTitle("Compo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"one ", "two", "three"}));
		comboBox.setBounds(91, 38, 131, 21);
		contentPane.add(comboBox);
		
		twoComboBox = new JComboBox();
		twoComboBox.setBounds(90, 92, 132, 21);
		contentPane.add(twoComboBox);
		
		btnListComboBox = new JButton("add list");
		btnListComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnListComboBoxActionPerformed(e);
			}
		});
		btnListComboBox.setBounds(233, 92, 85, 21);
		contentPane.add(btnListComboBox);
		
		comboBoxStu = new JComboBox();
		comboBoxStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleComboBoxStuActionPerformed(e);
			}
		});
		comboBoxStu.setBounds(91, 146, 131, 21);
		contentPane.add(comboBoxStu);
		
		btnAddListStu = new JButton("add list student");
		btnAddListStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnAddListStuActionPerformed(e);
			}
		});
		btnAddListStu.setBounds(233, 146, 131, 21);
		contentPane.add(btnAddListStu);
		
		btnPassData = new JButton("pass data load");
		btnPassData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnPassDataActionPerformed(e);
			}
		});
		btnPassData.setBounds(90, 198, 295, 21);
		contentPane.add(btnPassData);
		

	}
	protected void handleBtnListComboBoxActionPerformed(ActionEvent e) {
		//c1
//		var model = new DefaultComboBoxModel();
//		model.addElement("first");
//		model.addElement("one");
//		model.addElement(".....");
//		twoComboBox.setModel(model);
//		twoComboBox.setSelectedIndex(1);
//		
		//c2
		List<String> list = List.of("1", "2", "3");
		var model2 = new DefaultComboBoxModel(list.toArray());
//		model2.addAll(list);
		twoComboBox.setModel(model2);
	}
	protected void handleBtnAddListStuActionPerformed(ActionEvent e) {
		List<Student> list2 = List.of(
				new Student(1, "vu", true),
				new Student(2, "hong", false),
				new Student(3, "dao", false)
				);
		var model3 = new DefaultComboBoxModel(list2.toArray());
//		model2.addAll(list);
		comboBoxStu.setModel(model3);
		
	}
	protected void handleComboBoxStuActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
				((Student)comboBoxStu.getSelectedItem()).getId(),
				"thong tin sinh vien", JOptionPane.INFORMATION_MESSAGE
				);
	}
	protected void handleBtnPassDataActionPerformed(ActionEvent e) {
		List<Student> list3 = List.of(
				new Student(1, "vu", true),
				new Student(2, "hong", false),
				new Student(3, "dao", false)
				);
		var comboFunction = new ComboFunction();
		comboFunction.setList(list3);
		comboFunction.setVisible(true);
		comboFunction.setMainFunction(this);
		this.setVisible(false);
	}
}
