<template>
  <div>
    <el-row class="tac">
      <div class="danmu-body">
        <div class="danmu-link-top-container">
          <a class="link-top-item link-top-item-active">稿件弹幕</a>
          <a class="link-top-item">弹幕设置</a>
          <a class="link-top-item">弹幕反馈</a>
        </div>
        <div class="danmu-manager-center">
          <div class="danmu-head">
            <div class="left">
              <h2 class="head-title">稿件弹幕</h2>
            </div>
            <div class="danmu-head-right">
              <div class="dropdown danmudrop-down">
                <a id="dLabel-danmu-r" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  全部稿件
                  <span class="caret"></span>
                </a>

                <ul class="dropdown-menu danmu-menu-l" aria-labelledby="dLabel">
                  <li class="search">
                    <i class="icon-search"></i>
                    <input type="text" placeholder="输入关键字搜索视频" class="bili-input"/>
                  </li>
                  <ul class="article-list">
                    <li class="ellipsis">
                      <a href="#" class="ac-link ellipsis">全部稿件</a>
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
              <div class="dropdown danmudrop-down-r">
                <a id="dLabel" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  全部视频
                  <span class="caret"></span>
                </a>

                <ul class="dropdown-menu danmu-menu-r" aria-labelledby="dLabel">
                  <li class="ellipsis">
                    <span class="selected">全部视频</span>
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
            </div>
          </div>
          <div class="danmu-filter">
            <div class="danmu-filter-left">
              <div class="danmu-delete-btn">
                <div class="danmu-disable">删除弹幕</div>
                <div class="danmu-option-wrap">
                  <a class="danmu-option-btn">
                    <span class="danmu-option-arrowdown"></span>
                  </a>
                  <ul class="danmu-option-menu danmuDisplay">
                    <li class="dom-arrow"></li>
                    <li class="dom-arrow-dorder"></li>
                    <li class="dom-item">删除并拉黑</li>
                  </ul>
                </div>
              </div>
              <div class="danmu-protect-btn">
                <div class="danmu-btn-plain danmu-disable">保护弹幕</div>
                <div class="danmu-btn-plain danmu-disable">取消保护</div>
              </div>
              <div class="danmu-type-btn">
                <div class="danmu-btn-plain danmu-disable">设为字幕</div>
                <div class="danmu-btn-plain danmu-disable">设为普通</div>
              </div>
              <div class="danmu-refresh-btn">
                <div class="danmu-btn-plain">刷新</div>
              </div>
            </div>
            <div class="danmu-filter-advance">
              <span>高级</span>
              <span class="danmu-advance-arrowdown"></span>
            </div>
            <div class="danmu-search">
              <input type="text" placeholder="搜索弹幕"/>
              <i class="danmu-icon-search"></i>
            </div>
          </div>
          <div class="danmu-advance-search danmuDisplay">
            <div class="advance-content-time">
              <label>弹幕内容：</label>
              <input type="text" placeholder="请输入弹幕内容" class="dm-content"/>
              <label>播放时间：</label>
              <input class="dm-play-start"/>
              至
              <input class="dm-play-end"/>
            </div>
            <div class="advance-send-info">
              <label>发送者/UID：</label>
              <div class="uid-select">
                <p>
                  <span>UID</span>
                  <span class="danmu-option-arrowdown"></span>
                </p>
              </div>
              <input class="dm-sender" type="text" placeholder="输入发送者UID（多个以','隔开）"/>
              <label>发送日期：</label>
              <div class="block danmu-datePicker">
                <el-date-picker
                  v-model="value"
                  type="daterange"
                  align="right"
                  unlink-panels
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期"
                  :picker-options="pickerOptions">
                </el-date-picker>
              </div>
            </div>
            <div class="advance-dm-mode">
              <label>弹幕模式：</label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">滚动</span>
              </label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">底端</span>
              </label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">顶端</span>
              </label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">逆向</span>
              </label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">高级</span>
              </label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">代码</span>
              </label>
              <label class="dm-mode-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222">BAS</span>
              </label>
            </div>
            <div class="advance-dm-pool">
              <label>子弹幕池：</label>
              <label class="dm-pool-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222;position: relative;
    top: 1px;">普通</span>
              </label>
              <label class="dm-pool-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222;position: relative;
    top: 1px;">普通</span>
              </label>
              <label class="dm-pool-item">
                <span class="dm-checkbox">
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222;position: relative;
    top: 1px;">普通</span>
              </label>
            </div>
            <div class="advance-dm-attr">
              <label>弹幕属性：</label>
              <label class="dm-attr-item">
                <span class="dm-checkbox">
                  <input type="checkbox"/>
                  <i class="dm-checkbox-icon"></i>
                </span>
                <span style="margin-left: 5px;color: #222;position: relative;
    top: 1px;">保护弹幕</span>
              </label>
            </div>
            <div class="advance-dm-footer">
              <button class="advance-cancel-btn">重置</button>
              <button class="advance-ok-btn">搜索</button>
            </div>
          </div>
          <div class="danmu-container">
            <div class="danmu-table">
              <thead>
                <tr class="danmu-table-header">
                  <th class="w40 tac">
                    <i class="danmu-check-box-all"></i>
                  </th>
                  <th class="tal w150">发送者</th>
                  <th class="tal w90 video-item-play">
                    播放时间
                    <span class="play-time-asc"></span>
                    <span class="play-time-desc"></span>
                  </th>
                  <th class="tal w300">
                    弹幕内容
                  </th>
                  <th class="tal w110">
                    样式
                  </th>
                  <th class="tal w90">
                    属性
                  </th>
                  <th class="danmu-send-date tal">
                    发送时间
                    <span class="send-date-asc"></span>
                    <span class="send-date-desc danmu-selected"></span>
                  </th>
                  <th class="danmu-act tal">
                    操作
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr class="danmu-item">
                  <td class="danmu-input-group">
                    <i class="danmu-check-box"></i>
                  </td>
                  <td class="danmu-item-name">
                    <a>AsilenceBTF</a>
                  </td>
                  <td class="danmu-item-time">
                    01:17
                  </td>
                  <td class="danmu-item-content">
                    吉老师流批
                  </td>
                  <td class="danmu-item-style">
                    <span class="danmu-item-color"></span>
                    <span class="danmu-item-size">25</span>
                    <span>滚动</span>
                  </td>
                  <td class="danmu-item-attr">
                    普通
                  </td>
                  <td class="danmu-item-sendTime">
                    2019-04-17 12:33:58
                  </td>
                  <td class="danmu-item-action">

                  </td>
                </tr>
                <tr class="danmu-item">
                  <td class="danmu-input-group">
                    <i class="danmu-check-box"></i>
                  </td>
                  <td class="danmu-item-name">
                    <a>AsilenceBTF</a>
                  </td>
                  <td class="danmu-item-time">
                    01:00
                  </td>
                  <td class="danmu-item-content">
                    我多年的颈椎终于断了
                  </td>
                  <td class="danmu-item-style">
                    <span class="danmu-item-color"></span>
                    <span class="danmu-item-size">25</span>
                    <span>滚动</span>
                  </td>
                  <td class="danmu-item-attr">
                    普通
                  </td>
                  <td class="danmu-item-sendTime">
                    2019-04-17 12:33:58
                  </td>
                  <td class="danmu-item-action">

                  </td>
                </tr>
                <tr class="danmu-item">
                  <td class="danmu-input-group">
                    <i class="danmu-check-box"></i>
                  </td>
                  <td class="danmu-item-name">
                    <a>AsilenceBTF</a>
                  </td>
                  <td class="danmu-item-time">
                    00:11
                  </td>
                  <td class="danmu-item-content">
                    倒着还行
                  </td>
                  <td class="danmu-item-style">
                    <span class="danmu-item-color"></span>
                    <span class="danmu-item-size">25</span>
                    <span>滚动</span>
                  </td>
                  <td class="danmu-item-attr">
                    普通
                  </td>
                  <td class="danmu-item-sendTime">
                    2019-04-17 12:33:58
                  </td>
                  <td class="danmu-item-action">

                  </td>
                </tr>
                <tr class="danmu-item">
                  <td class="danmu-input-group">
                    <i class="danmu-check-box"></i>
                  </td>
                  <td class="danmu-item-name">
                    <a>ZZZ_ping</a>
                  </td>
                  <td class="danmu-item-time">
                    00:40
                  </td>
                  <td class="danmu-item-content">
                    ？？？？？
                  </td>
                  <td class="danmu-item-style">
                    <span class="danmu-item-color"></span>
                    <span class="danmu-item-size">25</span>
                    <span>滚动</span>
                  </td>
                  <td class="danmu-item-attr">
                    普通
                  </td>
                  <td class="danmu-item-sendTime">
                    2019-04-17 12:33:58
                  </td>
                  <td class="danmu-item-action">

                  </td>
                </tr>
                <tr class="danmu-item">
                  <td class="danmu-input-group">
                    <i class="danmu-check-box"></i>
                  </td>
                  <td class="danmu-item-name">
                    <a>Manslowness</a>
                  </td>
                  <td class="danmu-item-time">
                    00:44
                  </td>
                  <td class="danmu-item-content">
                    我多年的颈椎病终于治好了
                  </td>
                  <td class="danmu-item-style">
                    <span class="danmu-item-color"></span>
                    <span class="danmu-item-size">25</span>
                    <span>滚动</span>
                  </td>
                  <td class="danmu-item-attr">
                    普通
                  </td>
                  <td class="danmu-item-sendTime">
                    2019-04-17 12:33:58
                  </td>
                  <td class="danmu-item-action">

                  </td>
                </tr>
              </tbody>
            </div>
          </div>
          <div class="danmu-tips">
            弹幕列表显示最近30天新增稿件弹幕，上限1000条
          </div>
        </div>
      </div>
      <UGCfooter class="danmu-footer"/>
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
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      },
      value: ''
    }
  },

  // 监听器
  watch: {},

  created () {

  },

  mounted () {
    $(function () {
      $('.danmudrop-down').on('shown.bs.dropdown', function () {
        $(this).css({
          'background-color': '#F1F3F7'
        })
      })
      $('.danmudrop-down').on('hidden.bs.dropdown', function () {
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
      $('.danmu-filter-advance').click(function () {
        if ($('.danmu-advance-search').hasClass('danmuDisplay')) {
          $('.danmu-advance-search').removeClass('danmuDisplay')
        } else {
          $('.danmu-advance-search').addClass('danmuDisplay')
        }
      })
      $('.danmu-check-box-all').click(function () {
        if ($(this).hasClass('danmu-checked')) {
          $(this).removeClass('danmu-checked')
          $('.danmu-item .danmu-check-box').removeClass('danmu-checked')
        } else {
          $(this).addClass('danmu-checked')
          $('.danmu-item .danmu-check-box').addClass('danmu-checked')
        }
      })
      $('.danmu-check-box').click(function () {
        if ($(this).hasClass('danmu-checked')) {
          $(this).removeClass('danmu-checked')
        } else {
          $(this).addClass('danmu-checked')
        }
      })
      $('.danmu-item').hover(
        function () {
          $(this).addClass('danmu-item-hover')
        },
        function () {
          $(this).removeClass('danmu-item-hover')
        }
      )
    })
  },

  methods: {
  }
}
</script>

<style>
  @import "../../static/css/danmu.css";
</style>
