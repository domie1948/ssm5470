import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discussxuexiaogonggao from '@/views/modules/discussxuexiaogonggao/list'
    import jiazhanggoutong from '@/views/modules/jiazhanggoutong/list'
    import laoshi from '@/views/modules/laoshi/list'
    import storeup from '@/views/modules/storeup/list'
    import discusskechengxinxi from '@/views/modules/discusskechengxinxi/list'
    import kechengxinxi from '@/views/modules/kechengxinxi/list'
    import discussyuankuangjieshao from '@/views/modules/discussyuankuangjieshao/list'
    import forum from '@/views/modules/forum/list'
    import xuexiaogonggao from '@/views/modules/xuexiaogonggao/list'
    import jiazhang from '@/views/modules/jiazhang/list'
    import yuankuangjieshao from '@/views/modules/yuankuangjieshao/list'
    import goutonghuifu from '@/views/modules/goutonghuifu/list'
    import banji from '@/views/modules/banji/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/news',
        name: '教学特色',
        component: news
      }
          ,{
	path: '/discussxuexiaogonggao',
        name: '学校公告评论',
        component: discussxuexiaogonggao
      }
          ,{
	path: '/jiazhanggoutong',
        name: '家长沟通',
        component: jiazhanggoutong
      }
          ,{
	path: '/laoshi',
        name: '老师',
        component: laoshi
      }
          ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
          ,{
	path: '/discusskechengxinxi',
        name: '课程信息评论',
        component: discusskechengxinxi
      }
          ,{
	path: '/kechengxinxi',
        name: '课程信息',
        component: kechengxinxi
      }
          ,{
	path: '/discussyuankuangjieshao',
        name: '园况介绍评论',
        component: discussyuankuangjieshao
      }
          ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
          ,{
	path: '/xuexiaogonggao',
        name: '学校公告',
        component: xuexiaogonggao
      }
          ,{
	path: '/jiazhang',
        name: '家长',
        component: jiazhang
      }
          ,{
	path: '/yuankuangjieshao',
        name: '园况介绍',
        component: yuankuangjieshao
      }
          ,{
	path: '/goutonghuifu',
        name: '沟通回复',
        component: goutonghuifu
      }
          ,{
	path: '/banji',
        name: '班级',
        component: banji
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
