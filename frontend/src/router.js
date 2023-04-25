import Vue from 'vue';
import VueRouter from 'vue-router';

import ChatRoom from '@/components/ChatRoom';
import ManageRoom from '@/manage/ManageRoom';
import RegisterItem from '@/manage/RegisterItem';
import MyPage from '@/manage/MyPage';
import UpdateItem from '@/manage/UpdateItem';
import LoginForm from'@/components/LoginForm';
import adminList from '@/manage/ItemList';
import ManageLayout from '@/layout/ManageLayout';
import DefaultLayout from '@/layout/DefaultLayout';
import ItemList from '@/components/ItemList';
import ItemRetieve from '@/components/ItemRetieve';
import Cart from '@/components/Cart';
import SignUp from '@/components/SignUp';
import OrderConfirm from '@/components/OrderConfirm';
import CartPay from '@/components/CartPay';
import OrderDone from '@/components/TotalInfor';
// import ItemPay from '@/components/ItemPay'

const routes = [    
    {
        path : '/admin',
        name : 'admin',
        component : ManageLayout,
        children : [
            {path : "/register", component : RegisterItem, name : "RegisterItem"},
            {path : "/updateItem/:id", component : UpdateItem, name : "UpdateItem", props:true},
            {path : "/admin", component : adminList, name : "adminList"},
            {path : "/adminChat", component : ManageRoom, name:"ManageRoom"},
        ]
    },
    {
        path : '/',
        name : 'DefaultLayout',
        component : DefaultLayout,
        children : [
            {path : "/", component : ItemList, name : "Home"},
            {path : "/mypage/:id", component : MyPage, name : "MyPage", props:true},
            {path : "/loginForm", component : LoginForm, name : "LoginForm"},
            {path : "/chat/:id", component : ChatRoom, name:"ChatRoom", props:true},
            // {path : "/ItemList", component : ItemList, name : "ItemList"},
            {path : "/ItemList/:cat/:curPage", component : ItemList, name : "ItemList", props : true},
            {path : "/itemRetrieve/:id", component : ItemRetieve, name : "ItemRetrieve", props : true},
            {path : "/Cart", component : Cart, name : "Cart", props : true},
            {path : "/SignUp", component : SignUp, name : "SingUp"},
            {path : "/orderConfirm", component : OrderConfirm, name : "OrderConfirm"},
            {path : "/CartPay/:cartString", component : CartPay, name : "CartPay", props:true},
            {path : "/OrderDone", component : OrderDone, name : "OrderDone"},
            // {path : "/ItemPay", component : ItemPay, name : "ItemPay"}
        ]
    }
];

const router = new VueRouter({mode: 'history', routes}); 
Vue.use(VueRouter);
export default router;