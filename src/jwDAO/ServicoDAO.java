package jwDAO;

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

	public void salvar(Servico Servico) {

		em.getTransaction().begin();
		em.persist(Servico);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public void remover(Servico Servico) {

		em.getTransaction().begin();
		Servico cli = em.find(Servico.class, Servico.getId());
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
		List<Servico> Servicos = query.getResultList();
		return Servicos;
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Servico> buscarPorNome(String nome){
		
		String jpql = ("select c from Servico c where c.nome like  :cNome");
		Query query = em.createQuery(jpql);
		query.setParameter("cNome",  "%" + nome + "%");
		List<Servico> Servicos = query.getResultList();		

		return Servicos;
	}
}
