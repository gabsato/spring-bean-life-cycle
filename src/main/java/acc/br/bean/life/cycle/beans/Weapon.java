package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware{
    private String type;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon(String type) {
        this.type = type;
        System.out.println("1. Instantiation: Weapon " + this.type + " has been created.");
    }

    public String getType() {
        return type;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: Setting bean factory for " + getType());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. InitializingBean: Weapon " + this.type + " is undergoing intensive preparation.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: Weapon " + this.type + " is being discarded.");
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Performing custom init for " + this.type);
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: Performing custom destroy for " + this.type);
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: Weapon " + this.type + " is ready for action.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: Weapon " + this.type + " is about to be destroyed.");
    }
}
