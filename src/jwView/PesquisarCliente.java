package jwView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import jwDAO.ClienteDAO;
import jwModel.Cliente;

public class PesquisarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nome;
	
	public PesquisarCliente() {
		
		setTitle("Pesquisa de Cliente");
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
		nome.setFont(new Font("Tahoma", Font.BOLD, 13));
		nome.setBounds(228, 147, 535, 31);
		contentPanel.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Pesquisar Cliente Por Nome");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 23));
		lblNewLabel.setBounds(327, 61, 361, 31);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setForeground(new Color(0, 0, 128));
		lblNome.setBounds(106, 148, 112, 25);
		contentPanel.add(lblNome);
		
		ClienteDAO cliDao = new ClienteDAO();
		List<Cliente> list = cliDao.buscarTodos();
		JComboBox<Cliente> comboBox = new JComboBox<Cliente>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		for(Cliente c:list) {
			
			comboBox.addItem(c);
		}
		comboBox.setBounds(228, 301, 535, 30);
		contentPanel.add(comboBox);
		
		JButton novoServico = new JButton("Novo Servi\u00E7o");
		novoServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente cliente = (Cliente) comboBox.getSelectedItem();
				CadastroServicos  ser = new CadastroServicos(cliente);
				ser.setLocationRelativeTo(null);
				ser.setVisible(true);
				
			}
		});
		novoServico.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		novoServico.setForeground(new Color(0, 0, 128));
		novoServico.setBackground(new Color(0, 128, 0));
		novoServico.setBounds(799, 300, 123, 31);
		contentPanel.add(novoServico);
		
		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.removeAllItems();
				ClienteDAO cli = new ClienteDAO();
				String a = nome.getText();
				List <Cliente> clientes = cli.buscarPorNome(a);
				
				for(Cliente as: clientes ) {
					
					comboBox.addItem(as);
				}	
			}
		});
		pesquisar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		pesquisar.setBackground(new Color(0, 128, 0));
		pesquisar.setForeground(new Color(0, 0, 128));
		pesquisar.setBounds(799, 147, 123, 31);
		contentPanel.add(pesquisar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelar.setForeground(new Color(0, 0, 128));
		cancelar.setBackground(Color.RED);
		cancelar.setBounds(799, 428, 123, 31);
		contentPanel.add(cancelar);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(0, 0, 128));
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setBounds(167, 302, 47, 25);
		contentPanel.add(lblCliente);
	}
}
