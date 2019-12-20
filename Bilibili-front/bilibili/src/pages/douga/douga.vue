<template>
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
              <li class="nav-mask-ul-last-li"><a class="nav-mask-a" href="#" title="下载APP"><i class="appImg"></i>下载APP</a></li>
            </ul>
          </div>
          <div class="col-xs-4 nav-mask-height dismiss">
            <ul class="nav-mask-user-ul">
              <li>
                <a class="nav-mask-a" href="#">
                  <!--未登录-->
                  <div class="logOutDiv">
                    <img class="userImg" src="../../../static/images/akari.jpg">
                  </div>
                </a>
              </li>
              <li><a href="#" class="nav-mask-a">动态</a></li>
              <li><a href="#" class="nav-mask-a">历史</a></li>
              <div class="contributions"><a href="#" class="nav-mask-a u-link">投稿</a></div>
            </ul>
          </div>
          <div class="col-xs-1 nav-mask-height"></div>
          <!--<div style="width: 100%;height: 1000px"></div>-->
        </div>
        <div class="nav-head"></div>
        <div class="nav-band"></div>
        <div class="nav-search searchDisMiss">
          <a href="#" class="link-ranking link-ranking-bg">排行榜</a>
          <form class="searchform">
            <input type="text" placeholder="微波炉也能做烧烤？？？" class="search-keyword link-ranking-bg">
            <button type="submit" class="search-submit"></button>
          </form>
        </div>
      </div>
      <div class="bili-wrapper" style="border-bottom: 1px solid #e5e9ef;" >

        <div id="index" class="dropdown dropdown-menu-myclass">
          <i class="indexImg"></i>
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button">
            <div>首页</div>
          </button>
        </div>

        <div id="animation" class="dropdown dropdown-menu-myclass">
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <div class="num-wrap">
              <span>1</span>
            </div>
            <div class="douga-title">动画</div>
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu6" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu7" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu8" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu9" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu10" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu11" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu12" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu13" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu14" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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
          <button class="btn btn-default dropdown-toggle dropdown-menu-button" type="button" id="dropdownMenu15" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
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

      <!--分类-->
      <div class="douga-catogory-wrapper">
        <ul>
          <li><a href="#" class="on">全部</a></li>
          <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="具有一定制作程度的动画或静画的二次元创作视频">MAD·AMV</a></li>
          <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="使用MMD(MikuMikuDance)和其他3D建模类软件制作的视频">MMD·3D</a></li>
          <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="追求创新并具有强烈特色的短片、手书(绘)及ACG相关配音">短片·手书·配音</a></li>
          <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="特摄相关衍生视频">特摄</a></li>
          <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="以动画及动画相关内容为素材，包括但不仅限于音频替换、杂谈、排行榜等内容">综合</a></li>
        </ul>
      </div>

      <!--轮播+推荐-->
      <div class="douga-carousel-wrapper">
        <div class="row">
          <div class="col-xs-9 douga-carousel" >
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
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
                  <img src="../../../static/images/douga_carousel_1.jpg" alt="...">
                </div>
                <div class="item">
                  <img src="../../../static/images/douga_carousel_2.jpg" alt="...">
                </div>
                <div class="item">
                  <img src="../../../static/images/douga_carousel_3.jpg" alt="...">
                </div>
                <div class="item">
                  <img src="../../../static/images/douga_carousel_4.jpg" alt="...">
                </div>
                <div class="item">
                  <img src="../../../static/images/douga_carousel_5.jpg" alt="...">
                </div>
              </div>
            </div>
          </div>
          <div class="col-xs-3">
            <div class="douga-carousel-recommend">
              <div class="douga-recommend-item">
                <a href="#" >
                  <div>
                    <img src="../../../static/images/douga_recommend_1.jpg">
                  </div>
                </a>
                <div class="douga-item-hover">
                  <div class="douga-item-mask"></div>
                  <div class="douga-item-content">
                    <p class="title">【迪迪】柯南中的悲剧角色松田阵平，一千集出场只有几十分钟，却征服所有柯南迷</p>
                    <p class="author">up主：我叫萌迪迪</p>
                    <p class="play">播放：5.2万</p>
                    <i class="douga-later-icon"></i>
                  </div>
                </div>
              </div>
              <div class="douga-recommend-item">
                <a href="#" >
                  <div>
                    <img src="../../../static/images/douga_recommend_2.jpg">
                  </div>
                </a>
                <div class="douga-item-hover">
                  <div class="douga-item-mask"></div>
                  <div class="douga-item-content">
                    <p class="title">VRFM in 虚拟上海 - 今晚一起吃烤串吧！</p>
                    <p class="author">up主：VirtuaReal</p>
                    <p class="play">播放：1.9万</p>
                    <i class="douga-later-icon"></i>
                  </div>
                </div>
              </div>
              <div class="douga-recommend-item">
                <a href="#" >
                  <div>
                    <img src="../../../static/images/douga_recommend_3.jpg">
                  </div>
                </a>
                <div class="douga-item-hover">
                  <div class="douga-item-mask"></div>
                  <div class="douga-item-content">
                    <p class="title">【氰化欢乐秀第四季】海盗船长和屁屁鲨的传奇 @一只出格君</p>
                    <p class="author">up主：出格字幕组</p>
                    <p class="play">播放：13.0万</p>
                    <i class="douga-later-icon"></i>
                  </div>
                </div>
              </div>
              <div class="douga-recommend-item">
                <a href="#" >
                  <div>
                    <img src="../../../static/images/douga_recommend_4.jpg">
                  </div>
                </a>
                <div class="douga-item-hover">
                  <div class="douga-item-mask"></div>
                  <div class="douga-item-content">
                    <p class="title">当鬼灭之刃名场面变成了四川话配音，善逸简直骚到没边了！【鬼灭之刃】沙雕之刃</p>
                    <p class="author">up主：嘤嘤怪晓晓川</p>
                    <p class="play">播放：4.3万</p>
                    <i class="douga-later-icon"></i>
                  </div>
                </div>
              </div>
              <div class="douga-recommend-item">
                <a href="#" >
                  <div>
                    <img src="../../../static/images/douga_recommend_5.jpg">
                  </div>
                </a>
                <div class="douga-item-hover">
                  <div class="douga-item-mask"></div>
                  <div class="douga-item-content">
                    <p class="title">我有姿势我自豪，超威黑羽喵来啦</p>
                    <p class="author">up主：逆流茶会-澪</p>
                    <p class="play">播放：6120</p>
                    <i class="douga-later-icon"></i>
                  </div>
                </div>
              </div>
              <div class="douga-recommend-item">
                <a href="#" >
                  <div>
                    <img src="../../../static/images/douga_recommend_6.jpg">
                  </div>
                </a>
                <div class="douga-item-hover">
                  <div class="douga-item-mask"></div>
                  <div class="douga-item-content">
                    <p class="title">【鬼灭之刃/最後の呼吸】水天翻卷，流刃若火，刀光剑影，雷霆万钧.</p>
                    <p class="author">up主：Gin丶濑良</p>
                    <p class="play">播放：8.6万</p>
                    <i class="douga-later-icon"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--前方高能-->
      <div class="douga-highEnergy-wrapper">
        <div class="row">
          <div class="col-xs-10">
            <span class="douga-highEnergy-title">前方高能</span>
            <div class="douga-highEnergy">
              <div class="douga-highEnergy-item">
                <a href="#">
                  <div>
                    <img src="../../../static/images/douga_highEnergy_1.jpg">
                  </div>
                  <p title="【动画透镜07】《冰海战记》上：如何创作一部历史漫画作品？">【动画透镜07】《冰海战记》上：如何创作一部历史漫画作品？</p>
                </a>
                <div class="douga-highEnergy-item-hover">
                  <div class="douga-highEnergy-mask"></div>
                  <i class="douga-highEnergy-icon"></i>
                </div>
              </div>
              <div class="douga-highEnergy-item">
                <a href="#">
                  <div>
                    <img src="../../../static/images/douga_highEnergy_2.jpg">
                  </div>
                  <p title="[TOS2019/四谎]追光者">[TOS2019/四谎]追光者</p>
                </a>
                <div class="douga-highEnergy-item-hover">
                  <div class="douga-highEnergy-mask"></div>
                  <i class="douga-highEnergy-icon"></i>
                </div>
              </div>
              <div class="douga-highEnergy-item">
                <a href="#">
                  <div>
                    <img src="../../../static/images/douga_highEnergy_3.jpg">
                  </div>
                  <p title="[TOS2019/战争/PTSD] Kroner_ParaBellum">[TOS2019/战争/PTSD] Kroner_ParaBellum</p>
                </a>
                <div class="douga-highEnergy-item-hover">
                  <div class="douga-highEnergy-mask"></div>
                  <i class="douga-highEnergy-icon"></i>
                </div>
              </div>
              <div class="douga-highEnergy-item">
                <a href="#">
                  <div>
                    <img src="../../../static/images/douga_highEnergy_4.jpg">
                  </div>
                  <p title="周刊哔哩哔哩排行榜#483">周刊哔哩哔哩排行榜#483</p>
                </a>
                <div class="douga-highEnergy-item-hover">
                  <div class="douga-highEnergy-mask"></div>
                  <i class="douga-highEnergy-icon"></i>
                </div>
              </div>
              <div class="douga-highEnergy-item">
                <a href="#">
                  <div>
                    <img src="../../../static/images/douga_highEnergy_5.jpg">
                  </div>
                  <p title="【多吒向】那什么的哪吒们">【多吒向】那什么的哪吒们</p>
                </a>
                <div class="douga-highEnergy-item-hover">
                  <div class="douga-highEnergy-mask"></div>
                  <i class="douga-highEnergy-icon"></i>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xs-2">
            <span class="douga-highEnergy-right-title">近期热门</span>
            <div class="douga-hot">
              <ul>
                <li class="douga-hot-top-li" title="【动画透镜07】《冰海战记》上：如何创作一部历史漫画作品？">
                  <img src="../../../static/images/douga_highEnergy_right_1.jpg">
                  <i class="douga-hot-top-icon"></i>
                  <p class="top">【动画透镜07】《冰海战记》上：如何创作一部历史漫画作品？</p>
                </li>
                <li title="【合作动画】靴の花火">
                  <p>【合作动画】靴の花火</p>
                </li>
                <li title="【动作配布】【兰若MMD】How long">
                  <p>【动作配布】【兰若MMD】How long</p>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>

      <!--广告位1-->
      <div class="douga-ad-wrapper">
        <img src="../../../static/images/douga_ad_1.png">
      </div>

      <!--MAD·AMV模块-->
      <div class="MADAMV-wrapper">
        <div class="row">
          <div class="col-xs-10">
            <div class="MADAMV-wrapper-head">
              <a href="#" class="MADAMV-title">MAD·AMV</a>
              <div class="MADAMV-head-item MADAMV-new-status MADAMV-on">有新动态</div>
              <div class="MADAMV-head-item MADAMV-new-publication">最新投稿</div>
              <div class="MADAMV-head-right">
                <div class="MADAMV-new-status-num">
                  <i class="MADAMV-refresh-icon"></i>
                  <span><b>797</b>条新动态</span>
                </div>
                <div class="MADAMV-more">
                  <span>更多</span>
                  <i class="toMADAMVMore"></i>
                </div>
              </div>
            </div>
            <div class="MADAMV-content">
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_1.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">01:04</p>
                  <p class="MADAMV-item-title">前方高萌 猛男暴力踩点  据说本视频无人能坚持45秒 看完之后你会……</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        1.0万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        33
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_2.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">03:23</p>
                  <p class="MADAMV-item-title">【致郁综漫】遥 不 可 及....</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        1.2万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        108
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_3.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">02:37</p>
                  <p class="MADAMV-item-title">【踩点/高燃】索隆：当我念诗的时候，你就应该逃了</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        13.4万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        327
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_4.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">07:12</p>
                  <p class="MADAMV-item-title">《魔法少女小圆》-巴麻美角色歌「未来&Credens justitiam」（完整版）</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        7396
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        35
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_5.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">05:40</p>
                  <p class="MADAMV-item-title">【虐心向/MAD】原来,你已经不在我身旁</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        133.0万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        1.8万
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_6.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">04:36</p>
                  <p class="MADAMV-item-title">【抑郁者】活下去、活下去、活下去、活下去吧！</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        37.0万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        3626
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_7.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">03:07</p>
                  <p class="MADAMV-item-title">她哭的那一刻，誓要与全世界为敌</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        2.8万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        114
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_8.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">03:38</p>
                  <p class="MADAMV-item-title">前方深呼吸 以100秒为目标 让子弹飞一会</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        22.0万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        718
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_9.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">02:39</p>
                  <p class="MADAMV-item-title">【爆笑/海贼王】3>  路飞专业坑索隆，总有一天会被劈了。。。</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        1.4万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        30
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_10.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">03:02</p>
                  <p class="MADAMV-item-title">【TOS2019/少女革命】勇敢的人</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        1.3万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        39
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_11.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">04:21</p>
                  <p class="MADAMV-item-title">【漫综/治愈】无论你身在何方，我只爱你一人</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        1.2万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        217
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_12.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">03:42</p>
                  <p class="MADAMV-item-title">【加藤惠】王妃 小惠生日快乐！！！献给我最喜欢的女主角，我的王妃——加藤惠</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        52
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        0
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_13.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">01:32</p>
                  <p class="MADAMV-item-title">【禾必|前方高能】黑执事踩点练习-Grind Me Down</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        4.1万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        108
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_14.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">01:06</p>
                  <p class="MADAMV-item-title">【天行九歌 | 一梦江湖】卫庄 x 方思明</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        1.5万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        140
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MADAMV-content-item">
                <a href="#" class="MADAMV-content-item-a">
                  <div class="MADAMV-content-item-pic">
                    <img src="../../../static/images/MADAMV_item_15.jpg">
                  </div>
                  <div class="MADAMV-mask"></div>
                  <p class="MADAMV-mask-time">03:22</p>
                  <p class="MADAMV-item-title">当我拔剑的那一刻，全世界都将为之颤抖！！！</p>
                  <div class="MADAMV-item-playinfo-div">
                    <p class="MADAMV-item-playinfo">
                                    <span class="MADAMV-item-play">
                                        <i class="play-icon"></i>
                                        575.8万
                                    </span>
                      <span class="MADAMV-item-danmu">
                                        <i class="danmu-icon"></i>
                                        2.2万
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
            </div>
          </div>
          <div class="col-xs-2">
            <div class="MADAMV-rank-head">
              <span class="MADAMV-rank-head-title">排行</span>
              <span class="MADAMV-rank-head-item MADAMV-rank-head-item-on MADAMV-rank-all">全部</span>
              <span class="MADAMV-rank-head-item MADAMV-rank-original">原创</span>
              <span class="MADAMV-rank-dateconstraint">
                            三日
                            <i class="MADAMV-date-icon"></i>
                        </span>
            </div>
            <div class="MADAMV-rank-contents">
              <div class="MADAMV-rank-content">
                <ul class="MADAMV-rank-content-list">
                  <li class="MADAMV-rank-content-item-main">
                    <span class="MADAMV-rank-num MADAMV-rank-top3">1</span>
                    <a>
                      <div class="MADAMV-rank-img">
                        <img src="../../../static/images/MADAMV_rank_img_1.jpg">
                      </div>
                      <div class="MADAMV-rank-item-title">
                        <p>每天一遍，沙雕无限！</p>
                      </div>
                      <div class="MADAMV-rank-item-score">
                        <p>综合评分：27.3万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MADAMV-rank-content-item-main">
                    <span class="MADAMV-rank-num MADAMV-rank-top3">2</span>
                    <a>
                      <div class="MADAMV-rank-img">
                        <img src="../../../static/images/MADAMV_rank_img_2.jpg">
                      </div>
                      <div class="MADAMV-rank-item-title">
                        <p>她哭的那一刻，誓要与全世界为敌</p>
                      </div>
                      <div class="MADAMV-rank-item-score">
                        <p>综合评分：3.7万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MADAMV-rank-content-item-main">
                    <span class="MADAMV-rank-num MADAMV-rank-top3">3</span>
                    <a>
                      <div class="MADAMV-rank-img">
                        <img src="../../../static/images/MADAMV_rank_img_3.jpg">
                      </div>
                      <div class="MADAMV-rank-item-title">
                        <p>【加藤惠/AMV/加藤惠诞生祭】让我患上名为「你」的忧郁症！</p>
                      </div>
                      <div class="MADAMV-rank-item-score">
                        <p>综合评分：3.1万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MADAMV-rank-content-item ">
                    <span class="MADAMV-rank-num" >4</span>
                    <p class="MADAMV-rank-normal-p">【快新】怪盗基德的千层套路</p>
                  </li>
                  <li class="MADAMV-rank-content-item ">
                    <span class="MADAMV-rank-num">5</span>
                    <p class="MADAMV-rank-normal-p">即使生活虐我千百遍，我依旧待生活如初恋！！</p>
                  </li>
                  <li class="MADAMV-rank-content-item">
                    <span class="MADAMV-rank-num">6</span>
                    <p class="MADAMV-rank-normal-p">感谢陪伴！回顾高木同学每集高甜。</p>
                  </li>
                  <li class="MADAMV-rank-content-item">
                    <span class="MADAMV-rank-num">7</span>
                    <p class="MADAMV-rank-normal-p">此刀一出，身首分离！感受来自鬼灭之刃的视觉盛宴吧！</p>
                  </li>
                  <li class="MADAMV-rank-content-item">
                    <span class="MADAMV-rank-num">8</span>
                    <p class="MADAMV-rank-normal-p">[刀剑神域】高燃 MAD AMV虽然是场游戏但也不是闹着玩的|此生无悔入刀剑</p>
                  </li>
                  <li class="MADAMV-rank-content-item">
                    <span class="MADAMV-rank-num">9</span>
                    <p class="MADAMV-rank-normal-p">据说没人敢点进来! 前方高燃又鬼畜!</p>
                  </li>
                  <li class="MADAMV-rank-content-item">
                    <span class="MADAMV-rank-num">10</span>
                    <p class="MADAMV-rank-normal-p">海贼王：路飞玫瑰金霸气首秀，见闻色成顶级，五皇就是这么可怕！！！</p>
                  </li>
                  <span class="MADAMV-rank-tomore">
                                查看更多
                                <i class="MADAMV-rank-tomore-icon"></i>
                            </span>
                </ul>
              </div>
              <div class="MADAMV-rank-content">
                <ul class="MADAMV-rank-content-list">
                  <li class="MADAMV-rank-content-item-main">
                    <span class="MADAMV-rank-num MADAMV-rank-top3">1</span>
                    <a>
                      <div class="MADAMV-rank-img">
                        <img src="../../../static/images/MADAMV_rank_img_1.jpg">
                      </div>
                      <div class="MADAMV-rank-item-title">
                        <p>每天一遍，沙雕无限！</p>
                      </div>
                      <div class="MADAMV-rank-item-score">
                        <p>综合评分：27.3万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MADAMV-rank-content-item-main">
                    <span class="MADAMV-rank-num MADAMV-rank-top3">2</span>
                    <a>
                      <div class="MADAMV-rank-img">
                        <img src="../../../static/images/MADAMV_rank_img_2.jpg">
                      </div>
                      <div class="MADAMV-rank-item-title">
                        <p>她哭的那一刻，誓要与全世界为敌</p>
                      </div>
                      <div class="MADAMV-rank-item-score">
                        <p>综合评分：3.7万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MADAMV-rank-content-item-main">
                    <span class="MADAMV-rank-num MADAMV-rank-top3">3</span>
                    <a>
                      <div class="MADAMV-rank-img">
                        <img src="../../../static/images/MADAMV_rank_img_3.jpg">
                      </div>
                      <div class="MADAMV-rank-item-title">
                        <p>【加藤惠/AMV/加藤惠诞生祭】让我患上名为「你」的忧郁症！</p>
                      </div>
                      <div class="MADAMV-rank-item-score">
                        <p>综合评分：3.1万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MADAMV-rank-content-item ">
                    <span class="MADAMV-rank-num" >4</span>
                    <p class="MADAMV-rank-normal-p">【快新】怪盗基德的千层套路</p>
                  </li>
                  <li class="MADAMV-rank-content-item ">
                    <span class="MADAMV-rank-num">5</span>
                    <p class="MADAMV-rank-normal-p">即使生活虐我千百遍，我依旧待生活如初恋！！</p>
                  </li>
                  <span class="MADAMV-rank-tomore">
                                查看更多
                                <i class="MADAMV-rank-tomore-icon"></i>
                            </span>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--MMD·3D模块-->
      <div class="MMD3D-wrapper">
        <div class="row">
          <div class="col-xs-10">
            <div class="MMD3D-wrapper-head">
              <a href="#" class="MMD3D-title">MMD·3D</a>
              <div class="MMD3D-head-item MMD3D-new-status MMD3D-on">有新动态</div>
              <div class="MMD3D-head-item MMD3D-new-publication">最新投稿</div>
              <div class="MMD3D-head-right">
                <div class="MMD3D-new-status-num">
                  <i class="MMD3D-refresh-icon"></i>
                  <span><b>2858</b>条新动态</span>
                </div>
                <div class="MMD3D-more">
                  <span>更多</span>
                  <i class="toMMD3DMore"></i>
                </div>
              </div>
            </div>
            <div class="MMD3D-content">
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_1.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">01:29</p>
                  <p class="MMD3D-item-title">「旗袍星尘/V+/MMD」一身霜  谁提笔只两行  换一隅你安康  便销得这沧桑</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        1.5万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        29
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_2.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">06:27</p>
                  <p class="MMD3D-item-title">【熟肉】【PUBG】用抽签决定使用武器？！【LVG】</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        3927
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        6
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_3.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">02:05</p>
                  <p class="MMD3D-item-title">【JOJO的奇妙MMD】承太郎：一直看着我【全屏推荐】</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        6.8万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        826
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_4.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">00:51</p>
                  <p class="MMD3D-item-title">【MMD】I'm a sucker for you-我是个为你着迷的傻瓜-『卡莲.原罪猎人』</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        2054
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        4
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_5.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">03:16</p>
                  <p class="MMD3D-item-title">【布料解算/写实渲染】超精美 - 华夏风韵❀洛水天依 - 云裳谣</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        2459
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        9
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_6.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">09:10</p>
                  <p class="MMD3D-item-title">【梓璃梦】人類みなセンパイ！【MV】</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        4.2万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        363
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_7.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">02:20</p>
                  <p class="MMD3D-item-title">【崩坏3MMD】丽塔：贱长，要抹防晒油吗              Red Velvet - RBB</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        21.0万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        794
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_8.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">2:37:26</p>
                  <p class="MMD3D-item-title">ZB2018新功能</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        2974
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        20
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_9.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">02:26</p>
                  <p class="MMD3D-item-title">崩坏3MMD:老娘不剁鱼了</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        7.2万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        3.1万
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_10.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">15:02</p>
                  <p class="MMD3D-item-title">【初梦谣MMD】我永远喜欢弱音 我知道的 你们不喜欢的 先舔为敬啦~</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        3.1万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        128
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_11.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">10:38</p>
                  <p class="MMD3D-item-title">哪个才是最好的3D建模软件？-- Maya vs 3dsMax vs Cinema 4D vs Houdini vs Blender</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        1267
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        3
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_12.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">01:24</p>
                  <p class="MMD3D-item-title">[MMD] CHUNG HA - Chica [搬运]</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        159
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        0
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_13.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">03:46</p>
                  <p class="MMD3D-item-title">【崩坏3rdMMD】Trouble Maker-玄衣素裳/空之律者</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        17.9万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        1249
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_14.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">03:26</p>
                  <p class="MMD3D-item-title">洛天依MMD：勾指起誓，我是圣诞老人送给你，好孩子的礼物呀.</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        5.3万
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        545
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
              <div class="MMD3D-content-item">
                <a href="#" class="MMD3D-content-item-a">
                  <div class="MMD3D-content-item-pic">
                    <img src="../../../static/images/MMD3D_item_15.jpg">
                  </div>
                  <div class="MMD3D-mask"></div>
                  <p class="MMD3D-mask-time">03:41</p>
                  <p class="MMD3D-item-title">【舰C MMD】赏月独唱会【第六驱逐队】</p>
                  <div class="MMD3D-item-playinfo-div">
                    <p class="MMD3D-item-playinfo">
                                    <span class="MMD3D-item-play">
                                        <i class="play-icon"></i>
                                        696
                                    </span>
                      <span class="MMD3D-item-danmu">
                                        <i class="danmu-icon"></i>
                                        0
                                    </span>
                    </p>
                  </div>
                </a>
              </div>
            </div>
          </div>
          <div class="col-xs-2">
            <div class="MMD3D-rank-head">
              <span class="MMD3D-rank-head-title">排行</span>
              <span class="MMD3D-rank-head-item MMD3D-rank-head-item-on MMD3D-rank-all">全部</span>
              <span class="MMD3D-rank-head-item MMD3D-rank-original">原创</span>
              <span class="MMD3D-rank-dateconstraint">
                            三日
                            <i class="MMD3D-date-icon"></i>
                        </span>
            </div>
            <div class="MMD3D-rank-contents">
              <div class="MMD3D-rank-content">
                <ul class="MMD3D-rank-content-list">
                  <li class="MMD3D-rank-content-item-main">
                    <span class="MMD3D-rank-num MMD3D-rank-top3">1</span>
                    <a>
                      <div class="MMD3D-rank-img">
                        <img src="../../../static/images/MMD3D_rank_img_1.jpg">
                      </div>
                      <div class="MMD3D-rank-item-title">
                        <p>羡慕许仙系列【自制镜头配布】江南夜 【崩坏3MMD-伏羲】</p>
                      </div>
                      <div class="MMD3D-rank-item-score">
                        <p>综合评分：8.1万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MMD3D-rank-content-item-main">
                    <span class="MMD3D-rank-num MMD3D-rank-top3">2</span>
                    <a>
                      <div class="MMD3D-rank-img">
                        <img src="../../../static/images/MMD3D_rank_img_2.jpg">
                      </div>
                      <div class="MMD3D-rank-item-title">
                        <p>影 流 之 屑</p>
                      </div>
                      <div class="MMD3D-rank-item-score">
                        <p>综合评分：6.5万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MMD3D-rank-content-item-main">
                    <span class="MMD3D-rank-num MMD3D-rank-top3">3</span>
                    <a>
                      <div class="MMD3D-rank-img">
                        <img src="../../../static/images/MMD3D_rank_img_3.jpg">
                      </div>
                      <div class="MMD3D-rank-item-title">
                        <p>时乃空的首次bilibili限定直播！</p>
                      </div>
                      <div class="MMD3D-rank-item-score">
                        <p>综合评分：5.3万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MMD3D-rank-content-item ">
                    <span class="MMD3D-rank-num" >4</span>
                    <p class="MMD3D-rank-normal-p">在空旷的教师里诱惑你 - 万由里</p>
                  </li>
                  <li class="MMD3D-rank-content-item ">
                    <span class="MMD3D-rank-num">5</span>
                    <p class="MMD3D-rank-normal-p">▌MMD▌当我开了16倍抗锯齿会是什么样的感觉？Krewella-Runaway</p>
                  </li>
                  <li class="MMD3D-rank-content-item">
                    <span class="MMD3D-rank-num">6</span>
                    <p class="MMD3D-rank-normal-p">薄丝婚纱裙~小清新渲染【有頂天ビバーチェ】</p>
                  </li>
                  <li class="MMD3D-rank-content-item">
                    <span class="MMD3D-rank-num">7</span>
                    <p class="MMD3D-rank-normal-p">【1080/60布料】自己掉的头发都长在老婆头上的渲染。【芒种 弱音舞蹈MMD】</p>
                  </li>
                  <li class="MMD3D-rank-content-item">
                    <span class="MMD3D-rank-num">8</span>
                    <p class="MMD3D-rank-normal-p">【伊莉雅】影 流 魔 法</p>
                  </li>
                  <li class="MMD3D-rank-content-item">
                    <span class="MMD3D-rank-num">9</span>
                    <p class="MMD3D-rank-normal-p">【JOJO的奇妙MMD】全 员 恶 人 × 新 宝 岛【猛 男 版】</p>
                  </li>
                  <li class="MMD3D-rank-content-item">
                    <span class="MMD3D-rank-num">10</span>
                    <p class="MMD3D-rank-normal-p">天空都没有，怎么触摸(｀・ω・´)，弱音/触摸天空【MMD】</p>
                  </li>
                  <span class="MMD3D-rank-tomore">
                                查看更多
                                <i class="MMD3D-rank-tomore-icon"></i>
                            </span>
                </ul>
              </div>
              <div class="MMD3D-rank-content">
                <ul class="MMD3D-rank-content-list">
                  <li class="MMD3D-rank-content-item-main">
                    <span class="MMD3D-rank-num MMD3D-rank-top3">1</span>
                    <a>
                      <div class="MMD3D-rank-img">
                        <img src="../../../static/images/MMD3D_rank_img_1.jpg">
                      </div>
                      <div class="MMD3D-rank-item-title">
                        <p>每天一遍，沙雕无限！</p>
                      </div>
                      <div class="MMD3D-rank-item-score">
                        <p>综合评分：27.3万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MMD3D-rank-content-item-main">
                    <span class="MMD3D-rank-num MMD3D-rank-top3">2</span>
                    <a>
                      <div class="MMD3D-rank-img">
                        <img src="../../../static/images/MMD3D_rank_img_2.jpg">
                      </div>
                      <div class="MMD3D-rank-item-title">
                        <p>她哭的那一刻，誓要与全世界为敌</p>
                      </div>
                      <div class="MMD3D-rank-item-score">
                        <p>综合评分：3.7万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MMD3D-rank-content-item-main">
                    <span class="MMD3D-rank-num MMD3D-rank-top3">3</span>
                    <a>
                      <div class="MMD3D-rank-img">
                        <img src="../../../static/images/MMD3D_rank_img_3.jpg">
                      </div>
                      <div class="MMD3D-rank-item-title">
                        <p>【加藤惠/AMV/加藤惠诞生祭】让我患上名为「你」的忧郁症！</p>
                      </div>
                      <div class="MMD3D-rank-item-score">
                        <p>综合评分：3.1万</p>
                      </div>
                    </a>
                  </li>
                  <li class="MMD3D-rank-content-item ">
                    <span class="MMD3D-rank-num" >4</span>
                    <p class="MMD3D-rank-normal-p">【快新】怪盗基德的千层套路</p>
                  </li>
                  <li class="MMD3D-rank-content-item ">
                    <span class="MMD3D-rank-num">5</span>
                    <p class="MMD3D-rank-normal-p">即使生活虐我千百遍，我依旧待生活如初恋！！</p>
                  </li>
                  <span class="MMD3D-rank-tomore">
                                查看更多
                                <i class="MMD3D-rank-tomore-icon"></i>
                            </span>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!--广告位2-->
      <div class="douga-ad-wrapper">
        <img src="../../../static/images/douga_ad_2.png">
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
// import teacher from '@/api/admin/edu/teacher'
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
