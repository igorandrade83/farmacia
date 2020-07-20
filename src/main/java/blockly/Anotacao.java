package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Anotacao {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaAnotacoes
 * @return Var
 */
// Anotacao
public static Var gerenciar(Var listaAnotacoes) throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var ids = Var.VAR_NULL;
   private Var anotacao = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.list.Operations.newList();

    try {

        System.out.println(listaAnotacoes.getObjectAsString());

        ids =
        cronapi.list.Operations.newList();

        for (Iterator it_anotacao =
        cronapi.json.Operations.toJson(listaAnotacoes).iterator(); it_anotacao.hasNext();) {
            anotacao = Var.valueOf(it_anotacao.next());

            if (
            Var.valueOf(
            cronapi.logic.Operations.isNullOrEmpty(
            cronapi.json.Operations.getJsonOrMapField(anotacao,
            Var.valueOf("exclusao"))).getObjectAsBoolean() &&
            cronapi.logic.Operations.isNullOrEmpty(
            cronapi.json.Operations.getJsonOrMapField(anotacao,
            Var.valueOf("id"))).getObjectAsBoolean()).getObjectAsBoolean()) {

                cronapi.database.Operations.insert(Var.valueOf("app.entity.Anotacao"),Var.valueOf("nome",
                cronapi.json.Operations.getJsonOrMapField(anotacao,
                Var.valueOf("nome"))),Var.valueOf("user",
                blockly.UserManager.obterIdUsuario()));
            } else if (
            Var.valueOf(
            /*# sourceMappingStart=_XT#3P}}HRB{@y96)QmG */
            cronapi.logic.Operations.isNullOrEmpty(
            cronapi.json.Operations.getJsonOrMapField(anotacao,
            Var.valueOf("exclusao"))).negate().getObjectAsBoolean() &&
            /*# sourceMappingStart=sk!$prdy~m:6;@KmC56Z */
            cronapi.logic.Operations.isNullOrEmpty(
            cronapi.json.Operations.getJsonOrMapField(anotacao,
            Var.valueOf("id"))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {

                cronapi.database.Operations.remove(Var.valueOf("app.entity.Anotacao"),anotacao);
            }
        } // end for
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"), exception, Var.VAR_NULL);
     }
    return lista;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var listar() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    lista =
    cronapi.list.Operations.newList();

    try {

        lista =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Anotacao"),Var.valueOf("select a from Anotacao a"));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"), exception, Var.VAR_NULL);

        cronapi.util.Operations.throwException(
        Var.valueOf("Erro ao obter lista de anotações"));
     }
    return lista;
   }
 }.call();
}

}

