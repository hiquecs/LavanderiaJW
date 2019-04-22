package jwView;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jwDAO.ServicoDAO;
import jwModel.Servico;

public class TelaPrincipal {

	private JFrame frmLavanderiaEsportivaJw;
	private JTextField txtServiosTotaisDia;
	private SimpleDateFormat sdf;
	private JTextArea textArea;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmLavanderiaEsportivaJw.setVisible(true);
					window.frmLavanderiaEsportivaJw.setLocationRelativeTo(null);
					window.frmLavanderiaEsportivaJw.setResizable(false);
					window.frmLavanderiaEsportivaJw
							.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jw.jpg")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {

		frmLavanderiaEsportivaJw = new JFrame();
		frmLavanderiaEsportivaJw.setLocale(new Locale("pt", "BR"));
		frmLavanderiaEsportivaJw.getContentPane().setLocale(new Locale("pt", "BR"));
		frmLavanderiaEsportivaJw.setFocusableWindowState(true);
		frmLavanderiaEsportivaJw.getContentPane().setLayout(null);

		ImageIcon imagem1 = new ImageIcon(getClass().getResource("/inicial.png"));
		JLabel lblNewLabel = new JLabel(imagem1);
		lblNewLabel.setBounds(0, 0, 1001, 150);
		lblNewLabel.setComponentOrientation(ComponentOrientation.UNKNOWN);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmLavanderiaEsportivaJw.getContentPane().add(lblNewLabel);
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtServiosTotaisDia = new JTextField();
		txtServiosTotaisDia.setEditable(false);
		txtServiosTotaisDia.setBackground(new Color(70, 130, 180));
		txtServiosTotaisDia.setForeground(new Color(0, 0, 255));
		txtServiosTotaisDia.setFont(new Font("Goudy Old Style", Font.BOLD, 17));
		txtServiosTotaisDia.setHorizontalAlignment(SwingConstants.CENTER);
		txtServiosTotaisDia.setText("Servi\u00E7os  Totais  Dia   " + sdf.format(new Date(System.currentTimeMillis())));
		txtServiosTotaisDia.setBounds(156, 224, 701, 28);
		frmLavanderiaEsportivaJw.getContentPane().add(txtServiosTotaisDia);
		txtServiosTotaisDia.setColumns(10);

		JButton atuali = new JButton("Atualizar");
		atuali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualiza();
			}
		});

		textArea = new JTextArea();
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		textArea.setFont(new Font("Calibri Light", Font.BOLD, 15));
		textArea.setEditable(false);
		JScrollPane st = new JScrollPane(textArea);
		st.setBounds(156, 252, 701, 396);
		frmLavanderiaEsportivaJw.getContentPane().add(st);

		atuali.setForeground(new Color(0, 0, 255));
		atuali.setFont(new Font("Goudy Old Style", Font.BOLD, 15));
		atuali.setBackground(new Color(64, 224, 208));
		atuali.setBounds(867, 224, 107, 41);
		frmLavanderiaEsportivaJw.getContentPane().add(atuali);
		atualiza();

		ImageIcon imagem2 = new ImageIcon(getClass().getResource("/nuvens.jpg"));
		JLabel lblNewLabel_1 = new JLabel(imagem2);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_1.setBounds(10, 149, 991, 575);
		frmLavanderiaEsportivaJw.getContentPane().add(lblNewLabel_1);
		frmLavanderiaEsportivaJw.setTitle("Lavanderia Esportiva JW");
		frmLavanderiaEsportivaJw.setBounds(100, 100, 1017, 799);
		frmLavanderiaEsportivaJw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmLavanderiaEsportivaJw.setJMenuBar(menuBar);

		JButton cadastrarClientes = new JButton("Cadastrar Clientes");
		cadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroClientes cli = new CadastroClientes();
				cli.setLocationRelativeTo(null);
				cli.setVisible(true);
			}
		});
		cadastrarClientes.setBackground(new Color(224, 255, 255));
		cadastrarClientes.setForeground(Color.BLUE);
		menuBar.add(cadastrarClientes);

		JButton clientesCadastrados = new JButton("Clientes Cadastrados");
		clientesCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesCadastrados cad = new ClientesCadastrados();
				cad.setLocationRelativeTo(null);
				cad.setVisible(true);
			}
		});
		clientesCadastrados.setForeground(Color.BLUE);
		clientesCadastrados.setBackground(new Color(224, 255, 255));
		menuBar.add(clientesCadastrados);

		JButton cadastrarServicos = new JButton("Cadastrar Servi\u00E7os");
		cadastrarServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarCliente cli = new PesquisarCliente();
				cli.setLocationRelativeTo(null);
				cli.setVisible(true);
			}
		});
		cadastrarServicos.setForeground(Color.BLUE);
		cadastrarServicos.setBackground(new Color(224, 255, 255));
		menuBar.add(cadastrarServicos);

		JButton servicosCadastrados = new JButton("Servi\u00E7os Cadastrados");
		servicosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ServicosCadastrados cad = new ServicosCadastrados();
				cad.setLocationRelativeTo(null);
				cad.setVisible(true);
			}
		});
		servicosCadastrados.setForeground(Color.BLUE);
		servicosCadastrados.setBackground(new Color(224, 255, 255));
		menuBar.add(servicosCadastrados);
	}

	private void atualiza() {

		ServicoDAO dao = new ServicoDAO();
		Date data = new Date();
		GregorianCalendar dataCal = new GregorianCalendar();
		dataCal.setTime(data);

		List<Servico> list = dao.BuscarPorData(dataCal);

		textArea.setText("\n");
		for (Servico c : list) {
			textArea.setText(textArea.getText() + c.getId() + "  |   " + c.getCliente().getNome() + "   |  "
					+ c.getDataServico() + "   |  " + c.getDataEntrega() + "   |  " + c.getTime() + "\n\n");
		}
	}
}
