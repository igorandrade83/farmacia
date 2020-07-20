package blockly.dashboard;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DashboardMobile {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// DashboardMobile
public static Var obterDados() throws Exception {
 return new Callable<Var>() {

   private Var produtos = Var.VAR_NULL;
   private Var dadosFaturamento = Var.VAR_NULL;

   public Var call() throws Exception {

    produtos =
    Var.valueOf(consultarProdutosMaisVendido());

    dadosFaturamento =
    Var.valueOf(ObterDadosVendas());

    cronapi.chart.Operations.createChart(
    Var.valueOf("chart4029"),
    Var.valueOf("pie"),
    cronapi.map.Operations.getJsonOrMapField(produtos,
    Var.valueOf("legendas")), Var.VAR_NULL,
    cronapi.chart.Operations.createChartSerie(
    Var.valueOf("produtos"),
    cronapi.map.Operations.getJsonOrMapField(produtos,
    Var.valueOf("dados")), Var.VAR_NULL));

    cronapi.chart.Operations.createChart(
    Var.valueOf("chart4454"),
    Var.valueOf("line"),
    cronapi.map.Operations.getJsonOrMapField(dadosFaturamento,
    Var.valueOf("legendas")), Var.VAR_NULL,
    cronapi.chart.Operations.createChartSerie(
    Var.valueOf("Total"),
    cronapi.map.Operations.getJsonOrMapField(dadosFaturamento,
    Var.valueOf("dados")), Var.VAR_NULL));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var ObterDadosVendas() throws Exception {
 return new Callable<Var>() {

   private Var legendas = Var.VAR_NULL;
   private Var dados = Var.VAR_NULL;
   private Var faturamento = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {

    legendas =
    cronapi.list.Operations.newList();

    dados =
    cronapi.list.Operations.newList();

    try {

        faturamento =
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Venda"),Var.valueOf("select extract(day from v.data), \n        extract(month from v.data), \n        extract(year from v.data), SUM(v.valor) from Venda v \ngroup by extract(day from v.data), extract(month from v.data), extract(year from v.data)"));

        for (Iterator it_i = faturamento.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());

            cronapi.list.Operations.addLast(legendas,
            Var.valueOf(
            cronapi.list.Operations.get((
            cronapi.json.Operations.toJson(i)),
            Var.valueOf(1)).toString() +
            Var.valueOf("/").toString() +
            cronapi.list.Operations.get((
            cronapi.json.Operations.toJson(i)),
            Var.valueOf(2)).toString() +
            Var.valueOf("/").toString() +
            cronapi.list.Operations.get((
            cronapi.json.Operations.toJson(i)),
            Var.valueOf(3)).toString()));

            cronapi.list.Operations.addLast(dados,
            cronapi.list.Operations.getLast((
            cronapi.json.Operations.toJson(i))));
        } // end for
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

        System.out.println(erro.getObjectAsString());
     }
    return
cronapi.map.Operations.createObjectMapWith(Var.valueOf("legendas",legendas) , Var.valueOf("dados",dados));
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var consultarProdutosMaisVendido() throws Exception {
 return new Callable<Var>() {

   private Var produtos = Var.VAR_NULL;
   private Var legendas = Var.VAR_NULL;
   private Var dados = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var erro = Var.VAR_NULL;

   public Var call() throws Exception {

    legendas =
    cronapi.list.Operations.newList();

    dados =
    cronapi.list.Operations.newList();

    try {

        produtos =
        cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Pedido"),Var.valueOf("select p.produto.nome, p.produto.id, SUM(p.quantidade) from Pedido p where p.venda.statusVenda.id = :vendaStatusVendaId group by p.produto.id"),Var.valueOf("vendaStatusVendaId",
        Var.valueOf(2)));

        for (Iterator it_i = produtos.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());

            cronapi.list.Operations.addLast(legendas,
            cronapi.list.Operations.getFirst((
            cronapi.json.Operations.toJson(i))));

            cronapi.list.Operations.addLast(dados,
            cronapi.list.Operations.getLast((
            cronapi.json.Operations.toJson(i))));
        } // end for
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);

        cronapi.util.Operations.log(
        Var.valueOf("General"),
        Var.valueOf("SEVERE"), erro, Var.VAR_NULL);
     }
    return
cronapi.map.Operations.createObjectMapWith(Var.valueOf("legendas",legendas) , Var.valueOf("dados",dados));
   }
 }.call();
}

}

