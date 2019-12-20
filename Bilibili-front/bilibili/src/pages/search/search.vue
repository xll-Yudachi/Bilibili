<template>
    <div>
      <div class="search-head-wrapper">
        <div>
          <div class="search-head-div">
            <img src="../../../static/images/video_head_logo.png" class="head-logo-icon">
            <div class="search-head-title">
              <a href="#">主站<i class="search-head-icon1"></i></a>
              <a href="#">音频</a>
              <a href="#">游戏中心</a>
              <a href="#">直播</a>
              <a href="#">会员购</a>
              <a href="#">漫画</a>
              <a href="#">70年</a>
              <a href="#"><i class="search-head-icon2"></i>下载APP</a>
            </div>
          </div>
          <div class="search-user-div">
            <div class="search-user-content">
              <img class="user-img" :src="user.head_img">
              <div class="search-head-user">
                <a href="#">大会员</a>
                <a href="#">消息</a>
                <a href="#">动态</a>
                <a href="#">稍后再看</a>
                <a href="#">收藏</a>
                <a href="#">历史</a>
                <a href="#" class="post">投稿</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="search-container-wrapper">
        <div class="search-head-containner">
          <div class="search-wrapper">
            <div class="logo-input">
              <a class="search-logo"></a>
              <div class="search-block">
                <div class="input-wrapper">
                  <input id="search-keyword" type="text" maxlength="100" autocomplete="off" v-model="keyword">
                </div>
                <div class="search-button">
                  <i class="icon-search-button"></i>
                  <span id="submitSearchBtn" class="search-text" @click="submitSearch">搜索</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="search-navigator-wrapper">
        <div class="search-navigator-header-tabs">
          <ul class="switcher-head">
            <li class="switcher-head-item">
              <a class="search-active">
                综合
                <span class="switcher-head-item-num"></span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                视频
                <span class="switcher-head-item-num">99+</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                番剧
                <span class="switcher-head-item-num">0</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                影视
                <span class="switcher-head-item-num">0</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                直播
                <span class="switcher-head-item-num">0</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                专栏
                <span class="switcher-head-item-num">99+</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                话题
                <span class="switcher-head-item-num">0</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                用户
                <span class="switcher-head-item-num">0</span>
              </a>
            </li>
            <li class="switcher-head-item ">
              <a>
                相簿
                <span class="switcher-head-item-num">0</span>
              </a>
            </li>
            <li class="switcher-head-downline"></li>
          </ul>
        </div>
      </div>
      <div class="search-body-containner-wrapper">
        <div class="search-all-list">
          <div class="search-filter-wrap">
            <ul class="filter-type filter-order">
              <li class="filter-item search-filter-active">
                <a>综合排序</a>
              </li>
              <li class="filter-item">
                <a>最多点击</a>
              </li>
              <li class="filter-item">
                <a>最新发布</a>
              </li>
              <li class="filter-item">
                <a>最多弹幕</a>
              </li>
              <li class="filter-item">
                <a>最多收藏</a>
              </li>
            </ul>
            <ul class="filter-type filter-duration">
              <li class="filter-item search-filter-active">
                <a>全部时长</a>
              </li>
              <li class="filter-item">
                <a>10分钟以下</a>
              </li>
              <li class="filter-item">
                <a>10-30分钟</a>
              </li>
              <li class="filter-item">
                <a>30-60分钟</a>
              </li>
              <li class="filter-item">
                <a>60分钟以上</a>
              </li>
            </ul>
            <ul class="filter-type filter-partition">
              <li class="filter-item search-filter-active">
                <a>全部分区</a>
              </li>
              <li class="filter-item">
                <a>10-30分钟</a>
              </li>
              <li class="filter-item">
                <a>30-60分钟</a>
              </li>
              <li class="filter-item">
                <a>60分钟以上</a>
              </li>
            </ul>
            <a class="fold-up">
              <span>收起</span>
              <i class="filter-arrow-up"></i>
            </a>
            <a class="fold-down searchDisPlayNone">
              <span>更多筛选</span>
              <i class="filter-arrow-down"></i>
            </a>
            <div class="filter-switch-wrapper">
              <div class="aver-type aver-active">
                <i class="icon-aver aver-active"></i>
              </div>
              <div class="imgleft-type">
                <i class="icon-imgleft"></i>
              </div>
            </div>
          </div>
          <div class="mixin-list">
            <ul class="search-video-list">
              <li v-for="(video,index) in videoList" :key="video.id" class="search-video-item" @click="toVideoHtml(video.id)" v-if="index<20">
                <a class="img-anchor">
                  <div v-if="video.image_url" class="search-video-item-img">
                    <img :src="video.image_url">
                    <span class="so-imgTag_rb">{{formatTime(video.duration)}}</span>
                    <span class="mask-video"></span>
                  </div>
                  <div v-else class="search-video-item-img">
                    <img src="../../../static/images/video-placeholder.png">
                    <span class="so-imgTag_rb">{{formatTime(500*Math.random())}}</span>
                    <span class="mask-video"></span>
                  </div>
                  <div class="search-video-item-info">
                    <div class="video-item-headline">
                      <a class="headline-text">{{video.title}}</a>
                    </div>
                    <div class="video-item-tags">
                      <span v-if="video.play_num >= 10000" class="so-icon watch-num">
                        <i class="svi-play-icon"></i>
                        <!--1129.6万-->
                        {{(video.play_num / 10000).toFixed(1)}}万
                      </span>
                      <span v-else class="so-icon watch-num">
                        <i class="svi-play-icon"></i>
                        <!--1129.6万-->
                        {{video.play_num}}
                      </span>
                      <span class="so-icon svi-time">
                        <i class="svi-time-icon"></i>
                        {{video.upload_time.split(" ")[0]}}
                      </span>
                      <span class="so-icon">
                        <i class="svi-uper-icon"></i>
                        <a class="svi-up-name">
                          {{video.upname}}
                        </a>
                      </span>
                    </div>
                  </div>
                </a>
              </li>
            </ul>
          </div>
          <div class="block search-pagination">
            <el-pagination
              background
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page.sync="currentPage"
              :page-size="20"
              layout="prev, pager, next"
              :total="total">
            </el-pagination>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
