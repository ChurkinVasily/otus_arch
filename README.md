 ## Docker
 1). Собрать образ по докерфайлу (Точка в конце указывает, что докер файл брать из той же директории)
docker build -t <dockerHub_username>/<image_name>:<tag> .   
docker build -t vasilychurkin/otus_arch_hw:v1.0.1 . 

2). Запустить контейнер
 docker run -p 8080:8080 --name <имя контейнера> <имя образа>:<tag>
 docker run -p 8000:8080 --name hw1 vasilychurkin/otus_arch_hw:v1.0.0
 
 то же самое в фоне:
  docker run -d -p 8080:8080 --name mydock-container mydock
  
  3). Посмотреть запущеные контейнеры
  docker ps
  docker ps -a
  или
  docker container ls
  
  4). Посмотреть образы
  docker images
  
  
* на Windows контейнер запускается не на Localhost, а на порту на котором запущен докер
Unix машина Docker'а . Определить порт :
docker-machine ip default  


5) Посмотреть образы **docker images -a**
   удалить образы **docker image rm <имя образа>**
   
6) Если при попытке залогиниться в dockerHub возникает ошибка 
Error saving credentials: error storing credentials - err: exec: "docker-credential-desktop": executable file not found in %PATH%, out: ``  
необходимо в файле ~/.docker/config.json change credsStore to credStore

7) Пушить образ 
docker login
docker push vasilychurkin/<имя образа>:<tag>  
  
  
## MiniKube
1) Установка miniKube c оф сайта Kubernetes https://kubernetes.io/ru/docs/tasks/tools/install-minikube/
2) Предварительно долджен быть установлен Kubectl и VirtualBox (у меня уже были)
3) Ручная установка с помощью установщика Windows (скачать minikube-installer.exe)
4) Для установки должны быть доступны ресурсы: Creating virtualbox VM (CPUs=2, Memory=2200MB, Disk=20000MB)
5) Выполнить команду **minikube start**
6) Проверка статуса **minikube status**
7) Если проблемы при установке, minikube delete && minikube start
Успешным считается вывод команды minikube status:
$ minikube status
minikube
type: Control Plane
host: Running
kubelet: Running
apiserver: Running
kubeconfig: Configured
8) После этого можно пользоваться kubectl

## Kubernetes
1) Создать namespase
kubectl create ns <имя неймспейса>
2) Переключиться на НС  
kubectl config set-context --current --namespace=<имя нс>  
проверить на каком НС можно командой   
kubectl get po (покажет какие поды запущены в **текущем** NS) 
3) какой порт слушает под
 kubectl get pod hw1-deployment-645d47cdf7-bcgjp --template='{{(index (index .spec.containers 0).ports 0).containerPort}}{{"\n"}}'
4) Проверить сервис с типом NodePort:   
   minikube ssh (подключаемся к ноде миникуба по ssh)  
   curl <IP адрес сервиса из поля ClusterIP полученный из k get svc>:<порт сервиса открытый в spec.ports.port> 
5) Вызов сервиса с типом LoadBalancer    
  minikube ssh
  ifconfig (найти IP адрес кластера в поле eth1 inet addr) - ХОСТ (192.168.59.100)  
  порт получить из k get svc, поле Ports после двоеточия (например, 8000:32456 - нужен именно 32456) - ПОРТ
  в браузере вызвать ХОСТ:ПОРТ
6) логи миникуба :  
  minikube logs -f    
7) Алиас для IP - прописать в файле C:\Windows\System32\drivers\etc\host\  
8) Вызов  через Ingress  


#HELM
1) установить Chocolaty https://chocolatey.org/install (зыапустить команду от в PowerShell от имени администратора)  
2) установка Helm https://helm.sh/docs/intro/install/ 'choco install kubernetes-helm'

# Ingress Controller nginx
https://docs.nginx.com/nginx-ingress-controller/installation/installation-with-helm/  
1) Установка nginx-controller при помощи helm
git clone https://github.com/nginxinc/kubernetes-ingress.git --branch v2.2.0
cd kubernetes-ingress/deployments/helm-chart  
$ helm repo add nginx-ingress https://helm.nginx.com/stable
$ helm repo update
$ helm install nginx nginx-ingress/nginx-ingress --namespace ingress  -- инсталлируем с именем nginx из репо nginx-ingress в неймспейс ingress   
kubectl get po -n ingress - Проверка (должен быть запущен под nginx-ingress)


 
