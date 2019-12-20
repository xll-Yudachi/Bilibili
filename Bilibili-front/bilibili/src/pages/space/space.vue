<template>
  <div>
    <div style="z-index:-9999;position:absolute;height: 3020px;width: 100%; background-color: #f4f5f7"></div>
    <div style="z-index: 9999;">
      <div class="space-head">
        <div class="space-head-wrapper">
          <div>
            <div class="space-head-div">
              <div class="space-head-title">
                <i class="space-head-icon1"></i>
                <a href="#">主站</a>
                <a href="#">音频</a>
                <a href="#">游戏中心</a>
                <a href="#">直播</a>
                <a href="#">会员购</a>
                <a href="#">漫画</a>
                <a href="#">70年</a>
                <a href="#"><i class="space-head-icon2"></i>下载APP</a>
              </div>
            </div>
            <div class="space-search-div">
              <form>
                <input class="space-head-search" placeholder="新王加冕，FPX夺冠全程视频回顾">
              </form>
              <i class="space-head-search-icon"></i>
            </div>
            <div class="space-user-div">
              <div class="space-user-content">
                <img v-if="user.head_img" class="user-img" :src=user.head_img>
                <img v-else class="user-img" src="../../../static/images/noface.gif">
                <div class="space-head-user">
                  <a href="#">大会员</a>
                  <a href="#">消息</a>
                  <a href="#">动态</a>
                  <a href="#">稍后再看</a>
                  <a href="#">收藏</a>
                  <a href="#">历史</a>
                  <a href="#">创作中心</a>
                  <a href="#" class="post">投稿</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="head-bg">
        <div class="head-bg-wrapper">
          <div class="head-bg-inner">
            <div class="head-bg-mask"></div>
            <div class="head-bg-gradient">
              <div class="head-bg-user">
                <div class="head-bg-avatar">
                  <img v-if="user.head_img" :src=user.head_img>
                  <img v-else src="../../../static/images/noface.gif">
                  <span title="年度大会员" class="user-auth-subscript avatar-m no-auth"></span>
                </div>
                <div class="head-bg-basic">
                  <div class="head-bg-userinfo">
                    <span class="head-bg-username">
                      {{user.username}}
                    <span class="head-bg-usergender"></span>
                    <a href="#" target="_blank" class="level"></a>
                    <a href="#" target="_blank" class="vipType">年度大会员</a>
                    </span>
                  </div>
                  <div class="head-bg-spacing">
                    <input :placeholder="user.sign" @focusout="changeSign" id="sign" class="head-bg-usersign" type="text" />
                  </div>
                </div>
              </div>
            </div>
            <div class="head-bg-perspective">
              <el-col>
                <el-dropdown
                  trigger="click" class="perspective-dropdown">
      <span class="el-dropdown-link">
        视角：我自己<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
                  <el-dropdown-menu style="margin-left: 10px;font-size: 14px;" slot="dropdown" class="perspective-dropdown-menu myDropdownMenu">
                    <el-dropdown-item>新访客</el-dropdown-item>
                    <el-dropdown-item>我的粉丝</el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </el-col>
            </div>
          </div>
        </div>
      </div>

      <div class="space-navigator">
        <div class="space-navigator-wrapper">
          <div class="space-navigator-inner">
            <div class="space-navigator-tablinks">
              <a href="#" class="navigator-item navigator-active">
                <span class="icon-home"></span>
                <span class="navigator-text">主页</span>
              </a>
              <a href="#" class="navigator-item ">
                <span class="icon-following"></span>
                <span class="navigator-text">动态</span>
              </a>
              <a href="#" class="navigator-item ">
                <span class="icon-video"></span>
                <span class="navigator-text">投稿</span>
              </a>
              <a href="#" class="navigator-item ">
                <span class="icon-channel"></span>
                <span class="navigator-text">频道</span>
              </a>
              <a href="#" class="navigator-item ">
                <span class="icon-collect"></span>
                <span class="navigator-text">收藏</span>
              </a>
              <a href="#" class="navigator-item ">
                <span class="icon-sub"></span>
                <span class="navigator-text">订阅</span>
              </a>
              <a href="#" class="navigator-item ">
                <span class="icon-setting"></span>
                <span class="navigator-text">设置</span>
              </a>
            </div>
            <div class="space-navigator-search">
              <input id="search" type="text" placeholder="搜索视频"/>
              <span class="search-icon"></span>
            </div>
            <div class="space-navigator-statistics">
              <a href="#" class="navigator-statistics">
                <p class="navigator-data-title">关注数</p>
                <p class="navigator-data-num">111</p>
              </a>
              <a href="#" class="navigator-statistics">
                <p class="navigator-data-title">粉丝数</p>
                <p class="navigator-data-num">32</p>
              </a>
              <div class="navigator-statistics" title="截止昨天，视频、动态、专栏累计获赞86">
                <p class="navigator-data-title">获赞数</p>
                <p class="navigator-data-num">86</p>
              </div>
              <div class="navigator-statistics" title="12,603">
                <p class="navigator-data-title">播放数</p>
                <p class="navigator-data-num">1.3万</p>
              </div>
            </div>
          </div>
          <div class="space-navigator-cursor"></div>
        </div>
      </div>

      <div class="space-main">
        <div class="space-main-wrapper">
          <div class="space-main-left">
            <div class="left-mayView">
             <div class="left-tab">
               <ul>
                 <li class="tab-item is-active">我的粉丝会看到</li>
                 <li class="tab-item">新访客会看到</li>
               </ul>
               <div class="tab-cursor"></div>
             </div>
             <div class="left-mayView-part">
               <div class="left-mayView-content">
                 <a class="left-mayView-pic">
                   <img src="../../../static/images/mayView.jpg">
                 </a>
                 <div class="left-mayView-info">
                   <a href="#" class="left-mayView-info-title" title="【top 10】十大超强男主！">
                     【top 10】十大超强男主！
                   </a>
                   <div class="left-mayView-info-data">
                      <span>
                        <i class="info-play-icon"></i>
                        3329
                      </span>
                      <span>
                        <i class="info-comment-icon"></i>
                        38
                      </span>
                      <span>
                        <i class="info-date-icon"></i>
                        2018-2-2
                      </span>
                   </div>
                   <p class="left-mayView-info-desc" title="
          https://m.youtube.com/watch?v=U_-cxwKEKr4
