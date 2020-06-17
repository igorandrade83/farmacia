package farmacia.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela PEDIDO
* @generated
*/
@Entity
@Table(name = "\"PEDIDO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.Pedido")
@EntityListeners({cronapi.database.HistoryListener.class})
public class Pedido implements Serializable {

    /**
    * UID da classe, necessário na serialização
    * @generated
    */
    private static final long serialVersionUID = 1L;

    /**
    * @generated
    */
    @Id
    @Column(name = "id", nullable = true, insertable=true, updatable=true)
        private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

    /**
    * @generated
    */
    @Column(name = "quantidade", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.Integer quantidade;

    /**
    * @generated
    */
    @ManyToOne
    @JoinColumn(name="fk_produto", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
        
        private Produto produto;

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
    public Pedido(){
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
    public Pedido setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém quantidade
    * return quantidade
    * @generated
    */
    
    public java.lang.Integer getQuantidade(){
        return this.quantidade;
    }

    /**
    * Define quantidade
    * @param quantidade quantidade
    * @generated
    */
    public Pedido setQuantidade(java.lang.Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
    /**
    * Obtém produto
    * return produto
    * @generated
    */
    
    public Produto getProduto(){
        return this.produto;
    }

    /**
    * Define produto
    * @param produto produto
    * @generated
    */
    public Pedido setProduto(Produto produto){
        this.produto = produto;
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
    public Pedido setVenda(Venda venda){
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
Pedido object = (Pedido)obj;
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