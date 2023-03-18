package design_pattern;

import java.util.HashMap;
import java.util.Map;

public class SpringSingletonExample {
    /**
     * Spring framework using a singleton registery map to ensure Singleton
     */
    class AbstractBeanFactory {
        private final Map singletonCache = new HashMap();

        public Object getBean(String beanName) {
            // ...

            if (singletonCache.containsKey(beanName)) {
                // ...
            } else {
                // ...
            }

            return new Object();
        }
    }
}