let Base64 = require('js-base64').Base64
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {
      currentPage: 1,
      keyword: '',
      videoList: [],
      total: 0,
      user: {
        id: '',
        phone: '',
        email: '',
        create_time: '',
        head_img: '',
        username: '',
        region: ''
      }
    }
  },

  // 监听器
  watch: {},

  created () {
    let keywordOri = window.location.href.substring(window.location.href.lastIndexOf('=') + 1)
    this.keyword = Base64.decode(keywordOri)
    this.submitSearch()
    this.getUserInfo()
  },

  methods: {
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      this.$axios({
        method: 'get',
        url: 'http://localhost:9004/search/searchByPage',
        params: {
          keyword: this.keyword,
          page: val
        }
      }).then(response => {
        console.log(response)
        if (response.data.success) {
          this.videoList = response.data.data
        }
      })
    },
    submitSearch () {
      this.$axios({
        method: 'get',
        url: 'http://localhost:9004/search',
        params: {
          keyword: this.keyword
        }
      }).then(response => {
        console.log(response)
        if (response.data.success) {
          this.videoList = response.data.data
          this.total = this.videoList.length
        }
      })
    },
    formatTime (_seconds) {
      _seconds = parseInt(_seconds)
      let hours, mins, seconds
      let result = ''
      seconds = parseInt(_seconds % 60)
      mins = parseInt(_seconds % 3600 / 60)
      hours = parseInt(_seconds / 3600)

      if (hours) { result = `${this.PadZero(hours)}:${this.PadZero(mins)}:${this.PadZero(seconds)}` } else { result = `${this.PadZero(mins)}:${this.PadZero(seconds)}` }
      return result
    },
    PadZero (str) {
      // 补零
      return new RegExp(/^\d$/g).test(str) ? `0${str}` : str
    },
    toVideoHtml (val) {
      window.open('http://localhost:3000/video/' + val + '?spm=' + Base64.encode(localStorage.getItem('uid').toString()))
    },
    getUserInfo () {
      this.$axios({
        method: 'get',
        params: {
          userId: localStorage.getItem('uid')
        },
        url: 'http://localhost:9000/user/getUserInfo'
      }).then(response => {
        if (response.data.success) {
          this.user = response.data.data
          this.user.id = localStorage.getItem('uid')
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