原作者名: Anime First
原视频标题: Top 10 SUPER STRONG Male Lead Anime (Non Mainstream) NEW!!
        ">
                     https://m.youtube.com/watch?v=U_-cxwKEKr4
                     原作者名: Anime First
                     原视频标题: Top 10 SUPER STRONG Male Lead Anime (Non Mainstream) NEW!!
                   </p>
                   <div class="info-button-group" style="display: none">
                     <el-button
                       size="small"
                       type="primary">编辑置顶</el-button>
                     <el-button
                       size="small"
                     >取消置顶</el-button>
                   </div>
                 </div>
               </div>

             </div>
           </div>
            <div class="left-video">
              <h3 class="left-video-title">
                <a class="left-myvideo">我的视频</a>
                <span class="count">12</span>
                <div class="left-video-tab">
                  <ul>
                    <li>
                      <span class="video-tab-item is-active">最新发布</span>
                    </li>
                    <li>
                      <span class="video-tab-item">最多播放</span>
                    </li>
                    <li>
                      <span class="video-tab-item">最多收藏</span>
                    </li>
                  </ul>
                </div>
                <div class="video-tab-cursor"></div>
                <a class="spaceMore">
                  更多
                </a>
              </h3>
              <div class="left-video-content">
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
                <div class="left-video-item">
                  <a class="left-video-item-img">
                    <img src="../../../static/images/video_item_1.jpg">
                    <span class="left-video-item-time">39:33</span>
                  </a>
                  <a class="left-video-item-title">
                    【助眠】霓虹小姐姐的触发词
                  </a>
                  <div class="left-video-item-icon">
                    <span class="video-item-play">
                      <i class="video-item-play-icon"></i>
                      201
                    </span>
                    <span class="video-item-time">
                      <i class="video-item-time-icon"></i>
                      9-3
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="left-article">
              <h3 class="left-article-title">
                <a class="left-myarticle">我的专栏</a>
              </h3>
              <div></div>
            </div>
            <div class="left-channel">
              <h3 class="left-channel-title">
                <a class="left-mychannel">我的频道</a>
                <span v-if="channelList.length !== 0" class="create-option">
                  新建
                </span>
              </h3>
              <div v-if="channelList.length === 0" class="empty-channel">
                <p>投稿视频可以分类展示了</p>
                <div class="channel-btn-container">

                  <!-- Small modal -->
                  <button type="button" class="btn btn-primary channel-mybtn" data-toggle="modal" data-target=".bs-example-modal-sm">创建频道</button>

                  <div class="modal fade bs-example-modal-sm"  tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                    <div class="modal-dialog modal-sm" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close" @click="closeChannel"><span aria-hidden="true">&times;</span></button>
                          <h4 class="modal-title" style="text-align: left" id="myModalLabel">创建频道</h4>
                        </div>
                        <div class="modal-body" style="border-bottom: none">
                          <el-input
                            type="text"
                            placeholder="填写频道标题"
                            v-model="channelTitle"
                            maxlength="20"
                            show-word-limit
                            style="margin-top: 15px"
                          >
                          </el-input>
                          <div style="margin: 20px 0;"></div>
                          <el-input
                            type="textarea"
                            placeholder="填写频道简介（选填）"
                            v-model="channelIntro"
                            maxlength="60"
                            show-word-limit
                            id="channel-intro"
                          >
                          </el-input>
                        </div>
                        <div class="modal-footer" style="text-align: center;border-top: none">
                          <button type="button" class="btn btn-primary" data-dismiss="modal" @click="submitChannel">确定</button>
                          <button type="button" class="btn btn-default" data-dismiss="modal" @click="cancelChannel">取消</button>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
              <div v-if="channelList.length !== 0" class="left-channel-content">
                <div class="channel-item">
                  <div class="channel-title">
                    <a href="#" class="channel-name">123</a>
                    <span class="empty-hint">此频道中还没有视频哦~
                      <a href="#">立即添加</a>
                    </span>
                  </div>
                </div>
                <div class="channel-item">
                  <div class="channel-title">
                    <a href="#" class="channel-name">123</a>
                    <span class="empty-hint">此频道中还没有视频哦~
                      <a href="#">立即添加</a>
                    </span>
                  </div>
                </div>
                <div class="channel-item">
                  <div class="channel-title">
                    <a href="#" class="channel-name">123</a>
                    <span class="empty-hint">此频道中还没有视频哦~
                      <a href="#">立即添加</a>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="left-collect">
              <h3 class="left-collect-title">
                <a class="collect-title">
                  我的收藏夹
                </a>
                <span class="count">3</span>
                <a class="spaceMore">更多</a>
              </h3>
              <div class="left-collect-content">
                <div class="left-collect-item">
                  <a class="item-covers">
                    <img src="../../../static/images/space_collect_1.jpg">
                  </a>
                  <span class="collect-count">65</span>
                  <div class="collect-more-info">
                    <span class="collect-state">公开</span>
                    <a class="collect-name">默认收藏夹</a>
                  </div>
                </div>
                <div class="left-collect-item">
                  <a class="item-covers">
                    <img src="../../../static/images/space_collect_2.jpg">
                  </a>
                  <span class="collect-count">1</span>
                  <div class="collect-more-info">
                    <span class="collect-state">私有</span>
                    <a class="collect-name">美妆</a>
                  </div>
                </div>
                <div class="left-collect-item">
                  <a class="item-covers">
                    <img src="../../../static/images/space_collect_3.jpg">
                  </a>
                  <span class="collect-count">22</span>
                  <div class="collect-more-info">
                    <span class="collect-state">公开</span>
                    <a class="collect-name">诗和远方</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="left-bangumi">
              <h3 class="left-bangumi-title">
                <a class="bangumi-title">订阅番剧</a>
                <a class="spaceMore">更多</a>
              </h3>
              <div class="left-bangumi-content">
                <div class="bangumi-item">
                  <a class="bangumi-item-cover">
                    <img src="../../../static/images/space_bangumi_1.jpg">
                  </a>
                  <div class="bangumi-item-detail">
                    <a href="#" class="bangumi-item-title">
                      刀剑神域 爱丽丝篇 异界战争
                    </a>
                    <p class="bangumi-item-intro">
                      桐人、尤吉欧、爱丽丝。距离两名修剑士和一名整合骑士打败了最高祭司阿多米尼斯多雷特已过去了半年。
                      结束...
                    </p>
                  </div>
                </div>
                <div class="bangumi-item">
                  <a class="bangumi-item-cover">
                    <img src="../../../static/images/space_bangumi_2.jpg">
                  </a>
                  <div class="bangumi-item-detail">
                    <a href="#" class="bangumi-item-title">
                      <span class="end-icon"></span>
                      青春猪头少年不会梦到怀梦美少女
                    </a>
                    <p class="bangumi-item-intro">

                      居住在天空与海洋辉映的城镇“藤泽”的梓川咲太，就读高中二年级。
                      他与既是学姐又是恋人的樱岛麻衣所度过...

                    </p>
                  </div>
                </div>
                <div class="bangumi-item">
                  <a class="bangumi-item-cover">
                    <img src="../../../static/images/space_bangumi_3.jpg">
                  </a>
                  <div class="bangumi-item-detail">
                    <a href="#" class="bangumi-item-title">
                      诸神的逆鳞
                    </a>
                    <p class="bangumi-item-intro">

                      这是从人与非人尚存的世界流传下来的古老传说。
                      在与经历三千年后复活的，魔神族的精锐“十戒”的战斗中败...

                    </p>
                  </div>
                </div>
                <div class="bangumi-item">
                  <a class="bangumi-item-cover">
                    <img src="../../../static/images/space_bangumi_4.jpg">
                  </a>
                  <div class="bangumi-item-detail">
                    <a href="#" class="bangumi-item-title">
                      <span class="end-icon"></span>
                      画江湖之不良人 第三季
                    </a>
                    <p class="bangumi-item-intro">

                      《画江湖之不良人》第三季侠影归来，再现唐末乱世风云！王者弈天下 大唐生死局！
                      乾陵被毁、龙泉宝藏下落...

                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="left-sub">
              <h3 class="left-sub-title">
                <a class="sub-title">订阅标签</a>
                <span class="count">11</span>
                <a class="spaceMore">更多</a>
              </h3>
              <div class="left-sub-content">
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/tag-default-cover.png">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">PPOMO ASMR</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/tag-default-cover.png">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">翻跳</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/Originalchoreography.jpg">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">原创编舞</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/tag-default-cover.png">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">初投稿</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/attempt.jpg">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">试跳</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/Comicon.jpg">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">漫展</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/antique.jpg">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">古风</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/chinoiserie.jpg">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">中国风</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/tag-default-cover.png">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">催泪向</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/rank.jpg">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">排行榜</a>
                  </div>
                </div>
                <div class="sub-item">
                  <a class="sub-item-cover">
                    <img src="../../../static/images/tag-default-cover.png">
                  </a>
                  <div class="sub-item-detail">
                    <a class="sub-item-title">多素材</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="left-coin">
              <h3 class="left-coin-title">
                <a class="coin-title">最近投币的视频</a>
                <span class="count">1</span>
              </h3>
              <div class="left-coin-content">
                <div class="coin-item">
                  <a class="coin-item-cover">
                    <img src="../../../static/images/coin_item_1.jpg">
                    <div class="coin-item-tags-container">
                      <div class="coin-item-tag">合作</div>
                    </div>
                  </a>
                  <a class="coin-item-title" title="【为古代人物而歌】钟无艳原创曲《锈花》—阵前一令动三军，回马难得半分心（结尾戏腔！）">
                    【为古代人物而歌】钟无艳原创曲《锈花》—阵前一令动三军，回马难得半分心（结尾戏腔！）
                  </a>
                  <div class="coin-item-data">
                    <span>
                      <i class="info-play-icon"></i>
                      4.8万
                    </span>
                    <span>
                      <i class="info-comment-icon"></i>
                      332
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <div class="left-album">
              <h3 class="left-album-title">
                <a class="album-title">我的相簿</a>
                <span class="count">1</span>
                <a class="spaceMore">更多</a>
              </h3>
              <div class="left-album-content">
                <div class="album-item">
                  <a class="album-item-cover">
                    <img src="../../../static/images/album_item_1.jpg">
                  </a>
                  <a class="album-item-title">
                    我的测试相簿 我的测试相簿 我的测试相簿
                  </a>
                  <div class="album-item-data">
                    <span>
                      <i class="info-view-icon"></i>
                      127
                    </span>
                    <span>
                      <i class="info-like-icon"></i>
                      0
                    </span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="space-main-right">
            <div class="user-auth">
              <img src="../../../static/images/icon-auth.png" alt="获得 bilibili 认证，享受多重认证福利！" class="icon-auth">
              <div class="auth-title">
                <a href="#" class="goto-auth">点此申请 bilibili 认证</a>
                <span>获得 bilibili 认证，享受多重认证福利！</span>
              </div>
            </div>
            <div class="creation">
              <div class="creation-head">
                <a href="#" class="creation-title">
                  <span class="creation-icon-title"></span>
                  <span class="creation-icon-more"></span>
                </a>
              </div>
              <div class="creation-foot">
                <a href="#" class="creation-foot-upload">
                  <span class="upload-icon"></span>
                  <span class="creation-foot-text" style="position: relative;top: -5px;">视频投稿</span>
                </a>
                <a href="#" class="creation-foot-cm">
                  <span class="cm-icon"></span>
                  <span class="creation-foot-text">内容管理</span>
                </a>
              </div>
            </div>
            <div class="announcement">
              <h3 class="announcement-title">公告</h3>
              <div class="announcement-content">
                <el-input
                  type="textarea"
                  placeholder="编辑我的空间公告"
                  v-model="textarea"
                  maxlength="150"
                  show-word-limit
                  id="announcement-input"
                >
                </el-input>
              </div>
            </div>
            <div class="live">
              <h3 class="live-title">直播间</h3>
              <div class="live-content">
                <a href="#" class="live-link">
                  <span class="live-icon"></span>
                  <span class="tomylive">前往我的直播间</span>
                  <span class="live-icon-more"></span>
                </a>
              </div>
            </div>
            <div class="user">
              <div class="info">
                <div class="item-uid">
                  <span class="uid-icon"></span>
                  <span class="info-text">22531776</span>
                </div>
                <div class="item-birthday">
                  <span class="birthday-icon"></span>
                  <span class="info-text">08-17</span>
                </div>
              </div>
            </div>
            <div class="game">
              <h3 class="game-title">最近玩过的游戏</h3>
              <div class="game-content">
                <div class="game-item">
                  <a href="#" class="cover">
                    <img src="../../../static/images/game_1.png">
                  </a>
                  <div class="detail">
                    <a href="#">一梦江湖</a>
                  </div>
                </div>
                <div class="game-item">
                  <a href="#" class="cover">
                    <img src="../../../static/images/game_2.png">
                  </a>
                  <div class="detail">
                    <a href="#">战双帕弥什</a>
                  </div>
                </div>
                <div class="game-item">
                  <a href="#" class="cover">
                    <img src="../../../static/images/game_3.png">
                  </a>
                  <div class="detail">
                    <a href="#">影之诗</a>
                  </div>
                </div>
                <div class="game-item">
                  <a href="#" class="cover">
                    <img src="../../../static/images/game_4.png">
                  </a>
                  <div class="detail">
                    <a href="#">我的勇者</a>
                  </div>
                </div>
                <div class="game-item">
                  <a href="#" class="cover">
                    <img src="../../../static/images/game_5.png">
                  </a>
                  <div class="detail">
                    <a href="#">命运歌姬</a>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      user: {
        id: '',
        phone: '',
        email: '',
        create_time: '',
        head_img: '',
        username: '',
        region: '',
        sign: ''
      },
      textarea: '',
      channelList: [

      ],
      channelTitle: '',
      channelIntro: ''
    }
  },
  methods: {
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
        }
      })
    },
    changeSign (value) {
      console.log(value.target.value)
      this.$axios({
        method: 'put',
        params: {
          uid: this.user.id,
          sign: value.target.value
        },
        url: 'http://localhost:9000/user/changeSign'
      })
    },
    submitChannel () {
      this.channelTitle = ''
      this.channelIntro = ''
    },
    cancelChannel () {
      this.channelTitle = ''
      this.channelIntro = ''
    },
    closeChannel () {
      this.channelTitle = ''
      this.channelIntro = ''
    }
  },
  created () {
    this.user.id = localStorage.getItem('uid')
    this.getUserInfo()
  }
}
</script>

<style scoped>
</style>
