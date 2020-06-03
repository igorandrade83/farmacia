package farmacia.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela CLIENTEVENDA
* @generated
*/
@Entity
@Table(name = "\"CLIENTEVENDA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.ClienteVenda")
@EntityListeners({cronapi.database.HistoryListener.class})
public class ClienteVenda implements Serializable {

    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_cliente", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Cliente cliente;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_venda", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Venda venda;

    /**
    * Construtor
    * @generated
    */
    public ClienteVenda(){
    }

    /**
    * Obtém id
    * return id
    * @generated
    */
    
    public java.lang.String getId(){
        return this.id;
    }

    /**
    * Define id
    * @param id id
    * @generated
    */
    public ClienteVenda setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém cliente
    * return cliente
    * @generated
    */
    
    public Cliente getCliente(){
        return this.cliente;
    }

    /**
    * Define cliente
    * @param cliente cliente
    * @generated
    */
    public ClienteVenda setCliente(Cliente cliente){
        this.cliente = cliente;
        return this;
    }
    /**
    * Obtém venda
    * return venda
    * @generated
    */
    
    public Venda getVenda(){
        return this.venda;
    }

    /**
    * Define venda
    * @param venda venda
    * @generated
    */
    public ClienteVenda setVenda(Venda venda){
        this.venda = venda;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
ClienteVenda object = (ClienteVenda)obj;
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