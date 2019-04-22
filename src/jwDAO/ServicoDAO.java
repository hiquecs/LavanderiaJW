package jwDAO;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jwModel.Servico;

public class ServicoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public ServicoDAO() {

		emf = Persistence.createEntityManagerFactory("servico");
		em = emf.createEntityManager();
	}

	public void salvar(Servico servico) {

		em.getTransaction().begin();
		em.persist(servico);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public void delete(Servico servico) {

		em.getTransaction().begin();
		Servico cli = em.find(Servico.class, servico.getId());
		em.remove(cli);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public Servico buscar(int id) {

		em.getTransaction().begin();
		Servico cli = em.find(Servico.class, id);
		em.close();
		emf.close();

		return cli;
	}

	@SuppressWarnings("unchecked")
	public List<Servico> buscarTodos() {

		Query query = em.createQuery("FROM Servico Servico");
		List<Servico> servicos = query.getResultList();
		
		return servicos;
	}

	@SuppressWarnings("unchecked")
	public List<Servico> buscarPorNome(String nome) {

		String jpql = ("select c from Servico c where c.nome like  :cNome");
		Query query = em.createQuery(jpql);
		query.setParameter("cNome",  "%" + nome + "%");
		List<Servico> Servicos = query.getResultList();		

		return Servicos;
	}

	@SuppressWarnings("unchecked")
	public List<Servico> BuscarPorData(GregorianCalendar dataCal) {

		Integer dia = dataCal.get(Calendar.DAY_OF_MONTH);
		Integer mes = dataCal.get(Calendar.MONTH) + 1;

		String jpql = ("SELECT a FROM Servico a WHERE DAY(a.dataServico) = ? AND MONTH(a.dataServico) = ? ");

		Query query = em.createQuery(jpql);

		query.setParameter(0, dia);
		query.setParameter(1, mes);
		List<Servico> servicos = query.getResultList();

		return servicos;

	}

	public void atualizar(Servico servico) {
		
		em.getTransaction().begin();
		em.merge(servico);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}