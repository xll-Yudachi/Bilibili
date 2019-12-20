<template>
  <div id="app">
    <div>
      <div class="head">
        <div class="nav-mask row">
          <div class="col-xs-1 nav-mask-height"></div>
          <div class="col-xs-6 nav-mask-height" style="min-width: 420px">
            <ul class="nav-mask-ul">
              <li><a class="nav-mask-a" href="#" title="主站"><i class="mainImg"></i>主站</a></li>
              <li><a class="nav-mask-a" href="#" title="来探索bilibili音乐的世界吧~">音频</a></li>
              <li><a class="nav-mask-a" href="#" title="游戏中心">游戏中心</a></li>
              <li><a class="nav-mask-a" href="#" title="直播">直播</a></li>
              <li><a class="nav-mask-a" href="#" title="漫画"><i class="comicImg"></i>漫画</a></li>
              <li><a class="nav-mask-a" href="#" title="BW">BW</a></li>
              <li><a class="nav-mask-a" href="#" title="70年">70年</a></li>
              <li class="nav-mask-ul-last-li"><a class="nav-mask-a" href="#" title="下载APP"><i
                class="appImg"></i>下载APP</a></li>
            </ul>
          </div>
          <div class="col-xs-4 nav-mask-height dismiss">
            <ul class="nav-mask-user-ul">
              <li>
                <a id="user-head-img" class="nav-mask-a">
                  <!--未登录-->
                  <div v-if="!user.id" class="logOutDiv">
                    <img class="userImg" src="../../../static/images/akari.jpg" @click="toLogin">
                  </div>

                  <!--登录-->
                  <div v-if="user.id" class="logOutDiv el-dropdown-link">
                    <img v-if="user.head_img" @click="toSpace" class="userImg" style="left: -152px;" :src=user.head_img>
                    <img v-if="!user.head_img" @click="toSpace" class="userImg" style="left: -152px;"
                         src="../../../static/images/noface.gif">
                  </div>
                </a>
              </li>
              <div v-if="!user.id">
                <li v-if="!user.id" style="position: relative;left: 162px"><a href="#" class="nav-mask-a">动态</a></li>
                <li v-if="!user.id" style="position: relative;left: 162px"><a href="#" class="nav-mask-a">历史</a></li>
                <div v-if="!user.id" class="contributions"><a href="#" class="nav-mask-a u-link">投稿</a></div>
              </div>
              <div v-if="user.id">
                <li><a @click="logout" class="nav-mask-a">退出</a></li>
                <li><a href="#" class="nav-mask-a">大会员</a></li>
                <li><a href="#" class="nav-mask-a">消息</a></li>
                <li><a href="#" class="nav-mask-a">动态</a></li>
                <li><a href="#" class="nav-mask-a">收藏</a></li>
                <li><a href="#" class="nav-mask-a">历史</a></li>
                <li><a href="#" class="nav-mask-a" @click="toUGC">创作中心</a></li>
                <div style="margin-left: 385px;" class="contributions"><a href="#" class="nav-mask-a u-link">投稿</a>
                </div>
              </div>

            </ul>
          </div>
          <div class="col-xs-1 nav-mask-height"></div>
          <!--<div style="width: 100%;height: 1000px"></div>-->
        </div>
        <div class="nav-head"></div>
        <div class="nav-band"></div>
        <div class="nav-search searchDisMiss">
          <a href="#" class="link-ranking link-ranking-bg">排行榜</a>
          <input id="search-keyword" type="text" placeholder="微波炉也能做烧烤？？？" class="search-keyword link-ranking-bg"
                 v-model="keyword">
          <button id="submitSearchBtn" type="submit" class="search-submit" @click="submitSearch"></button>
        </div>
      </div>

      <div class="bili-wrapper">

        <div id="index" class="dropdown dropdown-menu-myclass">
          <i class="indexImg"></i>
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button">
            <div>首页</div>
          </button>
        </div>

        <div id="animation" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu1"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>动画</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
            <li><a href="#">MAD·AMV</a></li>
            <li><a href="#">MMD·3D</a></li>
            <li><a href="#">短书·手书·配音</a></li>
            <li><a href="#">特摄</a></li>
            <li><a href="#">综合</a></li>
          </ul>
        </div>

        <div id="panju" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu2"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>番剧</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <li><a href="#">连载动画</a></li>
            <li><a href="#">完结动画</a></li>
            <li><a href="#">资讯</a></li>
            <li><a href="#">官方延伸</a></li>
            <li><a href="#">新番时间表</a></li>
            <li><a href="#">番剧索引</a></li>
          </ul>
        </div>

        <div id="guochuang" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu3"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>国创</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
            <li><a href="#">国产动画</a></li>
            <li><a href="#">国产原创相关</a></li>
            <li><a href="#">布袋戏</a></li>
            <li><a href="#">动态剧·广播剧</a></li>
            <li><a href="#">资讯</a></li>
            <li><a href="#">新番时间表</a></li>
            <li><a href="#">国产动画索引</a></li>
          </ul>
        </div>

        <div id="music" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu4"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>音乐</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu4">
            <li><a href="#">原创音乐</a></li>
            <li><a href="#">翻唱</a></li>
            <li><a href="#">VOCALOID·UTAU</a></li>
            <li><a href="#">电音</a></li>
            <li><a href="#">演奏</a></li>
            <li><a href="#">MV</a></li>
            <li><a href="#">音乐现场</a></li>
            <li><a href="#">音乐综合</a></li>
            <li><a href="#">音频</a></li>
          </ul>
        </div>

        <div id="dance" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu5"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>舞蹈</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu5">
            <li><a href="#">宅舞</a></li>
            <li><a href="#">街舞</a></li>
            <li><a href="#">明星舞蹈</a></li>
            <li><a href="#">中国舞</a></li>
            <li><a href="#">舞蹈综合</a></li>
            <li><a href="#">舞蹈教程</a></li>
          </ul>
        </div>

        <div id="game" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu6"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>游戏</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu6">
            <li><a href="#">单机游戏</a></li>
            <li><a href="#">电子竞技</a></li>
            <li><a href="#">手机游戏</a></li>
            <li><a href="#">网络游戏</a></li>
            <li><a href="#">桌游棋牌</a></li>
            <li><a href="#">GMV</a></li>
            <li><a href="#">音游</a></li>
            <li><a href="#">Mugen</a></li>
            <li><a href="#">游戏赛事</a></li>
          </ul>
        </div>

        <div id="technology" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu7"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>科技</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu7">
            <li><a href="#">趣味科普人文</a></li>
            <li><a href="#">野生技术协会</a></li>
            <li><a href="#">演讲·公开课</a></li>
            <li><a href="#">星海</a></li>
            <li><a href="#">机械</a></li>
            <li><a href="#">汽车</a></li>
          </ul>
        </div>

        <div id="digital" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu8"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>数码</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu8">
            <li><a href="#">手机平板</a></li>
            <li><a href="#">电脑装机</a></li>
            <li><a href="#">摄影摄像</a></li>
            <li><a href="#">影音智能</a></li>
          </ul>
        </div>

        <div id="life" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu9"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>生活</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu9">
            <li><a href="#">搞笑</a></li>
            <li><a href="#">日常</a></li>
            <li><a href="#">美食圈</a></li>
            <li><a href="#">动物圈</a></li>
            <li><a href="#">手工</a></li>
            <li><a href="#">绘画</a></li>
            <li><a href="#">运动</a></li>
            <li><a href="#">其他</a></li>
          </ul>
        </div>

        <div id="ghostanimal" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu10"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>鬼畜</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu10">
            <li><a href="#">鬼畜调教</a></li>
            <li><a href="#">音MAD</a></li>
            <li><a href="#">人力VOCALOID</a></li>
            <li><a href="#">教程演示</a></li>
          </ul>
        </div>

        <div id="fashion" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu11"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>时尚</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu11">
            <li><a href="#">美妆</a></li>
            <li><a href="#">服饰</a></li>
            <li><a href="#">健身</a></li>
            <li><a href="#">T台</a></li>
            <li><a href="#">风尚标</a></li>
          </ul>
        </div>

        <div id="ad" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu12"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>广告</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu12">
            <li><a href="#">待定</a></li>
          </ul>
        </div>

        <div id="entertainment" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu13"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>娱乐</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu13">
            <li><a href="#">综艺</a></li>
            <li><a href="#">明星</a></li>
            <li><a href="#">Korea相关</a></li>
          </ul>
        </div>

        <div id="movie" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu14"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div>影视</div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu14">
            <li><a href="#">影视杂谈</a></li>
            <li><a href="#">影视剪辑</a></li>
            <li><a href="#">短片</a></li>
            <li><a href="#">预告·资讯</a></li>
          </ul>
        </div>

        <div id="screening" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu15"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap" style="margin-left: 4px">
              <span>1</span>
            </div>
            <div>
              放映厅
            </div>
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenu15">
            <li><a href="#">纪录片</a></li>
            <li><a href="#">电影</a></li>
            <li><a href="#">电视剧</a></li>
          </ul>
        </div>

        <div id="column" class="dropdown dropdown-menu-myclass">
          <i class="columnImg"></i>
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button">
            <div>专栏</div>
          </button>
        </div>

        <div id="square" class="dropdown dropdown-menu-myclass">
          <i class="squareImg"></i>
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button">
            <div>广场</div>
          </button>
        </div>

        <div id="liveBroadcast" class="dropdown dropdown-menu-myclass">
          <i class="liveBroadcastImg"></i>
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button">
            <div>直播</div>
          </button>
        </div>

        <div id="blackHouse" class="dropdown dropdown-menu-myclass">
          <i class="blackHouseImg"></i>
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button">
            <div>小黑屋</div>
          </button>
        </div>

        <div class="gif-menu">
          <img src="../../../static/images/gif_menu1.gif">
        </div>

      </div>

      <div id="chief_recommend" class="chief_style">
        <div id="carousel-example-generic" class="carousel slide my_carousel" data-ride="carousel" data-interval="4000">
          <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
            <li data-target="#carousel-example-generic" data-slide-to="4"></li>
          </ol>

          <div class="carousel-inner" role="listbox">
            <div class="item active">
              <img src="../../../static/images/carousel1.jpg" alt="轮播1">
            </div>
            <div class="item">
              <img src="../../../static/images/carousel2.jpg" alt="轮播2">
            </div>
            <div class="item">
              <img src="../../../static/images/carousel3.jpg" alt="轮播3">
            </div>
            <div class="item">
              <img src="../../../static/images/carousel4.jpg" alt="轮播4">
            </div>
            <div class="item">
              <img src="../../../static/images/carousel5.jpg" alt="轮播5">
            </div>
          </div>

        </div>
      </div>

      <!--登录-->
      <div v-if="islogin && recommenderList.length !== 0" class="recommend_module">
        <div @click="toVideo(recommend.id)" class="recommend_card recommend_card_firstrow" v-for="(recommend,index) in recommenderList" :key="recommend.id" v-if="index<=3">
          <img class="recommend_card_img" :src="recommend.image_url" >
          <div class="card_mask"></div>
          <div class="font">
            <p class="title">{{recommend.title}}</p>
            <p class="author">up主: yudachi</p>
            <p v-if="recommend.play_num >= 10000" class="play">播放: {{(recommend.play_num / 10000).toFixed(1)}}万</p>
            <p v-else class="play">播放: {{recommend.play_num}}</p>
          </div>
          <p class="recommend_p">{{recommend.title}}</p>
        </div>
        <div @click="toVideo(recommend.id)" class="recommend_card recommend_card_secondrow" v-for="(recommend,index) in recommenderList" :key="recommend.id" v-if="index>3 && index <=7">
          <img class="recommend_card_img" :src="recommend.image_url">
          <div class="card_mask"></div>
          <div class="font">
            <p class="title">{{recommend.title}}</p>
            <p class="author">up主: yudachi</p>
            <p v-if="recommend.play_num >= 10000" class="play">播放: {{(recommend.play_num / 10000).toFixed(1)}}万</p>
            <p v-else class="play">播放: {{recommend.play_num}}</p>
          </div>
          <p class="recommend_p">{{recommend.title}}</p>
        </div>

        <span class="rec-btn prev">昨日</span>
        <span class="rec-btn next">一周</span>
      </div>
      <!-- 未登录或者刚注册的新用户 -->
      <div v-else class="recommend_module">
        <div @click="toVideo(recommend.id)" class="recommend_card recommend_card_firstrow" v-for="(recommend,index) in newUserRecommenderList" :key="recommend.id" v-if="index<=3">
          <img class="recommend_card_img" :src="recommend.image_url" >
          <div class="card_mask"></div>
          <div class="font">
            <p class="title">{{recommend.title}}</p>
            <p class="author">up主: yudachi</p>
            <p v-if="recommend.play_num >= 10000" class="play">播放: {{(recommend.play_num / 10000).toFixed(1)}}万</p>
            <p v-else class="play">播放: {{recommend.play_num}}</p>
          </div>
          <p class="recommend_p">{{recommend.title}}</p>
        </div>
        <div @click="toVideo(recommend.id)" class="recommend_card recommend_card_secondrow" v-for="(recommend,index) in newUserRecommenderList" :key="recommend.id" v-if="index>3 && index <=7">
          <img class="recommend_card_img" :src="recommend.image_url">
          <div class="card_mask"></div>
          <div class="font">
            <p class="title">{{recommend.title}}</p>
            <p class="author">up主: yudachi</p>
            <p v-if="recommend.play_num >= 10000" class="play">播放: {{(recommend.play_num / 10000).toFixed(1)}}万</p>
            <p v-else class="play">播放: {{recommend.play_num}}</p>
          </div>
          <p class="recommend_p">{{recommend.title}}</p>
        </div>

        <span class="rec-btn prev">昨日</span>
        <span class="rec-btn next">一周</span>
      </div>

      <!--推广模块-->
      <div class="promotion-wrapper">
        <div class="row">
          <div class="col-xs-10">
            <div class="promotion-icon">
              <i class="pi"></i>
              <span class="promotion-span">推广</span>
              <a class="promotion-a" href="#">网络举报知识竞赛</a>
              <div class="promotion-story">
                <div class="promotion-item">
                  <img class="promotion-img" src="../../../static/images/promotion_1.jpg">
                  <p class="promotion-p">人类的荣光与未来，全靠你这一指了！</p>
                </div>
                <div class="promotion-item">
                  <img class="promotion-img" src="../../../static/images/promotion_2.jpg">
                  <p class="promotion-p">【混剪/家庭】妈妈，你在想什么</p>
                </div>
                <div class="promotion-item">
                  <img class="promotion-img" src="../../../static/images/promotion_3.jpg">
                  <p class="promotion-p">和美少女亲密互动，不能少了这个技术！</p>
                </div>
                <div class="promotion-item">
                  <img class="promotion-img" src="../../../static/images/promotion_4.jpg">
                  <p class="promotion-p">【爱李】✿芒种✿全世界wuwuwu（原编中国风）</p>
                </div>
                <div class="promotion-item">
                  <img class="promotion-img" src="../../../static/images/promotion_5.jpg">
                  <p class="promotion-p">爆炸卡点！颜值实力都超帅的南韩舞团ASSA Crew齐舞作品The Game of Go</p>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xs-2">
            <div class="online-num">
              <a class="promotion-online-a" href="#">在线人数：4471879</a>
            </div>
            <div class="promotion-right">
              <img class="promotion-right-img" src="../../../static/images/promotion_right.jpg">
            </div>
          </div>
        </div>
      </div>

      <!--广告位-->
      <div class="ad-wrapper">
        <img class="ad-wrapper-img" src="../../../static/images/ad_1.jpg">
      </div>

      <!--直播模块-->
      <div class="living-wrapper">
        <div class="row">
          <div class="col-xs-10">
            <div>
              <i class="living-icon"></i>
              <a class="living-title">正在直播</a>
              <p class="living-num">当前共有<span>5124</span>个在线直播</p>
              <a class="living-subtitle">
                <i class="living-subtitle-icon"></i>
                233秒居然能做这些！
              </a>
            </div>
            <div class="living-new-status">
              <i class="living-new-status-refresh"></i>
              <span class="living-new-status-num"><b>2800</b>条新动态</span>
            </div>
            <a href="#" class="toMore">
              <span>更多</span>
              <i class="toMoreIcon"></i>
            </a>
            <div class="living-card-module-list">
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_1.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_1.jpg">
                  </div>
                  <p class="living-card-title">无声卡电脑坏掉的一天</p>
                  <p class="living-card-category">电台 · 唱见电台</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_2.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_2.jpg">
                  </div>
                  <p class="living-card-title">白袜折纸 五更琉璃 六花</p>
                  <p class="living-card-category">绘画 · 同人绘画</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_3.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_3.jpg">
                  </div>
                  <p class="living-card-title">恐怖游戏：女巫猎杀</p>
                  <p class="living-card-category">单机 · 其他单机</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_4.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_4.jpg">
                  </div>
                  <p class="living-card-title">玩无限火力咯</p>
                  <p class="living-card-category">网游 · 英雄联盟</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_5.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_5.jpg">
                  </div>
                  <p class="living-card-title">一些简单的技巧</p>
                  <p class="living-card-category">绘画 · 原创绘画</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_6.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_6.jpg">
                  </div>
                  <p class="living-card-title">测试直播</p>
                  <p class="living-card-category">娱乐 · 虚拟主播</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_7.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_7.jpg">
                  </div>
                  <p class="living-card-title">B站第一情感咨询</p>
                  <p class="living-card-category">电台 · 聊天电台</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_8.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_8.jpg">
                  </div>
                  <p class="living-card-title">木兰SOLO大赛</p>
                  <p class="living-card-category">手游 · 王者荣耀</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_9.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_9.jpg">
                  </div>
                  <p class="living-card-title">艰难的冲分</p>
                  <p class="living-card-category">网游 · lol云顶之弈</p>
                </a>
              </div>
              <div class="living-card-module">
                <a href="#">
                  <div class="living-card-img-div">
                    <img class="living-card-img" src="../../../static/images/living_img_10.jpg">
                  </div>
                  <div class="living-card-up-div">
                    <span class="living-card-up-auther">xxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
                    <span class="living-card-up-online">
                                    <i class="living-card-up-icon"></i>
                                    5.4万
                                </span>
                  </div>
                  <div class="living-card-mask-div">
                    <img class="living-card-mask" src="../../../static/images/living_img_mask_10.jpg">
                  </div>
                  <p class="living-card-title">贪婪之秋</p>
                  <p class="living-card-category">单机 · 其他单机</p>
                </a>
              </div>
            </div>
          </div>
          <div class="col-xs-2">
            <div class="living-right-head">
              <a class="living-right-head-a living-right-head-current">直播排行</a>
              <a class="living-right-head-a">关注的主播</a>
              <a class="living-right-head-a">为你推荐</a>
            </div>
            <div class="living-right-carousel">
              <div class="living-rank">
                <div class="living-rank-list">
                  <div class="living-rank-item">
                    <span class="living-rank-num">1</span>
                    <a class="living-rank-a">
                      <div class="living-rank-portrait">
                        <img src="../../../static/images/portrait_1.jpg">
                      </div>
                    </a>
                    <div class="living-rank-title-div">
                      <p class="living-rank-title">
                        <span class="living-rank-name">痒局长</span>
                        <span class="living-rank-onlinenum">
                                                    <i class="viewIcon"></i>
                                                    15.3万
                                                </span>
                      </p>
                    </div>
                    <div class="living-rank-brief">
                      恰把鸡
                    </div>
                  </div>
                  <div class="living-rank-item">
                    <span class="living-rank-num">2</span>
                    <a class="living-rank-a">
                      <div class="living-rank-portrait">
                        <img src="../../../static/images/portrait_2.jpg">
                      </div>
                    </a>
                    <div class="living-rank-title-div">
                      <p class="living-rank-title">
                        <span class="living-rank-name">EdmundDZhang</span>
                        <span class="living-rank-onlinenum">
                                                    <i class="viewIcon"></i>
                                                    14.2万
                                                </span>
                      </p>
                    </div>
                    <div class="living-rank-brief">
                      阿鹅爱好者
                    </div>
                  </div>
                  <div class="living-rank-item">
                    <span class="living-rank-num">3</span>
                    <a class="living-rank-a">
                      <div class="living-rank-portrait">
                        <img src="../../../static/images/portrait_3.jpg">
                      </div>
                    </a>
                    <div class="living-rank-title-div">
                      <p class="living-rank-title">
                        <span class="living-rank-name">叶落莫言</span>
                        <span class="living-rank-onlinenum">
                                                    <i class="viewIcon"></i>
                                                    12.4万
                                                </span>
                      </p>
                    </div>
                    <div class="living-rank-brief">
                      又是快乐上分的一天！
                    </div>
                  </div>
                  <div class="living-rank-item">
                    <span class="living-rank-num">4</span>
                    <a class="living-rank-a">
                      <div class="living-rank-portrait">
                        <img src="../../../static/images/portrait_4.jpg">
                      </div>
                    </a>
                    <div class="living-rank-title-div">
                      <p class="living-rank-title">
                        <span class="living-rank-name">小霖QL</span>
                        <span class="living-rank-onlinenum">
                                                    <i class="viewIcon"></i>
                                                    9.3万
                                                </span>
                      </p>
                    </div>
                    <div class="living-rank-brief">
                      有亿点点甜QVQ
                    </div>
                  </div>
                  <div class="living-rank-item">
                    <span class="living-rank-num">5</span>
                    <a class="living-rank-a">
                      <div class="living-rank-portrait">
                        <img src="../../../static/images/portrait_5.jpg">
                      </div>
                    </a>
                    <div class="living-rank-title-div">
                      <p class="living-rank-title">
                        <span class="living-rank-name">睡神不醒丶</span>
                        <span class="living-rank-onlinenum">
                                                    <i class="viewIcon"></i>
                                                    7.7万
                                                </span>
                      </p>
                    </div>
                    <div class="living-rank-brief">
                      已上百星，冲第二个百星。
                    </div>
                  </div>
                  <div class="living-rank-item">
                    <span class="living-rank-num">6</span>
                    <a class="living-rank-a">
                      <div class="living-rank-portrait">
                        <img src="../../../static/images/portrait_6.jpg">
                      </div>
                    </a>
                    <div class="living-rank-title-div">
                      <p class="living-rank-title">
                        <span class="living-rank-name">梦醒三生梦</span>
                        <span class="living-rank-onlinenum">
                                                    <i class="viewIcon"></i>
                                                    7.7万
                                                </span>
                      </p>
                    </div>
                    <div class="living-rank-brief">
                      心态最差赵二狗
                    </div>
                  </div>
                </div>
              </div>
              <div class="living-focus-up">
                <div class="living-focus-up-list">
                  <div class="living-focus-up-item">
                    <a class="living-focus-up-a">
                      <div class="living-focus-up-portrait">
                        <img src="../../../static/images/focus_up_1.jpg">
                      </div>
                    </a>
                    <div class="living-focus-up-title-div">
                      <p class="living-focus-up-title">
                        <span class="living-focus-up-name">呛辣甜心</span>
                        <span class="living-focus-up-onlinenum">
                                                    <i class="focusIcon"></i>
                                                    3013
                                                </span>
                      </p>
                    </div>
                    <div class="living-focus-up-brief">
                      36岁老阿姨来送温暖
                    </div>
                  </div>
                  <div class="living-focus-up-item">
                    <a class="living-focus-up-a">
                      <div class="living-focus-up-portrait">
                        <img src="../../../static/images/focus_up_2.jpg">
                      </div>
                    </a>
                    <div class="living-focus-up-title-div">
                      <p class="living-focus-up-title">
                        <span class="living-focus-up-name">决战平安京官方</span>
                        <span class="living-focus-up-onlinenum">
                                                    <i class="focusIcon"></i>
                                                    3517
                                                </span>
                      </p>
                    </div>
                    <div class="living-focus-up-brief">
                      2019决战平安京OPL秋季赛
                    </div>
                  </div>
                </div>
              </div>
              <div class="living-recommend">
                <div id="carousel-example-generic-1" class="carousel slide" data-ride="carousel">
                  <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic-1" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic-1" data-slide-to="1"></li>
                  </ol>
                  <div class="carousel-inner" role="listbox">
                    <div class="item active">
                      <img src="../../../static/images/living_recommend_carousel_1.jpg" alt="...">
                      <div class="living-recommend-mask"></div>
                      <div class="living-recommend-mask-content">中秋佳月~大家一起开心过中秋！</div>
                    </div>
                    <div class="item">
                      <img src="../../../static/images/living_recommend_carousel_2.jpg" alt="...">
                      <div class="living-recommend-mask"></div>
                      <div class="living-recommend-mask-content">
                        《猫和老鼠》欢乐主播团招募盛夏启动
                      </div>
                    </div>
                  </div>
                </div>
                <div class="living-album-video">
                  <img src="../../../static/images/wh.png" class="living-album">
                  <img src="../../../static/images/sp.png" class="living-video">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--动画模块-->
      <div class="douga-wrapper">
        <div class="row">
          <div class="col-xs-10">
            <div>
              <i class="douga-icon"></i>
              <a href="#" class="douga-title">动画</a>
              <div class="douga-head-item douga-new-status douga-on">有新动态</div>
              <div class="douga-head-item douga-new-publication">最新投稿</div>
              <div class="douga-head-right">
                <div class="douga-new-status-num">
                  <i class="douga-refresh-icon"></i>
                  <span><b>35026</b>条新动态</span>
                </div>
                <div class="douga-more">
                  <span>更多</span>
                  <i class="toDougaMore"></i>
                </div>
              </div>
            </div>
            <div class="douga-content">
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_1.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">03:58</p>
                  <p class="douga-item-title">你能推倒女主选出正确结局吗？【万字互动视频】</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        42.4万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        2.0万
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_2.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">04:36</p>
                  <p class="douga-item-title">【国产基番】灵契mv 带我走（前世今生.微虐微甜HE）</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        4.8万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        129
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_3.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">07:08</p>
                  <p class="douga-item-title">漫画《鬼刀》宣传视频 英文版</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        272.0万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        2.7万
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_4.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">03:45</p>
                  <p class="douga-item-title">【大碗宽面X魔童哪吒】当哪吒的rap配上曲</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        66.9万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        3336
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_5.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">00:45</p>
                  <p class="douga-item-title">我的病毒女友</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        2311
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        9
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_6.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">04:38</p>
                  <p class="douga-item-title">对不起，我来晚了</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        1.4万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        30
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_7.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">18:07</p>
                  <p class="douga-item-title">【毒漫谈】东方Project是什么？</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        54.8万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        1.7万
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_8.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">03:00</p>
                  <p class="douga-item-title">【怪盗基德/黑羽快斗】【燃向】PLAY WITH FIRE（*微快新快）</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        15.1万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        818
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_9.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">02:27</p>
                  <p class="douga-item-title">注入灵魂!当DNF像素头表情包开口说话……!?</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        24.5万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        345
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="douga-content-item">
                <a href="#" class="douga-content-item-a">
                  <div class="douga-content-item-pic">
                    <img src="../../../static/images/douga_item_10.jpg">
                  </div>
                  <div class="douga-mask"></div>
                  <p class="douga-mask-time">05:02</p>
                  <p class="douga-item-title">【罗小黑战记】罗小黑来了哦~！【手书】</p>
                  <div class="douga-item-playinfo-div">
                    <p class="douga-item-playinfo">
                                    <span class="douga-item-play">
                                        <i class="play-icon"></i>
                                        18.3万
                                    </span>
                      <span class="douga-item-danmu">
                                        <i class="danmu-icon"></i>
                                        1261
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
            </div>
          </div>
          <div class="col-xs-2">
            <div class="douga-rank-head">
              <span class="douga-rank-head-title">排行</span>
              <span class="douga-rank-head-item douga-rank-head-item-on douga-rank-all">全部</span>
              <span class="douga-rank-head-item douga-rank-original">原创</span>
              <span class="douga-rank-dateconstraint">
                            三日
                            <i class="douga-date-icon"></i>
                        </span>
            </div>
            <div class="douga-rank-contents">
              <div class="douga-rank-content">
                <ul class="douga-rank-content-list">
                  <li class="douga-rank-content-item-main">
                    <span class="douga-rank-num douga-rank-top3">1</span>
                    <a>
                      <div class="douga-rank-img">
                        <img src="../../../static/images/douga_rank_img_1.jpg">
                      </div>
                      <div class="douga-rank-item-title">
                        <p>你能推倒女主选出正确结局吗？【万字互动视频】</p>
                      </div>
                      <div class="douga-rank-item-score">
                        <p>综合评分：103.9万</p>
                      </div>
                    </a>
                  </li>
                  <li class="douga-rank-content-item ">
                    <span class="douga-rank-num douga-rank-top3">2</span>
                    <p class="douga-rank-normal-p">沃兹：说好不哭，但没说好不变身！</p>
                  </li>
                  <li class="douga-rank-content-item ">
                    <span class="douga-rank-num douga-rank-top3">3</span>
                    <p class="douga-rank-normal-p">请问up，男主是个和尚却能和漂亮妹子谈恋爱是啥番？【阅片无数14】</p>
                  </li>
                  <li class="douga-rank-content-item">
                    <span class="douga-rank-num">4</span>
                    <p class="douga-rank-normal-p">明日方舟</p>
                  </li>
                  <li class="douga-rank-content-item">
                    <span class="douga-rank-num">5</span>
                    <p class="douga-rank-normal-p">【多吒向】那什么的哪吒们</p>
                  </li>
                  <li class="douga-rank-content-item">
                    <span class="douga-rank-num">6</span>
                    <p class="douga-rank-normal-p">《说好不哭》君臣限定版</p>
                  </li>
                  <li class="douga-rank-content-item">
                    <span class="douga-rank-num">7</span>
                    <p class="douga-rank-normal-p">周杰伦新MV 【说好不变身】 假面骑士Zio&nbsp;&nbsp;&nbsp;&nbsp;Woz渡边圭祐友情出演</p>
                  </li>
                  <span class="douga-rank-tomore">
                                查看更多
                                <i class="douga-rank-tomore-icon"></i>
                            </span>
                </ul>
              </div>
              <div class="douga-rank-content">
                <ul class="douga-rank-content-list">
                  <li class="douga-rank-content-item-main">
                    <span class="douga-rank-num douga-rank-top3">1</span>
                    <a>
                      <div class="douga-rank-img">
                        <img src="../../../static/images/douga_rank_img_1.jpg">
                      </div>
                      <div class="douga-rank-item-title">
                        <p>你能推倒女主选出正确结局吗？【万字互动视频】</p>
                      </div>
                      <div class="douga-rank-item-score">
                        <p>综合评分：103.9万</p>
                      </div>
                    </a>
                  </li>
                  <li class="douga-rank-content-item ">
                    <span class="douga-rank-num douga-rank-top3">2</span>
                    <p class="douga-rank-normal-p">沃兹：说好不哭，但没说好不变身！</p>
                  </li>
                  <li class="douga-rank-content-item ">
                    <span class="douga-rank-num douga-rank-top3">3</span>
                    <p class="douga-rank-normal-p">请问up，男主是个和尚却能和漂亮妹子谈恋爱是啥番？【阅片无数14】</p>
                  </li>
                  <li class="douga-rank-content-item">
                    <span class="douga-rank-num">4</span>
                    <p class="douga-rank-normal-p">明日方舟</p>
                  </li>
                  <li class="douga-rank-content-item">
                    <span class="douga-rank-num">5</span>
                    <p class="douga-rank-normal-p">【多吒向】那什么的哪吒们</p>
                  </li>
                  <!-- <li class="douga-rank-content-item">
                       <span class="douga-rank-num">6</span>
                       <p class="douga-rank-normal-p">《说好不哭》君臣限定版</p>
                   </li>
                   <li class="douga-rank-content-item">
                       <span class="douga-rank-num">7</span>
                       <p class="douga-rank-normal-p">周杰伦新MV 【说好不变身】 假面骑士Zio&nbsp;&nbsp;&nbsp;&nbsp;Woz渡边圭祐友情出演</p>
                   </li>-->
                  <span class="douga-rank-tomore">
                                查看更多
                                <i class="douga-rank-tomore-icon"></i>
                            </span>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--番剧模块-->
      <div class="bangumi-wrapper">
        <div class="row bangumi-content">
          <div class="col-xs-9">
            <i class="bangumi-icon"></i>
            <a href="#" class="bangumi-link">番剧</a>
            <div class="bangumi-tab-item-list">
              <div class="bangumi-new on">最新</div>
              <div class="bangumi-tab-item">一</div>
              <div class="bangumi-tab-item">二</div>
              <div class="bangumi-tab-item">三</div>
              <div class="bangumi-tab-item">四</div>
              <div class="bangumi-tab-item">五</div>
              <div class="bangumi-tab-item">六</div>
              <div class="bangumi-tab-item">日</div>
            </div>
            <div class="bangumi-new-time">
              <a href="#">新番时间表</a>
              <i class="toNew"></i>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_1.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss26878/">暖暖日记
                  4th</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep269849/">第24话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_2.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss28022/">騷亂時節的少女們。（僅限台灣地區）</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276942/">第11话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_3.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss26766/">水果篮子
                  (2019)</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep267785/">第24话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_4.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow text-overflow"
                   href="https://www.bilibili.com/bangumi/play/ss26960/">生肖奇缘 (2019)（僅限港澳地區）</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep268083/">第24话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_5.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow"
                   href="https://www.bilibili.com/bangumi/play/ss27959/">炎炎消防队</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276381/">第10话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_7.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss27999/">在地下城寻求邂逅是否搞错了什么
                  第二季</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276646/">第10话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_8.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss28002/">某科学的一方通行</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276484/">第10话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_11.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss27993/">Ｄｒ．ＳＴＯＮＥ
                  石纪元</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276783/">第11话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_12.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss28016/">女高中生的虚度日常</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276690/">第11话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_14.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow"
                   href="https://www.bilibili.com/bangumi/play/ss28007/">街角魔族</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep276369/">第10话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_15.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss28008/">GIVEN
                  被贈與的未來（僅限台灣地區）</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep277964/">第10话</a>
                </p>
              </div>
            </div>
            <div class="bangumi-card">
              <a class="bangumi-card-link">
                <div>
                  <img class="bangumi-card-link-img" src="../../../static/images/bangumi_10.jpg">
                </div>
              </a>
              <div>
                <a class="bangumi-card-title text-overflow" href="https://www.bilibili.com/bangumi/play/ss28003/">普通攻擊是全體二連擊，這樣的媽媽你喜歡嗎？（僅限台灣地區）</a>
                <p class="bangumi-card-update">
                  <a class="bangumi-card-newest" href="https://www.bilibili.com/bangumi/play/ep277977/">第10话</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-xs-3">
            <div class="rank_head">
              <h3 class="rank_h3">排行</h3>
              <div class="date_constraint">
                <span>三日</span>
                <i class="toDate"></i>
              </div>
            </div>
            <ul class="rank_list">
              <li class="rank_item">
                <i class="rank_num rank_top3">1</i>
                <p class="rank_title">鬼灭之刃</p>
                <span class="rank_total">更新至第23话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num rank_top3">2</i>
                <p class="rank_title">黑色四叶草</p>
                <span class="rank_total">更新至第100话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num rank_top3">3</i>
                <p class="rank_title">女高中生的虚度日常</p>
                <span class="rank_total">更新至第11话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">4</i>
                <p class="rank_title">重来吧，魔王大人！</p>
                <span class="rank_total">更新至第11话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">5</i>
                <p class="rank_title">擅长捉弄的高木同学 第二季</p>
                <span class="rank_total">更新至第10话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">6</i>
                <p class="rank_title">平凡职业造就世界最强</p>
                <span class="rank_total">更新至第9话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">7</i>
                <p class="rank_title">流汗吧！健身少女</p>
                <span class="rank_total">更新至第11话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">8</i>
                <p class="rank_title">Ｄｒ．ＳＴＯＮＥ 石纪元</p>
                <span class="rank_total">更新至第11话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">9</i>
                <p class="rank_title">CAROLE & TUESDAY</p>
                <span class="rank_total">更新至第21话</span>
              </li>
              <li class="rank_item">
                <i class="rank_num">10</i>
                <p class="rank_title">街角魔族</p>
                <span class="rank_total">更新至第10话</span>
              </li>
            </ul>
            <a href="#" class="toRankMore">
              查看更多
              <i class="toRankMoreIcon"></i>
            </a>
          </div>
        </div>
      </div>

      <div class="bili-foot">
        <div class="footer-wrap">
          <div class="foot-div-1">
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
          <div class="foot-div-2">
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
          <div class="row foot-div-3">
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
                <i class="sprite bg2"></i><a
                href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31011002002436" target="_blank">沪公网安备31011002002436号</a>
                |
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
  </div>
