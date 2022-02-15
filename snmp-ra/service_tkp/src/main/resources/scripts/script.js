importPackage(javax.slee.profile);
importPackage(javax.slee.management);
importPackage(javax.slee.resource);
importPackage(javax.slee);
importPackage(java.util);
importPackage(java.lang.reflect);
var mmConnection = null;
//mobicents
jmxConnect("localhost:1090","jmxconnector");
//opencloud
//jmxConnect("localhost:1199","opencloud/rhino","admin","password");
var slee = mbean("javax.slee.management:name=SleeManagement",false);
//var activityMBean = mbean("org.mobicents.slee:name=ActivityManagementMBean",false);
var deploymentMBean = mbean(slee.DeploymentMBean,false);
var resourceAdaptorMBean = mbean(slee.ResourceManagementMBean,false);
var profileMBean = mbean(slee.ProfileProvisioningMBean,false);
var serviceMBean = mbean(slee.ServiceManagementMBean,false);
var traceMBean = mbean(slee.TraceMBean,false);
function jmxConnect(hostport,name,username,password) {
    if (mmConnection != null) {
        // close the existing connection
        try {
            mmConnection.close();
        } catch (e) {
        }
    }

    var JMXServiceURL = javax.management.remote.JMXServiceURL;
    var JMXConnectorFactory = javax.management.remote.JMXConnectorFactory;

    var urlPath = "/jndi/rmi://" + hostport + "/jmxconnector";
    //var urlPath = "rmi://" + hostport + "/opencloud/rhino";
    //service:jmx:rmi:///jndi/rmi://lo:1199/opencloud/rhino
    urlPath = "service:jmx:rmi://"+hostport+"/jndi/rmi://"+hostport+"/"+name;
    //urlPath = "service:jmx:rmi://lo:1199/jndi/opencloud/rhinossl";
//    service:jmx:rmi://lo:1199/jndi/rmi://lo:1199/jmxconnector

//    var url = new JMXServiceURL("rmi", "lo", 1199, urlPath);
   var map = new java.util.HashMap();
   var creds = new Array();
   creds[0] = username;
   creds[1] = password;
   map.put('jmx.remote.credentials',objectArray(creds));
    var url = new JMXServiceURL(urlPath);
    println("connecting to " + url.toString());
    try {
    var jmxc = JMXConnectorFactory.connect(url,map);
    // note that the "mmConnection" is a global variable!
    //
    mmConnection = jmxc.getMBeanServerConnection();
  } catch (x){
      println(x.toString());
  }
}
jmxConnect.docString = "connects to the given host, port (specified as name:port)";

function mbeanConnection() {    
    if (mmConnection == null) {        
        throw "Not connected to MBeanServer yet!";
    }

    return mmConnection;
}
mbeanConnection.docString = "returns the current MBeanServer connection"

/**
 * Returns a platform MXBean proxy for given MXBean name and interface class
 */
function newPlatformMXBeanProxy(name, intf) {
    var factory = java.lang.management.ManagementFactory;
    return factory.newPlatformMXBeanProxy(mbeanConnection(), name, intf);
}
newPlatformMXBeanProxy.docString = "returns a proxy for a platform MXBean";

/**
 * Wraps a string to ObjectName if needed.
 */
function objectName(objName) {
    var ObjectName = Packages.javax.management.ObjectName;
    if (objName instanceof ObjectName) {
        return objName;
    } else {
        return new ObjectName(objName);
    }
}
objectName.docString = "creates JMX ObjectName for a given String";


/**
 * Creates a new (M&M) Attribute object
 *
 * @param name name of the attribute
 * @param value value of the attribute
 */
function attribute(name, value) {
    var Attribute = Packages.javax.management.Attribute;
    return new Attribute(name, value);
}
attribute.docString = "returns a new JMX Attribute using name and value given";

/**
 * Returns MBeanInfo for given ObjectName. Strings are accepted.
 */
