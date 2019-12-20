$(function () {
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
      url: './static/source/hls/bilibili.m3u8',
      type: 'hls'
    },
    danmaku: {
      id: '9E2E3368B56CDBB4', // 必需，弹幕 id，注意：它必须是唯一的，不能在你的新播放器中使用这些： `https://api.prprpr.me/dplayer/list`
      api: 'http://139.159.134.136:1207/', // 必需，弹幕 api
      maximum: 10000, // 可选，最大数量的弹幕
      author: 'yudachi'
    },
    highlight: [
      {
        time: 27,
        text: '开始'
      },
      {
        time: 115,
        text: '第二段'
      },
      {
        time: 186,
        text: '就算时过境迁，我仍然深爱你'
      }
    ]
  })

  $("[data-toggle='popover']").popover()

  $('#myPopover-danmu').on('shown.bs.popover', function () {
    $('.btbtn').hover(
      function () {
        $(this).css('color', '#00a1d6')
      },
      function () {
        $(this).css('color', 'black')
      }
    )
  })

  $('.danmu-ad button').click(function () {
    $(this).parent().fadeOut()
  })

  $('.oper-danmu').click(function () {
    if ($(this).html() === '展开') {
      $(this).html('收起')
      $('.video-play-danmu-content').stop().animate(
        {
          'height': '455px'
        }
        , function () {
          $('.danmu-content-item-content').css({
            'position': 'absolute',
            'margin-left': '18px'
          })
        })
    } else {
      $(this).html('展开')
      $('.danmu-content-item-content').css({
        'position': 'static',
        'margin-left': '15px'
      })
      $('.video-play-danmu-content').stop().animate(
        {
          'height': '0px'
        }
      )
    }
  })

  $(function () {
    $('[data-toggle="tooltip"]').tooltip()
  })

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

  $('#myPopover-complaint').popover({trigger: 'hover'})
    .on('mouseenter', function () {
      let _this = this // 这里的this触发的dom,需要存起来 否则在下面 .popover的逻辑中this会变为弹出的dom
      $(this).popover('show')
      $('.popover').on('mouseenter', function () {
        $('.complaintbtn').on('mouseenter', function () {
          $(this).css('color', '#00a1d6')
        }).on('mouseleave', function () {
          $(this).css('color', 'black')
        })
      })

      $('.popover').on('mouseleave', function () {
        $(_this).popover('hide')
      })
    })
    .on('mouseleave', function () {
      let _this = this
      if (!$('.popover:hover').length) {
        $(_this).popover('hide')
      }
    })

  $('.complaint a,.more-video-introduction a').hover(
    function () {
      $(this).css('color', '#00a1d6')
    },
    function () {
      $(this).css('color', 'black')
    }
  )

  let ori_height = 0
  let new_height = 0
  $('.more-video-introduction a').click(function () {
    if ($(this).html() == '展示更多') {
      ori_height = $('.video-introduction').css('height')
      $('.video-introduction').css({
        'overflow': 'visible',
        'height': 'auto'
      })
      new_height = $('.video-introduction').css('height')
      $(this).css('top', pxOper(0, new_height, ori_height))
      $(this).html('收起')
      $(this).parent().next().css('top', parseInt($(this).parent().next().css('top')) + 640 + 'px')
    } else {
      $('.video-introduction').css({
        'height': '75px',
        'overflow': 'hidden'
      })
      $(this).css('top', 0)
      $(this).html('展示更多')
      $(this).parent().next().css('top', parseInt($(this).parent().next().css('top')) - 640 + 'px')
    }
  })

  function pxOper (ori_top, new_height, ori_height) {
    return (
      ori_top +
            parseInt(new_height.slice(0, new_height.length - 2)) -
            parseInt(ori_height.slice(0, ori_height.length - 2))
    )
  }

  console.log($('#id').children())
  console.log(document.getElementById('id').childNodes)
  console.log(document.getElementById('id').children)
})
