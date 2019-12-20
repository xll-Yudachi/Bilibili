<template>
  <div>
    <el-row class="tac">
      <div class="dataOverview-body">
        <div class="dataOverview-link-top-container">
          <a class="link-top-item link-top-item-active">视频数据</a>
          <a class="link-top-item">专栏数据</a>
        </div>
        <div class="dataOverview-data-center">
          <div class="dataOverview-incremental">
            <div class="dataOverview-title">
              <div class="dataOverview-custom">
                <span class="Title">增量数据-趋势总览</span>
                <div class="title-group">
                  <span class="title-group-item dataOverview-active">播放</span>
                  <span class="title-group-item">弹幕</span>
                  <span class="title-group-item">评论</span>
                  <span class="title-group-item">分享</span>
                  <span class="title-group-item">硬币</span>
                  <span class="title-group-item">收藏</span>
                  <span class="title-group-item">充电</span>
                  <span class="title-group-item">点赞</span>
                </div>
              </div>
              <p class="dataOverview-time">
                各维度每日中午12:00更新前一日数据，此处展示最近30天数据
              </p>
            </div>
            <div class="incremental-legend">
              <div class="legend-item">
                <i class="incremental-icon"></i>
                <span class="legend-text">播放数量</span>
              </div>
            </div>
            <div id="incrementalChart" class="incremental-body">
            </div>
          </div>
          <div class="dataOverview-manuscriptSource">
            <div class="dataOverview-title">
              <div class="dataOverview-custom">
                <span class="Title">来源稿件</span>
                <div class="title-group">
                  <span class="title-group-item dataOverview-active">播放</span>
                  <span class="title-group-item">播放</span>
                  <span class="title-group-item">弹幕</span>
                  <span class="title-group-item">评论</span>
                  <span class="title-group-item">分享</span>
                  <span class="title-group-item">硬币</span>
                  <span class="title-group-item">收藏</span>
                  <span class="title-group-item">充电</span>
                </div>
              </div>
              <p class="dataOverview-time">
                各维度每日中午12:00更新前一日数据
              </p>
            </div>
            <div id="manuscriptSourceChart" class="manuscriptSource-body"></div>
            <div class="source-rank-list">
              <ul class="source-rank-list-inner source-rank-close">
                <li class="source-rank-list-item">
                  <div style="background-color: rgb(113, 184, 239)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">1</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">柯南看了20年，最终boss居然是他？！ 不看到最后永远不知道系列</a>
                    </h3>
                    <p title="2018/2/21 下午10:58:15" class="info-pubdate">发布时间：2018-02-21</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item">
                  <div style="background-color: rgb(122, 216, 217)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">2</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">【2018ACM-ICPC】金牌区颁奖</a>
                    </h3>
                    <p title="2018/4/19 下午6:57:20" class="info-pubdate">发布时间：2018-04-19</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item">
                  <div style="background-color: rgb(122, 217, 124)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">3</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        那是我们交织在一起的颜色！</a>
                    </h3>
                    <p title="2018/2/2 下午8:54:36" class="info-pubdate">发布时间：2018-02-02</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(255, 204, 51)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">4</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        又到了白色相簿的季节</a>
                    </h3>
                    <p title="2018/2/1 下午6:47:14" class="info-pubdate">发布时间：2018-02-01</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(255, 153, 51)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">5</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        想要传达给你的爱恋！</a>
                    </h3>
                    <p title="2018/2/1 下午8:53:37" class="info-pubdate">2018-02-01</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(255, 88, 61)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">6</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        【TOP30】不容错过的恋爱喜剧</a>
                    </h3>
                    <p title="2018/2/2 下午9:28:46" class="info-pubdate">发布时间：2018-02-02</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(255, 116, 165)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">7</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        【top 10】十大超强男主！</a>
                    </h3>
                    <p title="2018/2/2 下午1:21:18" class="info-pubdate">发布时间：2018-02-02</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(205, 108, 197)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">8</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        （老公视觉）十元老婆每天给你一个出门吻！！</a>
                    </h3>
                    <p title="2018/6/12 下午12:56:54" class="info-pubdate">发布时间：2018-06-12</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(108, 111, 131)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">9</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        【助眠】霓虹小姐姐的触发词</a>
                    </h3>
                    <p title="2019/9/3 下午2:53:11" class="info-pubdate">发布时间：2019-09-03</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
                <li class="source-rank-list-item displayNone">
                  <div style="background-color: rgb(130, 138, 186)" class="source-rank-list-item-mark"></div>
                  <div class="source-rank-list-item-rank">10</div>
                  <div class="source-rank-list-item-info">
                    <h3 class="info-title">
                      <a href="#">
                        【楚留香】三个女人一台戏！华山相争竟为她！</a>
                    </h3>
                    <p title="2018/3/3 下午2:13:22" class="info-pubdate">发布时间：2018-03-03</p>
                  </div>
                  <div class="source-rank-list-item-btngroup">
                    <button class="rank-btn-text">
                      <i class="play-btn"></i>
                      <span>
                          <a href="#">去播放页</a>
                        </span>
                    </button>
                    <button class="rank-btn-text">
                      <i class="data-btn"></i>
                      <span>
                          <a href="#">数据分析</a>
                        </span>
                    </button>
                  </div>
                </li>
              </ul>
              <div class="source-rank-stretch-button">
                <p>展开更多</p>
              </div>
            </div>
          </div>
          <div class="dataOverview-playSource">
            <div class="dataOverview-title">
              <div class="dataOverview-custom">
                <span class="Title">播放来源</span>
              </div>
              <p class="dataOverview-time">
                各维度每日中午12:00更新前一日数据，此处展示最近30天数据
              </p>
            </div>
            <div class="playSource-item-title">
              <p>终端占比</p>
            </div>
            <div id="playSourceChart" class="playSource-body"></div>
            <div class="terminal-legend">
              <p>统计安卓设备观看行为</p>
              <p>统计苹果手机观看行为</p>
              <p>统计桌面和网页观看行为</p>
              <p>统计移动设备H5观看行为</p>
              <p>统计站外观看行为</p>
            </div>
          </div>
          <div class="dataOverview-retention">
            <div class="dataOverview-title">
              <div class="dataOverview-custom">
                <span class="Title">观众留存率</span>
                <div class="title-group">
                  <span class="title-group-item dataOverview-active">全部</span>
                  <span class="title-group-item">自制</span>
                  <span class="title-group-item">转载</span>
                </div>
              </div>
              <p class="dataOverview-time">
                各维度每日中午12:00更新前一日数据，此处展示最近30个稿件
              </p>
            </div>
            <div class="retention-tool-box">
              <div class="retention-legend">
                <i class="icon-retention"></i>
                <span class="legend-text">留存率</span>
                <i class="icon-vedio-time"></i>
                <span class="legend-text">视频时长</span>
                <i class="icon-everage-time"></i>
                <span class="legend-text">平均播放时长</span>
              </div>
            </div>
            <div id="retentionChart" class="retention-body"/>
          </div>
          <div class="dataOverview-viewsNumber">
            <div class="dataOverview-title">
              <div class="dataOverview-custom">
                <span class="Title">观看人数</span>
                <div class="title-group">
                  <span class="title-group-item dataOverview-active">全部</span>
                  <span class="title-group-item">自制</span>
                  <span class="title-group-item">转载</span>
                </div>
              </div>
              <p class="dataOverview-time">
                各维度每日中午12:00更新前一日数据，此处展示最近30个稿件的近90天数据
              </p>
            </div>
            <div class="viewsNumber-legend">
              <div class="legend-item">
                <i class="incremental-icon"></i>
                <span class="legend-text">观看人数</span>
              </div>
            </div>
            <div id="viewsNumberChart" class="viewsNumber-body">
            </div>
          </div>
          <div class="dataOverview-rank">
            <div class="dataOverview-title">
              <div class="dataOverview-custom">
                <span class="Title">我在各分区中占比排行</span>
              </div>
              <p class="dataOverview-time">
                我在各区新增播放排名情况统计
              </p>
            </div>
            <p class="progress-rank-label">生活区前<strong>17%</strong></p>
            <div class="progress dataOverview-progress" >
                <div class="progress-bar" role="progressbar" aria-valuenow="17" aria-valuemin="0" aria-valuemax="100" style="width: 17%;background-color: #4bc7f0;border-color: #4bc7f0">
                  <span class="sr-only">60% Complete</span>
                </div>
              </div>
          </div>
        </div>
      </div>
    </el-row>
  </div>
