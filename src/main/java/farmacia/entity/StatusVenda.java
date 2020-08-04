package farmacia.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela STATUSVENDA
* @generated
*/
@Entity
@Table(name = "\"STATUSVENDA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.StatusVenda")
public class StatusVenda implements Serializable {

    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.Integer id;

    /**
    * @generated
    */
    @Column(name = "descricao", nullable = true, unique = false, insertable=true, updatable=true)
        
        private java.lang.String descricao;

    /**
    * Construtor
    * @generated
    */
    public StatusVenda(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    
    public java.lang.Integer getId(){
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public StatusVenda setId(java.lang.Integer id){
        this.id = id;
        return this;
    }
    /**
    * Obtém descricao
    * return descricao
    * @generated
    */
    
    public java.lang.String getDescricao(){
        return this.descricao;
    }

    /**
    * Define descricao
    * @param descricao descricao
    * @generated
    */
    public StatusVenda setDescricao(java.lang.String descricao){
        this.descricao = descricao;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
StatusVenda object = (StatusVenda)obj;
        if (id != null ? !id.equals(object.id) : object.id != null) return false;
        return true;
    }

    /**
    * @generated
    */
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}