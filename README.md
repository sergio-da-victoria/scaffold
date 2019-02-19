Scaffold Microservice em aplicações JavaEE,  POC realizada nas versões do OpenShift Origin OKD 3.11, 3.10 e Kuberntes 1.10, 1.11

Sérgio da Victória - Solution Architect - DevOps - Open Source Enthusiast <a href="mailto:meu@email.com">sergiodavictoria@hotmail.com</a>  


# Micro Profile JEE Com Thorntail e OpenShift OKD Platform 3.11  


* [Introdução](#sobre) 
* [Red Hat OpenJDK](#red-hat-openjdk)  
* [Criando Projeto](#criando-projeto)  
* [Instalando MySQL](#instalando-mysql)  
* [Excecutando](#excecutando)  
* [JUnit Teste TDD](#junit-teste-tdd)  
* [Deploy OpenShift](#deploy-openshift)
* [Escalando App](#escalando-app)
* [Testando Balance Health](#testando-balance-health)
* [Testando REST Persistence](#testando-rest-persistence)


___________________________________________________________________________________________________________________________________________________   

### Sobre

A finalidade desse tutorial é demonstrar um pouco sobre Microservice em aplicações JavaEE (Micro - Profile), contempla também o deploy no OpenShift com o uso do plugin fabric8-maven-plugin.  
O Thorntail usa o conceito de UberJar para gerar o artefato final.  
Que nada mais é do que um arquivo .jar que contém além do seu .war todas as dependências necessárias para que o Thorntail consiga rodar.  
É importante Expor que o Thorntail é o sucessor do WildFly Swarm.  
Segue as tecnlogias que iremos ver neste tutorial, JEE, Thorntail, EJB, CDI, JPA, REST, Arquillian(TDD) Junit, DB MySQL.  
Se não deseja usar o OpenShift como container, basta criar as configurações do MySQL, (user scaffold, password scaffold, banco scaffold) e ir direto para [Excecutando](#excecutando)      
Acredito que esse Scaffold, irá te ajudar em futuras implementações com JEE em Micro Profile.    

____________________________________________________________________________________________________________________________________________________    

### Red Hat openJDK  
  Instalando Red Hat OpenJDK 8  
  
  ```
  oc system login -u system:admin  
  oc create -n openshift -f https://github.com/jboss-container-images/openjdk/blob/develop/templates/image-streams.json
  ```
_____________________________________________________________________________________________________________________________________

### Criando Projeto  

```
  oc login -u developer -p developer  
  oc new-project scaffold
  ```
______________________________________________________________________________________________________________________________________
### Instalando MySQL  

Verificando se existe template mysql  
  
  ```
  oc get templates -n openshift | grep -i mysql
  
  ```
   
  **mysql-persistent           MySQL database service, with persistent storage. For more information about u... **      

Criando o MySQL  
   
   ```
   oc new-app mysql-persistent --name=mysql 
   ```
             
     
   * With parameters:  
   * Memory Limit=512Mi  
   * Namespace=openshift  
   * Database Service Name=mysql  
   * MySQL Connection Username=userDQ7 # generated  
   * MySQL Connection Password=WuEX2OPe8frFMrhw # generated  
   * MySQL root user Password=NlWvqKj6PwkPJD7y # generated  
   * MySQL Database Name=sampledb  
   * Volume Capacity=1Gi  
   * Version of MySQL Image=5.7
   
   
Verificando o pod do MySQL 
   
   ```
   oc get pods
   ```
   
   NAME            READY     STATUS    RESTARTS   AGE  
 **mysql-1-rw4nq   1/1       Running   0          1m**
   
Verificando o Serviço MySQL   
   
   ```
   oc get svc
   ```
   
   NAME      TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE  
 **mysql     ClusterIP   172.30.141.27   <none>        3306/TCP   2m**  


Criando a rota do serviço MySQL   
 
   ```
   oc expose svc/mysql (Cria uma rota)
   
   ```
      
 **route.route.openshift.io/mysql exposed **  

Externalizando a porta do MySQL  

   ```
   oc port-forward mysql-1-rw4nq 3306:3306
   ```
   ** Forwarding from 127.0.0.1:3306 -> 3306 **
   ** Forwarding from [::1]:3306     -> 3306 **    

Blz, bando criado. Agora basta acessar o MySQL com sua IDE favorita.     
Crie um usário scaffold com a senha scaffold, não se esqueça das permissões no MySQL  
Finalizando com o db,  crie o banco scaffold    

__________________________________________________________________________________________________________________________________________________________________
### Excecutando

```   
mvn clean package thorntail:run -Dswarm.project.stage=dev (Define o project-dev.yml) se ignorado usará o project-default.yml   
ou 
mvn clean package e  java -jar target/scaffold-1.0.0-SNAPSHOT-thorntail.jar -Sdev(Define o project-dev.yml) se ignorado usará project-default.yml

```
_________________________________________________________________________________________________________________________________________________
### JUnit Teste TDD

```   
mvn test

```
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 33.961 s - in br.com.open.eip.test.ProdutoRepositoryTest  
[INFO]   
[INFO] Results:  
[INFO]   
[INFO] ** Tests run: 10, Failures: 0, Errors: 0, Skipped: 0 **  
[INFO]   
[INFO] ------------------------------------------------------------------------  
[INFO] BUILD SUCCESS  
[INFO] ------------------------------------------------------------------------  
[INFO] Total time: 01:25 min  
[INFO] Finished at: 2019-02-19T11:03:06-03:00  
[INFO] Final Memory: 50M/632M  
[INFO] ------------------------------------------------------------------------  
____________________________________________________________________________________________________________________________________________________________________
### Deploy OpenShift    
    
Efetuando o deploy no Openshift com o plugin (fabric8-maven-plugin)      

```
mvn clean package fabric8:deploy -DskipTests=true -Popenshift

```
[INFO] --- fabric8-maven-plugin:4.0.0-M2:deploy (default-cli) @ scaffold ---    
[INFO] F8: Using OpenShift at https://ip-openshift:8443/ in namespace scaffold with manifest /home/desketop/app/app_workspace/scaffold/target/classes/META-INF/fabric8/openshift.yml    
[INFO] OpenShift platform detected  
[INFO] F8: Using project: scaffold  
[INFO] F8: Creating a Service from openshift.yml namespace scaffold name scaffold  
[INFO] F8: Creating a DeploymentConfig from openshift.yml namespace scaffold name scaffold  
[INFO] F8: Created DeploymentConfig: target/fabric8/applyJson/scaffold/deploymentconfig-scaffold.json  
[INFO] F8: Creating Route scaffold:scaffold host: null  
[INFO] F8: HINT: Use the command `oc get pods -w` to watch your pods start up  
[INFO] ------------------------------------------------------------------------  
[INFO] BUILD SUCCESS  
[INFO] ------------------------------------------------------------------------  
[INFO] Total time: 01:29 min  
[INFO] Finished at: 2019-02-18T10:49:50-03:00  
[INFO] Final Memory: 77M/757M  
[INFO] ------------------------------------------------------------------------  

____________________________________________________________________________________________________________________________________________________
### Escalando App

Verificando o pods  
   
   ```
   oc get pods
   ```
   
   mysql-1-rw4nq          1/1       Running     0          48m  
** scaffold-1-ldg78       1/1       Running     0          2m **  


Vericando a rota    

   ```
   oc get routes | grep -i scaffold
   ```
** scaffold   scaffold-scaffold.ip-openshift.nip.io             scaffold   8080 **    


Agora vamos escalar a app para testar o balance  

   ```
   oc get dc
   ```
 
 
** scaffold   1          1         1         config,image(scaffold:latest) **  


   ```
   oc scale dc/scaffold --replicas=2
   ```

_____________________________________________________________________________________________________________________________________________________________
### Testando Balance Health

O intuito da classe HealthChecks é mostrar o balance entre pods e passar um pouco sobre saúde de container.  
Não entrarei em detalhes sobre Health, livenessProbe, readinessProbe, mas se não conhece sobre assunto, sugiro que faça pesquisa. 
 
   ```
   while true; do sleep 1; curl -X GET http://scaffold-scaffold.ip-openshift.nip.io/scaffold/infra/host; echo -e; done;
   
   ```

Deverá obter a seguinte saída  

Host [ scaffold-1-75j58] Acesso [ 5]  
Host [ scaffold-1-ldg78] Acesso [ 6]  
Host [ scaffold-1-75j58] Acesso [ 6]  
Host [ scaffold-1-ldg78] Acesso [ 7]  
Host [ scaffold-1-75j58] Acesso [ 7]  
Host [ scaffold-1-ldg78] Acesso [ 8]  
Host [ scaffold-1-75j58] Acesso [ 8]  
Host [ scaffold-1-ldg78] Acesso [ 9]  

etc...     

_______________________________________________________________________________________________________________________________________________________________

### Testando REST Persistence

   * 1. Inclui Produto

```
curl -H "Content-Type: application/json" -X POST http://scaffold-scaffold.ip-openshift.nip.io/scaffold/produto/inclui -d '{"seqproduto":null,"complemento":"complemento","desccompleta":"desccompleta","codprodfiscal":"1","qtdfabricadalote":null,"codigoanp":1,"codigoif":1,"qtdlimitepromocecommerce":null,"youtubecodeecommerce":null,"datahorintegracaoecommerce":1550541870376}'

```

   * 2. Consulta Produto por ID

```
curl -H "Content-Type: application/json" -X GET http://scaffold-scaffold.192.168.99.100.nip.io/scaffold/produto/consulta/id?seqproduto=2

```
   * 3. Consutla Todos

```
curl -H "Content-Type: application/json" -X GET http://scaffold-scaffold.ip-openshift.nip.io/scaffold/produto/all

```

Ver detalhes REST -> Class ProdutoEndpoint, JPA (Persistence) -> CLass ProdutoRepository, Entity -> Produto




