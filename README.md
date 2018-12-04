# RTP-streaming-video-android





## Instalando servidor Wowza

Sigua a instruções do desenvolvedor [Wowza Streaming](https://www.wowza.com/pricing/installer)


<br />

# Configurando o servidor manualmente

Para configuramos manualmente o servidor seguiremos as seguintes etapas:

* Iniciar servidor
* Mover video para pasta do servidor
* Iniciar app android

<br />

## Iniciar servidor

* Abra o terminal e insira o comando: "sudo service WowzaStreamingEngine start"

<br />

## Mover video para servidor

* Escolha o video desejado para fazer streaming
* Copie o arquivo para o local de destino do servidor Wowza, que por padrão é '/usr/local/WowzaStreamingEngine-4.7.7/content'
* Por padrao o app android ira fazer streaming do video com nome de 'video.mp4', então devemos alterar o nome do arquivo recém copiado.

<br />

