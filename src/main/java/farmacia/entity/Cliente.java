package farmacia.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
* Classe que representa a tabela CLIENTE
* @generated
*/
@Entity
@Table(name = "\"CLIENTE\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("farmacia.entity.Cliente")
@EntityListeners({cronapi.database.HistoryListener.class})
public class Cliente implements Serializable {

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
    @Column(name = "nome", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String nome;

    /**
    * @generated
    */
    @Column(name = "cpf", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cpf;

    /**
    * @generated
    */
    @Column(name = "telefone", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String telefone;

    /**
    * @generated
    */
    @Column(name = "email", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String email;

    /**
    * @generated
    */
    @Column(name = "cep", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cep;

    /**
    * @generated
    */
    @Column(name = "endereco", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String endereco;

    /**
    * @generated
    */
    @Column(name = "complemento", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String complemento;

    /**
    * @generated
    */
    @Column(name = "bairro", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String bairro;

    /**
    * @generated
    */
    @Column(name = "cidade", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String cidade;

    /**
    * @generated
    */
    @Column(name = "uf", nullable = false, unique = false, insertable=true, updatable=true)
        
        private java.lang.String uf;

    /**
    * Construtor
    * @generated
    */
    public Cliente(){
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
    public Cliente setId(java.lang.String id){
        this.id = id;
        return this;
    }
    /**
    * Obtém nome
    * return nome
    * @generated
    */
    
    public java.lang.String getNome(){
        return this.nome;
    }

    /**
    * Define nome
    * @param nome nome
    * @generated
    */
    public Cliente setNome(java.lang.String nome){
        this.nome = nome;
        return this;
    }
    /**
    * Obtém cpf
    * return cpf
    * @generated
    */
    
    public java.lang.String getCpf(){
        return this.cpf;
    }

    /**
    * Define cpf
    * @param cpf cpf
    * @generated
    */
    public Cliente setCpf(java.lang.String cpf){
        this.cpf = cpf;
        return this;
    }
    /**
    * Obtém telefone
    * return telefone
    * @generated
    */
    
    public java.lang.String getTelefone(){
        return this.telefone;
    }

    /**
    * Define telefone
    * @param telefone telefone
    * @generated
    */
    public Cliente setTelefone(java.lang.String telefone){
        this.telefone = telefone;
        return this;
    }
    /**
    * Obtém email
    * return email
    * @generated
    */
    
    public java.lang.String getEmail(){
        return this.email;
    }

    /**
    * Define email
    * @param email email
    * @generated
    */
    public Cliente setEmail(java.lang.String email){
        this.email = email;
        return this;
    }
    /**
    * Obtém cep
    * return cep
    * @generated
    */
    
    public java.lang.String getCep(){
        return this.cep;
    }

    /**
    * Define cep
    * @param cep cep
    * @generated
    */
    public Cliente setCep(java.lang.String cep){
        this.cep = cep;
        return this;
    }
    /**
    * Obtém endereco
    * return endereco
    * @generated
    */
    
    public java.lang.String getEndereco(){
        return this.endereco;
    }

    /**
    * Define endereco
    * @param endereco endereco
    * @generated
    */
    public Cliente setEndereco(java.lang.String endereco){
        this.endereco = endereco;
        return this;
    }
    /**
    * Obtém complemento
    * return complemento
    * @generated
    */
    
    public java.lang.String getComplemento(){
        return this.complemento;
    }

    /**
    * Define complemento
    * @param complemento complemento
    * @generated
    */
    public Cliente setComplemento(java.lang.String complemento){
        this.complemento = complemento;
        return this;
    }
    /**
    * Obtém bairro
    * return bairro
    * @generated
    */
    
    public java.lang.String getBairro(){
        return this.bairro;
    }

    /**
    * Define bairro
    * @param bairro bairro
    * @generated
    */
    public Cliente setBairro(java.lang.String bairro){
        this.bairro = bairro;
        return this;
    }
    /**
    * Obtém cidade
    * return cidade
    * @generated
    */
    
    public java.lang.String getCidade(){
        return this.cidade;
    }

    /**
    * Define cidade
    * @param cidade cidade
    * @generated
    */
    public Cliente setCidade(java.lang.String cidade){
        this.cidade = cidade;
        return this;
    }
    /**
    * Obtém uf
    * return uf
    * @generated
    */
    
    public java.lang.String getUf(){
        return this.uf;
    }

    /**
    * Define uf
    * @param uf uf
    * @generated
    */
    public Cliente setUf(java.lang.String uf){
        this.uf = uf;
        return this;
    }

    /**
    * @generated
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
Cliente object = (Cliente)obj;
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