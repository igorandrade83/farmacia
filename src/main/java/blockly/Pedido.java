package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Pedido {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaItensPedido
 * @param clienteId
 * @param url
 * @return Var
 */
// Pedido
public static Var salvarItens(Var listaItensPedido, Var clienteId, Var url) throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;
   private Var idVenda = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    resposta =
    Var.VAR_FALSE;

    try {

        if (
        Var.valueOf(
        /*# sourceMappingStart=H?T;,r|uAQSZ6sr-J-UX */
        cronapi.logic.Operations.isNullOrEmpty(clienteId).negate().getObjectAsBoolean() &&
        /*# sourceMappingStart=y(SbRCw__X[o9kL~/VBb */
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.json.Operations.toJson(listaItensPedido)).negate().getObjectAsBoolean()).getObjectAsBoolean()) {

            idVenda =
            blockly.Venda.cadastrar(listaItensPedido, clienteId, url);

            for (Iterator it_i =
            cronapi.json.Operations.toJson(listaItensPedido).iterator(); it_i.hasNext();) {
                i = Var.valueOf(it_i.next());

                cronapi.database.Operations.insert(Var.valueOf("farmacia.entity.Pedido"),Var.valueOf("venda",idVenda),Var.valueOf("produto",
                cronapi.object.Operations.getObjectField(i,
                Var.valueOf("produto.id"))),Var.valueOf("quantidade",
                cronapi.object.Operations.getObjectField(i,
                Var.valueOf("quantidade"))));
            } // end for

            resposta =
            Var.VAR_TRUE;
        }
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"),
        Var.valueOf("Erro ao tentar salvar pedido"), Var.VAR_NULL);
     }
    return resposta;
   }
 }.call();
}

/**
 *
 * @param context
 * @return Var
 */
// Pedido
public static Var salvarItensChatBot(Var context) throws Exception {
 return new Callable<Var>() {

   private Var resposta = Var.VAR_NULL;
   private Var listaItensPedido = Var.VAR_NULL;
   private Var cliente = Var.VAR_NULL;
   private Var clienteId = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var produto = Var.VAR_NULL;
   private Var idVenda = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var exception = Var.VAR_NULL;

   public Var call() throws Exception {

    resposta =
    Var.VAR_NULL;

    listaItensPedido =
    cronapi.list.Operations.newList();

    try {

        cliente =
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Cliente"),Var.valueOf("select c from Cliente c where c.cpf = :cpf"),Var.valueOf("cpf",
        cronapi.json.Operations.getJsonOrMapField(context,
        Var.valueOf("cpf"))));

        if (
        /*# sourceMappingStart=WM!TBw|OZGcwPOQ2es%, */
        cronapi.logic.Operations.isNullOrEmpty(cliente).negate().getObjectAsBoolean()) {

            clienteId =
            cronapi.object.Operations.getObjectField(
            cronapi.list.Operations.getLast(cliente),
            Var.valueOf("id"));

            for (Iterator it_j =
            cronapi.json.Operations.getJsonOrMapField(context,
            Var.valueOf("produtosCarrinho")).iterator(); it_j.hasNext();) {
                j = Var.valueOf(it_j.next());

                produto =
                cronapi.list.Operations.getLast((
                cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Produto"),Var.valueOf("select p from Produto p where p.codigo = :codigo"),Var.valueOf("codigo",j))));

                if (
                /*# sourceMappingStart=-RePqRIP^ICy%_@4BtpP */
                cronapi.logic.Operations.isNullOrEmpty(produto).negate().getObjectAsBoolean()) {

                    cronapi.list.Operations.addLast(listaItensPedido,
                    cronapi.map.Operations.createObjectMapWith(Var.valueOf("produto",produto) , Var.valueOf("quantidade",
                    Var.valueOf(1))));
                } else {

                    resposta =
                    Var.valueOf("Há produtos na lista que não foram encontrados");
                }
            } // end for

            if (
            cronapi.logic.Operations.isNullOrEmpty(listaItensPedido).getObjectAsBoolean()) {

                resposta =
                Var.valueOf("Nenhum produto foi encontrado com o código informado");

                cronapi.json.Operations.setJsonOrMapField(context,
                Var.valueOf("erroPedido"),
                Var.VAR_TRUE);
            } else {

                idVenda =
                blockly.Venda.cadastrarChatbot(listaItensPedido, clienteId);

                for (Iterator it_i =
                cronapi.json.Operations.toJson(listaItensPedido).iterator(); it_i.hasNext();) {
                    i = Var.valueOf(it_i.next());

                    cronapi.database.Operations.insert(Var.valueOf("farmacia.entity.Pedido"),Var.valueOf("venda",idVenda),Var.valueOf("produto",
                    cronapi.object.Operations.getObjectField(i,
                    Var.valueOf("produto.id"))),Var.valueOf("quantidade",
                    cronapi.object.Operations.getObjectField(i,
                    Var.valueOf("quantidade"))));
                } // end for

                cronapi.json.Operations.setJsonOrMapField(context,
                Var.valueOf("idVenda"), idVenda);
            }
        } else {

            resposta =
            Var.valueOf("Cliente não encontrado");

            cronapi.json.Operations.setJsonOrMapField(context,
            Var.valueOf("erroPedido"),
            Var.VAR_TRUE);
        }
     } catch (Exception exception_exception) {
          exception = Var.valueOf(exception_exception);

        resposta =
        Var.valueOf("Erro ao solicitar a venda");
     }

    if (
    Var.valueOf(!resposta.equals(
    Var.VAR_NULL)).getObjectAsBoolean()) {

        cronapi.json.Operations.setJsonOrMapField(context,
        Var.valueOf("resposta"), resposta);
    }
    return context;
   }
 }.call();
}

}

