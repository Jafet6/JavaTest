public class MetodoUsuario {

    public static void cadastrar(Usuarios usuario){

        EntityManager em = JpaUtil.getEntityManager();
        UsuariosDao usuariosDao = new UsuariosDao(em);
        em.getTransaction().begin();
        usuariosDao.criarUsuario(usuario);
        em.getTransaction().commit();
        em.close();
    }
    public static void deletar(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        UsuariosDao usuariosDao = new UsuariosDao(em);
        em.getTransaction().begin();
        Usuarios usuario = usuariosDao.buscarPorId(id);
        usuariosDao.deletarUsuario(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public static void atualizar(Usuarios usuario){
        EntityManager em = JpaUtil.getEntityManager();
        UsuariosDao usuariosDao = new UsuariosDao(em);
        em.getTransaction().begin();
        usuariosDao.alterarUsuario(usuario);
        em.getTransaction().commit();
        em.close();
    }

}
