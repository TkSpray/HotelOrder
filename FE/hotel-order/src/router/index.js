import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home',
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/login/login.vue'),
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('../views/home/home.vue'),
    children: [
      {
        path: '/',
        component: () => import('../views/home/index/index.vue'),
      },
      {
        path: '/book',
        component: () => import('../views/home/book/book/book.vue'),
      },
      {
        path: '/booklist',
        component: () => import('../views/home/book/booklist/booklist.vue'),
      },
      {
        path: '/checkin',
        component: () => import('../views/home/checkin/checkin.vue'),
      },
      {
        path: '/checkout',
        component: () => import('../views/home/checkout/checkout.vue'),
      },
      {
        path: '/orderlist',
        component: () => import('../views/home/orderlist/orderlist.vue'),
      },
      {
        path: '/roomlist',
        component: () => import('../views/home/roomlist/roomlist.vue'),
      },
    ],
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
