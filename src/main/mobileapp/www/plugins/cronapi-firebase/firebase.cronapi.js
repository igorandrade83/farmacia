(function() {
  'use strict';


   /**
   * @categoryName Firebase Realtime
   */
  this.cronapi.firebase = {};
  
  
  //Ref: https://firebase.google.com/docs/web/setup
  /**
   * @type function
   * @name {{configFirebase}}
   * @description {{configFirebaseDescription}}
   */
  this.cronapi.firebase.configFirebase = function(/** @type {ObjectType.STRING} @description {{firebaseApiKey}} */	apiKey, /** @type {ObjectType.STRING} @description {{firebaseAuthDomain}} */	authDomain, /** @type {ObjectType.STRING} @description {{firebaseDatabaseURL}} */	databaseURL, /** @type {ObjectType.STRING} @description {{firebaseProjectId}}*/	projectId, /** @type {ObjectType.STRING} @description {{firebaseStorageBucket}} */	storageBucket, /** @type {ObjectType.STRING} @description {{messagingSenderId}}*/	messagingSenderId, /** @type {ObjectType.STRING} @description {{firebaseProvider}} */	provider, /** @type {ObjectType.STRING} @description {{firebaseUID}} */	uid) {
		var config = { 
			apiKey : apiKey,
			authDomain : authDomain,
			databaseURL : databaseURL,
			projectId : projectId,
			storageBucket : storageBucket,
			messagingSenderId : messagingSenderId,
			provider : provider,
			uid : uid
		};
		if(window.firebase.apps.length == 0)
		window.firebase.initializeApp(config);
  };
  
  
  
  //Ref: https://firebase.google.com/docs/reference/js/firebase.database
  /**
   * @type function
   * @name {{firebaseGetDatabase}}
   * @description {{firebaseGetDatabaseDescription}}
   * @returns {ObjectType.OBJECT}
   */
  this.cronapi.firebase.getDatabase = function(/** @type {ObjectType.STRING} @description {{firebaseOptionalAppName}} */	optionalAppName) {
    if(optionalAppName)		return window.firebase.database(optionalAppName);
		return window.firebase.database();
  };
  
  //Ref: https://firebase.google.com/docs/database/web/read-and-write
  /**
   * @type function
   * @name {{firebaseAddData}}
   * @description {{firebaseAddDataDescription}}
   */
  this.cronapi.firebase.addData = function(/** @type {ObjectType.OBJECT} @description {{firebaseDatabase}} */	database , /** @type {ObjectType.STRING} @description {{firebasePath}} */ path , /** @type {ObjectType.OBJECT} @description {{firebaseData}} */ data) {
		database.ref(path).set(data);
  };
  
  
  //Ref: https://firebase.google.com/docs/database/web/read-and-write
  /**
   * @type function
   * @name {{firebaseAddOnEvent}}
   * @description {{firebaseAddOnEventDescription}}
   */
  this.cronapi.firebase.addOnEvent = function(/** @type {ObjectType.OBJECT} @description {{firebaseDatabase}} */	database , /** @type {ObjectType.STRING} @description {{firebasePath}} */ path , /** @type {ObjectType.STATEMENTSENDER} @description {{statement}} */ statement) {
		database.ref(path).on('value',function(snapshot){
		  statement(snapshot.val());
		})
  };
  
  
  //Ref: https://firebase.google.com/docs/database/web/read-and-write
  /**
   * @type function
   * @name {{firebaseAddOnceEvent}}
   * @description {{firebaseAddOnceEventDescription}}
   */
  this.cronapi.firebase.addOnceEvent = function(/** @type {ObjectType.OBJECT} @description {{firebaseDatabase}} */	database , /** @type {ObjectType.STRING} @description {{firebasePath}} */ path , /** @type {ObjectType.STATEMENTSENDER} @description {{statement}} */ statement) {
		database.ref(path).once('value').then(function(snapshot){
		  statement(snapshot.val());
		});
  };
  
    //Ref: https://firebase.google.com/docs/database/web/read-and-write
  /**
   * @type function
   * @name {{firebaseUpdateData}}
   * @description {{firebaseUpdateDataDescription}}
   */
  this.cronapi.firebase.firebaseUpdateData = function(/** @type {ObjectType.OBJECT} @description {{firebaseDatabase}} */	database , /** @type {ObjectType.STRING} @description {{firebasePath}} */ path , /** @type {ObjectType.OBJECT} @description {{firebaseData}} */ data) {
		database.ref(path).update(data);
  };
  
  
      //Ref: https://firebase.google.com/docs/database/web/read-and-write
  /**
   * @type function
   * @name {{firebasePushData}}
   * @description {{firebasePushDataDescription}}
   */
  this.cronapi.firebase.pushData = function(/** @type {ObjectType.OBJECT} @description {{firebaseDatabase}} */	database , /** @type {ObjectType.STRING} @description {{firebasePath}} */ path , /** @type {ObjectType.OBJECT} @description {{firebaseData}} */ data) {
		database.ref(path +'/'+ database.ref(path).push().key ).set(data);
  };
  
  
  
}).bind(window)();
