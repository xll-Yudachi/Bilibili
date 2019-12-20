<template>
  <div>
    <div class="login-head-wrapper">
      <div>
        <div class="login-head-div">
          <div class="login-head-title">
            <i class="login-head-icon1"></i>
            <a href="#">主站</a>
            <a href="#">音频</a>
            <a href="#">游戏中心</a>
            <a href="#">直播</a>
            <a href="#">会员购</a>
            <a href="#">漫画</a>
            <a href="#">70年</a>
            <a href="#"><i class="login-head-icon2"></i>下载APP</a>
          </div>
        </div>
        <div class="login-search-div">
          <form>
            <input class="login-head-search" placeholder="新王加冕，FPX夺冠全程视频回顾">
          </form>
          <i class="login-head-search-icon"></i>
        </div>
        <div class="login-user-div">
          <div class="login-user-content">
            <img class="user-img" src="../../../static/images/akari.jpg">
            <div class="login-head-user">
              <a href="#">动态</a>
              <a href="#">历史</a>
              <a href="#">创作中心</a>
              <a href="#" class="post">投稿</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="register-content">
      <div class="top-banner">
        <img src="../../../static/images/login_head.png">
      </div>
    </div>

    <div class="title-line">
      <span class="tit">注册</span>
    </div>

    <div class="register-container">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" onsubmit="return false">
        <el-form-item prop="checkName">
          <el-input placeholder="昵称" type="text" v-model="ruleForm.checkName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass">
          <el-input placeholder="密码（6-16个字符组成，区分大小写）" type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item prop="region" style="width: 150px;position: relative;left: -135px;top: 0px;">
          <el-select v-model="ruleForm.region" placeholder="中国大陆">
            <el-option label="中国大陆" value="中国大陆"></el-option>
            <el-option label="中国香港特别行政区" value="中国香港特别行政区"></el-option>
            <el-option label="中国澳门特别行政区" value="中国澳门特别行政区"></el-option>
            <el-option label="中国台湾" value="中国台湾"></el-option>
          </el-select>
          <el-form-item prop="checkPhone" style="width: 280px;position: relative;left: 130px;top: -70px">
            <el-input placeholder="填写常用手机号" type="text" v-model="ruleForm.checkPhone" autocomplete="off"></el-input>
          </el-form-item>
        </el-form-item>
        <el-form-item prop="checkCode">
          <el-input placeholder="请输入短信验证码" type="text" v-model="ruleForm.checkCode" autocomplete="off"></el-input>
          <el-button @click="sendSms" style="background-color:#00a1d6;position: relative;top: -40px;left: 269px;width: 140px" type="primary" id="sendSms">点击获取</el-button>
        </el-form-item>
        <div class="register-agree">
          <span class="check-box checkbox-bwxr">
            <input @click="clickCheck" name="agree" type="checkbox">
          </span>
            我已同意
          <a target="_blank" href="https://www.bilibili.com/protocal/licence.html">
            《哔哩哔哩弹幕网用户使用协议》
          </a>
            和
          <a target="_blank" href="https://www.bilibili.com/blackboard/privacy-pc.html">
            《哔哩哔哩隐私政策》
          </a>
        </div>
        <el-form-item>
          <el-button v-if="!checkBoxStatus" disabled style="color:#d9d9d9;border-color:#d9d9d9;background-color:#f5f5f5;width: 410px;position: relative;top: -35px" type="primary">注册</el-button>
          <el-button v-if="checkBoxStatus" @click="submitForm('ruleForm')" style="background-color:#00a1d6;width: 410px;position: relative;top: -35px" type="primary">注册</el-button>
        </el-form-item>

        <div class="register_pc_direct_login">
          <a href="/login.html">已有账号，直接登录&gt;</a>
        </div>
      </el-form>
    </div>

    <div class="bili-foot">
      <div class="footer-wrap">
        <div class="foot-div-1" >
          <span class="foot_span">bilibili</span>
          <ul class="foot-ul">
            <a href="#">关于我们</a>
            <a href="#">联系我们</a>
            <a href="#">加入我们</a>
            <a href="#">友情链接</a>
            <a href="#">bilibili认证</a>
            <a href="#">Investor Relations</a>
          </ul>
        </div>
        <div class="foot-div-2" >
          <span class="foot_span">传送门</span>
          <ul class="foot-ul">
            <a href="#">帮助中心</a>
            <a href="#">侵权申诉</a>
            <a href="#">壁纸站</a>
            <a href="#">高级弹幕</a>
            <a href="#">活动中心</a>
            <a href="#">专车号服务中心</a>
            <a href="#">活动专题页</a>
            <a href="#">用户回馈论坛</a>
            <a href="#">名人堂</a>
          </ul>
        </div>
        <div class="row foot-div-3" >
          <div class="download-target">
            <div class="target-div">
              <i class="pcDown"></i>
              <a href="#" class="target-link">客户端下载</a>
            </div>
            <div class="target-div">
              <i class="sinaWb"></i>
              <a href="#" class="target-link">&nbsp;&nbsp;新浪微博</a>
            </div>
            <div class="target-div">
              <i class="weChat"></i>
              <a href="#" class="target-link">&nbsp;&nbsp;官方微信</a>
            </div>
          </div>
        </div>
      </div>
      <div class="footer-wrap footer-wrap-content">
        <div class="row foot-content">
          <div class="col-xs-2 pic-box">
            <img src="../../../static/images/partner1.png">
            <img src="../../../static/images/partner2.png" width="100px">
            <img src="../../../static/images/partner3.png">
          </div>
          <div class="col-xs-10 txt-con">
            <p>广播电视节目制作经营许可证：（沪）字第1248号|网络文化经营许可证：沪网文【2016】2296-134号|信息网络传播视听节目许可证：0910417</p>
            <p>互联网ICP备案：
              <a href="http://www.miitbeian.gov.cn/" target="_blank">沪ICP备13002172号-3</a>
              沪ICP证：沪B2-20100043 |违法不良信息举报邮箱：help@bilibili.com |违法不良信息举报电话：4000233233转3 |
              <a href="//static.hdslb.com/../../../static/images/yyzz.png" target="_blank">营业执照</a>
            </p>
            <p>
              <i class="sprite bg1"></i>
              <a href="http://www.shjbzx.cn" target="_blank">上海互联网举报中心</a> |
              <a href="http://jb.ccm.gov.cn/" target="_blank">12318全国文化市场举报网站</a> |
              <i class="sprite bg2"></i><a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011002002436" target="_blank">沪公网安备31011002002436号</a> |
              <a href="mailto:userreport@bilibili.com">儿童色情信息举报专区</a>
            </p>
            <p>网上有害信息举报专区：
              <i class="sprite bg3"></i>
              <a href="http://report.12377.cn:13225/toreportinputNormal_anis.do" target="_blank">中国互联网违法和不良信息举报中心</a>
            </p>
            <p>亲爱的市民朋友，上海警方反诈劝阻电话“962110”系专门针对避免您财产被骗受损而设，请您一旦收到来电，立即接听。</p>
            <p>公司名称：上海宽娱数码科技有限公司|公司地址：上海市杨浦区政立路485号|电话：021-25099888</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else if (value.length < 6) {
        callback(new Error('密码不能小于6个字符'))
      } else if (value.length > 16) {
        callback(new Error('密码不能大于16个字符'))
      } else {
        callback()
      }
    }
    var validateName = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请告诉我你的昵称吧'))
      } else if (value.length <= 2) {
        callback(new Error('昵称过短'))
      } else {
        this.$axios({
          method: 'get',
          params: {
            username: value
          },
          url: 'http://localhost:9000/user/findUserByUsername'
        }).then(response => {
          if (response.data.success) {
            callback()
          } else {
            callback(response.data.message)
          }
        })
      }
    }
    var validatePhone = (rule, value, callback) => {
      var length = value.length
      var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/
      if (value === '') {
        callback(new Error('请输入手机号码'))
      } else if (length > 0 && !mobile.test(value)) {
        callback(new Error('请输入正确的手机号码'))
      } else {
        this.$axios({
          method: 'get',
          params: {
            phone: value
          },
          url: 'http://localhost:9000/user/findUserByPhone'
        }).then(response => {
          if (response.data.success) {
            callback()
          } else {
            callback(response.data.message)
          }
        })
      }
    }
    var validateCode = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入短信验证码'))
      } else {
        callback()
      }
    }
    return {
      checkBoxStatus: false,
      ruleForm: {
        checkPhone: '',
        checkPass: '',
        checkCode: '',
        checkName: '',
        region: '中国大陆'
      },
      user: {
        username: '',
        password: '',
        region: '',
        phone: '',
        sex: ''
      },
      rules: {
        checkPhone: [
          { validator: validatePhone, trigger: 'blur' }
        ],
        checkName: [
          { validator: validateName, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkCode: [
          { validator: validateCode, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.submitRegister()
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    clickCheck () {
      this.checkBoxStatus = !this.checkBoxStatus
    },
    submitRegister () {
      this.user.username = this.ruleForm.checkName
      this.user.password = this.ruleForm.checkPass
      this.user.phone = this.ruleForm.checkPhone
      this.user.region = this.ruleForm.region
      this.$axios({
        method: 'post',
        data: this.user,
        params: {
          code: this.ruleForm.checkCode
        },
        url: 'http://localhost:9000/user/register'
      }).then(response => {
        if (response.data.success) {
          window.location.href = 'login.html'
        } else {
          this.$message.error(response.data.message)
          this.resetForm('ruleForm')
        }
      })
    },
    sendSms () {
      this.$axios({
        method: 'get',
        url: 'http://localhost:9000/user/sendRegisterSms',
        params: {
          phone: this.ruleForm.checkPhone
        }
      }).then(response => {
        if (response.data.success) {
          this.$message.success('短信验证码已发送！')
          // eslint-disable-next-line no-undef,no-unused-expressions
          $('#sendSms').attr('disabled', 'true')
          // eslint-disable-next-line no-undef,no-unused-expressions
          $('#sendSms').css({
            'color': 'rgb(217, 217, 217)',
            'border-color': 'rgb(217, 217, 217)',
            'background-color': 'rgb(245, 245, 245)'
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
