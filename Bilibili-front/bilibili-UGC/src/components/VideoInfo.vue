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
          <el-steps :space="200" :active="1" align-center finish-status="success" class="ugc-upload-steps">
            <el-step title="已完成（上传视频）"></el-step>
            <el-step title="进行中(填写视频信息)"></el-step>
            <el-step title="预览上传视频"></el-step>
          </el-steps>
          <div class="video-info-container">
            <div class="video-info-title-wrap">
              <h1>基本信息</h1>
              <div class="vitw-template-op">
                <p>使用投稿模版</p>
                <div class="vitw-template-divide"></div>
                <img src="../../static/images/template-op.png">
              </div>
            </div>
            <div class="vic-cover">
              <div class="vic-section-title">
                <h3 class="vic-section-title-main">视频封面设置</h3>
                <p class="vic-section-title-sub">（格式jpeg、png，文件大小≤5MB，建议尺寸≥1146*717，最低尺寸≥960*600）</p>
              </div>
              <div class="vic-cover-detail">
                <div class="vic-cover-preview">
                  <div class="vic-cover-preview-default">
                    <span class="vic-cover-upload-tip">上传封面</span>
                  </div>
                  <el-upload
                    class="vic-avatar-uploader"
                    :action="uploadImg()"
                    :show-file-list="false"
                    :on-success="handleAvatarSuccess"
                    :before-upload="beforeAvatarUpload"
                    :on-preview="handlePictureCardPreview"
                    :on-remove="handleRemove">
                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                    <i v-else class="vic-avatar-icon">
                      <img src="../../static/images/bilibili_tv.png">
                    </i>
                  </el-upload>
                </div>
                <div class="vic-cover-selector">
                  <div class="vic-cover-selector-deg"></div>
                  <div>
                    <p class="vic-cover-selector-title">可以选择以下封面。</p>
                  </div>
                  <div class="vic-cover-selector-items">
                    <div class="vic-cover-selector-item">
                      <img src="../../static/images/bilibili_tv.png" class="vic-cover-selector-item-img">
                    </div>
                    <div class="vic-cover-selector-item">
                      <img src="../../static/images/bilibili_tv.png" class="vic-bilibili-tv-small">
                    </div>
                    <div class="vic-cover-selector-item">
                      <img src="../../static/images/bilibili_tv.png" class="vic-bilibili-tv-small">
                    </div>
                    <div class="vic-cover-selector-item">
                      <img src="../../static/images/bilibili_tv.png" class="vic-bilibili-tv-small">
                    </div>
                    <div class="vic-cover-selector-item">
                      <img src="../../static/images/bilibili_tv.png" class="vic-bilibili-tv-small">
                    </div>
                  </div>
                </div>
              </div>
              <div class="vic-copyright-container">
                <div class="vic-common-title">
                  <p class="vic-common-title-inner">*</p>
                  <h3 class="vic-common-title-main">类型</h3>
                </div>
                <div class="vic-copyright-radio-group">
                  <div class="vic-copyright-radio-container">
                    <span class="vic-copyright-radio-box vic-copyright-radio-box-checked"></span>
                    <span class="vic-copyright-radio-name">自制</span>
                  </div>
                  <div class="vic-copyright-radio-container">
                    <span class="vic-copyright-radio-box"></span>
                    <span class="vic-copyright-radio-name">转载</span>
                  </div>
                </div>
                <el-input
                  class="vic-displayNone"
                  style="margin-top: 12px"
                  type="text"
                  placeholder="转载视频请注明来源（例：转自http://www.xxxx.com/yyyy），注明来源会更快地通过审核哦"
                  v-model="copyrightText"
                  maxlength="200"
                  show-word-limit
                >
                </el-input>
              </div>
              <div class="vic-partition-container">
                <div class="vic-common-title">
                  <p class="vic-common-title-inner">*</p>
                  <h3 class="vic-common-title-main">分区</h3>
                </div>
                <div class="block" style="text-align: left;margin-top: 12px">
                  <el-cascader
                    placeholder="点击选择"
                    v-model="vicValue"
                    :options="vicOptions"
                    @change="vicValuehandleChange"></el-cascader>
                </div>
              </div>
              <div class="vic-title-container">
                <div class="vic-common-title">
                  <p class="vic-common-title-inner">*</p>
                  <h3 class="vic-common-title-main">标题</h3>
                </div>
                <el-input
                  style="margin-top: 12px"
                  type="text"
                  placeholder="请输入内容"
                  v-model="titleText"
                  maxlength="80"
                  show-word-limit
                >
                </el-input>
              </div>
              <div class="vic-tag-container">
                <div class="vic-common-title">
                  <p class="vic-common-title-inner">*</p>
                  <h3 class="vic-common-title-main">标签</h3>
                  <p class="vic-section-title-sub">（使用活动标签即可参与活动，默认以前三个标签同步生成动态话题）
                  </p>
                </div>
                <div class="vic-tag-input-wrap">
                  <div class="vic-tag-input-box">
                    <div class="vic-tag-pre-wrap"></div>
                    <div class="vic-tag-input-box-instance">
                      <input type="text" maxlength="20" placeholder="按回车键Enter创建标签" class="vic-tag-input-box-val"/>
                    </div>
                    <p class="vic-tag-last-wrap">还可以添加<span>10</span>个标签</p>
                  </div>
                </div>
                <div class="vic-tag-other-wrap">
                <p class="vic-tag-other-label">推荐标签：</p>
                <div class="vic-tag-other-wrap-container">
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>音乐</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>MV</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>鬼畜</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>OP</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>搞笑</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>日本</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>完整版</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>动漫音乐</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>日常</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>动漫歌曲</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>BGM</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>动漫</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>剪辑</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>自制</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>原创</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>舞蹈</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>COSPLAY</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>现场</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>你的名字</span>
                    </p>
                  </div>
                  <div class="vic-tag-other-wrap-item">
                    <p>
                      <span>搬运</span>
                    </p>
                  </div>
                </div>
              </div>
                <div class="vic-tag-other-wrap">
                  <p class="vic-tag-other-label">参与活动：</p>
                  <div class="vic-tag-other-wrap-container vic-displayNone">
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>年度红黑盛典</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <i class="hot-icon"></i>
                        <span>12月打卡挑战</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <i class="hot-icon"></i>
                        <span>30天vlog挑战</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>我的学习日记</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>明日方舟·中心公园赛区</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <i class="hot-icon"></i>
                        <span>好奇心计划</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>猫咪维密大赛</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>考研加油站</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>聊聊我的职业</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>CF手游好兄弟别客气</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>奖学金计划-闯关四六级</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>追梦者</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>想读就读</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>带着小电视逛漫展</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>浮生一顿饭</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>克兰多尔学园祭</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>哔哩特效！变声！</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>中国电信&nbsp;Hello&nbsp;5G</span>
                      </p>
                    </div>
                    <div class="vic-tag-other-wrap-item">
                      <p>
                        <span>完美世界天秀妖刃招募</span>
                      </p>
                    </div>
                  </div>
                  <p class="vic-tag-other-act-wrap">
                    活动标签可在
                    <span style="font-weight: 700">选择分区</span>
                    后查看
                  </p>
                </div>
              </div>
              <div class="vic-intro-container">
                <div class="vic-common-title">
                  <h3 class="vic-common-title-main">简介</h3>
                </div>
                <el-input
                  class="vic-intro-text"
                  type="textarea"
                  placeholder="填写更全面的相关信息，让更多的人能找到你的视频吧！"
                  v-model="introTextarea"
                  maxlength="250"
                  show-word-limit
                  resize="none"
                >
                </el-input>
              </div>
              <div class="vic-dividing-line"></div>
              <div class="vic-option-container">
                <div class="option-title-wrap">
                  <h1>更多选项</h1>
                  <i class="option-title-icon el-icon-arrow-down"></i>
                  <p class="option-title-tip">（自制声明、商业声明、字幕设置、水印和充电开关）</p>
                </div>
                <div class="option-list-wrap vic-displayNone">
                  <div class="original-set-container">
                    <div class="original-title-container">
                      <h3 class="otc-main">自制声明</h3>
                      <i class="otc-icon"></i>
                      <div class="otc-icon-info vic-displayNone">
                        <p class="otc-icon-info-content">
                          勾选后该文案会显示在视频播放页中，此选项可以在再次编辑时取消
                        </p>
                        <p class="otc-icon-info-important">
                          一旦取消勾选操作，不可再次勾选
                        </p>
                      </div>
                    </div>
                    <div class="original-switch-wrap">
                      <div class="original-switch-check-box">
                        <i class="original-switch-check-box-icon original-switch-checked"></i>
                        <p class="original-switch-check-box-content">未经作者授权 禁止转载</p>
                      </div>
                    </div>
                  </div>
                  <div class="original-watermask-set-container">
                    <div class="original-title-container">
                      <h3 class="otc-main">视频水印</h3>
                    </div>
                    <div class="original-watermask-switch-wrap">
                      <span>已开启原创视频专属水印</span>
                      <a>查看配置</a>
                    </div>
                  </div>
                  <div class="original-subtitle-container">
                    <div class="original-title-container">
                      <h3 class="otc-main">字幕设置</h3>
                      <i class="otc-icon"></i>
                      <div class="otc-icon-info vic-displayNone">
                        <p class="otc-icon-info-content">
                          观众将会为您的投稿添加字幕，使非您所使用的语言的观众也可以观看
                        </p>
                      </div>
                    </div>
                    <div style="text-align: left;
    margin-top: 10px;">
                      <el-select v-model="ZMvalue" filterable placeholder="请选择视频语言">
                        <el-option
                          v-for="item in ZMoptions"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                        </el-option>
                      </el-select>
                    </div>
                    <div class="original-switch-wrap">
                      <div class="original-switch-check-box">
                        <i class="original-switch-check-box-icon"></i>
                        <p class="original-switch-check-box-content">允许观众投稿字幕</p>
                      </div>
                    </div>
                  </div>
                  <div class="original-porder-set-container">
                    <div class="original-title-container">
                      <h3 class="otc-main">商业声明</h3>
                      <i class="otc-icon"></i>
                      <div class="otc-icon-info vic-displayNone">
                        <p class="otc-icon-info-content">
                          勾选后该文案会显示在视频播放页中，此选项可以在再次编辑时取消
                        </p>
                      </div>
                    </div>
                    <div class="vic-copyright-radio-group">
                      <div class="vic-copyright-radio-container">
                        <span class="vic-copyright-radio-box vic-copyright-radio-box-checked"></span>
                        <span class="vic-copyright-radio-name">不含商业推广信息</span>
                      </div>
                      <div class="vic-copyright-radio-container">
                        <span class="vic-copyright-radio-box"></span>
                        <span class="vic-copyright-radio-name">含商业推广信息</span>
                      </div>
                    </div>
                    <div class="otc-item-list vic-displayNone">
                      <div style="text-align: left;
    margin-top: 15px;">
                        <el-select v-model="otc1value" placeholder = "手机游戏">
                          <el-option
                            v-for="item in otcItem1Options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                          </el-option>
                        </el-select>
                        <el-input v-model="otcInput" placeholder="选择游戏"></el-input>
                      </div>
                      <div style="text-align: left;
    margin-top: 15px;">
                        <el-select v-model="otc2value" placeholder="请选择推广形式">
                          <el-option
                            v-for="item in otcItem2Options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                          </el-option>
                        </el-select>
                      </div>
                    </div>
                  </div>
                  <div class="original-electron-set-container">
                    <div class="original-title-container">
                      <h3 class="otc-main">充电设置</h3>
                    </div>
                    <div class="otc-electron-content">
                        <a>参加充电计划</a>
                        <span>让我们为您的创作充电</span>
                    </div>
                  </div>
                </div>
                <div class="vic-dividing-line"></div>
              </div>
              <div class="vic-fans-dynamic-container">
                <div class="fans-dynamic-title-wrap">
                  <h1>粉丝动态</h1>
                </div>
                <el-input
                  style="margin-top: 15px"
                  type="textarea"
                  placeholder="有趣的动态描述，会增加被小编捕捉为热门动态的机会哟 (๑´ㅂ`๑) "
                  v-model="fansTextarea"
                  maxlength="233"
                  show-word-limit
                  resize="none"
                >
                </el-input>
              </div>
              <div class="vic-dtime-container">
                <div class="vic-dtime-switch-wrap">
                  <p class="vic-dtime-pre">定时发布</p>
                  <el-switch
                    v-model="isDtime"
                    active-text=""
                    inactive-text="">
                  </el-switch>
                  <p class="vic-dtime-last">
                    （当前+4小时 ≤ 可选时间 ≤ 当前+15天，转载稿件撞车判定以过审发布时间为准)
                  </p>
                </div>
              </div>
              <div class="vic-submit-btn-group">
                <el-dialog
                  title="提示"
                  :visible.sync="centerDialogVisible"
                  width="30%"
                  :modal-append-to-body="false"
                  center>
                  <span>需要注意的是内容是默认不居中的</span>
                  <span slot="footer" class="dialog-footer">
    <el-button @click="centerDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
  </span>
                </el-dialog>
                <button class="postnow" @click="submitVideoInfo">立即投稿</button>
                <el-button class="saveTemplate" type="text" @click="centerDialogVisible = true">保存模板</el-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </el-row>
  </div>
