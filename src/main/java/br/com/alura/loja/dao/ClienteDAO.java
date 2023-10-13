package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.getTransaction().begin();
        this.em.persist(cliente);
        this.em.getTransaction().commit();
    }
}
