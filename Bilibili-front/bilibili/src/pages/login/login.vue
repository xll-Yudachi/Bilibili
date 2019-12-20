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

    <div class="video-content">
      <div class="top-banner">
        <img src="../../../static/images/login_head.png">
      </div>
    </div>

    <div class="title-line">
      <span class="tit">登录</span>
    </div>

    <div class="login-box">
      <div class="login-box-left">
        <div class="qrcode-login">
          <div class="qrcode-con">
            <i class="tv-icon"></i>
            <div class="qrcode-box">
              <div class="qrcode-img"
                   title="https://passport.bilibili.com/qrcode/h5/login?oauthKey=abfcaad46be9f24be8c6be266bc55675">
                <img
                  src="data:image/png;base64,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"
                  style="display: block;">
              </div>
            </div>
          </div>
          <div class="qrcode-footer">
            <p class="status-txt">
              扫描二维码登录
            </p>
            <p class="app-link">
              请使用
              <a href="//app.bilibili.com/" target="_blank">哔哩哔哩客户端</a>
              <br/>
              扫码登录
              <br/>
              或扫码下载APP
            </p>
          </div>
        </div>
      </div>

      <div class="line"></div>

      <div class="login-box-right">
        <div class="form-login">
          <div id="geetest-wrap" class="input-box">
            <ul>
              <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item prop="checkPhoneOrEmial" style="width: 410px;">
                  <el-input placeholder="你的手机号/邮箱" type="text" v-model="ruleForm.checkPhoneOrEmial" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item  prop="checkPass" style="width: 410px;">
                  <el-input placeholder="密码" type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                </el-form-item>
              </el-form>

              <li class="item gc clearfix">
              </li>
              <li class="remember">
                <span>
                  <input type="checkbox">
                  <span class="remember-me">记住我</span>
                  <span class="not-remember">不是自己的电脑上不要勾选此项</span>
                  <a target="_blank" href="//passport.bilibili.com/register/findpassword.html#/verify"
                     class="forget-password">忘记密码?</a>
                  <a target="_blank" href="//www.bilibili.com/blackboard/help.html#%E8%B4%A6%E5%8F%B7%E7%9B%B8%E5%85%B3"
                     class="not-checkout">无法验证?</a>
                </span>
              </li>
              <li class="btn-box">
                <el-button
                  type="primary"
                  style="background-color: #00a7de;height: 38px;width: 186px"
                  @click="submitForm('ruleForm')"
                >登录
                </el-button>
                <el-button
                  type="primary"
                  style="background-color: white;height: 38px;width: 186px;border: 1px solid #ccc;color: #0f0f0f;margin-left: 35px"
                  @click="toRegister"
                >注册
                </el-button>
              </li>
              <li class="sns">
                <i class="weibo-icon"></i>
                <a class="btn weibo">微博账号登录</a>
                <i class="qq-icon"></i>
                <a class="btn qq">QQ账号登录</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <p class="agreement">
      登录即代表你同意
      <a target="_blank" href="https://www.bilibili.com/protocal/licence.html">
        用户协议
      </a>
        和
      <a target="_blank" href="https://www.bilibili.com/blackboard/privacy-pc.html">
        隐私政策
      </a>
    </p>

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
      } else {
        callback()
      }
    }

    var validatePhoneOrEmail = (rule, value, callback) => {
      var length = value.length
      var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/
      var email = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
      if (value === '' || length === 0) {
        callback(new Error('请输入注册时用的邮箱或者手机号呀'))
      } else {
        if (mobile.test(value)) {
          this.user.phone = value
          this.user.password = this.ruleForm.checkPass
        }
        if (email.test(value)) {
          this.user.email = value
          this.user.password = this.ruleForm.checkPass
        }
        callback()
      }
    }

    return {
      user: {
        phone: '',
        email: '',
        password: ''
      },
      ruleForm: {
        checkPhoneOrEmial: '',
        checkPass: ''
      },
      rules: {
        checkPhoneOrEmial: [
          { validator: validatePhoneOrEmail, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass, trigger: 'blur' }
        ]
      },
      isValid: false
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.isValid = true
        } else {
          console.log('error submit!!')
          return false
        }
        if (this.isValid) {
          this.$axios({
            method: 'post',
            data: this.user,
            url: '/api/user/login'
          }).then(response => {
            if (response.data.success) {
              localStorage.setItem('uid', response.data.data)
              window.location.href = '/index.html'
            } else {
              this.$message.error(response.data.message)
            }
          })
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    toRegister () {
      window.location.href = '/register.html'
    }
  }
}
</script>

<style scoped>

</style>
