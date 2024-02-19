package com.crud.oracle;

import java.util.Date;

public class PaqueteUser {
    private Long folioPq;
    private Long idUserPq;
    private Date fechaPq;
    private String remitentePq;
    private String destinatarioPq;
    private String direccionDestinatarioPq;
    private String telDestinatarioPq;
    private String pesoPq;
    private String observacionesPq;
    private Double costoEnvioPq;

    public Long getFolioPq() {
        return folioPq;
    }

    public void setFolioPq(Long folioPq) {
        this.folioPq = folioPq;
    }

    public Long getIdUserPq() {
        return idUserPq;
    }

    public void setIdUserPq(Long idUserPq) {
        this.idUserPq = idUserPq;
    }

    public Date getFechaPq() {
        return fechaPq;
    }

    public void setFechaPq(Date fechaPq) {
        this.fechaPq = fechaPq;
    }

    public String getRemitentePq() {
        return remitentePq;
    }

    public void setRemitentePq(String remitentePq) {
        this.remitentePq = remitentePq;
    }

    public String getDestinatarioPq() {
        return destinatarioPq;
    }

    public void setDestinatarioPq(String destinatarioPq) {
        this.destinatarioPq = destinatarioPq;
    }

    public String getDireccionDestinatarioPq() {
        return direccionDestinatarioPq;
    }

    public void setDireccionDestinatarioPq(String direccionDestinatarioPq) {
        this.direccionDestinatarioPq = direccionDestinatarioPq;
    }

    public String getTelDestinatarioPq() {
        return telDestinatarioPq;
    }

    public void setTelDestinatarioPq(String telDestinatarioPq) {
        this.telDestinatarioPq = telDestinatarioPq;
    }

    public String getPesoPq() {
        return pesoPq;
    }

    public void setPesoPq(String pesoPq) {
        this.pesoPq = pesoPq;
    }

    public String getObservacionesPq() {
        return observacionesPq;
    }

    public void setObservacionesPq(String observacionesPq) {
        this.observacionesPq = observacionesPq;
    }

    public Double getCostoEnvioPq() {
        return costoEnvioPq;
    }

    public void setCostoEnvioPq(Double costoEnvioPq) {
        this.costoEnvioPq = costoEnvioPq;
    }
}
