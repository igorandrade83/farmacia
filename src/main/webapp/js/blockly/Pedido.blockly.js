window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Pedido = window.blockly.js.blockly.Pedido || {};

/**
 * Pedido
 */
window.blockly.js.blockly.Pedido.finalizar = function() {
 var item, resposta, quantidade, produto, index, totalItem;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Pedido:salvarItens', function(sender_resposta) {
      resposta = sender_resposta;
    if (resposta) {
      this.cronapi.screen.changeView("#/home/logged/venda",[  ]);
    }
  }.bind(this), this.cronapi.screen.getScopeVariable('listaItensPedido'), this.cronapi.screen.getScopeVariable('cliente'));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.limparVariaveis = function() {
 var item, resposta, quantidade, produto, index, totalItem;
  this.cronapi.screen.changeValueOfField("vars.produto", null);
  this.cronapi.screen.changeValueOfField("vars.quantidade", null);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.criarLista = function() {
 var item, resposta, quantidade, produto, index, totalItem;
  this.cronapi.screen.createScopeVariable('listaItensPedido', []);
  this.cronapi.screen.createScopeVariable('valorTotal', 0);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.inserir = function(produto, quantidade) {
 var item, resposta, index, totalItem;
  if (!this.cronapi.logic.isNullOrEmpty(produto) && !this.cronapi.logic.isNullOrEmpty(quantidade)) {
    item = this.cronapi.object.newObject();
    this.cronapi.object.setProperty(item, 'produto', produto);
    this.cronapi.object.setProperty(item, 'quantidade', quantidade);
    this.cronapi.screen.getScopeVariable('listaItensPedido').push(item);
    this.blockly.js.blockly.Pedido.limparVariaveis();
    this.blockly.js.blockly.Pedido.calcularTotal();
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.excluir = function(index) {
 var item, resposta, quantidade, produto, totalItem;
  this.cronapi.screen.getScopeVariable('listaItensPedido').splice((index - 1), 1);
  this.blockly.js.blockly.Pedido.calcularTotal();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.calcularTotal = function() {
 var item, resposta, quantidade, produto, index, totalItem;
  this.cronapi.screen.changeValueOfField("vars.valorTotal", 0);
  var produto_list = this.cronapi.screen.getScopeVariable('listaItensPedido');
  for (var produto_index in produto_list) {
    produto = produto_list[produto_index];
    totalItem = this.cronapi.object.getProperty(produto, 'produto.precoVenda') * this.cronapi.object.getProperty(produto, 'quantidade');
    this.cronapi.screen.changeValueOfField("vars.valorTotal", this.cronapi.screen.getValueOfField("vars.valorTotal") + totalItem);
  }
}
