<template>
  <div>
    <div v-for="message in messages" :key="message.id">
      {{ message.username }} : {{ message.text }}
    </div>
    <form @submit.prevent="sendMessage">
      <input v-model="text" placeholder="Type a message...">
      <button>Send</button>
    </form>
    <div v-for="rmessage in receivedMessages" :key="rmessage.id">
      {{ rmessage }}
    </div>
  </div>
</template>

<script>
import mqtt from "mqtt/dist/mqtt"

export default {
  data : function(){
    return {
      connection : {
        host : 'broker.emqx.io',
        port : 8084,
        endpoint : '/mqtt',
        clean : true,
        connectTimeout : 4000,
        reconnectPeriod : 4000,
        clientId : 'manage',
        username : 'manage',
        password : '0000'
      },
      subscription : {
        topic : 'pet/#',
        qos : 0
      },
      publication : {
        topic : 'pet/user1',
        qos : 0,
        payload : '{"msg" : "Hello, I am browser."}'
      },
      receiveNews : '',
      qosList : [
        {label : 0, value : 0},
        {label : 1, value : 1},
        {label : 2, value : 2}
      ],
      subscribeSuccess : false,
      username : '',
      text : '',
      messages : [],
      receivedMessages : [],
      client: {
        connected: false,
      }
    }
  },
  created : function(){
    const { host, port, endpoint, ...options } = this.connection;
    const connectUrl = `wss://${host}:${port}${endpoint}`;
    try {
      this.client = mqtt.connect(connectUrl, options);
    } catch (error) {
      console.log('mqtt.connect error', error)
    }
    this.client.on('connect', ()=>{
      console.log('Connection succeed!');
    });
    this.client.on('error', error => {
      console.log('Connection failed', error);
    })
    const {topic, qos} = this.subscription;
    this.client.subscribe(topic, {qos}, (error, res)=>{
      if(error){
        console.log('USER1 : Subscribe to topics error', error);
        return;
      }
      this.subscribeSuccess = true;
      console.log('USER1 : Subscribe to topics res', res);
      this.receiveMessage();
    });
    
  },
  methods : {
    sendMessage : function(){
      this.publication.payload = `{"msg" : "${this.text}"}`;
      const {topic, qos, payload} = this.publication;
      this.client.publish(topic, payload, qos, error => {
        if(error) {
          console.log('Publish error', error);
        }
        this.messages.push({username : 'user', text : this.text});
      })
    },
    receiveMessage : function(){
      console.log("메세지 받기");
      this.client.on('message', (topic, message)=>{
      this.receiveNews = this.receiveNews.concat(message);
      console.log(`Received message ${message} from topic ${topic}`);
      this.receivedMessages.push(message);
    })
    }
  }
}
</script>

<style>

</style>