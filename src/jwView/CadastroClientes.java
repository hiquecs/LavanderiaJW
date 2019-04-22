package jwView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jwDAO.ClienteDAO;
import jwModel.Cliente;

public class CadastroClientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nome;
	private JTextField cpf;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField email;
	private JTextField telefoneCelular;

	public CadastroClientes() {
		setTitle("Cadastro de Clientes");
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jw.jpg")));
		setBounds(100, 100, 1031, 814);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		nome.setBounds(228, 147, 535, 31);
		contentPanel.add(nome);
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 23));
		lblNewLabel.setBounds(324, 63, 340, 31);
		contentPanel.add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setForeground(new Color(0, 0, 128));
		lblNome.setBounds(106, 148, 112, 25);
		contentPanel.add(lblNome);

		JLabel lblEndereoCompleto = new JLabel("Endere\u00E7o Completo");
		lblEndereoCompleto.setForeground(new Color(0, 0, 128));
		lblEndereoCompleto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereoCompleto.setBounds(82, 265, 136, 25);
		contentPanel.add(lblEndereoCompleto);

		try {
			javax.swing.text.MaskFormatter cpfF = new javax.swing.text.MaskFormatter("###.###.###-##");
			cpf = new javax.swing.JFormattedTextField(cpfF);
			cpf.setFont(new Font("Tahoma", Font.BOLD, 11));
			cpf.setColumns(10);
			cpf.setBounds(228, 207, 535, 31);
			contentPanel.add(cpf);
		} catch (Exception e) {
		}

		endereco = new JTextField();
		endereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		endereco.setColumns(10);
		endereco.setBounds(228, 264, 535, 31);
		contentPanel.add(endereco);

		try {
			javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("(##)####-####");
			telefone = new javax.swing.JFormattedTextField(tel);
			telefone.setFont(new Font("Tahoma", Font.BOLD, 11));
			telefone.setColumns(10);
			telefone.setBounds(228, 323, 535, 31);
			contentPanel.add(telefone);

		} catch (Exception e) {
		}

		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setForeground(new Color(0, 0, 128));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(194, 208, 24, 25);
		contentPanel.add(lblCpf);

		JLabel lblTelefone = new JLabel("Telefone Residencial");
		lblTelefone.setForeground(new Color(0, 0, 128));
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefone.setBounds(80, 324, 138, 25);
		contentPanel.add(lblTelefone);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.BOLD, 11));
		email.setColumns(10);
		email.setBounds(228, 427, 535, 31);
		contentPanel.add(email);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(176, 428, 42, 25);
		contentPanel.add(lblEmail);

		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClienteDAO cli = new ClienteDAO();
					Cliente cliente = new Cliente(null, nome.getText(), cpf.getText(), endereco.getText(),
							telefone.getText(), telefoneCelular.getText(), email.getText());
					cli.salvar(cliente);
					nome.setText(null);
					cpf.setText(null);
					endereco.setText(null);
					telefone.setText(null);
					telefoneCelular.setText(null);
					email.setText(null);
					JOptionPane.showMessageDialog(null, "Cliente Salvo Com Sucesso !!", "SUCESSO",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
					

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro Cliente não salvo !!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		salvar.setForeground(new Color(0, 0, 255));
		salvar.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 11));
		salvar.setBackground(new Color(0, 128, 0));
		salvar.setBounds(642, 545, 121, 40);
		contentPanel.add(salvar);

		JButton limpar = new JButton("Limpar ");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				cpf.setText(null);
				endereco.setText("");
				telefone.setText(null);
				telefoneCelular.setText(null);
				email.setText("");
			}
		});
		limpar.setForeground(new Color(0, 0, 205));
		limpar.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 11));
		limpar.setBackground(new Color(255, 0, 0));
		limpar.setBounds(454, 545, 121, 40);
		contentPanel.add(limpar);

		JButton cancelar = new JButton("cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setForeground(new Color(0, 0, 205));
		cancelar.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 11));
		cancelar.setBackground(new Color(255, 255, 0));
		cancelar.setBounds(275, 545, 121, 40);
		contentPanel.add(cancelar);

		try {
			javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("(##)#####-####");
			telefoneCelular = new javax.swing.JFormattedTextField(tel);
			telefoneCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
			telefoneCelular.setColumns(10);
			telefoneCelular.setBounds(228, 375, 535, 31);
			contentPanel.add(telefoneCelular);

		} catch (Exception e) {
		}

		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setForeground(new Color(0, 0, 128));
		lblTelefoneCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefoneCelular.setBounds(108, 375, 112, 25);
		contentPanel.add(lblTelefoneCelular);
	}
}
