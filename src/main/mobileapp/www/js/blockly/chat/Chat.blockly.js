window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.chat = window.blockly.js.blockly.chat || {};
window.blockly.js.blockly.chat.Chat = window.blockly.js.blockly.chat.Chat || {};

/**
 * Chat
 */
window.blockly.js.blockly.chat.Chat.enviarMensagem = function(msg) {
 var item, resposta, i;

  this.cronapi.util.callServerBlocklyAsynchronous('blockly.chatbot.Watson:enviarMensagem', function(sender_resposta) {
      resposta = sender_resposta;

    var i_list =
    this.cronapi.object.getObjectField(resposta,
    'texto');
    for (var i_index in i_list) {
      i = i_list[i_index];

      console.log(
      this.cronapi.object.getObjectField(resposta,
      'context'));

      this.cronapi.screen.changeValueOfField(
      'context',
      this.cronapi.object.getObjectField(resposta,
      'context'));

      this.cronapi.chat.renderChatHtml(
      "crn-kendo-chat-952877",
      this.cronapi.chat.chatUserObj(
      '',
      this.cronapi.object.getObjectField(resposta,
      'user'),
      ''), i,
      'list', function(sender_item) {
          item = sender_item;

        console.log(item);
      }.bind(this), function(sender_item) {
          item = sender_item;

        console.log(item);
      }.bind(this));
    }
  }.bind(this),
  this.cronapi.screen.getValueOfField(
  'context'), msg);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.chat.Chat.iniciarWatson = function() {
 var item, resposta, i, msg;

  this.cronapi.screen.createScopeVariable(
  'vars.context',
  null);

  this.cronapi.screen.createScopeVariable(
  'vars.loginUsuario',
  null);

  this.cronapi.util.callServerBlocklyAsynchronous('blockly.chatbot.Watson:iniciar', function(sender_resposta) {
      resposta = sender_resposta;

    this.cronapi.screen.changeValueOfField(
    'context',
    this.cronapi.object.getObjectField(resposta,
    'context'));

    this.cronapi.chat.renderChatMessage(
    "crn-kendo-chat-952877",
    this.cronapi.object.getObjectField(resposta,
    'texto'),
    this.cronapi.chat.chatUserObj(
    '',
    this.cronapi.object.getObjectField(resposta,
    'user'),
    ''));

    this.cronapi.chat.renderChatSuggestedActions(
    "starter",
    [
    this.cronapi.chat.chatSuggestedActionObj(
    'Listar Medicamentos',
    'Listar Medicamentos'),
    this.cronapi.chat.chatSuggestedActionObj(
    'Comprar Medicamentos',
    'Comprar Medicamentos')], function(sender_item) {
        item = sender_item;
    }.bind(this), function(sender_item) {
        item = sender_item;
    }.bind(this));
  }.bind(this));

  this.cronapi.util.callServerBlocklyAsynchronous('blockly.UserManager:obterLoginUsuario', function(sender_item) {
      item = sender_item;

    this.cronapi.screen.changeValueOfField(
    'loginUsuario', item);
  }.bind(this));
}
