package model.entidades;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private Date aniversario;
    private Double salario;

    // relacionamento com o departamento (composição de objetos)
    private Departamento departamento;

    public Vendedor() {
    }

    public Vendedor(Integer id, String nome, String email, Date aniversario, Double salario,
            Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.aniversario = aniversario;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vendedor other = (Vendedor) obj;
        if (id == null) {
            return other.id == null;
        } else
            return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", aniversario=" + aniversario
                + ", salario=" + salario + ", departamento=" + departamento + "]";
    }
}
