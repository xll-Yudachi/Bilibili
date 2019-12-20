<template>
  <div>
    <div class="video-head-wrapper">
      <div>
        <div class="video-head-div">
          <img src="/images/video_head_logo.png" class="head-logo-icon"/>
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
            <img class="user-img" :src="user.head_img">
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
            <span>{{video.title}}</span>
          </div>
          <div class="subtitle">
            <a href="#">{{video.partition_1}}&nbsp;</a><span>></span><a href="#">&nbsp;{{video.partition_2}}</a>
            <span class="time">{{video.upload_time}}</span>
            <span v-if="video.highest_rank != 0">最高全站日排行{{video.highest_rank}}名</span>
          </div>
          <div class="num">
            <span v-if="video.play_num >= 10000">{{(video.play_num / 10000).toFixed(1)}}万播放</span>
            <span v-else>{{video.play_num}}播放</span>
            <span>·</span>
            <span v-if="video.danmu_num >= 10000">{{(video.danmu_num / 10000).toFixed(1)}}万弹幕</span>
            <span v-else>{{video.danmu_num}}弹幕</span>
            <span class="forbid">
                    <i class="forbid-icon"></i>
                    未经作者授权，禁止转载
                </span>
          </div>
        </div>
        <div class="col-xs-offset-1 col-xs-3 video-up">
          <div class="up-face">
            <img :src=up.head_img>
          </div>
          <div class="up-info">
            <p class="name is-vip">
              {{up.username}}
              <a href="#"><i class="message-icon"></i>发消息</a>
            </p>
            <p class="brief">
              {{up.sign}}
            </p>
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
        <span v-if="video.like_num >= 10000">
          <img src="/images/thumbs.png" @click="changeLike"/>
          {{(video.like_num / 10000).toFixed(1)}}万
        </span>
        <span v-else>
          <img src="/images/thumbs.png" @click="changeLike"/>
          {{video.like_num}}
        </span>
        <span v-if="video.coin_num >= 10000">
          <img src="/images/icon.png" @click="changeCoin"/>
          {{(video.coin_num / 10000).toFixed(1)}}万
        </span>
        <span v-else>
          <img src="/images/icon.png" @click="changeCoin"/>
          {{video.coin_num}}
        </span>
        <span v-if="video.collect_num >= 10000">
          <img src="/images/collect.png" @click="changeCollect"/>
          {{(video.collect_num / 10000).toFixed(1)}}万
        </span>
        <span v-else>
          <img src="/images/collect.png" @click="changeCollect"/>
          {{video.collect_num}}
        </span>
        <span v-if="video.share_num >= 10000">
          <img src="/images/forward.png" @click="changeShare"/>
          {{(video.share_num / 10000).toFixed(1)}}万
        </span>
        <span v-else>
          <img src="/images/forward.png" @click="changeShare"/>
          {{video.share_num}}
        </span>

        <div class="complaint">
          <a href="#">稿件投诉</a>
          <a id="myPopover-complaint" tabindex="0" class="btn" role="button" data-placement="bottom"
             data-toggle="popover" data-trigger="focus" title="" data-html="true"
             data-content="<div class='complaintbtn-div'><button class='complaintbtn data-content-button' href='#'>屏蔽设定</button><br><button class='complaintbtn data-content-button' href='#'>高级弹幕</button></div>">
            <img src="/images/danmu-more.png">
          </a>
        </div>
      </div>
      <div class="video-introduction">
        <div class="video-intro">
          {{video.video_info}}
        </div>
      </div>
      <div class="more-video-introduction">
        <a href="javascript:void(0);">展示更多</a>
      </div>
      <div class="video-more-info">
        <div class="video-tags">
          <ul class="tag-area">
            <li class="video-tag" v-for="(tag,index) in this.tags" :key="tag.id" v-if="index<10">
              <a>{{tag}}</a>
            </li>
          </ul>
        </div>
        <div class="video_AD">
          <img src="/images/videoAD.jpg">
        </div>
        <div id="id" class="comment">
          <div class="b-head">
            <span class="b-head-t">{{commentList.length}}</span>
            <span class="b-head-t">评论</span>
          </div>
          <div class="comments-header">
            <div class="tabs-order">
              <ul>
                <li>按热度排序</li>
                <li>按时间排序</li>
              </ul>
            </div>
            <div class="block video-commnets-page">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page.sync="currentPage"
                :page-size="20"
                layout="total, prev, pager, next"
                :total="commentList.length">
              </el-pagination>
            </div>
          </div>
          <div class="comments-send">
            <div class="comments-send-userface">
              <img :src="user.head_img">
            </div>
            <div class="send-container">
            <textarea cols="80" name="msg" rows="5" placeholder="请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论。"
                      class="ipt-txt" v-model="commentText"></textarea>
              <button class="send-submit" @click="commentSubmit">发表评论</button>
            </div>
            <div class="comments-emoji">
              <i class="face"></i>
              <span class="text">表情</span>
            </div>
          </div>
          <div class="comments-content">
            <div v-for="(comment,index) in commentList" :key="comment.id" class="content-item-wrpa">
              <div class="comments-send-userface">
                <a>
                  <img :src="comment.userimg">
                </a>
              </div>
              <div class="ciw-content">
                <div class="user">
                  <a class="ciw-content-usernmae">{{comment.username}}</a>
                  <a class="level-link">
                    <i class="level l5"></i>
                  </a>
                </div>
                <p class="ciw-conetnt-text">
                  {{comment.text}}
                </p>
                <div class="ciw-info">
                <span class="info-plad">
                  来自
                  <a>安卓客户端</a>
                </span>
                  <span class="info-time">{{comment.date}}</span>
                  <span class="info-like">
                  <i></i>
                  <span>{{comment.thumbnum}}</span>
                </span>
                  <span class="info-hate">
                  <i></i>
                </span>
                  <span class="replay btn-hover btn-highlight" @click="reply(comment.id, index)">回复</span>
                  <div class="ciw-operation">
                    <div class="spot"></div>
                    <div class="ciw-operation-list videoDisplayNone">
                      <ul>
                        <li class="blacklist">加入黑名单</li>
                        <li class="ciw-report">举报</li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="reply-box" v-if="comment.reply.length > 0">
                  <div class="reply-item" v-for="replyItem in comment.reply" :key="replyItem.id">
                    <a class="reply-face">
                      <img :src="replyItem.userimg">
                    </a>
                    <div class="reply-content">
                      <div class="reply-user">
                        <a class="reply-user-name">{{replyItem.username}}</a>
                        <a class="level-link">
                          <i class="level l5"></i>
                        </a>
                        <span class="reply-text">
                          {{replyItem.text}}
                        <img src="../../static/images/emoji_1.jpg">
                      </span>
                      </div>
                    </div>
                    <div class="reply-info">
                      <span class="info-time">{{replyItem.date}}</span>
                      <span class="info-like">
                  <i></i>
                  <span>{{replyItem.thumbnum}}</span>
                </span>
                      <span class="info-hate">
                  <i></i>
                </span>
                      <div class="ciw-operation">
                        <div class="spot"></div>
                        <div class="ciw-operation-list videoDisplayNone">
                          <ul>
                            <li class="blacklist">加入黑名单</li>
                            <li class="report">举报</li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div id="comment-reply" class="comments-send videoDisplayNone">
                  <div class="comments-send-userface">
                    <img :src="user.head_img">
                  </div>
                  <div class="send-container">
            <textarea cols="80" name="msg" rows="5" placeholder="请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论。"
                      class="ipt-txt" v-model="commentReplyText"></textarea>
                    <button class="send-submit" @click="commentReplySubmit(index)">发表评论</button>
                  </div>
                  <div class="comments-emoji">
                    <i class="face"></i>
                    <span class="text">表情</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div style="height: 1160px"></div>
      </div>
      <div class="video-play-danmu">
        <div class="video-play-danmu-head">
          <span class="danmu-list">弹幕列表</span>
          <a id="myPopover-danmu" tabindex="0" class="btn" role="button" data-placement="bottom" data-toggle="popover"
             data-trigger="focus" title="" data-html="true"
             data-content="<button class='btbtn data-content-button' href='#'>屏蔽设定</button><br><button class='btbtn data-content-button' href='#'>高级弹幕</button>"><img
            src="/images/danmu-more.png"></a>
          <span class="oper-danmu">展开</span>
        </div>
        <div class="video-play-danmu-content">
          <div class="time">时间</div>
          <div class="danmu-content">弹幕内容({{danmuList.length}})</div>
          <div class="send-time">发送时间</div>
          <div class="danmu-content-item" v-for="danmu in danmuList.slice(0,12)" v-bind:key="danmu._id">
            <span class="danmu-content-item-time">{{formatTime(danmu.time)}}</span>
            <span class="danmu-content-item-content" title="推了!">{{danmu.text}}</span>
            <span class="danmu-content-item-send-time">{{danmu.date | formatDate}}</span>
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
                <img src="/images/danmu_ad_1.jpg" alt="...">
              </div>
              <div class="item">
                <img src="/images/danmu_ad_2.jpg" alt="...">
              </div>
              <div class="item">
                <img src="/images/danmu_ad_3.jpg" alt="...">
              </div>
            </div>
          </div>
        </div>
        <!--相关推荐-->
        <div class="danmu-reco">
          <span class="danmu-reco-title">相关推荐</span>
          <div class="danmu-reco-item" v-for="(tagsRecommend, index) in tagsRecommendList" :key="tagsRecommend.id" v-if="index < 10">
            <img @click="toVideoHtml(tagsRecommend.id)" v-if="tagsRecommend.image_url" :src="tagsRecommend.image_url">
            <img @click="toVideoHtml(tagsRecommend.id)" v-else src="../../static/images/video-placeholder.png">
            <div class="danmu-reco-info">
              <div class="danmu-reco-info-title" @click="toVideoHtml(tagsRecommend.id)">
                <a href="#" class="title">{{tagsRecommend.title}}</a>
              </div>
              <div class="danmu-reco-info-up-num">
                <a href="#" class="up">Yudachi</a>
                <div class="play-num">
                  <span v-if="tagsRecommend.play_num >= 10000">{{(tagsRecommend.play_num / 10000).toFixed(1)}}万播放</span>
                  <span v-else>{{tagsRecommend.play_num}}播放</span>
                  <span>·</span>
                  <span v-if="tagsRecommend.danmu_num >= 10000">{{(tagsRecommend.danmu_num / 10000).toFixed(1)}}万弹幕</span>
                  <span v-else>{{tagsRecommend.danmu_num}}弹幕</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>