</template>

<script>
import '../../static/js/toastr.min'
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {
      videoForm: {
        id: '',
        title: '',
        upid: '',
        partition_1: '',
        partition_2: '',
        video_info: '',
        tag: '',
        copyright: '',
        reprinted_url: '',
        hms: '',
        subtitle: '',
        fans_post_subtitle: '',
        ccs: '',
        ccs_category_1: '',
        ccs_category_2: '',
        ccs_way: '',
        fans_dynamic: ''
      },
      centerDialogVisible: false,
      isDtime: '',
      fansTextarea: '',
      imageUrl: '',
      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      titleText: '',
      introTextarea: '',
      copyrightText: '',
      ZMvalue: [],
      otc1value: [],
      otc2value: [],
      vicValue: [],
      otcInput: '',
      ZMoptions: [],
      otcItem1Options: [],
      otcItem2Options: [],
      vicOptions: []
    }
  },

  // 监听器
  watch: {},

  created () {
    this.videoForm.id = sessionStorage.getItem('videoId')
    sessionStorage.setItem('copyright', '0')
    sessionStorage.setItem('otc', '0')
    this.$axios({
      method: 'get',
      url: 'http://localhost:9003/media/initCategory'
    }).then(response => {
      if (response.data.success) {
        this.vicOptions = response.data.data
      }
    })

    this.$axios({
      method: 'get',
      url: 'http://localhost:9003/media/initLanguage'
    }).then(response => {
      if (response.data.success) {
        this.ZMoptions = response.data.data
      }
    })

    this.$axios({
      method: 'get',
      url: 'http://localhost:9003/media/initCommercial'
    }).then(response => {
      if (response.data.success) {
        this.otcItem1Options = response.data.data
      }
    })

    this.$axios({
      method: 'get',
      url: 'http://localhost:9003/media/initCommercialWay'
    }).then(response => {
      if (response.data.success) {
        this.otcItem2Options = response.data.data
      }
    })
  },

  mounted () {
    $(function () {
      $('.otc-icon').hover(
        function () {
          $(this).next().removeClass('vic-displayNone')
        },
        function () {
          $(this).next().addClass('vic-displayNone')
        }
      )
    })
    $(function () {
      $('.original-switch-check-box-icon').click(function () {
        if ($(this).hasClass('original-switch-checked')) {
          $(this).removeClass('original-switch-checked')
        } else {
          $(this).addClass('original-switch-checked')
        }
      })
      $('.option-title-wrap').click(function () {
        if ($(this).next().hasClass('vic-displayNone')) {
          $(this).next().removeClass('vic-displayNone')
          $(this).find('i').addClass('deg180')
        } else {
          $(this).next().addClass('vic-displayNone')
          $(this).find('i').removeClass('deg180')
        }
      })
    })
    $(function () {
      $('.vic-tag-other-wrap-item').click(function () {
        if ($('.vic-tag-other-wrap-container').children('.vic-tag-pre-item-selected').length === 10) {
          alert('Σ( ° △ °|||) 允许添加的标签已经达到上限了')
          return
        }

        if (!$(this).hasClass('vic-tag-pre-item-selected')) {
          $(this).addClass('vic-tag-pre-item-selected')
          let content = $(this).children().children().text()
          $('.vic-tag-pre-wrap').append(
            ' <div class="vic-tag-pre-item">\n' +
            '            <p class="vic-tag-pre-item-content">' + content + '</p>\n' +
            '            <i class="icon-guanbi"></i>\n' +
            '          </div>'
          )
          if ($('.vic-tag-pre-wrap').width() > 568) {
            $('.vic-tag-input-box-instance').addClass('vic-displayNone')
          } else {
            $('.vic-tag-input-box-instance').removeClass('vic-displayNone')
          }
          if ($('.vic-tag-pre-wrap').width() >= 804) {
            $('.vic-tag-last-wrap').addClass('vic-displayNone')
          } else {
            $('.vic-tag-last-wrap').removeClass('vic-displayNone')
          }

          let oriTagNum = $('.vic-tag-last-wrap').find('span').text()
          $('.vic-tag-last-wrap').find('span').text(parseInt(oriTagNum) - 1)

          if ($('.vic-tag-pre-wrap').height() >= 38) {
            $('.vic-tag-input-box').css({
              'height': '76px'
            })
            $('.vic-tag-pre-item').css({
              'margin': '4px 5px 3px 0px'
            })
          } else {
            $('.vic-tag-input-box').css({
              'height': '38px'
            })
            $('.vic-tag-pre-item').css({
              'margin': '3px 5px 3px 0px'
            })
          }
        }
      })

      $(document).on('click', '.vic-tag-pre-item', function () {
        let content = $(this).children().text()
        let $childrens = $('.vic-tag-other-wrap-item').children()
        let index = 0
        for (let i = 0; i < $childrens.length; i++) {
          if ($childrens[i].innerText.trim() === content.trim()) {
            index = i
            break
          }
        }
        $('.vic-tag-other-wrap-item').eq(index).removeClass('vic-tag-pre-item-selected')
        $(this).addClass('vic-displayNone')
        if ($('.vic-tag-pre-wrap').width() > 568) {
          $('.vic-tag-input-box-instance').addClass('vic-displayNone')
        } else {
          $('.vic-tag-input-box-instance').removeClass('vic-displayNone')
        }
        if ($('.vic-tag-pre-wrap').width() >= 804) {
          $('.vic-tag-last-wrap').addClass('vic-displayNone')
        } else {
          $('.vic-tag-last-wrap').removeClass('vic-displayNone')
        }
        let oriTagNum = $('.vic-tag-last-wrap').find('span').text()
        $('.vic-tag-last-wrap').find('span').text(parseInt(oriTagNum) + 1)

        if ($('.vic-tag-pre-wrap').height() >= 38) {
          $('.vic-tag-input-box').css({
            'height': '76px'
          })
          $('.vic-tag-pre-item').css({
            'margin': '4px 5px 3px 0px'
          })
        } else {
          $('.vic-tag-input-box').css({
            'height': '38px'
          })
          $('.vic-tag-pre-item').css({
            'margin': '3px 5px 3px 0px'
          })
        }
      })

      $('.vic-copyright-radio-box').click(function () {
        if (!$(this).hasClass('vic-copyright-radio-box-checked')) {
          $(this).addClass('vic-copyright-radio-box-checked')
          $(this).parent().siblings().children('.vic-copyright-radio-box').removeClass('vic-copyright-radio-box-checked')
        }

        if ($(this).next().text() === '转载') {
          $('.vic-copyright-container .el-input').removeClass('vic-displayNone')
          sessionStorage.setItem('copyright', '1')
        }
        if ($(this).next().text() === '自制') {
          $('.vic-copyright-container .el-input').addClass('vic-displayNone')
          sessionStorage.setItem('copyright', '0')
        }
        if ($(this).next().text() === '不含商业推广信息') {
          $('.otc-item-list').addClass('vic-displayNone')
          sessionStorage.setItem('otc', '0')
        }
        if ($(this).next().text() === '含商业推广信息') {
          $('.otc-item-list').removeClass('vic-displayNone')
          sessionStorage.setItem('otc', '1')
        }
      })
    })
  },

  methods: {
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
      console.log(this.imageUrl)
      console.log(file)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    handleRemove (file) {
      console.log(file)
    },
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    handleDownload (file) {
      console.log(file)
    },
    vicValuehandleChange () {
      $('.vic-tag-other-act-wrap').addClass('vic-displayNone')
      $('.vic-tag-other-act-wrap').prev().removeClass('vic-displayNone')
      console.log(this.vicValue)
    },
    submitVideoInfo () {
      for (var i = 0; i < $('.vic-tag-pre-item-content').length; i++) {
        if (i === $('.vic-tag-pre-item-content').length - 1) {
          this.videoForm.tag += $($('.vic-tag-pre-item-content')[i]).text()
        } else {
          this.videoForm.tag += $($('.vic-tag-pre-item-content')[i]).text() + '|'
        }
      }
      this.videoForm.title = this.titleText
      this.videoForm.upid = localStorage.getItem('uid')
      this.videoForm.partition_1 = this.vicValue[0]
      this.videoForm.partition_2 = this.vicValue[1]
      this.videoForm.video_info = this.introTextarea
      this.videoForm.copyright = sessionStorage.getItem('copyright')
      this.videoForm.reprinted_url = this.copyrightText
      if ($($('.original-switch-check-box-icon')[0]).hasClass('original-switch-checked')) {
        this.videoForm.hms = 1
      } else {
        this.videoForm.hms = 0
      }
      if ($($('.original-switch-check-box-icon')[1]).hasClass('original-switch-checked')) {
        this.videoForm.fans_post_subtitle = 1
      } else {
        this.videoForm.fans_post_subtitle = 0
      }
      this.videoForm.subtitle = this.ZMvalue
      this.videoForm.ccs = sessionStorage.getItem('otc')
      this.videoForm.ccs_category_1 = this.otc1value
      this.videoForm.ccs_category_2 = this.otcInput
      this.videoForm.ccs_way = this.otc2value
      this.videoForm.fans_dynamic = this.fansTextarea

      console.log(this.videoForm)
      sessionStorage.setItem('videoInfoStatus', 'success')

      this.$confirm('是否确定投稿', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'info'
      }).then(() => {
        this.$axios({
          method: 'post',
          url: 'http://localhost:9001/upload/videoInfo',
          data: this.videoForm
        }).then(response => {
          if (response.data.success) {
            this.$message({
              type: 'success',
              message: '投稿成功!'
            })
            this.$confirm('是否前往视频预览页面', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'info'
            }).then(() => {
              this.$router.push('/upload/preview')
            }).catch(() => {

            })
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消投稿'
        })
      })
    },
    uploadImg () {
      return 'http://localhost:9001/upload/videoImg/' + this.videoForm.id
    }
  }
}
</script>

<style>
  @import "../../static/css/toastr.min.css";
  @import "../../static/css/upload.css";
</style>
