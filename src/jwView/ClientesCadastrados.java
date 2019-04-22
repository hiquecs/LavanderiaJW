package jwView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import jwDAO.ClienteDAO;
import jwModel.Cliente;
import javax.swing.JTextField;

public class ClientesCadastrados extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<?> list;
	private JTextField nome;

	@SuppressWarnings("rawtypes")
	public ClientesCadastrados() {
		setModal(true);
		setBounds(100, 100, 1031, 814);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jw.jpg")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(0, 153, 153));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 151, 795, 489);
		contentPanel.add(scrollPane);

		ClienteDAO dao = new ClienteDAO();

		List<Cliente> serv = dao.buscarTodos();
		DefaultListModel<Cliente> listModel = new DefaultListModel<Cliente>();
		for (Cliente c : serv) {
			listModel.addElement(c);
		}
		@SuppressWarnings("unchecked")
		JList<Cliente> list_1 = new JList(listModel);
		list_1.setForeground(Color.BLUE);
		list_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(list_1);

		JButton btnNewButton = new JButton("Visualisar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ClienteDAO dao = new ClienteDAO();
				Cliente cli = (Cliente) list_1.getSelectedValue();
				cli = dao.buscar(cli.getId());
				ClienteAlteracao cliA = new ClienteAlteracao(cli);
				cliA.setLocationRelativeTo(null);
				cliA.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(767, 672, 140, 33);
		btnNewButton.setBackground(new Color(64, 224, 208));
		contentPanel.add(btnNewButton);

		JLabel lblServiosCadastrados = new JLabel("Clientes Cadastrados");
		lblServiosCadastrados.setForeground(Color.RED);
		lblServiosCadastrados.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 23));
		lblServiosCadastrados.setBounds(357, 36, 285, 31);
		contentPanel.add(lblServiosCadastrados);
		
		JButton button = new JButton("cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Broadway", Font.PLAIN, 11));
		button.setBackground(Color.RED);
		button.setBounds(612, 672, 140, 33);
		contentPanel.add(button);
		
		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClienteDAO dao = new ClienteDAO();

				listModel.clear();
				String a = nome.getText();
				List<Cliente> serv = dao.buscarPorNome(a);
				DefaultListModel<Cliente> listModel = new DefaultListModel<Cliente>();
				for (Cliente c : serv) {
					listModel.addElement(c);
				}
				list_1.setModel(listModel);	
			}
		});
		pesquisar.setForeground(new Color(0, 0, 128));
		pesquisar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		pesquisar.setBackground(new Color(0, 128, 0));
		pesquisar.setBounds(767, 88, 123, 31);
		contentPanel.add(pesquisar);
		
		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.BOLD, 13));
		nome.setColumns(10);
		nome.setBounds(201, 87, 535, 31);
		contentPanel.add(nome);
		
		JLabel label = new JLabel("Nome Completo");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(79, 88, 112, 25);
		contentPanel.add(label);
		{
			
			list = new JList(); 
			list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			list.setVisibleRowCount(-1);
			JScrollPane listScroller = new JScrollPane(list);
			listScroller.setPreferredSize(new Dimension(250, 80));

		}
	}
}