$(function () {
  $('#sign').focusin(
    function () {
      $('.head-bg-usersign').css('background', 'white')
    }
  )

  $('#sign').focusout(
    function () {
      $('.head-bg-usersign').css({
        'background': 'transparent',
        'box-shadow': 'box-shadow:0px 0px  10px 5px #aaa;'
      })
    }
  )

  $('#sign').hover(
    function () {
      let isFocus = $('#sign').is(':focus')
      if (isFocus !== true) {
        $('.head-bg-usersign').css({
          'background': 'rgba(0,0,0,0.2)'
        })
      }
    },
    function () {
      let isFocus = $('#sign').is(':focus')
      if (isFocus !== true) {
        $('.head-bg-usersign').css({
          'background': 'transparent'
        })
      }
    }
  )

  $('#announcement-input').focusin(
    function () {
      $(this).css({
        'border-color': '#00a1d6'
      })
    }
  )

  $('#announcement-input').focusout(
    function () {
      $(this).css({
        'border-color': 'white'
      })
      $('.el-input__count').css({
        'display': 'none'
      })
    }
  )

  $('#announcement-input').hover(
    function () {
      $('.el-input__count').css({
        'display': 'inline-block'
      })
      $(this).css({
        'border-color': '#00a1d6'
      })
    },
    function () {
      if (!$(this).is(':focus')) {
        $('.el-input__count').css({
          'display': 'none'
        })
        $(this).css({
          'border-color': 'white'
        })
      }
    }
  )

  $('.left-mayView-part').hover(
    function () {
      $('.info-button-group').css('display', 'inline-block')
    },
    function () {
      $('.info-button-group').css('display', 'none')
    }
  )

  function centerModals () {
    $('.modal').each(function (i) {
      var $clone = $(this).clone().css('display', 'block').appendTo('body')
      var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2)
      top = top > 0 ? top : 0
      $clone.remove()
      $(this).find('.modal-content').css('margin-top', top)
    })
  }

  $('.bs-example-modal-sm').on('show.bs.modal', centerModals) // question_modal是html中模态框的id
  $(window).on('resize', centerModals)

  $('.btn-primary').hover(
    function () {
      $(this).css({
        'background-color': '#00b5e5',
        'border-color': '#00b5e5',
        'color': '#fff'
      })
    },
    function () {
      $(this).css({
        'background-color': '#00a1d6',
        'border-color': '#00a1d6',
        'color': '#fff'
      })
    }
  )

  $('.navigator-item').hover(
    function () {
      $(this).siblings().removeClass('navigator-active')
      $(this).addClass('navigator-active')
    },
    function () {
      $(this).parent().children().eq(0).addClass('navigator-active')
      $(this).parent().children().eq(0).siblings().removeClass('navigator-active')
    }
  )
})
