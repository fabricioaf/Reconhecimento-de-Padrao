/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.servico;

import api.dao.PapelDAO;
import api.dao.PapelUsuarioDAO;
import api.dao.UsuarioDAO;
import api.modelo.Papel;
import api.modelo.Usuario;
import api.servico.ServicoUsuario;
import core.dao.PapelDAOMariaDB;
import core.dao.PapelUsuarioDAOMariaDB;
import core.dao.UsuarioDAOMariaDB;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sham
 */
public class ServicoUsuarioImpl implements ServicoUsuario {

    private final UsuarioDAO uDao;
    private final PapelDAO pDao;
    private final PapelUsuarioDAO puDao;

    public ServicoUsuarioImpl() {
        uDao = new UsuarioDAOMariaDB();
        pDao = new PapelDAOMariaDB();
        puDao = new PapelUsuarioDAOMariaDB();
    }

    @Override
    public Usuario create(Usuario usuario) {
        Usuario u = null;
        if (uDao.readByNomeUsuario(usuario.getNomeUsuario()) == null) {
            if (uDao.readByEmail(usuario.getEmail()) == null) {
                uDao.create(usuario);
                u = this.readByNomeUsuario(usuario.getNomeUsuario());
                for (Papel p : usuario.getPapeis()) {
                    puDao.create(u, p);
                }
                
            }
        }
        return u;
    }

    @Override
    public Usuario readByNomeUsuario(String nomeUsuario
    ) {
        Usuario usuario = uDao.readByNomeUsuario(nomeUsuario);
        if (usuario != null) {
            List<Papel> papeis = new LinkedList<>();
            List<Integer> idPapeis = puDao.readByUsuario(usuario);
            for (int id : idPapeis) {
                papeis.add(pDao.readById(id));
            }
            usuario.setPapeis(papeis);
        }
        return usuario;
    }

    @Override
    public Usuario updateByUsuario(Usuario usuario
    ) {
        return uDao.update(usuario);

    }

}
