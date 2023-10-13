package br.com.alura.loja.dao;


import br.com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {
    private EntityManager em;

    public PedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido produto) {
        this.em.getTransaction().begin();
        this.em.persist(produto);
        this.em.getTransaction().commit();
    }
}
