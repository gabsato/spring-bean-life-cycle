package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    

    public Item(String name) {
        this.name = name;
        System.out.println("1. Instantion: Item " + this.name + " has been created.");
    }

    public String getName() {
        return name;
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
    	System.out.println("BeanFactoryAware: Setting bean factory for " + getName());
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    	System.out.println("7. InitializingBean: Item " + this.name + " is undergoing intensive preparation.");
    }
    
    @Override
    public void destroy() throws Exception {
    	System.out.println("11. DisposalBean: Item " + this.name + " is being discarded");
    }
    
    public void customInit() {
    	System.out.println("8. Custom Initialization: Performing custom init for " + this.name);
    }
    
    public void customDestroy() {
    	System.out.println("13. Custom Destruction: Performing custom destroy for " + this.name);
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("6. @PostConstruct: Item " + this.name + " is ready for action.");
    }
    
    @PreDestroy
    public void preDestroy() {
    	System.out.println("10. @PreDestroy: Item " + this.name + " is about to be destroyed");
    }
}
