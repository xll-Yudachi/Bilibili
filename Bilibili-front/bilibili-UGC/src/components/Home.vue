<template>
  <div>
    <el-row class="tac">
      <div class="home-body">
        <div class="home-wrapper">
          <div class="home-row-1">
            <div id="carousel-example-generic" class="carousel slide mycarousel" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
              </ol>
              <div class="carousel-inner" role="listbox">
                <div class="item active">
                  <img src="../../static/images/home_1.png">
                </div>
                <div class="item">
                  <img src="../../static/images/home_2.png">
                </div>
                <div class="item">
                  <img src="../../static/images/home_3.png">
                </div>
                <div class="item">
                  <img src="../../static/images/home_4.png">
                </div>
                <div class="item">
                  <img src="../../static/images/home_5.png">
                </div>
              </div>
            </div>
            <div class="home-calendar-wrapper">
              <p class="greetings">
                中午好～ 今天是你成为up主的第
                <span class="greet-num">657</span>
                天
              </p>
              <div class="calendar-content">
                <div class="header">2019年11月 星期二</div>
                <div class="activeDay">19</div>
                <div class="lucky-wrap">
                  <div class="luck-title">宜</div>
                  <div class="luck-desc">好奇心</div>
                </div>
              </div>
              <div class="calendar-foot">
                <div class="footer-content">
                  <span>
                    知识领域认证上线，千元激励招募知识创作者
                    <a class="footer-link">点击查看</a>
                  </span>
                </div>
              </div>
            </div>
          </div>
          <div class="home-row-2">
            <div class="home-data-wrapper">
              <div class="home-data-tabs">
                <div class="data-left">
                  <a class="data-tab active-data">视频数据</a>
                  <a class="data-tab">专栏数据</a>
                </div>
                <div class="data-right">
                  <a class="sort">
                    <i class="sort-icon"></i>
                    排序
                  </a>
                </div>
              </div>
              <div class="home-data-list">
                <div class="home-data-item">
                  <div class="data-name">播放总量</div>
                  <div class="data-content">
                    <span>12,629</span>
                  </div>
                  <div class="diff-wrap">
                    <span class="improve">昨日增量</span>
                    <span class="diff-text">2</span>
                  </div>
                </div>
                <div class="home-data-item">
                  <div class="data-name">评论总量</div>
                  <div class="data-content">
                    <span>75</span>
                  </div>
                  <div class="diff-wrap">
                    <span class="improve">昨日增量</span>
                    <span class="no-improve"></span>
                  </div>
                </div>
                <div class="home-data-item">
                  <div class="data-name">收藏总量</div>
                  <div class="data-content">
                    <span>172</span>
                  </div>
                  <div class="diff-wrap">
                    <span class="improve">昨日增量</span>
                    <span class="no-improve"></span>
                  </div>
                </div>
                <div class="home-data-item">
                  <div class="data-name">弹幕总量</div>
                  <div class="data-content">
                    <span>53</span>
                  </div>
                  <div class="diff-wrap">
                    <span class="improve">昨日增量</span>
                    <span class="no-improve"></span>
                  </div>
                </div>
                <div class="home-data-item">
                  <div class="data-name">点赞总量</div>
                  <div class="data-content">
                    <span>80</span>
                  </div>
                  <div class="diff-wrap">
                    <span class="improve">昨日增量</span>
                    <span class="no-improve"></span>
                  </div>
                </div>
                <div class="home-data-item">
                  <div class="data-name">分享总量</div>
                  <div class="data-content">
                    <span>93</span>
                  </div>
                  <div class="diff-wrap">
                    <span class="improve">昨日增量</span>
                    <span class="no-improve"></span>
                  </div>
                </div>
              </div>
              <div class="home-data-fans">
                <div class="fans-tabs">
                  <div class="fans-title">
                    <p>粉丝数据总览</p>
                  </div>
                  <div class="fans-tab">
                    <a class="fans-t fans-active">关注我的</a>
                    <a class="fans-t">取消关注我的</a>
                  </div>
                  <div class="fans-tip">
                    <p>折线图每日中午12:00更新前一日增量数据，此处展示最近30天数据</p>
                  </div>
                </div>
                <div class="fans-total">
                  <span class="fans-name">粉丝总数</span>
                  <span class="fans-num">32</span>
                </div>
                <div id="myChart" class="myChart"/>
                <div class="top-line"></div>
              </div>
            </div>
          </div>
          <div class="home-income">
            <div class="home-income-header">
              <p>收益总览</p>
              <a class="income-link">
                <span>提现</span>
                <i class="income-icon"></i>
              </a>
            </div>
            <div class="home-income-content">
              <div class="home-income-data">
                <p>收益数据总览</p>
                <span>当前位置可展示您的收益</span>
              </div>
            </div>
          </div>
          <div class="home-comment">
            <div class="home-comment-header">
              <p>最近评论</p>
              <a class="comment-link">
                <span>查看全部</span>
                <i class="comment-icon"></i>
              </a>
            </div>
            <div class="home-comment-content">
              <ul class="comment-list">
                <li class="comment-item">
                  <div class="comment-info">
                    <div class="user-face">
                      <img src="../../static/images/user_face_1.jpg">
                    </div>
                    <div class="reply-block">
                      <a class="nickname">猎马人</a>
                      <span class="time">2019-09-09</span>
                      <p class="content">好烫啊，脱了吧。</p>
                      <p class="comment-video">
                        来源于视频：
                        <a class="video-link">【助眠】霓虹小姐姐的触发词</a>
                      </p>
                    </div>
                  </div>
                </li>
                <li class="comment-item">
                  <div class="comment-info">
                    <div class="user-face">
                      <img src="../../static/images/user_face_2.jpg">
                    </div>
                    <div class="reply-block">
                      <a class="nickname">中国九年义务教务</a>
                      <span class="time">2019-09-08</span>
                      <p class="content">收藏夹有很多测试内容嗷 收藏夹有很多测试内容嗷 收藏夹有很多测试内容嗷</p>
                      <p class="comment-video">
                        来源于视频：
                        <a class="video-link">【助眠】霓虹小姐姐的触发词</a>
                      </p>
                    </div>
                  </div>
                </li>
                <li class="comment-item">
                  <div class="comment-info">
                    <div class="user-face">
                      <img src="../../static/images/user_face_3.jpg">
                    </div>
                    <div class="reply-block">
                      <a class="nickname">国服第一抠脚帅</a>
                      <span class="time">2019-09-04</span>
                      <p class="content">?x1</p>
                      <p class="comment-video">
                        来源于视频：
                        <a class="video-link">【助眠】霓虹小姐姐的触发词</a>
                      </p>
                    </div>
                  </div>
                </li>
                <li class="comment-item">
                  <div class="comment-info">
                    <div class="user-face">
                      <img src="../../static/images/user_face_4.jpg">
                    </div>
                    <div class="reply-block">
                      <a class="nickname">好烫啊日炎穿反了</a>
                      <span class="time">2019-09-03</span>
                      <p class="content">43m</p>
                      <p class="comment-video">
                        来源于视频：
                        <a class="video-link">【助眠】霓虹小姐姐的触发词</a>
                      </p>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="home-academy">
            <div class="home-academy-header">
              <p>创作学院</p>
              <a class="academy-link">
                <span>查看更多</span>
                <i class="academy-icon"></i>
              </a>
            </div>
            <div class="home-academy-content">
              <div id="carousel-example-generic-2" class="carousel slide">
                <!-- Indicators -->
                <ol class="carousel-indicators myli">
                  <li data-target="#carousel-example-generic-2" data-slide-to="0" class="active"></li>
                  <li data-target="#carousel-example-generic-2" data-slide-to="1"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                  <div class="item active">
                    <div>
                      <ul class="pic">
                        <li class="academy-item">
                          <a>
                            <div class="card-img">
                              <img src="../../static/images/academy_img_1.jpg"/>
                            </div>
                            <div class="card-info">
                              <div class="card-title">
                                <span class="headline">实况杂谈</span>
                                <span class="num">共63课</span>
                              </div>
                              <div class="card-detail">
                                学习步骤：录屏、录音、剪辑、字幕
                              </div>
                            </div>
                          </a>
                        </li>
                        <li class="academy-item">
                          <a>
                            <div class="card-img">
                              <img src="../../static/images/academy_img_2.jpg"/>
                            </div>
                            <div class="card-info">
                              <div class="card-title">
                                <span class="headline">影像剪辑</span>
                                <span class="num">共28课</span>
                              </div>
                              <div class="card-detail">
                                学习步骤：视频剪辑、视频特效
                              </div>
                            </div>
                          </a>
                        </li>
                        <li class="academy-item">
                          <a>
                            <div class="card-img">
                              <img src="../../static/images/academy_img_3.jpg"/>
                            </div>
                            <div class="card-info">
                              <div class="card-title">
                                <span class="headline">vlog</span>
                                <span class="num">共60课</span>
                              </div>
                              <div class="card-detail">
                                学习步骤：拍摄、剪辑、字幕
                              </div>
                            </div>
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                  <div class="item">
                    <div>
                      <ul class="pic">
                        <li class="academy-item">
                          <a>
                            <div class="card-img">
                              <img src="../../static/images/academy_img_4.jpg"/>
                            </div>
                            <div class="card-info">
                              <div class="card-title">
                                <span class="headline">鬼畜</span>
                                <span class="num">共56课</span>
                              </div>
                              <div class="card-detail">
                                学习步骤：扒谱、调音、混音、剪辑
                              </div>
                            </div>
                          </a>
                        </li>
                        <li class="academy-item">
                          <a>
                            <div class="card-img">
                              <img src="../../static/images/academy_img_5.jpg"/>
                            </div>
                            <div class="card-info">
                              <div class="card-title">
                                <span class="headline">MMD</span>
                                <span class="num">共33课</span>
                              </div>
                              <div class="card-detail">
                                学习步骤：素材合成、视频特效
                              </div>
                            </div>
                          </a>
                        </li>
                        <li class="academy-item">
                          <a>
                            <div class="card-img">
                              <img src="../../static/images/academy_img_6.jpg"/>
                            </div>
                            <div class="card-info">
                              <div class="card-title">
                                <span class="headline">翻唱</span>
                                <span class="num">共66课</span>
                              </div>
                              <div class="card-detail">
                                学习步骤：录音、音频制作、视频后期、字幕
                              </div>
                            </div>
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="home-recommend">
            <ul class="home-recommend-list">
              <li class="recommend-item">
                <div class="recommend-item-pic">
                  <a>
                    <img src="../../static/images/home_recommend_1.jpg">
                  </a>
                  <div class="recommend-item-duration">12:09</div>
                </div>
                <a>
                  <div class="recommend-item-title">
                    成为一个优秀的“音乐UP主”必须要知道的3件事！
                  </div>
                </a>
              </li>
              <li class="recommend-item">
                <div class="recommend-item-pic">
                  <a>
                    <img src="../../static/images/home_recommend_2.jpg">
                  </a>
                  <div class="recommend-item-duration">10:14</div>
                </div>
                <a>
                  <div class="recommend-item-title">
                    【互动视频UP主课堂】零基础如何制作一期高质量互动视频？
                  </div>
                </a>
              </li>
              <li class="recommend-item">
                <div class="recommend-item-pic">
                  <a>
                    <img src="../../static/images/home_recommend_3.jpg">
                  </a>
                  <div class="recommend-item-duration">11:27</div>
                </div>
                <a>
                  <div class="recommend-item-title">
                    【互动视频UP主课堂】干货来袭~五大游戏玩法实例教学！
                  </div>
                </a>
              </li>
              <li class="recommend-item">
                <div class="recommend-item-pic">
                  <a>
                    <img src="../../static/images/home_recommend_4.jpg">
                  </a>
                  <div class="recommend-item-duration">08:02</div>
                </div>
                <a>
                  <div class="recommend-item-title">
                    百万粉丝的UP是如何制作一期美食视频的
                  </div>
                </a>
              </li>
            </ul>
          </div>
          <div class="home-foot-wrapper">
              <div class="foot-content">
                <div class="menu">
                  <a class="menu-item">bilibili</a>
                  <a class="menu-item">帮助中心</a>
                  <a class="menu-item">问题反馈</a>
                  <a class="menu-item">关于我们</a>
                  <a class="menu-item">活动专题页</a>
                </div>
                <div class="social-menu">
                  <a class="social-item">
                    <i class="weibo-icon"></i>
                  </a>
                  <a class="social-item">
                    <i class="weixin-icon"></i>
                  </a>
                </div>
              </div>
          </div>
        </div>
      </div>
    </el-row>
  </div>
