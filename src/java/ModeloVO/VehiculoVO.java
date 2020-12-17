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
public class VehiculoVO {
    private String vehPlaca,datId,catId,vehModelo,vehMarca,veEstado,vehPrecio;

    public VehiculoVO() {
    }

    public String getVehPlaca() {
        return vehPlaca;
    }

    public void setVehPlaca(String vehPlaca) {
        this.vehPlaca = vehPlaca;
    }

    public String getDatId() {
        return datId;
    }

    public void setDatId(String datId) {
        this.datId = datId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getVehModelo() {
        return vehModelo;
    }

    public void setVehModelo(String vehModelo) {
        this.vehModelo = vehModelo;
    }

    public String getVehMarca() {
        return vehMarca;
    }

    public void setVehMarca(String vehMarca) {
        this.vehMarca = vehMarca;
    }

    public String getVeEstado() {
        return veEstado;
    }

    public void setVeEstado(String veEstado) {
        this.veEstado = veEstado;
    }

    public String getVehPrecio() {
        return vehPrecio;
    }

    public void setVehPrecio(String vehPrecio) {
        this.vehPrecio = vehPrecio;
    }

    public VehiculoVO(String vehPlaca, String datId, String catId, String vehModelo, String vehMarca, String veEstado, String vehPrecio) {
        this.vehPlaca = vehPlaca;
        this.datId = datId;
        this.catId = catId;
        this.vehModelo = vehModelo;
        this.vehMarca = vehMarca;
        this.veEstado = veEstado;
        this.vehPrecio = vehPrecio;
    }
}
