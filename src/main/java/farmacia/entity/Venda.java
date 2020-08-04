package farmacia.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela VENDA
* @generated
*/
@Entity
@Table(name = "\"VENDA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.Venda")
@EntityListeners({cronapi.database.HistoryListener.class})
public class Venda implements Serializable {

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
    @Column(name = "valor", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Double valor;

    /**
    * @generated
    */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false, unique = false, insertable=true, updatable=true, columnDefinition = "TIMESTAMP")
        
        private java.util.Date data = Calendar.getInstance().getTime();

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_statusVenda", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
        
        private StatusVenda statusVenda;

    /**
    * Construtor
    * @generated
    */
    public Venda(){
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
    public Venda setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém valor
    * return valor
    * @generated
    */
    
    public java.lang.Double getValor(){
        return this.valor;
    }

    /**
    * Define valor
    * @param valor valor
    * @generated
    */
    public Venda setValor(java.lang.Double valor){
        this.valor = valor;
        return this;
    }
    /**
    * Obtém data
    * return data
    * @generated
    */
    
    public java.util.Date getData(){
        return this.data;
    }

    /**
    * Define data
    * @param data data
    * @generated
    */
    public Venda setData(java.util.Date data){
        this.data = data;
        return this;
    }
    /**
    * Obtém statusVenda
    * return statusVenda
    * @generated
    */
    
    public StatusVenda getStatusVenda(){
        return this.statusVenda;
    }

    /**
    * Define statusVenda
    * @param statusVenda statusVenda
    * @generated
    */
    public Venda setStatusVenda(StatusVenda statusVenda){
        this.statusVenda = statusVenda;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Venda object = (Venda)obj;
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