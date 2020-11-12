function fn() {    
  var env = karate.env; // get java system property 'karate.env'
  karate.log('karate.env system property is:', env);
  var port = karate.properties['demo.server.port'];
  var protocol = 'http';

  if (karate.properties['demo.server.https'] == 'true') {
    protocol = 'https';
    karate.configure('ssl', true);
  }

//    var config = { demoBaseUrl: protocol + '://127.0.0.1:' + port };
//    if (karate.env == 'proxy') {
//      var proxyPort = karate.properties['demo.proxy.port'];
//      karate.configure('proxy', 'http://127.0.0.1:' + proxyPort);
//    }
//
//    if (karate.env != 'mock' && karate.env != 'proxy' && karate.env != 'contract') {
//      // 'callSingle' is guaranteed to run only once even across all threads
//      var result = karate.callSingle('classpath:demo/headers/common-noheaders.feature', config);
//      // and it sets a variable called 'authInfo' used in headers-single.feature
//      config.authInfo = { authTime: result.time, authToken: result.token };
//    }

  if (!env) {
    env = 'dev';  // a custom 'intelligent' default
  }

  var config = { // base config JSON
    env: env,
	myVarName: 'someValue'
	appId: 'my.app.id',
    appSecret: 'my.secret',
    someUrlBase: 'https://jsonplaceholder.typicode.com',
    anotherUrlBase: 'https://another-host.com/v1/',
    anotherUrlBase1: 'https://another-host.com/v1/'

  };

  if (env == 'staging') //dev or e2e or stage/pre-prod
  {
    // over-ride only those that need to be
    config.someUrlBase = 'https://jsonplaceholder.typicode.com';
  } else if (env == 'e2e') {
    config.anotherUrlBase = 'https://jsonplaceholder.typicode.com';
  } else if(env == 'qa'){
    config.anotherUrlBase1 =  'https://jsonplaceholder.typicode.com'
  }

    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);

  return config;
}