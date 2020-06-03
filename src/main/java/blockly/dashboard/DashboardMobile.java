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

   public Var call() throws Exception {
    produtos = Var.valueOf(consultarProdutosMaisVendido());
    cronapi.chart.Operations.createChart(Var.valueOf("chart4029"), Var.valueOf("pie"), cronapi.map.Operations.getJsonOrMapField(produtos, Var.valueOf("legendas")), Var.VAR_NULL, cronapi.chart.Operations.createChartSerie(Var.valueOf("produtos"), cronapi.map.Operations.getJsonOrMapField(produtos, Var.valueOf("dados")), Var.VAR_NULL));
    return Var.VAR_NULL;
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
    legendas = cronapi.list.Operations.newList();
    dados = cronapi.list.Operations.newList();
    try {
         produtos = cronapi.database.Operations.query(Var.valueOf("farmacia.entity.Pedido"),Var.valueOf("select p.produto.nome, p.produto.id, SUM(p.quantidade) from Pedido p  group by p.produto.id"));
        for (Iterator it_i = produtos.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            cronapi.list.Operations.addLast(legendas,cronapi.list.Operations.getFirst((cronapi.json.Operations.toJson(i))));
            cronapi.list.Operations.addLast(dados,cronapi.list.Operations.getLast((cronapi.json.Operations.toJson(i))));
        } // end for
     } catch (Exception erro_exception) {
          erro = Var.valueOf(erro_exception);
         System.out.println(erro.getObjectAsString());
     }
    return cronapi.map.Operations.createObjectMapWith(Var.valueOf("legendas",legendas) , Var.valueOf("dados",dados));
   }
 }.call();
}

}

