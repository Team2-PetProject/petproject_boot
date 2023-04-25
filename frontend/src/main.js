import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import locale from 'element-ui/lib/locale/lang/ko';

Vue.use(ElementUI, {locale});
Vue.config.productionTip = false
Vue.filter('currency', function (value) {
  if (!value) return ''
  return Number(value).toLocaleString() + ' 원'
})
new Vue({
  router,    
  render: h => h(App),
}).$mount('#app') 
//여기서 id를 변경해서 설정할 수 있다.
 