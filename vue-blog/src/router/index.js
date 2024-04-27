import ArticleAdd from '@/components/ArticleAdd.vue'
import ArticleList from '@/components/ArticleList.vue'
import LoginView from '@/views/LoginView.vue'
import MainView from '@/views/MainView.vue'
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [

    {//登入界面
      path: '/',
      name: 'login',
      component: LoginView
    },
    {//主页面
      path: '/main',
      name: 'main',
      component: MainView,
      redirect: '/article/articleList',
      //子路由
      children: [
        {
          path: '/article/articleList',
          name: 'articleList',
          component: ArticleList
        },
        {
          path: '/article/articleAdd',
          name: 'articleAdd',
          component: ArticleAdd
        }
      ]
    },
  ]
})

export default router