</template>

<script>
let Base64 = require('js-base64').Base64
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {}
  },

  // 监听器
  watch: {
  },

  mounted () {
    this.$nextTick(() => {
      this.drawLine()
    })

    $(function () {
      $('.social-item').hover(
        function () {
          if ($(this).index() === 0) {
            $(this).children().toggleClass('weibo-icon-hover')
          }
          if ($(this).index() === 1) {
            $(this).children().toggleClass('weixin-icon-hover')
          }
        },
        function () {
          if ($(this).index() === 0) {
            $(this).children().toggleClass('weibo-icon-hover')
          }
          if ($(this).index() === 1) {
            $(this).children().toggleClass('weixin-icon-hover')
          }
        }
      )
    })

    let userId = Base64.decode(window.location.href.slice(window.location.href.indexOf('=') + 1, window.location.href.indexOf('#')))

    localStorage.setItem('uid', userId)
  },
  created () {
  },

  methods: {
    drawLine () {
      let data = [['2019-10-20', 206], ['2019-10-21', 137], ['2019-10-22', 128], ['2019-10-23', 85], ['2019-10-24', 94], ['2019-10-25', 71], ['2019-10-26', 106], ['2019-10-27', 84], ['2019-10-28', 93], ['2019-10-29', 85], ['2019-10-30', 73], ['2019-11-01', 83], ['2019-11-02', 125], ['2019-11-03', 107], ['2019-11-04', 82], ['2019-11-05', 44], ['2019-11-06', 72], ['2019-11-07', 106], ['2019-11-08', 107], ['2019-11-09', 66], ['2019-11-10', 91], ['2019-11-11', 92], ['2019-11-12', 113], ['2019-11-13', 107], ['2019-11-14', 131], ['2019-11-15', 111], ['2019-11-16', 64], ['2019-11-17', 69], ['2019-11-18', 88], ['2019-11-19', 77], ['2019-11-20', 83], ['2019-11-21', 111], ['2019-11-22', 57], ['2019-11-23', 55], ['2019-11-24', 60]]

      var dateList = data.map(function (item) {
        return item[0]
      })
      var valueList = data.map(function (item) {
        return item[1]
      })

      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById('myChart'))
      // 绘制图表
      myChart.setOption({
        tooltip: {
          trigger: 'axis',
          formatter: '新增关注我的 : <br/>{b} : {c}'
        },
        yAxis: {
          type: 'value',
          axisLabel: {
            formatter: '{value}'
          },
          splitLine: { // 网格线
            show: false
          }
        },
        xAxis: {
          type: 'category',
          splitLine: { // 网格线
            show: true,
            color: '#f1f2f5'
          },
          axisLine: {onZero: false},
          axisLabel: {
            formatter: '{value}'
          },
          boundaryGap: false,
          data: dateList
        },
        grid: {
          x: 40,
          y: 50,
          x2: 10,
          y2: 30
        },
        series: [
          {
            type: 'line',
            itemStyle: {
              normal: {
                color: '#74ceec',
                lineStyle: {
                  color: '#74ceec'
                }
              }
            },
            data: valueList
          }
        ]
      })
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

<style scoped>
  @import "../../static/css/home.css";
</style>
