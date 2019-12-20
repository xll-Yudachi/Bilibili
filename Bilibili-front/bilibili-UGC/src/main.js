// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import '../static/css/bootstrap.min.css'
import '../static/js/bootstrap.min.js'
import '../static/css/ugc.css'
import leftMenu from '@/components/common'
import UGCfooter from '@/components/footer'
import echarts from 'echarts'
// 引入video.js
import Videojs from 'video.js'
import 'video.js/dist/video-js.css'
Vue.prototype.$video = Videojs
Vue.prototype.$echarts = echarts
Vue.prototype.$axios = axios // 把axios挂载到vue上

Vue.use(echarts)
Vue.use(ElementUI)
Vue.component('leftMenu', leftMenu)
Vue.component('UGCfooter', UGCfooter)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) { // 判断该路由是否需要登录权限,能检测出带参数的路由
    if (sessionStorage.getItem('uploadStatus') === 'success') {
      next()
    } else {
      next({
        path: '/upload'
      })
    }
  } else {
    if (to.meta.requireVideoInfo) { // 判断该路由是否需要登录权限,能检测出带参数的路由
      if (sessionStorage.getItem('videoInfoStatus') === 'success') {
        next()
      } else {
        next({
          path: '/upload'
        })
      }
    } else {
      next()
    }
  }
})