function mbeanInfo(objName) {
    objName = objectName(objName);
    return mbeanConnection().getMBeanInfo(objName);
}
mbeanInfo.docString = "returns MBeanInfo of a given ObjectName";

/**
 * Returns ObjectInstance for a given ObjectName.
 */
function objectInstance(objName) {
    objName = objectName(objName);
    return mbeanConnection().objectInstance(objectName);
}
objectInstance.docString = "returns ObjectInstance for a given ObjectName";

/**
 * Queries with given ObjectName and QueryExp.
 * QueryExp may be null.
 *
 * @return set of ObjectNames.
 */
function queryNames(objName, query) {
    objName = objectName(objName);
    if (query == undefined) query = null;
    return mbeanConnection().queryNames(objName, query);
}
queryNames.docString = "returns QueryNames using given ObjectName and optional query";


/**
 * Queries with given ObjectName and QueryExp.
 * QueryExp may be null.
 *
 * @return set of ObjectInstances.
 */
function queryMBeans(objName, query) {
    objName = objectName(objName);
    if (query == undefined) query = null;
    return mbeanConnection().queryMBeans(objName, query);
}
queryMBeans.docString = "return MBeans using given ObjectName and optional query";

// wraps a script array as java.lang.Object[]
function objectArray(array) {
    var len = array.length;
    var res = java.lang.reflect.Array.newInstance(java.lang.Object, len);
    for (var i = 0; i < array.length; i++) {
        res[i] = array[i];
    }
    return res;
}

// wraps a script (string) array as java.lang.String[]
function stringArray(array) {
    var len = array.length;
    var res = java.lang.reflect.Array.newInstance(java.lang.String, len);
    for (var i = 0; i < array.length; i++) {
        res[i] = String(array[i]);
    }
    return res;
}

// script array to Java List
function toAttrList(array) {
    var AttributeList = Packages.javax.management.AttributeList;
    if (array instanceof AttributeList) {
        return array;
    }
    var list = new AttributeList(array.length);
    for (var index = 0; index < array.length; index++) {
        list.add(array[index]);
    }
    return list;
}

// Java Collection (Iterable) to script array
function toArray(collection) {
    if (collection instanceof Array) {
        return collection;
    }
    var itr = collection.iterator();
    var array = new Array();
    while (itr.hasNext()) {
        array[array.length] = itr.next();
    }
    return array;
}

// gets MBean attributes
function getMBeanAttributes(objName, attributeNames) {
    objName = objectName(objName);
    return mbeanConnection().getAttributes(objName,stringArray(attributeNames));
}
getMBeanAttributes.docString = "returns specified Attributes of given ObjectName";

// gets MBean attribute
function getMBeanAttribute(objName, attrName) {
    objName = objectName(objName);
    return mbeanConnection().getAttribute(objName, attrName);
}
getMBeanAttribute.docString = "returns a single Attribute of given ObjectName";


// sets MBean attributes
function setMBeanAttributes(objName, attrList) {
    objName = objectName(objName);
    attrList = toAttrList(attrList);
    return mbeanConnection().setAttributes(objName, attrList);
}
setMBeanAttributes.docString = "sets specified Attributes of given ObjectName";

// sets MBean attribute
function setMBeanAttribute(objName, attrName, attrValue) {
    var Attribute = Packages.javax.management.Attribute;
    objName = objectName(objName);
    mbeanConnection().setAttribute(objName, new Attribute(attrName, attrValue));
}
setMBeanAttribute.docString = "sets a single Attribute of given ObjectName";


// invokes an operation on given MBean
function invokeMBean(objName, operation, params, signature) {
    objName = objectName(objName);
    params = objectArray(params);
    signature = stringArray(signature);
    println(objName + " " + operation + " < " + toString(params) + " " + toString(signature));
    var res;
    try {
      res = mbeanConnection().invoke(objName, operation, params, signature);
    println(objName + " " + operation + " > " + toString(res));
      
    } catch (x) {
      println(objName + " " + operation + " ! " + x);
      throw x;
    }
    return res;
}
invokeMBean.docString = "invokes MBean operation on given ObjectName";

