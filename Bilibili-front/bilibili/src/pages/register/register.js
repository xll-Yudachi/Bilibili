import Vue from 'vue'
import register from './register.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
Vue.prototype.$axios = axios // 把axios挂载到vue上，$myAxios这个名称可以自定义

Vue.use(ElementUI)
// eslint-disable-next-line no-new
new Vue({
  el: '#register',
  render: h => h(register)
})
