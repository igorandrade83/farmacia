package blockly.chatbot;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Watson {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Watson
public static Var iniciar() throws Exception {
 return new Callable<Var>() {

   private Var watson = Var.VAR_NULL;

   public Var call() throws Exception {

    watson =
    Var.valueOf(cronapi.watson.conversation.ConversationOperations.message(
    Var.valueOf("2018-02-16").getTypedObject(java.lang.String.class),
    Var.valueOf("apikey").getTypedObject(java.lang.String.class),
    Var.valueOf("xL1nLIhheJNk7U_kCOR8anA-U5LSYO04FIaJWcamWLV6").getTypedObject(java.lang.String.class),
    Var.VAR_NULL.getTypedObject(java.lang.String.class), Var.VAR_NULL.getTypedObject(java.util.Map.class),
    cronapi.object.Operations.newObject(Var.valueOf("com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions"),Var.valueOf("workspaceId",
    Var.valueOf("2b8372ac-2843-4a6c-938c-a6abf02db247"))).getTypedObject(com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions.class)));
    return
cronapi.map.Operations.createObjectMapWith(Var.valueOf("context",
cronapi.object.Operations.getObjectField(watson,
Var.valueOf("context"))) , Var.valueOf("texto",
cronapi.object.Operations.getObjectField(
cronapi.object.Operations.getObjectField(watson,
Var.valueOf("output")),
Var.valueOf("text[0]"))) , Var.valueOf("user",
Var.valueOf("PharmaBot")));
   }
 }.call();
}

/**
 *
 * @param context
 * @param msg
 * @return Var
 */
// Descreva esta função...
public static Var enviarMensagem(Var context, Var msg) throws Exception {
 return new Callable<Var>() {

   private Var watson = Var.VAR_NULL;

   public Var call() throws Exception {

    watson =
    Var.valueOf(cronapi.watson.conversation.ConversationOperations.message(
    Var.valueOf("2018-02-16").getTypedObject(java.lang.String.class),
    Var.valueOf("apikey").getTypedObject(java.lang.String.class),
    Var.valueOf("xL1nLIhheJNk7U_kCOR8anA-U5LSYO04FIaJWcamWLV6").getTypedObject(java.lang.String.class),
    Var.VAR_NULL.getTypedObject(java.lang.String.class), Var.VAR_NULL.getTypedObject(java.util.Map.class),
    cronapi.object.Operations.newObject(Var.valueOf("com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions"),Var.valueOf("workspaceId",
    Var.valueOf("2b8372ac-2843-4a6c-938c-a6abf02db247")),Var.valueOf("input",
    cronapi.object.Operations.newObject(Var.valueOf("com.ibm.watson.developer_cloud.conversation.v1.model.InputData"),Var.valueOf("text",msg))),Var.valueOf("context",context)).getTypedObject(com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions.class)));

    watson =
    Var.valueOf(filtarIntencao(watson));
    return
cronapi.map.Operations.createObjectMapWith(Var.valueOf("context",
cronapi.object.Operations.getObjectField(watson,
Var.valueOf("context"))) , Var.valueOf("texto",
cronapi.object.Operations.getObjectField(
cronapi.object.Operations.getObjectField(watson,
Var.valueOf("output")),
Var.valueOf("text"))) , Var.valueOf("user",
Var.valueOf("chatbot")));
   }
 }.call();
}

/**
 *
 * @param param_watson
 * @return Var
 */
// Descreva esta função...
public static Var filtarIntencao(Var param_watson) throws Exception {
 return new Callable<Var>() {

   // param
   private Var watson = param_watson;
   // end
   private Var intencoes = Var.VAR_NULL;
   private Var context = Var.VAR_NULL;
   private Var intencao = Var.VAR_NULL;
   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {

    intencoes =
    cronapi.object.Operations.getObjectField(watson,
    Var.valueOf("intents"));

    context =
    cronapi.object.Operations.getObjectField(watson,
    Var.valueOf("context"));

    if (
    /*# sourceMappingStart=M1!v9D_gN_#KQh`3|OZI */
    cronapi.logic.Operations.isNullOrEmpty(intencoes).negate().getObjectAsBoolean()) {

        System.out.println(
        Var.valueOf("listar_produtos").getObjectAsString());

        intencao =
        cronapi.list.Operations.getFirst(intencoes);

        if (
        Var.valueOf(
        Var.valueOf("listar_produtos").equals(
        cronapi.object.Operations.getObjectField(intencao,
        Var.valueOf("intent")))).getObjectAsBoolean()) {

            cronapi.json.Operations.setJsonOrMapField(context,
            Var.valueOf("listaProdutos"),
            blockly.Produto.listarProdutos());

            watson =
            Var.valueOf(cronapi.watson.conversation.ConversationOperations.message(
            Var.valueOf("2018-02-16").getTypedObject(java.lang.String.class),
            Var.valueOf("apikey").getTypedObject(java.lang.String.class),
            Var.valueOf("xL1nLIhheJNk7U_kCOR8anA-U5LSYO04FIaJWcamWLV6").getTypedObject(java.lang.String.class),
            Var.VAR_NULL.getTypedObject(java.lang.String.class), Var.VAR_NULL.getTypedObject(java.util.Map.class),
            cronapi.object.Operations.newObject(Var.valueOf("com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions"),Var.valueOf("workspaceId",
            Var.valueOf("2b8372ac-2843-4a6c-938c-a6abf02db247")),Var.valueOf("context",context)).getTypedObject(com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions.class)));
        }
    }

    if (
    Var.valueOf(
    cronapi.object.Operations.getObjectField(context,
    Var.valueOf("comprarProdutos")).getObjectAsBoolean() &&
    /*# sourceMappingStart=dtU+7nvTTMq#au:QTe#s */
    cronapi.logic.Operations.isNullOrEmpty(
    cronapi.object.Operations.getObjectField(context,
    Var.valueOf("codProduto"))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {

        if (
        /*# sourceMappingStart=87@fd1][KSl/6VEV9!Qx */
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.object.Operations.getObjectField(context,
        Var.valueOf("produtosCarrinho"))).negate().getObjectAsBoolean()) {

            lista =
            cronapi.object.Operations.getObjectField(context,
            Var.valueOf("produtosCarrinho"));

            cronapi.list.Operations.addLast(lista,
            cronapi.object.Operations.getObjectField(context,
            Var.valueOf("codProduto")));

            cronapi.json.Operations.setJsonOrMapField(context,
            Var.valueOf("produtosCarrinho"), lista);
        } else {

            cronapi.json.Operations.setJsonOrMapField(context,
            Var.valueOf("produtosCarrinho"),
            cronapi.list.Operations.newList(
            cronapi.object.Operations.getObjectField(context,
            Var.valueOf("codProduto"))));
        }

        cronapi.json.Operations.setJsonOrMapField(context,
        Var.valueOf("produtoAdicionado"),
        Var.VAR_TRUE);

        cronapi.json.Operations.setJsonOrMapField(context,
        Var.valueOf("codProduto"),
        Var.VAR_NULL);

        watson =
        Var.valueOf(cronapi.watson.conversation.ConversationOperations.message(
        Var.valueOf("2018-02-16").getTypedObject(java.lang.String.class),
        Var.valueOf("apikey").getTypedObject(java.lang.String.class),
        Var.valueOf("xL1nLIhheJNk7U_kCOR8anA-U5LSYO04FIaJWcamWLV6").getTypedObject(java.lang.String.class),
        Var.VAR_NULL.getTypedObject(java.lang.String.class), Var.VAR_NULL.getTypedObject(java.util.Map.class),
        cronapi.object.Operations.newObject(Var.valueOf("com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions"),Var.valueOf("workspaceId",
        Var.valueOf("2b8372ac-2843-4a6c-938c-a6abf02db247")),Var.valueOf("context",context)).getTypedObject(com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions.class)));
    }

    if (
    Var.valueOf(
    cronapi.object.Operations.getObjectField(context,
    Var.valueOf("finalizarCompra")).getObjectAsBoolean() &&
    /*# sourceMappingStart=:!3g},33]Cb6`?yvu9~* */
    cronapi.logic.Operations.isNullOrEmpty(
    cronapi.object.Operations.getObjectField(context,
    Var.valueOf("cpf"))).negate().getObjectAsBoolean()).getObjectAsBoolean()) {

        context =
        blockly.Pedido.salvarItensChatBot(context);

        watson =
        Var.valueOf(cronapi.watson.conversation.ConversationOperations.message(
        Var.valueOf("2018-02-16").getTypedObject(java.lang.String.class),
        Var.valueOf("apikey").getTypedObject(java.lang.String.class),
        Var.valueOf("xL1nLIhheJNk7U_kCOR8anA-U5LSYO04FIaJWcamWLV6").getTypedObject(java.lang.String.class),
        Var.VAR_NULL.getTypedObject(java.lang.String.class), Var.VAR_NULL.getTypedObject(java.util.Map.class),
        cronapi.object.Operations.newObject(Var.valueOf("com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions"),Var.valueOf("workspaceId",
        Var.valueOf("2b8372ac-2843-4a6c-938c-a6abf02db247")),Var.valueOf("context",context)).getTypedObject(com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions.class)));

        if (
        /*# sourceMappingStart=`}r_B-%fcVG$:DxACSq+ */
        cronapi.logic.Operations.isNullOrEmpty(
        cronapi.json.Operations.getJsonOrMapField(context,
        Var.valueOf("idVenda"))).negate().getObjectAsBoolean()) {

            blockly.Boleto.emitir(
            cronapi.json.Operations.getJsonOrMapField(context,
            Var.valueOf("idVenda")));
        }
    }
    return watson;
   }
 }.call();
}

}

