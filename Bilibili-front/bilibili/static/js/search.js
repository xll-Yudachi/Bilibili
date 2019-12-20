$(function () {
  $('.switcher-head-item').hover(
    function () {
      $(this).children().css('color', '#00a1d6')
      $(this).siblings().children().css('color', 'black')
      let trans = $(this).index() * 110 + 37
      $('.switcher-head-downline').css('transform', 'translateX(' + trans + 'px)')
    },
    function () {
      $('.switcher-head-downline').css('transform', 'translateX(37px)')
      $(this).children().css('color', 'black')
      $('.switcher-head').children(':first-child').children().css('color', '#00a1d6')
    }
  )

  $('.fold-up').click(function () {
    $(this).addClass('searchDisPlayNone')
    $('.fold-down').removeClass('searchDisPlayNone')
    $('.filter-duration').addClass('searchDisPlayNone')
    $('.filter-partition').addClass('searchDisPlayNone')
  })

  $('.fold-down').click(function () {
    $(this).addClass('searchDisPlayNone')
    $('.fold-up').removeClass('searchDisPlayNone')
    $('.filter-duration').removeClass('searchDisPlayNone')
    $('.filter-partition').removeClass('searchDisPlayNone')
  })

  $('.icon-aver').click(function () {
    $(this).addClass('aver-active')
    $('.icon-imgleft').removeClass('imgleft-active')
  })
  $('.icon-imgleft').click(function () {
    $(this).addClass('imgleft-active')
    $('.icon-aver').removeClass('aver-active')
  })

  var input = document.getElementById('search-keyword')
  input.addEventListener('keyup', function (event) {
    event.preventDefault()
    if (event.keyCode === 13) {
      document.getElementById('submitSearchBtn').click()
    }
  })
})
