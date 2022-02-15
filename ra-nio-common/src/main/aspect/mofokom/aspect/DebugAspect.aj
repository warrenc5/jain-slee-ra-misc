package mofokom.aspect;

public privileged aspect DebugAspect {
    pointcut debug_class(): within(*) && !within(DebugAspect) && !within(mofokom.resource.common.SemaphoreBlockingQueue) && !within(mofokom.resource.common.MappedQueueFactory);

    pointcut debug_constructor(): debug_class() && execution(new(..));
    pointcut debug_method(): debug_class() && execution(* *(..));
    pointcut debug_field(): debug_class() && (get(* *.*) || set(* *.*));

            before (): debug_constructor() {
            System.err.println("=(= " + thisJoinPointStaticPart.getSignature());
            }
            after(): debug_constructor() {
            System.err.println("=)= " + thisJoinPointStaticPart.getSignature());
            }

            before (): debug_method() {
            System.err.println("={= " + thisJoinPointStaticPart.getSignature());
            }
            after() returning : debug_method() {
            System.err.println("=}= " + thisJoinPointStaticPart.getSignature());
            }
            after() throwing : debug_method() {
            System.err.println("=*= " + thisJoinPointStaticPart.getSignature());
            }
}