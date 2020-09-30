window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.Home = window.blockly.js.blockly.auth.Home || {};

/**
 * Home
 */
window.blockly.js.blockly.auth.Home.change = async function() {

  this.cronapi.screen.changeView("#/app/login",[  ]);
}
