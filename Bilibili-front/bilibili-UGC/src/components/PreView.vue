<template>
    <div>
      <el-row class="tac">
        <div class="preview-body">
          <el-steps :space="200" :active="2" align-center finish-status="success" class="ugc-preview-steps">
            <el-step title="上传视频"></el-step>
            <el-step title="填写视频信息"></el-step>
            <el-step title="进行中（预览上传视频）"></el-step>
          </el-steps>
          <div id="preview-div" class="preview-player">
            <!--<video id="preview-player" controls="controls" autoplay="autoplay" class="preview-media">
              <source :src="playVideoUrl" type="video/mp4">
            </video>-->
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
    return {
      videoUrl: ''
    }
  },

  // 监听器
  watch: {},

  created () {

  },

  mounted () {
    this.getVideoUrl()
  },

  methods: {
    playVideoUrl () {
      let vdo = document.getElementById('preview-player')
      vdo.src = this.videoUrl
      vdo.play()
    },
    getVideoUrl () {
      let id = sessionStorage.getItem('videoId')
      this.$axios({
        method: 'get',
        url: '/media/findVideoUrlById',
        params: {
          id: id
        }
      }).then(response => {
        if (response.data.success) {
          this.videoUrl = response.data.data
          this.init()
        }
      })
    },
    init () {
      let videoDom =
        "<video class='preview-media' id='preview-player' controls autoplay>" +
        "<source src='" + this.videoUrl + "' type='video/mp4'>" +
        '</video>'
      $('#preview-div').append(videoDom)
    }

  }
}
</script>

<style>
@import "../../static/css/preview.css";
</style>
