package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void remover(Long id) {
        em.getTransaction().begin();
        var categoria = buscarPorId(id);
        this.em.remove(categoria);
        em.getTransaction().commit();
    }

    private Categoria buscarPorId(Long id) {
        return this.em.find(Categoria.class, id);
    }
}
