package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Pedido {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaItensPedido
 * @param clienteId
 * @return Var
 */
// Pedido
public static Var salvarItens(Var listaItensPedido, Var clienteId) throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;
   private Var idVenda = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {
    resposta = Var.VAR_FALSE;
    try {
         if (Var.valueOf(cronapi.logic.Operations.isNullOrEmpty(clienteId).negate().getObjectAsBoolean() && cronapi.logic.Operations.isNullOrEmpty(cronapi.json.Operations.toJson(listaItensPedido)).negate().getObjectAsBoolean()).getObjectAsBoolean()) {
            idVenda = blockly.Venda.cadastrar(listaItensPedido, clienteId);
            for (Iterator it_i = cronapi.json.Operations.toJson(listaItensPedido).iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());
                cronapi.database.Operations.insert(Var.valueOf("farmacia.entity.Pedido"),Var.valueOf("venda",idVenda),Var.valueOf("produto",cronapi.object.Operations.getObjectField(i, Var.valueOf("produto.id"))),Var.valueOf("quantidade",cronapi.object.Operations.getObjectField(i, Var.valueOf("quantidade"))));
            } // end for
            resposta = Var.VAR_TRUE;
        }
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);
         cronapi.util.Operations.log(Var.valueOf("General"), Var.valueOf("INFO"), Var.valueOf("Erro"), Var.VAR_NULL);
     }
    return resposta;
   }
 }.call();
}

}

