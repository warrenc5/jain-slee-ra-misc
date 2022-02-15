          package mofokom.ccn.vs.vsip.value;
        /**
        *   Section Reference 9.34
        *
        **/
          public enum TaskStatusValueRange {
            THE_TASK_IS_SCHEDULED_FOR_EXECUTION("ordered","The task is scheduled for execution"),
            THE_TASK_HAVE_FINISHED_EXECUTING_AND_WAS_SUCCESSFUL("completed","The task have finished executing and was successful"),
            THE_TASK_HAVE_FINISHED_EXECUTING_AND_WAS_UNSUCCESSFUL("failed","The task have finished executing and was unsuccessful"),
            THE_TASK_IS_CURRENTLY_EXECUTING("running","The task is currently executing"),
            ;
            private java.lang.String value;
            private String description;
            private TaskStatusValueRange(java.lang.String value,String description){
              this.value = value;
              this.description = description;
            }
            public java.lang.String getValue() {
              return this.value;
            }
            public static TaskStatusValueRange forValue(java.lang.String value){
              for(TaskStatusValueRange v: values())
                if(v.getValue().equals(value)) 
                  return v;
              throw new IllegalArgumentException("No TaskStatusValueRange value for parameter " + value);
            }
            public String getDescription(){
              return this.description;
            }
          }
