window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Cliente = window.blockly.js.blockly.Cliente || {};

/**
 * Cliente
 */
window.blockly.js.blockly.Cliente.getCep = async function(cep) {
 var item, resposta;
  this.cronapi.util.getCEP(cep, async function(sender_resposta) {
      resposta = sender_resposta;
    if (!this.cronapi.object.getObjectField(resposta, 'erro')) {
      this.cronapi.screen.changeValueOfField("Cliente.active.bairro", this.cronapi.object.getObjectField(resposta, 'bairro'));
      this.cronapi.screen.changeValueOfField("Cliente.active.cidade", this.cronapi.object.getObjectField(resposta, 'localidade'));
      this.cronapi.screen.changeValueOfField("Cliente.active.uf", this.cronapi.object.getObjectField(resposta, 'uf'));
      this.cronapi.screen.changeValueOfField("Cliente.active.endereco", this.cronapi.object.getObjectField(resposta, 'logradouro'));
    }
  }.bind(this));
}
