window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Boleto = window.blockly.js.blockly.Boleto || {};

/**
 * Boleto
 */
window.blockly.js.blockly.Boleto.emitir = function(venda) {


  if (
  /*# sourceMappingStart=fP=o5xmd0#Ms/I[|{HE= */
  2 ==
  this.cronapi.object.getObjectField(venda,
  'statusVenda')) {

    this.cronapi.util.callServerBlocklyNoReturn('blockly.Boleto:emitir',
    this.cronapi.object.getObjectField(venda,
    'id'));
  } else if (
  /*# sourceMappingStart=^-RJeGP73pOHofxNqAuT */
  1 ==
  this.cronapi.object.getObjectField(venda,
  'statusVenda')) {

    this.cronapi.screen.notify('warning',
    'A venda necessita de aprovação.');
  } else {

    this.cronapi.screen.notify('warning',
    'A venda foi recusada.');
  }
}
