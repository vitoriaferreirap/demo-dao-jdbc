package model.entidades;

import java.io.Serializable;

//serializable é uma interface que permite que a classe seja convertida em um fluxo de bytes
// para que possa ser gravada em um arquivo ou transmitida pela rede
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public Departamento() {
    }

    public Departamento(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    // hashcode e equals são importantes para comparar objetos com base em seus
    // valore e não em suas referências de ponteiro

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
        Departamento other = (Departamento) obj;
        if (id == null) {
            return other.id == null;
        } else
            return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nome=" + nome + "]";
    }

}
