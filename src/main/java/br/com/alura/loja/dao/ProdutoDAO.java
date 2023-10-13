package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.getTransaction().begin();
        this.em.persist(produto);
        this.em.getTransaction().commit();
    }

    public void remover(Long id) {
        em.getTransaction().begin();
        var produto = this.buscarPorId(id);
        this.em.remove(produto);
        em.getTransaction().commit();
    }

    private Produto buscarPorId(Long id) {
        String jpql = "select p from Produto p where p.id = :id";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Produto> listarTodos() {
        String jpql = "select p from Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
}
