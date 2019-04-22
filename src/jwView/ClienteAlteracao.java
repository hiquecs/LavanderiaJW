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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jwDAO.ClienteDAO;
import jwModel.Cliente;

public class ClienteAlteracao extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nome;
	private JTextField cpf;
	private JTextField endereco;
	private JTextField telefone;
	private JTextField email;
	private JTextField telefoneCelular;
	private JTextField id;

	public ClienteAlteracao(Cliente cli) {
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

		nome = new JTextField(cli.getNome());
		nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		nome.setBounds(228, 147, 535, 31);
		contentPanel.add(nome);
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Edi\u00E7\u00E3o de Cliente");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 23));
		lblNewLabel.setBounds(378, 41, 229, 31);
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
			cpf.setText(cli.getCpf());
			contentPanel.add(cpf);
		} catch (Exception e) {
		}

		endereco = new JTextField(cli.getEndereco());
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
			telefone.setText(cli.getTelefone());
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

		email = new JTextField(cli.getEmail());
		email.setFont(new Font("Tahoma", Font.BOLD, 11));
		email.setColumns(10);
		email.setBounds(228, 427, 535, 31);
		contentPanel.add(email);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(176, 428, 42, 25);
		contentPanel.add(lblEmail);

		JButton salvar = new JButton("Salvar Edi\u00E7\u00E3o");
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClienteDAO cli = new ClienteDAO();
					Cliente cliente = new Cliente(Integer.parseInt(id.getText()), nome.getText(), cpf.getText(), endereco.getText(),
							telefone.getText(), telefoneCelular.getText(), email.getText());
					cli.atualizar(cliente);
					
					JOptionPane.showMessageDialog(null, "Cliente Atualizado Com Sucesso !!", "SUCESSO",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					ClientesCadastrados cad = new ClientesCadastrados();
					cad.setLocationRelativeTo(null);
					cad.setVisible(true);	

				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, "Erro Cliente não atualizado !!", "ERRO", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		salvar.setForeground(new Color(0, 0, 255));
		salvar.setFont(new Font("Broadway", Font.BOLD | Font.ITALIC, 11));
		salvar.setBackground(new Color(0, 128, 0));
		salvar.setBounds(634, 545, 136, 40);
		contentPanel.add(salvar);

		JButton limpar = new JButton("Deletar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				

				Object[] options = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Atenção está Prestes a deletar um registro de cliente\n Tem certeza disto?", "Informação",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);

				if (i == 0) {
					
					ClienteDAO dao = new ClienteDAO();
					ClienteDAO dao1 = new ClienteDAO();
					Cliente cli = dao.buscar(Integer.parseInt(id.getText()));
					dao1.deletar(cli);
					JOptionPane.showMessageDialog(null, "Cliente Deletado com Sucesso !!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					ClientesCadastrados cliA = new ClientesCadastrados();
					cliA.setLocationRelativeTo(null);
					cliA.setVisible(true);
					
				} else {
					
				}
				
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
				ClientesCadastrados cliA = new ClientesCadastrados();
				cliA.setLocationRelativeTo(null);
				cliA.setVisible(true);
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
			telefoneCelular.setText(cli.getTelefoneCelular());
			contentPanel.add(telefoneCelular);

		} catch (Exception e) {
		}

		JLabel lblTelefoneCelular = new JLabel("Telefone Celular");
		lblTelefoneCelular.setForeground(new Color(0, 0, 128));
		lblTelefoneCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefoneCelular.setBounds(108, 375, 112, 25);
		contentPanel.add(lblTelefoneCelular);
		
		JLabel lblClienteCodigo = new JLabel("Cliente Codigo");
		lblClienteCodigo.setForeground(new Color(0, 0, 128));
		lblClienteCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClienteCodigo.setBounds(10, 46, 95, 25);
		contentPanel.add(lblClienteCodigo);
		
		id = new JTextField(cli.getId().toString());
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Tahoma", Font.BOLD, 11));
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(106, 45, 111, 31);
		contentPanel.add(id);
	}
}
