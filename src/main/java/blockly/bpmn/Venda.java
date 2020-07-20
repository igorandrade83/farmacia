package blockly.bpmn;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Venda {

public static final int TIMEOUT = 300;

/**
 *
 * @param idVenda
 * @return Var
 */
// Pedido
public static Var aprovar(Var idVenda) throws Exception {
 return new Callable<Var>() {

   private Var venda = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        venda =
        cronapi.list.Operations.getLast((
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Venda"),Var.valueOf("select v from Venda v where v.id = :id"),Var.valueOf("id",idVenda))));

        cronapi.object.Operations.setObjectField(venda, Var.valueOf("statusVenda"),
        Var.valueOf(2));

        cronapi.database.Operations.update(Var.valueOf("farmacia.entity.Venda"),venda);
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        System.out.println(exception.getObjectAsString());
     }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param idVenda
 * @return Var
 */
// Pedido
public static Var reprovar(Var idVenda) throws Exception {
 return new Callable<Var>() {

   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        cronapi.database.Operations.execute(Var.valueOf("farmacia.entity.Venda"), Var.valueOf("update Venda set statusVenda = :statusVenda where id = :id"),Var.valueOf("statusVenda",
        Var.valueOf(3)),Var.valueOf("id",idVenda));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        System.out.println(exception.getObjectAsString());
     }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param idVenda
 * @param url
 * @return Var
 */
// Descreva esta função...
public static Var iniciarFluxoBpmn(Var idVenda, Var url) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {

    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("POST"),
    Var.valueOf("application/json"),
    Var.valueOf(
    url.toString() +
    Var.valueOf("/api/engine/engine/default/process-definition/key/pedidoRemedio/submit-form").toString()),
    Var.valueOf(setarParametros(idVenda)),
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("X-AUTH-TOKEN",
    cronapi.screen.Operations.getToken())), Var.VAR_NULL);
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param idVenda
 * @return Var
 */
// Descreva esta função...
public static Var setarParametros(Var idVenda) throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;

   public Var call() throws Exception {

    resposta =
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("variables",
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("idVenda",
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("value",idVenda))))));
    return resposta;
   }
 }.call();
}

}

