package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Produto {

public static final int TIMEOUT = 300;

/**
 *
 * @param codigo
 * @return Var
 */
// Produto
public static Var consultar(Var codigo) throws Exception {
 return new Callable<Var>() {

   private Var produto = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         produto = cronapi.list.Operations.getLast((cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Produto"),Var.valueOf("select p from Produto p where p.codigo = :codigo"),Var.valueOf("codigo",codigo))));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         System.out.println(exception.getObjectAsString());
        produto = cronapi.map.Operations.createObjectMapWith(Var.valueOf("msg",Var.valueOf("Erro ao buscar produto")));
     }
    return produto;
   }
 }.call();
}

}

