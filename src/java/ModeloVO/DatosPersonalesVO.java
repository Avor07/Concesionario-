/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author ortiz
 */
public class DatosPersonalesVO {
    private String dataId,usuId,datNombre,datApellido,dataTipoId,datNumeroID,daTelefono,datCorreo;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }

    public String getDatApellido() {
        return datApellido;
    }

    public void setDatApellido(String datApellido) {
        this.datApellido = datApellido;
    }

    public String getDataTipoId() {
        return dataTipoId;
    }

    public void setDataTipoId(String dataTipoId) {
        this.dataTipoId = dataTipoId;
    }

    public String getDatNumeroID() {
        return datNumeroID;
    }

    public void setDatNumeroID(String datNumeroID) {
        this.datNumeroID = datNumeroID;
    }

    public String getDaTelefono() {
        return daTelefono;
    }

    public void setDaTelefono(String daTelefono) {
        this.daTelefono = daTelefono;
    }

    public String getDatCorreo() {
        return datCorreo;
    }

    public void setDatCorreo(String datCorreo) {
        this.datCorreo = datCorreo;
    }

    public DatosPersonalesVO(String usuId, String datNombre, String datApellido, String daTelefono, String datCorreo) {
        this.usuId = usuId;
        this.datNombre = datNombre;
        this.datApellido = datApellido;

        this.daTelefono = daTelefono;
        this.datCorreo = datCorreo;
    }
    public DatosPersonalesVO(String dataId,String usuId, String datNombre, String datApellido, String daTelefono, String datCorreo) {
        this.usuId = usuId;
        this.datNombre = datNombre;
        this.datApellido = datApellido;

        this.daTelefono = daTelefono;
        this.datCorreo = datCorreo;
    }
    public DatosPersonalesVO( ) {
       
    }
}
