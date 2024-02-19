package com.crud.oracle;

public class UserOracle {

    private Long idUser;
    private String userName;
    private String correoUser;
    private String contrasenaUser;
    private String codigoPostalUser;
    private String direccionUser;
    private String telefonoUser;
    private Integer edadUser;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorreoUser() {
        return correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getCodigoPostalUser() {
        return codigoPostalUser;
    }

    public void setCodigoPostalUser(String codigoPostalUser) {
        this.codigoPostalUser = codigoPostalUser;
    }

    public String getDireccionUser() {
        return direccionUser;
    }

    public void setDireccionUser(String direccionUser) {
        this.direccionUser = direccionUser;
    }

    public String getTelefonoUser() {
        return telefonoUser;
    }

    public void setTelefonoUser(String telefonoUser) {
        this.telefonoUser = telefonoUser;
    }

    public Integer getEdadUser() {
        return edadUser;
    }

    public void setEdadUser(Integer edadUser) {
        this.edadUser = edadUser;
    }
    public String getContrasenaUser() {
        return contrasenaUser;
    }

    public void setContrasenaUser(String contrasenaUser) {
        this.contrasenaUser = contrasenaUser;
    }

}

