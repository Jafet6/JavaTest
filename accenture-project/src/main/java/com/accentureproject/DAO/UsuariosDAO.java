package com.accentureproject.DAO;

import com.accentureproject.model.Usuarios;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuariosDAO {
    private EntityManager em;

    public UsuariosDAO(EntityManager em) {
        this.em = em;
    }

    public Usuarios criarUsuario(Usuarios usuario) {
//        em.getTransaction().begin();
        this.em.persist(usuario);
        return usuario;
    }

    public void deletarUsuario(Usuarios usuario) {
        usuario = em.merge(usuario);
        this.em.remove(usuario);
    }

    public Usuarios alterarUsuario(Usuarios usuario) {
        this.em.merge(usuario);
        return usuario;
    }

    public Usuarios buscarPorId(Long id) {
        return this.em.find(Usuarios.class, id);
    }

    public List<Usuarios> buscarTodos() {
        String jpql = "SELECT p FROM Usuarios p";
        return em.createQuery(jpql, Usuarios.class).getResultList();
    }
}
