# Bilibili
### 语言: Java、Scala
### 数据库： Mysql、MongoDB

### 前端页面
由vue实现多页面搭建
创作中心由vue-cli搭建 图表等运用Echarts
视频详情页运用vue-nuxt 服务端渲染 利于SEO优化

### 后端
由SpringBoot + Spring + SpringJpa 完成三层架构

### 视频上传部分
采用Rabbitmq消息队列实现对视频的HLS处理  形成m3u8文件

### 视频部分
采用Dplayer 完成视频弹幕互动

### 评论部分
采用基于朴素贝叶斯算法的敏感词判断 进行输入限制

### 数据部分
用户行为随机生成
视频数据采用Webmagic实现爬虫爬取

### 视频智能推荐部分
#### 离线推荐
基于用户行为的统计 采用了基于隐语义的协同过滤算法（LFM） 用最小交替二乘法（ALS）进行偏差值估计调优\
基于内容的离线推荐 采用词频-逆文档算法（TF-IDF） 对标签进行计算相似度矩阵
#### 实时推荐
采用KafkaStream和SparkStream以及Flume完成对日志的采集、过滤、处理