/**
 * 主页
 */
const Home = {
  init() {
    //初始化菜单事件
    {
      let li = $('[data-menu]'), menuTitle = $('#page-title'), iframe = $('#iframe');
      li.on('click', function () {
        li.removeClass('action');
        this.classList.add('action');
        let menu = this.dataset['menu'];
        menuTitle.text(menu);
        switch (menu) {
          case '基本信息':
            iframe[0].src = 'user/base_info.html';
            break
          case '用户管理':
            iframe[0].src = 'user/list.html';
            break
          case '退出系统':
            let cTipWorking = new CTipWorking("正在退出");
            Main.get({token: sessionStorage.getItem("token")}, 'exit', () => {
              sessionStorage.removeItem('token');
              cTipWorking.destroy();
              location.href = 'index.html';
            });
            break
          default:
        }
      });
    }
  }
}