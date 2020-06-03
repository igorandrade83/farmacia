package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Venda {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaItensPedido
 * @param clienteId
 * @return Var
 */
// Venda
public static Var cadastrar(Var listaItensPedido, Var clienteId) throws Exception {
 return new Callable<Var>() {

   private Var valorTotal = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var precoVenda = Var.VAR_NULL;
   private Var quantidade = Var.VAR_NULL;
   private Var idVenda = Var.VAR_NULL;

   public Var call() throws Exception {
    valorTotal = Var.valueOf(0);
    for (Iterator it_i = cronapi.json.Operations.toJson(listaItensPedido).iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        precoVenda = cronapi.object.Operations.getObjectField(i, Var.valueOf("produto.precoVenda"));
        quantidade = cronapi.object.Operations.getObjectField(i, Var.valueOf("quantidade"));
        valorTotal = cronapi.math.Operations.sum(valorTotal,cronapi.math.Operations.multiply(quantidade,precoVenda));
    } // end for
    idVenda = cronapi.util.Operations.generateUUID();
    cronapi.database.Operations.insert(Var.valueOf("farmacia.entity.Venda"),Var.valueOf("data",cronapi.dateTime.Operations.getNow()),Var.valueOf("valor",valorTotal),Var.valueOf("id",idVenda));
    cronapi.database.Operations.insert(Var.valueOf("farmacia.entity.ClienteVenda"),Var.valueOf("cliente",clienteId),Var.valueOf("venda",idVenda));
    return idVenda;
   }
 }.call();
}

}

