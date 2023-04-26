<template>
  <div>
    <h1 class="header">문의내역</h1>
    <el-collapse accordion v-for="(info, idx) in messageList" :key="idx">
        <el-collapse-item :title="info.topic" name="1">
            <el-form>
                <el-row class="chat-bg">
                    <el-col type="flex" justify="center" >
                        <div v-for="(mesg, index) in info.data" :key="index">
                            <div v-if="mesg.username=='manage'" class="right-box">
                                <span  class="right-chat chat">
                                    {{ mesg.chat }} 
                                </span>
                                <div class="username">{{ now }}</div>
                            </div>
                            <div v-if="mesg.username!='manage'" class="left-box">
                                <div class="username">{{ mesg.username }}</div>
                                <span  class="left-chat chat">
                                    {{ mesg.chat }}
                                </span>&nbsp;
                                <div class="username">{{ now }}</div>
                                
                            </div>
                        </div>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="1" >&nbsp;</el-col>
                    <el-col :span="21">
                        <el-form-item>
                            <el-input type="textarea" v-model="info.mesg" autosize placeholder=""></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="0.5">
                        &nbsp;
                    </el-col>
                    <el-col :span="1">
                        <el-form-item>
                            <el-button type="warning" size="small" @click.prevent="send(info.topic, info.mesg)">전송</el-button>
                        </el-form-item>
                    </el-col>
                    <el-col :span="1.5" >&nbsp;</el-col>
                </el-row>
            </el-form>
        </el-collapse-item>
    </el-collapse>
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
                connectTimeout : 1000,
                reconnectPeriod : 1000,
                clientId : 'manage',
                username : 'manage',
                password : '0000'
            },
            subscription : {
                topic : 'pet/user/#',
                qos : 0
            },
            publication : {
                topic : 'pet/manage',
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
            client: {
                connected: false,
            },
            messageList : [],
            now : "",
            isStatus : false
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
                console.log('MANAGE : Subscribe to topics error', error);
                return;
            }
        this.subscribeSuccess = true;
        alert('MANAGE : Subscribe to topics res', res);
        this.receive();
        });
    },
    methods : {
        send : function(sendTopic, sendMesg){
            this.publication.payload = sendMesg;
            var userid = sendTopic.split('/')[2];
            this.publication.topic = 'pet/manage/' + userid;
            const {topic, qos, payload} = this.publication;
            this.client.publish(topic, payload, qos, error => {
            if(error) {
                console.log('Publish error', error);
            }
            this.time();
            });
            for(var i=0;i<this.messageList.length;i++){
                var info = this.messageList[i];
                var mesg = info.mesg;
                info.mesg="";
                if(info.topic == sendTopic){
                    info.data.push({username : 'manage', chat : mesg});
                    this.isStatus = true;
                    break;
                }
            }
            if(this.isStatus == false){
                this.messageList.push({topic : sendTopic, mesg:"", data : [{username : 'manage', chat : sendMesg}]});
            }
            this.isStatus = false;
        },
        receive : function(){
            this.client.on('message', (topic, message)=>{
                if(this.messageList.length ==0){
                    this.messageList.push({"topic" : topic, mesg:"", data : [{username : 'user', chat : message}]});
                }else{
                    for(var i=0;i<this.messageList.length;i++){
                        var info = this.messageList[i];
                        if(topic==info.topic){
                            info.data.push({username:'user', chat : message});
                            this.isStatus = true;
                            break;
                        }
                    }
                    if(this.isStatus==false){
                        this.messageList.push({"topic" : topic, mesg:"", data : [{username : 'user', chat : message}]});
                    }
                    this.isStatus = false;
                }
                this.receiveNews = this.receiveNews.concat(message);
                console.log(`Received message ${message} from topic ${topic}`);
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
        },
    }
}
</script>

<style scoped src="@/assets/chat.css">
</style>