</template>

<script>
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {}
  },

  mounted () {
    this.$nextTick(() => {
      this.drawincremental()
      this.drawmanuscriptSource()
      this.drawplaySource()
      this.drawretention()
      this.drawviewsNumber()
    })

    $(function () {
      $('.source-rank-stretch-button').click(function () {
        if ($(this).find('p').text() === '展开更多') {
          $.each($('.source-rank-list-inner').children(), function (index, value) {
            if ($(value).hasClass('displayNone')) {
              $(value).removeClass('displayNone')
            }
          })
          $(this).css('top', '435px')
          $(this).find('p').text('收起列表')
          $('.dataOverview-manuscriptSource').css('height', '735px')
        } else {
          $.each($('.source-rank-list-inner').children(), function (index, value) {
            if (index >= 3) {
              $(value).addClass('displayNone')
            }
          })
          $(this).css('top', '0px')
          $(this).find('p').text('展开更多')
          $('.dataOverview-manuscriptSource').css('height', 'auto')
        }
      })
    })
  },

  // 监听器
  watch: {},

  created () {

  },

  methods: {
    drawincremental () {
      let data = [['2019-10-26', 10], ['2019-10-27', 7], ['2019-10-28', 2], ['2019-10-29', 5], ['2019-10-30', 8], ['2019-10-30', 2], ['2019-11-01', 2], ['2019-11-02', 6], ['2019-11-03', 11], ['2019-11-04', 1], ['2019-11-05', 8], ['2019-11-06', 6], ['2019-11-07', 0], ['2019-11-08', 7], ['2019-11-09', 2], ['2019-11-10', 6], ['2019-11-11', 4], ['2019-11-12', 2], ['2019-11-13', 4], ['2019-11-14', 0], ['2019-11-15', 7], ['2019-11-16', 5], ['2019-11-17', 8], ['2019-11-18', 5], ['2019-11-19', 6], ['2019-11-20', 2], ['2019-11-21', 0], ['2019-11-22', 0], ['2019-11-23', 10], ['2019-11-24', 5]]

      var dateList = data.map(function (item) {
        return item[0]
      })
      var valueList = data.map(function (item) {
        return item[1]
      })

      // 基于准备好的dom，初始化echarts实例
      var incrementalChart = this.$echarts.init(document.getElementById('incrementalChart'))
      // 绘制图表
      incrementalChart.setOption({
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          }
        },
        xAxis: {
          type: 'category',
          data: dateList,
          boundaryGap: false, // 刻度从0开始
          splitLine: {
            lineStyle: { // 网格样式
              color: '#EBEBEB'
            },
            show: true // 显示平行于y轴的直线
          }
        },
        yAxis: {
          type: 'value',
          splitLine: {
            lineStyle: { // 网格样式
              color: '#EBEBEB'
            },
            show: true // 显示平行于y轴的直线
          }
        },
        grid: {
          x: 40,
          y: 50,
          x2: 10,
          y2: 30
        },
        series: [{
          name: '播放',
          type: 'line',
          data: valueList,
          areaStyle: {
            normal: {
              color: '#37c8f71f'
            }
          },
          itemStyle: {
            normal: {
              color: '#74ceec',
              lineStyle: {
                color: '#74ceec'
              }
            }
          }
        }]
      })
    },
    drawmanuscriptSource () {
      var manuscriptSourceChart = this.$echarts.init(document.getElementById('manuscriptSourceChart'))
      // 绘制图表
      manuscriptSourceChart.setOption({
        tooltip: {
          trigger: 'item',
          formatter: '{b} <br/>  播放数量：  {c} <br/> 播放占比：{d}%',
          textStyle: {
            align: 'left'
          },
          position: 'right'
        },
        series: [
          {
            name: '访问来源',
            type: 'pie',
            radius: ['40%', '80%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false,
                position: 'center'
              }
            },
            labelLine: {
              normal: {
                show: false
              }
            },
            itemStyle: {
              normal: {
                borderWidth: 3,
                borderColor: '#fff'
              }
            },
            data: [
              {
                value: 1100,
                name: '柯南看了20年，最终boss居然是他？！ 不看到最后永远不知道系列',
                itemStyle: {
                  color: 'rgb(113, 184, 239)'
                }
              },
              {
                value: 1424,
                name: '【2018ACM-ICPC】金牌区颁奖',
                itemStyle: {
                  color: 'rgb(122, 216, 217)'
                }

              },
              {
                value: 1562,
                name: '那是我们交织在一起的颜色！',
                itemStyle: {
                  color: 'rgb(122, 217, 124)'
                }
              }
            ]
          }
        ]
      })
    },
    drawplaySource () {
      var playSourceChart = this.$echarts.init(document.getElementById('playSourceChart'))
      // 绘制图表
      playSourceChart.setOption({
        tooltip: {
          trigger: 'item',
          formatter: ' {b}&nbsp{d}%'
        },
        legend: {
          icon: 'circle',
          orient: 'vertical',
          x: '250px',
          y: '28px',
          data: ['Android', 'iPhone', 'PC', 'H5', '站外']
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '80%'],
            center: ['25%', '50%'],
            avoidLabelOverlap: false,
            label: {
              normal: {
                show: false,
                position: 'center'
              },
              labelLine: {
                normal: {
                  show: false
                }
              }
            },
            itemStyle: {
              normal: {
                borderWidth: 1,
                borderColor: '#fff'
              }
            },
            data: [
              {
                value: 31,
                name: 'Android',
                itemStyle: {
                  color: '#71b8ef'
                }
              },
              {
                value: 26,
                name: 'iPhone',
                itemStyle: {
                  color: '#70d8d9'
                }
              },
              {
                value: 21,
                name: 'PC',
                itemStyle: {
                  color: '#ffcc33'
                }
              },
              {
                value: 11,
                name: 'H5',
                itemStyle: {
                  color: '#ff9933'
                }
              },
              {
                value: 12,
                name: '站外',
                itemStyle: {
                  color: '#ff583d'
                }
              }
            ]
          }
        ]
      })
    },
    drawretention () {
      let retentionMap = {
        'av19006276(2-1)': '视频：又到了白色相簿的季节',
        'av19011052(2-1)': '视频：想要传达给你的爱恋',
        'av19034725(2-2)': '视频：惊！男男接吻！',
        'av19036199(2-2)': '视频：【top10】十大超强男主',
        'av19052789(2-2)': '视频：那是我们交织在一起的颜色！',
        'av19054329(2-2)': '视频：【top30】不容错过的恋爱喜剧',
        'av19872467(2-21)': '视频：柯南看了20年，最终boos居然是他？！不看到最后永远不知道系列',
        'av20306178(3-3)': '视频：【楚留香】三个女人一台戏！华山相争竟为她！',
        'av20571097(3-9)': '视频：【楚留香】当你拥有双人亲密动作之后............',
        'av22299154(4-19)': '视频：【2018ACM-ICPC】金牌区颁奖',
        'av24730916(6-12)': '视频：（老公视觉）十元老婆每天给你一个出门吻！！',
        'av66488645(9-3)': '视频：【助眠】霓虹小姐姐的触发词'
      }
      var retentionChart = this.$echarts.init(document.getElementById('retentionChart'))
      // 绘制图表
      retentionChart.setOption({
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            animation: false,
            label: {
              backgroundColor: '#505765'
            }
          },
          textStyle: {
            align: 'left'
          },
          formatter: function (params) {
            let html = params[0].name + '<br>'
            for (let i = 0; i < params.length; i++) {
              html += '<span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>'
              if (params[i].seriesName === '留存率') {
                html += params[i].seriesName + ':' + params[i].value + '%<br>'
              } else {
                html += params[i].seriesName + ':' + params[i].value + '<br>'
              }
            }
            let title = retentionMap[html.substring(0, html.indexOf('<br>'))]
            let oriHtml = html.slice(html.indexOf('<br>'))
            html = title + oriHtml
            return html
          }
        },
        grid: {
          x: 50,
          y: 60,
          x2: 100,
          y2: 90
        },
        dataZoom: [
          {
            textStyle: false,
            show: true,
            realtime: true,
            start: 0,
            end: 50,
            height: '20px',
            bottom: 40
          },
          {
            type: 'inside',
            realtime: true,
            start: 0,
            end: 100
          }
        ],
        xAxis: [
          {
            type: 'category',
            data: ['av19006276(2-1)', 'av19011052(2-1)', 'av19034725(2-2)', 'av19036199(2-2)', 'av19052789(2-2)', 'av19054329(2-2)', 'av19872467(2-21)', 'av20306178(3-3)', 'av20571097(3-9)', 'av22299154(4-19)', 'av24730916(6-12)', 'av66488645(9-3)'],
            splitLine: {
              lineStyle: { // 网格样式
                color: '#EBEBEB'
              },
              show: true // 显示平行于y轴的直线
            },
            itemStyle: {
              borderWidth: 1
            },
            splitNumber: 20
          }
        ],
        yAxis: [
          {
            type: 'value',
            min: 0,
            max: 100,
            interval: 20,
            splitLine: {
              lineStyle: { // 网格样式
                color: '#EBEBEB'
              }
            },
            axisLabel: {
              formatter: '{value} %'
            }
          },
          {
            type: 'value',
            min: 0,
            max: 39.55,
            interval: 7.91,
            axisLabel: {
              formatter: '{value} min'
            }
          }
        ],
        series: [
          {
            name: '视频时长',
            type: 'bar',
            data: [1.88, 1.95, 4.72, 13.03, 0.85, 10.10, 4.82, 2.77, 3.07, 5.00, 0.42, 39.55],
            barWidth: 25,
            color: '#70b8ef'
          },
          {
            name: '平均播放时长',
            type: 'bar',
            data: [0.52, 0.25, 1.67, 3.67, 0.27, 2.45, 2.27, 0.55, 1.25, 1.30, 0.20, 13.08],
            barWidth: 25,
            color: '#79d8d9'
          },
          {
            name: '留存率',
            type: 'line',
            data: [27, 13, 35, 28, 31, 24, 47, 20, 41, 26, 48, 33],
            color: '#f4b656',
            borderWidth: 2
          }
        ]
      })
    },
    drawviewsNumber () {
      // 基于准备好的dom，初始化echarts实例
      var viewsNumberChart = this.$echarts.init(document.getElementById('viewsNumberChart'))
      let viewsNumberMap = {
        'av19006276(2-1)': '视频：又到了白色相簿的季节',
        'av19011052(2-1)': '视频：想要传达给你的爱恋',
        'av19034725(2-2)': '视频：惊！男男接吻！',
        'av19036199(2-2)': '视频：【top10】十大超强男主',
        'av19052789(2-2)': '视频：那是我们交织在一起的颜色！',
        'av19054329(2-2)': '视频：【top30】不容错过的恋爱喜剧',
        'av19872467(2-21)': '视频：柯南看了20年，最终boos居然是他？！不看到最后永远不知道系列',
        'av20306178(3-3)': '视频：【楚留香】三个女人一台戏！华山相争竟为她！',
        'av20571097(3-9)': '视频：【楚留香】当你拥有双人亲密动作之后............',
        'av22299154(4-19)': '视频：【2018ACM-ICPC】金牌区颁奖',
        'av24730916(6-12)': '视频：（老公视觉）十元老婆每天给你一个出门吻！！',
        'av66488645(9-3)': '视频：【助眠】霓虹小姐姐的触发词'
      }
      // 绘制图表
      viewsNumberChart.setOption({
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          },
          textStyle: {
            align: 'left'
          },
          formatter: function (params) {
            let html = params[0].name + '<br>'
            for (let i = 0; i < params.length; i++) {
              html += '<span style="display:inline-block;margin-right:10px;margin-left:5px;border-radius:10px;width:10px;height:10px;background-color:' + params[i].color + ';"></span>' + params[i].seriesName + ':' + params[i].value + '<br>'
            }
            let title = viewsNumberMap[html.substring(0, html.indexOf('<br>'))]
            let oriHtml = html.slice(html.indexOf('<br>'))
            title = '<span style="display:inline-block;margin-left:5px;">' + title + '</span>'
            html = title + oriHtml
            return html
          }
        },
        xAxis: {
          type: 'category',
          data: ['av19006276(2-1)', 'av19011052(2-1)', 'av19034725(2-2)', 'av19036199(2-2)', 'av19052789(2-2)', 'av19054329(2-2)', 'av19872467(2-21)', 'av20306178(3-3)', 'av20571097(3-9)', 'av22299154(4-19)', 'av24730916(6-12)', 'av66488645(9-3)'],
          boundaryGap: false, // 刻度从0开始
          splitLine: {
            lineStyle: { // 网格样式
              color: '#EBEBEB'
            },
            show: true // 显示平行于y轴的直线
          }
        },
        yAxis: {
          type: 'value',
          splitLine: {
            lineStyle: { // 网格样式
              color: '#EBEBEB'
            },
            show: true // 显示平行于y轴的直线
          },
          min: 0,
          max: 150,
          interval: 30
        },
        grid: {
          x: 50,
          y: 50,
          x2: 40,
          y2: 30
        },
        series: [{
          name: '观看人数',
          type: 'line',
          data: [3, 3, 44, 57, 1, 3, 87, 1, 9, 88, 48, 137],
          areaStyle: {
            normal: {
              color: '#37c8f71f'
            }
          },
          itemStyle: {
            normal: {
              color: '#74ceec',
              lineStyle: {
                color: '#74ceec'
              }
            }
          }
        }]
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

<style>
  @import "../../static/css/dataOverview.css";
</style>
