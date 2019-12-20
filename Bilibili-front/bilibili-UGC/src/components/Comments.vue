<template>
  <div>
    <el-row class="tac">
      <div class="comments-body">
        <div class="comments-link-top-container">
          <a class="link-top-item link-top-item-active">视频评论</a>
          <a class="link-top-item">专栏评论</a>
          <a class="link-top-item">音频评论</a>
        </div>
        <div class="comments-manager-center">
          <div class="comments-head">
            <div class="left">
              <h2 class="head-title">全部评论</h2>
              <span class="comments-num">(76)</span>
            </div>
            <div class="right">
              <div class="dropdown mydrop-down">
                <a id="dLabel" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  全部时间
                  <span class="caret"></span>
                </a>

                <ul class="dropdown-menu my-menu-1" aria-labelledby="dLabel">
                  <li class="ellipsis">
                    <span class="selected">全部时间</span>
                  </li>
                  <li class="ellipsis">
                    <span>最近1天</span>
                  </li>
                  <li class="ellipsis">
                    <span>最近7天</span>
                  </li>
                  <li class="ellipsis">
                    <span>最近1年</span>
                  </li>
                </ul>
              </div>
              <div class="dropdown mydrop-down-r" >
                <a id="dLabel-r" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  全部视频
                  <span class="caret"></span>
                </a>

                 <ul class="dropdown-menu my-menu-2" aria-labelledby="dLabel">
                   <li class="search">
                     <i class="icon-search"></i>
                     <input type="text" placeholder="输入关键字搜索视频" class="bili-input"/>
                   </li>
                   <ul class="article-list">
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">全部视频</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">【助眠】霓虹小姐姐的触发词</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">（老公视觉）十元老婆每天给你一个出门吻！！</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">【2018ACM-ICPC】金牌区颁奖</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">【楚留香】当你拥有双人亲密动作之后...........</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">【楚留香】三个女人一台戏！华山相争竟为她！</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">柯南看了20年，最终boss居然是他？！ 不看到最后永远不知道系列</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">【TOP30】不容错过的恋爱喜剧</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">那是我们交织在一起的颜色！</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">【top 10】十大超强男主！</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">惊！男男接吻！</a>
                     </li>
                     <li class="ellipsis">
                       <a href="#" class="ac-link ellipsis">想要传达给你的爱恋</a>
                     </li>
                     <li class="ellipsis" data-reporter-id="79">
                       <a href="#" class="ac-link ellipsis">又到了白色相簿的季节</a></li>
                   </ul>
                 </ul>
              </div>
            </div>
          </div>
          <div class="comments-content">
            <div class="action-bar">
              <div class="comments-check-box"></div>
              <div class="comments-action-btn">
                <span>举报评论</span>
                <span>删除评论</span>
              </div>
              <div class="action-bar-search">
                <i class="icon-search action-bar-fix"></i>
                <input type="text" placeholder="搜索评论"/>
              </div>
              <div class="action-bar-dropdown">
                  <a id="dLabel-action" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    最近发布时间
                    <span class="caret"></span>
                  </a>

                  <ul class="dropdown-menu my-menu-action" aria-labelledby="dLabel">
                    <li class="ellipsis">
                      <span class="selected">最近发布时间</span>
                    </li>
                    <li class="ellipsis">
                      <span>点赞数</span>
                    </li>
                    <li class="ellipsis">
                      <span>回复数</span>
                    </li>
                  </ul>
              </div>
            </div>
            <div class="comments-list automaticallyOpen">
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_1.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_1.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">【助眠】霓虹小姐姐的触发词</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <span class="relation-label">已充电</span>
                  <a>猎马客</a>
                  <span class="cli-title-split">回复</span>
                  <a class="cli-parent-user">
                    @好烫啊日炎穿反了
                  </a>
                  <span>在#1的评论</span>
                  <span class="cli-show-parent">
                    <span>查看评论</span>
                    <span class="cli-show-parent-display">收起评论</span>
                  </span>
                </div>
                <div class="cli-parent-reply cli-show-parent-display">
                  <a class="cli-parent-reply-avatar">
                    <img src="../../static/images/user_face_4.jpg">
                  </a>
                  <div class="cli-parent-reply-head">
                    <a>好烫啊日炎穿反了</a>
                  </div>
                  <div class="cli-parent-reply-content">
                    43m
                  </div>
                  <div class="cli-parent-reply-footer">
                    2019-09-03 15:37:18
                  </div>
                </div>
                <a>
                  <div class="cli-content">
                    好烫啊，脱了吧。
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2019-09-09 00:31</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>0</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_2.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_1.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">【助眠】霓虹小姐姐的触发词</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>中国九年义务教育</a>
                </div>
                <a>
                  <div class="cli-content">
                    收藏夹里有挺多口腔音的! 不是广告 真的不是广告! 想看的话自取 记得悄悄看鸭 毕竟口腔音是稀有物了（阿婆主不喜欢可以删掉的）(=・ω・=)【各种的都有滴】 （ps.不是钓鱼，在收藏夹里的口腔音触发音分组里）记得留下赞赞和关注哦
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2019-09-08 03:32</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>1</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_3.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_1.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">【助眠】霓虹小姐姐的触发词</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>国服第一抠脚帅</a>
                </div>
                <a>
                  <div class="cli-content">
                    ?x1
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2019-09-04 02:03</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>1</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_4.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_1.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">【助眠】霓虹小姐姐的触发词</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>好烫啊日炎穿反了</a>
                </div>
                <a>
                  <div class="cli-content">
                    43m
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2019-09-03 15:37</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>1</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_5.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_2.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">惊！男男接吻！</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>做个温柔的腐娘子</a>
                </div>
                <a>
                  <div class="cli-content">
                    颜值貌似不错
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2019-02-02 22:26</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>0</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_6.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_3.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">（老公视觉）十元老婆每天给你一个出门吻！！</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>小样774</a>
                </div>
                <a>
                  <div class="cli-content">
                    第一个，十元的吻我先来！！
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2019-02-01 03:57</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>0</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_7.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_2.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">惊！男男接吻！</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>星熊艺</a>
                </div>
                <a>
                  <div class="cli-content">
                    这是什么电影啊
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2018-09-15 12:33</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>0</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_8.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_4.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">柯南看了20年，最终boss居然是他？！ 不看到最后永远不知道系列</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>055万吨大驱</a>
                </div>
                <a>
                  <div class="cli-content">
                    其实幕后boss就是工藤新一，他的另一重身份是江浙闽主席，这是作者安装基本法来创作的，那些凶杀案的死者都是被江户川柯南给吸走了时间而死，他的法器就是黑框眼镜以及裤腰带，工藤新一吞下毒药后活到现在是因为他在一直续，只要每推一下黑框眼镜，他就能延续生命，生生不息，长命百岁
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2018-09-01 20:13</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>2</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_9.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_4.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">柯南看了20年，最终boss居然是他？！ 不看到最后永远不知道系列</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <a>枫城四叶草</a>
                </div>
                <a>
                  <div class="cli-content">
                    天秀啊！
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2018-08-24 11:51</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>0</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
              <div class="comments-list-item">
                <div class="comments-check-box"></div>
                <a class="comments-user-avatar">
                  <img src="../../static/images/user_face_10.jpg">
                </a>
                <div class="comments-article-wrap">
                  <a class="comments-article-pic">
                    <img src="../../static/images/video_item_5.jpg">
                  </a>
                  <a class="comments-articel-title">
                    <span class="comments-article-name">【楚留香】当你拥有双人亲密动作之后...........</span>
                    <span class="comments-article-show-all">全部评论</span>
                  </a>
                </div>
                <div class="cli-title">
                  <span class="relation-label">已充电</span>
                  <a>你党性不够 </a>
                  <span class="cli-title-split">回复</span>
                  <a class="cli-parent-user">
                    @你党性不够
                  </a>
                  <span>在#6的评论</span>
                  <span class="cli-show-parent">
                    <span>查看评论</span>
                    <span class="cli-show-parent-display">收起评论</span>
                  </span>
                </div>
                <div class="cli-parent-reply cli-show-parent-display">
                  <a class="cli-parent-reply-avatar">
                    <img src="../../static/images/user_face_10.jpg">
                  </a>
                  <div class="cli-parent-reply-head">
                    <a>你党性不够</a>
                  </div>
                  <div class="cli-parent-reply-content">
                    五楼强势表白四楼！（￣▽￣）
                  </div>
                  <div class="cli-parent-reply-footer">
                    2018-08-14 12:53:58
                  </div>
                </div>
                <a>
                  <div class="cli-content">
                    好吧，六楼
                  </div>
                </a>
                <div class="cli-action">
                  <span class="cli-action-date">2018-08-14 12:54</span>
                  <span class="cli-action-split">
                    |
                  </span>
                  <span class="cli-action-like">
                    赞(
                    <span>0</span>
                    )
                  </span>
                  <span class="cli-action-reply">
                    回复
                  </span>
                  <span class="cli-action-report">
                    举报
                  </span>
                  <span class="cli-action-delete">
                    删除
                  </span>
                </div>
              </div>
            </div>
            <div class="comments-list-tips">
              仅展示最近的50000条评论
            </div>
            <div class="block">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page.sync="currentPage"
                :page-size="100"
                layout="prev, pager, next, jumper"
                :total="1000">
              </el-pagination>
            </div>
          </div>
        </div>
      </div>
      <UGCfooter class="comments-footer"/>
    </el-row>
  </div>
