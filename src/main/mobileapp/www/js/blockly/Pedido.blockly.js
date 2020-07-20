window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Pedido = window.blockly.js.blockly.Pedido || {};

/**
 * Pedido
 */
window.blockly.js.blockly.Pedido.finalizar = function() {
 var item, resposta, index, quantidade, produto, totalItem, codigo;

  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Pedido:salvarItens', function(sender_resposta) {
      resposta = sender_resposta;

    if (resposta) {

      this.cronapi.screen.changeView("#/app/logged/venda",[  ]);
    }
  }.bind(this),
  this.cronapi.screen.getScopeVariable(
  'listaItensPedido'),
  this.cronapi.screen.getScopeVariable(
  'cliente'),
  null);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.limparVariaveis = function() {
 var item, resposta, index, quantidade, produto, totalItem, codigo;

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
 var item, resposta, index, quantidade, produto, totalItem, codigo;

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
window.blockly.js.blockly.Pedido.excluir = function(index) {
 var item, resposta, quantidade, produto, totalItem, codigo;

  /*# sourceMappingStart=~G-{(YwoUi?SNqaecu)A */
  this.cronapi.screen.getScopeVariable(
  'listaItensPedido').splice((index - 1), 1);

  this.blockly.js.blockly.Pedido.calcularTotal();
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.inserir = function(produto, quantidade) {
 var item, resposta, index, totalItem, codigo;

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

      /*# sourceMappingStart=EM]VAuOL0hiD/}+8F(%9 */
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
window.blockly.js.blockly.Pedido.calcularTotal = function() {
 var item, resposta, index, quantidade, produto, totalItem, codigo;

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

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Pedido.lerCodigoBarras = function() {
 var item, resposta, index, quantidade, produto, totalItem, codigo;

  this.cronapi.cordova.camera.qrCodeScanner(
  'CODE_39',
  'Consultar o preço do produto', function(sender_codigo) {
      codigo = sender_codigo;

    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Produto:consultar', function(sender_item) {
        item = sender_item;

      if (
      !
      this.cronapi.logic.isNullOrEmpty(
      this.cronapi.object.getProperty(item,
      'msg'))) {

        this.cronapi.screen.notify('error',
        this.cronapi.object.getProperty(item,
        'msg'));
      } else {

        this.cronapi.screen.notify('info',
        [
        this.cronapi.object.getProperty(item,
        'nome'),
        ' - ',
        this.cronapi.object.getProperty(item,
        'precoCusto')].join(''));
      }
    }.bind(this), codigo);
  }.bind(this), function(sender_item) {
      item = sender_item;

    this.cronapi.screen.notify('error',item);
  }.bind(this));
}
