package jwDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jwModel.Cliente;

public class ClienteDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public ClienteDAO() {

		emf = Persistence.createEntityManagerFactory("cliente");
		em = emf.createEntityManager();
	}

	public void salvar(Cliente cliente) {

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	public void deletar(Cliente cliente) {

		em.getTransaction().begin();
		Cliente cli = em.find(Cliente.class, cliente.getId());
		em.remove(cli);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

	public Cliente buscar(int id) {

		em.getTransaction().begin();
		Cliente cli = em.find(Cliente.class, id);
		em.close();
		emf.close();

		return cli;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		
		Query query = em.createQuery("FROM Cliente cliente");
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List <Cliente> buscarPorNome(String nome){
		
		String jpql = ("select c from Cliente c where c.nome like  :cNome");
		Query query = em.createQuery(jpql);
		query.setParameter("cNome",  "%" + nome + "%");
		List<Cliente> clientes = query.getResultList();		

		return clientes;
	}
	
	public void atualizar(Cliente cliente) {
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}