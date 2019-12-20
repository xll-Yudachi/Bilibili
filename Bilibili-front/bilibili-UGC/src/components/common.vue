<template>
  <div>
    <el-col :span="12" style="z-index: 2000;position: relative">
      <el-menu
        default-active=$route.path
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        :unique-opened="true"
        @select="handleSelect">
        <a class="ugc-logo"></a>
        <div class="upload-btn">
          <router-link to="/upload" class="nav_upload_btn">投稿</router-link>
        </div>
        <el-menu-item index="/home">
          <i class="home-manager-icon"></i>
          <span>首页管理</span>
        </el-menu-item>
        <el-menu-item index="/content">
          <i class="content-manager-icon"></i>
          <span slot="title">内容管理</span>
        </el-menu-item>
        <el-submenu index="3">
          <template slot="title">
            <i class="data-center-icon"></i>
            <span>数据中心</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/data/dataOverView">数据总览</el-menu-item>
            <el-menu-item index="/data/dataAnalysis">观众分析</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="/fans">
          <i class="fans-manager-icon"></i>
          <span slot="title">粉丝管理</span>
        </el-menu-item>
        <el-submenu index="/interactive">
          <template slot="title">
            <i class="dialog-icon"></i>
            <span>互动管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="/interactive/comments">评论管理</el-menu-item>
            <el-menu-item index="/interactive/danmu">弹幕管理</el-menu-item>
            <el-menu-item index="5-3">字幕管理</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="6">
          <template slot="title">
            <i class="earnings-icon"></i>
            <span>收益管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="6-1">创作激励</el-menu-item>
            <el-menu-item index="6-2">充电计划</el-menu-item>
            <el-menu-item index="6-3">悬赏计划</el-menu-item>
            <el-menu-item index="6-4">花火商单</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="7">
          <i class="coc-icon"></i>
          <span slot="title">创作学院</span>
        </el-menu-item>
        <el-menu-item index="8">
          <i class="setting-icon"></i>
          <span slot="title">个人设置</span>
        </el-menu-item>
        <el-menu-item index="9" style="margin-bottom: 20px;">
          <i class="appeal-icon"></i>
          <span slot="title">申诉管理</span>
        </el-menu-item>
        <div class="off-line"></div>
        <el-menu-item index="10">
          <i class="laboratory-icon"></i>
          <i class="beta-icon"></i>
          <span slot="title" style="position: relative;
    left: -13px;">创作实验室</span>
        </el-menu-item>
        <el-menu-item index="11">
          <i class="trophy-icon"></i>
          <span slot="title" style="position: relative;
    left: 6px;">创作新秀奖</span>
        </el-menu-item>
        <div class="off-line"></div>
        <div class="down-wrapper">
          <ul>
            <li>
              <a>
                <img src="../../static/images/bilibili_down.png">
                <div class="info-wrap">
                  <div class="title">投稿工具</div>
                  <div class="version">2.0.0.1054</div>
                </div>
              </a>
            </li>
            <li>
              <a>
                <img src="../../static/images/live_down.png">
                <div class="info-wrap">
                  <div class="title">直播姬</div>
                  <div class="version">2.0.0.1149</div>
                </div>
              </a>
            </li>
            <li>
              <a>
                <img src="../../static/images/activist_down.png">
                <div class="info-wrap">
                  <div class="title">点我维权</div>
                  <div class="version">v1.0</div>
                </div>
              </a>
            </li>
          </ul>
        </div>
        <div class="off-line"></div>
        <div class="help-wrapper">
          <ul>
            <li>反馈与建议</li>
            <li>帮助中心</li>
            <li>在线客服</li>
            <li>bilibili认证</li>
          </ul>
        </div>
      </el-menu>
    </el-col>
  </div>
</template>

<script>
export default {
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    close () {

    },
    open () {

    },
    flushCom () {
      this.$router.go(0)
    },
    handleSelect (path) {
      this.$router.push(path)
    }
  },
  beforeRouteUpdate () {
    this.flushCom()
  },
  watch: {}
}
</script>
