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

      this.cronapi.screen.changeView("#/home/vendedor/boleto",[  ]);
    }
  }.bind(this),
  this.cronapi.screen.getScopeVariable(
  'listaItensPedido'),
  this.cronapi.screen.getScopeVariable(
  'cliente'),
  this.cronapi.util.getBaseUrl());
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.limparVariaveis = function() {
 var item, resposta, quantidade, produto, index, totalItem;

  this.cronapi.screen.changeValueOfField(
  "vars.produto",
  null);

  this.cronapi.screen.changeValueOfField(
  "vars.quantidade",
  null);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.criarLista = function() {
 var item, resposta, quantidade, produto, index, totalItem;

  this.cronapi.screen.createScopeVariable(
  'listaItensPedido',
  []);

  this.cronapi.screen.createScopeVariable(
  'valorTotal',
  0);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.inserir = function(produto, quantidade) {
 var item, resposta, index, totalItem;

  if (
  /*# sourceMappingStart=/`R.sftKaGQ)(pn;*F41 */
  !
  this.cronapi.logic.isNullOrEmpty(produto) &&
  !
  this.cronapi.logic.isNullOrEmpty(quantidade)) {

    if (
    quantidade >
    0) {

      item =
      this.cronapi.object.newObject();

      this.cronapi.object.setProperty(item,
      'produto', produto);

      this.cronapi.object.setProperty(item,
      'quantidade', quantidade);

      /*# sourceMappingStart=c,3A:a@!eAaW7U`y^v-- */
      this.cronapi.screen.getScopeVariable(
      'listaItensPedido').push(item);

      this.blockly.js.blockly.Pedido.limparVariaveis();

      this.blockly.js.blockly.Pedido.calcularTotal();
    } else {

      this.cronapi.screen.notify('warning',
      'Quantidade tem que ser maior que 0');
    }
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.excluir = function(index) {
 var item, resposta, quantidade, produto, totalItem;

  /*# sourceMappingStart=~G-{(YwoUi?SNqaecu)A */
  this.cronapi.screen.getScopeVariable(
  'listaItensPedido').splice((index - 1), 1);

  this.blockly.js.blockly.Pedido.calcularTotal();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.calcularTotal = function() {
 var item, resposta, quantidade, produto, index, totalItem;

  this.cronapi.screen.changeValueOfField(
  "vars.valorTotal",
  0);

  var produto_list =
  this.cronapi.screen.getScopeVariable(
  'listaItensPedido');
  for (var produto_index in produto_list) {
    produto = produto_list[produto_index];

    totalItem =
    /*# sourceMappingStart=6t8@@r|R;5BUF/U~KDd5 */
    this.cronapi.object.getProperty(produto,
    'produto.precoVenda') *
    this.cronapi.object.getProperty(produto,
    'quantidade');

    this.cronapi.screen.changeValueOfField(
    "vars.valorTotal",
    /*# sourceMappingStart=Of8L3e@rJpMFJ6wv#/xY */
    this.cronapi.screen.getValueOfField(
    "vars.valorTotal") + totalItem);
  }
}
