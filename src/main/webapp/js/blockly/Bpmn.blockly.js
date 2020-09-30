window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Bpmn = window.blockly.js.blockly.Bpmn || {};

/**
 * Bpmn
 */
window.blockly.js.blockly.Bpmn.abrir = async function() {

  this.cronapi.screen.openUrl(String(this.cronapi.util.getBaseUrl()) + String('/app/welcome/default/'), true, 0, 0);
}