</template>

<script>
import $ from 'jquery'
let Base64 = require('js-base64').Base64
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {
      user: {
        id: '',
        phone: '',
        email: '',
        create_time: '',
        head_img: '',
        username: '',
        region: ''
      },
      keyword: '',
      recommenderList: [],
      newUserRecommenderList: [],
      islogin: false
    }
  },

  // 监听器
  watch: {
    recommenderList: function () {
      this.$nextTick(function () {
        $('.recommend_card').hover(
          function () {
            $(this).find('.card_mask').css({
              'visibility': 'visible',
              'top': '-100px'
            })
            $(this).find('.recommend_p').css('visibility', 'hidden')
            $(this).find('.font').css('visibility', 'visible')
            $(this).find('.title').css({
              'overflow': 'hidden',
              'text-overflow': 'ellipsis',
              'display': '-webkit-box',
              '-webkit-line-clamp': '1',
              '-webkit-box-orient': 'vertical'
            })
          },
          function () {
            $(this).find('.card_mask').css({
              'visibility': 'hidden',
              'top': '0px'
            })
            $(this).find('.recommend_p').css('visibility', 'visible')
            $(this).find('.font').css('visibility', 'hidden')
            $(this).find('.title').css({
              'overflow': 'hidden',
              'text-overflow': 'ellipsis',
              'display': '-webkit-box',
              '-webkit-line-clamp': '1',
              '-webkit-box-orient': 'vertical'
            })
          }
        )

        $('.recommend_module').hover(
          function () {
            $('.rec-btn').css(
              {
                'opacity': '1',
                'transition': 'all .2s'
              }
            )
          },
          function () {
            $('.rec-btn').css(
              {
                'opacity': '0',
                'transition': 'all .2s'
              }
            )
          }
        )
      })
    },
    newUserRecommenderList: function () {
      this.$nextTick(function () {
        $('.recommend_card').hover(
          function () {
            $(this).find('.card_mask').css({
              'visibility': 'visible',
              'top': '-100px'
            })
            $(this).find('.recommend_p').css('visibility', 'hidden')
            $(this).find('.font').css('visibility', 'visible')
            $(this).find('.title').css({
              'overflow': 'hidden',
              'text-overflow': 'ellipsis',
              'display': '-webkit-box',
              '-webkit-line-clamp': '1',
              '-webkit-box-orient': 'vertical'
            })
          },
          function () {
            $(this).find('.card_mask').css({
              'visibility': 'hidden',
              'top': '0px'
            })
            $(this).find('.recommend_p').css('visibility', 'visible')
            $(this).find('.font').css('visibility', 'hidden')
            $(this).find('.title').css({
              'overflow': 'hidden',
              'text-overflow': 'ellipsis',
              'display': '-webkit-box',
              '-webkit-line-clamp': '1',
              '-webkit-box-orient': 'vertical'
            })
          }
        )

        $('.recommend_module').hover(
          function () {
            $('.rec-btn').css(
              {
                'opacity': '1',
                'transition': 'all .2s'
              }
            )
          },
          function () {
            $('.rec-btn').css(
              {
                'opacity': '0',
                'transition': 'all .2s'
              }
            )
          }
        )
      })
    }
  },

  created () {
    if (localStorage.getItem('uid') != null) {
      this.islogin = true
      this.getUserInfo()
      this.initRecommender()
    } else {
      this.initNewUserRecommender()
    }
  },

  methods: {
    initNewUserRecommender () {
      this.$axios({
        method: 'get',
        url: 'http://localhost:9006/log/initNewUserRecommender'
      }).then(response => {
        if (response.data.success) {
          this.newUserRecommenderList = response.data.data
          for (let i = 0; i < this.newUserRecommenderList.length; i++) {
            if (this.newUserRecommenderList[i].image_url == null) {
              this.newUserRecommenderList[i].image_url = '../../../static/images/recommend_card' + (i + 1) + '.jpg'
            }
          }
        }
      })
    },
    initRecommender () {
      this.$axios({
        method: 'get',
        params: {
          uid: localStorage.getItem('uid')
        },
        url: 'http://localhost:9006/log/initRecommender'
      }).then(response => {
        console.log(response)
        if (response.data.success) {
          this.recommenderList = response.data.data
          if (this.recommenderList.length !== 0) {
            for (let i = 0; i < this.recommenderList.length; i++) {
              if (this.recommenderList[i].image_url == null) {
                this.recommenderList[i].image_url = '../../../static/images/recommend_card' + (i + 1) + '.jpg'
              }
            }
          } else {
            this.initNewUserRecommender()
          }
        }
      })
    },
    getUserInfo () {
      this.$axios({
        method: 'get',
        params: {
          userId: localStorage.getItem('uid')
        },
        url: 'http://localhost:9000/user/getUserInfo'
      }).then(response => {
        if (response.data.success) {
          this.user = response.data.data
          this.user.id = localStorage.getItem('uid')
        }
      })
    },
    toSpace () {
      window.location.href = '/space.html'
    },
    toLogin () {
      window.location.href = '/login.html'
    },
    toUGC () {
      window.location.href = 'http://localhost:8081?spm=' + Base64.encode(localStorage.getItem('uid'))
    },
    submitSearch () {
      console.log((this.keyword))
      window.open('http://localhost:8080/search.html?keyword=' + Base64.encode(this.keyword))
    },
    logout () {
      this.$confirm('是否退出登录?', '退出', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'info'
      }).then(() => {
        localStorage.clear()
        location.reload()
      })
    },
    toVideo (val) {
      if (!this.islogin) {
        this.$message.error('请先登录')
      } else {
        window.open('http://localhost:3000/video/' + val + '?spm=' + Base64.encode(localStorage.getItem('uid')))
      }
    }
  }
}
</script>

<style scoped>
  @import "../../../static/css/bootstrap.min.css";
  @import "../../../static/css/bilibili.css";
</style>
