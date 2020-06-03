package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Cliente {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade
 * @return Var
 */
// Cliente
public static Var obterNome(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var nomeCliente = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         nomeCliente = cronapi.database.Operations.getField(cronapi.database.Operations.query(Var.valueOf("farmacia.entity.ClienteVenda"),Var.valueOf("select c.cliente.nome from ClienteVenda c where c.venda.id = :vendaId"),Var.valueOf("vendaId",cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("id")))), Var.valueOf("this[0]"));
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         nomeCliente = Var.valueOf("Erro");
        System.out.println(erro.getObjectAsString());
     }
    return nomeCliente;
   }
 }.call();
}

}

