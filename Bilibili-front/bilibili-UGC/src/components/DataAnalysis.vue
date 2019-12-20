<template>
  <div>
    <el-row class="tac">
      <div class="dataAnalysis-body">
        <div class="dataAnalysis-link-top-container">
          <a class="link-top-item link-top-item-active">游客分析</a>
          <a class="link-top-item">粉丝分析</a>
        </div>
        <div class="dataAnalysis-data-center">
          <div class="dataAnalysis-touristsAttributes">
            <div class="dataAnalysis-title">
              <div class="dataAnalysis-custom">
                <span class="Title">游客基本属性</span>
              </div>
              <p class="dataAnalysis-time">
                各维度每周二中午12:00更新前7日数据
              </p>
            </div>
            <div id="genderDistributionChart" class="genderDistribution-body"/>
            <div id="ageDistributionChart" class="ageDistribution-body"/>
            <div id="watchWayDistributionChart" class="watchWayDistribution-body"/>
            <div class="legend-description">
              <p>统计Android设备App，iOS设备App(iPhone+iPad)观看行为</p>
              <p>统计桌面端网页，移动设备H5页面观看行为</p>
              <p>统计站外播放器观看行为</p>
            </div>
            <div class="dataAnalysis-rank-body">
                <div class="dataAnalysis-rank-title">
                  <p>地区分布</p>
                  <small>播放用户地区来源分布占比</small>
                </div>
                <div class="rank-content">
                  <div class="rank-item">
                    <div class="rank-progress-item rank-top3-item">
                      <div class="progress-item-badge progress-item-badge-1">1</div>
                      <p title="广东" class="progress-item-title">广东</p>
                      <div class="progress-item-inner">
                        <div class="y-progress-bar">
                          <div class="progress-bar-inner"></div>
                        </div>
                        <div class="progress-text">19%</div>
                      </div>
                    </div>
                    <div class="rank-progress-item rank-top3-item">
                      <div class="progress-item-badge progress-item-badge-2">2</div>
                      <p title="山东" class="progress-item-title">山东</p>
                      <div class="progress-item-inner">
                        <div class="y-progress-bar">
                          <div class="progress-bar-inner"></div>
                        </div>
                        <div class="progress-text">10%</div>
                      </div>
                    </div>
                    <div class="rank-progress-item rank-top3-item">
                      <div class="progress-item-badge progress-item-badge-3">3</div>
                      <p title="浙江" class="progress-item-title">浙江</p>
                      <div class="progress-item-inner">
                        <div class="y-progress-bar">
                          <div class="progress-bar-inner"></div>
                        </div>
                        <div class="progress-text">8%</div>
                      </div>
                    </div>
                  </div>
                  <div class="rank-item">
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">4</div>
                      <p title="上海" class="percentage-item-title">上海</p>
                      <span class="percentage-item-number">7%</span>
                    </div>
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">5</div>
                      <p title="江苏" class="percentage-item-title">江苏</p>
                      <span class="percentage-item-number">7%</span>
                    </div>
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">6</div>
                      <p title="湖南" class="percentage-item-title">湖南</p>
                      <span class="percentage-item-number">6%</span>
                    </div>
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">7</div>
                      <p title="北京" class="percentage-item-title">北京</p>
                      <span class="percentage-item-number">5%</span>
                    </div>
                  </div>
                  <div class="rank-item">
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">8</div>
                      <p title="四川" class="percentage-item-title">四川</p>
                      <span class="percentage-item-number">4%</span>
                    </div>
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">9</div>
                      <p title="广西" class="percentage-item-title">广西</p>
                      <span class="percentage-item-number">4%</span>
                    </div>
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">10</div>
                      <p title="湖北" class="percentage-item-title">湖北</p>
                      <span class="percentage-item-number">4%</span>
                    </div>
                    <div class="percentage-progress-item">
                      <div class="percentage-item-badge">11</div>
                      <p title="其他" class="percentage-item-title">其他</p>
                      <span class="percentage-item-number">22%</span>
                    </div>
                  </div>
                </div>
            </div>
          </div>
          <div class="dataAnalysis-touristsContents">
            <div class="dataAnalysis-title">
              <div class="dataAnalysis-custom">
                <span class="Title">游客内容倾向</span>
              </div>
              <p class="dataAnalysis-time">
                各维度每周二中午12:00更新前7日数据
              </p>
            </div>
            <div class="dataAnalysis-rank-body">
              <div class="dataAnalysis-rank-title">
                <p>分区占比</p>
                <small>观看该分区视频占比</small>
              </div>
              <div class="rank-content">
                <div class="rank-item">
                  <div class="rank-progress-item rank-top3-item">
                    <div class="progress-item-badge progress-item-badge-1">1</div>
                    <p title="日常" class="progress-item-title">日常</p>
                    <div class="progress-item-inner">
                      <div class="y-progress-bar">
                        <div class="progress-bar-inner"></div>
                      </div>
                      <div class="progress-text">26%</div>
                    </div>
                  </div>
                  <div class="rank-progress-item rank-top3-item">
                    <div class="progress-item-badge progress-item-badge-2">2</div>
                    <p title="搞笑" class="progress-item-title">搞笑</p>
                    <div class="progress-item-inner">
                      <div class="y-progress-bar">
                        <div class="progress-bar-inner"></div>
                      </div>
                      <div class="progress-text">17%</div>
                    </div>
                  </div>
                  <div class="rank-progress-item rank-top3-item">
                    <div class="progress-item-badge progress-item-badge-3">3</div>
                    <p title="综合" class="progress-item-title">综合</p>
                    <div class="progress-item-inner">
                      <div class="y-progress-bar">
                        <div class="progress-bar-inner"></div>
                      </div>
                      <div class="progress-text">10%</div>
                    </div>
                  </div>
                </div>
                <div class="rank-item">
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">4</div>
                    <p title="影视剪辑" class="percentage-item-title">影视剪辑</p>
                    <span class="percentage-item-number">9%</span>
                  </div>
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">5</div>
                    <p title=" 手机游戏" class="percentage-item-title"> 手机游戏</p>
                    <span class="percentage-item-number">8%</span>
                  </div>
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">6</div>
                    <p title=" 美食圈" class="percentage-item-title"> 美食圈</p>
                    <span class="percentage-item-number">8%</span>
                  </div>
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">7</div>
                    <p title="电子竞技" class="percentage-item-title">电子竞技</p>
                    <span class="percentage-item-number">7%</span>
                  </div>
                </div>
                <div class="rank-item">
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">8</div>
                    <p title="单机游戏" class="percentage-item-title">单机游戏</p>
                    <span class="percentage-item-number">6%</span>
                  </div>
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">9</div>
                    <p title="动物圈" class="percentage-item-title">动物圈</p>
                    <span class="percentage-item-number">5%</span>
                  </div>
                  <div class="percentage-progress-item">
                    <div class="percentage-item-badge">10</div>
                    <p title="连载动画" class="percentage-item-title">连载动画</p>
                    <span class="percentage-item-number">4%</span>
                  </div>
                </div>
              </div>
              <div class="dataAnalysis-rank-title">
                <p>标签地图</p>
                <small>观众喜欢观看的标签</small>
              </div>
              <div class="normal-empty">
                <p>暂无数据</p>
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

  // 监听器
  watch: {},

  mounted () {
    this.$nextTick(() => {
      this.drawgenderDistribution()
      this.drawageDistribution()
      this.drawwatchWayDistribution()
    })
  },

  created () {

  },

  methods: {
    drawgenderDistribution () {
      var genderDistributionChart = this.$echarts.init(document.getElementById('genderDistributionChart'))
      // 绘制图表
      genderDistributionChart.setOption({
        title: {
          text: '性别占比',
          left: '17%',
          textStyle: {
            fontStyle: 'normal', // 风格
            fontWeight: 'normal', // 粗细
            fontSize: 15, // 大小
            align: 'center' // 水平对齐
          }
        },
        tooltip: {
          trigger: 'item',
          formatter: ' {b}&nbsp{d}%'
        },
        legend: {
          icon: 'circle',
          orient: 'vertical',
          x: '250px',
          y: '50px',
          data: ['男性观众', '女性观众'],
          textStyle: { // 图例文字的样式
            fontSize: 14,
            color: '#727272'
          }
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '80%'],
            center: ['25%', '55%'],
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
                borderWidth: 2,
                borderColor: '#fff'
              }
            },
            data: [
              {
                value: 31,
                name: '女性观众',
                itemStyle: {
                  color: '#ff7e9c'
                }
              },
              {
                value: 26,
                name: '男性观众',
                itemStyle: {
                  color: '#37c8f7'
                }
              }
            ]
          }
        ]
      })
    },
    drawageDistribution () {
      var ageDistributionChart = this.$echarts.init(document.getElementById('ageDistributionChart'))
      // 绘制图表
      ageDistributionChart.setOption({
        title: {
          text: '观众年龄',
          left: '17%',
          textStyle: {
            fontStyle: 'normal', // 风格
            fontWeight: 'normal', // 粗细
            fontSize: 15, // 大小
            align: 'center' // 水平对齐
          }
        },
        tooltip: {
          trigger: 'item',
          formatter: ' {b}&nbsp{d}%'
        },
        legend: {
          icon: 'circle',
          orient: 'vertical',
          x: '250px',
          y: '50px',
          data: ['0-16岁', '16-25岁', '25-40岁', '40岁以上'],
          textStyle: { // 图例文字的样式
            fontSize: 14,
            color: '#727272'
          }
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '80%'],
            center: ['25%', '55%'],
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
                borderWidth: 2,
                borderColor: '#fff'
              }
            },
            data: [
              {
                value: 9,
                name: '0-16岁',
                itemStyle: {
                  color: '#92DDFF'
                }
              },
              {
                value: 45,
                name: '16-25岁',
                itemStyle: {
                  color: '#43C1FB'
                }
              },
              {
                value: 25,
                name: '25-40岁',
                itemStyle: {
                  color: '#4391FB'
                }
              },
              {
                value: 19,
                name: '40岁以上',
                itemStyle: {
                  color: '#6485F0'
                }
              }
            ]
          }
        ]
      })
    },
    drawwatchWayDistribution () {
      var watchWayDistributionChart = this.$echarts.init(document.getElementById('watchWayDistributionChart'))
      // 绘制图表
      watchWayDistributionChart.setOption({
        title: {
          text: '观看途径',
          left: '17%',
          textStyle: {
            fontStyle: 'normal', // 风格
            fontWeight: 'normal', // 粗细
            fontSize: 15, // 大小
            align: 'center' // 水平对齐
          }
        },
        tooltip: {
          trigger: 'item',
          formatter: ' {b}&nbsp{d}%'
        },
        legend: {
          icon: 'circle',
          orient: 'vertical',
          x: '250px',
          y: '50px',
          data: ['移动', 'PC', '站外', '其他'],
          textStyle: { // 图例文字的样式
            fontSize: 14,
            color: '#727272'
          }
        },
        series: [
          {
            type: 'pie',
            radius: ['40%', '80%'],
            center: ['25%', '55%'],
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
                borderWidth: 2,
                borderColor: '#fff'
              }
            },
            data: [
              {
                value: 45,
                name: '移动',
                itemStyle: {
                  color: '#FF74A5'
                }
              },
              {
                value: 9,
                name: 'PC',
                itemStyle: {
                  color: '#57CAFF'
                }
              },
              {
                value: 0,
                name: '站外',
                itemStyle: {
                  color: '#AA82FF'
                }
              },
              {
                value: 0,
                name: '其他',
                itemStyle: {
                  color: '#FFCF13'
                }
              }
            ]
          }
        ]
      })
    }
  }
}
</script>

<style>
  @import "../../static/css/dataAnalysis.css";
</style>
