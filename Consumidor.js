const amqp = require('amqplib')
const queue = 'PREÇO';

amqp.connect({
host:'localhost',
port:5672,
username:'admin',
password:321654987
})
.then((conexao)=>{
    conexao.createChannel()
    .then((canal)=>{
    canal.consume(queue,(mensagem)=>{
    console.log(mensagem.content.toString())
    })
    })
}).catch((erro)=>console.log(erro))