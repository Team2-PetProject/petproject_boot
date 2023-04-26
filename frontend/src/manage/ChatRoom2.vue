<template>
  <div>
    <el-col type="flex" justify="center" id="chat-bg">
        <div v-for="(mesg, idx) in messageList" :key="idx" >
            <div v-if="mesg.username=='user/2'" class="right-box">
                <span  class="right-chat chat">
                    {{ mesg.text }} 
                </span>
                <div class="username">{{ now }}</div>
            </div>
            <div v-if="mesg.username!='user/2'" class="left-box">
                <!-- <div class="username">{{ mesg.username }}</div> -->
                <span  class="left-chat chat">
                    {{ mesg.text }}
                </span>
                <div class="username">{{ now }}</div>
            </div>
        </div>
    </el-col>
    <el-form>
        <el-col :span="20">
            <el-form-item>
                <el-input type="textarea" v-model="message" autosize placeholder="문의내용을 입력해주세요."></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="0.5">
            &nbsp;
        </el-col>
        <el-col :span="1">
            <el-form-item>
                <el-button type="warning" icon="el-icon-edit" size="small" @click.prevent="send"></el-button>
            </el-form-item>
        </el-col>
        
    </el-form>
  </div>
</template>

<script>
import mqtt from "mqtt/dist/mqtt"

export default {
    components : {
    },
    name : "ChatRoom",
    data : function(){
        return {
            connection : {
                host : 'broker.emqx.io',
                port : 8084,
                endpoint : '/mqtt',
                clean : true,
                connectTimeout : 4000,
                reconnectPeriod : 4000,
                clientId : 'user2',
                username : 'user2',
                password : '2222'
            },
            subscription : {
                topic : 'pet/manage/2',
                qos : 0
            },
            publication : {
                topic : 'pet/user/2',
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
            receivedMessages : [],
            client: {
                connected: false,
            },
            message : "",
            messageList : [],
            now : ""
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
                console.log('user2 : Subscribe to topics error', error);
                return;
            }
        this.subscribeSuccess = true;
        console.log('user2 : Subscribe to topics res', res);
        this.receive();
        });
    },
    methods : {
        send : function(){
            // this.publication.payload = `{"msg" : "${this.message}"}`;
            this.publication.payload = this.message;
            const {topic, qos, payload} = this.publication;
            this.client.publish(topic, payload, qos, error => {
            if(error) {
                console.log('Publish error', error);
            }
            this.messageList.push({username : 'user/2', text : this.message});
            this.time();
            this.message = "";
            });
        },
        receive : function(){
            this.client.on('message', (topic, message)=>{
                console.log(message);
                this.receiveNews = this.receiveNews.concat(message);
                console.log(`Received message ${message} from topic ${topic}`);
                this.messageList.push({username : topic, text : message});
                this.time();
            })
        },
        time : function(){
            var date = new Date();
            var hour = date.getHours();
            var ampm = "오전";
            if(hour >12){
                hour = hour-12;
                ampm = "오후";
            }
            this.now = (date.getMonth()+1)+"/"+ date.getDate() +" "+ ampm + " " + hour + ":"+ date.getMinutes();
        }
    }
}
</script>

<style scoped src="@/assets/chat.css">
</style>