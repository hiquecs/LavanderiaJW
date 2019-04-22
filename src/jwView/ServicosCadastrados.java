package jwView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import jwDAO.ServicoDAO;
import jwModel.Servico;

public class ServicosCadastrados extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JList<?> list;
	private JFormattedTextField data ;

	@SuppressWarnings("rawtypes")
	public ServicosCadastrados() {
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
		scrollPane.setBounds(112, 150, 795, 490);
		contentPanel.add(scrollPane);

		ServicoDAO dao = new ServicoDAO();

		List<Servico> serv = dao.buscarTodos();
		DefaultListModel<Servico> listModel = new DefaultListModel<Servico>();
		for (Servico c : serv) {
			listModel.addElement(c);
		}
		@SuppressWarnings("unchecked")
		JList<Servico> list_1 = new JList(listModel);
		list_1.setForeground(Color.BLUE);
		list_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(list_1);

		JButton btnNewButton = new JButton("Visualisar Servi\u00E7o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ServicoDAO dao = new ServicoDAO();
				Servico serv = (Servico) list_1.getSelectedValue();
				serv = dao.buscar(serv.getId());
				ServicoAlteracao servA = new ServicoAlteracao(serv);
				servA.setLocationRelativeTo(null);
				servA.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(767, 672, 140, 33);
		btnNewButton.setBackground(new Color(64, 224, 208));
		contentPanel.add(btnNewButton);

		JLabel lblServiosCadastrados = new JLabel("Servi\u00E7os Cadastrados");
		lblServiosCadastrados.setForeground(Color.RED);
		lblServiosCadastrados.setFont(new Font("Copperplate Gothic Light", Font.ITALIC, 23));
		lblServiosCadastrados.setBounds(358, 23, 285, 31);
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
		
		JButton pesquisa = new JButton("Pesquisar");
		pesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listModel.clear();
				ServicoDAO dao = new ServicoDAO();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Date dat;
				try {
					dat = formato.parse(data.getText());
				} catch (ParseException e) {
				  dat=null;
					e.printStackTrace();
				} 
				GregorianCalendar dataCal = new GregorianCalendar();
				dataCal.setTime(dat);
				List<Servico> list = dao.BuscarPorData(dataCal);
				
				for (Servico c : list) {
					listModel.addElement(c);
				}
				list_1.setModel(listModel);
			}
		});
		pesquisa.setForeground(new Color(0, 0, 128));
		pesquisa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		pesquisa.setBackground(new Color(0, 128, 0));
		pesquisa.setBounds(767, 89, 123, 31);
		contentPanel.add(pesquisa);
		
		javax.swing.text.MaskFormatter data1;
		try {
			data1 = new javax.swing.text.MaskFormatter("##/##/####");
		} catch (ParseException e) {

            data1=null;
			e.printStackTrace();
		}
		data = new javax.swing.JFormattedTextField(data1);
		data.setHorizontalAlignment(SwingConstants.CENTER);
		data.setFont(new Font("Tahoma", Font.BOLD, 13));
		data.setBounds(657, 89, 95, 29);
		contentPanel.add(data);
		
		JLabel lblDataDoServio = new JLabel("Data do Servi\u00E7o");
		lblDataDoServio.setForeground(new Color(0, 0, 128));
		lblDataDoServio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDataDoServio.setBounds(531, 90, 112, 25);
		contentPanel.add(lblDataDoServio);
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