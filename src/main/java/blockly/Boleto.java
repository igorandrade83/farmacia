package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class Boleto {

public static final int TIMEOUT = 300;

/**
 *
 * @param vendaId
 * @return Var
 */
// Descreva esta função...
public static Var consultarDadosVenda(Var vendaId) throws Exception {
 return new Callable<Var>() {

   private Var mapa = Var.VAR_NULL;
   private Var result = Var.VAR_NULL;

   public Var call() throws Exception {

    mapa =
    cronapi.map.Operations.createObjectMap();

    result =
    cronapi.database.Operations.query(Var.valueOf("farmacia.entity.ClienteVenda"),Var.valueOf("select c.cliente, c.venda from ClienteVenda c where c.venda.id = :vendaId"),Var.valueOf("vendaId",vendaId));

    cronapi.map.Operations.setMapField(mapa,
    Var.valueOf("cliente"),
    cronapi.database.Operations.getField(result,
    Var.valueOf("this[0]")));

    cronapi.map.Operations.setMapField(mapa,
    Var.valueOf("venda"),
    cronapi.database.Operations.getField(result,
    Var.valueOf("this[1]")));
    return mapa;
   }
 }.call();
}

/**
 *
 * @param vendaId
 */
// Descreva esta função...
public static void emitir(Var vendaId) throws Exception {
  new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;
   private Var dataAtual = Var.VAR_NULL;
   private Var mapa = Var.VAR_NULL;
   private Var cliente = Var.VAR_NULL;
   private Var venda = Var.VAR_NULL;
   private Var nomeArquivo = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {

    try {

        dataAtual =
        cronapi.dateTime.Operations.getNowNoHour();

        mapa =
        Var.valueOf(consultarDadosVenda(vendaId));

        cliente =
        cronapi.map.Operations.getMapField(mapa,
        Var.valueOf("cliente"));

        venda =
        cronapi.map.Operations.getMapField(mapa,
        Var.valueOf("venda"));

        retorno =
        Var.valueOf(validar(
        cronapi.object.Operations.getObjectField(venda,
        Var.valueOf("statusVenda"))));

        if (
        Var.valueOf(!retorno.equals(
        Var.VAR_NULL)).getObjectAsBoolean()) {

            cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"), retorno);
        } else {

            nomeArquivo =
            Var.valueOf(
            Var.valueOf("boleto_").toString() +
            cronapi.dateTime.Operations.getNowInMilliseconds().toString());

            cronapi.io.Operations.startDownload(
            paymentslip.PaymentSlip.generatePaymentSlipByteArray(
            paymentslip.PaymentSlip.createInstanceOfPaymentSlip(
            paymentslip.PaymentSlip.chooseBank(
            Var.valueOf("BANCO_DO_BRASIL")),
            paymentslip.PaymentSlip.defineDatesOfPaymentSlip(
            paymentslip.PaymentSlip.createDatesOfPaymentSlip(
            cronapi.dateTime.Operations.getDay(
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("data"))),
            cronapi.dateTime.Operations.getMonth(
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("data"))),
            cronapi.dateTime.Operations.getYear(
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("data")))),
            paymentslip.PaymentSlip.createDatesOfPaymentSlip(
            cronapi.dateTime.Operations.getDay(
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("data"))),
            cronapi.dateTime.Operations.getMonth(
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("data"))),
            cronapi.dateTime.Operations.getYear(
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("data")))),
            paymentslip.PaymentSlip.createDatesOfPaymentSlip(
            cronapi.dateTime.Operations.getDay(dataAtual),
            cronapi.dateTime.Operations.getMonth(dataAtual),
            cronapi.dateTime.Operations.getYear(dataAtual))),
            paymentslip.PaymentSlip.createFavored(
            Var.valueOf("Cronapp"),
            Var.valueOf("1824"),
            Var.valueOf("4"),
            Var.valueOf("76000"),
            Var.valueOf("5"),
            Var.valueOf("1207113"),
            Var.valueOf("18"),
            paymentslip.PaymentSlip.createAddress(
            Var.valueOf("Rua Prof. Leopoldo Amaral, n• 366"),
            Var.valueOf("Pituba"),
            Var.valueOf("41.830-494"),
            Var.valueOf("Salvador"),
            Var.valueOf("BA")),
            Var.valueOf("9000206")),
            paymentslip.PaymentSlip.createPayer(
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("nome")),
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("cpf")),
            paymentslip.PaymentSlip.createAddress(
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("endereco")),
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("bairro")),
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("cep")),
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("cidade")),
            cronapi.object.Operations.getObjectField(cliente, Var.valueOf("uf")))),
            cronapi.object.Operations.getObjectField(venda, Var.valueOf("valor")),
            Var.valueOf("1234"),
            cronapi.list.Operations.newList(
            Var.valueOf("Efetuar o pagamento até a data do vencimento"),
            Var.valueOf("Após o vencimento multa de 0.05 ao mês")),
            cronapi.list.Operations.newList(
            Var.valueOf("Somente no Cronapp Bank"))),
            Var.valueOf("PDF")),
            Var.valueOf(
            nomeArquivo.toString() +
            Var.valueOf(".pdf").toString()));
        }
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

        cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"),
        Var.valueOf("Erro ao tentar gerar o boleto"), Var.VAR_NULL);

        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Erro ao tentar gerar o boleto"));
     }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param status
 * @return Var
 */
// Descreva esta função...
public static Var validar(Var status) throws Exception {
 return new Callable<Var>() {

   private Var retorno = Var.VAR_NULL;

   public Var call() throws Exception {

    retorno =
    Var.VAR_NULL;

    if (
    Var.valueOf(!
    cronapi.object.Operations.getObjectField(status, Var.valueOf("id")).equals(
    Var.valueOf(2))).getObjectAsBoolean()) {

        retorno =
        cronapi.object.Operations.getObjectField(status, Var.valueOf("descricao"));
    }
    return retorno;
   }
 }.call();
}

}

