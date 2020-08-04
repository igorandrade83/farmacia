package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;


/**
* @generated
*
**/
public class AnotacaoPK implements Serializable {

  /**
  * @generated
  */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
   * @generated
   */
  private java.util.Date data = Calendar.getInstance().getTime();

  /**
   * Construtor
   * @generated
   */
  public AnotacaoPK(){
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
  public AnotacaoPK setId(java.lang.String id){
    this.id = id;
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
  public AnotacaoPK setData(java.util.Date data){
    this.data = data;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
AnotacaoPK object = (AnotacaoPK)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    if (data != null ? !data.equals(object.data) : object.data != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    result = 31 * result + ((data == null) ? 0 : data.hashCode());
    return result;
  }

}
