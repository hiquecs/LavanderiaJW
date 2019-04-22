package jwModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String responsavel;

	@Temporal(TemporalType.DATE)
	private Date dataServico;
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;
	private String enderecoEntrega;
	private String time;
	private String modalidade;
	private Integer camisa1Q;
	private String camisa1C;
	private Integer calcao1Q;
	private String calcao1C;
	private Integer meia1Q;
	private String meia1C;
	private Integer camisa1GQ;
	private String camisa1GC;
	private Integer calcao1GQ;
	private String calcao1GC;
	private Integer meia1GQ;
	private String meia1GC;
	private Integer camisa2Q;
	private String camisa2C;
	private Integer calcao2Q;
	private String calcao2C;
	private Integer Meia2Q;
	private String Meia2C;
	private Integer camisa2GQ;
	private String camisa2GC;
	private Integer calcao2GQ;
	private String calcao2GC;
	private Integer meia2GQ;
	private String meia2GC;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Servico() {

	}

	public Servico(Integer id, String responsavel, Date dataServico, Date dataEntrega, String enderecoEntrega,
			String time, String modalidade, Integer camisa1q, String camisa1c, Integer calcao1q, String calcao1c,
			Integer meia1q, String meia1c, Integer camisa1gq, String camisa1gc, Integer calcao1gq, String calcao1gc,
			Integer meia1gq, String meia1gc, Integer camisa2q, String camisa2c, Integer calcao2q, String calcao2c,
			Integer meia2q, String meia2c, Integer camisa2gq, String camisa2gc, Integer calcao2gq, String calcao2gc,
			Integer meia2gq, String meia2gc, Cliente cliente) {

		this.id = id;
		this.responsavel = responsavel;
		this.dataServico = dataServico;
		this.dataEntrega = dataEntrega;
		this.enderecoEntrega = enderecoEntrega;
		this.time = time;
		this.modalidade = modalidade;
		camisa1Q = camisa1q;
		camisa1C = camisa1c;
		calcao1Q = calcao1q;
		calcao1C = calcao1c;
		meia1Q = meia1q;
		meia1C = meia1c;
		camisa1GQ = camisa1gq;
		camisa1GC = camisa1gc;
		calcao1GQ = calcao1gq;
		calcao1GC = calcao1gc;
		meia1GQ = meia1gq;
		meia1GC = meia1gc;
		camisa2Q = camisa2q;
		camisa2C = camisa2c;
		calcao2Q = calcao2q;
		calcao2C = calcao2c;
		Meia2Q = meia2q;
		Meia2C = meia2c;
		camisa2GQ = camisa2gq;
		camisa2GC = camisa2gc;
		calcao2GQ = calcao2gq;
		calcao2GC = calcao2gc;
		meia2GQ = meia2gq;
		meia2GC = meia2gc;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Integer getCamisa1Q() {
		return camisa1Q;
	}

	public void setCamisa1Q(Integer camisa1q) {
		camisa1Q = camisa1q;
	}

	public String getCamisa1C() {
		return camisa1C;
	}

	public void setCamisa1C(String camisa1c) {
		camisa1C = camisa1c;
	}

	public Integer getCalcao1Q() {
		return calcao1Q;
	}

	public void setCalcao1Q(Integer calcao1q) {
		calcao1Q = calcao1q;
	}

	public String getCalcao1C() {
		return calcao1C;
	}

	public void setCalcao1C(String calcao1c) {
		calcao1C = calcao1c;
	}

	public Integer getMeia1Q() {
		return meia1Q;
	}

	public void setMeia1Q(Integer meia1q) {
		meia1Q = meia1q;
	}

	public String getMeia1C() {
		return meia1C;
	}

	public void setMeia1C(String meia1c) {
		meia1C = meia1c;
	}

	public Integer getCamisa1GQ() {
		return camisa1GQ;
	}

	public void setCamisa1GQ(Integer camisa1gq) {
		camisa1GQ = camisa1gq;
	}

	public String getCamisa1GC() {
		return camisa1GC;
	}

	public void setCamisa1GC(String camisa1gc) {
		camisa1GC = camisa1gc;
	}

	public Integer getCalcao1GQ() {
		return calcao1GQ;
	}

	public void setCalcao1GQ(Integer calcao1gq) {
		calcao1GQ = calcao1gq;
	}

	public String getCalcao1GC() {
		return calcao1GC;
	}

	public void setCalcao1GC(String calcao1gc) {
		calcao1GC = calcao1gc;
	}

	public Integer getMeia1GQ() {
		return meia1GQ;
	}

	public void setMeia1GQ(Integer meia1gq) {
		meia1GQ = meia1gq;
	}

	public String getMeia1GC() {
		return meia1GC;
	}

	public void setMeia1GC(String meia1gc) {
		meia1GC = meia1gc;
	}

	public Integer getCamisa2Q() {
		return camisa2Q;
	}

	public void setCamisa2Q(Integer camisa2q) {
		camisa2Q = camisa2q;
	}

	public String getCamisa2C() {
		return camisa2C;
	}

	public void setCamisa2C(String camisa2c) {
		camisa2C = camisa2c;
	}

	public Integer getCalcao2Q() {
		return calcao2Q;
	}

	public void setCalcao2Q(Integer calcao2q) {
		calcao2Q = calcao2q;
	}

	public String getCalcao2C() {
		return calcao2C;
	}

	public void setCalcao2C(String calcao2c) {
		calcao2C = calcao2c;
	}

	public Integer getMeia2Q() {
		return Meia2Q;
	}

	public void setMeia2Q(Integer meia2q) {
		Meia2Q = meia2q;
	}

	public String getMeia2C() {
		return Meia2C;
	}

	public void setMeia2C(String meia2c) {
		Meia2C = meia2c;
	}

	public Integer getCamisa2GQ() {
		return camisa2GQ;
	}

	public void setCamisa2GQ(Integer camisa2gq) {
		camisa2GQ = camisa2gq;
	}

	public String getCamisa2GC() {
		return camisa2GC;
	}

	public void setCamisa2GC(String camisa2gc) {
		camisa2GC = camisa2gc;
	}

	public Integer getCalcao2GQ() {
		return calcao2GQ;
	}

	public void setCalcao2GQ(Integer calcao2gq) {
		calcao2GQ = calcao2gq;
	}

	public String getCalcao2GC() {
		return calcao2GC;
	}

	public void setCalcao2GC(String calcao2gc) {
		calcao2GC = calcao2gc;
	}

	public Integer getMeia2GQ() {
		return meia2GQ;
	}

	public void setMeia2GQ(Integer meia2gq) {
		meia2GQ = meia2gq;
	}

	public String getMeia2GC() {
		return meia2GC;
	}

	public void setMeia2GC(String meia2gc) {
		meia2GC = meia2gc;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cod= " + id+ "     dataServico= " + dataServico
				+ "    dataEntrega= " + dataEntrega+ "    responsavel= " + responsavel;
	}

}