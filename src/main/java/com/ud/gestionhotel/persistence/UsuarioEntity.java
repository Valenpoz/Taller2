package com.ud.gestionhotel.persistence;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Id
    @Column(name="id_usuario")
    private long id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    private String contrasena;
    private String rol;

    @OneToOne
    @JoinColumn(name = "fk_id_cliente")
    private ClienteEntity clienteEntity;

    @OneToOne
    @JoinColumn(name = "fk_id_empleado")
    private EmpleadoEntity empleadoEntity;

    @OneToOne
    @JoinColumn(name = "fk_id_administrador_general")
    private AdministradorGeneralEntity administradorGeneralEntity;

    @OneToOne
    @JoinColumn(name = "fk_id_administrador")
    private AdministradorEntity administradorEntity;

    public UsuarioEntity() {
    }

    public UsuarioEntity(long id, String nombreUsuario, String contrasena, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
