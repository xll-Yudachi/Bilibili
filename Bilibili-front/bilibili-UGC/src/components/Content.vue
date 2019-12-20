<template>
  <div>
    <el-row class="tac">
      <div class="content-body">
        <div class="content-link-top-container">
          <a class="link-top-item link-top-item-active">视频管理</a>
          <a class="link-top-item">专栏管理</a>
          <a class="link-top-item">互动视频管理</a>
          <a class="link-top-item">音频管理</a>
          <a class="link-top-item">相簿管理</a>
        </div>
        <div class="content-main">
          <div class="content-page-wrap">
            <div class="content-header">
              <el-tabs v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="全部稿件(13)" name="first" style="width: 940px">
                  <div class="all-manuscript">
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="all-manuscript-item">
                      <div class="all-manuscript-card">
                        <a class="cover-wrap">
                          <img src="../../static/images/video_item_1.jpg">
                          <div class="duration">39:33</div>
                          <div class="tag-wrap"></div>
                        </a>
                        <div class="data-wrap">
                          <div class="data-title">
                            <span class="typename">日常</span>
                            <a class="name">【助眠】霓虹小姐姐的触发词</a>
                          </div>
                          <div class="data-status">
                            <span class="pubdate">19-09-03 14:53:11</span>
                          </div>
                          <div class="data-view">
                            <a class="ok-btn">编辑</a>
                            <a class="plain-btn">数据</a>
                            <a class="option-btn"></a>
                          </div>
                          <div class="data-footer">
                            <div class="click data-item">
                              <i class="click-icon"></i>
                              <span class="icon-text">206</span>
                            </div>
                            <div class="danmu data-item">
                              <i class="danmu-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="comment data-item">
                              <i class="content-comment-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="coin data-item">
                              <i class="coin-icon"></i>
                              <span class="icon-text">4</span>
                            </div>
                            <div class="favorite data-item">
                              <i class="favorite-icon"></i>
                              <span class="icon-text">10</span>
                            </div>
                            <div class="like data-item">
                              <i class="like-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                            <div class="share data-item">
                              <i class="share-icon"></i>
                              <span class="icon-text">0</span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="block">
                    <el-pagination
                      @size-change="handleSizeChange"
                      @current-change="handleCurrentChange"
                      :current-page.sync="currentPage"
                      :page-size="100"
                      layout="prev, pager, next, jumper"
                      :total="1000">
                    </el-pagination>
                  </div>
                </el-tab-pane>
                <el-tab-pane label="进行中(0)" name="second">配置管理</el-tab-pane>
                <el-tab-pane label="已通过(12)" name="third">角色管理</el-tab-pane>
                <el-tab-pane label="未通过(1)" name="fourth">定时任务补偿</el-tab-pane>
              </el-tabs>
              <div class="content-filter-wrap">
                <form class="search-wrap">
                  <input type="text" placeholder="搜索稿件"/>
                  <i class="search-icon"></i>
                </form>

                <div class="category-wrap">
                  <a class="dropdown-btn">
                    <span class="icon-text">全部分区</span>
                    <i class="el-icon-arrow-down"></i>
                  </a>
                  <div class="dropdown dropdown-status">
                    <div class="dropdown-mask"></div>
                    <div class="dropdown-content">
                      <a class="dropdown-item dropdown-active">
                        全部分区
                      </a>
                      <a class="dropdown-item">游戏(2)</a>
                      <a class="dropdown-item">生活(1)</a>
                      <a class="dropdown-item">娱乐(1)</a>
                      <a class="dropdown-item">影视(1)</a>
                      <a class="dropdown-item dropdown-disable">音乐(0)</a>
                      <a class="dropdown-item">科技(1)</a>
                      <a class="dropdown-item dropdown-disable">数码(0)</a>
                      <a class="dropdown-item">动画(7)</a>
                      <a class="dropdown-item dropdown-disable">时尚(0)</a>
                      <a class="dropdown-item dropdown-disable">舞蹈(0)</a>
                      <a class="dropdown-item dropdown-disable">番剧(0)</a>
                      <a class="dropdown-item dropdown-disable">纪录(0)</a>
                      <a class="dropdown-item dropdown-disable">鬼畜(0)</a>
                      <a class="dropdown-item dropdown-disable">广告(0)</a>
                      <a class="dropdown-item dropdown-disable">国创(0)</a>
                      <a class="dropdown-item dropdown-disable">电视剧(0)</a>
                      <a class="dropdown-item dropdown-disable">电影(0)</a>
                    </div>
                  </div>
                </div>

                <div class="order-wrap">
                  <a class="dropdown-btn">
                    <span class="icon-text">投稿时间排序</span>
                    <i class="el-icon-arrow-down"></i>
                  </a>
                  <div class="dropdown dropdown-status">
                    <div class="dropdown-mask"></div>
                    <div class="dropdown-content">
                      <a class="dropdown-item dropdown-active">投稿时间排序</a>
                      <a class="dropdown-item">点击数排序</a>
                      <a class="dropdown-item">评论数排序</a>
                      <a class="dropdown-item">收藏数排序</a>
                      <a class="dropdown-item">弹幕数排序</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <UGCfooter class="content-footer"/>
    </el-row>
  </div>
</template>

<script>
export default {
  // 组件
  components: {},
  // 定义数据
  data () {
    return {
      activeName: 'first',
      currentPage: 1
    }
  },

  // 监听器
  watch: {
  },

  created () {

  },

  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    },
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  },

  mounted () {
    $(function () {
      $('.category-wrap .dropdown-btn').click(function () {
        $(this).next('.dropdown').toggleClass('dropdown-status')
      })

      $('.order-wrap .dropdown-btn').click(function () {
        $(this).next('.dropdown').toggleClass('dropdown-status')
      })

      $('.dropdown-mask').click(function () {
        $('.dropdown').addClass('dropdown-status')
      })

      $('.dropdown-item').hover(
        function () {
          if (!$(this).hasClass('dropdown-disable')) {
            $(this).addClass('dropdown-active')
          }
        },
        function () {
          if ($(this).index() !== 0) {
            $(this).removeClass('dropdown-active')
          }
        }
      )
    })
  }
}
</script>

<style>
  @import "../../static/css/content.css";
  @import "../../static/css/home.css";
</style>
