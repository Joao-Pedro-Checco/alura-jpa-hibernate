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
        var produto = buscarPorId(id);
        this.em.remove(produto);
        em.getTransaction().commit();
    }

    private Produto buscarPorId(Long id) {
        return this.em.find(Produto.class, id);
    }

    public List<Produto> listar() {
        String jpql = "select p from Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
}
