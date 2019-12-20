<template>
    <div style="">
      <el-row class="tac">
        <div class="fans-body">
          <div class="fans-link-top-container">
            <a class="link-top-item link-top-item-active">粉丝勋章</a>
            <a class="link-top-item">骑士团</a>
          </div>
          <div class="fans-data-center">
            <div class="fans-data-header">
              <h2 class="title">我的粉丝勋章</h2>
              <p>开设粉丝勋章同时，你也会成为 bilibili link 的一位爱抖露，拥有自己的粉丝应援团哦～</p>
            </div>
            <ul class="medal-form">
              <li class="medal-item">
                <span class="medal-item-tip">勋章状态：</span>
                <span class="red">尚未具备开通资格</span>
              </li>
              <li class="medal-item">
                <span class="medal-item-tip">勋章名称：</span>
                <div class="tooltip-helper">
                  <div class="tooltip-els">
                    <span class="minispan">
                      勋章名称设置后将同步到bilibili直播
                      <i class="tip-icon">?</i>
                    </span>
                  </div>
                  <div class="tooltip-bubble">
                    <div class="tooltip-content">
                      <div class="medal-tooltip-arrow right"></div>
                      <div class="medal-tooltip-inner">
                        <p class="medal-tooltip-title">文案设置参考：</p>
                        <span>
                          <ul class="tip-content">
                            <li>3～6个字符（2～3个汉字）；</li>
                            <li>请避免包含色情、政治等违禁信息（含谐音类）；</li>
                            <li>请避免使用头衔、职位、职能等特定称谓；</li>
                            <li>不可为纯数字；</li>
                            <li>请避免使用bilibili官方特定产品名称；</li>
                            <li>请避免使用谐音违规或其他引发歧义的词汇。</li>
                          </ul>
                        </span>
                      </div>

                    </div>
                  </div>
                </div>
              </li>
              <li class="medal-item">
                <span class="medal-item-tip">领取条件：</span>
                <span>50电池或者20硬币</span>
              </li>
              <li class="page-tip">
                <p>温馨提醒：</p>
                <ul>
                  <li>在当前版本中，关注数≧1000 且有视频投稿的UP主可以开通自己的粉丝勋章；</li>
                  <li>开通粉丝勋章时需要设置勋章名称，名称设置后经过一定冷却时间可进行更改；</li>
                  <li>已经于直播开通的勋章无需再次设置名称。</li>
                  <a class="help"> > 粉丝勋章相关帮助</a>
                </ul>
              </li>
            </ul>
            <div class="medal-list">
              <div class="part">
                <h3 class="title">勋章等级榜</h3>
                <div class="content">
                  <div class="empty-wrp">
                    <div>
                      <img src="../../static/images/article_empty.png">
                      <div class="text">敬请期待～</div>
                    </div>
                  </div>
                  <ul style="display: none">
                    <li>
                      <div>排行</div>
                      <div class="nike">用户昵称</div>
                      <div>勋章等级</div>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="part recent">
                <h3 class="title">最近领取</h3>
                <div class="content">
                  <div class="empty-wrp">
                    <img src="../../static/images/article_empty.png">
                    <div class="text">暂时没有领取数据哦～</div>
                  </div>
                  <ul class="list" style="display: none">
                    <li>
                      <div class="nike">用户昵称</div>
                      <div>领取时间</div>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <UGCfooter class="fans-footer"/>
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
  mounted () {
    $('.minispan').hover(
      function () {
        $('.tooltip-bubble').stop().fadeIn()
      },
      function () {
        $('.tooltip-bubble').stop().fadeOut()
      }
    )
  },

  // 监听器
  watch: {},

  created () {

  },

  methods: {}
}
</script>

<style>
@import "../../static/css/fans.css";
</style>
