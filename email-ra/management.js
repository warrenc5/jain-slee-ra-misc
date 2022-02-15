
  function undeploy_service() {
    var serviceID = Packages.javax.slee.ServiceID;
    serviceID = new ServiceID('Mail SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');

    var deployableUnitID = Packages.javax.slee.DeployableUnitID;
    var uri = 'file:/usr/src/maven/repository/mofokom/mail-service/1.0-SNAPSHOT/mail-service-1.0-SNAPSHOT-du.jar';
    var deployableUnitID = new DeployableUnitID(uri);

    if(serviceMBean.getState(serviceID) == 'Active') {
      serviceMBean.deactivate(serviceID);
    }
    removeAllActivites();

    try {
      while(serviceMBean.getState(serviceID) != 'Inactive') {
      }
    } catch(x) {
      println(x);
    }
    deploymentMBean.uninstall(deployableUnitID)

  }
  function deploy_service() {
    var serviceID = Packages.javax.slee.ServiceID;
    serviceID = new ServiceID('Mail SLEE Service Example','MOFOKOM','1.0-SNAPSHOT');

    var deployableUnitID = Packages.javax.slee.DeployableUnitID;
    var uri = 'file:/usr/src/maven/repository/mofokom/mail-service/1.0-SNAPSHOT/mail-service-1.0-SNAPSHOT-du.jar';
    var deployableUnitID = new DeployableUnitID(uri);


    try{
      deploymentMBean.install(uri);
    }catch(x){
      println(x);
    }
    serviceMBean.activate(serviceID);
  }

  try {
    undeploy_service();
  } catch (x) {
    println (x);
  }

  try {
    undeploy_ra();
  } catch (x) {
    println (x);
  }

  try {
    deploy_ra();
  } catch(x){
    println(x);
  }

  try {
    deploy_service();
  } catch(x){
    println(x);
  }
  

  function removeAllActivites(){
    try {
      (activities = nodeHouseKeepingMBean.getActivities(java.lang.Integer.valueOf(100),true)) //!= 0){
        for(var iterator = activities.keySet().iterator(); iterator.hasNext();) { 
          var activity = iterator.next().get(0);
          println("killing activity " + activity); 
          nodeHouseKeepingMBean.removeActivity(activity);
        }
    } catch (e) {
      println(e);
    }
    }
    function deploy_ra(){
      var resourceAdaptorID = Packages.javax.slee.ResourceAdaptorID;
      var entityName = 'Mail Resource Adaptor Entity';
      var linkName = 'Mail Resource Adaptor Entity Link';
      var deployableUnitID = Packages.javax.slee.DeployableUnitID;
      var uri = 'file:/usr/src/maven/repository/mofokom/mail-ra/1.0-SNAPSHOT/mail-ra-1.0-SNAPSHOT-du.jar';
      var deployableUnitID = new DeployableUnitID(uri);

      try {
        deploymentMBean.install(uri);
      }catch (x) {
      }

      try {
        var configProperties = Packages.javax.slee.resource.ConfigProperties;
        configProperties = new ConfigProperties();
        resourceAdaptorID = new ResourceAdaptorID('Mail Resource Adaptor','MOFOKOM','1.0-SNAPSHOT');

        
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('CONNECT_STORE','java.lang.Boolean', true);

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('CONNECT_TRANSPORT','java.lang.Boolean', false);

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('MAIL_AUTHENTICATION','java.lang.Boolean', true);

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('ACTIVITY_DIMENSION','java.lang.Integer',  java.lang.Integer.valueOf(1024) );

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('WORK_QUEUE','java.lang.Integer',  java.lang.Integer.valueOf(1) );

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('POOL_SIZE','java.lang.Integer',  java.lang.Integer.valueOf(2) );

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('MAX_POOL_SIZE','java.lang.Integer',  java.lang.Integer.valueOf(3) );

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('POOL_TIMEOUT','java.lang.Long',  java.lang.Long.valueOf(120) );

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('CONFIG_URI','java.lang.String',  'resource:/local.properties' );

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('DRAIN_ON_SHUTDOWN','java.lang.Boolean', false);

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('SESSION_DEBUG','java.lang.Boolean', false);

	 configProperties.addProperty(property);
  
  var property = Packages.javax.slee.resource.ConfigProperties.Property;
  property = new javax.slee.resource.ConfigProperties.Property('SHUTDOWN_PERIOD','java.lang.Long',  java.lang.Long.valueOf(2000) );

	 configProperties.addProperty(property);
  

          resourceAdaptorMBean.createResourceAdaptorEntity(resourceAdaptorID,entityName,configProperties);
      }catch (x) {
      }
      try{
        resourceAdaptorMBean.bindLinkName(entityName,linkName);
      }catch (x) {
      }

      try{
        if(resourceAdaptorMBean.getState(entityName) == 'Inactive') { 
          resourceAdaptorMBean.activateResourceAdaptorEntity(entityName);
        }
      }catch (x) {
      }

    }

    function undeploy_ra(){
      var resourceAdaptorID = Packages.javax.slee.ResourceAdaptorID;
      var entityName = 'Mail Resource Adaptor Entity';
      var linkName = 'Mail Resource Adaptor Entity Link';
      var deployableUnitID = Packages.javax.slee.DeployableUnitID;
      var uri = 'file:/usr/src/maven/repository/mofokom/mail-ra/1.0-SNAPSHOT/mail-ra-1.0-SNAPSHOT-du.jar';
      var deployableUnitID = new DeployableUnitID(uri);

      alarmMBean.clearAlarm(entityName);
      try {

        if(resourceAdaptorMBean.getState(entityName) == 'Active') { 
          resourceAdaptorMBean.deactivateResourceAdaptorEntity(entityName);
          removeAllActivites();
          while(resourceAdaptorMBean.getState(entityName) != 'Inactive') {
          }
        }
      } catch(x) {
        println(x);
      }

      try {
        resourceAdaptorMBean.unbindLinkName(linkName);
      } catch(x) {
        println(x);
      }

      try {
        resourceAdaptorMBean.removeResourceAdaptorEntity(entityName);
      } catch(x) {
        println(x);
      }

      deploymentMBean.uninstall(deployableUnitID)
    }
	
