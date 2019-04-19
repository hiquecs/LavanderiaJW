package jwView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientesCadastrados extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea; 
	private JTextField codCliente;

	public ClientesCadastrados() {
		setTitle("Clientes");
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jw.jpg")));
		setBounds(100, 100, 1031, 814);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Clientes Cadastrados");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 23));
		lblNewLabel.setBounds(358, 38, 285, 31);
		contentPanel.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		textArea.setFont(new Font("Calibri Light", Font.BOLD, 15));
		textArea.setEditable(false);
		JScrollPane st = new JScrollPane(textArea);
		st.setBounds(155, 150, 701, 396);
		contentPanel.add(st);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setForeground(new Color(0, 0, 205));
		cancelar.setFont(new Font("Broadway", Font.PLAIN, 11));
		cancelar.setBackground(new Color(255, 0, 0));
		cancelar.setBounds(747, 637, 121, 40);
		contentPanel.add(cancelar);
		
		JButton editar = new JButton("Editar");
	    editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer num = null;	
				try {
			    num = Integer.parseInt(codCliente.getText());
				}catch(Exception  es) {
				JOptionPane.showMessageDialog(null,"Codigo do Cliente invalido","Erro", JOptionPane.ERROR_MESSAGE,null);
				codCliente.setText("00000");
				}
				
		    if(num != 0) {
				
			}else {
				JOptionPane.showMessageDialog(null,"Codigo do Cliente invalido","Erro", JOptionPane.ERROR_MESSAGE,null);
				codCliente.setText("00000");
			}
			
			}
		});
		editar.setForeground(new Color(0, 0, 205));
		editar.setFont(new Font("Broadway", Font.PLAIN, 11));
		editar.setBackground(new Color(34, 139, 34));
		editar.setBounds(747, 571, 121, 40);
		contentPanel.add(editar);
		
		try {
			javax.swing.text.MaskFormatter quant = new javax.swing.text.MaskFormatter("#####");
			codCliente = new javax.swing.JFormattedTextField(quant);
			codCliente.setHorizontalAlignment(SwingConstants.CENTER);
			codCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			codCliente.setBounds(639, 574, 86, 31);
			contentPanel.add(codCliente);
	        codCliente.setText("00000");
			codCliente.setColumns(10);	
		} catch (Exception e) {
		}
		
		JLabel lblDigiteOCodigo = new JLabel("Digite o codigo do Cliente Para edit\u00E1-lo :");
		lblDigiteOCodigo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDigiteOCodigo.setForeground(new Color(0, 0, 205));
		lblDigiteOCodigo.setBounds(371, 577, 260, 22);
		contentPanel.add(lblDigiteOCodigo);

	}
}