/**
 * Wraps a MBean specified by ObjectName as a convenient
 * script object -- so that setting/getting MBean attributes
 * and invoking MBean method can be done with natural syntax.
 *
 * @param objName ObjectName of the MBean
 * @param async asynchornous mode [optional, default is false]
 * @return script wrapper for MBean
 *
 * With async mode, all field, operation access is async. Results
 * will be of type FutureTask. When you need value, call 'get' on it.
 */
function mbean(objName, async) {
    objName = objectName(objName);
    var info = mbeanInfo(objName);    
    var attrs = info.attributes;
    var attrMap = new Object;
    for (var index in attrs) {
        //println("attr "  +attrs[index].name);
        attrMap[attrs[index].name] = attrs[index];
    }
    var opers = info.operations;
    var operMap = new Object;
    var operTypeMap = new Object;

    for (var index in opers) {
        var k=""; 
        for(var s = 0 ; s < opers[index].signature.length ; s++) {
          k+=opers[index].signature[s].type;
        }
        //println("op " + opers[index].name + " "  + k);

        operMap[opers[index].name] = opers[index];
        operTypeMap[opers[index].name + k] = opers[index];
    }

    function isAttribute(name) {
        return name in attrMap;
    }

    function isOperation(name) {
        return name in operMap;
    }

    return new JSAdapter() {
        __has__: function (name) {
            return isAttribute(name) || isOperation(name);
        },
        __get__: function (name) {
            if (isAttribute(name)) {
                //println("attribute " + name);
                if (async) {
                    return getMBeanAttribute.future(objName, name); 
                } else {
                    return getMBeanAttribute(objName, name); 
                }
            } else if (isOperation(name)) {
                //println("operation " + name);
                return function() {
                    var params = objectArray(arguments);
                    var k=""; 
                    for(var s = 0 ; s < arguments.length ; s++) {
                    try {
                      k+=arguments[s].getClass().getName();
                      } catch(x) {
                      k+='java.lang.String';
                      }
                    }
                    //println ("**" + name + " " + k);
                    var oper = operTypeMap[name + k];

                    var sigs = oper.signature;
                    var sigNames = new Array(sigs.length);
                    for (var index in sigs) {
                        //print(sigs[index].toString());
                        sigNames[index] = sigs[index].getType();
                    }
                    if (async) {
                        return invokeMBean.future(objName, name, 
                                                  params, sigNames);
                    } else {
                        return invokeMBean(objName, name, params, sigNames);
                    }
                }
            } else {
                println(name + "not found");
                return undefined;
            }
        },
        __put__: function (name, value) {
            if (isAttribute(name)) {
                if (async) {
                    setMBeanAttribute.future(objName, name, value);
                } else {
                    setMBeanAttribute(objName, name, value);
                }
            } else {
                println(name + "not found");
                return undefined;
            }
        }
    };
}
mbean.docString = "returns a conveninent script wrapper for a MBean of given ObjectName";

if (this.application != undefined) {    
    this.application.addTool("JMX Connect", 
        // connect to a JMX MBean Server 
        function () {
            var url = prompt("Connect to JMX server (host:port)");
            if (url != null) {
                try {
                    jmxConnect(url);
                    alert("connected!");
                } catch (e) {
                    error(e, "Can not connect to " + url);
                }
            }
        });
}
function toString(a){
  var k = "["
  for(var s = 0 ; s < a.length ; s++) {
    k+=s+"="+a[s] + ", " 
  }

  return k += "]"
}

//FUNCTION CODE FROM mm.js

