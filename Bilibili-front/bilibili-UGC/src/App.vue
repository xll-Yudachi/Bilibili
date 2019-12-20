<template>
  <div id="app">
    <div class="ugc-head-wrapper">
      <div>
        <div class="ugc-head-div">
          <i class="head-logo-icon"></i>
          <div class="ugc-head-title">
            <a href="#">主站<i class="ugc-head-icon1"></i></a>
            <a href="#">音频</a>
            <a href="#">游戏中心</a>
            <a href="#">直播</a>
            <a href="#">会员购</a>
            <a href="#">漫画</a>
            <a href="#">70年</a>
            <a href="#"><i class="ugc-head-icon2"></i>下载APP</a>
          </div>
        </div>
        <div class="ugc-search-div">
          <form>
            <input class="ugc-head-search" placeholder="00后国产男团这么强？">
          </form>
          <i class="ugc-head-search-icon"></i>
        </div>
        <div class="ugc-user-div">
          <div class="ugc-user-content">
            <img class="user-img" :src="user.head_img">
            <div class="ugc-head-user">
              <a href="#">大会员</a>
              <a href="#">消息</a>
              <a href="#">动态</a>
              <a href="#">稍后再看</a>
              <a href="#">收藏</a>
              <a href="#">历史</a>
              <a href="#">创作中心</a>
              <a href="#" class="post">投稿</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <left-menu/>
    <router-view/>
  </div>
</template>
<script>
export default {
  name: 'App',
  data () {
    return {
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
  methods: {
    getUserInfo () {
      this.$axios({
        method: 'get',
        params: {
          userId: localStorage.getItem('uid')
        },
        url: 'http://localhost:9000/user/getUserInfo'
      }).then(response => {
        console.log(response)
        if (response.data.success) {
          this.user = response.data.data
        }
      })
    }
  },
  created () {
    if (localStorage.getItem('uid') != null) {
      this.getUserInfo()
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
*{
  margin: 0px;
  padding: 0px;
}
</style>
