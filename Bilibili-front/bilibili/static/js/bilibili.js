$(function () {
  $('.dropdown-menu-myclass').hover(
    function () {
      $(this).addClass('open')
      $(this).find('aria-expanded').toggleClass('false', 'true')
      if ($(this).index() < 1 || $(this).index() > 15) {
        $(this).find('.btn').css('background-color', 'white')
      } else {
        $(this).css('background-color', 'white')
      }
      $(this).css('cursor', 'pointer')
    },
    function () {
      $(this).removeClass('open')
      $(this).find('aria-expanded').toggleClass('true', 'false')
    }
  )

  $('.recommend_card').hover(
    function () {
      $(this).find('.card_mask').css({
        'visibility': 'visible',
        'top': '-100px'
      })
      $(this).find('.recommend_p').css('visibility', 'hidden')
      $(this).find('.font').css('visibility', 'visible')
    },
    function () {
      $(this).find('.card_mask').css('visibility', 'hidden')
      $(this).find('.recommend_p').css('visibility', 'visible')
      $(this).find('.font').css('visibility', 'hidden')
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

  $('.bangumi-tab-item').hover(
    function () {
      if ($(this).css('color') === 'rgb(0, 0, 0)' && $('.bangumi-new').css('color') === 'rgb(42, 171, 210)') {
        $(this).css('color', '#00a1d6')
        $(this).siblings().css('color', 'black')
        $('.bangumi-new').css('color', '#00a1d6')
      } else {
        $(this).css('color', '#00a1d6')
        $(this).siblings().css('color', 'black')
      }
    }, function () {
      // rgb(42, 171, 210)
      $(this).css('color', 'black')
    })

  $('.bangumi-tab-item').click(function () {
    $(this).addClass('on')
    $(this).siblings().removeClass('on')
    $('.bangumi-new').css('color', 'black')
  })

  $('.bangumi-new').hover(
    function () {
      $(this).css('color', '#00a1d6')
    },
    function () {
      $(this).css('color', 'black')
    }
  )

  $('.bangumi-new').click(function () {
    $(this).addClass('on')
    $(this).siblings().removeClass('on')
  })

  $('.living-card-module').hover(
    function () {
      $(this).find('.living-card-img-div').css('display', 'none')
      $(this).find('.living-card-up-div').css('display', 'none')
      $(this).find('.living-card-mask-div').css('display', 'inline-block')
      $(this).find('.living-card-title').css('display', 'none')
      $(this).find('.living-card-category').css('display', 'none')
    },
    function () {
      $(this).find('.living-card-img-div').css('display', 'inline-block')
      $(this).find('.living-card-up-div').css('display', 'inline-block')
      $(this).find('.living-card-mask-div').css('display', 'none')
      $(this).find('.living-card-title').css('display', 'inline-block')
      $(this).find('.living-card-category').css('display', 'inline-block')
    }
  )

  $('.living-card-module').slice(5, 10).css('top', '20px')

  /*    $('.living-right-head').children().eq(0).css('margin-right','0px') */

  $('.living-right-head-a').hover(
    function () {
      $(this).css('color', '#00a1d6')
    },
    function () {
      if ($(this).hasClass('living-right-head-current')) {

      } else {
        $(this).css('color', 'black')
      }
    }
  )

  let living_right_carousel_index = 0
  let left_move = 260

  $('.living-right-head-a').click(function () {
    $(this).addClass('living-right-head-current')
    $(this).siblings().removeClass('living-right-head-current')
    $(this).siblings().css('color', 'black')
    slide($(this))
  })

  function slide (obj) {
    let current_index = obj.index()
    let ori_left = $('.living-right-carousel').children().eq(living_right_carousel_index).css('left')
    let arr = ori_left.split('p')
    let ori_left_num = parseInt(ori_left)
    if (living_right_carousel_index == 0 && current_index == 1) {
      $('.living-right-carousel').children().eq(current_index).stop().animate({'left': ori_left_num - left_move}, 'fast')
      $('.living-right-carousel').children().eq(current_index + 1).css('left', ori_left_num - left_move)
      $('.living-right-carousel').children().eq(current_index - 1).css('left', ori_left_num + 2 * left_move)
    } else if (living_right_carousel_index == 0 && current_index == 2) {
      $('.living-right-carousel').children().eq(current_index).stop().animate({'left': ori_left_num - 2 * left_move}, 'fast')
      $('.living-right-carousel').children().eq(current_index - 1).css('left', ori_left_num + left_move)
      $('.living-right-carousel').children().eq(current_index - 2).css('left', ori_left_num + left_move)
    } else if (living_right_carousel_index == 1 && current_index == 0) {
      $('.living-right-carousel').children().eq(current_index).stop().animate({'left': ori_left_num + left_move}, 'fast')
      $('.living-right-carousel').children().eq(current_index + 1).css('left', ori_left_num + left_move)
      $('.living-right-carousel').children().eq(current_index + 2).css('left', ori_left_num + left_move)
    } else if (living_right_carousel_index == 1 && current_index == 2) {
      $('.living-right-carousel').children().eq(current_index).stop().animate({'left': ori_left_num - left_move}, 'fast')
      $('.living-right-carousel').children().eq(current_index - 2).css('left', ori_left_num + 2 * left_move)
      $('.living-right-carousel').children().eq(current_index - 1).css('left', ori_left_num + 2 * left_move)
    } else if (living_right_carousel_index == 2 && current_index == 0) {
      $('.living-right-carousel').children().eq(current_index).stop().animate({'left': ori_left_num + 2 * left_move}, 'fast')
      $('.living-right-carousel').children().eq(current_index + 1).css('left', ori_left_num + 2 * left_move)
      $('.living-right-carousel').children().eq(current_index + 2).css('left', ori_left_num + 2 * left_move)
    } else if (living_right_carousel_index == 2 && current_index == 1) {
      $('.living-right-carousel').children().eq(current_index).stop().animate({'left': ori_left_num + left_move}, 'fast')
      $('.living-right-carousel').children().eq(current_index - 1).css('left', ori_left_num + 4 * left_move)
      $('.living-right-carousel').children().eq(current_index + 1).css('left', ori_left_num + left_move)
    } else {
      return
    }
    living_right_carousel_index = current_index
  }

  $('.living-rank-num').slice(3, 6).css('background-color', '#b8c0cc')

  $('.living-rank-title-div').hover(
    function () {
      $(this).find('.living-rank-name').css('color', '#00a1d6')
    },
    function () {
      $(this).find('.living-rank-name').css('color', 'black')
    }
  )

  $('.living-rank-brief').hover(
    function () {
      $(this).prev().find('.living-rank-name').css('color', '#00a1d6')
    },
    function () {
      $(this).prev().find('.living-rank-name').css('color', 'black')
    }
  )

  $('.living-focus-up-title-div').hover(
    function () {
      $(this).find('.living-focus-up-name').css('color', '#00a1d6')
    },
    function () {
      $(this).find('.living-focus-up-name').css('color', 'black')
    }
  )

  $('.living-focus-up-brief').hover(
    function () {
      $(this).prev().find('.living-focus-up-name').css('color', '#00a1d6')
    },
    function () {
      $(this).prev().find('.living-focus-up-name').css('color', 'black')
    }
  )

  $('.living-new-status').rotate({
    bind: {
      mouseover: function () {
        $(this).css('background-color', '#ccd0d7')
        $(this).find('.living-new-status-refresh').rotate({animateTo: 360, duration: 700})
      },
      mouseout: function () {
        $(this).css('background-color', 'white')
        $(this).find('.living-new-status-refresh').rotate({animateTo: 0, duration: 700})
      }
    }
  })

  $('.toMore').hover(
    function () {
      $(this).find('span').stop().animate(
        {
          'right': '3px'
        }, 'fast')
      $(this).find('i').stop().animate(
        {
          'left': '3px'
        }, 'fast')
      $(this).css({
        'background-color': '#ccd0d7',
        'font-size': '13px'
      })
    },
    function () {
      $(this).find('span').stop().animate(
        {
          'right': '0px'
        }, 'fast')
      $(this).find('i').stop().animate(
        {
          'left': '0px'
        }, 'fast')
      $(this).css({
        'background-color': 'white',
        'font-size': '12px'
      })
    }
  )

  $('.douga-title').hover(
    function () {
      $(this).css('color', '#00a1d6')
    },
    function () {
      $(this).css('color', 'black')
    }
  )

  $('.douga-head-item').hover(
    function () {
      $(this).css('color', '#00a1d6')
    },
    function () {
      if ($(this).hasClass('douga-on')) {
        return
      }
      $(this).css('color', 'black')
    }
  )

  $('.douga-head-item').click(function () {
    $(this).addClass('douga-on')
    $(this).siblings().removeClass('douga-on')
    $(this).siblings().css('color', 'black')
  })

  $('.douga-new-status-num').rotate({
    bind: {
      mouseover: function () {
        $(this).css('background-color', '#ccd0d7')
        $(this).find('.douga-refresh-icon').rotate({animateTo: 360, duration: 700})
      },
      mouseout: function () {
        $(this).css('background-color', 'white')
        $(this).find('.douga-refresh-icon').rotate({animateTo: 0, duration: 700})
      }
    }
  })
  $('.douga-more').hover(
    function () {
      $(this).find('span').stop().animate(
        {
          'right': '3px'
        }, 'fast')
      $(this).find('i').stop().animate(
        {
          'left': '3px'
        }, 'fast')
      $(this).css({
        'background-color': '#ccd0d7',
        'font-size': '13px'
      })
    },
    function () {
      $(this).find('span').stop().animate(
        {
          'right': '0px'
        }, 'fast')
      $(this).find('i').stop().animate(
        {
          'left': '0px'
        }, 'fast')
      $(this).css({
        'background-color': 'white',
        'font-size': '12px'
      })
    }
  )

  $('.douga-content-item').hover(
    function () {
      $(this).find('.douga-item-playinfo-div').stop().animate(
        {
          'top': '-100px'
        }, 'fast')
      $(this).find('.douga-mask').css('visibility', 'visible')
      $(this).find('.douga-mask-time').css('visibility', 'visible')
    },
    function () {
      $(this).find('.douga-item-playinfo-div').stop().animate(
        {
          'top': '-119px'
        }, 'fast')
      $(this).find('.douga-mask').css('visibility', 'hidden')
      $(this).find('.douga-mask-time').css('visibility', 'hidden')
    }
  )

  $('.douga-rank-head-item').hover(
    function () {
      slideRank($(this))
      $(this).addClass('douga-rank-head-item-on')
      $(this).siblings().removeClass('douga-rank-head-item-on')
    },
    function () {

    }
  )

  function slideRank (obj) {
    let tmp_0 = $('.douga-wrapper').find('.douga-rank-content')[0]
    let tmp_1 = $('.douga-wrapper').find('.douga-rank-content')[1]

    if (obj.index() === 2) {
      $(tmp_1).stop().animate({
        'left': '-280px'
      })

      $(tmp_0).stop().animate({
        'left': '-280px'
      })
    }
    if (obj.index() === 1 && !obj.hasClass('douga-rank-head-item-on')) {
      $(tmp_1).stop().animate({
        'left': '0px'
      })

      $(tmp_0).stop().animate({
        'left': '0px'
      })
    }
  }

  $('.bili-wrapper div').click(function () {
    window.location.href = 'douga.html'
  })

  // 临时测试
  $('#app img').hover(
    function () {
      $(this).css('cursor', 'pointer')
    },
    function () {

    }
  )

  var input = document.getElementById('search-keyword')
  input.addEventListener('keyup', function (event) {
    event.preventDefault()
    if (event.keyCode === 13) {
      document.getElementById('submitSearchBtn').click()
    }
  })
})