function match(a,v) {
  for(var s = 0 ; s < a.length ; s++) {
    //alert("checking:" + a + " " + this[s] + " " + this[s].match(a));
    if(a[s].match(v)){
      return true
    }
  }
  return false;
}

    var deployBase = 'file:///tmp/';
    
  var duID ;
  try {
    duID = deploymentMBean.getDeployableUnit(deployBase + 'snmp-ra-1.0-SNAPSHOT-du.jar');
    println(duID.toString());
  } catch (x) {
    println(x);
  }
  if (duID == null)
    deploymentMBean.install(deployBase + 'snmp-ra-1.0-SNAPSHOT-du.jar');
  else
    deploymentMBean.uninstall(duID);
  
  var duID ;
  try {
    duID = deploymentMBean.getDeployableUnit(deployBase + 'snmp-service-1.0-SNAPSHOT-du.jar');
    println(duID.toString());
  } catch (x) {
    println(x);
  }
  if (duID == null)
    deploymentMBean.install(deployBase + 'snmp-service-1.0-SNAPSHOT-du.jar');
  else
    deploymentMBean.uninstall(duID);
  

 var serviceID = new ServiceID('SNMP SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');

 var sbbID = new SbbID('SNMP SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');

  /*
  //get sbb tracer names
  var tracerNames = traceMBean.getSbbTracerNames(serviceID,sbbID);
  //get sbb tracer level

  for(var i=0; i < tracerNames.length; i++){
    traceMBean.getTracerLevel(serviceID,sbbID,tracerNames[i]);
    debug(serviceID + ' ' + sbbID + ' ' + tracerNames[i] + level);
  }

  //set sbb tracer level
  traceMBean.setSbbTracerLevel(serviceID,javax.slee.facilities.TraceLevel.FINEST);
  */  
  
  
  //locate ra with type

  

 var raLinkName = 'SNMP Resource Adaptor Entity Link';
 var raEntityName = 'snmp-ra-entity';
 
 var raID = new ResourceAdaptorID('SNMP Resource Adaptor','MOFOKOM','1.0-SNAPSHOT');

 var properties = new javax.slee.resource.ConfigProperties();
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('WORK_QUEUE','java.lang.Integer', java.lang.Integer.valueOf(1)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(2)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_TIMEOUT','java.lang.Long', java.lang.Long.valueOf(120)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SNMP_CONTEXT_VERSION','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('HOST','java.lang.String', 'localhost'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('LISTEN','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('BIND_ADDRESS','java.lang.String', '0.0.0.0'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PORT','java.lang.Integer', java.lang.Integer.valueOf(162)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SOCKET_TYPE','java.lang.String', 'Standard'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_ENGINE_ID','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_NAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USERNAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_AUTH_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('AUTH_PROTOCOL','java.lang.String', 'MD5'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PRIV_PROTOCOL','java.lang.String', 'DES'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_PRIV_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_AUTHENTICATION','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_PRIVACY','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('COMMUNITY','java.lang.String', 'public'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_RECV_SIZE','java.lang.Integer', java.lang.Integer.valueOf(10000)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('RETRY_INTERVALS','java.lang.String', '1000,2000,5000'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('ACTIVITY_DIMENSION','java.lang.Integer', java.lang.Integer.valueOf(5)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('WORK_QUEUE','java.lang.Integer', java.lang.Integer.valueOf(1)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(2)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_TIMEOUT','java.lang.Long', java.lang.Long.valueOf(120)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SNMP_CONTEXT_VERSION','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('HOST','java.lang.String', 'localhost'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('LISTEN','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('BIND_ADDRESS','java.lang.String', '0.0.0.0'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PORT','java.lang.Integer', java.lang.Integer.valueOf(162)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SOCKET_TYPE','java.lang.String', 'Standard'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_ENGINE_ID','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_NAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USERNAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_AUTH_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('AUTH_PROTOCOL','java.lang.String', 'MD5'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PRIV_PROTOCOL','java.lang.String', 'DES'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_PRIV_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_AUTHENTICATION','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_PRIVACY','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('COMMUNITY','java.lang.String', 'public'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_RECV_SIZE','java.lang.Integer', java.lang.Integer.valueOf(10000)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('RETRY_INTERVALS','java.lang.String', '1000,2000,5000'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('ACTIVITY_DIMENSION','java.lang.Integer', java.lang.Integer.valueOf(5)));
 

    var installed = false;
    try {
      resourceAdaptorMBean.getResourceAdaptor(raEntityName);
      installed = true;
    } catch (x) {
      //not installed
    }

    //already installed 
    if(installed) {

      //get state
      var state = resourceAdaptorMBean.getState(raEntityName);

      if (javax.slee.management.ResourceAdaptorEntityState.ACTIVE.equals(state)) {
        //deactivate ra entity
        resourceAdaptorMBean.deactivateResourceAdaptorEntity(raEntityName);
      }

      if(resourceAdaptorMBean.getLinkNames(raEntityName).length != 0){
        resourceAdaptorMBean.unbindLinkName(raLinkName);
      }

      resourceAdaptorMBean.removeResourceAdaptorEntity(raEntityName);
    } else {
      //create ra entity
      resourceAdaptorMBean.createResourceAdaptorEntity(raID,raEntityName,properties);

      //bind link
      resourceAdaptorMBean.bindLinkName(raEntityName,raLinkName);

      //activate ra entity
      resourceAdaptorMBean.activateResourceAdaptorEntity(raEntityName);
    }

    //get ra entity tracer 
    var tracerNames = traceMBean.getResourceAdaptorEntityTracerNames(raEntityName);

    //set ra entity tracer nb. FINEST -root = ""
    for(var i=0; i < tracerNames.length; i++){
      var lever = traceMBean.getTracerLevel(raEntityName,tracerNames[i]);
      traceMBean.setResourceAdaptorEntityTraceLevel(raEntityName,tracerName[i],javax.slee.facilities.TraceLevel.FINEST);
      debug(raEntityName + ' ' + tracerNames[i] + ' ' + level.toString());
    }
  
	
    var serviceId = new ServiceID('SNMP SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');
    
    //get state
    var serviceState = serviceMBean.getState(serviceId);

    //toggle 
    if(serviceState.isInactive()){
      //activate service
      serviceMBean.activate(serviceId);
    }else{
      //deactivate service
      serviceMBean.deactivate(serviceId);
    }
  

 var serviceID = new ServiceID('SNMP SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');

 var sbbID = new SbbID('SNMP SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');

  /*
  //get sbb tracer names
  var tracerNames = traceMBean.getSbbTracerNames(serviceID,sbbID);
  //get sbb tracer level

  for(var i=0; i < tracerNames.length; i++){
    traceMBean.getTracerLevel(serviceID,sbbID,tracerNames[i]);
    debug(serviceID + ' ' + sbbID + ' ' + tracerNames[i] + level);
  }

  //set sbb tracer level
  traceMBean.setSbbTracerLevel(serviceID,javax.slee.facilities.TraceLevel.FINEST);
  */  
  
  
  //locate ra with type

  

 var raLinkName = 'SNMP Resource Adaptor Entity Link';
 var raEntityName = 'snmp-ra-entity';
 
 var raID = new ResourceAdaptorID('SNMP Resource Adaptor','MOFOKOM','1.0-SNAPSHOT');

 var properties = new javax.slee.resource.ConfigProperties();
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('WORK_QUEUE','java.lang.Integer', java.lang.Integer.valueOf(1)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(2)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_TIMEOUT','java.lang.Long', java.lang.Long.valueOf(120)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SNMP_CONTEXT_VERSION','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('HOST','java.lang.String', 'localhost'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('LISTEN','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('BIND_ADDRESS','java.lang.String', '0.0.0.0'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PORT','java.lang.Integer', java.lang.Integer.valueOf(162)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SOCKET_TYPE','java.lang.String', 'Standard'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_ENGINE_ID','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_NAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USERNAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_AUTH_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('AUTH_PROTOCOL','java.lang.String', 'MD5'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PRIV_PROTOCOL','java.lang.String', 'DES'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_PRIV_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_AUTHENTICATION','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_PRIVACY','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('COMMUNITY','java.lang.String', 'public'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_RECV_SIZE','java.lang.Integer', java.lang.Integer.valueOf(10000)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('RETRY_INTERVALS','java.lang.String', '1000,2000,5000'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('ACTIVITY_DIMENSION','java.lang.Integer', java.lang.Integer.valueOf(5)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('WORK_QUEUE','java.lang.Integer', java.lang.Integer.valueOf(1)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(2)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_POOL_SIZE','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('POOL_TIMEOUT','java.lang.Long', java.lang.Long.valueOf(120)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SNMP_CONTEXT_VERSION','java.lang.Integer', java.lang.Integer.valueOf(3)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('HOST','java.lang.String', 'localhost'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('LISTEN','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('BIND_ADDRESS','java.lang.String', '0.0.0.0'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PORT','java.lang.Integer', java.lang.Integer.valueOf(162)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('SOCKET_TYPE','java.lang.String', 'Standard'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_ENGINE_ID','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('CONTEXT_NAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USERNAME','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_AUTH_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('AUTH_PROTOCOL','java.lang.String', 'MD5'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('PRIV_PROTOCOL','java.lang.String', 'DES'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USER_PRIV_PASSWORD','java.lang.String', ''));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_AUTHENTICATION','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('USE_PRIVACY','java.lang.Boolean', java.lang.Boolean.valueOf(false)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('COMMUNITY','java.lang.String', 'public'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('MAX_RECV_SIZE','java.lang.Integer', java.lang.Integer.valueOf(10000)));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('RETRY_INTERVALS','java.lang.String', '1000,2000,5000'));
 
    properties.addProperty(new javax.slee.resource.ConfigProperties.Property('ACTIVITY_DIMENSION','java.lang.Integer', java.lang.Integer.valueOf(5)));
 

    var installed = false;
    try {
      resourceAdaptorMBean.getResourceAdaptor(raEntityName);
      installed = true;
    } catch (x) {
      //not installed
    }

    //already installed 
    if(installed) {

      //get state
      var state = resourceAdaptorMBean.getState(raEntityName);

      if (javax.slee.management.ResourceAdaptorEntityState.ACTIVE.equals(state)) {
        //deactivate ra entity
        resourceAdaptorMBean.deactivateResourceAdaptorEntity(raEntityName);
      }

      if(resourceAdaptorMBean.getLinkNames(raEntityName).length != 0){
        resourceAdaptorMBean.unbindLinkName(raLinkName);
      }

      resourceAdaptorMBean.removeResourceAdaptorEntity(raEntityName);
    } else {
      //create ra entity
      resourceAdaptorMBean.createResourceAdaptorEntity(raID,raEntityName,properties);

      //bind link
      resourceAdaptorMBean.bindLinkName(raEntityName,raLinkName);

      //activate ra entity
      resourceAdaptorMBean.activateResourceAdaptorEntity(raEntityName);
    }

    //get ra entity tracer 
    var tracerNames = traceMBean.getResourceAdaptorEntityTracerNames(raEntityName);

    //set ra entity tracer nb. FINEST -root = ""
    for(var i=0; i < tracerNames.length; i++){
      var lever = traceMBean.getTracerLevel(raEntityName,tracerNames[i]);
      traceMBean.setResourceAdaptorEntityTraceLevel(raEntityName,tracerName[i],javax.slee.facilities.TraceLevel.FINEST);
      debug(raEntityName + ' ' + tracerNames[i] + ' ' + level.toString());
    }
  
	