package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
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

   private Var exception = Var.VAR_NULL;
   private Var produto = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        produto =
        cronapi.list.Operations.getLast((
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Produto"),Var.valueOf("select p from Produto p where p.codigo = :codigo"),Var.valueOf("codigo",codigo))));
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        System.out.println(exception.getObjectAsString());

        produto =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("msg",
        Var.valueOf("Erro ao buscar produto")));
     }
    return produto;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var listarProdutos() throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;
   private Var produtos = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    resposta =
    Var.VAR_NULL;

    try {

        resposta =
        Var.valueOf("<ul>");

        produtos =
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Produto"),Var.valueOf("select p from Produto p"));

        for (Iterator it_i = produtos.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());

            if (
            Var.valueOf(!resposta.equals(
            Var.VAR_NULL)).getObjectAsBoolean()) {

                resposta =
                Var.valueOf(
                resposta.toString() +
                Var.valueOf(
                Var.valueOf("<li>").toString() +
                Var.valueOf(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("codigo")).toString() +
                Var.valueOf(" - ").toString()).toString() +
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("nome")).toString() +
                Var.valueOf(
                Var.valueOf("- R$").toString() +
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("precoVenda")).toString() +
                Var.valueOf("</li>").toString()).toString()).toString());
            } else {

                resposta =
                Var.valueOf(
                Var.valueOf("<li>").toString() +
                Var.valueOf(
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("codigo")).toString() +
                Var.valueOf(" - ").toString()).toString() +
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("nome")).toString() +
                Var.valueOf(
                Var.valueOf(" - R$").toString() +
                cronapi.json.Operations.getJsonOrMapField(i,
                Var.valueOf("precoVenda")).toString() +
                Var.valueOf("</li>").toString()).toString());
            }
        } // end for

        resposta =
        Var.valueOf(
        resposta.toString() +
        Var.valueOf("</ul>").toString());
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        System.out.println(exception.getObjectAsString());
     }
    return resposta;
   }
 }.call();
}

}

