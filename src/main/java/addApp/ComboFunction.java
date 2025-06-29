package addApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.MainFunction;
import app.Student;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ComboFunction extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox listCombo2;
	private JButton btnLoad;
	private MainFunction mainFunction;
	private List<Student> list;
	private JButton btnReturn;

	public void setList(List<Student> list) {
		this.list = list;
	}

	public void setMainFunction(MainFunction mainFunction) {
		this.mainFunction = mainFunction;
	}

	/**
	 * Launch the application.
	 */
	
	
	public static void main(List<Student> list) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboFunction frame = new ComboFunction();
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
	public ComboFunction() {
		setTitle("sub frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listCombo2 = new JComboBox();
		listCombo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleListCombo2ActionPerformed(e);
			}
		});
		listCombo2.setBounds(45, 42, 101, 21);
		contentPane.add(listCombo2);
		
		btnLoad = new JButton("loading");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnLoadActionPerformed(e);
			}
		});
		btnLoad.setBounds(179, 42, 85, 21);
		contentPane.add(btnLoad);
		
		btnReturn = new JButton("return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleBtnReturnActionPerformed(e);
			}
		});
		btnReturn.setBounds(42, 102, 85, 21);
		contentPane.add(btnReturn);

	}


	protected void handleListCombo2ActionPerformed(ActionEvent e) {
//		var model = new DefaultComboBoxModel<Student>();
//		model.addAll(list);
//		listCombo2.setModel(model);
//		listCombo2.setSelectedIndex(0);
	}
	
	protected void handleBtnLoadActionPerformed(ActionEvent e) {
		var model = new DefaultComboBoxModel<Student>();
		model.addAll(list);
		listCombo2.setModel(model);
		listCombo2.setSelectedIndex(0);
		
	}
	protected void handleBtnReturnActionPerformed(ActionEvent e) {
		this.dispose();
		mainFunction.setVisible(true);
		var a = new ComboFunction();
	}
}
