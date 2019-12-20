<template>
    <div>

    </div>
</template>

<script>
export default {
  beforeCreate () {
    console.log(this.$route)
    const nextPath = this.$route.query.nextPath
    this.$router.replace(
      {
        path: nextPath
      }
    )
    console.log('调用')
    console.log(nextPath)
  },
  render: function (h) {
    return h() // avoid warning message
  }
}
</script>

<style scoped>

</style>
