window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Anotacao = window.blockly.js.blockly.Anotacao || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.excluir = async function(anotacao) {
 var item, banco, nome, anotacoes, k, bd, j, lista;
  this.cronapi.json.setProperty(anotacao, 'exclusao', true);
  this.cronapi.json.deleteProperty(anotacao, '$$hashKey');
  this.cronapi.pouchdb.updateDoc(await this.blockly.js.blockly.Anotacao.criarBancoLocal(), anotacao, null, async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('success','Erro ao excluir anotação');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.obter();
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.criarBancoLocal = async function() {
 var item, anotacao, banco, nome, anotacoes, k, bd, j, lista;
  this.cronapi.screen.createScopeVariable('listaAnotacoes', []);
  return this.cronapi.pouchdb.createLocalDatabase('anotacoes', 'idb');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.inicializar = async function() {
 var item, anotacao, banco, nome, anotacoes, k, bd, j, lista;
  this.cronapi.screen.createScopeVariable('listaAnotacoes', []);
  await this.blockly.js.blockly.Anotacao.sincronizar();
}

function mathRandomInt(a, b) {
  if (a > b) {
    // Swap a and b to ensure a is smaller.
    var c = a;
    a = b;
    b = c;
  }
  return Math.floor(Math.random() * (b - a + 1) + a);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.inserir = async function(nome) {
 var item, anotacao, banco, anotacoes, k, bd, j, lista;
  banco = await this.blockly.js.blockly.Anotacao.criarBancoLocal();
  anotacao = this.cronapi.object.newObject({name: 'nome', value: nome});
  this.cronapi.object.setProperty(anotacao, '_id', String(mathRandomInt(1, 100000)));
  this.cronapi.pouchdb.createDoc(banco, anotacao, null, async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao inserir anotação');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.obter();
  }.bind(this));
  this.cronapi.screen.changeValueOfField('vars.nome', null);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.inserirLote = async function(lista) {
 var item, anotacao, banco, nome, anotacoes, k, bd, j;
  banco = await this.blockly.js.blockly.Anotacao.criarBancoLocal();
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Anotacao:listar', async function(sender_anotacoes) {
      anotacoes = sender_anotacoes;
    this.cronapi.pouchdb.createDocLote(banco, anotacoes, null, async function(sender_item) {
        item = sender_item;
      console.log(item);
    }.bind(this), async function(sender_item) {
        item = sender_item;
      await this.blockly.js.blockly.Anotacao.obter();
    }.bind(this));
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.sincronizar = async function() {
 var item, anotacao, banco, nome, anotacoes, k, bd, j, lista;
  this.cronapi.pouchdb.getAllDoc(await this.blockly.js.blockly.Anotacao.criarBancoLocal(), this.cronapi.json.createObjectFromString('{\"include_docs\": true}'), async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao sincronizar anotações');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.tratarDados(this.cronapi.json.getProperty(item, 'rows'));
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Anotacao:gerenciar', async function(sender_item) {
        item = sender_item;
      if (!this.cronapi.logic.isNullOrEmpty(item)) {
        await this.blockly.js.blockly.Anotacao.deletarBancoLocal(await this.blockly.js.blockly.Anotacao.criarBancoLocal());
        await this.blockly.js.blockly.Anotacao.inserirLote(item);
      }
    }.bind(this), this.cronapi.screen.getScopeVariable('listaAnotacoes'));
  }.bind(this));
}

/**
 * Anotacao
 */
window.blockly.js.blockly.Anotacao.obter = async function() {
 var item, anotacao, banco, nome, anotacoes, k, bd, j, lista;
  banco = await this.blockly.js.blockly.Anotacao.criarBancoLocal();
  this.cronapi.pouchdb.getAllDoc(banco, this.cronapi.json.createObjectFromString('{\"include_docs\": true}'), async function(sender_item) {
      item = sender_item;
    this.cronapi.screen.notify('error','Erro ao obter as anotações');
  }.bind(this), async function(sender_item) {
      item = sender_item;
    await this.blockly.js.blockly.Anotacao.tratarDados(this.cronapi.json.getProperty(item, 'rows'));
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.deletarBancoLocal = async function(bd) {
 var item, anotacao, banco, nome, anotacoes, k, j, lista;
  this.cronapi.pouchdb.getAllDoc(bd, this.cronapi.json.createObjectFromString('{\"include_docs\": true}'), async function(sender_item) {
      item = sender_item;
    console.log(item);
  }.bind(this), async function(sender_item) {
      item = sender_item;
    var k_list = this.cronapi.json.getProperty(item, 'rows');
    for (var k_index in k_list) {
      k = k_list[k_index];
      this.cronapi.pouchdb.deleteByIdDoc(bd, this.cronapi.json.getProperty(k, 'id'), this.cronapi.json.getProperty(this.cronapi.json.getProperty(k, 'value'), 'rev'), null, async function(sender_item) {
          item = sender_item;
        this.cronapi.screen.notify('success','Erro ao deletar registro do banco');
      }.bind(this), async function(sender_item) {
          item = sender_item;
        this.cronapi.screen.changeValueOfField("vars.nome", '');
      }.bind(this));
    }
  }.bind(this));
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Anotacao.tratarDados = async function(lista) {
 var item, anotacao, banco, nome, anotacoes, k, bd, j;
  this.cronapi.screen.changeValueOfField('listaAnotacoes', []);
  for (var j_index in lista) {
    j = lista[j_index];
    this.cronapi.screen.getScopeVariable('listaAnotacoes').push(this.cronapi.json.getProperty(j, 'doc'));
  }
  this.cronapi.screen.changeValueOfField("vars.nome", null);
}
