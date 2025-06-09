
var projectName = '幼儿园管理系统';
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
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '学校公告',
	url: './pages/xuexiaogonggao/list.html'
}, 
{
	name: '园况介绍',
	url: './pages/yuankuangjieshao/list.html'
}, 
{
	name: '课程信息',
	url: './pages/kechengxinxi/list.html'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.html'
}, 
{
	name: '教学特色',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/ssmhc41t/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"老师","menuJump":"列表","tableName":"laoshi"}],"menu":"老师管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"家长","menuJump":"列表","tableName":"jiazhang"}],"menu":"家长管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"班级","menuJump":"列表","tableName":"banji"}],"menu":"班级管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"学校公告","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"园况介绍","menuJump":"列表","tableName":"yuankuangjieshao"}],"menu":"园况介绍管理"},{"child":[{"buttons":["新增","查看","修改","删除","查看评论"],"menu":"课程信息","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"家长沟通","menuJump":"列表","tableName":"jiazhanggoutong"}],"menu":"家长沟通管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"沟通回复","menuJump":"列表","tableName":"goutonghuifu"}],"menu":"沟通回复管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"论坛管理","tableName":"forum"}],"menu":"论坛管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"buttons":["新增","查看","修改","删除"],"menu":"教学特色","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告模块"},{"child":[{"buttons":["查看"],"menu":"园况介绍列表","menuJump":"列表","tableName":"yuankuangjieshao"}],"menu":"园况介绍模块"},{"child":[{"buttons":["查看"],"menu":"课程信息列表","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息模块"}],"roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["查看","审核","回复"],"menu":"家长沟通","menuJump":"列表","tableName":"jiazhanggoutong"}],"menu":"家长沟通管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"沟通回复","menuJump":"列表","tableName":"goutonghuifu"}],"menu":"沟通回复管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告模块"},{"child":[{"buttons":["查看"],"menu":"园况介绍列表","menuJump":"列表","tableName":"yuankuangjieshao"}],"menu":"园况介绍模块"},{"child":[{"buttons":["查看"],"menu":"课程信息列表","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息模块"}],"roleName":"老师","tableName":"laoshi"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"家长沟通","menuJump":"列表","tableName":"jiazhanggoutong"}],"menu":"家长沟通管理"},{"child":[{"buttons":["查看"],"menu":"沟通回复","menuJump":"列表","tableName":"goutonghuifu"}],"menu":"沟通回复管理"},{"child":[{"buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"学校公告列表","menuJump":"列表","tableName":"xuexiaogonggao"}],"menu":"学校公告模块"},{"child":[{"buttons":["查看"],"menu":"园况介绍列表","menuJump":"列表","tableName":"yuankuangjieshao"}],"menu":"园况介绍模块"},{"child":[{"buttons":["查看"],"menu":"课程信息列表","menuJump":"列表","tableName":"kechengxinxi"}],"menu":"课程信息模块"}],"roleName":"家长","tableName":"jiazhang"}]


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
