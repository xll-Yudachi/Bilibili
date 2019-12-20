import Vue from 'vue'
import Router from 'vue-router'
import home from '@/components/Home'
import content from '@/components/Content'
import dataOverview from '@/components/DataOverview'
import data from '@/components/Data'
import dataAnalysis from '@/components/DataAnalysis'
import fans from '@/components/Fans'
import interactive from '@/components/Interactive'
import comments from '@/components/Comments'
import danmu from '@/components/Danmu'
import upload from '@/components/Upload'
import videoinfo from '@/components/VideoInfo'
import preView from '@/components/PreView'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: home
    },
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/content',
      name: 'content',
      component: content
    },
    {
      path: '/data',
      name: 'data',
      component: data,
      children: [
        {
          path: 'dataOverview',
          component: dataOverview
        },
        {
          path: 'dataAnalysis',
          component: dataAnalysis
        }
      ]
    },
    {
      path: '/fans',
      name: 'fans',
      component: fans
    },
    {
      path: '/interactive',
      name: 'interactive',
      component: interactive,
      children: [
        {
          path: 'comments',
          component: comments
        },
        {
          path: 'danmu',
          component: danmu
        }
      ]
    },
    {
      path: '/upload',
      name: 'upload',
      component: upload
    },
    {
      path: '/upload/videoinfo',
      name: 'videoinfo',
      component: videoinfo,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/upload/preView',
      name: 'preView',
      component: preView,
      meta: {
        requireVideoInfo: true
      }
    }
  ]
})