</template>

<script>
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {
      activeName: 'first',
      currentPage: 1
    }
  },

  // 监听器
  watch: {},

  created () {

  },

  mounted () {
    $(function () {
      $('.mydrop-down').on('shown.bs.dropdown', function () {
        $(this).css({
          'background-color': '#F1F3F7'
        })
      })
      $('.mydrop-down').on('hidden.bs.dropdown', function () {
        $(this).css({
          'background-color': 'white'
        })
      })
      $('.article-list li').hover(
        function () {
          $(this).children().css({
            'color': '#21a4da'
          })
        },
        function () {
          $(this).children().css({
            'color': '#6d757a'
          })
        }
      )
      $('#dLabel-action').hover(
        function () {
          $(this).css(
            {
              'color': '#21a4da'
            }
          )
        },
        function () {
          $(this).css(
            {
              'color': '#6d757a'
            }
          )
        }
      )
      $('.my-menu-action li').hover(
        function () {
          $(this).children().addClass('selected')
          $(this).siblings().children().removeClass('selected')
          $('.my-menu-action').children(':first').children().addClass('selected')
        },
        function () {
          $(this).children().removeClass('selected')
          $('.my-menu-action').children(':first').children().addClass('selected')
        }
      )
      $('.comments-check-box').click(function () {
        if ($(this).hasClass('comments-checked')) {
          $(this).removeClass('comments-checked')
          $('.comments-list-item .comments-check-box').removeClass('comments-checked')
        } else {
          $(this).addClass('comments-checked')
          $('.comments-list-item .comments-check-box').addClass('comments-checked')
        }
      })
      $('.cli-show-parent span').click(function () {
        $(this).css({
          'display': 'none'
        })
        $(this).siblings().css({
          'display': 'inline-block'
        })
        if ($(this).text() === '查看评论') {
          $(this).parent().parent().next().removeClass('cli-show-parent-display')
        } else {
          $(this).parent().parent().next().addClass('cli-show-parent-display')
        }
      })
    })
  },

  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    },
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
    },
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
  @import "../../static/css/comments.css";
</style>
