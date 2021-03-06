package jwView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jwDAO.ClienteDAO;
import jwDAO.ServicoDAO;
import jwModel.Cliente;
import jwModel.Servico;

public class ServicoAlteracao extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nome;
	private JTextField responsavel;
	private JTextField endereco;
	private JTextField time;
	private JTextField modalidade;
	private JTextField id;
	private JTextField txtQtde;
	private JTextField txtCor;
	private JTextField textField_3;
	private JTextField txtCamisas;
	private JTextField txtCales;
	private JTextField txtMeies;
	private JTextField camisa1Q;
	private JTextField calcao1Q;
	private JTextField meia1Q;
	private JTextField txtTime;
	private JTextField camisa1C;
	private JTextField calcao1C;
	private JTextField meia1C;
	private JTextField txtCamisaG;
	private JTextField txtMeiesG;
	private JTextField txtCalesG;
	private JTextField camisa1GQ;
	private JTextField camisa1GC;
	private JTextField meia1GQ;
	private JTextField meia1GC;
	private JTextField calcao1GQ;
	private JTextField calcao1GC;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtTime_1;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField camisa2Q;
	private JTextField calcao2Q;
	private JTextField meia2Q;
	private JTextField textField_22;
	private JTextField camisa2C;
	private JTextField calcao2C;
	private JTextField meia2C;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField camisa2GQ;
	private JTextField calcao2GQ;
	private JTextField meia2GQ;
	private JTextField textField_34;
	private JTextField camisa2GC;
	private JTextField calcao2GC;
	private JTextField meia2GC;
	private JFormattedTextField dataEntrega;
	private JFormattedTextField dataServico;
	private Date date;
	private Date data;
	private JTextField idServico;

	public ServicoAlteracao(Servico serv) {
		setTitle("Cadastro de Servi\u00E7os");
		setModal(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/jw.jpg")));
		setBounds(100, 100, 1031, 814);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		nome = new JTextField(serv.getCliente().getNome());
		nome.setBackground(new Color(255, 255, 255));
		nome.setFont(new Font("Tahoma", Font.BOLD, 11));
		nome.setEditable(false);
		nome.setBounds(349, 107, 414, 31);
		contentPanel.add(nome);
		nome.setColumns(10);

		
		ImageIcon imagem1 = new ImageIcon(getClass().getResource("/inicial1.png"));
		JLabel ser = new JLabel(imagem1);
		ser.setForeground(new Color(255, 0, 0));
		ser.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 23));
		ser.setBounds(270, 9, 464, 87);
		contentPanel.add(ser);

		JLabel lblNome = new JLabel("Cliente");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setForeground(new Color(0, 0, 128));
		lblNome.setBounds(175, 108, 41, 25);
		contentPanel.add(lblNome);

		JLabel lblEndereoCompleto = new JLabel("Nome do Responsavel");
		lblEndereoCompleto.setForeground(new Color(0, 0, 128));
		lblEndereoCompleto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereoCompleto.setBounds(80, 150, 136, 25);
		contentPanel.add(lblEndereoCompleto);

		responsavel = new JTextField(serv.getResponsavel());
		responsavel.setFont(new Font("Tahoma", Font.BOLD, 11));
		responsavel.setColumns(10);
		responsavel.setBounds(228, 149, 535, 31);
		contentPanel.add(responsavel);

		endereco = new JTextField(serv.getEnderecoEntrega());
		endereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		endereco.setColumns(10);
		endereco.setBounds(228, 191, 535, 31);
		contentPanel.add(endereco);

		time = new JTextField(serv.getTime());
		time.setFont(new Font("Tahoma", Font.BOLD, 11));
		time.setColumns(10);
		time.setBounds(228, 233, 535, 31);
		contentPanel.add(time);

		JLabel lblCpf = new JLabel("Endere\u00E7o de Entrega");
		lblCpf.setForeground(new Color(0, 0, 128));
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(80, 192, 129, 25);
		contentPanel.add(lblCpf);

		JLabel lblTelefone = new JLabel("Time");
		lblTelefone.setForeground(new Color(0, 0, 128));
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(187, 234, 29, 25);
		contentPanel.add(lblTelefone);

		modalidade = new JTextField(serv.getModalidade());
		modalidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		modalidade.setColumns(10);
		modalidade.setBounds(228, 275, 535, 31);
		contentPanel.add(modalidade);

		JLabel lblEmail = new JLabel("Modalidade");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(149, 276, 67, 25);
		contentPanel.add(lblEmail);

		JButton editar = new JButton("Salvar Edi\u00E7\u00E3o");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					ClienteDAO dao = new ClienteDAO();
					ServicoDAO serDao = new ServicoDAO();
					Cliente cli = dao.buscar(Integer.parseInt(id.getText()));

					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

					try {
						date = format.parse(dataServico.getText());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						data = format.parse(dataEntrega.getText());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					Servico servico = new Servico(Integer.parseInt(idServico.getText()), responsavel.getText(), date,
							data, endereco.getText(), time.getText(), modalidade.getText(),
							Integer.parseInt(camisa1Q.getText()), camisa1C.getText(),
							Integer.parseInt(calcao1Q.getText()), calcao1C.getText(),
							Integer.parseInt(meia1Q.getText()), meia1C.getText(), Integer.parseInt(camisa1GQ.getText()),
							camisa1GC.getText(), Integer.parseInt(calcao1GQ.getText()), calcao1GC.getText(),
							Integer.parseInt(meia1GQ.getText()), meia1GC.getText(),
							Integer.parseInt(camisa2Q.getText()), camisa2C.getText(),
							Integer.parseInt(calcao2Q.getText()), calcao2C.getText(),
							Integer.parseInt(meia2Q.getText()), meia2C.getText(), Integer.parseInt(camisa2GQ.getText()),
							camisa2GC.getText(), Integer.parseInt(calcao2GQ.getText()), calcao2GC.getText(),
							Integer.parseInt(meia2GQ.getText()), meia2GC.getText(), cli);

					serDao.atualizar(servico);

					Object[] options = { "Sim", "N�o" };
					int i = JOptionPane.showOptionDialog(null, "Servi�o Atualizado Com Sucesso !!\n Deseja Imprimir ?",
							"Informa��o", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
							options[0]);

					if (i == 0) {

						PrinterJob job = PrinterJob.getPrinterJob();
						job.setJobName("Servi�o");
						job.setPrintable(new Printable() {

							public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
								if (page > 0) {
									return NO_SUCH_PAGE;
								}

								Graphics2D g2d = (Graphics2D) g;
								g2d.translate(pf.getImageableX(), pf.getImageableY());
								g2d.scale(contentPanel.getAlignmentX() * 1.25, contentPanel.getAlignmentY() * 1.19);
								contentPanel.printAll(g);

								return PAGE_EXISTS;
							}
						});

						Boolean ok = job.printDialog();

						if (ok) {
							try {
								job.print();
							} catch (PrinterException e) {

							}
						}
						dispose();
					} else {
						dispose();
					}
				} catch (Exception e) {

				}
			}
		});
		editar.setForeground(new Color(0, 0, 255));
		editar.setFont(new Font("Broadway", Font.PLAIN, 11));
		editar.setBackground(new Color(153, 255, 153));
		editar.setBounds(673, 705, 121, 40);
		contentPanel.add(editar);

		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] options = { "Sim", "N�o" };
				int i = JOptionPane.showOptionDialog(null,
						"Aten��o est� Prestes a deletar um registro de Servi�o\n Tem certeza disto?", "Informa��o",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

				if (i == 0) {

					ServicoDAO dao = new ServicoDAO();
					ServicoDAO dao1 = new ServicoDAO();
					Servico servico = dao.buscar(Integer.parseInt(idServico.getText()));
					dao1.delete(servico);
					JOptionPane.showMessageDialog(null, "Servi�o Deletado com Sucesso ", "Informa��o",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					ServicosCadastrados cad = new ServicosCadastrados();
					cad.setLocationRelativeTo(null);
					cad.setVisible(true);

				} else {

				}
			}
		});
		deletar.setForeground(new Color(0, 0, 205));
		deletar.setFont(new Font("Broadway", Font.PLAIN, 11));
		deletar.setBackground(new Color(255, 102, 102));
		deletar.setBounds(440, 705, 121, 40);
		contentPanel.add(deletar);

		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ServicosCadastrados cad = new ServicosCadastrados();
				cad.setLocationRelativeTo(null);
				cad.setVisible(true);
			}
		});
		voltar.setForeground(new Color(0, 0, 205));
		voltar.setFont(new Font("Broadway", Font.PLAIN, 11));
		voltar.setBackground(new Color(255, 255, 153));
		voltar.setBounds(202, 705, 121, 40);
		contentPanel.add(voltar);

		id = new JTextField(serv.getCliente().getId().toString());
		id.setBackground(new Color(255, 255, 255));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Tahoma", Font.BOLD, 11));
		id.setEditable(false);
		id.setBounds(228, 107, 111, 31);
		contentPanel.add(id);
		id.setColumns(10);

		txtQtde = new JTextField();
		txtQtde.setForeground(Color.BLUE);
		txtQtde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQtde.setText("     Qtde");
		txtQtde.setEditable(false);
		txtQtde.setColumns(10);
		txtQtde.setBounds(324, 337, 86, 25);
		contentPanel.add(txtQtde);

		txtCor = new JTextField();
		txtCor.setForeground(Color.BLUE);
		txtCor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCor.setText("      Cor");
		txtCor.setEditable(false);
		txtCor.setColumns(10);
		txtCor.setBounds(410, 337, 86, 25);
		contentPanel.add(txtCor);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(496, 337, 126, 25);
		contentPanel.add(textField_3);

		txtCamisas = new JTextField();
		txtCamisas.setForeground(Color.RED);
		txtCamisas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCamisas.setText("         Camisas");
		txtCamisas.setEditable(false);
		txtCamisas.setColumns(10);
		txtCamisas.setBounds(202, 362, 121, 25);
		contentPanel.add(txtCamisas);

		txtCales = new JTextField();
		txtCales.setForeground(Color.RED);
		txtCales.setText("         Cal\u00E7\u00F5es");
		txtCales.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCales.setEditable(false);
		txtCales.setColumns(10);
		txtCales.setBounds(202, 387, 121, 25);
		contentPanel.add(txtCales);

		txtMeies = new JTextField();
		txtMeies.setForeground(Color.RED);
		txtMeies.setText("          Mei\u00F5es");
		txtMeies.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMeies.setEditable(false);
		txtMeies.setColumns(10);
		txtMeies.setBounds(202, 412, 121, 25);
		contentPanel.add(txtMeies);

		camisa1Q = new javax.swing.JFormattedTextField(serv.getCamisa1Q());
		camisa1Q.setHorizontalAlignment(SwingConstants.CENTER);
		camisa1Q.setFont(new Font("Tahoma", Font.BOLD, 14));
		camisa1Q.setColumns(10);
		camisa1Q.setBounds(324, 362, 86, 25);
		contentPanel.add(camisa1Q);

		calcao1Q = new javax.swing.JFormattedTextField(serv.getCalcao1Q());
		calcao1Q.setHorizontalAlignment(SwingConstants.CENTER);
		calcao1Q.setFont(new Font("Tahoma", Font.BOLD, 14));
		calcao1Q.setColumns(10);
		calcao1Q.setBounds(324, 387, 86, 25);
		contentPanel.add(calcao1Q);

		meia1Q = new javax.swing.JFormattedTextField(serv.getMeia1Q());
		meia1Q.setHorizontalAlignment(SwingConstants.CENTER);
		meia1Q.setFont(new Font("Tahoma", Font.BOLD, 14));
		meia1Q.setColumns(10);
		meia1Q.setBounds(324, 412, 86, 25);
		contentPanel.add(meia1Q);

		txtTime = new JTextField();
		txtTime.setForeground(Color.BLUE);
		txtTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTime.setText("          Time 1");
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		txtTime.setBounds(202, 337, 121, 25);
		contentPanel.add(txtTime);

		camisa1C = new JTextField(serv.getCamisa1C());
		camisa1C.setHorizontalAlignment(SwingConstants.CENTER);
		camisa1C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		camisa1C.setColumns(10);
		camisa1C.setBounds(410, 362, 86, 25);
		contentPanel.add(camisa1C);

		calcao1C = new JTextField(serv.getCalcao1C());
		calcao1C.setHorizontalAlignment(SwingConstants.CENTER);
		calcao1C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calcao1C.setColumns(10);
		calcao1C.setBounds(410, 387, 86, 25);
		contentPanel.add(calcao1C);

		meia1C = new JTextField(serv.getMeia1C());
		meia1C.setHorizontalAlignment(SwingConstants.CENTER);
		meia1C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		meia1C.setColumns(10);
		meia1C.setBounds(410, 412, 86, 25);
		contentPanel.add(meia1C);

		txtCamisaG = new JTextField();
		txtCamisaG.setForeground(Color.RED);
		txtCamisaG.setText("      Camisa G");
		txtCamisaG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCamisaG.setEditable(false);
		txtCamisaG.setColumns(10);
		txtCamisaG.setBounds(496, 362, 126, 25);
		contentPanel.add(txtCamisaG);

		txtMeiesG = new JTextField();
		txtMeiesG.setForeground(Color.RED);
		txtMeiesG.setText("       Mei\u00F5es G");
		txtMeiesG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMeiesG.setEditable(false);
		txtMeiesG.setColumns(10);
		txtMeiesG.setBounds(496, 412, 126, 25);
		contentPanel.add(txtMeiesG);

		txtCalesG = new JTextField();
		txtCalesG.setEditable(false);
		txtCalesG.setForeground(Color.RED);
		txtCalesG.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCalesG.setText("      Cal\u00E7\u00F5es G");
		txtCalesG.setColumns(10);
		txtCalesG.setBounds(496, 387, 126, 25);
		contentPanel.add(txtCalesG);

		camisa1GQ = new javax.swing.JFormattedTextField(serv.getCamisa1GQ());
		camisa1GQ.setHorizontalAlignment(SwingConstants.CENTER);
		camisa1GQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		camisa1GQ.setColumns(10);
		camisa1GQ.setBounds(622, 362, 86, 25);
		contentPanel.add(camisa1GQ);

		camisa1GC = new JTextField(serv.getCamisa1GC());
		camisa1GC.setHorizontalAlignment(SwingConstants.CENTER);
		camisa1GC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		camisa1GC.setColumns(10);
		camisa1GC.setBounds(708, 362, 86, 25);
		contentPanel.add(camisa1GC);

		meia1GQ = new javax.swing.JFormattedTextField(serv.getMeia1GQ());
		meia1GQ.setHorizontalAlignment(SwingConstants.CENTER);
		meia1GQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		meia1GQ.setColumns(10);
		meia1GQ.setBounds(622, 412, 86, 25);
		contentPanel.add(meia1GQ);

		meia1GC = new JTextField(serv.getMeia1GC());
		meia1GC.setHorizontalAlignment(SwingConstants.CENTER);
		meia1GC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		meia1GC.setColumns(10);
		meia1GC.setBounds(708, 412, 86, 25);
		contentPanel.add(meia1GC);

		calcao1GQ = new javax.swing.JFormattedTextField(serv.getCalcao1GQ());
		calcao1GQ.setHorizontalAlignment(SwingConstants.CENTER);
		calcao1GQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		calcao1GQ.setColumns(10);
		calcao1GQ.setBounds(622, 387, 86, 25);
		contentPanel.add(calcao1GQ);

		calcao1GC = new JTextField(serv.getCalcao1GC());
		calcao1GC.setHorizontalAlignment(SwingConstants.CENTER);
		calcao1GC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calcao1GC.setColumns(10);
		calcao1GC.setBounds(708, 387, 86, 25);
		contentPanel.add(calcao1GC);

		textField = new JTextField();
		textField.setText("     Qtde");
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(622, 337, 86, 25);
		contentPanel.add(textField);

		textField_1 = new JTextField();
		textField_1.setText("      Cor");
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(708, 337, 86, 25);
		contentPanel.add(textField_1);

		txtTime_1 = new JTextField();
		txtTime_1.setText("          Time 2");
		txtTime_1.setForeground(Color.BLUE);
		txtTime_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTime_1.setEditable(false);
		txtTime_1.setColumns(10);
		txtTime_1.setBounds(202, 467, 121, 25);
		contentPanel.add(txtTime_1);

		textField_9 = new JTextField();
		textField_9.setForeground(Color.RED);
		textField_9.setText("         Camisas");
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(202, 493, 121, 25);
		contentPanel.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setForeground(Color.RED);
		textField_10.setText("         Cal\u00E7\u00F5es");
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(202, 519, 121, 25);
		contentPanel.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setForeground(Color.RED);
		textField_11.setText("          Mei\u00F5es");
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(202, 545, 121, 25);
		contentPanel.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setText("     Qtde");
		textField_12.setForeground(Color.BLUE);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(324, 467, 86, 25);
		contentPanel.add(textField_12);

		camisa2Q = new javax.swing.JFormattedTextField(serv.getCamisa2Q());
		camisa2Q.setHorizontalAlignment(SwingConstants.CENTER);
		camisa2Q.setFont(new Font("Tahoma", Font.BOLD, 14));
		camisa2Q.setColumns(10);
		camisa2Q.setBounds(324, 493, 86, 25);
		contentPanel.add(camisa2Q);

		calcao2Q = new javax.swing.JFormattedTextField(serv.getCalcao2Q());
		calcao2Q.setHorizontalAlignment(SwingConstants.CENTER);
		calcao2Q.setFont(new Font("Tahoma", Font.BOLD, 14));
		calcao2Q.setColumns(10);
		calcao2Q.setBounds(324, 519, 86, 25);
		contentPanel.add(calcao2Q);

		meia2Q = new javax.swing.JFormattedTextField(serv.getMeia2Q());
		meia2Q.setHorizontalAlignment(SwingConstants.CENTER);
		meia2Q.setFont(new Font("Tahoma", Font.BOLD, 14));
		meia2Q.setColumns(10);
		meia2Q.setBounds(324, 545, 86, 25);
		contentPanel.add(meia2Q);

		textField_22 = new JTextField();
		textField_22.setText("      Cor");
		textField_22.setForeground(Color.BLUE);
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(410, 467, 86, 25);
		contentPanel.add(textField_22);

		camisa2C = new JTextField(serv.getCamisa2C());
		camisa2C.setHorizontalAlignment(SwingConstants.CENTER);
		camisa2C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		camisa2C.setColumns(10);
		camisa2C.setBounds(410, 493, 86, 25);
		contentPanel.add(camisa2C);

		calcao2C = new JTextField(serv.getCalcao2C());
		calcao2C.setHorizontalAlignment(SwingConstants.CENTER);
		calcao2C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calcao2C.setColumns(10);
		calcao2C.setBounds(410, 519, 86, 25);
		contentPanel.add(calcao2C);

		meia2C = new JTextField(serv.getMeia2C());
		meia2C.setHorizontalAlignment(SwingConstants.CENTER);
		meia2C.setFont(new Font("Tahoma", Font.PLAIN, 14));
		meia2C.setColumns(10);
		meia2C.setBounds(410, 545, 86, 25);
		contentPanel.add(meia2C);

		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setColumns(10);
		textField_26.setBounds(496, 467, 126, 25);
		contentPanel.add(textField_26);

		textField_27 = new JTextField();
		textField_27.setForeground(Color.RED);
		textField_27.setText("      Camisa G");
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_27.setEditable(false);
		textField_27.setColumns(10);
		textField_27.setBounds(496, 493, 126, 25);
		contentPanel.add(textField_27);

		textField_28 = new JTextField();
		textField_28.setForeground(Color.RED);
		textField_28.setText("      Cal\u00E7\u00F5es G");
		textField_28.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_28.setEditable(false);
		textField_28.setColumns(10);
		textField_28.setBounds(496, 519, 126, 25);
		contentPanel.add(textField_28);

		textField_29 = new JTextField();
		textField_29.setForeground(Color.RED);
		textField_29.setText("       Mei\u00F5es G");
		textField_29.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_29.setEditable(false);
		textField_29.setColumns(10);
		textField_29.setBounds(496, 545, 126, 25);
		contentPanel.add(textField_29);

		textField_30 = new JTextField();
		textField_30.setText("     Qtde");
		textField_30.setForeground(Color.BLUE);
		textField_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_30.setEditable(false);
		textField_30.setColumns(10);
		textField_30.setBounds(622, 467, 86, 25);
		contentPanel.add(textField_30);

		camisa2GQ = new javax.swing.JFormattedTextField(serv.getCamisa2GQ());
		camisa2GQ.setHorizontalAlignment(SwingConstants.CENTER);
		camisa2GQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		camisa2GQ.setColumns(10);
		camisa2GQ.setBounds(622, 493, 86, 25);
		contentPanel.add(camisa2GQ);

		calcao2GQ = new javax.swing.JFormattedTextField(serv.getCalcao2GQ());
		calcao2GQ.setHorizontalAlignment(SwingConstants.CENTER);
		calcao2GQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		calcao2GQ.setColumns(10);
		calcao2GQ.setBounds(622, 519, 86, 25);
		contentPanel.add(calcao2GQ);

		meia2GQ = new javax.swing.JFormattedTextField(serv.getMeia2GQ());
		meia2GQ.setHorizontalAlignment(SwingConstants.CENTER);
		meia2GQ.setFont(new Font("Tahoma", Font.BOLD, 14));
		meia2GQ.setColumns(10);
		meia2GQ.setBounds(622, 545, 86, 25);
		contentPanel.add(meia2GQ);

		textField_34 = new JTextField();
		textField_34.setText("      Cor");
		textField_34.setForeground(Color.BLUE);
		textField_34.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_34.setEditable(false);
		textField_34.setColumns(10);
		textField_34.setBounds(708, 467, 86, 25);
		contentPanel.add(textField_34);

		camisa2GC = new JTextField(serv.getCamisa2GC());
		camisa2GC.setHorizontalAlignment(SwingConstants.CENTER);
		camisa2GC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		camisa2GC.setColumns(10);
		camisa2GC.setBounds(708, 493, 86, 25);
		contentPanel.add(camisa2GC);

		calcao2GC = new JTextField(serv.getCalcao2GC());
		calcao2GC.setHorizontalAlignment(SwingConstants.CENTER);
		calcao2GC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		calcao2GC.setColumns(10);
		calcao2GC.setBounds(708, 519, 86, 25);
		contentPanel.add(calcao2GC);

		meia2GC = new JTextField(serv.getMeia2GC());
		meia2GC.setHorizontalAlignment(SwingConstants.CENTER);
		meia2GC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		meia2GC.setColumns(10);
		meia2GC.setBounds(708, 545, 86, 25);
		contentPanel.add(meia2GC);

		JLabel lblDataServio = new JLabel("Data Servi\u00E7o");
		lblDataServio.setForeground(new Color(0, 0, 128));
		lblDataServio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataServio.setBounds(138, 600, 78, 25);
		contentPanel.add(lblDataServio);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
			dataServico = new javax.swing.JFormattedTextField(data);
			dataServico.setHorizontalAlignment(SwingConstants.CENTER);
			dataServico.setFont(new Font("Tahoma", Font.BOLD, 13));
			dataServico.setText("");
			dataServico.setBounds(228, 600, 95, 24);
			dataServico.setText(sdf.format(serv.getDataServico()));
			contentPanel.add(dataServico);

		} catch (Exception e) {
		}

		try {
			javax.swing.text.MaskFormatter data = new javax.swing.text.MaskFormatter("##/##/####");
			dataEntrega = new javax.swing.JFormattedTextField(data);
			dataEntrega.setHorizontalAlignment(SwingConstants.CENTER);
			dataEntrega.setText("");
			dataEntrega.setFont(new Font("Tahoma", Font.BOLD, 13));
			dataEntrega.setBounds(688, 600, 95, 24);
			dataEntrega.setText(sdf.format(serv.getDataEntrega()));
			contentPanel.add(dataEntrega);
		} catch (Exception e) {
		}

		JLabel lblDataEntrega = new JLabel("Data Entrega");
		lblDataEntrega.setForeground(new Color(0, 0, 128));
		lblDataEntrega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataEntrega.setBounds(587, 600, 86, 25);
		contentPanel.add(lblDataEntrega);

		JLabel lblServio = new JLabel("Servi\u00E7o Codigo");
		lblServio.setForeground(new Color(0, 0, 128));
		lblServio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServio.setBounds(10, 23, 95, 25);
		contentPanel.add(lblServio);

		idServico = new JTextField(serv.getId().toString());
		idServico.setBackground(new Color(255, 255, 255));
		idServico.setHorizontalAlignment(SwingConstants.CENTER);
		idServico.setFont(new Font("Tahoma", Font.BOLD, 11));
		idServico.setEditable(false);
		idServico.setColumns(10);
		idServico.setBounds(115, 22, 111, 31);
		contentPanel.add(idServico);

	}
}