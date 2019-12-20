<template>
    <div>
      <el-row class="tac">
        <div class="upload-body">
          <div class="upload-link-top-container">
            <a class="link-top-item link-top-item-active">视频投稿</a>
            <a class="link-top-item">专栏投稿</a>
            <a class="link-top-item">
              互动视频投稿
              <span class="ob-point">公测</span>
            </a>
            <a class="link-top-item">音频投稿</a>
            <a class="link-top-item">相簿投稿</a>
          </div>
          <div class="upload-manager-center">
            <el-steps :space="200" :active="0" align-center class="ugc-upload-steps">
              <el-step title="进行中（上传视频）"></el-step>
              <el-step title="填写视频信息"></el-step>
              <el-step title="预览上传视频"></el-step>
            </el-steps>
            <el-upload
              class="upload-demo"
              drag
              :on-success="submitSuccess"
              action="http://localhost:9001/upload/video"
              multiple>
              <i class="ugc-upload-icon"></i>
              <div class="el-upload__text">
                拖拽视频到此处也可上传
                <div class="ugc-upload-btn">
                  <div class="ugc-upload-inner"></div>
                  <div class="ugc-upload-title">
                    上传视频
                  </div>
                </div>
                <div class="upload-queue-status">
                  <p class="upload-queue-status-pretext">当前审核队列</p>
                  <p class="upload-queue-status-inner">繁忙</p>
                </div>
              </div>
            </el-upload>
            <div class="first-step-optbtn">
                <el-button disabled @click="nextStep">下一步</el-button>
            </div>
          </div>
        </div>
      </el-row>
    </div>
</template>

<script>
// import teacher from '@/api/admin/edu/teacher'
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {}
  },

  // 监听器
  watch: {},

  created () {
    sessionStorage.clear()
  },

  methods: {
    submitSuccess (response, file, fileList) {
      $('.first-step-optbtn .el-button').removeAttr('disabled')
      $('.first-step-optbtn .el-button').removeClass('is-disabled')
      console.log(response.data)
      sessionStorage.setItem('videoId', response.data)
    },
    nextStep () {
      sessionStorage.setItem('uploadStatus', 'success')
      this.$router.push({
        path: '/upload/videoinfo'
      })
    }
  }
}
</script>

<style>
@import "../../static/css/upload.css";
</style>
