window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Fornecedor = window.blockly.js.blockly.Fornecedor || {};

/**
 * Fornecedor
 */
window.blockly.js.blockly.Fornecedor.obterDadosReceita = async function(cnpj) {
 var item, resposta;
  this.cronapi.util.getURLFromOthers('GET', 'application/json', String('https://www.receitaws.com.br/v1/cnpj/') + String(cnpj), null, null, function(sender_resposta) {
      resposta = sender_resposta;
    console.log(resposta);
  }.bind(this), function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('info','Erro ao buscar o CNPJ, por favor preencha os dados');
  }.bind(this));
}
