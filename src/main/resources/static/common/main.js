Date.prototype.Format = function (fmt) {
  let o = {
    "M+": this.getMonth() + 1, //月份
    "d+": this.getDate(), //日
    "h+": this.getHours(), //小时
    "m+": this.getMinutes(), //分
    "s+": this.getSeconds(), //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    "S": this.getMilliseconds() //毫秒
  };
  if (/(y+)/.test(fmt))
    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  for (var k in o) {
    if (new RegExp("(" + k + ")").test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    }
  }
  return fmt;
}

/**
 * 全局AJAX设置
 */
$.ajaxSetup({
  beforeSend: function (xhr) {
    xhr.setRequestHeader('token', sessionStorage.getItem('token'));
  }
});

$(document).ajaxError(function (event, jqxhr, settings, thrownError) {
  //跳转到登录页面
  sessionStorage.removeItem('token');
  alert('请登录');
  window.parent.location.href = location.origin;
});
/**
 *公共方法
 * @type {{}}
 */
const Main = {
  API_PATH: location.origin + "/",
  /**
   * 删除
   * @param id 被删除数据的ID
   * @param path url路径 如:"plan/yearplan"
   * @param callback 删除成功后的回调函数
   */
  delete: function (id, path, callback) {
    $.ajax({
      url: Main.API_PATH + path,
      type: 'delete',
      dataType: 'json',
      data: {id: id},
      contentType: "application/x-www-form-urlencoded",
      success: function (data) {
        callback(data);
      },
      error: function () {
      }
    });
  },
  /**
   * 更改
   * @param json var json{ id:""}
   * @param path url路径 如:"plan/yearplan"
   * @param callback 成功后的回调函数
   */
  put: function (json, path, callback) {
    $.ajax({
      url: Main.API_PATH + path,
      type: 'put',
      dataType: 'json',
      data: json,
      contentType: "application/x-www-form-urlencoded",
      success: function (data) {
        callback(data);
      },
      error: function () {
      }
    });
  },
  /**
   * 新增
   * @param json var json{ id:""}
   * @param path url路径 如:"plan/yearplan"
   * @param callback 成功后的回调函数
   */
  post: function (json, path, callback) {
    $.ajax({
      url: Main.API_PATH + path,
      type: 'POST',
      dataType: 'json',
      data: json,
      contentType: "application/x-www-form-urlencoded",
      success: function (data) {
        callback(data);
      },
      error: function () {
      }
    });
  },
  /**
   *  查询
   * @param json
   * @param path
   * @param callback
   */
  get: function (json, path, callback) {
    $.ajax({
      url: Main.API_PATH + path,
      type: 'get',
      dataType: 'json',
      data: json,
      success: function (data) {
        callback(data);
      },
      error: function () {
      }
    });
  },
  /**
   * 获取当前用户
   */
  getMe() {
    return JSON.parse(sessionStorage.getItem('user'));
  },
  /**
   * java Date 转时间字符串
   */
  dateToTimeString(date) {
    if (!date) {
      return '';
    }
    return new Date(date).Format('yyyy-MM-dd hh:mm:ss');
  }
};

/**
 * html转元素
 * @param html html
 * @returns {Node | null}
 * @constructor
 */
const C_HTML_TO_ELEMENT = (html) => {
  let template = document.createElement('template');
  html = html.trim(); // Never return a text node of whitespace as the result
  template.innerHTML = html;
  return template.content.firstChild;
};

/**
 * 窗体对话框
 */
class CDialog {
  /**
   * 创建
   * @param title 标题
   */
  constructor(title) {
    this.header = $(`<header>${title}</header>`);
    this.article = $('<article/>');
    this.footer = $('<footer/>');

    this.ui = $('<div class="ui-dialog"/>')
        .append(
            $('<div/>')
                .append(this.header)
                .append(this.article)
                .append(this.footer)
        );

    $(document.body).append(this.ui);
  }

  /**
   * 设置内容
   * @param obj JQuery元素对象
   */
  setContent(obj) {
    this.article.append(obj);

    //聚焦首个有自动焦点属性的元素
    let focusElement = obj[0].querySelector('[autofocus]');
    if (focusElement) {
      focusElement.focus();
    }
  }

  /**
   * 添加按钮
   * @param name 名称
   * @param callback 回调 () => {}
   * @param isCancel 是否为取消按钮
   */
  addAction(name, callback, isCancel) {
    let button = document.createElement('button');
    button.textContent = name;
    button.addEventListener('click', callback);
    if (isCancel) {
      button.classList.add('ui-button-cancel');
    }

    this.footer.append(button);
  }

  /**
   * 切换隐藏状态
   */
  toggleHide() {
    this.ui.toggleClass('ui-dialog-hide');
  }

  /**
   * 销毁
   */
  destroy() {
    this.ui.remove();
  }
}

/**
 * 提示工作中
 */
class CTipWorking {
  /**
   * 创建
   * @param title 可选 提示标题
   */
  constructor(title) {
    if (!title) {
      title = '正在处理,请稍等';
    }

    let ui = C_HTML_TO_ELEMENT(`
      <div class="ui-tip-working">
        <div>
          <header>${title}</header>
          <article>
            <div class="ui-tip-working-fading-circle">
              <div class="ui-tip-working-circle1 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle2 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle3 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle4 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle5 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle6 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle7 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle8 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle9 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle10 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle11 ui-tip-working-circle"></div>
              <div class="ui-tip-working-circle12 ui-tip-working-circle"></div>
            </div>
          </article>
        </div>
      </div>
    `);
    this.ui = ui;

    document.body.appendChild(ui);
  }

  destroy() {
    this.ui.remove();
  }
}