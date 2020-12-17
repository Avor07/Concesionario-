/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import ModeloDAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ortiz
 */
public class UsuarioRolVO {
    private String rolId,usuId;

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public UsuarioRolVO(String rolId, String usuId) {
        this.rolId = rolId;
        this.usuId = usuId;
    }
    public UsuarioRolVO(String rolId) {
        this.rolId = rolId;
    }
}
