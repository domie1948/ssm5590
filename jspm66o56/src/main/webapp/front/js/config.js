
var projectName = '校园餐厅管理';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.jsp'
},

{
	name: '我的收藏',
	url: '../storeup/list.jsp'
}
]


var indexNav = [

{
	name: '校园美食',
	url: './pages/xiaoyuanmeishi/list.jsp'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.jsp'
}, 
{
	name: '新闻资讯',
	url: './pages/news/list.jsp'
},
]

var adminurl =  "http://localhost:8080/jspm66o56/index.jsp";

var cartFlag = false

var chatFlag = false


chatFlag = true


var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"商家","menuJump":"列表","tableName":"shangjia"}],"menu":"商家管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"菜系类别","menuJump":"列表","tableName":"caixileibie"}],"menu":"菜系类别管理"},{"child":[{"buttons":["查看","修改","删除","查看评论"],"menu":"校园美食","menuJump":"列表","tableName":"xiaoyuanmeishi"}],"menu":"校园美食管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"在线下单","menuJump":"列表","tableName":"zaixianxiadan"}],"menu":"在线下单管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"美食论坛","tableName":"forum"}],"menu":"美食论坛"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"buttons":["新增","查看","修改","删除"],"menu":"美食资讯","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"客服","tableName":"chat"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看","下单"],"menu":"校园美食列表","menuJump":"列表","tableName":"xiaoyuanmeishi"}],"menu":"校园美食模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看"],"menu":"菜系类别","menuJump":"列表","tableName":"caixileibie"}],"menu":"菜系类别管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"校园美食","menuJump":"列表","tableName":"xiaoyuanmeishi"}],"menu":"校园美食管理"},{"child":[{"buttons":["查看","审核","删除","修改"],"menu":"在线下单","menuJump":"列表","tableName":"zaixianxiadan"}],"menu":"在线下单管理"}],"frontMenu":[{"child":[{"buttons":["查看","下单"],"menu":"校园美食列表","menuJump":"列表","tableName":"xiaoyuanmeishi"}],"menu":"校园美食模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"商家","tableName":"shangjia"},{"backMenu":[{"child":[{"buttons":["查看","删除","支付"],"menu":"在线下单","menuJump":"列表","tableName":"zaixianxiadan"}],"menu":"在线下单管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看","下单"],"menu":"校园美食列表","menuJump":"列表","tableName":"xiaoyuanmeishi"}],"menu":"校园美食模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
