<template>
    <div>
      <el-row class="tac">
        <router-view/>
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

  },

  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style>
@import "../../static/css/home.css";
</style>