<style>@import "../../static/css/bootstrap.min.css";</style>
<style>@import "../../static/css/DPlayer.min.css";</style>
<style>@import "../../static/css/video.css";</style>
<script>
    let Base64 = require('js-base64').Base64
    import axios from 'axios';
    export default {
        head: {
            script: [
                {src: '/js/jquery-1.12.4.min.js '},
                {src: '/js/jquery.rotate-2.2.js'},
                {src: '/js/hls.js'},
                {src: '/js/DPlayer.min.js'},
                {src: '/js/bootstrap.min.js'},
                {src: '/js/video.js'},
            ]
        },
        watch: {
            danmuList: function () {
                this.$nextTick(function () {
                    $('.danmu-content-item').hover(
                        function () {
                            $(this).find('.danmu-content-item-send-time').css('display', 'none')
                            $(this).find('.danmu-button-group').css('visibility', 'visible')
                        },
                        function () {
                            $(this).find('.danmu-content-item-send-time').css('display', 'inline-block')
                            $(this).find('.danmu-button-group').css('visibility', 'hidden')
                        }
                    )
                    $('.danmu-button').hover(
                        function () {
                            $(this).css({
                                'color': 'white',
                                'background': '#00a1d6'
                            })
                            if ($(this).index() === 2) {
                                $(this).prev().prev().css('visibility', 'visible')
                            }
                            if ($(this).index() === 3) {
                                $(this).prev().prev().css('visibility', 'visible')
                            }
                        },
                        function () {
                            $(this).css({
                                'color': '#03a0d6',
                                'background': '#fff'
                            })
                            if ($(this).index() === 2) {
                                $(this).prev().prev().css('visibility', 'hidden')
                            }
                            if ($(this).index() === 3) {
                                $(this).prev().prev().css('visibility', 'hidden')
                            }
                        }
                    )
                    $('.spot').click(function () {
                        if ($(this).next().hasClass('videoDisplayNone')){
                            $(this).next().removeClass('videoDisplayNone')
                        }else{
                            $(this).next().addClass('videoDisplayNone')
                        }
                    })
                })
            },
            tagsRecommendList: function () {
                this.$nextTick(function () {

                })
            }
        },
        data() {
            return {
                video: {},
                up: {},
                currentPage: 1,
                danmuList: [],
                tags:[],
                commentText: '',
                comment:{
                    uid:'',
                    text:'',
                    vid:'',
                    pid:''
                },
                commentList:[],
                user:{
                },
                commentReplyText:'',
                isLike: 0,
                isCoin: 0,
                isCollect: 0,
                isShare: 0,
                UserRecord:{
                    uid: '',
                    vid: '',
                    isLike: '',
                    isCoin: '',
                    isCollect: '',
                    isShare: ''
                },
                tagsRecommendList:[]
            }
        },
        methods: {
            initVideo() {
                axios({
                    method: 'get',
                    url: 'http://localhost:9003/media/findVideoById',
                    params: {
                        id: this.$route.params.id
                    }
                }).then(response => {
                    this.video = response.data.data
                    console.log(this.video);
                    this.UserRecord.vid = this.video.id
                    this.tags = this.video.tag.split("|")
                    this.initUp()
                    this.initUser()
                    this.initComment()
                    this.initTagsRecommend()
                })
            },
            initUp() {
                axios({
                    method: 'get',
                    url: 'http://localhost:9000/user/getUserInfo',
                    params: {
                        userId: this.video.upid
                    }
                }).then(response => {
                    if (response.data.success) {
                        this.up = response.data.data
                    }
                })
            },
            initUser(){
                let oriUrl = window.location.href.substring(window.location.href.lastIndexOf("=") + 1);
                let reg=new RegExp('%3D','g')//g代表全部
                let userId = Base64.decode(oriUrl.replace(reg, "="))
                axios({
                    method:'get',
                    url:'http://localhost:9000/user/getUserInfo',
                    params: {
                        userId : userId
                    }
                }).then(response=>{
                    if (response.data.success){
                        this.user = response.data.data
                        sessionStorage.setItem("uid", this.user.id)
                        this.UserRecord.uid = this.user.id
                    }
                })
            },
            initDanmu() {
                axios({
                    method: 'get',
                    url: 'http://localhost:9003/media/findDanmuByPlayer',
                    params: {
                        player: this.$route.params.id
                    }
                }).then(response => {
                    console.log(response.data.data);
                    if (response.data.success) {
                        this.danmuList = response.data.data
                    }
                })
            },
            initComment(){
                axios({
                    method:'get',
                    url:'http://localhost:9005/comment/findCommentByVid',
                    params:{
                        vid: this.$route.params.id,
                        pid: this.comment.pid
                    }
                }).then(response=>{
                    console.log(response);
                    if (response.data.success){
                        this.commentList = response.data.data;
                    }
                })
            },
            initTagsRecommend(){
                axios({
                    method: 'get',
                    url: 'http://localhost:9006/log/initTagsRecommender',
                    params:{
                        vid : this.$route.params.id
                    }
                }).then(response=>{
                    console.log(response)
                    console.log(response);
                    if (response.data.success){
                        this.tagsRecommendList = response.data.data
                    }
                })
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            },
            formatTime(_seconds) {
                _seconds = parseInt(_seconds);
                let hours, mins, seconds;
                let result = '';
                seconds = parseInt(_seconds % 60);
                mins = parseInt(_seconds % 3600 / 60)
                hours = parseInt(_seconds / 3600);

                if (hours)
                    result = `${this.PadZero(hours)}:${this.PadZero(mins)}:${this.PadZero(seconds)}`
                else
                    result = `${this.PadZero(mins)}:${this.PadZero(seconds)}`
                return result;
            },
            PadZero(str) {
                //补零
                return new RegExp(/^\d$/g).test(str) ? `0${str}` : str;
            },
            commentSubmit(){
               this.comment.uid = this.user.id
               this.comment.text = this.commentText
               this.comment.vid = this.$route.params.id
               axios({
                   method: 'get',
                   url: 'http://localhost:9005/comment/judgeWord',
                   params:{
                       word: this.comment.text
                   }
               }).then(response=>{
                   console.log(response);
                   if (response.data.success){
                       if (response.data.data){
                           this.$message.error("您输入的内容包含敏感词！请重新输入")
                       }else{
                           axios({
                               method: 'post',
                               url: 'http://localhost:9005/comment/addComment',
                               data: this.comment
                           }).then(response=>{
                               if (response.data.success){
                                   this.$message.success("评论成功")
                                   this.commentText = ''
                                   this.comment = {}
                                   this.initComment()
                               }
                           })
                       }
                   }
               })
            },
            commentReplySubmit(index){
                this.comment.uid = this.user.id
                this.comment.text = this.commentReplyText
                this.comment.vid = this.$route.params.id
                axios({
                    method: 'get',
                    url: 'http://localhost:9005/comment/judgeWord',
                    params:{
                        word: this.comment.text
                    }
                }).then(response=>{
                    console.log(response);
                    if (response.data.success){
                        if (response.data.data){
                            this.$message.error("您输入的内容包含敏感词！请重新输入")
                        }else{
                            axios({
                                method: 'post',
                                url: 'http://localhost:9005/comment/addComment',
                                data: this.comment
                            }).then(response=>{
                                if (response.data.success){
                                    this.$message.success("回复成功")
                                    $('.content-item-wrpa').eq(index).find('#comment-reply').addClass('videoDisplayNone')
                                    this.commentReplyText = ''
                                    this.comment = {}
                                    this.initComment()
                                }
                            })
                        }
                    }
                })
            },
            reply(val, index){
                $('.content-item-wrpa').eq(index).find('#comment-reply').removeClass('videoDisplayNone')
                this.comment.pid = val
            },
            changeLike(){
              this.isLike = 1
                this.UserRecord.isCoin = this.isCoin
                this.UserRecord.isCollect = this.isCollect
                this.UserRecord.isLike = this.isLike
                this.UserRecord.isShare = this.isShare
                axios({
                  method: 'post',
                  url:'http://localhost:9006/log/changeUserRecord',
                  data: this.UserRecord
                }).then(response=>{
                    if (response.data.success){
                        this.$message.success("点赞成功")
                    }
                })
            },
            changeCoin(){
                this.isCoin = 1
                this.UserRecord.isCoin = this.isCoin
                this.UserRecord.isCollect = this.isCollect
                this.UserRecord.isLike = this.isLike
                this.UserRecord.isShare = this.isShare
                axios({
                    method: 'post',
                    url:'http://localhost:9006/log/changeUserRecord',
                    data: this.UserRecord
                }).then(response=>{
                    if (response.data.success){
                        this.$message.success("投币成功")
                    }
                })
            },
            changeCollect(){
                this.isCollect = 1
                this.UserRecord.isCoin = this.isCoin
                this.UserRecord.isCollect = this.isCollect
                this.UserRecord.isLike = this.isLike
                this.UserRecord.isShare = this.isShare
                axios({
                    method: 'post',
                    url:'http://localhost:9006/log/changeUserRecord',
                    data: this.UserRecord
                }).then(response=>{
                    if (response.data.success){
                        this.$message.success("收藏成功")
                    }
                })
            },
            changeShare(){
                this.isShare = 1
                this.UserRecord.isCoin = this.isCoin
                this.UserRecord.isCollect = this.isCollect
                this.UserRecord.isLike = this.isLike
                this.UserRecord.isShare = this.isShare
                axios({
                    method: 'post',
                    url:'http://localhost:9006/log/changeUserRecord',
                    data: this.UserRecord
                }).then(response=>{
                    if (response.data.success){
                        this.$message.success("分享成功")
                    }
                })
            },
            toVideoHtml(val){
                window.location.href="http://localhost:3000/video/" + val + '?spm=' + Base64.encode(sessionStorage.getItem('uid').toString())
            }
        },
        filters:{
            formatDate(value) {// 时间戳转换日期格式方法
                if (value == null) {
                    return '';
                } else {
                    let date = new Date(value);
                    let y = date.getFullYear();// 年
                    let MM = date.getMonth() + 1;// 月
                    MM = MM < 10 ? ('0' + MM) : MM;
                    let d = date.getDate();// 日
                    d = d < 10 ? ('0' + d) : d;
                    let h = date.getHours();// 时
                    h = h < 10 ? ('0' + h) : h;
                    let m = date.getMinutes();// 分
                    m = m < 10 ? ('0' + m) : m;
                    let s = date.getSeconds();// 秒
                    s = s < 10 ? ('0' + s) : s;
                    return MM + '-' + d + ' ' + h + ':' + m;
                }
            }
        },
        mounted() {
            this.initVideo()
            this.initDanmu()
            const dp = new DPlayer({
                container: document.getElementById('dplayer'),
                autoplay: false,
                theme: '#FADFA3',
                loop: false,
                lang: 'zh-cn',
                screenshot: true,
                hotkey: true,
                preload: 'auto',
                volume: 0.2,
                mutex: true,
                video: {
                    url: '/source/hls/' + this.$route.params.id + "/" + this.$route.params.id + ".m3u8",
                    type: 'hls',
                },
                danmaku: {
                    id: this.$route.params.id,                                        // 必需，弹幕 id，注意：它必须是唯一的，不能在你的新播放器中使用这些： `https://api.prprpr.me/dplayer/list`
                    api: 'http://139.159.134.136:1207/',                             // 必需，弹幕 api
                    maximum: 10000,                                                 // 可选，最大数量的弹幕
                    user: sessionStorage.getItem("uid") + "",
                }
            });
        }
    }
</script>

