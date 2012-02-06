package extension.tapestry;

import org.apache.tapestry5.ioc.ServiceBinder;

public class Module {

    public static void bind(ServiceBinder binder) {
        binder.bind(Uppercase.class, UppercaseImpl.class);
    }
}
