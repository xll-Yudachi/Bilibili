export const getHtml = (xpath) => {
  removeHightLight()

  var list = []
  var result = document.evaluate(xpath, document, null, XPathResult.ANY_TYPE, null)

  var nodes = result.iterateNext() // 枚举第一个元素
  list.push(nodes)
  // eslint-disable-next-line no-cond-assign
  while (nodes = result.iterateNext()) {
    // 对 nodes 执行操作;
    list.push(nodes)
  }

  console.log(list)
  for (let i = 0; i < list.length; i++) {
    list[i].classList.add('hightlight')
  }
}

export const readXPath = function readNode (element) {
  if (element.id !== '') { // 判断id属性，如果这个元素有id，则显 示//*[@id="xPath"]  形式内容
    // eslint-disable-next-line no-useless-escape
    return '//*[@id=\"' + element.id + '\"]'
  }
  // 这里需要需要主要字符串转译问题，可参考js 动态生成html时字符串和变量转译（注意引号的作用）
  if (element === document.body) { // 递归到body处，结束递归
    return '/html/' + element.tagName.toLowerCase()
  }
  // eslint-disable-next-line one-var
  let ix = 1, // 在nodelist中的位置，且每次点击初始化
    siblings = element.parentNode.childNodes // 同级的子元素
  for (var i = 0, l = siblings.length; i < l; i++) {
    var sibling = siblings[i]
    // 如果这个元素是siblings数组中的元素，则执行递归操作
    if (sibling === element) {
      return readNode(element.parentNode) + '/' + element.tagName.toLowerCase() + '[' + (ix) + ']'
      // 如果不符合，判断是否是element元素，并且是否是相同元素，如果是相同的就开始累加
    } else if (sibling.nodeType === 1 && sibling.tagName === element.tagName) {
      ix++
    }
  }
}

// export const readXPath = function read(element) => {
//   if (element.id !== "") {//判断id属性，如果这个元素有id，则显 示//*[@id="xPath"]  形式内容
//     return '//*[@id=\"' + element.id + '\"]';
//   }
//   //这里需要需要主要字符串转译问题，可参考js 动态生成html时字符串和变量转译（注意引号的作用）
//   if (element == document.body) {//递归到body处，结束递归
//     return '/html/' + element.tagName.toLowerCase();
//   }
//   var ix = 1,//在nodelist中的位置，且每次点击初始化
//     siblings = element.parentNode.childNodes;//同级的子元素
//   for (var i = 0, l = siblings.length; i < l; i++) {
//     var sibling = siblings[i];
//     //如果这个元素是siblings数组中的元素，则执行递归操作
//     if (sibling == element) {
//       return arguments.callee(element.parentNode) + '/' + element.tagName.toLowerCase() + '[' + (ix) + ']';
//       //如果不符合，判断是否是element元素，并且是否是相同元素，如果是相同的就开始累加
//     } else if (sibling.nodeType == 1 && sibling.tagName == element.tagName) {
//       ix++;
//     }
//   }
// };

function removeHightLight () {
  var eles = document.getElementsByClassName('hightlight')
  var tmp = []
  for (let i = 0; i < eles.length; i++) {
    tmp.push(eles[i])
  }
  for (let i = 0; i < tmp.length; i++) {
    tmp[i].classList.remove('hightlight')
  }
}
