<template>
  <div>
    <div class="video-head-wrapper">
      <div>
        <div class="video-head-div">
          <img src="../../../static/images/video_head_logo.png" class="head-logo-icon">
          <div class="video-head-title">
            <a href="#">主站<i class="video-head-icon1"></i></a>
            <a href="#">音频</a>
            <a href="#">游戏中心</a>
            <a href="#">直播</a>
            <a href="#">会员购</a>
            <a href="#">漫画</a>
            <a href="#">70年</a>
            <a href="#"><i class="video-head-icon2"></i>下载APP</a>
          </div>
        </div>
        <div class="video-search-div">
          <form>
            <input class="video-head-search" placeholder="00后国产男团这么强？">
          </form>
          <i class="video-head-search-icon"></i>
        </div>
        <div class="video-user-div">
          <div class="video-user-content">
            <img class="user-img" src="../../../static/images/user_head.jpg">
            <div class="video-head-user">
              <a href="#">大会员</a>
              <a href="#">消息</a>
              <a href="#">动态</a>
              <a href="#">稍后再看</a>
              <a href="#">收藏</a>
              <a href="#">历史</a>
              <a href="#" class="post">投稿</a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!--视频标题+Up主信息-->
    <div class="video-title-up-wrapper">
      <div class="row">
        <div class="col-xs-8 video-title">
          <div class="title">
            <span>日语版《说好不哭》翻唱【鹿乃/花寄女生宿舍】</span>
          </div>
          <div class="subtitle">
            <a href="#">音乐&nbsp;</a><span>></span><a href="#">&nbsp;翻唱</a>
            <span class="time">2019-09-23 22:00:44</span>
            <span>最高全站日排行10名</span>
          </div>
          <div class="num">
            <span>45.1万播放</span>
            <span>·</span>
            <span>2687弹幕</span>
            <span class="forbid">
                    <i class="forbid-icon"></i>
                    未经作者授权，禁止转载
                </span>
          </div>
        </div>
        <div class="col-xs-offset-1 col-xs-3 video-up">
          <div class="up-face">
            <img src="../../../static/images/up_img.jpg">
          </div>
          <div class="up-info">
            <p class="name is-vip">
              鹿乃ちゃん
              <a href="#"><i class="message-icon"></i>发消息</a>
            </p>
            <p class="brief">你好，我是鹿乃！</p>
          </div>
          <div class="focuson">
            <div class="charge"><span>充电</span></div>
            <div class="focusnum">
              <i class="focus-icon"></i>
              <span>关注48.1万</span>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!--视频播放页面-->
    <div class="video-play-wrapper">
      <div id="dplayer" class="dplayer" style="width: 850px;height: 500px;"></div>
      <div class="video-tool-bar">
        <span><img src="../../../static/images/thumbs.png">6.3万</span>
        <span><img src="../../../static/images/icon.png">7.5万</span>
        <span><img src="../../../static/images/collect.png">4.7万</span>
        <span><img src="../../../static/images/forward.png"/>1.2万</span>
        <div class="complaint">
          <a href="#">稿件投诉</a>
          <a id="myPopover-complaint" tabindex="0" class="btn" role="button" data-placement="bottom"
             data-toggle="popover" data-trigger="focus" title="" data-html="true"
             data-content="<div class='complaintbtn-div'><button class='complaintbtn data-content-button' href='#'>屏蔽设定</button><br><button class='complaintbtn data-content-button' href='#'>高级弹幕</button></div>">
            <img src="../../../static/images/danmu-more.png">
          </a>
        </div>
      </div>
      <div class="video-introduction">
        我用日语歌词用心翻唱了周杰伦的《说好不哭》

        演唱：鹿乃
        日语填词：花寄女生宿舍
        协助：MUE
        混音：HeavenZ
        封面/片尾图：柠檬喵桑/疯猫嗷
        时轴：投影
        特效：kiriko
        翻译：行方不知

        原唱：周杰伦，阿信
        作词：方文山
        作曲：周杰伦

        ∽∽───────────────────────∽∽

        花寄女子寮
        ◆鹿乃
        【Youtube】https://www.youtube.com/channel/UCfuz6xYbYFGsWWBi3SpJI1w?sub_confirmation=1
        【Twitter】https://twitter.com/kano_hanayori

        ◆野野宮ののの
        【bili】http://space.bilibili.com/441403698
        【Youtube】https://www.youtube.com/channel/UCiexEBp7-D46FXUtQ-BpgWg?sub_confirmation=1
        【Twitter】https://twitter.com/nonomiyanonono

        ◆花丸晴琉
        【bili】https://space.bilibili.com/441381282
        【Youtube】https://www.youtube.com/channel/UCyIcOCH-VWaRKH9IkR8hz7Q?sub_confirmation=1
        【Twitter】https://twitter.com/hanamaruhareru

        ◆小东人鱼
        【bili】https://space.bilibili.com/441382432
        【Youtube】https://www.youtube.com/channel/UCV2m2UifDGr3ebjSnDv5rUA?sub_confirmation=1
        【Twitter】https://twitter.com/kohigashihitona

        ◆花寄女子寮 公式
        【Twitter】https://twitter.com/hanayori_v

        ∽∽───────────────────────∽∽
      </div>
      <div class="more-video-introduction">
        <a href="javascript:void(0);">展示更多</a>
      </div>
      <div class="video_AD">
        <img src="../../../static/images/videoAD.jpg">
      </div>
      <div id="id" class="comment">
        <div class="b-head">
          <span class="b-head-t">3871</span>
          <span class="b-head-t">评论</span>
        </div>
        <div class="comments-header">
          <div class="tabs-order">
            <ul>
              <li>按热度排序</li>
              <li>按时间排序</li>
            </ul>
          </div>
          <div class="header-page">
            <span>共127页</span>
            <a href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <span>...</span>
            <a href="#">下一页</a>
          </div>
        </div>
      </div>
      <div class="video-play-danmu">
        <div class="video-play-danmu-head">
          <span class="danmu-list">弹幕列表</span>
          <a id="myPopover-danmu" tabindex="0" class="btn" role="button" data-placement="bottom" data-toggle="popover"
             data-trigger="focus" title="" data-html="true"
             data-content="<button class='btbtn data-content-button' href='#'>屏蔽设定</button><br><button class='btbtn data-content-button' href='#'>高级弹幕</button>"><img
            src="../../../static/images/danmu-more.png"></a>
          <span class="oper-danmu">展开</span>
        </div>
        <div class="video-play-danmu-content">
          <div class="time">时间</div>
          <div class="danmu-content">弹幕内容(1015)</div>
          <div class="send-time">发送时间</div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">03:01</span>
            <span class="danmu-content-item-content" title="推了!">推了!</span>
            <span class="danmu-content-item-send-time">09-25 22:25</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">00:40</span>
            <span class="danmu-content-item-content" title="死了">死了</span>
            <span class="danmu-content-item-send-time">09-25 22:28</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>
            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">00:04</span>
            <span class="danmu-content-item-content" title="2492正在观看">2492正在观看</span>
            <span class="danmu-content-item-send-time">09-25 22:28</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">01:03</span>
            <span class="danmu-content-item-content" title="阿瓦洛斯">阿瓦洛斯</span>
            <span class="danmu-content-item-send-time">09-25 22:28</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">01:09</span>
            <span class="danmu-content-item-content" title="awsl">awsl</span>
            <span class="danmu-content-item-send-time">09-25 22:28</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">00:16</span>
            <span class="danmu-content-item-content" title="啊我睡了">啊我睡了</span>
            <span class="danmu-content-item-send-time">09-25 22:28</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">02:33</span>
            <span class="danmu-content-item-content" title="いい歌だね">いい歌だね</span>
            <span class="danmu-content-item-send-time">09-25 22:28</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">03:03</span>
            <span class="danmu-content-item-content" title="就算时过境迁，我仍然深爱你">就算时过境迁，我仍然深爱你</span>
            <span class="danmu-content-item-send-time">09-25 22:33</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">03:03</span>
            <span class="danmu-content-item-content" title="就算时过境迁，我仍然深爱你">就算时过境迁，我仍然深爱你</span>
            <span class="danmu-content-item-send-time">09-25 22:33</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">03:03</span>
            <span class="danmu-content-item-content" title="就算时过境迁，我仍然深爱你">就算时过境迁，我仍然深爱你</span>
            <span class="danmu-content-item-send-time">09-25 22:33</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">03:03</span>
            <span class="danmu-content-item-content" title="就算时过境迁，我仍然深爱你">就算时过境迁，我仍然深爱你</span>
            <span class="danmu-content-item-send-time">09-25 22:33</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>

            </div>
          </div>
          <div class="danmu-content-item">
            <span class="danmu-content-item-time">03:03</span>
            <span class="danmu-content-item-content" title="就算时过境迁，我仍然深爱你">就算时过境迁，我仍然深爱你</span>
            <span class="danmu-content-item-send-time">09-25 22:33</span>
            <div class="danmu-button-group">
              <div class="danmu-mask report-mask">
                举报该弹幕的发送者
              </div>
              <div class="danmu-mask shield-mask">
                屏蔽该弹幕的发送者
              </div>
              <button class="danmu-button">举报</button>
              <button class="danmu-button">屏蔽用户</button>
            </div>
          </div>
          <button class="history-danmu">查看历史弹幕</button>
        </div>
        <!--广告-->
        <div class="danmu-ad" data-dismiss="alert" role="alert">
          <button>×</button>
          <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-example-generic" data-slide-to="1"></li>
              <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="item active">
                <img src="../../../static/images/danmu_ad_1.jpg" alt="...">
              </div>
              <div class="item">
                <img src="../../../static/images/danmu_ad_2.jpg" alt="...">
              </div>
              <div class="item">
                <img src="../../../static/images/danmu_ad_3.jpg" alt="...">
              </div>
            </div>
          </div>
        </div>
        <!--相关推荐-->
        <div class="danmu-reco">
          <span class="danmu-reco-title">相关推荐</span>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
          <div class="danmu-reco-item">
            <img src="../../../static/images/danmu_reco_1.jpg">
            <div class="danmu-reco-info">
              <a href="#" class="title">日语版《说好不哭》女声翻唱【花丸晴琉/花寄女生宿</a>
              <a href="#" class="up">花丸晴琉Official</a>
              <div class="play-num">
                <span>22.8万播放</span>
                <span>·</span>
                <span>1177弹幕</span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div style="height: 1160px"></div>
    </div>

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

  created () {

  },

  methods: {}
}
</script>
