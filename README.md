# Projeto de exercício: Ciclo de Vida dos Beans

## Introdução

O projeto mostra o ciclo de vida dos beans no Spring. O exercício consiste em fazer o ciclo de vida dos beans nas classes, `Item` e `Weapon`, com base na classe `Character`, ilustrando como o Spring faz gerenciamento da criação, inicialização e destruição dos beans.

## Proposta do Exercício

Este exercício fornecer uma compreensão na prática de como os beans são gerenciados no Spring. O projeto usa as interfaces `BeanNameAware`, `ApplicationContextAware`, `BeanFactoryAware`, `InitializingBean` e `DisposableBean`, além das anotações `@PostConstruct` e `@PreDestroy`. A implementação desses métodos exibe as fases do ciclo de vida dos beans, desde a instância inicial até a destruição.

### Diretório das classes

(IMAGEM)

