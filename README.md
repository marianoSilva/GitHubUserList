# GitHubUserList

Lista de Usuários do GitHub, utilizando as APIs do GitHub(https://developer.github.com/v3/)


## Como executar

-Clone o projeto utilizando um cliente git ou o próprio Android Studio.(https://github.com/marianoSilva/GitHubUserList.git)  

-Aguarde o download das dependencias e indexação do projeto  

-Execute o projeto em um emulador ou dispositivo real através do Android Studio  


## Arquitetura do projeto
A arquitetura escolhida foi a MVI onde a view demonstra sua intenção a view model que processa e atualiza o estado da view.
![Arquitetura](https://miro.medium.com/v2/resize:fit:911/1*TTKpvdzyNXfPBhVyRqD6EA.png)


## CI

Para build via terminal utilizar:

Debug:  
./gradlew clean app:assembleDebug  

Release:  
./gradlew clean app:assembleRelease

O projeto roda esteiras de CI no Bitrise sempre que uma PR ou Merge são feitos para as Branchs principais (develop/master)  


## Principais bibliotecas utlizadas

-Retrofit  

-Navigation  

-Coil  

-Compose  

-Dagger Hilt  

-Gson
